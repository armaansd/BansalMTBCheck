import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Image;
import java.awt.Color;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Calendar;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;

import javax.swing.SwingConstants;

public class login extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField user;
	private JPasswordField password;
	String checkpass;
	boolean flag = false;
	Connection conn = null;
	
	
	public static void main(String[] args) {
		try {
			login dialog = new login();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public login() {
		conn = SqliteConnection.dbconnector1();
		setBounds(100, 100, 611, 527);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(12, 16, 579, 461);
		contentPanel.add(panel);
		panel.setLayout(null);
		
		JPanel panel1 = new JPanel();
		panel1.setBackground(Color.WHITE);
		panel1.setBounds(12, 16, 579, 461);
		contentPanel.add(panel1);
		panel1.setVisible(false);
		panel1.setLayout(null);
		
		
		JLabel label4 = new JLabel("");
		label4.setBounds(10, 11, 555, 118);
		Image img2=new ImageIcon(this.getClass().getResource("/spinner.gif")).getImage();
		label4.setIcon( new ImageIcon(img2));
		panel1.add(label4);
		
		JLabel label = new JLabel("User Name");
		label.setForeground(new Color(60, 179, 113));
		label.setFont(new Font("SansSerif", Font.BOLD, 18));
		label.setBounds(161, 176, 114, 48);
		panel.add(label);
		
		user = new JTextField();
		user.setFont(new Font("Trebuchet MS", Font.BOLD, 18));
		user.setColumns(10);
		user.setBounds(285, 176, 166, 48);
		panel.add(user);
		
		JLabel label_1 = new JLabel("Password");
		label_1.setForeground(new Color(60, 179, 113));
		label_1.setFont(new Font("SansSerif", Font.BOLD, 18));
		label_1.setBounds(161, 255, 114, 48);
		panel.add(label_1);
		
		password = new JPasswordField();
		password.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				
				
				
				if(e.getKeyCode()==KeyEvent.VK_ENTER)
				{
					
					String monu=user.getText();
					
					String pass = password.getText();
					
					try { 
							conn =DriverManager.getConnection("jdbc:sqlite:print.sqlite"); 
							Statement statement = conn.createStatement();
							String query = "SELECT password FROM per where username = '"+monu+"' ";
			             ResultSet rs = statement.executeQuery(query);

			            while (rs.next())
			            {      
			               checkpass = rs.getString("password");
			            	
			            }
					
						}
						catch(Exception ee)
						{
							ee.printStackTrace();
						}
						
						if(pass.equals(checkpass))
						{
							
							setVisible(false);
							String val = user.getText();
							String s[] = {val};
							MainPage.main(s);
							
						}	
						else
						{
							
							JOptionPane.showMessageDialog(null, "ENVALID USER NAME AND PASSWORD CONTACT TO ADMIN IF YOU FORGET IT");
						}	
					
					
				}	
				
			}
		});
		password.setEchoChar('.');
		password.setFont(new Font("Tahoma", Font.PLAIN, 18));
		password.setColumns(10);
		password.setBounds(285, 255, 166, 48);
		panel.add(password);
		
		JButton btnNewButton = new JButton("Login");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				String monu=user.getText();
				
				String pass = password.getText();
				
				try { 
						conn =DriverManager.getConnection("jdbc:sqlite:print.sqlite"); 
						Statement statement = conn.createStatement();
						String query = "SELECT password FROM per where username = '"+monu+"' ";
						ResultSet rs = statement.executeQuery(query);

							while (rs.next())
				            {      
				               checkpass = rs.getString("password");
				            	
				            }
				
					}
				catch(Exception e)
				{
					e.printStackTrace();
				}
				
				if(pass.equals(checkpass))
				{
					setVisible(false);
					
					String val = user.getText();
					String s[] = {val};
					loading.main(s);
					MainPage.main(s);
					
				}	
				
				
				
				
			}
		});
		btnNewButton.setBounds(315, 325, 125, 33);
		panel.add(btnNewButton);
		
		JLabel label3 = new JLabel("");
		label3.setBounds(10, 11, 555, 118);
		Image img1=new ImageIcon(this.getClass().getResource("/name.jpg")).getImage();
		label3.setIcon( new ImageIcon(img1));
		panel.add(label3);
		
		JLabel label_2 = new JLabel("DEVELOPED BY MULTITECH BULLS SOFTWARE TECHNOLOGIES PVT. LTD.\r\n");
		label_2.setOpaque(true);
		label_2.setHorizontalAlignment(SwingConstants.CENTER);
		label_2.setForeground(new Color(178, 34, 34));
		label_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		label_2.setBackground(Color.WHITE);
		label_2.setBounds(10, 423, 569, 27);
		panel.add(label_2);
	}
}
