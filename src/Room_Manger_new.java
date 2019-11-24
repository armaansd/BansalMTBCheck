import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;
import java.awt.Color;
import java.awt.Desktop;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Room_Manger_new {

	private JFrame frame;
	Connection conn=null;
	
	
	JLabel d1,lb01,lb02,lb03,icu1,icu2,ecg;
	JLabel lb101A,lb101B,lb102A,lb102B,lb102C,lb103,lb104,lb105;
	JLabel lb201A,lb201B,lb202A,lb202B,lb202C,lb203,lb204,lb205,lb206,lb207A,lb207B,lb207C,lb207D,lb207E,lb208A,lb208B,lb209,lb210;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Room_Manger_new window = new Room_Manger_new();
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
	public Room_Manger_new() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 791, 540);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 255, 0), 3));
		panel.setBounds(10, 11, 215, 417);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		d1 = new JLabel("D1");
		d1.setBackground(Color.GREEN);
		d1.setOpaque(true);
		d1.setForeground(new Color(0, 0, 0));
		d1.setFont(new Font("Tahoma", Font.BOLD, 14));
		d1.setHorizontalAlignment(SwingConstants.CENTER);
		d1.setBounds(10, 11, 86, 107);
		panel.add(d1);
		
		lb01 = new JLabel("01");
		lb01.setOpaque(true);
		lb01.setHorizontalAlignment(SwingConstants.CENTER);
		lb01.setForeground(Color.BLACK);
		lb01.setFont(new Font("Tahoma", Font.BOLD, 14));
		lb01.setBackground(Color.GREEN);
		lb01.setBounds(119, 11, 86, 107);
		panel.add(lb01);
		
		lb02 = new JLabel("02");
		lb02.setOpaque(true);
		lb02.setHorizontalAlignment(SwingConstants.CENTER);
		lb02.setForeground(Color.BLACK);
		lb02.setFont(new Font("Tahoma", Font.BOLD, 14));
		lb02.setBackground(Color.GREEN);
		lb02.setBounds(10, 131, 86, 107);
		panel.add(lb02);
		
		lb03 = new JLabel("03");
		lb03.setOpaque(true);
		lb03.setHorizontalAlignment(SwingConstants.CENTER);
		lb03.setForeground(Color.BLACK);
		lb03.setFont(new Font("Tahoma", Font.BOLD, 14));
		lb03.setBackground(Color.GREEN);
		lb03.setBounds(119, 131, 86, 107);
		panel.add(lb03);
		
		icu1 = new JLabel("ICU1");
		icu1.setOpaque(true);
		icu1.setHorizontalAlignment(SwingConstants.CENTER);
		icu1.setForeground(Color.BLACK);
		icu1.setFont(new Font("Tahoma", Font.BOLD, 14));
		icu1.setBackground(Color.GREEN);
		icu1.setBounds(10, 247, 86, 107);
		panel.add(icu1);
		
		icu2 = new JLabel("ICU2");
		icu2.setOpaque(true);
		icu2.setHorizontalAlignment(SwingConstants.CENTER);
		icu2.setForeground(Color.BLACK);
		icu2.setFont(new Font("Tahoma", Font.BOLD, 14));
		icu2.setBackground(Color.GREEN);
		icu2.setBounds(119, 247, 86, 107);
		panel.add(icu2);
		
		ecg = new JLabel("ECG");
		ecg.setOpaque(true);
		ecg.setFont(new Font("Tahoma", Font.BOLD, 14));
		ecg.setBackground(Color.GREEN);
		ecg.setHorizontalAlignment(SwingConstants.CENTER);
		ecg.setBounds(10, 358, 195, 48);
		panel.add(ecg);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new LineBorder(new Color(0, 255, 0), 3));
		panel_1.setBounds(235, 11, 209, 417);
		frame.getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		lb101A = new JLabel("101 A");
		lb101A.setOpaque(true);
		lb101A.setHorizontalAlignment(SwingConstants.CENTER);
		lb101A.setForeground(Color.BLACK);
		lb101A.setFont(new Font("Tahoma", Font.BOLD, 14));
		lb101A.setBackground(Color.GREEN);
		lb101A.setBounds(10, 11, 86, 107);
		panel_1.add(lb101A);
		
		lb101B = new JLabel("101 B");
		lb101B.setOpaque(true);
		lb101B.setHorizontalAlignment(SwingConstants.CENTER);
		lb101B.setForeground(Color.BLACK);
		lb101B.setFont(new Font("Tahoma", Font.BOLD, 14));
		lb101B.setBackground(Color.GREEN);
		lb101B.setBounds(106, 11, 86, 107);
		panel_1.add(lb101B);
		
		lb102A = new JLabel("102 A");
		lb102A.setOpaque(true);
		lb102A.setHorizontalAlignment(SwingConstants.CENTER);
		lb102A.setForeground(Color.BLACK);
		lb102A.setFont(new Font("Tahoma", Font.BOLD, 14));
		lb102A.setBackground(Color.GREEN);
		lb102A.setBounds(10, 129, 86, 107);
		panel_1.add(lb102A);
		
		lb102B = new JLabel("102 B");
		lb102B.setOpaque(true);
		lb102B.setHorizontalAlignment(SwingConstants.CENTER);
		lb102B.setForeground(Color.BLACK);
		lb102B.setFont(new Font("Tahoma", Font.BOLD, 14));
		lb102B.setBackground(Color.GREEN);
		lb102B.setBounds(106, 129, 86, 107);
		panel_1.add(lb102B);
		
		lb102C = new JLabel("102 C");
		lb102C.setOpaque(true);
		lb102C.setHorizontalAlignment(SwingConstants.CENTER);
		lb102C.setForeground(Color.BLACK);
		lb102C.setFont(new Font("Tahoma", Font.BOLD, 14));
		lb102C.setBackground(Color.GREEN);
		lb102C.setBounds(10, 247, 86, 84);
		panel_1.add(lb102C);
		
		lb103 = new JLabel("103");
		lb103.setOpaque(true);
		lb103.setHorizontalAlignment(SwingConstants.CENTER);
		lb103.setForeground(Color.BLACK);
		lb103.setFont(new Font("Tahoma", Font.BOLD, 14));
		lb103.setBackground(Color.GREEN);
		lb103.setBounds(106, 247, 86, 84);
		panel_1.add(lb103);
		
		lb104 = new JLabel("104");
		lb104.setOpaque(true);
		lb104.setHorizontalAlignment(SwingConstants.CENTER);
		lb104.setFont(new Font("Tahoma", Font.BOLD, 14));
		lb104.setBackground(Color.GREEN);
		lb104.setBounds(10, 338, 86, 68);
		panel_1.add(lb104);
		
		lb105 = new JLabel("105");
		lb105.setOpaque(true);
		lb105.setHorizontalAlignment(SwingConstants.CENTER);
		lb105.setFont(new Font("Tahoma", Font.BOLD, 14));
		lb105.setBackground(Color.GREEN);
		lb105.setBounds(106, 338, 86, 68);
		panel_1.add(lb105);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new LineBorder(new Color(0, 255, 0), 3));
		panel_2.setBounds(454, 11, 311, 417);
		frame.getContentPane().add(panel_2);
		panel_2.setLayout(null);
		
		lb201A = new JLabel("201 A");
		lb201A.setOpaque(true);
		lb201A.setHorizontalAlignment(SwingConstants.CENTER);
		lb201A.setFont(new Font("Tahoma", Font.BOLD, 14));
		lb201A.setBackground(Color.GREEN);
		lb201A.setBounds(10, 11, 147, 35);
		panel_2.add(lb201A);
		
		lb202A = new JLabel("202 A");
		lb202A.setOpaque(true);
		lb202A.setHorizontalAlignment(SwingConstants.CENTER);
		lb202A.setFont(new Font("Tahoma", Font.BOLD, 14));
		lb202A.setBackground(Color.GREEN);
		lb202A.setBounds(10, 57, 147, 35);
		panel_2.add(lb202A);
		
		lb202C = new JLabel("202 C");
		lb202C.setOpaque(true);
		lb202C.setHorizontalAlignment(SwingConstants.CENTER);
		lb202C.setFont(new Font("Tahoma", Font.BOLD, 14));
		lb202C.setBackground(Color.GREEN);
		lb202C.setBounds(10, 103, 147, 35);
		panel_2.add(lb202C);
		
		lb203 = new JLabel("203");
		lb203.setOpaque(true);
		lb203.setHorizontalAlignment(SwingConstants.CENTER);
		lb203.setFont(new Font("Tahoma", Font.BOLD, 14));
		lb203.setBackground(Color.GREEN);
		lb203.setBounds(167, 103, 134, 35);
		panel_2.add(lb203);
		
		lb205 = new JLabel("205");
		lb205.setOpaque(true);
		lb205.setHorizontalAlignment(SwingConstants.CENTER);
		lb205.setFont(new Font("Tahoma", Font.BOLD, 14));
		lb205.setBackground(Color.GREEN);
		lb205.setBounds(167, 149, 134, 35);
		panel_2.add(lb205);
		
		lb207A = new JLabel("207 A");
		lb207A.setOpaque(true);
		lb207A.setHorizontalAlignment(SwingConstants.CENTER);
		lb207A.setFont(new Font("Tahoma", Font.BOLD, 14));
		lb207A.setBackground(Color.GREEN);
		lb207A.setBounds(164, 195, 137, 35);
		panel_2.add(lb207A);
		
		lb207C = new JLabel("207 C");
		lb207C.setOpaque(true);
		lb207C.setHorizontalAlignment(SwingConstants.CENTER);
		lb207C.setFont(new Font("Tahoma", Font.BOLD, 14));
		lb207C.setBackground(Color.GREEN);
		lb207C.setBounds(167, 241, 134, 35);
		panel_2.add(lb207C);
		
		lb208A = new JLabel("208 A");
		lb208A.setOpaque(true);
		lb208A.setHorizontalAlignment(SwingConstants.CENTER);
		lb208A.setFont(new Font("Tahoma", Font.BOLD, 14));
		lb208A.setBackground(Color.GREEN);
		lb208A.setBounds(10, 327, 147, 35);
		panel_2.add(lb208A);
		
		lb209 = new JLabel("209");
		lb209.setOpaque(true);
		lb209.setHorizontalAlignment(SwingConstants.CENTER);
		lb209.setFont(new Font("Tahoma", Font.BOLD, 14));
		lb209.setBackground(Color.GREEN);
		lb209.setBounds(10, 370, 147, 35);
		panel_2.add(lb209);
		
		lb201B = new JLabel("201 B");
		lb201B.setOpaque(true);
		lb201B.setHorizontalAlignment(SwingConstants.CENTER);
		lb201B.setFont(new Font("Tahoma", Font.BOLD, 14));
		lb201B.setBackground(Color.GREEN);
		lb201B.setBounds(167, 11, 134, 35);
		panel_2.add(lb201B);
		
		lb202B = new JLabel("202 B");
		lb202B.setOpaque(true);
		lb202B.setHorizontalAlignment(SwingConstants.CENTER);
		lb202B.setFont(new Font("Tahoma", Font.BOLD, 14));
		lb202B.setBackground(Color.GREEN);
		lb202B.setBounds(167, 57, 134, 35);
		panel_2.add(lb202B);
		
		lb204 = new JLabel("204");
		lb204.setOpaque(true);
		lb204.setHorizontalAlignment(SwingConstants.CENTER);
		lb204.setFont(new Font("Tahoma", Font.BOLD, 14));
		lb204.setBackground(Color.GREEN);
		lb204.setBounds(10, 149, 147, 35);
		panel_2.add(lb204);
		
		lb206 = new JLabel("206");
		lb206.setOpaque(true);
		lb206.setHorizontalAlignment(SwingConstants.CENTER);
		lb206.setFont(new Font("Tahoma", Font.BOLD, 14));
		lb206.setBackground(Color.GREEN);
		lb206.setBounds(10, 195, 147, 35);
		panel_2.add(lb206);
		
		lb207B = new JLabel("207 B");
		lb207B.setOpaque(true);
		lb207B.setHorizontalAlignment(SwingConstants.CENTER);
		lb207B.setFont(new Font("Tahoma", Font.BOLD, 14));
		lb207B.setBackground(Color.GREEN);
		lb207B.setBounds(10, 241, 147, 35);
		panel_2.add(lb207B);
		
		lb207D = new JLabel("207 D");
		lb207D.setOpaque(true);
		lb207D.setHorizontalAlignment(SwingConstants.CENTER);
		lb207D.setFont(new Font("Tahoma", Font.BOLD, 14));
		lb207D.setBackground(Color.GREEN);
		lb207D.setBounds(10, 285, 147, 35);
		panel_2.add(lb207D);
		
		lb207E = new JLabel("207 E");
		lb207E.setOpaque(true);
		lb207E.setHorizontalAlignment(SwingConstants.CENTER);
		lb207E.setFont(new Font("Tahoma", Font.BOLD, 14));
		lb207E.setBackground(Color.GREEN);
		lb207E.setBounds(167, 287, 134, 35);
		panel_2.add(lb207E);
		
		lb208B = new JLabel("208 B");
		lb208B.setOpaque(true);
		lb208B.setHorizontalAlignment(SwingConstants.CENTER);
		lb208B.setFont(new Font("Tahoma", Font.BOLD, 14));
		lb208B.setBackground(Color.GREEN);
		lb208B.setBounds(167, 329, 134, 35);
		panel_2.add(lb208B);
		
		lb210 = new JLabel("210");
		lb210.setOpaque(true);
		lb210.setHorizontalAlignment(SwingConstants.CENTER);
		lb210.setFont(new Font("Tahoma", Font.BOLD, 14));
		lb210.setBackground(Color.GREEN);
		lb210.setBounds(167, 370, 134, 35);
		panel_2.add(lb210);
		
		JLabel lblUnbookedRoom = new JLabel("UNBOOKED ROOM");
		lblUnbookedRoom.setOpaque(true);
		lblUnbookedRoom.setHorizontalAlignment(SwingConstants.CENTER);
		lblUnbookedRoom.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblUnbookedRoom.setBackground(Color.GREEN);
		lblUnbookedRoom.setBounds(10, 433, 147, 27);
		frame.getContentPane().add(lblUnbookedRoom);
		
		JLabel lblBookRoom = new JLabel("BOOK ROOM");
		lblBookRoom.setOpaque(true);
		lblBookRoom.setHorizontalAlignment(SwingConstants.CENTER);
		lblBookRoom.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblBookRoom.setBackground(Color.RED);
		lblBookRoom.setBounds(10, 471, 147, 27);
		frame.getContentPane().add(lblBookRoom);
		
		JLabel lblDe = new JLabel("DEVELOPED BY\r\n\r\n");
		lblDe.setForeground(new Color(178, 34, 34));
		lblDe.setOpaque(true);
		lblDe.setHorizontalAlignment(SwingConstants.RIGHT);
		lblDe.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblDe.setBackground(new Color(255, 255, 255));
		lblDe.setBounds(167, 471, 171, 27);
		frame.getContentPane().add(lblDe);
		
		JLabel lblMultitechBullsSoftware = new JLabel("  MULTITECH BULLS SOFTWARE TECHNOLOGIES PVT. LTD.");
		lblMultitechBullsSoftware.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
				try {
					Desktop.getDesktop().browse(new URI("http://www.mtbtechnologies.com"));
				} catch (IOException | URISyntaxException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
			
		});
		lblMultitechBullsSoftware.setOpaque(true);
		lblMultitechBullsSoftware.setHorizontalAlignment(SwingConstants.CENTER);
		lblMultitechBullsSoftware.setForeground(new Color(178, 34, 34));
		lblMultitechBullsSoftware.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblMultitechBullsSoftware.setBackground(Color.WHITE);
		lblMultitechBullsSoftware.setBounds(320, 471, 445, 27);
		frame.getContentPane().add(lblMultitechBullsSoftware);
		
		check();
	}
	
	public void check()
	{
		try { 
			conn =DriverManager.getConnection("jdbc:ucanaccess://bansal.accdb"); 
			 Statement statement = conn.createStatement();
             String query = "SELECT * FROM  book_room1  ";
             ResultSet rs = statement.executeQuery(query);

            while (rs.next())
            {      
               
            	String s,s11;            	
            	s = (rs.getString("room_no"));
            	s11 = rs.getString("status");
            	
            	
            	switch (s) {
				case "D1":
					if(s11.equals("BOOK"))
					{
						d1.setBackground(Color.red);
					}
					else
					{
						d1.setBackground(Color.GREEN);
					}
					break;
					
					
				case "01":
					if(s11.equals("BOOK"))
					{
						lb01.setBackground(Color.red);
					}
					else
					{
						lb01.setBackground(Color.GREEN);
					}
					break;
					
					
					
				case "02":
					if(s11.equals("BOOK"))
					{
						lb02.setBackground(Color.red);
					}
					else
					{
						lb02.setBackground(Color.GREEN);
					}
					break;
					
					
				case "03":
					if(s11.equals("BOOK"))
					{
						lb03.setBackground(Color.red);
					}
					else
					{
						lb03.setBackground(Color.GREEN);
					}
					break;
					
					
				case "ICU1":
					if(s11.equals("BOOK"))
					{
						icu1.setBackground(Color.red);
					}
					else
					{
						icu1.setBackground(Color.GREEN);
					}
					break;
					
					
				case "ICU2":
					if(s11.equals("BOOK"))
					{
						icu2.setBackground(Color.red);
					}
					else
					{
						icu2.setBackground(Color.GREEN);
					}
					break;
					
				case "ECG":
					if(s11.equals("BOOK"))
					{
						ecg.setBackground(Color.red);
					}
					else
					{
						ecg.setBackground(Color.GREEN);
					}
					break;
					
				case "101A":
					if(s11.equals("BOOK"))
					{
						lb101A.setBackground(Color.red);
					}
					else
					{
						lb101A.setBackground(Color.GREEN);
					}
					break;
					
					
				case "101B":
					if(s11.equals("BOOK"))
					{
						lb101B.setBackground(Color.red);
					}
					else
					{
						lb101B.setBackground(Color.GREEN);
					}
					break;
					
				case "102A":
					if(s11.equals("BOOK"))
					{
						lb102A.setBackground(Color.red);
					}
					else
					{
						lb102A.setBackground(Color.GREEN);
					}
					break;
					
				case "102B":
					if(s11.equals("BOOK"))
					{
						lb102B.setBackground(Color.red);
					}
					else
					{
						lb101B.setBackground(Color.GREEN);
					}
					break;
					
				case "102C":
					if(s11.equals("BOOK"))
					{
						lb102C.setBackground(Color.red);
					}
					else
					{
						lb102C.setBackground(Color.GREEN);
					}
					break;
					
					
				case "103":
					if(s11.equals("BOOK"))
					{
						lb103.setBackground(Color.red);
					}
					else
					{
						lb103.setBackground(Color.GREEN);
					}
					break;
					
					
				case "104":
					if(s11.equals("BOOK"))
					{
						lb104.setBackground(Color.red);
					}
					else
					{
						lb104.setBackground(Color.GREEN);
					}
					break;
					
					
				case "105":
					if(s11.equals("BOOK"))
					{
						lb105.setBackground(Color.red);
					}
					else
					{
						lb105.setBackground(Color.GREEN);
					}
					break;
					
				case "201A":
					if(s11.equals("BOOK"))
					{
						lb201A.setBackground(Color.red);
					}
					else
					{
						lb201A.setBackground(Color.GREEN);
					}
					break;
					
				case "201B":
					if(s11.equals("BOOK"))
					{
						lb201B.setBackground(Color.red);
					}
					else
					{
						lb201B.setBackground(Color.GREEN);
					}
					break;
					
				case "202A":
					if(s11.equals("BOOK"))
					{
						lb202A.setBackground(Color.red);
					}
					else
					{
						lb202A.setBackground(Color.GREEN);
					}
					break;
					
				case "202B":
					if(s11.equals("BOOK"))
					{
						lb202B.setBackground(Color.red);
					}
					else
					{
						lb202B.setBackground(Color.GREEN);
					}
					break;
					
					
				case "202C":
					if(s11.equals("BOOK"))
					{
						lb202C.setBackground(Color.red);
					}
					else
					{
						lb202C.setBackground(Color.GREEN);
					}
					break;
					
				case "203":
					if(s11.equals("BOOK"))
					{
						lb203.setBackground(Color.red);
					}
					else
					{
						lb203.setBackground(Color.GREEN);
					}
					break;
					
				case "204":
					if(s11.equals("BOOK"))
					{
						lb204.setBackground(Color.red);
					}
					else
					{
						lb204.setBackground(Color.GREEN);
					}
					break;
					
				case "205":
					if(s11.equals("BOOK"))
					{
						lb205.setBackground(Color.red);
					}
					else
					{
						lb205.setBackground(Color.GREEN);
					}
					break;
					
					
				case "206":
					if(s11.equals("BOOK"))
					{
						lb206.setBackground(Color.red);
					}
					else
					{
						lb206.setBackground(Color.GREEN);
					}
					break;
				
				case "207A":
					if(s11.equals("BOOK"))
					{
						lb207A.setBackground(Color.red);
					}
					else
					{
						lb207A.setBackground(Color.GREEN);
					}
					break;
					
				case "207B":
					if(s11.equals("BOOK"))
					{
						lb207B.setBackground(Color.red);
					}
					else
					{
						lb207B.setBackground(Color.GREEN);
					}
					break;
					
				case "207C":
					if(s11.equals("BOOK"))
					{
						lb207C.setBackground(Color.red);
					}
					else
					{
						lb207C.setBackground(Color.GREEN);
					}
					break;
					
				case "207D":
					if(s11.equals("BOOK"))
					{
						lb207D.setBackground(Color.red);
					}
					else
					{
						lb207D.setBackground(Color.GREEN);
					}
					break;
					
				case "207E":
					if(s11.equals("BOOK"))
					{
						lb207E.setBackground(Color.red);
					}
					else
					{
						lb207E.setBackground(Color.GREEN);
					}
					break;
					
				case "208A":
					if(s11.equals("BOOK"))
					{
						lb208A.setBackground(Color.red);
					}
					else
					{
						lb208A.setBackground(Color.GREEN);
					}
					break;
					
				case "208B":
					if(s11.equals("BOOK"))
					{
						lb208B.setBackground(Color.red);
					}
					else
					{
						lb208B.setBackground(Color.GREEN);
					}
					break;
					
				case "209":
					if(s11.equals("BOOK"))
					{
						lb209.setBackground(Color.red);
					}
					else
					{
						lb209.setBackground(Color.GREEN);
					}
					break;
					
				case "210":
					if(s11.equals("BOOK"))
					{
						lb210.setBackground(Color.red);
					}
					else
					{
						lb210.setBackground(Color.GREEN);
					}
					break;
				
				default:
					break;
				}
            	
                
            }//end while
            conn.close();
            } catch (Exception e1) {
                 e1.printStackTrace();
            }
	}
}
