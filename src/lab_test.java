import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.AbstractAction;
import javax.swing.InputMap;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JRootPane;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import net.proteanit.sql.DbUtils;

import javax.swing.JTable;
import javax.swing.KeyStroke;
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
import javax.swing.JTextArea;

public class lab_test extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTable lab_test;
	int col;
	DefaultTableModel model = 	new DefaultTableModel();
	static String s,s1;
	int id,k;
	String sid;
	String col_name;
	String entryy;
	private JTable table;
	JTextArea record;
	DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd-MM-yyyy");
	Connection conn1 = null;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		
		s = args[0];
		s1 = args[1];
		try {
			lab_test dialog = new lab_test();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	
	
	protected JRootPane createRootPane() { 
	    JRootPane rootPane = new JRootPane();
	    KeyStroke stroke = KeyStroke.getKeyStroke("ESCAPE");
	    AbstractAction actionListener = new AbstractAction() { 
	      public void actionPerformed(ActionEvent actionEvent) { 
	       
	    	  
	    		
	    	  String s[] = {"ss"};
	    	  AdmitPatient.main(s);
	    	  setVisible(false);
	        
	        

	      } 
	    } ;
	    InputMap inputMap = rootPane.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
	    inputMap.put(stroke, "ESCAPE");
	    rootPane.getActionMap().put("ESCAPE", actionListener);

	    return rootPane;
	  } 
	public lab_test() {
		setBounds(100, 100, 865, 551);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JScrollPane scrollPane = new JScrollPane();
			scrollPane.setBounds(10, 60, 830, 155);
			contentPanel.add(scrollPane);
			{
				lab_test = new JTable();
				model = new DefaultTableModel();
				lab_test.setModel(model);
				scrollPane.setViewportView(lab_test);
			}
		}
		{
			JLabel lblNewLabel = new JLabel("");
			lblNewLabel.setText(s);
			lblNewLabel.setForeground(new Color(32, 178, 170));
			lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
			lblNewLabel.setBounds(10, 11, 270, 38);
			contentPanel.add(lblNewLabel);
			{
				JScrollPane scrollPane = new JScrollPane();
				scrollPane.setBounds(10, 267, 830, 155);
				contentPanel.add(scrollPane);
				{
					table = new JTable();
					scrollPane.setViewportView(table);
				}
			}
			{
				JButton btnAddNewRecord = new JButton("Add New Record");
				btnAddNewRecord.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						
						
						
						lab_test.selectAll();
						
						String date;
			   			LocalDateTime now = LocalDateTime.now();
			   			date = dtf.format(now);
			   			
			   			
						
						try{
								
								conn1 =DriverManager.getConnection("jdbc:ucanaccess://bsshlab.accdb"); 
								String query1="Insert into  "+s+"  (Sno,Date) values(?,?)";
								PreparedStatement pst=conn1.prepareStatement(query1);	
							
								pst.setString(1,  lab_test.getValueAt(0, 0).toString());
								pst.setString(2,  date);
								
								pst.execute();
								//JOptionPane.showMessageDialog(null, "Data Saved !");
								pst.close();
								
							}
							catch(Exception e1)
							{
								e1.printStackTrace();
							}
						
							
							
									for(k=0;k<lab_test.getColumnCount();k++)
										
									{	
									
										
										col_name = lab_test.getColumnName(k);
										
									
												
												
												
												
												
												
												
												
												
										entryy = 	lab_test.getValueAt(0, k).toString();
										
										/*JOptionPane.showMessageDialog(null, entryy);
										JOptionPane.showMessageDialog(null, col_name);*/
										try{
											conn1 =DriverManager.getConnection("jdbc:ucanaccess://bsshlab.accdb");
											String query = "update "+s+" set "+col_name+" = ? where Sno = '"+lab_test.getValueAt(0, 0)+"' ";
											 PreparedStatement preparedStmt = conn1.prepareStatement(query);
										     preparedStmt.setString(1, entryy);
										     preparedStmt.executeUpdate();
										     conn1.close();
										      
				
										}
										catch(Exception ee)
										{
											ee.printStackTrace();
										}
										
									}
										model.removeRow(0);
										
										try
										{
																								
											conn1 =DriverManager.getConnection("jdbc:ucanaccess://bsshlab.accdb");
											String query= "select *  from   "+s+" ";
											PreparedStatement statement= conn1.prepareStatement(query);
											ResultSet rs=statement.executeQuery();
											table.setModel(DbUtils.resultSetToTableModel(rs));
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
										 	conn1 =DriverManager.getConnection("jdbc:ucanaccess://bsshlab.accdb"); 
											String query="Select Sno from "+s+" ";
											PreparedStatement pst=conn1.prepareStatement(query);
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
										
						
										
										
										
										date = dtf.format(now);
											
									try
									{
																							
										conn1 =DriverManager.getConnection("jdbc:ucanaccess://bsshlab.accdb");
										String query= "select *  from   "+s+" ";
										PreparedStatement statement= conn1.prepareStatement(query);
										ResultSet rs=statement.executeQuery();
										table.setModel(DbUtils.resultSetToTableModel(rs));
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
									 	conn1 =DriverManager.getConnection("jdbc:ucanaccess://bsshlab.accdb"); 
										String query="Select Sno from "+s+" ";
										PreparedStatement pst=conn1.prepareStatement(query);
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
									
									
									model.insertRow(lab_test.getRowCount(),new Object[]{sid,date,""});

									
									
									
									

						
					}
				});
				btnAddNewRecord.setFont(new Font("Tahoma", Font.BOLD, 18));
				btnAddNewRecord.setBounds(651, 236, 189, 23);
				contentPanel.add(btnAddNewRecord);
			}
			{
				record = new JTextArea();
				record.setBounds(10, 433, 435, 68);
				contentPanel.add(record);
			}
			{
				JButton btnSave = new JButton("Save");
				btnSave.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						
						
						
						try{
							
							conn1 =DriverManager.getConnection("jdbc:ucanaccess://bsshlab.accdb"); 
							String query1="Insert into  "+s1+"  (Record) values(?)";
							PreparedStatement pst=conn1.prepareStatement(query1);	
						
							pst.setString(1, record.getText().toString());
							
							
							pst.execute();
							//JOptionPane.showMessageDialog(null, "Data Saved !");
							pst.close();
							
						}
						catch(Exception e1)
						{
							e1.printStackTrace();
						}
						
						
					}
				});
				btnSave.setFont(new Font("Tahoma", Font.BOLD, 18));
				btnSave.setBounds(459, 453, 189, 38);
				contentPanel.add(btnSave);
			}
			{
				JLabel label = new JLabel((String) null);
				label.setText(s1);
				label.setForeground(new Color(32, 178, 170));
				label.setFont(new Font("Tahoma", Font.BOLD, 18));
				label.setBounds(292, 11, 270, 38);
				contentPanel.add(label);
			}
			data1();
		}
	}
	public void data1()
	{
		
		
			String date;
			LocalDateTime now = LocalDateTime.now();
			date = dtf.format(now);
				
		try
		{
																
			conn1 =DriverManager.getConnection("jdbc:ucanaccess://bsshlab.accdb");
			String query= "select *  from   "+s+" ";
			PreparedStatement statement= conn1.prepareStatement(query);
			ResultSet rs=statement.executeQuery();
			table.setModel(DbUtils.resultSetToTableModel(rs));
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
		 	conn1 =DriverManager.getConnection("jdbc:ucanaccess://bsshlab.accdb"); 
			String query="Select Sno from "+s+" ";
			PreparedStatement pst=conn1.prepareStatement(query);
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
		
		try{
			conn1 =DriverManager.getConnection("jdbc:ucanaccess://bsshlab.accdb");
			  Statement st = conn1.createStatement();
			  ResultSet rs = st.executeQuery("SELECT * FROM "+s+" ");
			  ResultSetMetaData md = rs.getMetaData();
			  col = md.getColumnCount();
			  
			  for (int i = 1; i <= col; i++){
					String col_name1 = md.getColumnName(i);
					
					model.addColumn(col_name1);
					
					lab_test.setModel(model);
					
			  }		
			  rs.close();
			 
		}
		
		catch(Exception eee){
			
			eee.printStackTrace();
		}
		model.insertRow(lab_test.getRowCount(),new Object[]{sid,date,""});

		
		try{
		 	conn1 =DriverManager.getConnection("jdbc:ucanaccess://bsshlab.accdb"); 
			String query="Select * from "+s1+" ";
			PreparedStatement pst=conn1.prepareStatement(query);
			ResultSet rs=pst.executeQuery();
			while(rs.next())
			{
				record.append("\n\n");
				record.append(rs.getString("record"));
			}
			
			rs.close();
			pst.close();
		}
		catch(Exception ee)
		{
			ee.printStackTrace();
		}
		
		
		
		
	}
}
