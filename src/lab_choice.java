import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.AbstractAction;
import javax.swing.InputMap;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRootPane;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import net.proteanit.sql.DbUtils;

import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.KeyStroke;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;

public class lab_choice extends JDialog {

	private final JPanel contentPanel = new JPanel();
	public JTable lab_name;
	DefaultTableModel model = 	new DefaultTableModel();
	String choice;
	/**
	 * Launch the application.
	 */
	static String s;
	public static void main(String[] args) {
		
		s =args[0];
		try {
			lab_choice dialog = new lab_choice();
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
	       
	    	  
	    	  
	    	  	String ss[]= {s};
	    		lab_test.main(ss);	
	    		setVisible(false);
	        
	        

	      } 
	    } ;
	    InputMap inputMap = rootPane.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
	    inputMap.put(stroke, "ESCAPE");
	    rootPane.getActionMap().put("ESCAPE", actionListener);

	    return rootPane;
	  } 
	public lab_choice() {
		setBounds(100, 100, 211, 481);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 43, 175, 303);
		contentPanel.add(scrollPane);
		
		lab_name = new JTable();
		//lab_name.setModel(model);
		scrollPane.setViewportView(lab_name);
		
		JButton btnNewButton = new JButton("Add Choice");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				 int[] selectedRows = lab_name.getSelectedRows();
				 

				// choice =  model.getValueAt(1, 0).toString();
				 for (int i = selectedRows.length-1; i >= 0; i--)  {
						
					
					 JOptionPane.showMessageDialog(null, i);
					//JOptionPane.showMessageDialog(null, "choice");
					 choice =  lab_name.getValueAt(selectedRows[i], 0).toString();
					 
					 
					 JOptionPane.showMessageDialog(null, choice);
					
					
					try
			  			{
						
						JOptionPane.showMessageDialog(null, s);
						Connection conn =DriverManager.getConnection("jdbc:sqlite:print.sqlite"); 
						Statement st = conn.createStatement();
						String sql = "ALTER TABLE '"+s+"' add '"+choice+"' Text";
						st.executeUpdate(sql);
						st.close();
				
			  			}
						
						catch(Exception e1)
						{
							e1.printStackTrace();
						}
				
				
				 }
			}
		});
		btnNewButton.setBounds(10, 363, 128, 23);
		contentPanel.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Add New Lab");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				JTextField lab= new JTextField();
			
				lab.requestFocusInWindow();
				  JComponent[] inputs = new JComponent[] {
				        new JLabel("Lab Name"),
				        	lab,
				        	
				      
				        
				      
				};
				int result = JOptionPane.showConfirmDialog(null, inputs, "Enter New Lab here", JOptionPane.PLAIN_MESSAGE);
				if (result == JOptionPane.OK_OPTION) {
					
					
					try{
						Connection conn =DriverManager.getConnection("jdbc:ucanaccess://bansal.accdb");  
						String query1="Insert into lab_record  (lab) values(?)";
						PreparedStatement pst = conn.prepareStatement(query1);
						pst.setString(1, lab.getText());
						
						
						pst.execute();
						pst.close();
						JOptionPane.showMessageDialog(null, "A New Service Added Succesfully !");
						
						
						}
					catch(Exception e1)
					{
						JOptionPane.showMessageDialog(null, e1);
					}
					data1();
				}
			
			}
		});
		btnNewButton_1.setBounds(10, 11, 156, 23);
		contentPanel.add(btnNewButton_1);
		
		data1();
		
	}
	public void data1()
	{
		
		
			
			try
			{
																	
				Connection conn =DriverManager.getConnection("jdbc:ucanaccess://bansal.accdb");
				String query= "select *  from  lab_record ";
				PreparedStatement statement= conn.prepareStatement(query);
				ResultSet rs=statement.executeQuery();
				lab_name.setModel(DbUtils.resultSetToTableModel(rs));
				rs.close();
				statement.close();
				
			}
			catch(SQLException e1)
			{
					e1.printStackTrace();
			}
			
		
	}

}
