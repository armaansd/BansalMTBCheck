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

public class medicine extends JDialog {

	private final JPanel contentPanel = new JPanel();
	int col;
	DefaultTableModel model = 	new DefaultTableModel();
	static String s;
	int id,k;
	String sr,date;
	String sid;
	String col_name;
	String entryy;
	private JTable service;
	private JTextField service_name;
	private JTextField qty;
	private JTextField rate;
	private JTextField amount;
	TextAutoCompleter ac,ac1,ac2,ac3;
	DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd-MM-yyyy");
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		s = args[0];
		
		try {
			medicine dialog = new medicine();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}

	/**
	 * Create the dialog.
	 */
	public medicine() {
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
			JLabel lblNewLabel = new JLabel("");
			lblNewLabel.setText(s);
			lblNewLabel.setForeground(new Color(32, 178, 170));
			lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
			lblNewLabel.setBounds(10, 11, 381, 43);
			contentPanel.add(lblNewLabel);
			{
				JScrollPane scrollPane = new JScrollPane();
				scrollPane.setBounds(10, 159, 830, 263);
				contentPanel.add(scrollPane);
				{
					service = new JTable();
					service.addMouseListener(new MouseAdapter() {
						@Override
						public void mouseClicked(MouseEvent arg0) {
							
							
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
			
			JLabel lblDrugs = new JLabel("Drugs");
			lblDrugs.setFont(new Font("Sitka Text", Font.BOLD, 13));
			lblDrugs.setBounds(11, 89, 137, 33);
			contentPanel.add(lblDrugs);
			
			service_name = new JTextField();
			
			ac = new TextAutoCompleter(service_name);
			service_name.setColumns(10);
			service_name.setBounds(10, 116, 210, 38);
			contentPanel.add(service_name);
			
			JLabel lblFrequency = new JLabel("Frequency");
			lblFrequency.setFont(new Font("Sitka Text", Font.BOLD, 13));
			lblFrequency.setBounds(348, 86, 81, 33);
			contentPanel.add(lblFrequency);
			
			
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
			
			JLabel lblDose = new JLabel("Dose");
			lblDose.setFont(new Font("Sitka Text", Font.BOLD, 13));
			lblDose.setBounds(229, 88, 46, 33);
			contentPanel.add(lblDose);
			
			
			
			JLabel lblDays = new JLabel("Days");
			lblDays.setFont(new Font("Sitka Text", Font.BOLD, 13));
			lblDays.setBounds(436, 89, 81, 33);
			contentPanel.add(lblDays);
			
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
							Connection conn =DriverManager.getConnection("jdbc:ucanaccess://bansal.accdb"); 
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
							Connection conn =DriverManager.getConnection("jdbc:ucanaccess://bansal.accdb"); 
							String query = "Insert into  "+s+" (Sno,Drugs,Dose,Frequency,Days,Date) values(?,?,?,?,?,?) ";
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
																				
							Connection conn =DriverManager.getConnection("jdbc:ucanaccess://bansal.accdb");
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
			amount.setBounds(435, 116, 128, 38);
			contentPanel.add(amount);
			
			JButton btnNewButton = new JButton("Add New medicine");
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
							Connection conn =DriverManager.getConnection("jdbc:ucanaccess://bansal.accdb");  
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
			btnNewButton.setBounds(10, 55, 128, 33);
			contentPanel.add(btnNewButton);
			
			JButton btnNewButton_1 = new JButton("Update");
			btnNewButton_1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					
					
					try {
						Connection conn =DriverManager.getConnection("jdbc:ucanaccess://bansal.accdb"); 
						String query = "update "+s+" set Date=?,Drugs=?,Dose=?,Frequency=?,Days=? where Sno = '"+sr+"' ";
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
																			
						Connection conn =DriverManager.getConnection("jdbc:ucanaccess://bansal.accdb");
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
			btnNewButton_1.setBounds(580, 116, 106, 33);
			contentPanel.add(btnNewButton_1);
			
			JButton btnDelete = new JButton("Delete");
			btnDelete.addActionListener(new ActionListener() {
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
																			
						Connection conn =DriverManager.getConnection("jdbc:ucanaccess://bansal.accdb");
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
			btnDelete.setBounds(707, 116, 106, 33);
			contentPanel.add(btnDelete);
			data1();
			service();
		}
	}
	public void data1()
	{
		
		
			
		try
		{
																
			Connection conn =DriverManager.getConnection("jdbc:ucanaccess://bansal.accdb");
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
		
		catch(Exception eee){
			
			eee.printStackTrace();
		
		}
		
		
		try{
			Connection conn =DriverManager.getConnection("jdbc:ucanaccess://bansal.accdb"); 
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
			Connection conn =DriverManager.getConnection("jdbc:ucanaccess://bansal.accdb");
			Statement statement = conn.createStatement();
            String query = "SELECT DISTINCT Drugs FROM medicine ";
            ResultSet rs = statement.executeQuery(query);

            while (rs.next())
            {      
               
            	
            	String s = rs.getString("Drugs");
            	
            	ac.addItem(s);
            	
            
                
            }//end while
            conn.close();
            } catch (Exception e1) {
                 e1.printStackTrace();
            }
		
	}
}
