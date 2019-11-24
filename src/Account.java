import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dialog;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Image;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JRootPane;
import javax.swing.JScrollBar;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

import net.proteanit.sql.DbUtils;

import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JComboBox;
import javax.swing.JComponent;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.InputMap;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.KeyStroke;
import javax.swing.UIManager;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.print.PrinterException;

import javax.swing.JCheckBox;
import javax.swing.SwingConstants;

public class Account extends JDialog {

	private final JPanel contentPanel = new JPanel();
	DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd-MM-yyyy");
	String da;
	private static JTable table;
	JComboBox party,party1;
	private JTextField date;
	private JTextField credit;
	private JTextField debit;
	private JTextField narration;
	private JLabel lblNewLabel;
	private JLabel lblDebit;
	private JLabel lblNarration;
	Dialog dialog;
	private Object[] rows;
	DefaultTableModel model;
	String s,t;
	String gg;
	Double cre = 0.0;
	Double deb = 0.0;
	private JTextField textField;
	private JButton delete;
	private JButton btnPrint;
	private JButton btnTally;
	JCheckBox check;
	double cbala;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		
		try
		{
			UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
		}
		catch(Exception e)
		{
			
		}
		
		try {
			Account dialog = new Account();
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
	       
	    	  
	    		
	    	  String s[] = {"admin"};
	    	  MainPage.main(s);
	        

	      } 
	    } ;
	    InputMap inputMap = rootPane.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
	    inputMap.put(stroke, "ESCAPE");
	    rootPane.getActionMap().put("ESCAPE", actionListener);

	    return rootPane;
	  } 

	public Account() {
		setTitle("Account Section");
		setBounds(100, 1, 1230, 917);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		//Image Imgh=new ImageIcon(this.getClass().getResource("/logo.png")).getImage();
	   	//setIconImage(Imgh);
		
		
		
		JScrollPane scrollPane = new JScrollPane();
		
		scrollPane.setBounds(12, 120, 1202, 382);
		contentPanel.add(scrollPane);
		
		
		model = new DefaultTableModel();
		rows = new Object[9];
		Object[] columns={"Date","Party","Credit","Debit","Narration","Cash Type","CBalance","Day","Tally",};
		
		model.setColumnIdentifiers(columns);
		
		table = new JTable();
		JTableHeader anHeader = table.getTableHeader();
	    anHeader.setForeground(new Color(0).black);
	    anHeader.setFont(new Font("Tahoma", Font.BOLD, 14));
	    anHeader.setBackground(new Color(0).black);
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				if(e.getClickCount() == 2)
				{
				int i = table.getSelectedRow();
				String v = table.getValueAt(i, 1).toString();
				String v1 = table.getValueAt(i, 6).toString();
				
				v = v1.concat(v);
				
				Account dialog = new Account();
				
				/*setVisible(false);
				String arr[]={v};
				view.main(arr);*/
				
				
				
				}
			}
		});
		
		table.setModel(model);
		table.setBounds(10, 11, 666, 194);
		table.setSelectionForeground(new Color(255, 255, 255));
		table.setSelectionBackground(new Color(0, 0, 128));
		table.setFont(new Font("Tahoma", Font.BOLD, 16));
		table.setRowHeight(30);
		scrollPane.setViewportView(table);
		
		JScrollBar sb = scrollPane.getVerticalScrollBar();
		sb.setValue( sb.getMaximum() );
		
		party = new JComboBox();
		party.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				
				
				
			}
		});
		party.setFont(new Font("Tahoma", Font.BOLD, 24));
		party.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				
				if(e.getKeyCode()==KeyEvent.VK_ENTER)
				{
					if(e.getKeyCode()==KeyEvent.VK_ENTER)
					{
						
						
						
						
						if(check.isSelected())
						{
							
							delete.setVisible(true);
							s = party.getSelectedItem().toString();
							s = s.concat("Account");
							double cbala = 0.0;
							while(model.getRowCount() > 0)
							{
								
								for(int i =0; i < model.getRowCount();i++)
								{
									model.removeRow(i);
								}	
							}	
							
							try
							{
																					
								Connection conn =DriverManager.getConnection("jdbc:ucanaccess://bansal.accdb");  
								 Statement statement1 = conn.createStatement();
				        			String query1=  "select *  from  "+s+"  ";
				        			 ResultSet rs1 = statement1.executeQuery(query1);
								 while (rs1.next())
				 		            {  
									 
									 
									 	rows[0]= rs1.getString("Date");
				 						rows[1]= rs1.getString("Party");
				 						rows[2]= Math.round(Double.parseDouble(rs1.getString("Credit")));
				 						rows[3]= Math.round(Double.parseDouble(rs1.getString("Dedit")));
				 						rows[4]= rs1.getString("Narration");
				 						
				 						double a = Double.parseDouble(rs1.getString("Credit"));
				 						double b = Double.parseDouble(rs1.getString("Debit"));
				 						gg = rs1.getString("Day");
				 						
				 						if(b==0.0)
				 						{	
				 						cbala = cbala + (a-b);
				 						cbala = Math.round(cbala);
				 						}
				 						else if(a==0)
				 						{
				 							cbala = cbala - (b-a);
				 							cbala = Math.round(cbala);
				 						}	
				 						rows[5] = String.valueOf(cbala);
				 						rows[6]= rs1.getString("Day");
				 						rows[7]= rs1.getString("Tally");
				 						t= rs1.getString("Tally");
				 						double x = Double.parseDouble(rs1.getString("Credit"));
				 						double y = Double.parseDouble(rs1.getString("Debit"));
				 						if(x==0.0 && y==0.0)
				 						{
				 							
				 						}
				 						else if(gg.equals("Manual Entry"))
				 						{	
				 						model.addRow(rows);
				 						
				 						}
									 	
				 		            }//end while
				 		
								rs1.close();
								statement1.close();
								
							}
							catch(SQLException e1)
							{
									e1.printStackTrace();
							}
							
							if(cbala<0.0)
							{
								
							textField.setForeground(new Color(255, 0, 0));	
							textField.setText(String.valueOf(cbala));
							
							
							}
							else if(cbala>0.0)
							{
								
								textField.setForeground(new Color(0, 0, 205));	
								textField.setText(String.valueOf(cbala));
								
								
								
							}
							else if(cbala==0.0)
							{
								
								textField.setForeground(new Color(0, 0, 205));	
								textField.setText(String.valueOf(cbala));
								
								
								
							}	
							
							if(t.equals("***"))
							{
								textField.setText(String.valueOf(cbala).concat("*"));
							}	
							
						}
						else if(!(check.isSelected()))
						{
							delete.setVisible(false);
							s = party.getSelectedItem().toString();
							s = s.concat("Account");
							double cbala = 0.0;
							while(model.getRowCount() > 0)
							{
								
								for(int i =0; i < model.getRowCount();i++)
								{
									model.removeRow(i);
								}	
							}	
							
							try
							{
																					
								 Connection conn =DriverManager.getConnection("jdbc:ucanaccess://bansal.accdb");  
								 Statement statement1 = conn.createStatement();
								 String query1=  "select *  from  "+s+" ";
				        	     ResultSet rs1 = statement1.executeQuery(query1);
								 while (rs1.next())
				 		            {  
				 						rows[0]= rs1.getString("Date");
				 						rows[1]= rs1.getString("Party");
				 						rows[2]= rs1.getString("Credit");
				 						rows[3]= rs1.getString("Debit");
				 						rows[4]= rs1.getString("Narration");
				 						
				 						double a = Double.parseDouble(rs1.getString("Credit"));
				 						double b = Double.parseDouble(rs1.getString("Debit"));
				 						if(b==0.0)
				 						{	
				 						cbala = cbala + (a-b);
				 						cbala = Math.round(cbala);
				 						}
				 						else if(a==0)
				 						{
				 							cbala = cbala - (b-a);
				 							cbala = Math.round(cbala);
				 						}	
				 						rows[5] = String.valueOf(cbala);
				 						rows[6]= rs1.getString("Day");
				 						rows[7]= rs1.getString("Tally");
				 						t= rs1.getString("Tally");
				 						double x = Double.parseDouble(rs1.getString("Credit"));
				 						double y = Double.parseDouble(rs1.getString("Debit"));
				 						if(x==0.0 && y==0.0)
				 						{
				 							
				 						}
				 						else
				 						{	
				 						model.addRow(rows);
				 						
				 						}
				 		
				 		            }//end while
				 		
								rs1.close();
								statement1.close();
								
							}
							catch(SQLException e1)
							{
									e1.printStackTrace();
							}
							
							if(cbala<0.0)
							{
								
							textField.setForeground(new Color(255, 0, 0));	
							textField.setText(String.valueOf(cbala));
							
							
							}
							else if(cbala>0.0)
							{
								
								textField.setForeground(new Color(0, 0, 205));	
								textField.setText(String.valueOf(cbala));
								
								
								
							}	
							else if(cbala==0.0)
							{
								
								textField.setForeground(new Color(0, 0, 205));	
								textField.setText(String.valueOf(cbala));
								
								
								
							}	
							if(t.equals("***"))
							{
								textField.setText(String.valueOf(cbala).concat("*"));
							}
							
							credit.setText("");
							debit.setText("");
							narration.setText("");
							party1.requestFocusInWindow();
						}	
				
		/*		s = party.getSelectedItem().toString();
				s = s.concat("Account");
				double cbala = 0.0;
				while(model.getRowCount() > 0)
				{
					
					for(int i =0; i < model.getRowCount();i++)
					{
						model.removeRow(i);
					}	
				}	
				
				try
				{
																		
					Connection conn =DriverManager.getConnection("jdbc:ucanaccess://bansal.accdb");  
					 Statement statement1 = conn.createStatement();
	        			String query1=  "select *  from  "+s+" ";
	        			 ResultSet rs1 = statement1.executeQuery(query1);
					 while (rs1.next())
	 		            {  
	 						rows[0]= rs1.getString("Date");
	 						rows[1]= rs1.getString("Party");
	 						rows[2]= Math.round(Double.parseDouble(rs1.getString("Credit")));
	 						rows[3]= Math.round(Double.parseDouble(rs1.getString("Debit")));
	 						rows[4]= rs1.getString("Narration");
	 						
	 						double a = Double.parseDouble(rs1.getString("Credit"));
	 						double b = Double.parseDouble(rs1.getString("Debit"));
	 						
	 						if(b==0.0)
	 						{	
	 						cbala = cbala + (a-b);
	 						cbala = Math.round(cbala);
	 						
	 						}
	 						else if(a==0)
	 						{
	 							cbala = cbala - (b-a);
	 							cbala = Math.round(cbala);
	 						}	
	 						rows[5] = String.valueOf(cbala);
	 						rows[6]= rs1.getString("Day");
	 						
	 						double x = Double.parseDouble(rs1.getString("Credit"));
	 						double y = Double.parseDouble(rs1.getString("Debit"));
	 						if(x==0.0 && y==0.0)
	 						{
	 							
	 						}
	 						else
	 						{	
	 						model.addRow(rows);
	 						
	 						}
	 		
	 		            }//end while
	 		
					rs1.close();
					statement1.close();
					
				}
				catch(SQLException e1)
				{
						e1.printStackTrace();
				}
				
				if(cbala<0.0)
				{
					
				textField.setForeground(new Color(255, 0, 0));	
				textField.setText(String.valueOf(cbala));
				
				textField_1.setForeground(new Color(255, 0, 0));	
				textField_1.setText(" ! LENA HAIN !");
				
				}
				else if(cbala>0.0)
				{
					
					textField.setForeground(new Color(0, 0, 205));	
					textField.setText(String.valueOf(cbala));
					
					
					textField_1.setForeground(new Color(0, 0, 205));	
					textField_1.setText(" ! DENA HAIN !");

				}*/	
				party1.requestFocusInWindow();
					}
					
				}
				
			}
		});
		party.setBounds(12, 72, 212, 37);
		contentPanel.add(party);
		
		
		LocalDateTime now = LocalDateTime.now();
		da = dtf.format(now);
		date = new JTextField();
		date.setHorizontalAlignment(SwingConstants.CENTER);
		date.setFont(new Font("Tahoma", Font.BOLD, 20));
		date.setText(da);
		date.setBounds(38, 559, 159, 37);
		contentPanel.add(date);
		date.setColumns(10);
		
		party1 = new JComboBox();
		party1.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				
				if(e.getKeyCode()==KeyEvent.VK_ENTER)
				{
					if(e.getKeyCode()==KeyEvent.VK_ENTER)
					{
						narration.requestFocusInWindow();
					}
				}
			}
				});
			
		party1.setFont(new Font("Tahoma", Font.BOLD, 20));
		party1.setModel(new DefaultComboBoxModel(new String[] {"self"}));
		party1.setBounds(219, 559, 235, 37);
		contentPanel.add(party1);
		
		credit = new JTextField();
		credit.setFont(new Font("Tahoma", Font.BOLD, 16));
		credit.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				
				
				if(e.getKeyCode()==KeyEvent.VK_ENTER)
				{
					
					
					
					
					if(credit.getText().isEmpty())
					{
						debit.requestFocusInWindow();
						
					}	
					else
					{	
						
						
						
					String s = party1.getSelectedItem().toString();
					String s21 = s.concat("Account");
		           
					
					String s1 = party.getSelectedItem().toString();
					String s22 = s1.concat("Account");
		          
					Calendar cal =new GregorianCalendar();
		   			int second = cal.get(Calendar.SECOND);
		   			int minute = cal.get(Calendar.MINUTE);
		   			int hour = cal.get(Calendar.HOUR);
		   			
		   			
		   			String time = hour+":"+minute+":"+second;
					try {
						Connection conn =DriverManager.getConnection("jdbc:ucanaccess://bansal.accdb"); 
						String query = "Insert into "+s22+" (Date,Party,Credit,Debit,Day,Narration) values(?,?,?,?,?,?) ";
						PreparedStatement pst = conn.prepareStatement(query);
						pst.setString(1,  date.getText().toString().concat("    ").concat(time));
						pst.setString(2, party1.getSelectedItem().toString());
						pst.setString(3, credit.getText());
						pst.setString(4, "0.0");
						pst.setString(5, "Manual Entry");
						pst.setString(6, narration.getText());
						pst.execute();
						pst.close();
						
						
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
					
					try {
						Connection conn =DriverManager.getConnection("jdbc:ucanaccess://bansal.accdb");  
						String query = "Insert into "+s21+" (Date,Party,Credit,Debit,day,Narration) values(?,?,?,?,?,?) ";
						PreparedStatement pst = conn.prepareStatement(query);
						pst.setString(1,  date.getText().toString().concat("    ").concat(time));
						pst.setString(2, party.getSelectedItem().toString());
						pst.setString(3, "0.0");
						pst.setString(4,  credit.getText());
						pst.setString(5, "Manual Entry");
						pst.setString(6, narration.getText());
						pst.execute();
						pst.close();
						
						
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}

					
					s = party.getSelectedItem().toString();
					s = s.concat("Account");
					double cbala = 0.0;
					while(model.getRowCount() > 0)
					{
						
						for(int i =0; i < model.getRowCount();i++)
						{
							model.removeRow(i);
						}	
					}	
					
					try
					{
																			
						Connection conn =DriverManager.getConnection("jdbc:ucanaccess://bansal.accdb");  
						 Statement statement1 = conn.createStatement();
		        			String query1=  "select *  from  "+s+" ";
		        			 ResultSet rs1 = statement1.executeQuery(query1);
						 while (rs1.next())
		 		            {  
		 						rows[0]= rs1.getString("Date");
		 						rows[1]= rs1.getString("Party");
		 						rows[2]= Math.round(Double.parseDouble(rs1.getString("Credit")));
		 						rows[3]= Math.round(Double.parseDouble(rs1.getString("Debit")));
		 						rows[4]= rs1.getString("Narration");
		 						
		 						double a = Double.parseDouble(rs1.getString("Credit"));
		 						double b = Double.parseDouble(rs1.getString("Debit"));
		 						if(b==0.0)
		 						{	
		 						cbala = cbala + (a-b);
		 						cbala = Math.round(cbala);;
		 						}
		 						else if(a==0)
		 						{
		 							cbala = cbala - (b-a);
		 							cbala = Math.round(cbala);
		 						}	
		 						rows[5] = String.valueOf(cbala);
		 						rows[6]= rs1.getString("Day");
		 						rows[7]= rs1.getString("Tally");
		 						double x = Double.parseDouble(rs1.getString("Credit"));
		 						double y = Double.parseDouble(rs1.getString("Debit"));
		 						if(x==0.0 && y==0.0)
		 						{
		 							
		 						}
		 						else
		 						{	
		 						model.addRow(rows);
		 						
		 						}
		 		
		 		            }//end while
		 		
						rs1.close();
						statement1.close();
						
					}
					catch(SQLException e1)
					{
							e1.printStackTrace();
					}
					
					if(cbala<0.0)
					{
						
					textField.setForeground(new Color(255, 0, 0));	
					textField.setText(String.valueOf(cbala));
					
					
					}
					else if(cbala>0.0)
					{
						
						textField.setForeground(new Color(0, 0, 205));	
						textField.setText(String.valueOf(cbala));
						
						
						
					}	
					else if(cbala==0.0)
					{
						
						textField.setForeground(new Color(0, 0, 205));	
						textField.setText(String.valueOf(cbala));
						
						
						
					}	
					credit.setText("");
					debit.setText("");
					narration.setText("");
					party1.requestFocusInWindow();
					table.scrollRectToVisible(table.getCellRect(table.getRowCount()-1, 0, true));
				}
				}	
			}
		});
		credit.setColumns(10);
		credit.setBounds(736, 558, 116, 37);
		contentPanel.add(credit);
		
		debit = new JTextField();
		debit.setFont(new Font("Tahoma", Font.BOLD, 16));
		debit.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				
				if(e.getKeyCode()==KeyEvent.VK_ENTER)
				{
					String s = party1.getSelectedItem().toString();
					String s21 = s.concat("Account");
		          
		          
					if(debit.getText().isEmpty())
					{
						narration.requestFocusInWindow();
					}	
					else
					{	
						
						Calendar cal =new GregorianCalendar();
			   			int second = cal.get(Calendar.SECOND);
			   			int minute = cal.get(Calendar.MINUTE);
			   			int hour = cal.get(Calendar.HOUR);
			   			
			   			
			   			String time = hour+":"+minute+":"+second;
					try {
						Connection conn =DriverManager.getConnection("jdbc:ucanaccess://bansal.accdb");  
						String query = "Insert into "+s21+" (Date,Party,Credit,Debit,Day,Narration) values(?,?,?,?,?,?) ";
						PreparedStatement pst = conn.prepareStatement(query);
						pst.setString(1,  date.getText().toString().concat("    ").concat(time));
						pst.setString(2, party.getSelectedItem().toString());
						pst.setString(3, debit.getText());
						pst.setString(4,  "0.0");
						pst.setString(5, "Manual Entry");
						pst.setString(6, narration.getText());
						pst.execute();
						pst.close();
						
						
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
					
					String s1 = party.getSelectedItem().toString();
					String s22 = s1.concat("Account");
		          
					
					try {
						Connection conn =DriverManager.getConnection("jdbc:ucanaccess://bansal.accdb"); 
						String query = "Insert into "+s22+" (Date,Party,Credit,Debit,Day,Narration) values(?,?,?,?,?,?) ";
						PreparedStatement pst = conn.prepareStatement(query);
						pst.setString(1,  date.getText().toString().concat("    ").concat(time));
						pst.setString(2, party1.getSelectedItem().toString());
						pst.setString(3, "0.0");
						pst.setString(4, debit.getText());
						pst.setString(5, "Manual Entry");
						pst.setString(6, narration.getText());
						
						pst.execute();
						pst.close();
						
						
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
					s = party.getSelectedItem().toString();
					s = s.concat("Account");
					double cbala = 0.0;
					while(model.getRowCount() > 0)
					{
						
						for(int i =0; i < model.getRowCount();i++)
						{
							model.removeRow(i);
						}	
					}	
					
					try
					{
																			
						Connection conn =DriverManager.getConnection("jdbc:ucanaccess://bansal.accdb");  
						 Statement statement1 = conn.createStatement();
		        			String query1=  "select *  from  "+s+" ";
		        			 ResultSet rs1 = statement1.executeQuery(query1);
						 while (rs1.next())
		 		            {  
		 						rows[0]= rs1.getString("Date");
		 						rows[1]= rs1.getString("Party");
		 						rows[2]= Math.round(Double.parseDouble(rs1.getString("Credit")));
		 						rows[3]= Math.round(Double.parseDouble(rs1.getString("Debit")));
		 						rows[4]= rs1.getString("Narration");
		 						
		 						double a = Double.parseDouble(rs1.getString("Credit"));
		 						double b = Double.parseDouble(rs1.getString("Debit"));
		 						if(b==0.0)
		 						{	
		 						cbala = cbala + (a-b);
		 						cbala = Math.round(cbala);
		 						}
		 						else if(a==0)
		 						{
		 							cbala = cbala - (b-a);
		 							cbala = Math.round(cbala);;
		 						}	
		 						rows[5] = String.valueOf(cbala);
		 						rows[6]= rs1.getString("Day");
		 						rows[7]= rs1.getString("Tally");
		 						double x = Double.parseDouble(rs1.getString("Credit"));
		 						double y = Double.parseDouble(rs1.getString("Debit"));
		 						if(x==0.0 && y==0.0)
		 						{
		 							
		 						}
		 						else
		 						{	
		 						model.addRow(rows);
		 						
		 						}
		 		
		 		            }//end while
		 		
						rs1.close();
						statement1.close();
						
					}
					catch(SQLException e1)
					{
							e1.printStackTrace();
					}
					
					if(cbala<0.0)
					{
						
					textField.setForeground(new Color(255, 0, 0));	
					textField.setText(String.valueOf(cbala));
					
					
					}
					else if(cbala>0.0)
					{
						
						textField.setForeground(new Color(0, 0, 205));	
						textField.setText(String.valueOf(cbala));
						
						
						
					}	
					else if(cbala==0.0)
					{
						
						textField.setForeground(new Color(0, 0, 205));	
						textField.setText(String.valueOf(cbala));
						
						
						
					}
					credit.setText("");
					debit.setText("");
					narration.setText("");
					party1.requestFocusInWindow();
					table.scrollRectToVisible(table.getCellRect(table.getRowCount()-1, 0, true));
					}
				}

			}
		});
		debit.setColumns(10);
		debit.setBounds(885, 558, 116, 37);
		contentPanel.add(debit);
		
		narration = new JTextField();
		narration.setFont(new Font("Tahoma", Font.BOLD, 12));
		narration.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				
				
				if(e.getKeyCode()==KeyEvent.VK_ENTER)
				{
					credit.requestFocusInWindow();
					
				}
				
			}
		});
		narration.setColumns(10);
		narration.setBounds(508, 558, 202, 37);
		contentPanel.add(narration);
		
		lblNewLabel = new JLabel("Credit");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel.setBounds(736, 529, 116, 16);
		contentPanel.add(lblNewLabel);
		
		lblDebit = new JLabel("Debit");
		lblDebit.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblDebit.setHorizontalAlignment(SwingConstants.CENTER);
		lblDebit.setBounds(885, 529, 116, 16);
		contentPanel.add(lblDebit);
		
		lblNarration = new JLabel("Narration");
		lblNarration.setHorizontalAlignment(SwingConstants.CENTER);
		lblNarration.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNarration.setBounds(508, 529, 196, 16);
		contentPanel.add(lblNarration);
		
		textField = new JTextField();
		textField.setEditable(false);
		
		textField.setFont(new Font("Tahoma", Font.BOLD, 24));
		textField.setBounds(975, 11, 212, 50);
		contentPanel.add(textField);
		textField.setColumns(10);
		
		delete = new JButton("Delete");
		delete.setVisible(false);
		delete.setFont(new Font("Tahoma", Font.BOLD, 18));
		delete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				
				DefaultTableModel model = (DefaultTableModel)table.getModel();
				 int[] selectedRows = table.getSelectedRows();
				 
				 int dialogResult = JOptionPane.showConfirmDialog (null, "Would You Like to Delete Selected Entry");
					if(dialogResult == JOptionPane.YES_OPTION){
			        for (int i = selectedRows.length - 1; i >= 0; i--) {
			          
			        	
			        	
						  
							
							String s2,s3,s4;
							
							s2 =  model.getValueAt(selectedRows[i], 0).toString();
							s3 =  model.getValueAt(selectedRows[i], 1).toString();
							s4 =  "Manual Entry";
							if(s3.equals("admin"))
							{
								s3 = s3.concat("account");
							}	
							else 
							{
								s3 = s3.concat("Account");
							}	
							
							try
							{
								
							Connection conn =DriverManager.getConnection("jdbc:ucanaccess://bansal.accdb"); 
							String query = "DELETE FROM   "+s+" WHERE Date = '"+s2+"' AND Day = '"+s4+"' ";
							PreparedStatement pst=conn.prepareStatement(query);
				  			pst.executeUpdate();
				  				
				  			}
				  			catch(Exception e1)
				  			{
				  				//JOptionPane.showMessageDialog(null,e1);
				  			}
							
							try{
								
								Connection conn =DriverManager.getConnection("jdbc:ucanaccess://bansal.accdb"); 
								String query = "DELETE FROM   "+s3+" WHERE Date = '"+s2+"' AND Day = '"+s4+"' ";
								PreparedStatement pst=conn.prepareStatement(query);
					  			pst.executeUpdate();
					  				
					  			}
					  			catch(Exception e1)
					  			{
					  				//JOptionPane.showMessageDialog(null,e1);
					  			}
								
								
							
							
							
							s = party.getSelectedItem().toString();
							s = s.concat("Account");
							double cbala = 0.0;
							while(model.getRowCount() > 0)
							{
								
								for(int ii =0; ii < model.getRowCount();ii++)
								{
									model.removeRow(ii);
								}	
							}	
							
							try
							{
																					
								Connection conn =DriverManager.getConnection("jdbc:ucanaccess://bansal.accdb");  
								 Statement statement1 = conn.createStatement();
				        			String query1=  "select *  from  "+s+" ";
				        			 ResultSet rs1 = statement1.executeQuery(query1);
								 while (rs1.next())
				 		            {  
				 						rows[0]= rs1.getString("Date");
				 						rows[1]= rs1.getString("Party");
				 						rows[2]= Math.round(Double.parseDouble(rs1.getString("Credit")));
				 						rows[3]= Math.round(Double.parseDouble(rs1.getString("Debit")));
				 						rows[4]= rs1.getString("Narration");
				 						
				 						double a = Double.parseDouble(rs1.getString("Credit"));
				 						double b = Double.parseDouble(rs1.getString("Debit"));
				 						
				 						if(b==0.0)
				 						{	
				 						cbala = cbala + (a-b);
				 						cbala = Math.round(cbala);
				 						
				 						}
				 						else if(a==0)
				 						{
				 							cbala = cbala - (b-a);
				 							cbala = Math.round(cbala);
				 						}	
				 						rows[5] = String.valueOf(cbala);
				 						rows[6]= rs1.getString("Day");
				 						
				 						double x = Double.parseDouble(rs1.getString("Credit"));
				 						double y = Double.parseDouble(rs1.getString("Debit"));
				 						if(x==0.0 && y==0.0)
				 						{
				 							
				 						}
				 						else
				 						{	
				 						model.addRow(rows);
				 						
				 						}
				 		
				 		            }//end while
				 		
								rs1.close();
								statement1.close();
								
							}
							catch(SQLException e1)
							{
									e1.printStackTrace();
							}
							
							if(cbala<0.0)
							{
								
							textField.setForeground(new Color(255, 0, 0));	
							textField.setText(String.valueOf(cbala));
							
							
							}
							else if(cbala>0.0)
							{
								
								textField.setForeground(new Color(0, 0, 205));	
								textField.setText(String.valueOf(cbala));
								
								
								
							}	
							party1.requestFocusInWindow();
								
							
							
							
							
			
							
			        }  }				
			}
		});
		delete.setBounds(1079, 513, 125, 37);
		contentPanel.add(delete);
		
		JLabel lblClosingBalance = new JLabel("Closing Balance");
		lblClosingBalance.setForeground(new Color(0, 51, 255));
		lblClosingBalance.setFont(new Font("DialogInput", Font.BOLD, 22));
		lblClosingBalance.setBounds(752, 19, 235, 30);
		contentPanel.add(lblClosingBalance);
		
		check = new JCheckBox("Delete Entry ");
		check.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				String d = "";
				if(check.isSelected())
				{
					
					delete.setVisible(true);
					s = party.getSelectedItem().toString();
					s = s.concat("Account");
					double cbala = 0.0;
					while(model.getRowCount() > 0)
					{
						
						for(int i =0; i < model.getRowCount();i++)
						{
							model.removeRow(i);
						}	
					}	
					
					try
					{
																			
						Connection conn =DriverManager.getConnection("jdbc:ucanaccess://bansal.accdb");  
						 Statement statement1 = conn.createStatement();
		        			String query1=  "select *  from  "+s+"  ";
		        			 ResultSet rs1 = statement1.executeQuery(query1);
						 while (rs1.next())
		 		            {  
							 
							 
							 	rows[0]= rs1.getString("Date");
		 						rows[1]= rs1.getString("Party");
		 						rows[2]= rs1.getString("Credit");
		 						rows[3]= rs1.getString("Debit");
		 						rows[4]= rs1.getString("Narration");
		 						
		 						double a = Double.parseDouble(rs1.getString("Credit"));
		 						double b = Double.parseDouble(rs1.getString("Debit"));
		 						gg = rs1.getString("Day");
		 						
		 						if(b==0.0)
		 						{	
		 						cbala = cbala + (a-b);
		 						//cbala = Math.abs(cbala);
		 						}
		 						else if(a==0)
		 						{
		 							cbala = cbala - (b-a);
			 						//cbala = Math.abs(cbala);
		 						}	
		 						rows[5] = String.valueOf(cbala);
		 						rows[6]= rs1.getString("Day");
		 						
		 						double x = Double.parseDouble(rs1.getString("Credit"));
		 						double y = Double.parseDouble(rs1.getString("Debit"));
		 						if(x==0.0 && y==0.0)
		 						{
		 							
		 						}
		 						else if(gg.equals("Manual Entry"))
		 						{	
		 						model.addRow(rows);
		 						
		 						}
							 	
		 		            }//end while
		 		
						rs1.close();
						statement1.close();
						
					}
					catch(SQLException e1)
					{
							e1.printStackTrace();
					}
					
					if(cbala<0.0)
					{
						
					textField.setForeground(new Color(255, 0, 0));	
					textField.setText(String.valueOf(cbala));
					
					
					}
					else if(cbala>0.0)
					{
						
						textField.setForeground(new Color(0, 0, 205));	
						textField.setText(String.valueOf(cbala));
						
						
						
					}	
					
						
				}
				else if(!(check.isSelected()))
				{
					delete.setVisible(false);
					s = party.getSelectedItem().toString();
					s = s.concat("Account");
					double cbala = 0.0;
					while(model.getRowCount() > 0)
					{
						
						for(int i =0; i < model.getRowCount();i++)
						{
							model.removeRow(i);
						}	
					}	
					
					try
					{
																			
						Connection conn =DriverManager.getConnection("jdbc:ucanaccess://bansal.accdb");  
						 Statement statement1 = conn.createStatement();
		        			String query1=  "select *  from  "+s+" ";
		        			 ResultSet rs1 = statement1.executeQuery(query1);
						 while (rs1.next())
		 		            {  
		 						rows[0]= rs1.getString("Date");
		 						rows[1]= rs1.getString("Party");
		 						rows[2]= rs1.getString("Credit");
		 						rows[3]= rs1.getString("Debit");
		 						rows[4]= rs1.getString("Narration");
		 						
		 						double a = Double.parseDouble(rs1.getString("Credit"));
		 						double b = Double.parseDouble(rs1.getString("Debit"));
		 						if(b==0.0)
		 						{	
		 						cbala = cbala + (a-b);
		 						//cbala = Math.abs(cbala);
		 						}
		 						else if(a==0)
		 						{
		 							cbala = cbala - (b-a);
			 						//cbala = Math.abs(cbala);
		 						}	
		 						rows[5] = String.valueOf(cbala);
		 						rows[6]= rs1.getString("Day");
		 						
		 						double x = Double.parseDouble(rs1.getString("Credit"));
		 						double y = Double.parseDouble(rs1.getString("Debit"));
		 						if(x==0.0 && y==0.0)
		 						{
		 							
		 						}
		 						else
		 						{	
		 						model.addRow(rows);
		 						
		 						}
		 		
		 		            }//end while
		 		
						rs1.close();
						statement1.close();
						
					}
					catch(SQLException e1)
					{
							e1.printStackTrace();
					}
					
					if(cbala<0.0)
					{
						
					textField.setForeground(new Color(255, 0, 0));	
					textField.setText(String.valueOf(cbala));
					
					
					}
					else if(cbala>0.0)
					{
						
						textField.setForeground(new Color(0, 0, 205));	
						textField.setText(String.valueOf(cbala));
						
						
						
					}	
					
						
				}	
			}
		});
		check.setForeground(new Color(0, 0, 255));
		check.setFont(new Font("Tahoma", Font.BOLD, 20));
		check.setBounds(12, 11, 335, 37);
		contentPanel.add(check);
		
		btnPrint = new JButton("Print");
		btnPrint.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				try {
					table.print();
				} catch (PrinterException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
		 		
				
			}
		});
		btnPrint.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnPrint.setBounds(1079, 572, 125, 37);
		contentPanel.add(btnPrint);
		
		btnTally = new JButton("Tally");
		btnTally.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				table.selectAll();
			
				DefaultTableModel model = (DefaultTableModel)table.getModel();
				 int[] selectedRows = table.getSelectedRows();
				for (int i = 0; i <= selectedRows.length-1; i++) {
			          
		        	
		        	
					  
					
					String s2,s3;
					
					s2 =  model.getValueAt(selectedRows[i], 0).toString();
					
					
					try
					{
						Connection conn =DriverManager.getConnection("jdbc:ucanaccess://bansal.accdb"); 
						String query ="Update  "+s+" set Tally=? where Date = '"+s2+"' "; 
						PreparedStatement ps  = conn.prepareStatement(query);
						
						
						ps.setString(1, "***");
						
						
						
						ps.executeUpdate();
						ps.close();
						
						
						
					
						
						
						

						
					}
					catch(Exception ee)
					{
						ee.printStackTrace();
					}
				}
					cbala = 0.0;
					while(model.getRowCount() > 0)
					{
						
						for(int j =0; j < model.getRowCount();j++)
						{
							model.removeRow(j);
						}	
					}	
									
				
				
				try
				{
																		
					Connection conn =DriverManager.getConnection("jdbc:ucanaccess://bansal.accdb");  
					 Statement statement1 = conn.createStatement();
	        			String query1=  "select *  from  "+s+" ";
	        			 ResultSet rs1 = statement1.executeQuery(query1);
					 while (rs1.next())
	 		            {  
	 						rows[0]= rs1.getString("Date");
	 						rows[1]= rs1.getString("Party");
	 						rows[2]= Math.round(Double.parseDouble(rs1.getString("Credit")));
	 						rows[3]= Math.round(Double.parseDouble(rs1.getString("Debit")));
	 						rows[4]= rs1.getString("Narration");
	 						
	 						double a = Double.parseDouble(rs1.getString("Credit"));
	 						double b = Double.parseDouble(rs1.getString("Debit"));
	 						if(b==0.0)
	 						{	
	 						cbala = cbala + (a-b);
	 						cbala = Math.round(cbala);
	 						}
	 						else if(a==0)
	 						{
	 							cbala = cbala - (b-a);
	 							cbala = Math.round(cbala);;
	 						}	
	 						rows[5] = String.valueOf(cbala);
	 						rows[6]= rs1.getString("Day");
	 						rows[7]= rs1.getString("Tally");
	 						t = rs1.getString("Tally");
	 						double x = Double.parseDouble(rs1.getString("Credit"));
	 						double y = Double.parseDouble(rs1.getString("Debit"));
	 						if(x==0.0 && y==0.0)
	 						{
	 							
	 						}
	 						else
	 						{	
	 						model.addRow(rows);
	 						
	 						}
	 		
	 		            }//end while
	 		
					rs1.close();
					statement1.close();
					
				}
				catch(SQLException e1)
				{
						e1.printStackTrace();
				}
				
				if(cbala<0.0)
				{
					
				textField.setForeground(new Color(255, 0, 0));	
				textField.setText(String.valueOf(cbala));
				
				
				}
				else if(cbala>0.0)
				{
					
					textField.setForeground(new Color(0, 0, 205));	
					textField.setText(String.valueOf(cbala));
					
					
					
				}	
				else if(cbala==0.0)
				{
					
					textField.setForeground(new Color(0, 0, 205));	
					textField.setText(String.valueOf(cbala));
					
					
					
				}	
				
					if(t.equals("***"))
					{
						textField.setText(String.valueOf(cbala).concat("*"));
					}	
			}
		});
		btnTally.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnTally.setBounds(976, 78, 125, 37);
		contentPanel.add(btnTally);
		party();
	}
	public void party()
	{
		try { 
			Connection conn =DriverManager.getConnection("jdbc:ucanaccess://bansal.accdb"); 
			Statement statement = conn.createStatement();
             String query = "SELECT * FROM  Accountholder";
             ResultSet rs = statement.executeQuery(query);

            while (rs.next())
            {      
               
            	            	
            	
            	party.addItem(rs.getString("name"));
            	party1.addItem(rs.getString("name"));
            	
            
            
                
            }//end while
            conn.close();
            } catch (Exception e1) {
                 e1.printStackTrace();
            }
	

	}
	public void sum()
	{
		cre = 0.0;
		deb = 0.0;
		for(int i = 0; i < model.getRowCount(); i++)
		{
			cre = cre + Double.parseDouble(model.getValueAt(i, 2).toString());
			deb = deb + Double.parseDouble(model.getValueAt(i, 3).toString());
		}	
		
		
		Double tot = 0.0;
		tot = cre - deb;
		tot = Math.abs(tot);
		if(tot<0.0)
		{
			//JOptionPane.showMessageDialog(null, " g");
		textField.setForeground(new Color(255, 0, 0));	
		textField.setText(String.valueOf(tot));
		
		}
		else if(tot>0.0)
		{
			JOptionPane.showMessageDialog(null, " gg");
			textField.setForeground(new Color(0, 0, 205));	
			textField.setText(String.valueOf(tot));

		}	
	}
	
	public static String[] printbutton3()
	{
		int tablerow1= table.getRowCount();
		//JOptionPane.showMessageDialog(null, tablerow1);
		String [] table_1valueslenghth=new String[5*tablerow1];
		//JOptionPane.showMessageDialog(null, tablerow1*4);
		for(int i=0;i<tablerow1*7;i++)
		{
			table_1valueslenghth[i]=	(String) table.getValueAt(i/7, 0);
			//JOptionPane.showMessageDialog(null, table_1valueslenghth[i]);
			table_1valueslenghth[i+1] =(String)  table.getValueAt(i/7, 1);
			//JOptionPane.showMessageDialog(null, table_1valueslenghth[i+1]);
			table_1valueslenghth[i+2]=	(String) table.getValueAt(i/7, 2).toString();
			//JOptionPane.showMessageDialog(null, table_1valueslenghth[i+2]);
			table_1valueslenghth[i+3]=	(String) table.getValueAt(i/7, 3).toString();
			//JOptionPane.showMessageDialog(null, table_1valueslenghth[i+3]);
			table_1valueslenghth[i+4]=	(String) table.getValueAt(i/7, 4);
			//JOptionPane.showMessageDialog(null, table_1valueslenghth[i+4]);
			table_1valueslenghth[i+5]=	(String) table.getValueAt(i/7, 5);
			
			table_1valueslenghth[i+6]=	(String) table.getValueAt(i/7, 6);
			i=i+6;
		}
		return table_1valueslenghth;
	}
}
