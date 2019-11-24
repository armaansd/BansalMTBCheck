import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import com.mxrck.autocompleter.TextAutoCompleter;

import net.proteanit.sql.DbUtils;

import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.SystemColor;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class admitservice extends JDialog {

	private final JPanel contentPanel = new JPanel();
	int col;
	DefaultTableModel model = 	new DefaultTableModel();
	static String s,date;
	int id,k;
	String sid;
	String col_name;
	String entryy;
	private JTable service;
	private JTextField service_name;
	private JTextField qty;
	private JTextField rate;
	private JTextField amount;
	TextAutoCompleter ac,ac1,ac2,ac3;
	JLabel lbl;
	Connection conn;
	String sr;
	DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd-MM-yyyy");
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		s = args[0];
		
		try {
			admitservice dialog = new admitservice();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}

	/**
	 * Create the dialog.
	 */
	public admitservice() {
		
		conn = SqliteConnection.dbconnector();
		setBounds(100, 100, 866, 483);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			{
				model = new DefaultTableModel();
			}
		}
		{
			lbl = new JLabel("");
			lbl.setText(s);
			lbl.setForeground(new Color(32, 178, 170));
			lbl.setFont(new Font("Tahoma", Font.BOLD, 18));
			lbl.setBounds(10, 11, 381, 43);
			contentPanel.add(lbl);
			{
				JScrollPane scrollPane = new JScrollPane();
				scrollPane.setBounds(10, 165, 830, 257);
				contentPanel.add(scrollPane);
				{
					service = new JTable();
					service.addMouseListener(new MouseAdapter() {
						@Override
						public void mouseClicked(MouseEvent e) {
							
							
							int i = service.getSelectedRow();
							
				   			sr = service.getValueAt(i, 0).toString();
				   			date = service.getValueAt(i, 1).toString();
				   			service_name.setText(service.getValueAt(i, 2).toString());
				   			rate.setText(service.getValueAt(i, 3).toString());
				   			qty.setText(service.getValueAt(i, 4).toString());
				   			amount.setText(service.getValueAt(i, 5).toString());
						}
					});
					
					scrollPane.setViewportView(service);
				}
			}
			{
				JButton btnAddNewRecord = new JButton("Add New Record");
				btnAddNewRecord.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						
						
						
												
										
										
						
						
					}
				});
				btnAddNewRecord.setFont(new Font("Tahoma", Font.BOLD, 18));
				btnAddNewRecord.setBounds(651, 236, 189, 23);
				contentPanel.add(btnAddNewRecord);
			}
			
			JLabel label = new JLabel("Service Name");
			label.setFont(new Font("Sitka Text", Font.BOLD, 13));
			label.setBounds(11, 89, 137, 33);
			contentPanel.add(label);
			
			service_name = new JTextField();
			service_name.addKeyListener(new KeyAdapter() {
				@Override
				public void keyPressed(KeyEvent e) {
					
					
					if(e.getKeyCode()==KeyEvent.VK_ENTER)
					{
						
						try { 
							Connection conn =DriverManager.getConnection("jdbc:ucanaccess://bansal.accdb");
							Statement statement = conn.createStatement();
				            String query = "SELECT rate FROM ipdservice where serivce = '"+service_name.getText().toString()+"' ";
				            ResultSet rs = statement.executeQuery(query);

				            while (rs.next())
				            {      
				               
				            	
				            	String s = rs.getString("rate");
				            	
				            	rate.setText(s);
				            	
				            	
				            
				                
				            }//end while
				            conn.close();
				            } catch (Exception e1) {
				                 e1.printStackTrace();
				            }
						
					}
				}
			});
			ac = new TextAutoCompleter(service_name);
			service_name.setColumns(10);
			service_name.setBounds(10, 116, 210, 38);
			contentPanel.add(service_name);
			
			JLabel label_1 = new JLabel("Qty.");
			label_1.setFont(new Font("Sitka Text", Font.BOLD, 13));
			label_1.setBounds(348, 86, 46, 33);
			contentPanel.add(label_1);
			
			
			rate = new JTextField();
			
			rate.setColumns(10);
			rate.setBounds(229, 115, 106, 38);
			contentPanel.add(rate);
			
			qty = new JTextField();
			qty.addKeyListener(new KeyAdapter() {
				@Override
				public void keyPressed(KeyEvent e) {
					
					
					if(e.getKeyCode()==KeyEvent.VK_ENTER)
					{
						double rrr = Double.parseDouble(rate.getText().toString());
						double qqtt = Double.parseDouble(qty.getText().toString());
						
						double amtt = rrr*qqtt;
						amount.setText(String.valueOf(amtt));
						
					}	
				}
			});
			qty.setColumns(10);
			qty.setBounds(347, 113, 61, 38);
			contentPanel.add(qty);
			
			JLabel label_2 = new JLabel("Rate");
			label_2.setFont(new Font("Sitka Text", Font.BOLD, 13));
			label_2.setBounds(229, 88, 46, 33);
			contentPanel.add(label_2);
			
			
			
			JLabel label_3 = new JLabel("Amount");
			label_3.setFont(new Font("Sitka Text", Font.BOLD, 13));
			label_3.setBounds(420, 89, 81, 33);
			contentPanel.add(label_3);
			
			amount = new JTextField();
			amount.addKeyListener(new KeyAdapter() {
				@Override
				public void keyPressed(KeyEvent e) {
					if(e.getKeyCode()==KeyEvent.VK_ENTER)
					{
						
						
						String date;
			   			LocalDateTime now = LocalDateTime.now();
			   			date = dtf.format(now);
			   			
						
						try{
							conn =DriverManager.getConnection("jdbc:ucanaccess://bansal.accdb"); 
							String query="Select Sno from "+s+" ";
							PreparedStatement pst=conn.prepareStatement(query);
							ResultSet rs=pst.executeQuery();
							while(rs.next())
							{
								id=rs.getInt("Sno");
							}
							sid=String.valueOf((id+1));
							rs.close();
							pst.close();
						}
						catch(Exception ee)
						{
							ee.printStackTrace();
						}
						
						
						try {
							conn =DriverManager.getConnection("jdbc:ucanaccess://bansal.accdb"); 
							String query = "Insert into  "+s+" (Sno,Service,qty,rate,Amount,Date) values(?,?,?,?,?,?) ";
							PreparedStatement pst = conn.prepareStatement(query);
							pst.setString(1, sid);
							pst.setString(2, service_name.getText());
							pst.setString(3, qty.getText());
							pst.setString(4, rate.getText());
							pst.setString(5, amount.getText());
							pst.setString(6, date);
							
							pst.execute();
							pst.close();
							
							
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						
						
						
						
						try
						{
																				
							conn =DriverManager.getConnection("jdbc:ucanaccess://bansal.accdb");
							String query= "select *  from   "+s+" ";
							PreparedStatement statement= conn.prepareStatement(query);
							ResultSet rs=statement.executeQuery();
							service.setModel(DbUtils.resultSetToTableModel(rs));
							rs.close();
							statement.close();
							
						}

						catch(SQLException e1)
						{
								e1.printStackTrace();
						
						}
						

						
						
					}
					
					
					
					
				}
			});
			amount.setColumns(10);
			amount.setBounds(419, 116, 128, 38);
			contentPanel.add(amount);
			
			JButton btnNewButton = new JButton("Add New Service");
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					
					JTextField service= new JTextField();
					JTextField rate= new JTextField();
					service.requestFocusInWindow();
					  JComponent[] inputs = new JComponent[] {
					        new JLabel("Service"),
					        	service,
					        	
					        new JLabel("Rates"),
					        rate,
					        
					      
					};
					int result = JOptionPane.showConfirmDialog(null, inputs, "Enter New Service here", JOptionPane.PLAIN_MESSAGE);
					if (result == JOptionPane.OK_OPTION) {
						
						
						try{
							conn =DriverManager.getConnection("jdbc:ucanaccess://bansal.accdb");  
							String query1="Insert into ipdservice  (serivce,rate) values(?,?)";
							PreparedStatement pst = conn.prepareStatement(query1);
							pst.setString(1, service.getText());
							pst.setString(2, rate.getText());
							
							pst.execute();
							pst.close();
							JOptionPane.showMessageDialog(null, "A New Service Added Succesfully !");
							
							
							}
						catch(Exception e1)
						{
							JOptionPane.showMessageDialog(null, e1);
						}
					}
				}
			});
			btnNewButton.setBounds(10, 65, 128, 23);
			contentPanel.add(btnNewButton);
			
			JButton btnNewButton_1 = new JButton("Delete");
			btnNewButton_1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					
					
					
					try{
						
						Connection conn =DriverManager.getConnection("jdbc:ucanaccess://bansal.accdb"); 
						String query = "DELETE FROM "+s+"  WHERE Sno = '"+sr+"' ";
						PreparedStatement pst=conn.prepareStatement(query);
			  			pst.executeUpdate();
			  				
			  			}
			  			catch(Exception e1)
			  			{
			  				JOptionPane.showMessageDialog(null,e1);
			  			}
					
					
					try
					{
																			
						conn =DriverManager.getConnection("jdbc:ucanaccess://bansal.accdb");
						String query= "select *  from   "+s+" ";
						PreparedStatement statement= conn.prepareStatement(query);
						ResultSet rs=statement.executeQuery();
						service.setModel(DbUtils.resultSetToTableModel(rs));
						rs.close();
						statement.close();
						
					}

					catch(SQLException e1)
					{
							e1.printStackTrace();
					
					}
					
						
				}
			});
			btnNewButton_1.setBounds(690, 116, 114, 33);
			contentPanel.add(btnNewButton_1);
			
			JButton btnUpdate = new JButton("Update");
			btnUpdate.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					
					
					try {
						Connection conn =DriverManager.getConnection("jdbc:ucanaccess://bansal.accdb"); 
						String query = "update "+s+" set Date=?,Service=?,qty=?,rate=?,Amount=? where Sno = '"+sr+"' ";
						PreparedStatement pst = conn.prepareStatement(query);
					
						pst.setString(1, date);
						pst.setString(2, service_name.getText());
						pst.setString(3, qty.getText());
						pst.setString(4, rate.getText());
						pst.setString(5, amount.getText());
					
						pst.executeUpdate();
						pst.close();
						
						
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
					try
					{
																			
						conn =DriverManager.getConnection("jdbc:ucanaccess://bansal.accdb");
						String query= "select *  from   "+s+" order by Sno ";
						PreparedStatement statement= conn.prepareStatement(query);
						ResultSet rs=statement.executeQuery();
						service.setModel(DbUtils.resultSetToTableModel(rs));
						rs.close();
						statement.close();
						
					}

					catch(SQLException e1)
					{
							e1.printStackTrace();
					
					}
					
				}
			});
			btnUpdate.setBounds(566, 116, 114, 33);
			contentPanel.add(btnUpdate);
			data1();
			service();
		}
	}
	public void data1()
	{



		
		try
		{
																
			conn =DriverManager.getConnection("jdbc:ucanaccess://bansal.accdb");
			String query= "select *  from   "+lbl.getText().toString()+" ";
			PreparedStatement statement= conn.prepareStatement(query);
			ResultSet rs=statement.executeQuery();
			service.setModel(DbUtils.resultSetToTableModel(rs));
			rs.close();
			statement.close();
			
		}

		catch(SQLException e1)
		{
				e1.printStackTrace();
		
		}
		
		catch(Exception eee){
			
			eee.printStackTrace();
		
		}
		
		
		try{
			conn =DriverManager.getConnection("jdbc:ucanaccess://bansal.accdb"); 
			String query="Select Sno from "+s+" ";
			PreparedStatement pst=conn.prepareStatement(query);
			ResultSet rs=pst.executeQuery();
			while(rs.next())
			{
				id=rs.getInt("Sno");
			}
			sid=String.valueOf((id+1));
			rs.close();
			pst.close();
		}
		catch(Exception ee)
		{
			ee.printStackTrace();
		}
		
	}
	
	public void service()
	{
		
		ac.removeAllItems();
			
		try { 
			conn =DriverManager.getConnection("jdbc:ucanaccess://bansal.accdb");
			Statement statement = conn.createStatement();
            String query = "SELECT DISTINCT serivce FROM ipdservice ";
            ResultSet rs = statement.executeQuery(query);

            while (rs.next())
            {      
               
            	
            	String s = rs.getString("serivce");
            	
            	ac.addItem(s);
            	
            
                
            }//end while
            conn.close();
            } catch (Exception e1) {
                 e1.printStackTrace();
            }
		
	}
}
