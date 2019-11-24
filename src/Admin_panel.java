import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.UIManager;

import com.mxrck.autocompleter.TextAutoCompleter;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JDialog;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;

public class Admin_panel {

	public  JFrame frame;
	TextAutoCompleter ac;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					try { UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");} 
					 catch (Exception e) { }	
					Admin_panel window = new Admin_panel();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Admin_panel() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 869, 481);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton btnNewButton = new JButton("Add New Lab/Test");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				
				
				
				JTextField lab= new JTextField();
				lab.requestFocusInWindow();
	  JComponent[] inputs = new JComponent[] {
	        new JLabel("Add Lab"),
	             lab,
	        	
	        
	      
	};
	int result = JOptionPane.showConfirmDialog(null, inputs, "Enter New Lab Here", JOptionPane.PLAIN_MESSAGE);
	if (result == JOptionPane.OK_OPTION) {
		
		
		try{
			Connection conn =DriverManager.getConnection("jdbc:ucanaccess://bansal.accdb");  
			String query1="Insert into  lab_record (lab) values(?)";
			PreparedStatement pst = conn.prepareStatement(query1);
			pst.setString(1, lab.getText());
			pst.execute();
			pst.close();
			JOptionPane.showMessageDialog(null, "A New Lab Name Added Succesfully !");
			
			
			}
		catch(Exception e1)
		{
			JOptionPane.showMessageDialog(null, e1);
		}
		
	
	}
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 22));
		btnNewButton.setBounds(10, 11, 245, 36);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnAddNewServive = new JButton("Add New Service");
		btnAddNewServive.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
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
		btnAddNewServive.setFont(new Font("Tahoma", Font.BOLD, 22));
		btnAddNewServive.setBounds(10, 69, 245, 36);
		frame.getContentPane().add(btnAddNewServive);
		
		JButton btnAddNewRoom = new JButton("Add New Room");
		btnAddNewRoom.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				JTextField room= new JTextField();
				JTextField bed= new JTextField();
				room.requestFocusInWindow();
				  JComponent[] inputs = new JComponent[] {
				        new JLabel("Room No"),
				        	room,
				        	
				        new JLabel("Bed No"),
				        bed,
				        
				      
				};
				int result = JOptionPane.showConfirmDialog(null, inputs, "Enter New Room and bed here", JOptionPane.PLAIN_MESSAGE);
				if (result == JOptionPane.OK_OPTION) {
					
					
					try{
						Connection conn =DriverManager.getConnection("jdbc:ucanaccess://bansal.accdb");  
						String query1="Insert into book_room  (room_no,bed_no,status) values(?,?,?)";
						PreparedStatement pst = conn.prepareStatement(query1);
						pst.setString(1, room.getText());
						pst.setString(2, bed.getText());
						pst.setString(3, "UNBook");
						pst.execute();
						pst.close();
						JOptionPane.showMessageDialog(null, "A New Room Created Succesfully !");
						
						
						}
					catch(Exception e1)
					{
						JOptionPane.showMessageDialog(null, e1);
					}
				}
			}
		});
		btnAddNewRoom.setFont(new Font("Tahoma", Font.BOLD, 22));
		btnAddNewRoom.setBounds(10, 127, 245, 36);
		frame.getContentPane().add(btnAddNewRoom);
		
		JButton btnAddNewMedicine = new JButton("Add New Medicine");
		btnAddNewMedicine.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				JTextField categor= new JTextField();
				 ac = new TextAutoCompleter(categor);
				 
				 try { 
					 	 Connection conn =DriverManager.getConnection("jdbc:ucanaccess://bansal.accdb"); 
						 Statement statement = conn.createStatement();
			             String query = "SELECT category FROM medicine";
			             ResultSet rs = statement.executeQuery(query);

			            while (rs.next())
			            {      
			               
			            	String s = rs.getString("category");
			            	
			            	ac.addItem(s);;
			            	
			            	
			            
			                
			            }//end while
			            conn.close();
			            } catch (Exception e1) {
			                 e1.printStackTrace();
			            }
				 
				JTextField drug= new JTextField();
				categor.requestFocusInWindow();
				  JComponent[] inputs = new JComponent[] {
				        new JLabel("Category"),
				        	categor,
				        	
				        new JLabel("Drug"),
				        drug,
				        
				      
				};
				int result = JOptionPane.showConfirmDialog(null, inputs, "Enter New Medicine here", JOptionPane.PLAIN_MESSAGE);
				if (result == JOptionPane.OK_OPTION) {
					
					
					try{
						Connection conn =DriverManager.getConnection("jdbc:ucanaccess://bansal.accdb");  
						String query1="Insert into medicine  (Drugs,category) values(?,?)";
						PreparedStatement pst = conn.prepareStatement(query1);
						pst.setString(1, drug.getText());
						pst.setString(2, categor.getText());
						
						pst.execute();
						pst.close();
						JOptionPane.showMessageDialog(null, "A New Medicine Added Succesfully !");
						
						
						}
					catch(Exception e1)
					{
						JOptionPane.showMessageDialog(null, e1);
					}
				}
				
			}
		});
		btnAddNewMedicine.setFont(new Font("Tahoma", Font.BOLD, 22));
		btnAddNewMedicine.setBounds(10, 189, 245, 36);
		frame.getContentPane().add(btnAddNewMedicine);
		
		JButton btnShedular = new JButton("Shedular");
		btnShedular.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			
				JCalander window = new JCalander();
				window.frame.setVisible(true);
			}
		});
		btnShedular.setFont(new Font("Tahoma", Font.BOLD, 22));
		btnShedular.setBounds(10, 245, 245, 36);
		frame.getContentPane().add(btnShedular);
		
		JButton btnCreateUser = new JButton("Create User");
		btnCreateUser.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				user_create window = new user_create();
				window.frame.setVisible(true);
			}
		});
		btnCreateUser.setFont(new Font("Tahoma", Font.BOLD, 22));
		btnCreateUser.setBounds(10, 304, 245, 36);
		frame.getContentPane().add(btnCreateUser);
		
		JButton btnAccount = new JButton("Account");
		btnAccount.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				
					Account dialog = new Account();
					dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
					dialog.setVisible(true);
				
			}
		});
		btnAccount.setFont(new Font("Tahoma", Font.BOLD, 22));
		btnAccount.setBounds(10, 366, 245, 36);
		frame.getContentPane().add(btnAccount);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				frame.dispose();
				String s[] = {"admin"};
				MainPage.main(s);
			}
		});
		btnBack.setFont(new Font("Tahoma", Font.BOLD, 22));
		btnBack.setBounds(598, 11, 245, 36);
		frame.getContentPane().add(btnBack);
		
		JButton btnSallery = new JButton("Sallery");
		btnSallery.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				salllery dialog = new salllery();
				dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
				dialog.setVisible(true);
			}
		});
		btnSallery.setFont(new Font("Tahoma", Font.BOLD, 22));
		btnSallery.setBounds(267, 11, 245, 36);
		frame.getContentPane().add(btnSallery);
	}
}
