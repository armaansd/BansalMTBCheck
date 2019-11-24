import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import net.proteanit.sql.DbUtils;

import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.JScrollPane;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Room_Manager extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTable book;
	private JTable unbook;
	private Object[] rows;
	DefaultTableModel model,model1;
	String s1,s2;
	String name,mobile;
	/**
	 * Launch the application.
	 */
	public static void main(String args[]) {
		
		
		
		try
		{
			UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
		}
		catch(Exception e)
		{
			
		}
		
		
		try {
			Room_Manager dialog = new Room_Manager();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 * 
	 * 
	 * 
	 * 
	 * 
	 * String naam;
	String baapu;
	String umar;
	String gend;
	String mobilnum;
	String patto;
	String shar;
	String raj;
	String deppt;
	String drkaname;
	String admdate;
	String roomkano;
	String wardkano;
	 */
	public Room_Manager() {
		setTitle("Room Manager");
		setBounds(100, 100, 861, 480);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 11, 825, 408);
		contentPanel.add(panel);
		panel.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBackground(Color.GREEN);
		scrollPane.setBounds(10, 11, 381, 339);
		panel.add(scrollPane);
		
		model = new DefaultTableModel();
		model1 = new DefaultTableModel();
		rows = new Object[8];
		Object[] columns={"Room No.","Bed No",};
		Object[] columns1={"Room No.","Bed No",};
		model.setColumnIdentifiers(columns);
		model1.setColumnIdentifiers(columns1);
		book = new JTable();
		book.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				
				
				model1 = (DefaultTableModel)book.getModel();
				 int[] selectedRows = book.getSelectedRows();
				
				 for (int i = selectedRows.length - 1; i >= 0; i--)
				 {
				s1 =  model1.getValueAt(selectedRows[i], 0).toString();
				s2 =  model1.getValueAt(selectedRows[i], 1).toString();
				
				
				/*try{
					
				Connection conn =DriverManager.getConnection("jdbc:ucanaccess://sbbh.accdb"); 
				String query = "DELETE FROM book_room   WHERE room_no = '"+s1+"' and bed_no = '"+s2+"' ";
				PreparedStatement pst=conn.prepareStatement(query);
	  			pst.executeUpdate();
	  				
	  			}
	  			catch(Exception e1)
	  			{
	  				JOptionPane.showMessageDialog(null,e1);
	  			}*/
				
				
				
				String value = "Admit"; 
	   			try
				{
																		
					Connection conn =DriverManager.getConnection("jdbc:ucanaccess://sbbh.accdb");
					String query= "select name,mobile  from  ipd_admit where status = '"+value+"' and room_no = '"+s1+"' and bed_no = '"+s2+"' ";
					PreparedStatement statement= conn.prepareStatement(query);
					ResultSet rs=statement.executeQuery();
					 while (rs.next())
			            {  
							
							name = rs.getString("name");
							mobile = rs.getString("mobile");
						
			            }//end while
					rs.close();
					statement.close();
					
				}
				catch(SQLException e1)
				{
						e1.printStackTrace();
				}
				
				
				JOptionPane.showMessageDialog(null,name+"  "+mobile);
				
				
				 }	
			}
		});
		book.setSelectionBackground(Color.GREEN);
		book.setGridColor(Color.GREEN);
		book.setRowHeight(30);
		book.setFont(new Font("Tahoma", Font.BOLD, 22));
		book.setForeground(Color.GREEN);
		book.setModel(model);
		
		scrollPane.setViewportView(book);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(420, 11, 367, 339);
		panel.add(scrollPane_1);
		
		unbook = new JTable();
		unbook.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				
				
				model1 = (DefaultTableModel)unbook.getModel();
				 int[] selectedRows = unbook.getSelectedRows();
				
				 for (int i = selectedRows.length - 1; i >= 0; i--)
				 {
				s1 =  model1.getValueAt(selectedRows[i], 0).toString();
				s2 =  model1.getValueAt(selectedRows[i], 1).toString();
				
				
				
				
				String value = "Admit"; 
	   			try
				{
																		
					Connection conn =DriverManager.getConnection("jdbc:ucanaccess://sbbh.accdb");
					String query= "select name,mobile  from  ipd_admit where status = '"+value+"' and room_no = '"+s1+"' and bed_no = '"+s2+"' ";
					PreparedStatement statement= conn.prepareStatement(query);
					ResultSet rs=statement.executeQuery();
					 while (rs.next())
			            {  
							
							name = rs.getString("name");
							mobile = rs.getString("mobile");
						
			            }//end while
					rs.close();
					statement.close();
					
				}
				catch(SQLException e1)
				{
						e1.printStackTrace();
				}
				
				
				JOptionPane.showMessageDialog(null,name+"  "+mobile);
				 }
			}
		});
		unbook.setGridColor(Color.RED);
		unbook.setSelectionBackground(Color.RED);
		unbook.setFont(new Font("Tahoma", Font.BOLD, 22));
		unbook.setForeground(Color.RED);
		unbook.setRowHeight(30);
		unbook.setModel(model1);
		scrollPane_1.setViewportView(unbook);
		
		JButton btnNewButton = new JButton("Add New Room");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				
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
						Connection conn =DriverManager.getConnection("jdbc:ucanaccess://sbbh.accdb");  
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
					
					String ss = "Book";
					try{
						
							Connection conn =DriverManager.getConnection("jdbc:ucanaccess://sbbh.accdb");
							String query="Select * from  book_room where status = '"+ss+"' ";
							PreparedStatement pst=conn.prepareStatement(query);
							ResultSet rs=pst.executeQuery();
							unbook.setModel(DbUtils.resultSetToTableModel(rs));
							rs.close();
							pst.close();				
							rs.close();
							pst.close();
					}
							catch(SQLException e1)
							{
									e1.printStackTrace();
							}
					
					
					
					
					String sss = "UNBook";
					try{
						//JOptionPane.showMessageDialog(null, drshab);
							Connection conn =DriverManager.getConnection("jdbc:ucanaccess://sbbh.accdb");
							String query="Select * from  book_room where status = '"+sss+"' ";
							PreparedStatement pst=conn.prepareStatement(query);
							ResultSet rs=pst.executeQuery();
							book.setModel(DbUtils.resultSetToTableModel(rs));
							rs.close();
							pst.close();				
							rs.close();
							pst.close();
					}
							catch(SQLException e1)
							{
									e1.printStackTrace();
							}
			
				}
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnNewButton.setBounds(298, 374, 157, 25);
		panel.add(btnNewButton);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				
				model = (DefaultTableModel)book.getModel();
				 int[] selectedRows = book.getSelectedRows();
				 
				 
				 int dialogResult = JOptionPane.showConfirmDialog (null, "Would You Like to Delete Selected Entry");
					if(dialogResult == JOptionPane.YES_OPTION){
			        for (int i = selectedRows.length - 1; i >= 0; i--) {
			          
			        	
			        	
						  
							
							
							
							s1 =  model.getValueAt(selectedRows[i], 0).toString();
							s2 =  model.getValueAt(selectedRows[i], 1).toString();
							
							
							try{
								
							Connection conn =DriverManager.getConnection("jdbc:ucanaccess://sbbh.accdb"); 
							String query = "DELETE FROM book_room   WHERE room_no = '"+s1+"' and bed_no = '"+s2+"' ";
							PreparedStatement pst=conn.prepareStatement(query);
				  			pst.executeUpdate();
				  				
				  			}
				  			catch(Exception e1)
				  			{
				  				JOptionPane.showMessageDialog(null,e1);
				  			}
							
							
							
							String ss = "Book";
							try{
								//JOptionPane.showMessageDialog(null, drshab);
									Connection conn =DriverManager.getConnection("jdbc:ucanaccess://sbbh.accdb");
									String query="Select * from  book_room where status = '"+ss+"' ";
									PreparedStatement pst=conn.prepareStatement(query);
									ResultSet rs=pst.executeQuery();
									book.setModel(DbUtils.resultSetToTableModel(rs));
									rs.close();
									pst.close();				
									rs.close();
									pst.close();
							}
									catch(SQLException e1)
									{
											e1.printStackTrace();
									}
							
							
							
							
							String sss = "UNBook";
							try{
								//JOptionPane.showMessageDialog(null, drshab);
									Connection conn =DriverManager.getConnection("jdbc:ucanaccess://sbbh.accdb");
									String query="Select * from  book_room where status = '"+sss+"' ";
									PreparedStatement pst=conn.prepareStatement(query);
									ResultSet rs=pst.executeQuery();
									book.setModel(DbUtils.resultSetToTableModel(rs));
									rs.close();
									pst.close();				
									rs.close();
									pst.close();
							}
									catch(SQLException e1)
									{
											e1.printStackTrace();
									}
							
			        }
					}
				
			}
		});
		btnDelete.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnDelete.setBounds(465, 376, 157, 23);
		panel.add(btnDelete);
		
		
		
		String ss = "Book";
		try{
			//JOptionPane.showMessageDialog(null, drshab);
				Connection conn =DriverManager.getConnection("jdbc:ucanaccess://sbbh.accdb");
				String query="Select * from  book_room where status = '"+ss+"' ";
				PreparedStatement pst=conn.prepareStatement(query);
				ResultSet rs=pst.executeQuery();
				book.setModel(DbUtils.resultSetToTableModel(rs));
				rs.close();
				pst.close();				
				rs.close();
				pst.close();
		}
				catch(SQLException e1)
				{
						e1.printStackTrace();
				}
		
		
		
		
		String sss = "UNBook";
		try{
			//JOptionPane.showMessageDialog(null, drshab);
				Connection conn =DriverManager.getConnection("jdbc:ucanaccess://sbbh.accdb");
				String query="Select * from  book_room where status = '"+sss+"' ";
				PreparedStatement pst=conn.prepareStatement(query);
				ResultSet rs=pst.executeQuery();
				unbook.setModel(DbUtils.resultSetToTableModel(rs));
				rs.close();
				pst.close();				
				rs.close();
				pst.close();
		}
				catch(SQLException e1)
				{
						e1.printStackTrace();
				}
				
	}
}
