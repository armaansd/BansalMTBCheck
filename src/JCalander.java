import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import com.toedter.calendar.JCalendar;
import java.awt.SystemColor;
import javax.swing.JTextArea;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Color;

public class JCalander {

	 JFrame frame;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				
				
				
				try
				{
					UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
				}
				catch(Exception e)
				{
					
				}
				try {
					JCalander window = new JCalander();
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
	public JCalander() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 876, 466);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JCalendar calendar = new JCalendar();
		calendar.getDayChooser().setSundayForeground(new Color(139, 0, 0));
		calendar.getDayChooser().setForeground(new Color(0, 139, 139));
		calendar.getDayChooser().setDecorationBackgroundColor(new Color(0, 139, 139));
		calendar.getMonthChooser().getComboBox().setFont(new Font("Tahoma", Font.BOLD, 16));
		calendar.getYearChooser().getSpinner().setFont(new Font("Tahoma", Font.BOLD, 16));
		
		calendar.getMonthChooser().getSpinner().setBackground(SystemColor.activeCaption);
		calendar.setBounds(10, 11, 482, 405);
		frame.getContentPane().add(calendar);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(502, 115, 348, 224);
		frame.getContentPane().add(scrollPane);
		
		JTextArea textArea = new JTextArea();
		textArea.setWrapStyleWord(true);
		textArea.setFont(new Font("Monospaced", Font.PLAIN, 20));
		scrollPane.setViewportView(textArea);
		
		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.BOLD, 16));
		textField.setEditable(false);
		textField.setBounds(641, 77, 209, 30);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("Check");
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				
				Date date = calendar.getDate();
				
				DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");  
				String strDate = dateFormat.format(date);
				textField.setText(strDate);
				
				
				textArea.setText("");
				try{
        			Connection conn =DriverManager.getConnection("jdbc:ucanaccess://bansal.accdb"); 
        			String query= "Select *  from  shedual where date = '"+textField.getText()+"' ";
        			PreparedStatement pst=conn.prepareStatement(query);
        			ResultSet rs=pst.executeQuery();
        			while(rs.next())
        			{
        				
        				textArea.setText(rs.getString("shedual"));
        				
        			}
        			
        			
        			
        			rs.close();
        			pst.close();
        		}
        		catch(Exception ee)
        		{
        			JOptionPane.showMessageDialog(null, ee);
        		}
				
			}
		});
		btnNewButton.setBounds(501, 77, 130, 30);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Check Shedual");
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				
				textArea.setText("");
				try{
        			Connection conn =DriverManager.getConnection("jdbc:ucanaccess://bansal.accdb"); 
        			String query= "Select *  from  shedual where date = '"+textField.getText()+"' ";
        			PreparedStatement pst=conn.prepareStatement(query);
        			ResultSet rs=pst.executeQuery();
        			while(rs.next())
        			{
        				
        				textArea.setText(rs.getString("shedual"));
        				
        			}
        			
        			
        			
        			rs.close();
        			pst.close();
        		}
        		catch(Exception ee)
        		{
        			JOptionPane.showMessageDialog(null, ee);
        		}
			}
		});
		btnNewButton_1.setBounds(502, 351, 145, 23);
		frame.getContentPane().add(btnNewButton_1);
		
		JButton btnSave = new JButton("Save");
		btnSave.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try{
					
					Connection conn =DriverManager.getConnection("jdbc:ucanaccess://bansal.accdb"); 
					String query1="Insert into  shedual  (date,shedual) values(?,?)";
					PreparedStatement pst=conn.prepareStatement(query1);	
				
					pst.setString(1, textField.getText());
					pst.setString(2, textArea.getText());
					
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
		btnSave.setBounds(618, 385, 145, 23);
		frame.getContentPane().add(btnSave);
		
		JButton btnUpdate = new JButton("Update");
		btnUpdate.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				try
				{
					Connection conn =DriverManager.getConnection("jdbc:ucanaccess://bansal.accdb");
	   				conn =DriverManager.getConnection("jdbc:ucanaccess://bansal.accdb");
					String query ="Update  shedual set shedual=? where date = '"+textField.getText().toString()+"' "; 
					PreparedStatement ps  = conn.prepareStatement(query);
					
					
					ps.setString(1, textArea.getText().toString());
					
					
					
					ps.executeUpdate();
					ps.close();
					
				
					
				}
				catch(Exception ee)
				{
					ee.printStackTrace();
				}

				
				textArea.setText("");
				try{
        			Connection conn =DriverManager.getConnection("jdbc:ucanaccess://bansal.accdb"); 
        			String query= "Select *  from  shedual where date = '"+textField.getText()+"' ";
        			PreparedStatement pst=conn.prepareStatement(query);
        			ResultSet rs=pst.executeQuery();
        			while(rs.next())
        			{
        				
        				textArea.setText(rs.getString("shedual"));
        				
        			}
        			
        			
        			
        			rs.close();
        			pst.close();
        		}
        		catch(Exception ee)
        		{
        			JOptionPane.showMessageDialog(null, ee);
        		}

			}
		});
		btnUpdate.setBounds(720, 350, 130, 23);
		frame.getContentPane().add(btnUpdate);
	}
}
