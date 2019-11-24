import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.awt.print.PageFormat;
import java.awt.print.Paper;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.security.PrivilegedExceptionAction;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Vector;
import java.util.regex.Pattern;

import javax.print.Doc;
import javax.print.DocFlavor;
import javax.print.DocPrintJob;
import javax.print.PrintException;
import javax.print.PrintService;
import javax.print.PrintServiceLookup;
import javax.print.SimpleDoc;
import javax.sql.ConnectionEvent;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.InputMap;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import java.awt.Color;
import java.awt.Component;

import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.KeyStroke;
import javax.swing.RowFilter;
import javax.swing.border.BevelBorder;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JDialog;

import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.ActionEvent;
import javax.swing.border.EtchedBorder;
import javax.swing.JTable;
import javax.swing.border.SoftBevelBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableRowSorter;

import com.itextpdf.text.Document;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfWriter;
import com.mxrck.autocompleter.TextAutoCompleter;

import jxl.format.Colour;
import net.proteanit.sql.DbUtils;

import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JSeparator;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTabbedPane;
import javax.swing.border.TitledBorder;
import java.awt.Cursor;
import java.awt.Desktop;

import javax.swing.DebugGraphics;
import java.awt.event.MouseAdapter;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.border.LineBorder;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.Canvas;
import java.awt.Button;
import com.toedter.calendar.JDateChooser;
import com.toedter.components.JLocaleChooser;

//import bill_form.BillPrintable;

import com.toedter.calendar.JDayChooser;
import java.awt.GridLayout;
import javax.swing.JSpinner;

public class MainPage extends JFrame{

	public static MainPage frame  ;
	DefaultTableModel jaana,dtm;
	Connection conn=null;
	Connection conn1 =null;
	String checkuhid;
	JPanel panel;
	public JTable table_1;
	String id1,date,time,date1,name1,address1,dept1,consultant1,father1,age1,gender1,mobile1;
	public JButton buttonopd4;
	public JButton buttonopd5;
	int fourthcount=0;
	
	
	
	String rdate;
	String rtime;
	JPopupMenu popupMenu;
	public JPopupMenu popupMenu_1;
	public JTabbedPane Regis;
	public JTextField qty1;
	DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd-MM-yyyy");
	String doc;
	String from,to,ss;
	//TextAutoCompleter ac,ac1;
	String drshabname,drshab;
	String sid,sidd,iteam,tyy,ty;
	public JTextField amoo;
	public JTextField qtyy;
	int  id  = 0;
	int id11 = 0;
	int idd,v;
	public JPanel opd_panel;
	public JTextField rg_no;
	public JTextField name;
	public JTextField fname;
	public JTextField mobile;
	public JTextField city;
	public JTextField state;
	public JTextField age;
	public JTable appottable;
	private Object[] rows;
	private Object[] rows1;
	private Object[] rows2;
	DefaultTableModel model,model1,model2;
	JComboBox sex,sex2;
	TextAutoCompleter ac,ac1,ac2,ac3;
	private JTextField reg;
	private JTextField reg_name;
	private JTextField reg_fname;
	private JTextField reg_mobile;
	private JTextField reg_city;
	private JTextField reg_state;
	private JTextField reg_address;
	private JTextField reg_age;
	String dr,dr1,ttt,tttt;
	int i=0;
	int j= 0;
	String s21;
	String tdate,ttime,tapt;
	JPanel register_panel;
	JButton admitdirect;
	JButton admit;
	JButton admin;
	
	
	
	String smsname; 
	String smscontact; 
	String smsdr;
	
	
	java.util.Date fromm1;
	java.util.Date too1;
	java.util.Date get;
	JComboBox type;
	/**
	 * Launch the application.
	 */
	public static DefaultTableModel buildTableModel(ResultSet rs)
            throws SQLException {

        ResultSetMetaData metaData = rs.getMetaData();

        // names of columns
        Vector<String> columnNames = new Vector<String>();
        int columnCount = metaData.getColumnCount();
        for (int column = 1; column <= columnCount; column++) {
            columnNames.add(metaData.getColumnName(column));
        }

        // data of the table
        Vector<Vector<Object>> data = new Vector<Vector<Object>>();
        while (rs.next()) {
            Vector<Object> vector = new Vector<Object>();
            for (int columnIndex = 1; columnIndex <= columnCount; columnIndex++) {
                vector.add(rs.getObject(columnIndex));
            }
            data.add(vector);
        }

        return new DefaultTableModel(data, columnNames);

    }
	
	
		Calendar cal =new GregorianCalendar();
		int second = cal.get(Calendar.SECOND);
		int minute = cal.get(Calendar.MINUTE);
		int hour = cal.get(Calendar.HOUR);
		private JTable contable;
		private JTextField re_drname;
		private JTextField charge;
		
		String t,t1,t2,t3,t4,t5;
		private JTextField refby;
		private JTextField addres;
		private JTextField rffby;
		private JTextField remark;
		private JTextField uhid;
			
		 public static String convertToIndianCurrency(int v2) {
		        BigDecimal bd = new BigDecimal(v2);
		        long number = bd.longValue();
		        long no = bd.longValue();
		        int decimal = (int) (bd.remainder(BigDecimal.ONE).doubleValue() * 100);
		        int digits_length = String.valueOf(no).length();
		        int i = 0;
		        ArrayList<String> str = new ArrayList<>();
		        HashMap<Integer, String> words = new HashMap<>();
		        words.put(0, "");
		        words.put(1, "One");
		        words.put(2, "Two");
		        words.put(3, "Three");
		        words.put(4, "Four");
		        words.put(5, "Five");
		        words.put(6, "Six");
		        words.put(7, "Seven");
		        words.put(8, "Eight");
		        words.put(9, "Nine");
		        words.put(10, "Ten");
		        words.put(11, "Eleven");
		        words.put(12, "Twelve");
		        words.put(13, "Thirteen");
		        words.put(14, "Fourteen");
		        words.put(15, "Fifteen");
		        words.put(16, "Sixteen");
		        words.put(17, "Seventeen");
		        words.put(18, "Eighteen");
		        words.put(19, "Nineteen");
		        words.put(20, "Twenty");
		        words.put(30, "Thirty");
		        words.put(40, "Forty");
		        words.put(50, "Fifty");
		        words.put(60, "Sixty");
		        words.put(70, "Seventy");
		        words.put(80, "Eighty");
		        words.put(90, "Ninety");
		        String digits[] = {"", "Hundred", "Thousand", "Lakh", "Crore"};
		        while (i < digits_length) {
		            int divider = (i == 2) ? 10 : 100;
		            number = no % divider;
		            no = no / divider;
		            i += divider == 10 ? 1 : 2;
		            if (number > 0) {
		                int counter = str.size();
		                String plural = (counter > 0 && number > 9) ? "s" : "";
		                String tmp = (number < 21) ? words.get(Integer.valueOf((int) number)) + " " + digits[counter] + plural : words.get(Integer.valueOf((int) Math.floor(number / 10) * 10)) + " " + words.get(Integer.valueOf((int) (number % 10))) + " " + digits[counter] + plural;                
		                str.add(tmp);
		            } else {
		                str.add("");
		            }
		        }
		 
		        Collections.reverse(str);
		        String Rupees = String.join(" ", str).trim();
		 
		        String paise = (decimal) > 0 ? " And Paise " + words.get(Integer.valueOf((int) (decimal - decimal % 10))) + " " + words.get(Integer.valueOf((int) (decimal % 10))) : "";
		        return Rupees + paise + " Only";
		    }
		public	static String monu;
		private JTextField remark1;
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			
			
		
			public void run()
		{
				
				
					monu = args[0];
					try 
					{
						try {
				            //here you can put the selected theme class name in JTattoo
				            UIManager.setLookAndFeel("com.jtattoo.plaf.texture.TextureLookAndFeel");
				 
				        } catch (ClassNotFoundException ex) {
				            java.util.logging.Logger.getLogger(AdmitPatient.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
				        } catch (InstantiationException ex) {
				            java.util.logging.Logger.getLogger(AdmitPatient.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
				        } catch (IllegalAccessException ex) {
				            java.util.logging.Logger.getLogger(AdmitPatient.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
				        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
				            java.util.logging.Logger.getLogger(AdmitPatient.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
				        }	    					 
						 frame = new MainPage();
						
					  } 
				catch (Exception e) 
					{
					    e.printStackTrace();
					}
			}
		});
	}

	/**
	 * Create the application.
	 */
	
   
	public MainPage() {
		
		
	
		conn=SqliteConnection.dbconnector();
		conn1=SqliteConnection.dbconnector1();
		
		
		
		 getContentPane().setBackground(Color.WHITE);
		 Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		 setExtendedState(JFrame.MAXIMIZED_BOTH);
	     setBounds(0, 0, screenSize.width, screenSize.height);  
		 setMinimumSize(new Dimension(700, 700));
		 setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE); 
	     setVisible(true);
	     Image Imgh=new ImageIcon(this.getClass().getResource("/logo.png")).getImage();
		 setIconImage(Imgh);
         
         addWindowListener(new WindowListener() {
		
			public void windowOpened(WindowEvent arg0) {}
			public void windowIconified(WindowEvent arg0) {}
			public void windowDeiconified(WindowEvent arg0) {}
			public void windowDeactivated(WindowEvent arg0) {}
			public void windowClosed(WindowEvent arg0) {}
			public void windowActivated(WindowEvent arg0) {}
			public void windowClosing(WindowEvent e) 
			{
				int i=JOptionPane.showConfirmDialog(null, "Save Data before closing, Are you sure to close.");
				if(i==0)
				{
					frame.dispose();
					System.exit(0);
				}
			}	
        });
       
   	//Image Imgh=new ImageIcon(this.getClass().getResource("/LOGO.png")).getImage();
   //	setIconImage(Imgh);
   	setTitle("Bansal Hospital");
   	
   	Regis = new JTabbedPane(JTabbedPane.TOP);
   	Regis.setFont(new Font("Microsoft YaHei UI", Font.BOLD, 18));
   	GroupLayout groupLayout = new GroupLayout(getContentPane());
   	groupLayout.setHorizontalGroup(
   		groupLayout.createParallelGroup(Alignment.LEADING)
   			.addGroup(groupLayout.createSequentialGroup()
   				.addGap(10)
   				.addComponent(Regis)
   				.addGap(10))
   	);
   	groupLayout.setVerticalGroup(
   		groupLayout.createParallelGroup(Alignment.LEADING)
   			.addGroup(groupLayout.createSequentialGroup()
   				.addGap(11)
   				.addComponent(Regis)
   				.addGap(11))
   	);
   	Regis.setBackground(new Color(209, 128, 17));
   	
   	
   	
   	model = new DefaultTableModel();
   	model1 = new DefaultTableModel();
   	model2 = new DefaultTableModel();
	
   	rows = new Object[16];
	rows1 = new Object[16];
	Object[] columns={"Rg.No","Name","Father Name","Mobile","City","State","Address","Sex","Age","Doctor Name","Status","Date","Time","REF BY","REMARK"};
	Object[] columns1={"Rg.No","Name","Father Name","Mobile","City","State","Address","Sex","Age","Doctor Name","Charge","Status","Date","Time","REF BY","REMARK"};
   	model.setColumnIdentifiers(columns);
   	model1.setColumnIdentifiers(columns1);
   	
   	opd_panel = new JPanel();
   	Regis.addTab("Appotiment", null, opd_panel, null);
   	
   	JPanel infopanel = new JPanel();
   	infopanel.setBorder(new LineBorder(new Color(0, 0, 0), 2));
   	infopanel.setBackground(Color.WHITE);
   	
   	JPanel regtable = new JPanel();
   	
   	admitdirect = new JButton("Admit Patient");
   	admitdirect.addActionListener(new ActionListener() {
   		public void actionPerformed(ActionEvent arg0) {
   			
   			
   			
   			frame.dispose();
   			String s[] = {"","","","","","","","","",""};
   			AdmitPatient.main(s);
   		}
   	});
   	admitdirect.setForeground(new Color(0, 0, 128));
   	admitdirect.setFont(new Font("Tahoma", Font.BOLD, 18));
   	
   	JLabel lblDevelopedByMultitech = new JLabel("DEVELOPED BY MULTITECH BULLS SOFTWARE TECHNOLOGIES PVT. LTD.\r\n");
   	lblDevelopedByMultitech.setOpaque(true);
   	lblDevelopedByMultitech.setHorizontalAlignment(SwingConstants.CENTER);
   	lblDevelopedByMultitech.setForeground(new Color(178, 34, 34));
   	lblDevelopedByMultitech.setFont(new Font("Tahoma", Font.BOLD, 14));
   	lblDevelopedByMultitech.setBackground(Color.WHITE);
   	GroupLayout gl_opd_panel = new GroupLayout(opd_panel);
   	gl_opd_panel.setHorizontalGroup(
   		gl_opd_panel.createParallelGroup(Alignment.TRAILING)
   			.addGroup(gl_opd_panel.createSequentialGroup()
   				.addContainerGap()
   				.addGroup(gl_opd_panel.createParallelGroup(Alignment.LEADING)
   					.addComponent(infopanel, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 1305, Short.MAX_VALUE)
   					.addGroup(Alignment.TRAILING, gl_opd_panel.createSequentialGroup()
   						.addComponent(admitdirect, GroupLayout.PREFERRED_SIZE, 197, GroupLayout.PREFERRED_SIZE)
   						.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
   						.addComponent(lblDevelopedByMultitech, GroupLayout.PREFERRED_SIZE, 598, GroupLayout.PREFERRED_SIZE))
   					.addComponent(regtable, GroupLayout.PREFERRED_SIZE, 1296, GroupLayout.PREFERRED_SIZE))
   				.addContainerGap())
   	);
   	gl_opd_panel.setVerticalGroup(
   		gl_opd_panel.createParallelGroup(Alignment.TRAILING)
   			.addGroup(gl_opd_panel.createSequentialGroup()
   				.addContainerGap()
   				.addComponent(infopanel, GroupLayout.PREFERRED_SIZE, 249, GroupLayout.PREFERRED_SIZE)
   				.addGap(18)
   				.addComponent(regtable, GroupLayout.PREFERRED_SIZE, 316, GroupLayout.PREFERRED_SIZE)
   				.addGap(18)
   				.addGroup(gl_opd_panel.createParallelGroup(Alignment.LEADING)
   					.addGroup(gl_opd_panel.createSequentialGroup()
   						.addPreferredGap(ComponentPlacement.RELATED, 37, Short.MAX_VALUE)
   						.addComponent(lblDevelopedByMultitech, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)
   						.addContainerGap())
   					.addGroup(gl_opd_panel.createSequentialGroup()
   						.addGap(18)
   						.addComponent(admitdirect, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
   						.addContainerGap())))
   	);
   	regtable.setLayout(new GridLayout(0, 1, 0, 0));
   	
   	JScrollPane scrollPane = new JScrollPane();
   	regtable.add(scrollPane);
   	
   	
   	appottable = new JTable();
   	appottable.addMouseListener(new MouseAdapter() {
   		@Override
   		public void mouseClicked(MouseEvent arg0) {
   			
   			
   			int i = appottable.getSelectedRow();
   			
   			name.setText(appottable.getValueAt(i, 1).toString());
   			fname.setText(appottable.getValueAt(i, 2).toString());
   			mobile.setText(appottable.getValueAt(i, 3).toString());
   			city.setText(appottable.getValueAt(i, 4).toString());
   			state.setText(appottable.getValueAt(i, 5).toString());
   			addres.setText(appottable.getValueAt(i, 6).toString());
   			sex.setSelectedItem(appottable.getValueAt(i, 7).toString());
   			age.setText(appottable.getValueAt(i, 8).toString());
   			doc =appottable.getValueAt(i, 9).toString();
   			refby.setText(appottable.getValueAt(i, 13).toString());
   			remark1.setText(appottable.getValueAt(i, 14).toString());
   		    tdate = 	appottable.getValueAt(i, 11).toString();
   		    ttime  =	appottable.getValueAt(i, 12).toString();
   			
   			
   			
   			
   			
   			checkuhid = "";
   			try
			{
																	
				      conn =DriverManager.getConnection("jdbc:ucanaccess://bansal.accdb");  
				      Statement statement1 = conn.createStatement();
	    			  String query1=  "select uhid  from uhid where mobile = '"+appottable.getValueAt(i, 3).toString()+"' AND name = '"+appottable.getValueAt(i, 1).toString()+"' ";
	    			  ResultSet rs1 = statement1.executeQuery(query1);
	    			 	while (rs1.next())
			            {  
							
							
							checkuhid = (rs1.getString("uhid"));
														
			            }//end while
			
				rs1.close();
				statement1.close();
				
			}
			catch(SQLException e1)
			{
					e1.printStackTrace();
			}
   			
   			if(checkuhid.equals(null)||checkuhid.equals(""))
   			{
   				uhid();  	
   				
   			}	
   			else
   				
   			{
   				
   				uhid.setText(checkuhid);
    			
   			}	
   			
   			
   		}
   	});
   	appottable.setForeground(new Color(0, 0, 0));
   	appottable.setModel(model);
   	appottable.setBounds(10, 11, 666, 194);
   	appottable.setSelectionForeground(new Color(255, 255, 255));
   	appottable.setSelectionBackground(new Color(51, 204, 255));
   	appottable.setFont(new Font("Tahoma", Font.PLAIN, 16));
   	appottable.setRowHeight(30);
   	scrollPane.setViewportView(appottable);
   	infopanel.setLayout(null);
   	
   	JLabel lblNewLabel = new JLabel("");
   	lblNewLabel.setBounds(635, 5, 46, 14);
   	infopanel.add(lblNewLabel);
   	
   	JLabel lblNewLabel_1 = new JLabel("APT");
   	lblNewLabel_1.setHorizontalAlignment(SwingConstants.LEFT);
   	lblNewLabel_1.setForeground(new Color(60, 179, 113));
   	lblNewLabel_1.setFont(new Font("SansSerif", Font.BOLD, 18));
   	lblNewLabel_1.setBounds(8, 10, 77, 24);
   	infopanel.add(lblNewLabel_1);
   	
   	rg_no = new JTextField();
   	rg_no.setFont(new Font("Tahoma", Font.PLAIN, 22));
   	rg_no.setBounds(71, 11, 107, 33);
   	infopanel.add(rg_no);
   	rg_no.setColumns(10);
   	
   	JLabel lblName = new JLabel("Name");
   	lblName.setForeground(new Color(60, 179, 113));
   	lblName.setFont(new Font("SansSerif", Font.BOLD, 18));
   	lblName.setBounds(8, 58, 69, 24);
   	infopanel.add(lblName);
   	
   	name = new JTextField();
   	
   	name.setFont(new Font("Tahoma", Font.PLAIN, 22));
   	name.addKeyListener(new KeyAdapter() {
   		@Override
   		public void keyPressed(KeyEvent e) {
   			
   			if(e.getKeyCode()==KeyEvent.VK_ENTER)
			{
   				
   				try
   				{
   																		
   					conn =DriverManager.getConnection("jdbc:ucanaccess://bansal.accdb");  
   					 Statement statement1 = conn.createStatement();
   		    			String query1=  "select *  from  uhid where name = '"+name.getText().toString()+"' ";
   		    			 ResultSet rs1 = statement1.executeQuery(query1);
   					 while (rs1.next())
   				            {  
   								
   								
   								fname.setText(rs1.getString("fname"));
   								mobile.setText(rs1.getString("mobile"));
   								city.setText(rs1.getString("city"));
   								state.setText(rs1.getString("state"));
   								addres.setText(rs1.getString("Address"));
   								sex.setSelectedItem(rs1.getString("sex"));
   								age.setText(rs1.getString("age"));
   								state.setText(rs1.getString("state"));
   							
   				            }//end while
   				
   					rs1.close();
   					statement1.close();
   					
   				}
   				catch(SQLException e1)
   				{
   						e1.printStackTrace();
   				}
   				
			}
   			
   		}
   	});
   	ac = new TextAutoCompleter(name);
   	name.setColumns(10);
   	name.setBounds(81, 55, 209, 36);
   	infopanel.add(name);
   	
   	JLabel lblFatherName = new JLabel("Father Name");
   	lblFatherName.setForeground(new Color(60, 179, 113));
   	lblFatherName.setFont(new Font("SansSerif", Font.BOLD, 18));
   	lblFatherName.setBounds(302, 59, 112, 24);
   	infopanel.add(lblFatherName);
   	
   	fname = new JTextField();
   	fname.setFont(new Font("Tahoma", Font.PLAIN, 22));
   	fname.setColumns(10);
   	fname.setBounds(434, 58, 185, 35);
   	infopanel.add(fname);
   	
   	JLabel lblMobileNo = new JLabel("Mobile No:");
   	lblMobileNo.setForeground(new Color(60, 179, 113));
   	lblMobileNo.setFont(new Font("SansSerif", Font.BOLD, 18));
   	lblMobileNo.setBounds(642, 58, 112, 24);
   	infopanel.add(lblMobileNo);
   	
   	mobile = new JTextField();
   	ac2 = new TextAutoCompleter(mobile);
   	mobile.addKeyListener(new KeyAdapter() {
   		@Override
   		public void keyPressed(KeyEvent e) {
   			
   			
   			if(e.getKeyCode()==KeyEvent.VK_ENTER)
			{
   				
   				try
   				{
   																		
   					conn =DriverManager.getConnection("jdbc:ucanaccess://bansal.accdb");  
   					 Statement statement1 = conn.createStatement();
   		    			String query1=  "select *  from "+ttt+" where mobile = '"+mobile.getText().toString()+"' ";
   		    			 ResultSet rs1 = statement1.executeQuery(query1);
   					 while (rs1.next())
   				            
   					 {  
   								
   								
   								fname.setText(rs1.getString("fname"));
   								name.setText(rs1.getString("name"));
   								city.setText(rs1.getString("city"));
   								state.setText(rs1.getString("state"));
   								addres.setText(rs1.getString("Address"));
   								sex.setSelectedItem(rs1.getString("sex"));
   								age.setText(rs1.getString("age"));
   								state.setText(rs1.getString("state"));
   							
   				    }//end while
   				
   					rs1.close();
   					statement1.close();
   					
   				}
   				catch(SQLException e1)
   				{
   						e1.printStackTrace();
   				}
   			
			}
   		}
   	});
   	mobile.setFont(new Font("Tahoma", Font.PLAIN, 22));
   	ac2 = new TextAutoCompleter(mobile);
   	mobile.setColumns(10);
   	mobile.setBounds(753, 57, 185, 33);
   	infopanel.add(mobile);
   	
   	JLabel lblCity = new JLabel("City:");
   	lblCity.setForeground(new Color(60, 179, 113));
   	lblCity.setFont(new Font("SansSerif", Font.BOLD, 18));
   	lblCity.setBounds(10, 99, 46, 42);
   	infopanel.add(lblCity);
   	
   	city = new JTextField();
   	city.setFont(new Font("Tahoma", Font.PLAIN, 22));
   	ac1 = new TextAutoCompleter(city);
   	city.setColumns(10);
   	city.setBounds(82, 98, 209, 43);
   	infopanel.add(city);
   	
   	JLabel lblState = new JLabel("State");
   	lblState.setHorizontalAlignment(SwingConstants.RIGHT);
   	lblState.setForeground(new Color(60, 179, 113));
   	lblState.setFont(new Font("SansSerif", Font.BOLD, 18));
   	lblState.setBounds(301, 100, 113, 24);
   	infopanel.add(lblState);
   	
   	state = new JTextField();
   	state.setFont(new Font("Tahoma", Font.PLAIN, 22));
   	state.setColumns(10);
   	state.setBounds(436, 104, 185, 33);
   	infopanel.add(state);
   	
   	JLabel lblSex = new JLabel("Sex:");
   	lblSex.setForeground(new Color(60, 179, 113));
   	lblSex.setFont(new Font("SansSerif", Font.BOLD, 18));
   	lblSex.setBounds(640, 104, 46, 24);
   	infopanel.add(lblSex);
   	
   	sex = new JComboBox();
   	sex.setForeground(new Color(0, 153, 0));
   	sex.setFont(new Font("SansSerif", Font.PLAIN, 18));
   	sex.setModel(new DefaultComboBoxModel(new String[] {"Male", "Female", "Other"}));
   	sex.setBounds(753, 99, 185, 33);
   	infopanel.add(sex);
   	
   	JLabel lblAgw = new JLabel("Age:");
   	lblAgw.setHorizontalAlignment(SwingConstants.RIGHT);
   	lblAgw.setForeground(new Color(60, 179, 113));
   	lblAgw.setFont(new Font("SansSerif", Font.BOLD, 18));
   	lblAgw.setBounds(988, 58, 46, 24);
   	infopanel.add(lblAgw);
   	
   	age = new JTextField();
   	age.setFont(new Font("Tahoma", Font.PLAIN, 22));
   	age.setColumns(10);
   	age.setBounds(1044, 58, 77, 33);
   	infopanel.add(age);
   	
   	JButton btnNewButton = new JButton("Add Appotiment");
   	btnNewButton.setForeground(new Color(0, 0, 128));
   	btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 18));
   	btnNewButton.addActionListener(new ActionListener() {
   		public void actionPerformed(ActionEvent arg0) {
   			
   			
   			LocalDateTime now = LocalDateTime.now();
   			date = dtf.format(now);
   			
   			Calendar cal =new GregorianCalendar();
   			int second = cal.get(Calendar.SECOND);
   			int minute = cal.get(Calendar.MINUTE);
   			int hour = cal.get(Calendar.HOUR);
   			
   			
   			time = hour+":"+minute+":"+second;
   			
   			rgno();
   			
   			try {
				conn =DriverManager.getConnection("jdbc:ucanaccess://bansal.accdb"); 
				String query = "Insert into  "+ttt+" (rg,name,fname,mobile,city,state,Address,sex,age,status,date,time,doctorname,refby,remark) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?) ";
				PreparedStatement pst = conn.prepareStatement(query);
				pst.setString(1, rg_no.getText());
				pst.setString(2, name.getText());
				pst.setString(3, fname.getText());
				pst.setString(4, mobile.getText());
				pst.setString(5, city.getText());
				pst.setString(6, state.getText());
				pst.setString(7, addres.getText());
				pst.setString(8, sex.getSelectedItem().toString());
				pst.setString(9, age.getText());
				pst.setString(10,"Book");
				pst.setString(11, date);
				pst.setString(12, time);
				pst.setString(13, dr1);
				pst.setString(14, refby.getText());
				pst.setString(15, remark1.getText());
				pst.execute();
				pst.close();
				
				
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
   			
   			
   			
   			
   			rgno();
   			data();
   			sendSMS(String.valueOf(j),name.getText(),mobile.getText(),dr1);
   			//sendSMS(j, smsname,smscontact, smsdr);
   			ac.removeAllItems();
   			ac1.removeAllItems();
   			
   			name.setText("");
   			fname.setText("");
   			mobile.setText("");
   			city.setText("");
   			state.setText("");
   			addres.setText("");
   			age.setText("");
   			refby.setText("---");
   			name();
   			city();
   		
   			
   			
   			
			
   		}
   	});
   	btnNewButton.setBounds(489, 197, 175, 35);
   	infopanel.add(btnNewButton);
   	
   	JLabel refer = new JLabel("Reff");
   	refer.setForeground(new Color(60, 179, 113));
   	refer.setFont(new Font("SansSerif", Font.BOLD, 18));
   	refer.setBounds(10, 152, 69, 32);
   	infopanel.add(refer);
   	
   	refby =  new JTextField();
   	refby.setText("----");
   	refby.setFont(new Font("Tahoma", Font.PLAIN, 22));
   	refby.setColumns(10);
   	refby.setBounds(83, 152, 209, 42);
   	infopanel.add(refby);
   	
   	JLabel label_11 = new JLabel("Address:");
   	label_11.setForeground(new Color(60, 179, 113));
   	label_11.setFont(new Font("SansSerif", Font.BOLD, 18));
   	label_11.setBounds(950, 103, 89, 24);
   	infopanel.add(label_11);
   	
   	addres = new JTextField();
   	addres.setFont(new Font("Tahoma", Font.PLAIN, 22));
   	addres.setColumns(10);
   	addres.setBounds(1043, 101, 167, 33);
   	infopanel.add(addres);
   	
   	JButton UB = new JButton("UB");
   	UB.addActionListener(new ActionListener() {
   		public void actionPerformed(ActionEvent arg0) {
   			
   			dr1 = "Dr.Ujjwal Bansal";
   			dr = UB.getText();
   			ttt = dr.concat("_").concat("OPD");
   			
   			
   			dr = UB.getText();
   			tttt = dr.concat("_").concat("RPD");
   			
   			
   			
   			
   			/*try
	        	{
	        		
	            	
	            	
		            s21 = dr.concat("Account");
		            //JOptionPane.showMessageDialog(null, s21);
		            conn =DriverManager.getConnection("jdbc:ucanaccess://bansal.accdb");  
	  				String query11= "CREATE  TABLE   "+s21+" (Date Text,Party Text,Credit Text,Debit Text,type Text,Narration Text,CBalance Text,Day Text,Tally Text,result Text)";
	  				PreparedStatement pst11=conn.prepareStatement(query11);
	  				pst11.execute();
	  				conn.close();
	  				//JOptionPane.showMessageDialog(null, "Ok");
	  				
	  				
	  			}
	  			catch(Exception e1)
	  			{
	  				e1.printStackTrace();;
	  			}*/
   			
   			mobile();
   			rgno();
   		   	data();
   		   	data1();
   		   	rgno1();
   		
   		}
   	});
   	UB.setOpaque(true);
   	UB.setBackground(Color.PINK);
   	UB.setFont(new Font("Tahoma", Font.BOLD, 22));
   	UB.setBounds(194, 10, 169, 36);
   	infopanel.add(UB);
   	
   	JButton btnBb = new JButton("BB");
   	btnBb.addActionListener(new ActionListener() {
   		public void actionPerformed(ActionEvent arg0) {
   			
   			dr1 = "Dr.Bharti Bansal";
   			dr = btnBb.getText();
   			ttt = dr.concat("_").concat("OPD");
   			
   			
   			tttt = dr.concat("_").concat("RPD");
   			
   			
   			
   			rgno();
   		   	data();
   		   	data1();
   		   	rgno1();
   			
   			
   			try
        	{
        		
            	
            	
	            s21 = dr.concat("Account");
	            //JOptionPane.showMessageDialog(null, s21);
	            conn =DriverManager.getConnection("jdbc:ucanaccess://bansal.accdb");  
  				String query11= "CREATE  TABLE   "+s21+" (Date Text,Party Text,Credit Text,Debit Text,type Text,Narration Text,CBalance Text,Day Text,Tally Text,result Text)";
  				PreparedStatement pst11=conn.prepareStatement(query11);
  				pst11.execute();
  				conn.close();
  				//JOptionPane.showMessageDialog(null, "Ok");
  				
  				
  			}
  			catch(Exception e1)
  			{
  				e1.printStackTrace();;
  			}
   			
   			
   		}
   	});
   	btnBb.setOpaque(true);
   	btnBb.setFont(new Font("Tahoma", Font.BOLD, 22));
   	btnBb.setBackground(Color.BLUE);
   	btnBb.setBounds(401, 10, 169, 36);
   	infopanel.add(btnBb);
   	
   	JButton btnOpb = new JButton("OPB");
   	btnOpb.addActionListener(new ActionListener() {
   		public void actionPerformed(ActionEvent arg0) {
   			
   			dr1 = "Dr.O.P. Bansal";
   			dr = btnOpb.getText();
   			ttt = dr.concat("_").concat("OPD");
   			
   			
   			tttt = dr.concat("_").concat("RPD");
   			
   			rgno();
   		   	data();
   		   	data1();
   		   	rgno1();
   		   	
   		   	
   		   	
   		 try
     	{
     		
         	
         	
	            s21 = dr.concat("Account");
	            //JOptionPane.showMessageDialog(null, s21);
	            conn =DriverManager.getConnection("jdbc:ucanaccess://bansal.accdb");  
				String query11= "CREATE  TABLE   "+s21+" (Date Text,Party Text,Credit Text,Debit Text,type Text,Narration Text,CBalance Text,Day Text,Tally Text,result Text)";
				PreparedStatement pst11=conn.prepareStatement(query11);
				pst11.execute();
				conn.close();
				//JOptionPane.showMessageDialog(null, "Ok");
				
				
			}
			catch(Exception e1)
			{
				e1.printStackTrace();;
			}
   		}
   	});
   	btnOpb.setOpaque(true);
   	btnOpb.setFont(new Font("Tahoma", Font.BOLD, 22));
   	btnOpb.setBackground(Color.GREEN);
   	btnOpb.setBounds(594, 11, 169, 36);
   	infopanel.add(btnOpb);
   	
   	JButton btnJn = new JButton("JN");
   	btnJn.addActionListener(new ActionListener() {
   		public void actionPerformed(ActionEvent arg0) {
   			
   			
   			dr1 = "Dr. Jitender Nagpal";
   			dr = btnJn.getText();
   			ttt = dr.concat("_").concat("OPD");
   			
   			
   			tttt = dr.concat("_").concat("RPD");
   			
   			rgno();
   		   	data();
   		   	data1();
   		   	rgno1();
   		   	
   		   	
   		   	
   		   	
   		 try
     	{
     		
         	
         	
	            s21 = dr.concat("Account");
	            //JOptionPane.showMessageDialog(null, s21);
	            conn =DriverManager.getConnection("jdbc:ucanaccess://bansal.accdb");  
				String query11= "CREATE  TABLE   "+s21+" (Date Text,Party Text,Credit Text,Debit Text,type Text,Narration Text,CBalance Text,Day Text,Tally Text,result Text)";
				PreparedStatement pst11=conn.prepareStatement(query11);
				pst11.execute();
				conn.close();
				//JOptionPane.showMessageDialog(null, "Ok");
				
				
			}
			catch(Exception e1)
			{
				e1.printStackTrace();;
			}
   		}
   	});
   	btnJn.setOpaque(true);
   	btnJn.setFont(new Font("Tahoma", Font.BOLD, 22));
   	btnJn.setBackground(Color.RED);
   	btnJn.setBounds(779, 11, 169, 36);
   	infopanel.add(btnJn);
   	
   	JButton btnAdmit = new JButton("Update");
   	btnAdmit.addActionListener(new ActionListener() {
   		public void actionPerformed(ActionEvent e) {
   			
   			
   			
   			
   			/*JOptionPane.showMessageDialog(null, ttt);
   			JOptionPane.showMessageDialog(null, tdate);
   			JOptionPane.showMessageDialog(null, ttime);*/
   			
   			
	   			
   			try
			{
																	
				conn =DriverManager.getConnection("jdbc:ucanaccess://bansal.accdb");  
				 Statement statement1 = conn.createStatement();
	    			String query1=  "select rg  from "+ttt+" where date = '"+tdate+"' and time = '"+ttime+"' ";
	    			 ResultSet rs1 = statement1.executeQuery(query1);
				 while (rs1.next())
			            {  
							
							
					 		tapt = rs1.getString("rg");
						
			            }//end while
			
				rs1.close();
				statement1.close();
				
			}
			catch(SQLException e1)
			{
					e1.printStackTrace();
			}
   			   			
   			
   			/*try{
				
				Connection conn =DriverManager.getConnection("jdbc:ucanaccess://bansal.accdb"); 
				String query = "DELETE FROM "+ttt+" WHERE rg = '"+tapt+"' ";
				PreparedStatement pst=conn.prepareStatement(query);
	  			pst.executeUpdate();
	  				
	  			}
	  			catch(Exception e1)
	  			{
	  				e1.printStackTrace();;
	  			}
   			
   			*/
   			String date;
   			LocalDateTime now = LocalDateTime.now();
   			date = dtf.format(now);
   			
   			Calendar cal =new GregorianCalendar();
   			int second = cal.get(Calendar.SECOND);
   			int minute = cal.get(Calendar.MINUTE);
   			int hour = cal.get(Calendar.HOUR);
   			
   			
   			String time = hour+":"+minute+":"+second;
   			
   			
   			try {
				conn =DriverManager.getConnection("jdbc:ucanaccess://bansal.accdb"); 
				String query = "update "+ttt+" set name=?,fname=?,mobile=?,city=?,state=?,Address=?,sex=?,age=?,status=?,date=?,time=?,doctorname=?,refby=?,remark=? where rg = '"+tapt+"' ";
				PreparedStatement pst = conn.prepareStatement(query);
			
				pst.setString(1, name.getText());
				pst.setString(2, fname.getText());
				pst.setString(3, mobile.getText());
				pst.setString(4, city.getText());
				pst.setString(5, state.getText());
				pst.setString(6, addres.getText());
				pst.setString(7, sex.getSelectedItem().toString());
				pst.setString(8, age.getText());
				pst.setString(9, "Book");
				pst.setString(10, date);
				pst.setString(11, time);
				pst.setString(12, dr1);
				pst.setString(13, refby.getText());
				pst.setString(14, remark1.getText());
				pst.executeUpdate();
				pst.close();
				
				
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
   			
   			rgno();
   			i=0;
   			j=0;
   			
   			while(model.getRowCount() > 0)
   			{
   				
   				for(i =0; i < model.getRowCount();i++)
   				{
   					model.removeRow(i);
   				}
   			}	
   			
   			
   				
   				date = dtf.format(now);
   			
   			
   			try
   			{
   																	
   				    conn =DriverManager.getConnection("jdbc:ucanaccess://bansal.accdb");  
   				    Statement statement1 = conn.createStatement();
   	    			String query1=  "select *  from  "+ttt+" where date = '"+date+"' order by rg   ";
   	    			 ResultSet rs1 = statement1.executeQuery(query1);
   	    			 while (rs1.next())
   			            {  
   							j = j+1;
   							
   					 		rows[0]= String.valueOf(j);
   							rows[1]= rs1.getString("name");
   							
   							rows[2]= rs1.getString("fname");
   							rows[3]= rs1.getString("mobile");
   							rows[4]= rs1.getString("city");
   							rows[5] = rs1.getString("state");
   							rows[6]= rs1.getString("Address");
   							rows[7]= rs1.getString("sex");
   							rows[8]= rs1.getString("age");
   							rows[9]= rs1.getString("doctorname");
   							rows[10]= rs1.getString("status");
   							rows[11]= rs1.getString("date");	
   							rows[12]= rs1.getString("time");
   							rows[13]= rs1.getString("refby");
   							rows[14]= rs1.getString("remark");
   							String ss = rs1.getString("status");
   							Colour colour = null;
   							model.addRow(rows);
   							
   				
   			            }//end while
   			
   				rs1.close();
   				statement1.close();
   				
   			}
   			catch(SQLException e1)
   			{
   					e1.printStackTrace();
   			}
   			

   			
   			ac.removeAllItems();
   			ac1.removeAllItems();
   			
   			name.setText("");
   			fname.setText("");
   			mobile.setText("");
   			city.setText("");
   			state.setText("");
   			addres.setText("");
   			age.setText("");
   			remark1.setText("---");
   			name();
   			city();
   		
   			
   		}
   	});
   	btnAdmit.setForeground(new Color(0, 0, 128));
   	btnAdmit.setFont(new Font("Tahoma", Font.BOLD, 18));
   	btnAdmit.setBounds(891, 197, 197, 35);
   	infopanel.add(btnAdmit);
   	
   	JLabel lblDate_1 = new JLabel("Date");
   	lblDate_1.setOpaque(true);
   	lblDate_1.setHorizontalAlignment(SwingConstants.RIGHT);
   	lblDate_1.setForeground(new Color(60, 179, 113));
   	lblDate_1.setFont(new Font("Tahoma", Font.BOLD, 16));
   	lblDate_1.setBackground(new Color(255, 255, 255));
   	lblDate_1.setBounds(950, 10, 89, 33);
   	infopanel.add(lblDate_1);
   	
   	JDateChooser dateChooser = new JDateChooser();
   	dateChooser.setDateFormatString("dd-MM-yyyy");
   	dateChooser.setBounds(1044, 5, 200, 33);
   	infopanel.add(dateChooser);
   	
   	JButton btnNewButton_2 = new JButton("Check");
   	btnNewButton_2.addActionListener(new ActionListener() {
   		public void actionPerformed(ActionEvent arg0) {
   			
   			
   			DateFormat fd = new SimpleDateFormat("dd-MM-yyyy");
			
			
			from = fd.format(dateChooser.getDate());
			
			
			while(model.getRowCount() > 0)
			{
				
				for(int i =0; i < model.getRowCount();i++)
				{
					model.removeRow(i);
				}
			}	
			try
			{
																	
				    conn =DriverManager.getConnection("jdbc:ucanaccess://bansal.accdb");  
				    Statement statement1 = conn.createStatement();
	    			String query1=  "select *  from  "+ttt+" where date = '"+from+"' ";
	    			 ResultSet rs1 = statement1.executeQuery(query1);
	    			 while (rs1.next())
			            {  
							j = j+1;
					 		rows[0]= String.valueOf(j);
							rows[1]= rs1.getString("name");
							rows[2]= rs1.getString("fname");
							rows[3]= rs1.getString("mobile");
							rows[4]= rs1.getString("city");
							rows[5] = rs1.getString("state");
							rows[6]= rs1.getString("Address");
							rows[7]= rs1.getString("sex");
							rows[8]= rs1.getString("age");
							rows[9]= rs1.getString("doctorname");
							rows[10]= rs1.getString("status");
							rows[11]= rs1.getString("date");	
							rows[12]= rs1.getString("time");
							rows[13]= rs1.getString("refby");
							String ss = rs1.getString("status");
							Colour colour = null;
							model.addRow(rows);
							
				
			            }//end while
			
				rs1.close();
				statement1.close();
				
			}
			catch(SQLException e1)
			{
					e1.printStackTrace();
			}
			
   			
   		}
   	});
   	btnNewButton_2.setBounds(1156, 55, 139, 36);
   	infopanel.add(btnNewButton_2);
   	
   	JButton btnTransferOpd = new JButton("Transfer OPD");
   	btnTransferOpd.addActionListener(new ActionListener() {
   		public void actionPerformed(ActionEvent arg0) {
   			
   			
			JComboBox  cd2 = (JComboBox) new JComboBox<>();
			
			cd2.addItem("UB");
			cd2.addItem("BB");
			cd2.addItem("JN");
			cd2.addItem("OPB");
			 		
			  JComponent[] inputs = new JComponent[] {
			       
			        	
					 	new JLabel("Choice Doctor to transfer OPD"),
						cd2,
						

			       
			        
			        
			};
			  int result = JOptionPane.showConfirmDialog(null, inputs, "Enter Doctor for Transfer OPD", JOptionPane.PLAIN_MESSAGE);
				if (result == JOptionPane.OK_OPTION) 
				{

					
					
					try
					{
																			
						conn =DriverManager.getConnection("jdbc:ucanaccess://bansal.accdb");  
						 Statement statement1 = conn.createStatement();
			    			String query1=  "select rg  from "+ttt+" where date = '"+tdate+"' and time = '"+ttime+"' ";
			    			 ResultSet rs1 = statement1.executeQuery(query1);
						 while (rs1.next())
					            {  
									
									
							 		tapt = rs1.getString("rg");
								
					            }//end while
					
						rs1.close();
						statement1.close();
						
					}
					catch(SQLException e1)
					{
							e1.printStackTrace();
					}
					
					
					
					try
					{
						conn =DriverManager.getConnection("jdbc:ucanaccess://bansal.accdb"); 
						String query ="Update "+ttt+" set status=? WHERE rg = '"+tapt+"' "; 
						PreparedStatement ps  = conn.prepareStatement(query);
						ps.setString(1, "transfer");
						
						ps.executeUpdate();
						ps.close();
						
						

						
					}
					catch(Exception ee)
					{
						ee.printStackTrace();
					}

					
					
					/*try{
						
						Connection conn =DriverManager.getConnection("jdbc:ucanaccess://bansal.accdb"); 
						String query = "DELETE FROM "+ttt+" WHERE date = '"+tdate+"' AND time = '"+ttime+"'  ";
						PreparedStatement pst=conn.prepareStatement(query);
			  			pst.executeUpdate();
			  			
			  				
			  			}
			  			catch(Exception e1)
			  			{
			  				e1.printStackTrace();;
			  			}*/
					
					

   			
					}
				
				ttt = cd2.getSelectedItem().toString().concat("_OPD");
				tttt = cd2.getSelectedItem().toString().concat("_RPD");
				rgno();
				String date;
	   			LocalDateTime now = LocalDateTime.now();
	   			date = dtf.format(now);
	   			
	   			Calendar cal =new GregorianCalendar();
	   			int second = cal.get(Calendar.SECOND);
	   			int minute = cal.get(Calendar.MINUTE);
	   			int hour = cal.get(Calendar.HOUR);
	   			
	   			
	   			String time = hour+":"+minute+":"+second;
	   			
	   			
	   			try {
					conn =DriverManager.getConnection("jdbc:ucanaccess://bansal.accdb"); 
					String query = "Insert into  "+ttt+" (rg,name,fname,mobile,city,state,Address,sex,age,status,date,time,doctorname,refby,remark) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?) ";
					PreparedStatement pst = conn.prepareStatement(query);
					pst.setString(1, rg_no.getText());
					pst.setString(2, name.getText());
					pst.setString(3, fname.getText());
					pst.setString(4, mobile.getText());
					pst.setString(5, city.getText());
					pst.setString(6, state.getText());
					pst.setString(7, addres.getText());
					pst.setString(8, sex.getSelectedItem().toString());
					pst.setString(9, age.getText());
					pst.setString(10,"Book");
					pst.setString(11, date);
					pst.setString(12, time);
					pst.setString(13, cd2.getSelectedItem().toString());
					pst.setString(14, refby.getText());
					pst.setString(15, remark1.getText());
					pst.execute();
					pst.close();
					
					
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
	   			
	   			rgno();
	   			rgno1();
	   			i=0;
	   			int j=0;
	   			
	   			while(model.getRowCount() > 0)
	   			{
	   				
	   				for(int i =0; i < model.getRowCount();i++)
	   				{
	   					model.removeRow(i);
	   				}
	   			}	
	   			
	   			
	   				
	   				date = dtf.format(now);
	   			
	   			
	   			try
	   			{
	   																	
	   				    conn =DriverManager.getConnection("jdbc:ucanaccess://bansal.accdb");  
	   				    Statement statement1 = conn.createStatement();
	   	    			String query1=  "select *  from  "+ttt+" where date = '"+date+"'order by rg desc  ";
	   	    			 ResultSet rs1 = statement1.executeQuery(query1);
	   	    			 while (rs1.next())
	   			            {  
	   							j = j+1;
	   					 		rows[0]= String.valueOf(j);
	   							rows[1]= rs1.getString("name");
	   							rows[2]= rs1.getString("fname");
	   							rows[3]= rs1.getString("mobile");
	   							rows[4]= rs1.getString("city");
	   							rows[5] = rs1.getString("state");
	   							rows[6]= rs1.getString("Address");
	   							rows[7]= rs1.getString("sex");
	   							rows[8]= rs1.getString("age");
	   							rows[9]= rs1.getString("doctorname");
	   							rows[10]= rs1.getString("status");
	   							rows[11]= rs1.getString("date");	
	   							rows[12]= rs1.getString("time");
	   							rows[13]= rs1.getString("refby");
	   							rows[14]= rs1.getString("remark");
	   							String ss = rs1.getString("status");
	   							Colour colour = null;
	   							model.addRow(rows);
	   							
	   				
	   			            }//end while
	   			
	   				rs1.close();
	   				statement1.close();
	   				
	   			}
	   			catch(SQLException e1)
	   			{
	   					e1.printStackTrace();
	   			}
	   			data1();
	   			ac.removeAllItems();
	   			ac1.removeAllItems();
	   			
	   			name.setText("");
	   			fname.setText("");
	   			mobile.setText("");
	   			city.setText("");
	   			state.setText("");
	   			addres.setText("");
	   			age.setText("");
	   			remark1.setText("---");
	   			name();
	   			city();
	   		
	   		
			
   			
   		}
   	});
   	btnTransferOpd.setForeground(new Color(0, 0, 128));
   	btnTransferOpd.setFont(new Font("Tahoma", Font.BOLD, 18));
   	btnTransferOpd.setBounds(1098, 197, 197, 35);
   	infopanel.add(btnTransferOpd);
   	
   	JButton btnRegister = new JButton("Register");
   	btnRegister.addActionListener(new ActionListener() {
   		public void actionPerformed(ActionEvent arg0) {
   			
   			
			reg_name.setText(name.getText().toString());
   			reg_fname.setText(fname.getText().toString());
   			reg_mobile.setText(mobile.getText().toString());
   			reg_city.setText(city.getText().toString());
   			reg_state.setText(state.getText().toString());
   			reg_address.setText(addres.getText().toString());
   			rffby.setText(refby.getText().toString());
   			sex2.setSelectedItem(sex.getSelectedItem().toString());
   			re_drname.setText(doc);
   			reg_age.setText(age.getText()); 	
   			
   			rgno1();
   			
   			Regis.setSelectedIndex(1);
   			
   		}
   	});
   	btnRegister.setForeground(new Color(0, 0, 128));
   	btnRegister.setFont(new Font("Tahoma", Font.BOLD, 18));
   	btnRegister.setBounds(684, 197, 197, 35);
   	infopanel.add(btnRegister);
   	
   	JLabel lblRemark_1 = new JLabel("Remark");
   	lblRemark_1.setForeground(new Color(60, 179, 113));
   	lblRemark_1.setFont(new Font("SansSerif", Font.BOLD, 18));
   	lblRemark_1.setBounds(10, 198, 69, 32);
   	infopanel.add(lblRemark_1);
   	
   	remark1 = new JTextField();
   	remark1.setText("----");
   	remark1.setFont(new Font("Tahoma", Font.PLAIN, 22));
   	remark1.setColumns(10);
   	remark1.setBounds(83, 198, 209, 42);
   	infopanel.add(remark1);
   	opd_panel.setLayout(gl_opd_panel);
   	
   	register_panel = new JPanel();
   	Regis.addTab("Registration"
   			+ "", null, register_panel, null);
   	
   	JPanel panel_2 = new JPanel();
   	register_panel.add(panel_2);
   	
   	JPanel panel_3 = new JPanel();
   	panel_3.setBorder(new LineBorder(new Color(0, 0, 0), 2));
   	panel_3.setLayout(null);
   	
   	JPanel panel_4 = new JPanel();
   	panel_4.setBorder(new LineBorder(new Color(0, 0, 0), 2));
   	panel_4.setLayout(null);
   	panel_4.setBackground(Color.WHITE);
   	
   	JLabel label = new JLabel("");
   	label.setBounds(635, 5, 46, 14);
   	panel_4.add(label);
   	
   	JLabel lblApdNo = new JLabel("Reg No.");
   	lblApdNo.setForeground(new Color(60, 179, 113));
   	lblApdNo.setFont(new Font("SansSerif", Font.BOLD, 18));
   	lblApdNo.setBounds(10, 11, 98, 24);
   	panel_4.add(lblApdNo);
   	
   	reg = new JTextField();
   	reg.setFont(new Font("Tahoma", Font.PLAIN, 22));
   	reg.setText("1");
   	reg.setColumns(10);
   	reg.setBounds(100, 16, 89, 27);
   	panel_4.add(reg);
   	
   	JLabel label_2 = new JLabel("Name");
   	label_2.setForeground(new Color(60, 179, 113));
   	label_2.setFont(new Font("SansSerif", Font.BOLD, 18));
   	label_2.setBounds(10, 55, 69, 24);
   	panel_4.add(label_2);
   	
   	reg_name = new JTextField();
   	reg_name.addActionListener(new ActionListener() {
   		public void actionPerformed(ActionEvent arg0) {
   		}
   	});
   	reg_name.setFont(new Font("Tahoma", Font.PLAIN, 22));
   	reg_name.setColumns(10);
   	reg_name.setBounds(102, 54, 185, 33);
   	panel_4.add(reg_name);
   	
   	JLabel label_3 = new JLabel("Father Name");
   	label_3.setForeground(new Color(60, 179, 113));
   	label_3.setFont(new Font("SansSerif", Font.BOLD, 18));
   	label_3.setBounds(314, 55, 112, 24);
   	panel_4.add(label_3);
   	
   	reg_fname = new JTextField();
   	reg_fname.setFont(new Font("Tahoma", Font.PLAIN, 22));
   	reg_fname.setColumns(10);
   	reg_fname.setBounds(446, 54, 185, 33);
   	panel_4.add(reg_fname);
   	
   	JLabel label_4 = new JLabel("Mobile No:");
   	label_4.setForeground(new Color(60, 179, 113));
   	label_4.setFont(new Font("SansSerif", Font.BOLD, 18));
   	label_4.setBounds(645, 55, 112, 24);
   	panel_4.add(label_4);
   	
   	reg_mobile = new JTextField();
   	reg_mobile.addKeyListener(new KeyAdapter() {
   		@Override
   		public void keyPressed(KeyEvent arg0) {
   		}
   	});
   	reg_mobile.setColumns(10);
   	reg_mobile.setBounds(756, 54, 185, 33);
   	panel_4.add(reg_mobile);
   	
   	JLabel label_5 = new JLabel("City:");
   	label_5.setForeground(new Color(60, 179, 113));
   	label_5.setFont(new Font("SansSerif", Font.BOLD, 18));
   	label_5.setBounds(951, 55, 46, 24);
   	panel_4.add(label_5);
   	
   	reg_city = new JTextField();
   	reg_city.setColumns(10);
   	reg_city.setBounds(1007, 54, 185, 33);
   	panel_4.add(reg_city);
   	
   	JLabel label_6 = new JLabel("State");
   	label_6.setForeground(new Color(60, 179, 113));
   	label_6.setFont(new Font("SansSerif", Font.BOLD, 18));
   	label_6.setBounds(10, 95, 112, 24);
   	panel_4.add(label_6);
   	
   	reg_state = new JTextField();
   	reg_state.setFont(new Font("Tahoma", Font.PLAIN, 22));
   	reg_state.setColumns(10);
   	reg_state.setBounds(102, 94, 185, 33);
   	panel_4.add(reg_state);
   	
   	JLabel label_7 = new JLabel("Address:");
   	label_7.setForeground(new Color(60, 179, 113));
   	label_7.setFont(new Font("SansSerif", Font.BOLD, 18));
   	label_7.setBounds(314, 103, 112, 24);
   	panel_4.add(label_7);
   	
   	reg_address = new JTextField();
   	reg_address.setFont(new Font("Tahoma", Font.PLAIN, 22));
   	reg_address.setColumns(10);
   	reg_address.setBounds(446, 98, 185, 24);
   	panel_4.add(reg_address);
   	
   	JLabel label_8 = new JLabel("Sex:");
   	label_8.setForeground(new Color(60, 179, 113));
   	label_8.setFont(new Font("SansSerif", Font.BOLD, 18));
   	label_8.setBounds(645, 106, 77, 24);
   	panel_4.add(label_8);
   	
   	sex2 = new JComboBox();
   	sex2.setModel(new DefaultComboBoxModel(new String[] {"Male", "Female", "Other"}));
   	sex2.setForeground(new Color(0, 153, 0));
   	sex2.setFont(new Font("SansSerif", Font.PLAIN, 18));
   	sex2.setBounds(756, 106, 185, 24);
   	panel_4.add(sex2);
   	
   	JLabel label_9 = new JLabel("Age:");
   	label_9.setForeground(new Color(60, 179, 113));
   	label_9.setFont(new Font("SansSerif", Font.BOLD, 18));
   	label_9.setBounds(947, 103, 133, 24);
   	panel_4.add(label_9);
   	
   	reg_age = new JTextField();
   	reg_age.setColumns(10);
   	reg_age.setBounds(1030, 105, 77, 33);
   	panel_4.add(reg_age);
   	
   	JButton button = new JButton("Save");
   	button.addActionListener(new ActionListener() {
   		public void actionPerformed(ActionEvent arg0) {
   			
   			
   			
   			
   			if(type.getSelectedItem().toString().equals("Free"))
   			{
   				try {
   					conn =DriverManager.getConnection("jdbc:ucanaccess://bansal.accdb"); 
   					String query = "Insert into  uhid (uhid,name,fname,mobile,city,state,Address,sex,age) values(?,?,?,?,?,?,?,?,?) ";
   					PreparedStatement pst = conn.prepareStatement(query);
   					pst.setString(1, uhid.getText());
   					pst.setString(2, reg_name.getText());
   					pst.setString(3, reg_fname.getText());
   					pst.setString(4, reg_mobile.getText());
   					pst.setString(5, reg_city.getText());
   					pst.setString(6, reg_state.getText());
   					pst.setString(7, reg_address.getText());
   					pst.setString(8, sex2.getSelectedItem().toString());
   					pst.setString(9, reg_age.getText());
   					
   					pst.execute();
   					pst.close();
   					
   					
   				} catch (SQLException e1) {
   					// TODO Auto-generated catch block
   					//e1.printStackTrace();
   				}
   				
   				uhid();
   			}	
   			else
   			{	
   			rgno1();
   			
   			
   			int dialogResult = JOptionPane.showConfirmDialog (null, "Do You Want to Register This Patient" );
			if(dialogResult == JOptionPane.YES_OPTION){
			
   			if(charge.getText().toString().equals(null)||charge.getText().toString().equals(""))
   			{
   				
   				JOptionPane.showMessageDialog(null, "Charge Feild is Mandatry");
   				
   			}	
   			else
   			{
   	   			LocalDateTime now = LocalDateTime.now();
   	   			date = dtf.format(now);
   	   			
   	   			Calendar cal =new GregorianCalendar();
   	   			int second = cal.get(Calendar.SECOND);
   	   			int minute = cal.get(Calendar.MINUTE);
   	   			int hour = cal.get(Calendar.HOUR);
   	   			
   	   			
   	   			String time = hour+":"+minute+":"+second;
   	   			
   	   			
   	   			try {
   					conn =DriverManager.getConnection("jdbc:ucanaccess://bansal.accdb"); 
   					String query = "Insert into  "+tttt+" (rg,name,fname,mobile,city,state,Address,sex,age,status,date,time,doctorname,charge,refby,remark) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?) ";
   					PreparedStatement pst = conn.prepareStatement(query);
   					pst.setString(1, reg.getText());
   					pst.setString(2, reg_name.getText());
   					pst.setString(3, reg_fname.getText());
   					pst.setString(4, reg_mobile.getText());
   					pst.setString(5, reg_city.getText());
   					pst.setString(6, reg_state.getText());
   					pst.setString(7, reg_address.getText());
   					pst.setString(8, sex2.getSelectedItem().toString());
   					pst.setString(9, reg_age.getText());
   					pst.setString(10,"OPD");
   					pst.setString(11, date);
   					pst.setString(12, time);
   					pst.setString(13, re_drname.getText());
   					pst.setString(14, charge.getText());
   					pst.setString(15, rffby.getText());
   					pst.setString(16, remark.getText());
   					pst.execute();
   					pst.close();
   					
   					
   				} catch (SQLException e1) {
   					// TODO Auto-generated catch block
   					e1.printStackTrace();
   				}
   	   			
   	   		try
			{
																	
				conn =DriverManager.getConnection("jdbc:ucanaccess://bansal.accdb");  
				 Statement statement1 = conn.createStatement();
	    			String query1=  "select rg  from "+ttt+" where date = '"+tdate+"' and time = '"+ttime+"' ";
	    			 ResultSet rs1 = statement1.executeQuery(query1);
				 while (rs1.next())
			            {  
							
							
					 		tapt = rs1.getString("rg");
						
			            }//end while
			
				rs1.close();
				statement1.close();
				
						}
			catch(SQLException e1)
			{
					e1.printStackTrace();
			}
			
			
   	   			try
   				{
   					conn =DriverManager.getConnection("jdbc:ucanaccess://bansal.accdb"); 
   					String query ="Update "+ttt+" set status=?where rg = '"+tapt+"' "; 
   					PreparedStatement ps  = conn.prepareStatement(query);
   					ps.setString(1, "Register");
   					
   					ps.executeUpdate();
   					ps.close();
   					
   				}
   				catch(Exception ee)
   				{
   					ee.printStackTrace();
   				}
   	   			
   	   			
   	   			
   	   			
   	   			try
   	        	{
   	        		
   	            	
   	            	
   		            s21 = dr.concat("Account");
   		            JOptionPane.showMessageDialog(null, s21);
   		            conn =DriverManager.getConnection("jdbc:ucanaccess://bansal.accdb");  
   	  				String query11= "CREATE  TABLE   "+s21+" (Date Text,Party Text,Credit Text,Debit Text,type Text,Narration Text,CBalance Text,Day Text,Tally Text,result Text)";
   	  				PreparedStatement pst11=conn.prepareStatement(query11);
   	  				pst11.execute();
   	  				conn.close();
   	  				//JOptionPane.showMessageDialog(null, "Ok");
   	  				
   	  				
   	  			}
   	  			catch(Exception e1)
   	  			{
   	  				e1.printStackTrace();;
   	  			}
   			
   	   			
   	   			try {
   	   				conn =DriverManager.getConnection("jdbc:ucanaccess://bansal.accdb"); 
   					String query = "Insert into "+s21+" (Date,Party,Credit,Debit,Day,Narration,type) values(?,?,?,?,?,?,?) ";
   					PreparedStatement pst = conn.prepareStatement(query);
   					pst.setString(1,  date.concat("    ").concat(time));
   					pst.setString(2, reg_name.getText());
   					pst.setString(3, charge.getText());
   					pst.setString(4, "0.0");
   					pst.setString(5, "Manual Entry");
   					pst.setString(6, "OPD");
   					pst.setString(7, "OPD");
   					pst.execute();
   					pst.close();
   					
   					
   					JOptionPane.showMessageDialog(null, "OPD Charge Has Been Successfully Credit In "+re_drname.getText().concat(" ").concat("Account"));
   					
   				} catch (SQLException e1) {
   					// TODO Auto-generated catch block
   					e1.printStackTrace();
   				}
   				
   	   			
   	   			
   	   			printopd();
   	   			rgno();
   	   		   	data();
   	   		   	data1();
   	   		   	rgno1();
   	   		   	
   	   		   	
   	   		   	
   	   		 	
   				try {
   					conn =DriverManager.getConnection("jdbc:ucanaccess://bansal.accdb"); 
   					String query = "Insert into  uhid (uhid,name,fname,mobile,city,state,Address,sex,age) values(?,?,?,?,?,?,?,?,?) ";
   					PreparedStatement pst = conn.prepareStatement(query);
   					pst.setString(1, uhid.getText());
   					pst.setString(2, reg_name.getText());
   					pst.setString(3, reg_fname.getText());
   					pst.setString(4, reg_mobile.getText());
   					pst.setString(5, reg_city.getText());
   					pst.setString(6, reg_state.getText());
   					pst.setString(7, reg_address.getText());
   					pst.setString(8, sex2.getSelectedItem().toString());
   					pst.setString(9, reg_age.getText());
   					
   					pst.execute();
   					pst.close();
   					
   					
   				} catch (SQLException e1) {
   					// TODO Auto-generated catch block
   					//e1.printStackTrace();
   				}
   				
   				uhid();
   				
   				ac.removeAllItems();
   				ac1.removeAllItems();

   				name.setText("");
   				fname.setText("");
   				mobile.setText("");
   				city.setText("");
   				state.setText("");
   				addres.setText("");
   				age.setText("");
   				
   				name();
   				city();
   			}	
			}
   		}}
   	});
   	button.setBounds(389, 182, 112, 23);
   	panel_4.add(button);
   	
   	JButton btnPrint = new JButton("Print");
   	btnPrint.addActionListener(new ActionListener() {
   		public void actionPerformed(ActionEvent arg0) {
   			
   			String arr[] = {"NN"};
   			REPORT.main(arr);
   		}
   	});
   	btnPrint.setForeground(new Color(0, 0, 128));
   	btnPrint.setFont(new Font("Tahoma", Font.BOLD, 18));
   	GroupLayout gl_panel_2 = new GroupLayout(panel_2);
   	gl_panel_2.setHorizontalGroup(
   		gl_panel_2.createParallelGroup(Alignment.TRAILING)
   			.addGroup(gl_panel_2.createSequentialGroup()
   				.addGroup(gl_panel_2.createParallelGroup(Alignment.LEADING)
   					.addGroup(gl_panel_2.createSequentialGroup()
   						.addContainerGap()
   						.addGroup(gl_panel_2.createParallelGroup(Alignment.TRAILING)
   							.addComponent(panel_3, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 1317, Short.MAX_VALUE)
   							.addComponent(panel_4, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 1317, Short.MAX_VALUE)))
   					.addGroup(gl_panel_2.createSequentialGroup()
   						.addGap(480)
   						.addComponent(btnPrint, GroupLayout.PREFERRED_SIZE, 197, GroupLayout.PREFERRED_SIZE)))
   				.addContainerGap())
   	);
   	gl_panel_2.setVerticalGroup(
   		gl_panel_2.createParallelGroup(Alignment.LEADING)
   			.addGroup(gl_panel_2.createSequentialGroup()
   				.addContainerGap()
   				.addComponent(panel_4, GroupLayout.DEFAULT_SIZE, 215, Short.MAX_VALUE)
   				.addGap(18)
   				.addComponent(panel_3, GroupLayout.DEFAULT_SIZE, 320, Short.MAX_VALUE)
   				.addGap(18)
   				.addComponent(btnPrint, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
   				.addGap(35))
   	);
   	
   	JLabel label_10 = new JLabel("Doctor");
   	label_10.setForeground(new Color(60, 179, 113));
   	label_10.setFont(new Font("SansSerif", Font.BOLD, 18));
   	label_10.setBounds(10, 139, 112, 24);
   	panel_4.add(label_10);
   	
   	re_drname = new JTextField();
   	re_drname.setFont(new Font("Tahoma", Font.PLAIN, 22));
   	re_drname.setColumns(10);
   	re_drname.setBounds(102, 138, 185, 33);
   	panel_4.add(re_drname);
   	
   	JLabel lblCharge = new JLabel("Charge");
   	lblCharge.setForeground(new Color(60, 179, 113));
   	lblCharge.setFont(new Font("SansSerif", Font.BOLD, 18));
   	lblCharge.setBounds(314, 139, 112, 24);
   	panel_4.add(lblCharge);
   	
   	charge = new JTextField();
   	charge.selectAll();
   	charge.setFont(new Font("Tahoma", Font.PLAIN, 22));
   	charge.setColumns(10);
   	charge.setBounds(446, 138, 185, 33);
   	panel_4.add(charge);
   	
   	admit = new JButton("Admit");
   	admit.addActionListener(new ActionListener() {
   		public void actionPerformed(ActionEvent e) {
   			
   			
   			int dialogResult = JOptionPane.showConfirmDialog (null, "Do You Want to confirm admit This Patient" );
			if(dialogResult == JOptionPane.YES_OPTION)
			{
				
			String name =  reg_name.getText();
			String fname =  reg_fname.getText();
   			String mobile =  reg_mobile.getText();
   			String city =  reg_city.getText();
   			String state =  reg_state.getText();
   			String address =  reg_address.getText();
   			String sex =  sex2.getSelectedItem().toString();
   			String age =  reg_age.getText();
			
   			String dr =  re_drname.getText();
		
   			String reff =  rffby.getText();
			
   			String arr[] = {name,fname,mobile,city,state,address,sex,age,dr,reff};
			AdmitPatient.main(arr);
   			frame.dispose();
			}
   		}
   	});
   	admit.setBounds(675, 182, 112, 23);
   	panel_4.add(admit);
   	
   	JLabel lblRefby = new JLabel("Reff By");
   	lblRefby.setForeground(new Color(60, 179, 113));
   	lblRefby.setFont(new Font("SansSerif", Font.BOLD, 18));
   	lblRefby.setBounds(643, 142, 112, 24);
   	panel_4.add(lblRefby);
   	
   	rffby = new JTextField();
   	rffby.setText("----");
   	rffby.selectAll();
   	rffby.setFont(new Font("Tahoma", Font.PLAIN, 22));
   	rffby.setColumns(10);
   	rffby.setBounds(756, 141, 185, 33);
   	panel_4.add(rffby);
   	
   	JLabel lblRemark = new JLabel("Remark");
   	lblRemark.setForeground(new Color(60, 179, 113));
   	lblRemark.setFont(new Font("SansSerif", Font.BOLD, 18));
   	lblRemark.setBounds(947, 142, 112, 24);
   	panel_4.add(lblRemark);
   	
   	remark = new JTextField();
   	remark.setText("----");
   	remark.selectAll();
   	remark.setFont(new Font("Tahoma", Font.PLAIN, 22));
   	remark.setColumns(10);
   	remark.setBounds(1030, 141, 185, 33);
   	panel_4.add(remark);
   	
   	admin = new JButton("Admin");
   	admin.addActionListener(new ActionListener() {
   		public void actionPerformed(ActionEvent e) {
   			
   			frame.dispose();
   			Admin_panel window = new Admin_panel();
			window.frame.setVisible(true);
   		}
   	});
   	admin.setBounds(1218, 182, 89, 23);
   	panel_4.add(admin);
   	
   	JLabel label_12 = new JLabel("UHID");
   	label_12.setForeground(new Color(60, 179, 113));
   	label_12.setFont(new Font("SansSerif", Font.BOLD, 18));
   	label_12.setBounds(239, 15, 69, 24);
   	panel_4.add(label_12);
   	
   	uhid = new JTextField();
   	uhid.setText("1");
   	uhid.setFont(new Font("Tahoma", Font.PLAIN, 22));
   	uhid.setColumns(10);
   	uhid.setBounds(296, 11, 89, 40);
   	panel_4.add(uhid);
   	
   	JButton btnUpdateRemark = new JButton("Update Remark");
   	btnUpdateRemark.addActionListener(new ActionListener() {
   		public void actionPerformed(ActionEvent arg0) {
   			
   			
   			try
			{
   				conn =DriverManager.getConnection("jdbc:ucanaccess://bansal.accdb");
				String query ="Update  "+tttt+" set remark = ? where rg = '"+reg.getText().toString()+"' "; 
				PreparedStatement ps  = conn.prepareStatement(query);
				
				
				ps.setString(1, remark.getText().toString());
				
				
				
				ps.executeUpdate();
				ps.close();
				
							
			}
			catch(Exception ee)
			{
				ee.printStackTrace();
			}
   			
   			data();
   		   	data1();
   		   
   			
   		}
   	});
   	btnUpdateRemark.setBounds(522, 182, 133, 23);
   	panel_4.add(btnUpdateRemark);
   	
   	JLabel lblDate = new JLabel("Date");
   	lblDate.setOpaque(true);
   	lblDate.setHorizontalAlignment(SwingConstants.RIGHT);
   	lblDate.setForeground(new Color(60, 179, 113));
   	lblDate.setFont(new Font("Tahoma", Font.BOLD, 16));
   	lblDate.setBackground(Color.WHITE);
   	lblDate.setBounds(721, 8, 149, 32);
   	panel_4.add(lblDate);
   	
   	JDateChooser dateChooser_1 = new JDateChooser();
   	dateChooser_1.setDateFormatString("dd-MM-yyyy");
   	dateChooser_1.setBounds(882, 10, 200, 33);
   	panel_4.add(dateChooser_1);
   	
   	
   	
   	JDateChooser dateChooser_2 = new JDateChooser();
   	dateChooser_2.setDateFormatString("dd-MM-yyyy");
   	dateChooser_2.setBounds(1091, 11, 200, 33);
   	panel_4.add(dateChooser_2);
   	
   	JButton button_1 = new JButton("Check");
   	button_1.addActionListener(new ActionListener() {
   		public void actionPerformed(ActionEvent arg0) {
   			
          DateFormat fd = new SimpleDateFormat("dd-MM-yyyy");
			
			
			from = fd.format(dateChooser_1.getDate());
			to = fd.format(dateChooser_2.getDate());
	
			try {
				fromm1 = new SimpleDateFormat("dd-MM-yyyy").parse(from);
				too1 = new SimpleDateFormat("dd-MM-yyyy").parse(to);
				
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
			while(model1.getRowCount() > 0)
			{
				
				for(int i =0; i < model1.getRowCount();i++)
				{
					model1.removeRow(i);
				}
			}	
			try
			{
																	
				    conn =DriverManager.getConnection("jdbc:ucanaccess://bansal.accdb");  
				    Statement statement1 = conn.createStatement();
	    			String query1=  "select *  from  "+tttt+"   ";
	    			 ResultSet rs1 = statement1.executeQuery(query1);
	    			 while (rs1.next())
			            {  
							j = j+1;
							rows1[0]= rs1.getString("rg");
							rows1[1]= rs1.getString("name");
							rows1[2]= rs1.getString("fname");
							rows1[3]= rs1.getString("mobile");
							rows1[4]= rs1.getString("city");
							rows1[5] = rs1.getString("state");
							rows1[6]= rs1.getString("Address");
							rows1[7]= rs1.getString("sex");
							rows1[8]= rs1.getString("age");
							rows1[9]= rs1.getString("doctorname");
							rows1[10]= rs1.getString("charge");
							rows1[11]= rs1.getString("status");
							rows1[12]= rs1.getString("date");	
							rows1[13]= rs1.getString("time");	
							rows1[14]= rs1.getString("refby");	
							rows1[15]= rs1.getString("remark");
							
							ss = rs1.getString("date");
							try {
							
								
								get = new SimpleDateFormat("dd-MM-yyyy").parse(ss);
								
								
							} catch (ParseException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
							
							if(get.after(fromm1)&&get.before(too1))
							{	
								
							
								model1.addRow(rows1);
							
								
								
							}
							else
							{
								//JOptionPane.showMessageDialog(null, "No");
							}
							
				
			            }//end while
			
				rs1.close();
				statement1.close();
				
			}
			catch(SQLException e1)
			{
					JOptionPane.showMessageDialog(null, e1);
			}
	
   			
   		}
   	});
   	button_1.setBounds(1206, 52, 101, 27);
   	panel_4.add(button_1);
   	
   	JButton btnPrint_1 = new JButton("Print");
   	btnPrint_1.addActionListener(new ActionListener() {
   		public void actionPerformed(ActionEvent e) {
   			
   			printopd();
   		}
   	});
   	btnPrint_1.setBounds(808, 182, 112, 23);
   	panel_4.add(btnPrint_1);
   	
   	JLabel lblType = new JLabel("Type");
   	lblType.setForeground(new Color(60, 179, 113));
   	lblType.setFont(new Font("SansSerif", Font.BOLD, 18));
   	lblType.setBounds(389, 17, 69, 24);
   	panel_4.add(lblType);
   	
   	type = new JComboBox();
   	type.setModel(new DefaultComboBoxModel(new String[] {"Paid", "Free"}));
   	type.setBounds(470, 13, 153, 27);
   	panel_4.add(type);
   	
   	
   	
   	JScrollPane scrollPane_1 = new JScrollPane();
   	scrollPane_1.setBounds(4, 11, 1297, 298);
   	panel_3.add(scrollPane_1);
   	
   	contable = new JTable();
   	contable.addMouseListener(new MouseAdapter() {
   		@Override
   		public void mouseClicked(MouseEvent arg0) {
   			
   			
   			i = contable.getSelectedRow();
   			reg.setText(contable.getValueAt(i, 0).toString());
   			reg_name.setText(contable.getValueAt(i, 1).toString());
   			reg_fname.setText(contable.getValueAt(i, 2).toString());
   			reg_mobile.setText(contable.getValueAt(i, 3).toString());
   			reg_city.setText(contable.getValueAt(i, 4).toString());
   			reg_state.setText(contable.getValueAt(i, 5).toString());
   			reg_address.setText(contable.getValueAt(i, 6).toString());
   			sex2.setSelectedItem(contable.getValueAt(i, 7).toString());
   			reg_age.setText(contable.getValueAt(i, 8).toString());
   			re_drname.setText(contable.getValueAt(i, 9).toString());
   			charge.setText(contable.getValueAt(i, 10).toString());
   			rffby.setText(contable.getValueAt(i, 14).toString());
   			remark.setText(contable.getValueAt(i, 15).toString());
   			
   			rdate = contable.getValueAt(i, 12).toString();
   			rtime = contable.getValueAt(i, 13).toString();
   			
   			
   			
   			try
			{
																	
				conn =DriverManager.getConnection("jdbc:ucanaccess://bansal.accdb");  
				 Statement statement1 = conn.createStatement();
	    			String query1=  "select uhid  from uhid where mobile = '"+reg_mobile.getText().toString()+"' and name = '"+reg_name.getText().toString()+"' ";
	    			 ResultSet rs1 = statement1.executeQuery(query1);
				 while (rs1.next())
			            {  
							
							
							uhid.setText(rs1.getString("uhid"));
						
			            }//end while
			
				rs1.close();
				statement1.close();
				
			}
			catch(SQLException e1)
			{
					e1.printStackTrace();
			}
	
   			
   			
   			
   			
   			
   			
   			/*String arr[] = {name,fname,mobile,city,state,address,sex,age,dr,reff};
			AdmitPatient.main(arr);
   			frame.dispose();*/
   		}
   	});
   	contable.setSelectionForeground(new Color(255, 255, 255));
   	contable.setSelectionBackground(new Color(51, 204, 255));
   	contable.setFont(new Font("Tahoma", Font.PLAIN, 11));
   	contable.setRowHeight(30);
   	
   	contable.setModel(model1);
   	scrollPane_1.setViewportView(contable);
   	panel_2.setLayout(gl_panel_2);
   //	Image img12345=new ImageIcon(this.getClass().getResource("/plus.png")).getImage();
   	
   	getContentPane().setLayout(groupLayout);
   	
   	
   		
		
	   	city();
	   	name();
	   	mobile();
	   // permission();
	    uhid();
	}
	
	
	public void rgno()
	{
		
		
		id=0;
		try{
	
			conn =DriverManager.getConnection("jdbc:ucanaccess://bansal.accdb");
			String query="Select  DISTINCT rg from "+ttt+" ";
			PreparedStatement pst=conn.prepareStatement(query);
			ResultSet rs=pst.executeQuery();
			while(rs.next())
			{
				
				id=rs.getInt("rg");
				
			}
			
			sid=String.valueOf((id+1));
			rg_no.setText(sid);
			rs.close();
			pst.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}	
	public void uhid()
	{
		
		id=0;
		String ss = "uhid";
		try{
	
			conn =DriverManager.getConnection("jdbc:ucanaccess://bansal.accdb");
			String query="Select  DISTINCT uhid from "+ss+" ";
			PreparedStatement pst=conn.prepareStatement(query);
			ResultSet rs=pst.executeQuery();
			while(rs.next())
			{
				
				id=rs.getInt("uhid");
				
			}
			
			sid=String.valueOf((id+1));
			uhid.setText(sid);
			rs.close();
			pst.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
	
	}	
		
	
	
	
	public void rgno1()
	{
		
		id11 =0;
		try{
			conn =DriverManager.getConnection("jdbc:ucanaccess://bansal.accdb");
			String query="Select rg from "+tttt+" ";
			PreparedStatement pst=conn.prepareStatement(query);
			ResultSet rs=pst.executeQuery();
			while(rs.next())
			{
				id11=rs.getInt("rg");
				
			}
			sid=String.valueOf((id11+1));
			reg.setText(sid);
			rs.close();
			pst.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
	}
	
	
	
	
	
	
	
	
	
	public void data()
	{
		
		
		while(model.getRowCount() > 0)
		{
			
			for(int i =0; i < model.getRowCount();i++)
			{
				model.removeRow(i);
			}
		}	
		
			String date;
			LocalDateTime now = LocalDateTime.now();
			date = dtf.format(now);
		
		j=0;
		try
		{
			
				
			    conn =DriverManager.getConnection("jdbc:ucanaccess://bansal.accdb");  
			    Statement statement1 = conn.createStatement();
    			String query1=  "select *  from  "+ttt+" where date = '"+date+"'  order by rg   ";
    			 ResultSet rs1 = statement1.executeQuery(query1);
    			 while (rs1.next())
		            {  
						
    				 		j = j+1;
				 		rows[0]= String.valueOf(j);
						rows[1]= rs1.getString("name");
						rows[2]= rs1.getString("fname");
						rows[3]= rs1.getString("mobile");
						rows[4]= rs1.getString("city");
						
						rows[5] = rs1.getString("state");
						rows[6]= rs1.getString("Address");
						rows[7]= rs1.getString("sex");
						rows[8]= rs1.getString("age");
						rows[9]= rs1.getString("doctorname");
						rows[10]= rs1.getString("status");
						rows[11]= rs1.getString("date");	
						rows[12]= rs1.getString("time");
						rows[13]= rs1.getString("refby");
						rows[14]= rs1.getString("remark");
						
						model.addRow(rows);
						
						smsname = rs1.getString("name");
						smscontact = rs1.getString("mobile");
						smsdr = rs1.getString("doctorname");
						
						

		            }//end while
    			 
			rs1.close();
			statement1.close();
			
		}
		catch(SQLException e1)
		{
				e1.printStackTrace();
		}
		

		
		
		
	}
	
	
	public void data1()
	{
		
		i=0;
		int j=0;
		
		while(model1.getRowCount() > 0)
		{
			
			for(int i =0; i < model1.getRowCount();i++)
			{
				model1.removeRow(i);
			}
		}	
		
			String date;
			LocalDateTime now = LocalDateTime.now();
			date = dtf.format(now);
		
		
		try
		{
																
			conn =DriverManager.getConnection("jdbc:ucanaccess://bansal.accdb");  
			 Statement statement1 = conn.createStatement();
    			String query1=  "select *  from  "+tttt+" where date = '"+date+"'  order by rg   ";
    			 ResultSet rs1 = statement1.executeQuery(query1);
			 while (rs1.next())
		            {  
						j++;
				 		rows1[0]= rs1.getString("rg");
						rows1[1]= rs1.getString("name");
						rows1[2]= rs1.getString("fname");
						rows1[3]= rs1.getString("mobile");
						rows1[4]= rs1.getString("city");
						rows1[5] = rs1.getString("state");
						rows1[6]= rs1.getString("Address");
						rows1[7]= rs1.getString("sex");
						rows1[8]= rs1.getString("age");
						rows1[9]= rs1.getString("doctorname");
						rows1[10]= rs1.getString("charge");
						rows1[11]= rs1.getString("status");
						rows1[12]= rs1.getString("date");	
						rows1[13]= rs1.getString("time");	
						rows1[14]= rs1.getString("refby");	
						rows1[15]= rs1.getString("remark");
						
					
						
						model1.addRow(rows1);
						
						
		
		            }//end while
		
			rs1.close();
			statement1.close();
			
		}
		catch(SQLException e1)
		{
				e1.printStackTrace();
		}
	
		
	}

	
	public void name()
	{
		
		ac.removeAllItems();
			
		try { 
			conn =DriverManager.getConnection("jdbc:ucanaccess://bansal.accdb");
			Statement statement = conn.createStatement();
            String query = "SELECT DISTINCT name FROM uhid ";
            ResultSet rs = statement.executeQuery(query);

            while (rs.next())
            {      
               
            	
            	String s = rs.getString("name");
            	
            	ac.addItem(s);
            	
            
                
            }//end while
            conn.close();
            } catch (Exception e1) {
                 e1.printStackTrace();
                 JOptionPane.showMessageDialog(null, e1);
            }
		
	}
	
	
	
	public void mobile()
	{
		
		ac2.removeAllItems();
			
		try { 
			conn =DriverManager.getConnection("jdbc:ucanaccess://bansal.accdb");
			Statement statement = conn.createStatement();
            String query = "SELECT DISTINCT mobile FROM uhid ";
            ResultSet rs = statement.executeQuery(query);

            while (rs.next())
            {      
               
            	
            	String s = rs.getString("mobile");
            	
            	ac2.addItem(s);
            	
            
                
            }//end while
            conn.close();
            } catch (Exception e1) {
                 e1.printStackTrace();
     }
		
	}
	
	public void city()
	{
		
		
		ac1.removeAllItems();;
		try { 
			conn =DriverManager.getConnection("jdbc:ucanaccess://bansal.accdb");
				Statement statement = conn.createStatement();
             String query = "SELECT DISTINCT city FROM uhid ";
             ResultSet rs = statement.executeQuery(query);

            while (rs.next())
            {      
               
            	
            	String s = rs.getString("city");
            	
            	ac1.addItem(s);
            	
            
                
            }//end while
            conn.close();
            } catch (Exception e1) {
                 e1.printStackTrace();
            }
			
		
		
		
			
	}
	public void printopd()
	{
		
		
		String date;
			LocalDateTime now = LocalDateTime.now();
			date = dtf.format(now);
			
			
			Calendar cal =new GregorianCalendar();
   			int second = cal.get(Calendar.SECOND);
   			int minute = cal.get(Calendar.MINUTE);
   			int hour = cal.get(Calendar.HOUR);
   			
   			
   			time = hour+":"+minute+":"+second;
		
		Document document = new Document(PageSize.A4,0,0,0,0);
		try
	      {     
	         PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream("print1.pdf"));
	         document.open();
	         Paragraph p = new Paragraph("",new com.itextpdf.text.Font(com.itextpdf.text.Font.FontFamily.TIMES_ROMAN,11));
	         try{ 	
	        	 
	        	 	conn1 =DriverManager.getConnection("jdbc:sqlite:print.sqlite"); 
 		        	String query="select * from  printopd where name = '"+dr+"' ";
 	 				PreparedStatement pst=conn1.prepareStatement(query);
 	 				ResultSet rs=pst.executeQuery();
 	 				byte[] b2=rs.getBytes("image");
 	 				pst.close();
 	 				rs.close();
 	 				
 	 				com.itextpdf.text.Image image1 = com.itextpdf.text.Image.getInstance(b2);
 	 				com.itextpdf.text.Image jpg=com.itextpdf.text.Image.getInstance(b2);
 	 				jpg.scaleToFit  (550, 550);
 	 				jpg.setAlignment(com.itextpdf.text.Image.UNDERLYING);
 	 				jpg.setAbsolutePosition(0, 550);
 	 				document.add(jpg);
 	 				
 	 				PdfContentByte cb2,cb3,cb4,cb5,cb6,cb7,cb8,cb9,cb10,cb11,cb12,cb13,cb14,cb15,cb16,cb17,cb18,cb19,cb20,cb21,cb22,cb23,cb24,cb25,cb26,cb27,cb28,cb29,cb30,cb31,cb32,cb33,cb34,cb35,cb36;
 	 				BaseFont bf = BaseFont.createFont(BaseFont.HELVETICA, BaseFont.CP1252, BaseFont.NOT_EMBEDDED);
 	 				
 	 				
 	 			
 	 				t2 = reg.getText().toString();
 	 				t3 = reg_name.getText().toString();
 	 				
 					
 					t4 = charge.getText().toString();
 					t4 = t4.concat("/-");
 					
 					String s,s1,s2;
 					s = re_drname.getText().toString();
 					s1 = charge.getText().toString();
 					s2 = uhid.getText().toString();
 					v= Integer.parseInt(charge.getText());
 					t5 = MainPage.convertToIndianCurrency(v);
 					
 	 				
 	 				cb2 = writer.getDirectContent();
 					cb2.beginText();
 	 				cb2.setFontAndSize(bf, 10);
 	 				cb2.showTextAligned(PdfContentByte.ALIGN_LEFT, rdate, 155, 725, 0);
 	 				cb2.endText();
 	 				
 	 				
 	 				cb2 = writer.getDirectContent();
 					cb2.beginText();
 	 				cb2.setFontAndSize(bf, 10);
 	 				cb2.showTextAligned(PdfContentByte.ALIGN_LEFT, s2, 105,722, 0);
 	 				cb2.endText();
 	 				
 	 				
 	 				cb2 = writer.getDirectContent();
 					cb2.beginText();
 	 				cb2.setFontAndSize(bf, 10);
 	 				cb2.showTextAligned(PdfContentByte.ALIGN_LEFT, rtime, 160, 700, 0);
 	 				cb2.endText();
 	 				
 	 				
 	 				cb4 = writer.getDirectContent();
 					cb4.beginText();
 	 				cb4.setFontAndSize(bf, 10);
 	 				cb4.showTextAligned(PdfContentByte.ALIGN_LEFT, t2, 40, 722, 0);
 	 				cb4.endText();
 	 				
 	 				
 	 				
 	 				cb6 = writer.getDirectContent();
 					cb6.beginText();
 	 				cb6.setFontAndSize(bf, 10);
 	 				cb6.showTextAligned(PdfContentByte.ALIGN_LEFT, t3, 78, 673, 0);
 	 				cb6.endText();
 	 				
 	 			
 	 				
 	 				
 	 				cb8 = writer.getDirectContent();
 					cb8.beginText();
 	 				cb8.setFontAndSize(bf, 10);
 	 				cb8.showTextAligned(PdfContentByte.ALIGN_LEFT, s, 130, 630, 0);
 	 				cb8.endText();
 	 				
 	 				
 	 				
 	 				
 	 				
 	 				
 	 				cb10 = writer.getDirectContent();
 					cb10.beginText();
 	 				cb10.setFontAndSize(bf, 10);
 	 				cb10.showTextAligned(PdfContentByte.ALIGN_LEFT, t4, 30, 560, 0);
 	 				cb10.endText();
 	 				
 	 				
 	 				
 	 				
 	 				
 	 				cb12 = writer.getDirectContent();
 					cb12.beginText();
 	 				cb12.setFontAndSize(bf, 10);
 	 				cb12.showTextAligned(PdfContentByte.ALIGN_LEFT, t5, 90, 650, 0);
 	 				cb12.endText();
 	 				
 	 				
 	 				
 	 				
 	 				
 	 				cb13 = writer.getDirectContent();
 					cb13.beginText();
 	 				cb13.setFontAndSize(bf, 10);
 	 				cb13.showTextAligned(PdfContentByte.ALIGN_LEFT, monu, 85, 605, 0);
 	 				cb13.endText();
 	 				
 	 				
 	 				
 	 				document.add(p);
 	 				document.close();
 	 				writer.close();
 	 				Desktop.getDesktop().open(new File("print1.pdf"));
 	 				
 	 				
 	 				
				
				  
 	 				
      	        }catch(Exception fe)
      	        {
      	        	JOptionPane.showMessageDialog(null, fe);
      	        }
	         
	         	
 				 
	           
	}
		catch(Exception e)
		{}
	
	}
	
	
	
	
	
	
	
	
	public String sendSMS(String Id, String Name,String Contact,String Doctor)
	{
		//JOptionPane.showMessageDialog(null, "message1");
			try 
			{
				// Construct data
				String id = Id; 
				String contact = Contact; 
				String mgs=Doctor+",Your appointment number is "+id+" please be present at your time otherwise it will be reset:- Manager Bansal Hospital 9530395333";
				//String mjaak="à¤†à¤ªà¤•à¤¾ à¤ªà¤‚à¤œà¥€à¤•à¤°à¤£ à¤¸à¤‚à¤–à¥�à¤¯à¤¾ 10 à¤¹à¥ˆ";
				String msg1=java.net.URLEncoder.encode(mgs, "UTF-8").replace("+", "%20");
				//JOptionPane.showMessageDialog(null, msg1);
				
				// Send data
				
				HttpURLConnection conn = (HttpURLConnection) new URL("http://manage.hivemsg.com/api/send_transactional_sms.php?username=u4592&msg_token=hrk9gC&sender_id=UJJWAL&message="+msg1+"&mobile="+contact+"").openConnection();
				//HttpURLConnection conn = (HttpURLConnection) new URL("http://bulksms.fitechmedia.com/vendorsms/pushsms.aspx?user=ujjwal&password=NGYS4K1Q&msisdn="+contact+"&sid=UJJWAL&msg="+msg1+"&fl=0&gwid=2").openConnection();
				//HttpURLConnection conn = (HttpURLConnection) new URL("http://sms.fitechmedia.com/pushsms.php?username="+"ujjwal"+"&password="+"ujjwal"+"&sender="+"UJJWAL"+"&numbers="+contact+"&message="+msg1+"").openConnection();
			//	HttpURLConnection conn = (HttpURLConnection) new URL("http://astarsms.astargroup.org/api/pushsms.php?username=BANSALHC&password=6578&sender=BANSAL&message="+msg1+"&numbers="+contact+"&unicode=false&flash=false").openConnection();
				//HttpURLConnection conn = (HttpURLConnection) new URL("http://astarsms.astargroup.org/pushsms.php?username="+"BANSALHC"+"&password="+"6578"+"&sender="+"BANSALHC"+"&numbers="+contact+"&message="+msg1+"").openConnection();
				//String data = apiKey + numbers + message + sender;
				conn.setDoOutput(true);
				conn.setRequestMethod("POST");
				//conn.setRequestProperty("Content-Type","text/xml");
				conn.setRequestProperty("Content-Length", Integer.toString(msg1.length()));
				conn.getOutputStream().write(msg1.getBytes("UTF-8"));
				final BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
				final StringBuffer stringBuffer = new StringBuffer();
				String line;
				while ((line = rd.readLine()) != null) {
					stringBuffer.append(line);
				}
				rd.close();
				
				return stringBuffer.toString();
			} catch (Exception e) {
				System.out.println("Error SMS "+e);
				return "Error "+e;
			
			}
	
				
}
	/*public void permission()
	{
		
		try { 
			conn =DriverManager.getConnection("jdbc:ucanaccess://bansal.accdb");
				Statement statement = conn.createStatement();
             String query = "SELECT * FROM per where username = '"+monu+"' ";
             ResultSet rs = statement.executeQuery(query);

            while (rs.next())
            {      
               
            	
            	
            	String opd = rs.getString("OPD");
            	String ipd = rs.getString("IPD");
            	
            	if(opd.equals("yes"))
            	{
            		
            		opd_panel.setVisible(true);
            		admin.setVisible(false);
            		
            	}	
            	if(ipd.equals("yes"))
            	{
            		
            		admit.setVisible(true);
            		admin.setVisible(false);
            	}	
            	if(opd.equals("no")&&ipd.equals("yes"))
            	{
            		
            		admitdirect.setVisible(true);
            		admin.setVisible(false);
            	}	
            	if(ipd.equals("no"))
            	{
            		
            		admitdirect.setVisible(false);
            		admin.setVisible(false);
            		
            	}
            	if(monu.equals("admin"))
            	{
            		
            		admin.setVisible(true);
            	}	
                
            }//end while
            conn.close();
            } catch (Exception e1) {
                 e1.printStackTrace();
            }*/
			
	

}
