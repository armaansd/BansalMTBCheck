import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JCheckBox;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class user_create {

	public JFrame frame;
	private JTextField user;
	private JTextField password;
	
	JCheckBox appot,ipd,admit,addmission,discharge;
	String apt,ipdd,admitt,add,dis;
	private JCheckBox lab;
	private JCheckBox chckbxService;
	private JCheckBox chckbxRoomManager;
	private JCheckBox chckbxMedicine;
	private JCheckBox chckbxDischarge;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					user_create window = new user_create();
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
	public user_create() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 852, 477);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 11, 816, 405);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblUserName = new JLabel("User Name");
		lblUserName.setForeground(new Color(60, 179, 113));
		lblUserName.setFont(new Font("SansSerif", Font.BOLD, 18));
		lblUserName.setBounds(10, 21, 114, 36);
		panel.add(lblUserName);
		
		JButton btnNewButton = new JButton("Create User");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				
					if(appot.isSelected())
					{
						apt = "yes";
						
					}	
					if(!(appot.isSelected()))
					{
						apt = "no";
						
					}	
					if(ipd.isSelected())
					{
						ipdd = "yes";
					}	
					if(!(ipd.isSelected()))
					{
						ipdd = "no";
					}	
					if(admit.isSelected())
					{
						admitt = "yes";
					}	
					if(!(admit.isSelected()))
					{
						admitt = "no";
					}	
					if(addmission.isSelected())
					{
						add = "yes";
					}	
					if(!(addmission.isSelected()))
					{
						add = "no";
					}	
					if(discharge.isSelected())
					{
						dis = "yes";
					}
					if(!(discharge.isSelected()))
					{
						dis = "no";
					}
				try {
   					Connection conn =DriverManager.getConnection("jdbc:sqlite:print.sqlite"); 
   					String query = "Insert into per (username,password,OPD,IPD,Admit,Admission_summery,Dishcharge_summery) values(?,?,?,?,?,?,?) ";
   					PreparedStatement pst = conn.prepareStatement(query);
   					pst.setString(1, user.getText());
   					pst.setString(2, password.getText());
   					pst.setString(3, apt);
   					pst.setString(4, ipdd);
   					pst.setString(5, admitt);
   					pst.setString(6, add);
   					pst.setString(7, dis);
   					JOptionPane.showMessageDialog(null, "User Created");
   					pst.execute();
   					pst.close();
   					
   					
   				} catch (SQLException e1) {
   					// TODO Auto-generated catch block
   					e1.printStackTrace();
   				}
   	   			
			
				
				
			}
		});
		btnNewButton.setBounds(144, 326, 156, 36);
		panel.add(btnNewButton);
		
		user = new JTextField();
		user.setBounds(134, 21, 166, 36);
		panel.add(user);
		user.setColumns(10);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setForeground(new Color(60, 179, 113));
		lblPassword.setFont(new Font("SansSerif", Font.BOLD, 18));
		lblPassword.setBounds(10, 68, 114, 36);
		panel.add(lblPassword);
		
		password = new JTextField();
		password.setColumns(10);
		password.setBounds(134, 68, 166, 36);
		panel.add(password);
		
		appot = new JCheckBox("Appotiment");
		appot.setFont(new Font("Tahoma", Font.BOLD, 16));
		appot.setBounds(6, 127, 135, 23);
		panel.add(appot);
		
		ipd = new JCheckBox("IPD");
		ipd.setFont(new Font("Tahoma", Font.BOLD, 16));
		ipd.setBounds(6, 162, 135, 23);
		panel.add(ipd);
		
		admit = new JCheckBox("Admit");
		admit.setFont(new Font("Tahoma", Font.BOLD, 16));
		admit.setBounds(6, 199, 135, 23);
		panel.add(admit);
		
		addmission = new JCheckBox("Addmission Summery");
		addmission.setFont(new Font("Tahoma", Font.BOLD, 16));
		addmission.setBounds(6, 235, 210, 23);
		panel.add(addmission);
		
		discharge = new JCheckBox("Discharge Summery'");
		discharge.setFont(new Font("Tahoma", Font.BOLD, 16));
		discharge.setBounds(6, 272, 210, 23);
		panel.add(discharge);
		
		lab = new JCheckBox("Lab");
		lab.setFont(new Font("Tahoma", Font.BOLD, 16));
		lab.setBounds(242, 124, 135, 23);
		panel.add(lab);
		
		chckbxService = new JCheckBox("Service");
		chckbxService.setFont(new Font("Tahoma", Font.BOLD, 16));
		chckbxService.setBounds(242, 162, 135, 23);
		panel.add(chckbxService);
		
		chckbxRoomManager = new JCheckBox("Room Manager");
		chckbxRoomManager.setFont(new Font("Tahoma", Font.BOLD, 16));
		chckbxRoomManager.setBounds(242, 199, 156, 23);
		panel.add(chckbxRoomManager);
		
		chckbxMedicine = new JCheckBox("Medicine");
		chckbxMedicine.setFont(new Font("Tahoma", Font.BOLD, 16));
		chckbxMedicine.setBounds(242, 237, 156, 23);
		panel.add(chckbxMedicine);
		
		chckbxDischarge = new JCheckBox("Discharge");
		chckbxDischarge.setFont(new Font("Tahoma", Font.BOLD, 16));
		chckbxDischarge.setBounds(242, 274, 156, 23);
		panel.add(chckbxDischarge);
	}
}
