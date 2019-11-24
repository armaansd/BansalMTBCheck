import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;

public class Chat_Box extends JDialog {

	private final JPanel contentPanel = new JPanel();
	JTextArea message,Chat;
	/**
	 * Launch the application.
	 */
	static String username;
	String name,messagge;
	public static void main(String[] args) {
		
		username = args[0];
		try {
			Chat_Box dialog = new Chat_Box();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public Chat_Box() {
		setBounds(100, 100, 543, 471);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(Color.WHITE);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(10, 11, 507, 357);
		contentPanel.add(panel);
		panel.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 135, 487, 215);
		panel.add(scrollPane);
		
		Chat = new JTextArea();
		Chat.setForeground(new Color(100, 149, 237));
		Chat.setFont(new Font("Monospaced", Font.BOLD, 19));
		scrollPane.setViewportView(Chat);
		
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(10, 70, 261, 54);
		panel.add(scrollPane_1);
		
		message = new JTextArea();
		message.setForeground(new Color(100, 149, 237));
		message.setFont(new Font("Monospaced", Font.BOLD, 19));
		scrollPane_1.setViewportView(message);
		
		JLabel userlabel = new JLabel("User");
		userlabel.setText(username);
		userlabel.setFont(new Font("Tahoma", Font.BOLD, 18));
		userlabel.setBounds(10, 11, 208, 25);
		panel.add(userlabel);
		
		JButton btnNewButton = new JButton("Send");
		btnNewButton.setBounds(326, 72, 155, 42);
		panel.add(btnNewButton);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				
				
				try{
					Connection conn =DriverManager.getConnection("jdbc:ucanaccess://bansal.accdb");  
					String query1="Insert into Chat  (user,message) values(?,?)";
					PreparedStatement pst = conn.prepareStatement(query1);
					pst.setString(1, userlabel.getText().toString());
					pst.setString(2, message.getText().toString());
					
					pst.execute();
					pst.close();
					
					
					
					}
				catch(Exception e1)
				{
					JOptionPane.showMessageDialog(null, e1);
				}
				
				message.setText("");
				getdata();
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 18));
		
		
		
		JButton btnGet = new JButton("Get");
		btnGet.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				getdata();
			}
		});
		btnGet.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnGet.setBounds(185, 379, 155, 42);
		contentPanel.add(btnGet);
		
		JButton btnClear = new JButton("Clear");
		btnClear.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnClear.setBounds(350, 379, 155, 42);
		contentPanel.add(btnClear);
		
		
		
		getdata();
	}
	public void getdata()
	{
		
		Chat.setText("");
		try{
			
			Connection conn =DriverManager.getConnection("jdbc:ucanaccess://bansal.accdb");
			String query="Select * from Chat ";
			PreparedStatement pst=conn.prepareStatement(query);
			ResultSet rs=pst.executeQuery();
			while(rs.next())
			{
				
				name=rs.getString("user");
				messagge = rs.getString("message");
				
				
				Chat.append("\n");
				Chat.append(name+":-");
				Chat.append("\n");
				Chat.append(messagge);
				
				
			}
			
			
			rs.close();
			pst.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}
