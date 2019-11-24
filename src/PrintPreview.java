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
import javax.swing.JScrollPane;

public class PrintPreview extends JDialog {

	private final JPanel contentPanel = new JPanel();
	String checkpass;
	boolean flag = false;
	Connection conn = null;
	Connection conn1 = null;
	
	public static void main(String[] args) {
		try {
			PrintPreview dialog = new PrintPreview();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public PrintPreview() {
		conn = SqliteConnection.dbconnector1();
		conn1 =SqliteConnection.dbconnector();
		setBounds(0, 0, 700, 842);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(0, 0, 700, 842);
		contentPanel.add(panel);
		panel.setLayout(null);
		Image img1=new ImageIcon(this.getClass().getResource("/admwb.jpg")).getImage();
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 0, 595, 842);
		panel.add(scrollPane);
		
		JLabel lblNewLabel = new JLabel("");
		scrollPane.setViewportView(lblNewLabel);
		lblNewLabel.setIcon( new ImageIcon(img1));
		
		JButton btnNewButton = new JButton("New button");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				
				lblNewLabel.print(getGraphics());
					System.out.print(true);
					
			}
		});
		btnNewButton.setBounds(601, 11, 89, 23);
		panel.add(btnNewButton);
		
	}
}
