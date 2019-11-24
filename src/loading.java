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

public class loading extends JDialog {

	private final JPanel contentPanel = new JPanel();
	String checkpass;
	boolean flag = false;
	Connection conn = null;
	
	
	public static void main(String[] args) {
		try {
			loading dialog = new loading();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public loading() {
		conn = SqliteConnection.dbconnector1();
		setBounds(100, 100, 827, 1096);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(12, 0, 827, 1096);
		contentPanel.add(panel);
		panel.setLayout(null);
		
		JLabel label3 = new JLabel("");
		label3.setBounds(0,11, 827, 727);
		Image img1=new ImageIcon(this.getClass().getResource("/spinner.gif")).getImage();
		label3.setIcon( new ImageIcon(img1));
		panel.add(label3);
	}
}
