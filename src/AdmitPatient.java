import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.awt.image.BufferedImage;
import java.awt.print.PageFormat;
import java.awt.print.Paper;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.security.PrivilegedExceptionAction;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
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

import javax.imageio.ImageIO;
import javax.security.auth.RefreshFailedException;
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
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import javax.swing.text.StyleConstants.FontConstants;

import org.apache.poi.hwpf.converter.WordToFoUtils;
import org.apache.poi.xwpf.usermodel.ParagraphAlignment;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;

import com.itextpdf.text.Document;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Element;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.mxrck.autocompleter.TextAutoCompleter;
import com.sun.pdfview.font.PDFFont;

import jxl.Workbook;
import jxl.format.BoldStyle;
import jxl.format.Colour;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import net.proteanit.sql.DbUtils;
import net.ucanaccess.console.Main;

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
import java.awt.Choice;
import java.awt.Button;
import com.toedter.calendar.JDateChooser;
import com.toedter.components.JLocaleChooser;


import org.apache.commons.lang.WordUtils;
//import bill_form.BillPrintable;

import com.toedter.calendar.JDayChooser;
import javax.swing.JTextArea;

public class AdmitPatient extends JFrame{
	byte[] CR = null;
	String filename = null;
	PdfContentByte cb2,cb3,cb4,cb5,cb6,cb7,cb8,cb9,cb10,cb11,cb12,cb13,cb14,cb15,cb16,cb17,cb18,cb19,cb20,cb21,cb22,cb23,cb24,cb25,cb26,cb27,cb28,cb29,cb30,cb31,cb32,cb33,cb34,cb35,cb36;
	Paragraph p1;
	public static AdmitPatient frame;
	DefaultTableModel jaana,dtm;
	Connection conn1=null;
	JPanel panel;
	int col;
	String s;
	 Font f;
	 PdfPCell c2;
	public JTable table_1;
	String id1,date,date1,name1,address1,dept1,consultant1,father1,age1,gender1,mobile1,service;
	public JButton buttonopd4;
	public JButton buttonopd5;
	int fourthcount=0;
	JPopupMenu popupMenu;
	public JPopupMenu popupMenu_1;
	public JTabbedPane Regis;
	public JTextField qty1;
	DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd-MM-yyyy");
	String col_name11;
	Connection conn=null;
	Connection conn2=null;
	Connection conn3=null;
	TextAutoCompleter rnoo;
	String drshabname,drshab;
	String sid,sidd,iteam,tyy,ty;
	public JTextField amoo;
	public JTextField qtyy;
	int  id  = 0;
	int id11 = 0;
	int idd,v;
	private Object[] rows;
	private Object[] rows1;
	
	
	
	String rstatus="NONADMIT";
	
	
	int check;
	String roomm,ward;
	private Object[] rows2;
	DefaultTableModel model,model1,jana;
	JComboBox sex2;
	JComboBox comboBox;
	JComboBox bed;
	JComboBox red;
 	JComboBox categ,billing;
 	JComboBox 	high_detail;
	TextAutoCompleter ac,ac1,ac2,ac3,acc,dr;
	private JTextField ipd;
	private JTextField reg_name;
	private JTextField reg_fname;
	private JTextField reg_mobile;
	private JTextField reg_city;
	private JTextField reg_state;
	private JTextField reg_address;
	private JTextField reg_age;
	JTextArea english,english2,digno;
	JTextArea reason;
	int i=0;
	int j= 0;
	String dd,tt,dis;
	String coname;
	String arr[];
	String name,mobile;
	String jp;
	JLabel lbl;
	public static JTable  table;
	String tdate,ttime,tapt;
	String mrd;
	JTextArea otnote,clinic,investigation,History;
	JComboBox reasonchoice;
	
	
	String rename;
	String redod;
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
		
		String t,t1,t2,t3,t4,t5;
			
		JTextArea hindi;
		 static String namme = null;
		 static String fnamme,mobille,cittyy,statte,address,sexx,agee,drree,rfee;
		 private JTextField uhid;
		 private JTextField addmission_date;
		 private JTextField rfby;
		 
		 private JTable med;
		 private JTextField dignose;
		 private JTextField textField;
		 String sonu;
		 private JTextField oprate_date;
		 private JTextField followup;
		 private JTextField drugs;
		 private JTextField dose;
		 private JTextField frequency;
		 private JTextField days;
		 
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			
		
			
			
			public void run()
			{
				
				 namme = args[0];
				 fnamme = args[1];
				 mobille = args[2];
				 cittyy = args[3];
				 statte = args[4];
				 address = args[5];
				 sexx = args[6];
				 
				 agee= args[7];
				 drree = args[8];
				 rfee = args[9];
				 
				 
				 
				 
				
				
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
						 frame = new AdmitPatient();
						
						
						 
					  } catch (Exception e) {
					    e.printStackTrace();
				}
			
			
			}
			
		});
	}

	/**
	 * Create the application.
	 */
	

	
	public AdmitPatient() {
		
		
		
		conn2=SqliteConnection.dbconnector();
		conn1=SqliteConnection.dbconnector1();
		conn=SqliteConnection.dbconnector2();
		conn3=SqliteConnection.dbconnector2();
		
		
		try{
			
			conn2 =DriverManager.getConnection("jdbc:ucanaccess://bansal.accdb");
			String query="Select uhid from uhid where name = '"+namme+"' AND mobile = '"+mobille+"' ";
			PreparedStatement pst=conn2.prepareStatement(query);
			ResultSet rs=pst.executeQuery();
			while(rs.next())
			{
				
				id=rs.getInt("uhid");
				
			}
			
			sid=String.valueOf((id));
			
			rs.close();
			pst.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		 getContentPane().setBackground(Color.WHITE);
		 Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		 setExtendedState(JFrame.MAXIMIZED_BOTH);
	     setBounds(0, 0, 1382, 801);  
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
   				.addContainerGap()
   				.addComponent(Regis, GroupLayout.PREFERRED_SIZE, 1356, GroupLayout.PREFERRED_SIZE)
   				.addContainerGap(20, Short.MAX_VALUE))
   	);
   	groupLayout.setVerticalGroup(
   		groupLayout.createParallelGroup(Alignment.LEADING)
   			.addGroup(groupLayout.createSequentialGroup()
   				.addContainerGap()
   				.addComponent(Regis, GroupLayout.PREFERRED_SIZE, 714, GroupLayout.PREFERRED_SIZE)
   				.addContainerGap(59, Short.MAX_VALUE))
   	);
   	Regis.setBackground(new Color(209, 128, 17));
   	
   	
   	
   	model1 = new DefaultTableModel();
   	model1 = new DefaultTableModel();
   	jana = new DefaultTableModel();
   	
	rows = new Object[13];
	rows1 = new Object[14];
	rows2 = new Object[4];
	Object[] colomns2 = {"Drugs","Dose","Frequency","Days"};
	Object[] columns={"Rg.No","Name","Father Name","Mobile","City","State","Address","Sex","Age","Doctor Name","Status","Date","Time"};
	Object[] columns1={"Rg.No","Name","Father Name","Mobile","City","State","Address","Sex","Age","Doctor Name","Charge","Status","Date","Time"};
   	model1.setColumnIdentifiers(columns);
   	model1.setColumnIdentifiers(columns1);
   	jana.setColumnIdentifiers(colomns2);
   	
   	
   	
   	
   	
   /*	String ss = "UNBook";
    try { 
		
		conn =DriverManager.getConnection("jdbc:ucanaccess://sbbh.accdb");
		Statement statement = conn.createStatement();
        String query = "SELECT DISTINCT room_no FROM book_room where status = '"+ss+"' ";
        ResultSet rs = statement.executeQuery(query);

       while (rs.next())
       {      
          
       	String s = rs.getString("room_no");
       	comboBox.addItem(s);
       	
       	
       	
       
           
       }//end while
       conn.close();
       } catch (Exception e1) {
            e1.printStackTrace();
       }*/
   	
   	JPanel admit = new JPanel();
   	Regis.addTab("Admit"
   			+ "", null, admit, null);
   	
   	JPanel panel_2 = new JPanel();
   	admit.add(panel_2);
   	
   	JPanel panel_3 = new JPanel();
   	panel_3.setBorder(new BevelBorder(BevelBorder.RAISED, new Color(0, 0, 255), new Color(0, 0, 255), new Color(0, 0, 255), new Color(0, 0, 255)));
   	panel_3.setLayout(null);
   	
   	JPanel panel_4 = new JPanel();
   	panel_4.setBorder(new LineBorder(new Color(0, 0, 255)));
   	panel_4.setLayout(null);
   	panel_4.setBackground(Color.WHITE);
   	
   	JLabel lblUhidNi = new JLabel("IPD No");
   	lblUhidNi.setForeground(new Color(60, 179, 113));
   	lblUhidNi.setFont(new Font("SansSerif", Font.BOLD, 18));
   	lblUhidNi.setBounds(10, 11, 112, 24);
   	panel_4.add(lblUhidNi);
   	
   	ipd = new JTextField();
   	ipd.setFont(new Font("Tahoma", Font.PLAIN, 22));
   	ipd.setText("1");
   	ipd.setColumns(10);
   	ipd.setBounds(76, 13, 89, 27);
   	panel_4.add(ipd);
   	
   	JLabel label_2 = new JLabel("Name");
   	label_2.setForeground(new Color(60, 179, 113));
   	label_2.setFont(new Font("SansSerif", Font.BOLD, 18));
   	label_2.setBounds(334, 12, 69, 24);
   	panel_4.add(label_2);
   	
   	reg_name = new JTextField();
   	ac = new TextAutoCompleter(reg_name);
   	reg_name.addKeyListener(new KeyAdapter() {
   		@Override
   		public void keyPressed(KeyEvent e) {
   			
   			if(e.getKeyCode()==KeyEvent.VK_ENTER)
   			{
   				
   				try
   				{
   																		
   					conn2 =DriverManager.getConnection("jdbc:ucanaccess://bansal.accdb");  
   					 Statement statement1 = conn2.createStatement();
   		    			String query1=  "select *  from  uhid where name = '"+reg_name.getText().toString()+"' ";
   		    			 ResultSet rs1 = statement1.executeQuery(query1);
   					 while (rs1.next())
   				            {  
   								
   								uhid.setText(rs1.getString("uhid"));
   								reg_fname.setText(rs1.getString("fname"));
   								reg_mobile.setText(rs1.getString("mobile"));
   								reg_city.setText(rs1.getString("city"));
   								reg_state.setText(rs1.getString("state"));
   								reg_address.setText(rs1.getString("Address"));
   								sex2.setSelectedItem(rs1.getString("sex"));
   								reg_age.setText(rs1.getString("age"));
   								reg_state.setText(rs1.getString("state"));
   							
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
   	reg_name.setText(namme);
   	reg_name.setFont(new Font("Tahoma", Font.PLAIN, 22));
   	reg_name.setColumns(10);
   	reg_name.setBounds(397, 10, 185, 33);
   	panel_4.add(reg_name);
   	
   	JLabel lblCareOf = new JLabel("Care Of");
   	lblCareOf.setForeground(new Color(60, 179, 113));
   	lblCareOf.setFont(new Font("SansSerif", Font.BOLD, 18));
   	lblCareOf.setBounds(589, 15, 77, 24);
   	panel_4.add(lblCareOf);
   	
   	reg_fname = new JTextField();
   	reg_fname.setText(fnamme);
   	reg_fname.setFont(new Font("Tahoma", Font.PLAIN, 22));
   	reg_fname.setColumns(10);
   	reg_fname.setBounds(670, 14, 185, 33);
   	panel_4.add(reg_fname);
   	
   	JLabel label_4 = new JLabel("Mobile No:");
   	label_4.setForeground(new Color(60, 179, 113));
   	label_4.setFont(new Font("SansSerif", Font.BOLD, 18));
   	label_4.setBounds(864, 16, 112, 24);
   	panel_4.add(label_4);
   	
   	reg_mobile = new JTextField();
   	reg_mobile.addKeyListener(new KeyAdapter() {
   		@Override
   		public void keyPressed(KeyEvent e) {
   			
   			if(e.getKeyCode()==KeyEvent.VK_ENTER)
   			{
   				
   				try
   				{
   																		
   					conn2 =DriverManager.getConnection("jdbc:ucanaccess://bansal.accdb");  
   					 Statement statement1 = conn2.createStatement();
   		    			String query1=  "select *  from  uhid where mobile = '"+reg_mobile.getText().toString()+"' ";
   		    			 ResultSet rs1 = statement1.executeQuery(query1);
   					 while (rs1.next())
   				            {  
   								
   								uhid.setText(rs1.getString("uhid"));
   								reg_fname.setText(rs1.getString("fname"));
   								reg_name.setText(rs1.getString("name"));
   								reg_city.setText(rs1.getString("city"));
   								reg_state.setText(rs1.getString("state"));
   								reg_address.setText(rs1.getString("Address"));
   								sex2.setSelectedItem(rs1.getString("sex"));
   								reg_age.setText(rs1.getString("age"));
   								reg_state.setText(rs1.getString("state"));
   							
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
   	reg_mobile.setFont(new Font("Tahoma", Font.PLAIN, 22));
   	reg_mobile.setText(mobille);
   	reg_mobile.setColumns(10);
   	reg_mobile.setBounds(971, 13, 134, 33);
   	panel_4.add(reg_mobile);
   	
   	JLabel label_5 = new JLabel("City:");
   	label_5.setForeground(new Color(60, 179, 113));
   	label_5.setFont(new Font("SansSerif", Font.BOLD, 18));
   	label_5.setBounds(8, 60, 46, 24);
   	panel_4.add(label_5);
   	
   	reg_city = new JTextField();
   	reg_city.setFont(new Font("Tahoma", Font.PLAIN, 22));
   	reg_city.setText(cittyy);
   	reg_city.setColumns(10);
   	reg_city.setBounds(76, 59, 246, 33);
   	panel_4.add(reg_city);
   	
   	JLabel label_6 = new JLabel("State");
   	label_6.setForeground(new Color(60, 179, 113));
   	label_6.setFont(new Font("SansSerif", Font.BOLD, 18));
   	label_6.setBounds(332, 61, 112, 24);
   	panel_4.add(label_6);
   	
   	reg_state = new JTextField();
   	reg_state.setText(statte);
   	reg_state.setFont(new Font("Tahoma", Font.PLAIN, 22));
   	reg_state.setColumns(10);
   	reg_state.setBounds(398, 60, 185, 33);
   	panel_4.add(reg_state);
   	
   	JLabel label_7 = new JLabel("Address:");
   	label_7.setForeground(new Color(60, 179, 113));
   	label_7.setFont(new Font("SansSerif", Font.BOLD, 18));
   	label_7.setBounds(10, 100, 81, 24);
   	panel_4.add(label_7);
   	
   	reg_address = new JTextField();
   	reg_address.setText(address);
   	reg_address.setFont(new Font("Tahoma", Font.PLAIN, 22));
   	reg_address.setColumns(10);
   	reg_address.setBounds(101, 103, 185, 27);
   	panel_4.add(reg_address);
   	
   	JLabel label_8 = new JLabel("Sex:");
   	label_8.setForeground(new Color(60, 179, 113));
   	label_8.setFont(new Font("SansSerif", Font.BOLD, 18));
   	label_8.setBounds(1111, 14, 59, 25);
   	panel_4.add(label_8);
   	
   	sex2 = new JComboBox();
   	sex2.setBackground(Color.WHITE);
   	sex2.setModel(new DefaultComboBoxModel(new String[] {"Male", "Female", "Other"}));
   	sex2.setSelectedItem(sexx);
   	sex2.setForeground(new Color(0, 153, 0));
   	sex2.setFont(new Font("SansSerif", Font.PLAIN, 18));
   	sex2.setBounds(1163, 14, 146, 26);
   	panel_4.add(sex2);
   	
   	JLabel label_9 = new JLabel("Age:");
   	label_9.setForeground(new Color(60, 179, 113));
   	label_9.setFont(new Font("SansSerif", Font.BOLD, 18));
   	label_9.setBounds(603, 66, 53, 24);
   	panel_4.add(label_9);
   	
   	reg_age = new JTextField();
   	reg_age.setFont(new Font("Tahoma", Font.PLAIN, 22));
   	reg_age.setText(agee);
   	reg_age.setColumns(10);
   	reg_age.setBounds(671, 63, 77, 33);
   	panel_4.add(reg_age);
   	
   	JButton btnNewButton_3 = new JButton("Current IPD");
   	btnNewButton_3.setForeground(new Color(0, 0, 255));
   	btnNewButton_3.addActionListener(new ActionListener() {
   		public void actionPerformed(ActionEvent arg0) {
   			
   			String value = "Admit"; 
   			
   			check = 1;
   			try
			{
																	
				conn =DriverManager.getConnection("jdbc:ucanaccess://sbbh.accdb");
				String query= "select *  from  ipd_admit where status = '"+value+"' ";
				PreparedStatement statement= conn.prepareStatement(query);
				ResultSet rs=statement.executeQuery();
				contable.setModel(DbUtils.resultSetToTableModel(rs));
				rs.close();
				statement.close();
				
			}
			catch(SQLException e1)
			{
					e1.printStackTrace();
			}
   		}
   	});
   	btnNewButton_3.setOpaque(true);
   	btnNewButton_3.setBackground(new Color(255, 255, 255));
   	btnNewButton_3.setFont(new Font("Tahoma", Font.BOLD, 18));
   	
   	JButton btnDischarge = new JButton("Old Discharged");
   	btnDischarge.setForeground(new Color(0, 0, 255));
   	btnDischarge.addActionListener(new ActionListener() {
   		public void actionPerformed(ActionEvent arg0) {
   			
   			
   			
   			String value = "Discharge"; 
   			check = 0;
   			try
			{
																	
   				conn1 =DriverManager.getConnection("jdbc:sqlite:print.sqlite"); 
				String query= "select  *  from  ipd_dis  ";
				PreparedStatement statement= conn1.prepareStatement(query);
				ResultSet rs=statement.executeQuery();
				contable.setModel(DbUtils.resultSetToTableModel(rs));
				rs.close();
				statement.close();
				
			}
			catch(SQLException e1)
			{
					e1.printStackTrace();
			}
   			
   			
   		}
   	});
   	btnDischarge.setOpaque(true);
   	btnDischarge.setFont(new Font("Tahoma", Font.BOLD, 18));
   	btnDischarge.setBackground(Color.WHITE);
	
	JButton btnBilling = new JButton("Billing");
	btnBilling.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent arg0) {
			
			
		String bill_no = ipd.getText();		
		String name =reg_name.getText();
		
		String mobile =	reg_mobile.getText();
		String add = reg_address.getText();
		String sex = sex2.getSelectedItem().toString();
		String age = reg_age.getText().toString();
		String admitdate = 	addmission_date.getText();
		String dr  =     re_drname.getText();
		String op = reason.getText();	
		//String romno = comboBox.getSelectedItem().toString();
		//String bedd = red.getSelectedItem().toString();
		String uhidd = uhid.getText();
		
		
		
		String bil = null;
		
		int id11 =0;
		try{
			Connection conn1 =DriverManager.getConnection("jdbc:sqlite:print.sqlite"); 
			String query="Select sno from bill_no ";
			PreparedStatement pst=conn1.prepareStatement(query);
			ResultSet rs=pst.executeQuery();
			while(rs.next())
			{
				id11=rs.getInt("sno");
				
			}
			bil=String.valueOf((id11+1));
			
			rs.close();
			pst.close();
		}
		catch(Exception ee)
		{
			ee.printStackTrace();
		}
		
		
		
		
		try {
			Connection conn1 =DriverManager.getConnection("jdbc:sqlite:print.sqlite");  
				String query = "Insert into  bill_no (sno) values(?)";
				PreparedStatement pst = conn1.prepareStatement(query);
				pst.setString(1, bil);
				
		
				pst.execute();
				pst.close();
				
				
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		
		
		String s[] = {bil,admitdate,dis,dr,roomm,ward,name,age,sex,op,add,mobile,uhidd};
		Billing.main(s);
			
		}
	});
	btnBilling.setForeground(new Color(0, 0, 255));
	btnBilling.setOpaque(true);
	btnBilling.setFont(new Font("Tahoma", Font.BOLD, 18));
	btnBilling.setBackground(Color.WHITE);
	
	JButton btnBack = new JButton("Back");
	btnBack.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent arg0) {
			
			
			String s[] = {"s"};
			MainPage.main(s);
   			frame.dispose();
		}
	});
	btnBack.setOpaque(true);
	btnBack.setForeground(Color.BLUE);
	btnBack.setFont(new Font("Tahoma", Font.BOLD, 18));
	btnBack.setBackground(Color.WHITE);
	
	JButton btnCancel = new JButton("Cancel");
	btnCancel.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent arg0) {
			
			
			String value = "Cancel"; 
   			try
			{
																	
				conn =DriverManager.getConnection("jdbc:ucanaccess://sbbh.accdb");
				String query= "select *  from  ipd_admit where status = '"+value+"' ";
				PreparedStatement statement= conn.prepareStatement(query);
				ResultSet rs=statement.executeQuery();
				contable.setModel(DbUtils.resultSetToTableModel(rs));
				rs.close();
				statement.close();
				
			}
			catch(SQLException e1)
			{
					e1.printStackTrace();
			}
		}
	});
	btnCancel.setOpaque(true);
	btnCancel.setForeground(Color.BLUE);
	btnCancel.setFont(new Font("Tahoma", Font.BOLD, 18));
	btnCancel.setBackground(Color.WHITE);
	
	JComboBox comboBox_1 = new JComboBox();
	comboBox_1.setFont(new Font("Tahoma", Font.BOLD, 14));
	comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"Name", "UHID", "Phone No"}));
	
	textField = new JTextField();
	textField.setFont(new Font("Tahoma", Font.PLAIN, 14));
	textField.addKeyListener(new KeyAdapter() {
		@Override
		public void keyReleased(KeyEvent e) {
			DefaultTableModel m=(DefaultTableModel) contable.getModel();
			String search=textField.getText().toString();
			TableRowSorter<DefaultTableModel> tr=new TableRowSorter<DefaultTableModel>(m);
			contable.setRowSorter(tr);
			tr.setRowFilter(RowFilter.regexFilter(search));
		}
	});
	textField.setColumns(10);
	
	JButton btnDischargeSummery_1 = new JButton("Discharge Summery");
	btnDischargeSummery_1.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			
			
			JComboBox  cd2 = (JComboBox) new JComboBox<>();
    		try { 
    			conn1 =DriverManager.getConnection("jdbc:sqlite:print.sqlite"); 
    			Statement statement = conn1.createStatement();
                String query = "SELECT name FROM discharge ";
                ResultSet rs = statement.executeQuery(query);

                while (rs.next())
                {      
                   
                	
                	String s = rs.getString("name");
                	
                	cd2.addItem(s);
                	
                
                    
                }//end while
                conn1.close();
                } catch (Exception e1) {
                     e1.printStackTrace();
                }
    		
    		
    		
    		
    		 JComponent[] inputs = new JComponent[] {
				       
			        	
					 	new JLabel("Choice Treatment"),
						cd2,
					
						
			       
			        
			        
			};
    		 
    		 	int result = JOptionPane.showConfirmDialog(null, inputs, "Choice Treatment", JOptionPane.PLAIN_MESSAGE);
				if (result == JOptionPane.OK_OPTION) 
				{
					
					
					
						sonu = cd2.getSelectedItem().toString();
		   		         
		   		         try{ 	
		   		        	 
		   		        	 	conn1 =DriverManager.getConnection("jdbc:sqlite:print.sqlite"); 
		   	 		        	String query="select * from discharge where name = '"+cd2.getSelectedItem().toString()+"' ";
		   	 	 				PreparedStatement pst=conn1.prepareStatement(query);
		   	 	 				ResultSet rs=pst.executeQuery();
		   	 	 				History.append(rs.getString("history"));
		   	 	 				otnote.append(rs.getString("otnote"));
		   	 	 				clinic.append(rs.getString("clinic"));
		   	 	 				
		   	 	 				pst.close();
		   	 	 				rs.close();
		   	 	 				
		   	 	 				
		   	 	 				
		   	      	        }
		   		         
		   		         	
		   	 				 
		   		           
		   		
		   			catch(Exception ee)
		   			{}
		   		        
		   		         
		   		         
		   		         String s = cd2.getSelectedItem().toString();
		   		      for(int j=0; j < s.length(); j++) {
		 				 
		 				 s =s.replace(" ", "_");
		 			
		 				 
		 				}
		 			 
		   		         
		   		      try
		   			{
		   																	
		   				conn1 =DriverManager.getConnection("jdbc:sqlite:print.sqlite"); 
		   				String query= "select *  from   "+s+" ";
		   				PreparedStatement statement= conn1.prepareStatement(query);
		   				ResultSet rs=statement.executeQuery();
						while (rs.next())
				            {  
								
							
							
						 		
								rows2[0]= rs.getString("Drugs");
								
								rows2[1]= rs.getString("Dose");
								
								rows2[2]= rs.getString("Frequency");
								
								rows2[3]= rs.getString("Days");
								
								jana.addRow(rows2);
								
					
				            }//end 
		   				
		   			}

		   			catch(SQLException e1)
		   			{
		   					e1.printStackTrace();
		   			
		   			}    
		   			
		   		   String name =reg_name.getText().toString();
		    		String mobile = reg_mobile.getText().toString();
		    		
		    		lbl.setText(name.concat(mobile));
		    		Regis.setSelectedIndex(2);
				}
			
			
		
		}
	});
	btnDischargeSummery_1.setOpaque(true);
	btnDischargeSummery_1.setForeground(Color.BLUE);
	btnDischargeSummery_1.setFont(new Font("Tahoma", Font.BOLD, 18));
	btnDischargeSummery_1.setBackground(Color.WHITE);
	
	JButton btnPrevious = new JButton("Preview of Old discharged");
	btnPrevious.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			
			
			
			
			digno.append(null);
			otnote.append(null);
			clinic.append(null);
			investigation.append(null);
			History.append(null);
			
			oprate_date.setText("");
			followup.setText("");
			
			String name =reg_name.getText().toString();
    		String mobile = reg_mobile.getText().toString();
    		
    		String lab_record = name.concat(mobile).concat("lab_report").concat(addmission_date.getText());
    		String med_record = name.concat(mobile).concat("med_report").concat(addmission_date.getText());
    		String dis_record = name.concat(mobile).concat("dis_report").concat(addmission_date.getText());
    		
    		for(int j=0; j < lab_record.length(); j++) {
				 
				 
    				lab_record = lab_record.replace(" ", "");
			
				 
				}
			
    		for(int j=0; j < lab_record.length(); j++) {
				 
				 
    			
    				lab_record = lab_record.replace("-", "");
			
				 
				}
    		
    		
    		for(int j=0; j < lab_record.length(); j++) {
				 
				 
    			
				lab_record = lab_record.replace(".", "");
		
			 
			}
		

    		for(int j=0; j < med_record.length(); j++) {
				 
				 med_record = med_record.replace(" ", "");
			
				 
				}
    		
    		
    		
    		for(int j=0; j < med_record.length(); j++) {
				 
				 med_record = med_record.replace(".", "");
			
				 
				}
			
    		for(int j=0; j < med_record.length(); j++) {
				 
				 med_record = med_record.replace("-", "");
			
				 
				}
    		
    		
    				
    		
    		
    		try
			{
   															
   				conn3 =DriverManager.getConnection("jdbc:ucanaccess://bsshlab.accdb");
				String query= "select *  from  "+lab_record+" ";
				PreparedStatement statement= conn3.prepareStatement(query);
				ResultSet rs=statement.executeQuery();
				table.setModel(DbUtils.resultSetToTableModel(rs));
				rs.close();
				statement.close();
				
			}
			catch(SQLException e1)
			{
					e1.printStackTrace();
			}
    		
    		
    		
    		try
			{
   															
    			conn3 =DriverManager.getConnection("jdbc:ucanaccess://bsshlab.accdb");
				String query= "select *  from  "+med_record+" ";
				PreparedStatement statement= conn3.prepareStatement(query);
				ResultSet rs=statement.executeQuery();
				while (rs.next())
	            {  
					
				
				
			 		
					rows2[0]= rs.getString("Drugs");
					
					rows2[1]= rs.getString("Dose");
					
					rows2[2]= rs.getString("Frequency");
					
					rows2[3]= rs.getString("Days");
					
					jana.addRow(rows2);
					
		
	            }//end while
	
			rs.close();
			statement.close();
			
		}

				
				
			
			catch(SQLException e1)
			{
					e1.printStackTrace();
			}
    		
    		
    		

    		try{
    		
    			conn1 =DriverManager.getConnection("jdbc:sqlite:print.sqlite"); 
    			String query="Select * from disreport where ipd = '"+ipd.getText()+"' AND uhid = '"+uhid.getText()+"'  ";
    			PreparedStatement pst=conn1.prepareStatement(query);
    			ResultSet rs=pst.executeQuery();
    			while(rs.next())
    			{
    				
    				digno.append(rs.getString("dia"));
    				otnote.append(rs.getString("ot"));
    				clinic.append(rs.getString("clinic"));
    				investigation.append(rs.getString("invest"));
    				History.append(rs.getString("history"));
    				sonu=rs.getString("opr1");
 	 				oprate_date.setText(rs.getString("ot_date"));
 	 				followup.setText(rs.getString("follow"));
 	 				
    				
    			}
    			
    			rs.close();
    			pst.close();
    		}
    		catch(Exception ee)
    		{
    			ee.printStackTrace();
    		}
    			
    		
    		/*  try{ 	
		        	 
		        	 	conn1 =DriverManager.getConnection("jdbc:sqlite:print.sqlite"); 
	 		        	String query="select * from discharge where name = '"+sonu+"' ";
	 	 				PreparedStatement pst=conn1.prepareStatement(query);
	 	 				ResultSet rs=pst.executeQuery();
	 	 				History.append(rs.getString("history"));
	 	 				otnote.append(rs.getString("otnote"));
	 	 				clinic.append(rs.getString("clinic"));
	 	 				
	 	 				pst.close();
	 	 				rs.close();
	 	 				
	 	 				
	 	 				
	      	        }
		         
		         	
	 				 
		           
		
			catch(Exception ee)*/
			{}
    		  
    		  
    		  String namee =reg_name.getText().toString();
	    		String mobilee = reg_mobile.getText().toString();
	    		
	    		lbl.setText(namee.concat(mobilee));
	    		Regis.setSelectedIndex(2);
		        
			
		}
	});
	btnPrevious.setOpaque(true);
	btnPrevious.setForeground(Color.BLUE);
	btnPrevious.setFont(new Font("Tahoma", Font.BOLD, 18));
	btnPrevious.setBackground(Color.WHITE);
	
	JButton btnImport = new JButton("Rescipt Change");
	btnImport.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			
			
			
			String date;
    		LocalDateTime now = LocalDateTime.now();
    		date = dtf.format(now);
			
			JTextField amount = new JTextField();
			JTextField narration = new JTextField();
			JTextField rno =  new JTextField();
    		JComboBox  cd22 = (JComboBox) new JComboBox<>();
    		JComboBox  cd23 = (JComboBox) new JComboBox<>();
			cd22.addItem("UB_IPD");
			cd22.addItem("BB_IPD");
			cd22.addItem("OPB_IPD");
			cd22.addItem("JN_IPD");
			rnoo = new TextAutoCompleter(rno);
			
			amount.requestFocusInWindow();
			comboBox.addActionListener(new ActionListener() {
		    	public void actionPerformed(ActionEvent arg0) {
		    		
		    		
		    		cd23.removeAllItems();
		    		try{
						conn1 =DriverManager.getConnection("jdbc:sqlite:print.sqlite"); 
						String query="Select ipd from '"+cd22.getSelectedItem().toString()+"'  ";
						PreparedStatement pst=conn1.prepareStatement(query);
						ResultSet rs=pst.executeQuery();
						while(rs.next())
						{
							cd23.addItem(rs.getString("ipd"));
							
						}
						
						
						rs.close();
						pst.close();
					}
					catch(Exception ee)
					{
						ee.printStackTrace();
					}
		    		
		    		
		    		
		    	}
			});
			  JComponent[] inputs = new JComponent[] {
			        new JLabel("AMOUNT"),
			        	amount,
			        	
			        	
			        	new JLabel("Narration"),
			        	narration,
			        	
			       new JLabel("Day Name"),
			        cd22,
			        
			        
			        new JLabel("Rescipt No"),
			        rno
			      
			};
			int result = JOptionPane.showConfirmDialog(null, inputs, "Enter AMOUNT AND CHOICE DR", JOptionPane.PLAIN_MESSAGE);
			if (result == JOptionPane.OK_OPTION) {
			
				
				
				Calendar cal =new GregorianCalendar();
				int second = cal.get(Calendar.SECOND);
				int minute = cal.get(Calendar.MINUTE);
				int hour = cal.get(Calendar.HOUR);
				
				
				String time = hour+":"+minute+":"+second;
				
				
				
				
				String pdf = reg_name.getText().concat(dis).concat(cd22.getSelectedItem().toString());
				
				
				for(int j=0; j < pdf.length(); j++) {
					 
					 pdf = pdf.replace(" ", "");
				
					 
					}
				
				
				for(int j=0; j < pdf.length(); j++) {
					 
					 pdf = pdf.replace(".", "");
				
					 
					}
				String sss = "D:\\Temp\\";
  				pdf = sss.concat(pdf+".pdf");
					
			
			Document document = new Document(PageSize.A4,0,0,0,0);
			try
		      {     
		         PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream(pdf));
		         document.open();
		         Paragraph p = new Paragraph("",new com.itextpdf.text.Font(com.itextpdf.text.Font.FontFamily.TIMES_ROMAN,11));
		         try{ 	
		        	 
		        	 	conn1 =DriverManager.getConnection("jdbc:sqlite:print.sqlite"); 
	 		        	String query="select * from  printopd where name1 = '"+cd22.getSelectedItem().toString()+"' ";
	 	 				PreparedStatement pst=conn1.prepareStatement(query);
	 	 				ResultSet rs=pst.executeQuery();
	 	 				byte[] b2=rs.getBytes("image1");
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
	 	 				
	 	 				
	 	 			
	 	 				t2 = rno.getText();
	 	 				t3 = reg_name.getText().toString();
	 	 				
	 					
	 					t4 = amount.getText().toString();
	 					t4 = t4.concat("/-");
	 					
	 					String s,s1,s2;
	 					s = re_drname.getText().toString();
	 					s1 = amount.getText().toString();
	 					s2 = ipd.getText().toString();
	 					v= Integer.parseInt(amount.getText());
	 					t5 = MainPage.convertToIndianCurrency(v);
	 					
	 	 				
	 	 				cb2 = writer.getDirectContent();
	 					cb2.beginText();
	 	 				cb2.setFontAndSize(bf, 10);
	 	 				cb2.showTextAligned(PdfContentByte.ALIGN_LEFT, dis, 155, 725, 0);
	 	 				cb2.endText();
	 	 				
	 	 				
	 	 				cb2 = writer.getDirectContent();
	 					cb2.beginText();
	 	 				cb2.setFontAndSize(bf, 10);
	 	 				cb2.showTextAligned(PdfContentByte.ALIGN_LEFT, dis, 455, 725, 0);
	 	 				cb2.endText();
	 	 				
	 	 				
	 	 				cb2 = writer.getDirectContent();
	 					cb2.beginText();
	 	 				cb2.setFontAndSize(bf, 10);
	 	 				cb2.showTextAligned(PdfContentByte.ALIGN_LEFT, s2, 106,722, 0);
	 	 				cb2.endText();
	 	 				
	 	 				
	 	 				cb2 = writer.getDirectContent();
	 					cb2.beginText();
	 	 				cb2.setFontAndSize(bf, 10);
	 	 				cb2.showTextAligned(PdfContentByte.ALIGN_LEFT, s2, 400,722, 0);
	 	 				cb2.endText();
	 	 				
	 	 				
	 	 				cb2 = writer.getDirectContent();
	 					cb2.beginText();
	 	 				cb2.setFontAndSize(bf, 10);
	 	 				cb2.showTextAligned(PdfContentByte.ALIGN_LEFT, time, 160, 700, 0);
	 	 				cb2.endText();
	 	 				
	 	 				
	 	 				
	 	 				cb2 = writer.getDirectContent();
	 					cb2.beginText();
	 	 				cb2.setFontAndSize(bf, 10);
	 	 				cb2.showTextAligned(PdfContentByte.ALIGN_LEFT, time, 460, 700, 0);
	 	 				cb2.endText();

	 	 				
	 	 				
	 	 				cb4 = writer.getDirectContent();
	 					cb4.beginText();
	 	 				cb4.setFontAndSize(bf, 10);
	 	 				cb4.showTextAligned(PdfContentByte.ALIGN_LEFT, t2, 40, 722, 0);
	 	 				cb4.endText();
	 	 				
	 	 				
	 	 				cb4 = writer.getDirectContent();
	 					cb4.beginText();
	 	 				cb4.setFontAndSize(bf, 10);
	 	 				cb4.showTextAligned(PdfContentByte.ALIGN_LEFT, t2, 250, 722, 0);
	 	 				cb4.endText();
	 	 				
	 	 				
	 	 				
	 	 				cb6 = writer.getDirectContent();
	 					cb6.beginText();
	 	 				cb6.setFontAndSize(bf, 10);
	 	 				cb6.showTextAligned(PdfContentByte.ALIGN_LEFT, t3, 78, 673, 0);
	 	 				cb6.endText();
	 	 				
	 	 				
	 	 				
	 	 				cb6 = writer.getDirectContent();
	 					cb6.beginText();
	 	 				cb6.setFontAndSize(bf, 10);
	 	 				cb6.showTextAligned(PdfContentByte.ALIGN_LEFT, t3, 330, 673, 0);
	 	 				cb6.endText();
	 	 				
	 	 			
	 	 				
	 	 				
	 	 				cb6 = writer.getDirectContent();
	 					cb6.beginText();
	 	 				cb6.setFontAndSize(bf, 10);
	 	 				cb6.showTextAligned(PdfContentByte.ALIGN_LEFT, t3, 78, 673, 0);
	 	 				cb6.endText();
	 	 				
	 	 				
	 	 				
	 	 				
	 	 				
	 	 				
	 	 				cb10 = writer.getDirectContent();
	 					cb10.beginText();
	 	 				cb10.setFontAndSize(bf, 10);
	 	 				cb10.showTextAligned(PdfContentByte.ALIGN_LEFT, t4, 30, 560, 0);
	 	 				cb10.endText();
	 	 				
	 	 				
	 	 				
	 	 				cb10 = writer.getDirectContent();
	 					cb10.beginText();
	 	 				cb10.setFontAndSize(bf, 10);
	 	 				cb10.showTextAligned(PdfContentByte.ALIGN_LEFT, t4, 230, 560, 0);
	 	 				cb10.endText();
	 	 				
	 	 				cb10 = writer.getDirectContent();
	 					cb10.beginText();
	 	 				cb10.setFontAndSize(bf, 10);
	 	 				cb10.showTextAligned(PdfContentByte.ALIGN_LEFT, narration.getText(), 43, 630, 0);
	 	 				cb10.endText();
	 	 				
	 	 				
	 	 				
	 	 				cb10 = writer.getDirectContent();
	 					cb10.beginText();
	 	 				cb10.setFontAndSize(bf, 10);
	 	 				cb10.showTextAligned(PdfContentByte.ALIGN_LEFT, narration.getText(), 290, 628, 0);
	 	 				cb10.endText();

	 	 				
	 	 				
	 	 				
	 	 				
	 	 				cb12 = writer.getDirectContent();
	 					cb12.beginText();
	 	 				cb12.setFontAndSize(bf, 10);
	 	 				cb12.showTextAligned(PdfContentByte.ALIGN_LEFT, t5, 70, 650, 0);
	 	 				cb12.endText();
	 	 				
	 	 				
	 	 				cb12 = writer.getDirectContent();
	 					cb12.beginText();
	 	 				cb12.setFontAndSize(bf, 10);
	 	 				cb12.showTextAligned(PdfContentByte.ALIGN_LEFT, t5, 330, 650, 0);
	 	 				cb12.endText();
	 	 				
	 	 				
	 	 				
	 	 				
	 	 				
	 	 				cb13 = writer.getDirectContent();
	 					cb13.beginText();
	 	 				cb13.setFontAndSize(bf, 10);
	 	 				cb13.showTextAligned(PdfContentByte.ALIGN_LEFT, "USER", 85, 605, 0);
	 	 				cb13.endText();
	 	 				
	 	 				
	 	 				
	 	 				cb13 = writer.getDirectContent();
	 					cb13.beginText();
	 	 				cb13.setFontAndSize(bf, 10);
	 	 				cb13.showTextAligned(PdfContentByte.ALIGN_LEFT, "USER", 330, 605, 0);
	 	 				cb13.endText();
	 	 				
	 	 				
	 	 				document.add(p);
	 	 				document.close();
	 	 				writer.close();
	 	 				Desktop.getDesktop().open(new File(pdf));
	 	 				
	 	 				
	 	 				
					
	 	 				
	      	        }catch(Exception fe)
	      	        {
	      	        	JOptionPane.showMessageDialog(null, fe);
	      	        	fe.printStackTrace();
	      	        }
		         
		         	
	 				 
		           
		}
			catch(Exception ee)
			{}
			
			
	
				
			}
		}
	});
	btnImport.setOpaque(true);
	btnImport.setForeground(Color.BLUE);
	btnImport.setFont(new Font("Tahoma", Font.BOLD, 18));
	btnImport.setBackground(Color.WHITE);
	
	JButton btnIpdRecipt = new JButton("IPD RECIPT");
	btnIpdRecipt.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			
			int dialogResult = JOptionPane.showConfirmDialog (null, "Do you want genrate rescipt of patient\n"+reg_name.getText() );
			if(dialogResult == JOptionPane.YES_OPTION){
			

    		String date;
    		LocalDateTime now = LocalDateTime.now();
    		date = dtf.format(now);
			
			JTextField amount = new JTextField();
			JTextField narration = new JTextField();
    		JComboBox  cd22 = (JComboBox) new JComboBox<>();
			cd22.addItem("UB_IPD");
			cd22.addItem("BB_IPD");
			cd22.addItem("OPB_IPD");
			cd22.addItem("JN_IPD");
			amount.requestFocusInWindow();
			  JComponent[] inputs = new JComponent[] {
			        new JLabel("AMOUNT"),
			        	amount,
			        	
			        	
			        	new JLabel("Narration"),
			        	narration,
			        	
			       new JLabel("Day Name"),
			        cd22
			        
			      
			};
			int result = JOptionPane.showConfirmDialog(null, inputs, "Enter AMOUNT AND CHOICE DR", JOptionPane.PLAIN_MESSAGE);
			if (result == JOptionPane.OK_OPTION) {
				
				
				

				id11 =0;
				try{
					conn1 =DriverManager.getConnection("jdbc:sqlite:print.sqlite"); 
					String query="Select ipd from '"+cd22.getSelectedItem().toString()+"'  ";
					PreparedStatement pst=conn1.prepareStatement(query);
					ResultSet rs=pst.executeQuery();
					while(rs.next())
					{
						id11=rs.getInt("ipd");
						
					}
					sid=String.valueOf((id11+1));
					
					rs.close();
					pst.close();
				}
				catch(Exception ee)
				{
					ee.printStackTrace();
				}
				
				
				
				try {
					conn1 =DriverManager.getConnection("jdbc:sqlite:print.sqlite"); 
   					String query = "Insert into  "+cd22.getSelectedItem().toString()+" (ipd,date,patient,father,charge) values(?,?,?,?,?) ";
   					PreparedStatement pst = conn1.prepareStatement(query);
   					pst.setString(1, sid);
   					pst.setString(2, dis);
   					pst.setString(3, reg_name.getText());
   					pst.setString(4, reg_fname.getText());
   					pst.setString(5, amount.getText());
   			
   					pst.execute();
   					pst.close();
   					
   					
   				} catch (SQLException e1) {
   					// TODO Auto-generated catch block
   					e1.printStackTrace();
   				}
				
				
				
	   			
				Calendar cal =new GregorianCalendar();
				int second = cal.get(Calendar.SECOND);
				int minute = cal.get(Calendar.MINUTE);
				int hour = cal.get(Calendar.HOUR);
				
				
				String time = hour+":"+minute+":"+second;
				
				
				
				
				String pdf = reg_name.getText().concat(dis).concat(cd22.getSelectedItem().toString());
				
				
				for(int j=0; j < pdf.length(); j++) {
					 
					 pdf = pdf.replace(" ", "");
				
					 
					}
				
				
				for(int j=0; j < pdf.length(); j++) {
					 
					 pdf = pdf.replace(".", "");
				
					 
					}
					String sss = "D:\\Temp\\";
	  				pdf = sss.concat(pdf+".pdf");
					
			
			Document document = new Document(PageSize.A4,0,0,0,0);
			try
		      {     
		         PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream(pdf));
		         document.open();
		         Paragraph p = new Paragraph("",new com.itextpdf.text.Font(com.itextpdf.text.Font.FontFamily.TIMES_ROMAN,11));
		         try{ 	
		        	 
		        	 	conn1 =DriverManager.getConnection("jdbc:sqlite:print.sqlite"); 
	 		        	String query="select * from  printopd where name1 = '"+cd22.getSelectedItem().toString()+"' ";
	 	 				PreparedStatement pst=conn1.prepareStatement(query);
	 	 				ResultSet rs=pst.executeQuery();
	 	 				byte[] b2=rs.getBytes("image1");
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
	 	 				
	 	 				
	 	 			
	 	 				t2 = sid;
	 	 				t3 = reg_name.getText().toString();
	 	 				
	 					
	 					t4 = amount.getText().toString();
	 					t4 = t4.concat("/-");
	 					
	 					String s,s1,s2;
	 					s = re_drname.getText().toString();
	 					s1 = amount.getText().toString();
	 					s2 = ipd.getText().toString();
	 					v= Integer.parseInt(amount.getText());
	 					t5 = MainPage.convertToIndianCurrency(v);
	 					
	 	 				
	 	 				cb2 = writer.getDirectContent();
	 					cb2.beginText();
	 	 				cb2.setFontAndSize(bf, 10);
	 	 				cb2.showTextAligned(PdfContentByte.ALIGN_LEFT, dis, 155, 725, 0);
	 	 				cb2.endText();
	 	 				
	 	 				
	 	 				cb2 = writer.getDirectContent();
	 					cb2.beginText();
	 	 				cb2.setFontAndSize(bf, 10);
	 	 				cb2.showTextAligned(PdfContentByte.ALIGN_LEFT, dis, 455, 725, 0);
	 	 				cb2.endText();
	 	 				
	 	 				
	 	 				cb2 = writer.getDirectContent();
	 					cb2.beginText();
	 	 				cb2.setFontAndSize(bf, 10);
	 	 				cb2.showTextAligned(PdfContentByte.ALIGN_LEFT, s2, 106,722, 0);
	 	 				cb2.endText();
	 	 				
	 	 				
	 	 				cb2 = writer.getDirectContent();
	 					cb2.beginText();
	 	 				cb2.setFontAndSize(bf, 10);
	 	 				cb2.showTextAligned(PdfContentByte.ALIGN_LEFT, s2, 400,722, 0);
	 	 				cb2.endText();
	 	 				
	 	 				
	 	 				cb2 = writer.getDirectContent();
	 					cb2.beginText();
	 	 				cb2.setFontAndSize(bf, 10);
	 	 				cb2.showTextAligned(PdfContentByte.ALIGN_LEFT, time, 160, 700, 0);
	 	 				cb2.endText();
	 	 				
	 	 				
	 	 				
	 	 				cb2 = writer.getDirectContent();
	 					cb2.beginText();
	 	 				cb2.setFontAndSize(bf, 10);
	 	 				cb2.showTextAligned(PdfContentByte.ALIGN_LEFT, time, 460, 700, 0);
	 	 				cb2.endText();

	 	 				
	 	 				
	 	 				cb4 = writer.getDirectContent();
	 					cb4.beginText();
	 	 				cb4.setFontAndSize(bf, 10);
	 	 				cb4.showTextAligned(PdfContentByte.ALIGN_LEFT, t2, 40, 722, 0);
	 	 				cb4.endText();
	 	 				
	 	 				
	 	 				cb4 = writer.getDirectContent();
	 					cb4.beginText();
	 	 				cb4.setFontAndSize(bf, 10);
	 	 				cb4.showTextAligned(PdfContentByte.ALIGN_LEFT, t2, 250, 722, 0);
	 	 				cb4.endText();
	 	 				
	 	 				
	 	 				
	 	 				cb6 = writer.getDirectContent();
	 					cb6.beginText();
	 	 				cb6.setFontAndSize(bf, 10);
	 	 				cb6.showTextAligned(PdfContentByte.ALIGN_LEFT, t3, 78, 673, 0);
	 	 				cb6.endText();
	 	 				
	 	 				
	 	 				
	 	 				cb6 = writer.getDirectContent();
	 					cb6.beginText();
	 	 				cb6.setFontAndSize(bf, 10);
	 	 				cb6.showTextAligned(PdfContentByte.ALIGN_LEFT, t3, 330, 673, 0);
	 	 				cb6.endText();
	 	 				
	 	 			
	 	 				
	 	 				
	 	 				cb6 = writer.getDirectContent();
	 					cb6.beginText();
	 	 				cb6.setFontAndSize(bf, 10);
	 	 				cb6.showTextAligned(PdfContentByte.ALIGN_LEFT, t3, 78, 673, 0);
	 	 				cb6.endText();
	 	 				
	 	 				
	 	 				
	 	 				
	 	 				
	 	 				
	 	 				cb10 = writer.getDirectContent();
	 					cb10.beginText();
	 	 				cb10.setFontAndSize(bf, 10);
	 	 				cb10.showTextAligned(PdfContentByte.ALIGN_LEFT, t4, 30, 560, 0);
	 	 				cb10.endText();
	 	 				
	 	 				
	 	 				
	 	 				cb10 = writer.getDirectContent();
	 					cb10.beginText();
	 	 				cb10.setFontAndSize(bf, 10);
	 	 				cb10.showTextAligned(PdfContentByte.ALIGN_LEFT, t4, 230, 560, 0);
	 	 				cb10.endText();
	 	 				
	 	 				cb10 = writer.getDirectContent();
	 					cb10.beginText();
	 	 				cb10.setFontAndSize(bf, 10);
	 	 				cb10.showTextAligned(PdfContentByte.ALIGN_LEFT, narration.getText(), 43, 630, 0);
	 	 				cb10.endText();
	 	 				
	 	 				
	 	 				
	 	 				cb10 = writer.getDirectContent();
	 					cb10.beginText();
	 	 				cb10.setFontAndSize(bf, 10);
	 	 				cb10.showTextAligned(PdfContentByte.ALIGN_LEFT, narration.getText(), 290, 628, 0);
	 	 				cb10.endText();

	 	 				
	 	 				
	 	 				
	 	 				
	 	 				cb12 = writer.getDirectContent();
	 					cb12.beginText();
	 	 				cb12.setFontAndSize(bf, 10);
	 	 				cb12.showTextAligned(PdfContentByte.ALIGN_LEFT, t5, 70, 650, 0);
	 	 				cb12.endText();
	 	 				
	 	 				
	 	 				cb12 = writer.getDirectContent();
	 					cb12.beginText();
	 	 				cb12.setFontAndSize(bf, 10);
	 	 				cb12.showTextAligned(PdfContentByte.ALIGN_LEFT, t5, 330, 650, 0);
	 	 				cb12.endText();
	 	 				
	 	 				
	 	 				
	 	 				
	 	 				
	 	 				cb13 = writer.getDirectContent();
	 					cb13.beginText();
	 	 				cb13.setFontAndSize(bf, 10);
	 	 				cb13.showTextAligned(PdfContentByte.ALIGN_LEFT, "USER", 85, 605, 0);
	 	 				cb13.endText();
	 	 				
	 	 				
	 	 				
	 	 				cb13 = writer.getDirectContent();
	 					cb13.beginText();
	 	 				cb13.setFontAndSize(bf, 10);
	 	 				cb13.showTextAligned(PdfContentByte.ALIGN_LEFT, "USER", 330, 605, 0);
	 	 				cb13.endText();
	 	 				
	 	 				
	 	 				document.add(p);
	 	 				document.close();
	 	 				writer.close();
	 	 				Desktop.getDesktop().open(new File(pdf));
	 	 				
	 	 				
	 	 				
					
	 	 				
	      	        }catch(Exception fe)
	      	        {
	      	        	JOptionPane.showMessageDialog(null, fe);
	      	        	fe.printStackTrace();
	      	        }
		         
		         	
	 				 
		           
		}
			catch(Exception ee)
			{}
			
			}
		}
		}
	});
	btnIpdRecipt.setOpaque(true);
	btnIpdRecipt.setForeground(Color.BLUE);
	btnIpdRecipt.setFont(new Font("Tahoma", Font.BOLD, 18));
	btnIpdRecipt.setBackground(Color.WHITE);
	
	JButton btnBillReprint = new JButton("Bill Reprint");
	btnBillReprint.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			
			
			
			String pdf = rename+redod;
			
			
			for(int j=0; j < pdf.length(); j++) {
				 
				 pdf = pdf.replace(" ", "");
			
				 
				}
			
			
			for(int j=0; j < pdf.length(); j++) {
				 
				 pdf = pdf.replace(".", "");
			
				 
				}
			String sss = "D:\\Temp\\";
				pdf = sss.concat(pdf+".pdf");
  				pdf = pdf+".pdf";
  				
  				try {
					Desktop.getDesktop().open(new File(pdf));
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
		}
	});
	btnBillReprint.setOpaque(true);
	btnBillReprint.setForeground(Color.BLUE);
	btnBillReprint.setFont(new Font("Tahoma", Font.BOLD, 18));
	btnBillReprint.setBackground(Color.WHITE);
	
	JButton btnResciptReprint = new JButton("Rescipt Reprint");
	btnResciptReprint.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			
			
			JTextField amount = new JTextField();
			JTextField narration = new JTextField();
    		JComboBox  cd22 = (JComboBox) new JComboBox<>();
			cd22.addItem("UB_IPD");
			cd22.addItem("BB_IPD");
			cd22.addItem("OPB_IPD");
			cd22.addItem("JN_IPD");
			amount.requestFocusInWindow();
			  JComponent[] inputs = new JComponent[] {
			     
			        	
			       new JLabel("Dr Name"),
			        cd22
			        
			      
			};
			int result = JOptionPane.showConfirmDialog(null, inputs, "CHOICE DR", JOptionPane.PLAIN_MESSAGE);
			if (result == JOptionPane.OK_OPTION) {
				
				
				
				
				
				
				String pdf = reg_name.getText().concat(dis).concat(cd22.getSelectedItem().toString());
				
				
				for(int j=0; j < pdf.length(); j++) {
					 
					 pdf = pdf.replace(" ", "");
				
					 
					}
				
				
				for(int j=0; j < pdf.length(); j++) {
					 
					 pdf = pdf.replace(".", "");
				
					 
					}
				String sss = "D:\\Temp\\";
  				pdf = sss.concat(pdf+".pdf");
	  				
	  				
	  				
	  				
	  				
	  				try {
						Desktop.getDesktop().open(new File(pdf));
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				
			}
			
			
			
		}
	});
	btnResciptReprint.setOpaque(true);
	btnResciptReprint.setForeground(Color.BLUE);
	btnResciptReprint.setFont(new Font("Tahoma", Font.BOLD, 18));
	btnResciptReprint.setBackground(Color.WHITE);
	GroupLayout gl_panel_2 = new GroupLayout(panel_2);
	gl_panel_2.setHorizontalGroup(
		gl_panel_2.createParallelGroup(Alignment.TRAILING)
			.addGroup(gl_panel_2.createSequentialGroup()
				.addContainerGap()
				.addGroup(gl_panel_2.createParallelGroup(Alignment.LEADING)
					.addGroup(gl_panel_2.createSequentialGroup()
						.addGroup(gl_panel_2.createParallelGroup(Alignment.LEADING)
							.addComponent(panel_4, GroupLayout.DEFAULT_SIZE, 1319, Short.MAX_VALUE)
							.addGroup(gl_panel_2.createSequentialGroup()
								.addComponent(comboBox_1, GroupLayout.PREFERRED_SIZE, 113, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.UNRELATED)
								.addComponent(textField, GroupLayout.PREFERRED_SIZE, 183, GroupLayout.PREFERRED_SIZE))
							.addGroup(gl_panel_2.createSequentialGroup()
								.addComponent(btnNewButton_3, GroupLayout.PREFERRED_SIZE, 151, GroupLayout.PREFERRED_SIZE)
								.addGap(18)
								.addComponent(btnDischarge, GroupLayout.PREFERRED_SIZE, 213, GroupLayout.PREFERRED_SIZE)
								.addGap(18)
								.addComponent(btnBilling, GroupLayout.PREFERRED_SIZE, 151, GroupLayout.PREFERRED_SIZE)
								.addGap(18)
								.addComponent(btnDischargeSummery_1, GroupLayout.PREFERRED_SIZE, 233, GroupLayout.PREFERRED_SIZE)
								.addGap(18)
								.addComponent(btnBack, GroupLayout.PREFERRED_SIZE, 208, GroupLayout.PREFERRED_SIZE)
								.addGap(18)
								.addComponent(btnImport, GroupLayout.PREFERRED_SIZE, 263, GroupLayout.PREFERRED_SIZE))
							.addComponent(panel_3, GroupLayout.DEFAULT_SIZE, 1319, Short.MAX_VALUE))
						.addContainerGap())
					.addGroup(gl_panel_2.createSequentialGroup()
						.addComponent(btnCancel, GroupLayout.DEFAULT_SIZE, 213, Short.MAX_VALUE)
						.addGap(18)
						.addComponent(btnPrevious, GroupLayout.PREFERRED_SIZE, 267, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.UNRELATED)
						.addComponent(btnIpdRecipt, GroupLayout.PREFERRED_SIZE, 267, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(btnBillReprint, GroupLayout.PREFERRED_SIZE, 267, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(btnResciptReprint, GroupLayout.PREFERRED_SIZE, 267, GroupLayout.PREFERRED_SIZE)
						.addGap(2))))
	);
	gl_panel_2.setVerticalGroup(
		gl_panel_2.createParallelGroup(Alignment.TRAILING)
			.addGroup(gl_panel_2.createSequentialGroup()
				.addGap(16)
				.addComponent(panel_4, GroupLayout.PREFERRED_SIZE, 307, GroupLayout.PREFERRED_SIZE)
				.addPreferredGap(ComponentPlacement.RELATED)
				.addGroup(gl_panel_2.createParallelGroup(Alignment.LEADING, false)
					.addComponent(comboBox_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addComponent(textField, GroupLayout.DEFAULT_SIZE, 29, Short.MAX_VALUE))
				.addPreferredGap(ComponentPlacement.RELATED)
				.addComponent(panel_3, GroupLayout.PREFERRED_SIZE, 214, GroupLayout.PREFERRED_SIZE)
				.addPreferredGap(ComponentPlacement.RELATED)
				.addGroup(gl_panel_2.createParallelGroup(Alignment.LEADING)
					.addComponent(btnDischarge, 0, 0, Short.MAX_VALUE)
					.addGroup(gl_panel_2.createParallelGroup(Alignment.LEADING, false)
						.addGroup(gl_panel_2.createParallelGroup(Alignment.BASELINE)
							.addComponent(btnBack, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)
							.addComponent(btnDischargeSummery_1, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)
							.addComponent(btnBilling, 0, 0, Short.MAX_VALUE))
						.addComponent(btnNewButton_3, Alignment.TRAILING))
					.addComponent(btnImport, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE))
				.addPreferredGap(ComponentPlacement.RELATED)
				.addGroup(gl_panel_2.createParallelGroup(Alignment.TRAILING)
					.addComponent(btnCancel, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)
					.addGroup(gl_panel_2.createSequentialGroup()
						.addGroup(gl_panel_2.createParallelGroup(Alignment.LEADING)
							.addComponent(btnIpdRecipt, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)
							.addGroup(gl_panel_2.createParallelGroup(Alignment.BASELINE)
								.addComponent(btnBillReprint, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)
								.addComponent(btnResciptReprint, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE))
							.addComponent(btnPrevious, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE))
						.addContainerGap())))
	);
	
	JLabel lblUnderDoctor = new JLabel("Under Doctor");
	lblUnderDoctor.setForeground(new Color(60, 179, 113));
	lblUnderDoctor.setFont(new Font("SansSerif", Font.BOLD, 18));
	lblUnderDoctor.setBounds(754, 67, 155, 24);
	panel_4.add(lblUnderDoctor);
	
	re_drname = new JTextField();
	dr = new TextAutoCompleter(re_drname);
	
	/*Dr.Ujjwal Bansal
	Dr.Bharti Bansal
	Dr.O.P. Bansal
	Dr. Jitender Nagpal*/
	
	dr.addItem("Dr.Ujjwal Bansal");
	dr.addItem("Dr.Bharti Bansal");
	dr.addItem("Dr.O.P. Bansal");
	dr.addItem("Dr. Jitender Nagpal");
	re_drname.setText(drree);
	re_drname.setFont(new Font("Tahoma", Font.PLAIN, 22));
	re_drname.setColumns(10);
	re_drname.setBounds(919, 65, 185, 33);
	panel_4.add(re_drname);
	
	JButton btnAddmit = new JButton("Admit");
	btnAddmit.setForeground(new Color(0, 0, 255));
	btnAddmit.setFont(new Font("Verdana", Font.BOLD, 20));
	btnAddmit.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			
			
			
			rgno();
			
			int dialogResult = JOptionPane.showConfirmDialog (null, "Do You Want to Confirm Addmit this Addmision" );
			if(dialogResult == JOptionPane.YES_OPTION){
			
			
			String date;
			LocalDateTime now = LocalDateTime.now();
			date = dtf.format(now);
			
			Calendar cal =new GregorianCalendar();
			int second = cal.get(Calendar.SECOND);
			int minute = cal.get(Calendar.MINUTE);
			int hour = cal.get(Calendar.HOUR);
			
			
			String time = hour+":"+minute+":"+second;
			
			if(rstatus.equalsIgnoreCase("Admit"))
			{
				
				
				JOptionPane.showMessageDialog(null, "Hello Dear This Patient is Already Admit in Your Current IPD");
			}
			else
			{	
			try {
				conn =DriverManager.getConnection("jdbc:ucanaccess://sbbh.accdb"); 
				String query = "Insert into  ipd_admit (ipd_no,name,fname,mobile,city,state,Address,sex,age,date,time,doctorname,refby,cate,highrisk,room_no,bed_no,reason,dis_date,status,bill,uhid,diagnose) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?) ";
				PreparedStatement pst = conn.prepareStatement(query);
				pst.setString(1, ipd.getText());
				pst.setString(2, reg_name.getText());
				pst.setString(3, reg_fname.getText());
				pst.setString(4, reg_mobile.getText());
				pst.setString(5, reg_city.getText());
				pst.setString(6, reg_state.getText());
				pst.setString(7, reg_address.getText());
				pst.setString(8, sex2.getSelectedItem().toString());
				pst.setString(9, reg_age.getText());
				pst.setString(10, date);
				pst.setString(11, time);
				pst.setString(12, re_drname.getText());
				pst.setString(13, rfby.getText());
				pst.setString(14, categ.getSelectedItem().toString());
				pst.setString(15, high_detail.getSelectedItem().toString());
				pst.setString(16, comboBox.getSelectedItem().toString());
				pst.setString(17, bed.getSelectedItem().toString());
				pst.setString(18, reason.getText());
				pst.setString(19, "---");
				pst.setString(20, "Admit");
				pst.setString(21, billing.getSelectedItem().toString());
				pst.setString(22, uhid.getText());
				pst.setString(23, dignose.getText());
				pst.execute();
				pst.close();
				
				
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		
			
			try
			{
				conn =DriverManager.getConnection("jdbc:ucanaccess://sbbh.accdb");
				String query ="Update  Book_room set status=? where bed_no = '"+bed.getSelectedItem().toString()+"' AND room_no = '"+comboBox.getSelectedItem().toString()+"' "; 
				PreparedStatement ps  = conn.prepareStatement(query);
				
				
				ps.setString(1, "Book");
				
				
				
				ps.executeUpdate();
				ps.close();
				
				
				
			
				
				
				

				
			}
			catch(Exception ee)
			{
				ee.printStackTrace();
			}
			
			
			String name =reg_name.getText().toString();
			String mobile = reg_mobile.getText().toString();
			
			String lab_record = name.concat(mobile).concat("lab_report");
			
			
			
			
			
			
			
			try {
				data1();
			} catch (ClassNotFoundException e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
			}
			rgno();
			
			String namee =reg_name.getText().toString();
    		String mobilee = reg_mobile.getText().toString();
    		String datee = addmission_date.getText().toString();
    		service = namee.concat(mobilee).concat("medicine");
    		
    		for(int j=0; j < service.length(); j++) {
				 
				 service = service.replace(" ", "");
			
				 
				}
			
    	
    		try
  			{
    			
    			conn =DriverManager.getConnection("jdbc:ucanaccess://sbbh.accdb"); 
    			String query="CREATE  TABLE  "+service+" (Sno INTEGER PRIMARY KEY  NOT NULL,Date Text, Drugs Text,Dose Text,Frequency Text,Days Text)";
  				Statement pst=conn.createStatement();
  				pst.executeUpdate(query);
  				
  			
  			}
			
			catch(Exception e1)
			{
				e1.printStackTrace();
			}
			
			}
			
			
    		
			name();
		   	try {
				data1();
			} catch (ClassNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		   	rgno();
		   	room();
		   	icd();

		   
    		  
    		   
    		   
    		
			}	
		}
	});
	btnAddmit.setBounds(235, 201, 154, 31);
	panel_4.add(btnAddmit);
	
	JLabel lblRoom = new JLabel("Room");
	lblRoom.setForeground(new Color(60, 179, 113));
	lblRoom.setFont(new Font("SansSerif", Font.BOLD, 18));
	lblRoom.setBounds(294, 158, 53, 24);
	panel_4.add(lblRoom);
	
	
	
	bed = new JComboBox();
	bed.setOpaque(true);
	bed.setForeground(Color.BLACK);
	bed.setFont(new Font("Tahoma", Font.PLAIN, 20));
	bed.setBackground(Color.GREEN);
	bed.setBounds(561, 154, 185, 33);
	panel_4.add(bed);
	
	
	
    red	= new JComboBox();
    red.setOpaque(true);
    red.setForeground(Color.BLACK);
    red.setFont(new Font("Tahoma", Font.PLAIN, 20));
    red.setBackground(Color.RED);
    red.setBounds(767, 156, 138, 30);
    panel_4.add(red);
    
    comboBox = new JComboBox();
    comboBox.addActionListener(new ActionListener() {
    	public void actionPerformed(ActionEvent arg0) {
    		
    		
    		String ss = "UNBook";
    		bed.removeAllItems();
    	 try { 
    		conn =DriverManager.getConnection("jdbc:ucanaccess://sbbh.accdb");
    		Statement statement = conn.createStatement();
            String query = "SELECT DISTINCT bed_no FROM book_room where status = '"+ss+"' AND room_no = '"+comboBox.getSelectedItem().toString()+"' ";
            ResultSet rs = statement.executeQuery(query);

           while (rs.next())
           {      
              
           	String s = rs.getString("bed_no");
           
           	bed.addItem(s);
           	
           	
           	
           
               
           }//end while
           conn.close();
           } catch (Exception e1) {
                e1.printStackTrace();
           }
    	 
    	 
    	 
    	String sss = "Book";
		red.removeAllItems();
		 try { 
			conn =DriverManager.getConnection("jdbc:ucanaccess://sbbh.accdb");
			Statement statement = conn.createStatement();
	        String query = "SELECT DISTINCT bed_no FROM book_room where status = '"+sss+"' AND room_no = '"+comboBox.getSelectedItem().toString()+"' ";
	        ResultSet rs = statement.executeQuery(query);

	       while (rs.next())
	       {      
	          
	       	String s = rs.getString("bed_no");
	       
	       	red.addItem(s);
	       	
	       	
	       	
	       
	           
	       }//end while
	       conn.close();
	       } catch (Exception e1) {
	            e1.printStackTrace();
	       }
    		
    		
    	}
    });
    comboBox.setOpaque(true);
    comboBox.setFont(new Font("Tahoma", Font.PLAIN, 20));
    comboBox.setForeground(Color.BLACK);
    comboBox.setBackground(Color.GREEN);
    comboBox.setBounds(360, 153, 185, 33);
    panel_4.add(comboBox);
    
    JButton btnDiscahrge = new JButton("Discharge");
    btnDiscahrge.setForeground(new Color(0, 0, 255));
    btnDiscahrge.setFont(new Font("Verdana", Font.BOLD, 20));
    btnDiscahrge.addActionListener(new ActionListener() {
    	public void actionPerformed(ActionEvent arg0) {
    		
    		
    		int dialogResult = JOptionPane.showConfirmDialog (null, "Do You Want to confirm Discharge This Patient" );
			if(dialogResult == JOptionPane.YES_OPTION)
			{
				
				
				int dialogResult1 = JOptionPane.showConfirmDialog (null, "Do You Want to confirm Discharge This Patient" );
				if(dialogResult1 == JOptionPane.YES_OPTION)
				{
						
    		
    		
    		
    		try
			{
    			conn =DriverManager.getConnection("jdbc:ucanaccess://sbbh.accdb");
				String query ="Update  Book_room set status=? where bed_no = '"+red.getSelectedItem().toString()+"' AND room_no = '"+comboBox.getSelectedItem().toString()+"' "; 
				PreparedStatement ps  = conn.prepareStatement(query);
				
				
				ps.setString(1, "UNBook");
				
				ps.executeUpdate();
				ps.close();
				
			
				
			}
			catch(Exception ee)
			{
				ee.printStackTrace();
			}
    		
    		
    		String date;
    		LocalDateTime now = LocalDateTime.now();
    		date = dtf.format(now);
    		
    		
    		try
			{
    			conn =DriverManager.getConnection("jdbc:ucanaccess://sbbh.accdb");
				String query ="Update  ipd_admit set dis_date=?,status=? where date = '"+dd+"' AND time = '"+tt+"' "; 
				PreparedStatement ps  = conn.prepareStatement(query);
				
				
				ps.setString(1, date);
				ps.setString(2,"Discharge");
				
				
				
				ps.executeUpdate();
				ps.close();
				
			
				
			}
			catch(Exception ee)
			{
				ee.printStackTrace();
			}
    		
    		
    		
    		
    		
    		mrdno();
			
			Calendar cal =new GregorianCalendar();
			int second = cal.get(Calendar.SECOND);
			int minute = cal.get(Calendar.MINUTE);
			int hour = cal.get(Calendar.HOUR);
			
			
			String time = hour+":"+minute+":"+second;
			
			
			try {
				conn1 =DriverManager.getConnection("jdbc:sqlite:print.sqlite"); 
				String query = "Insert into  ipd_dis (ipd,name,fname,mobile,city,state,Address,sex,age,date,time,doctorname,refby,cate,highrisk,room_no,bed_no,reason,dis_date,status,bill,uhid,diagnose,mrd) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?) ";
				PreparedStatement pst = conn1.prepareStatement(query);
				pst.setString(1, ipd.getText());
				pst.setString(2, reg_name.getText());
				pst.setString(3, reg_fname.getText());
				pst.setString(4, reg_mobile.getText());
				pst.setString(5, reg_city.getText());
				pst.setString(6, reg_state.getText());
				pst.setString(7, reg_address.getText());
				pst.setString(8, sex2.getSelectedItem().toString());
				pst.setString(9, reg_age.getText());
				pst.setString(10, addmission_date.getText());
				pst.setString(11, time);
				pst.setString(12, re_drname.getText());
				pst.setString(13, rfby.getText());
				pst.setString(14, categ.getSelectedItem().toString());
				pst.setString(15, high_detail.getSelectedItem().toString());
				pst.setString(16, comboBox.getSelectedItem().toString());
				pst.setString(17, red.getSelectedItem().toString());
				pst.setString(18, reason.getText());
				pst.setString(19, date);
				pst.setString(20, "discharge");
				pst.setString(21, billing.getSelectedItem().toString());
				pst.setString(22, uhid.getText());
				pst.setString(23, dignose.getText());
				pst.setString(24, mrd);
				pst.execute();
				pst.close();
				
				
				JOptionPane.showMessageDialog(null, "Patient Discharged");
				
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

    		room();
    		rgno();
    		try {
				data1();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    		
    		name();
		   	try {
				data1();
			} catch (ClassNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		   	rgno();
		   	room();
		   	icd();
    		
		   	
    		
				

    	}}}
    });
    btnDiscahrge.setBounds(235, 244, 155, 32);
    panel_4.add(btnDiscahrge);
    
    JLabel lblUhid = new JLabel("UHID");
    lblUhid.setForeground(new Color(60, 179, 113));
    lblUhid.setFont(new Font("SansSerif", Font.BOLD, 18));
    lblUhid.setBounds(183, 15, 47, 24);
    panel_4.add(lblUhid);
    
    uhid = new JTextField();
    uhid.selectAll();
    uhid.setText(sid);
    uhid.setFont(new Font("Tahoma", Font.PLAIN, 22));
    uhid.setColumns(10);
    uhid.setBounds(235, 13, 89, 27);
    uhid.addKeyListener(new KeyAdapter() {
   		@Override
   		public void keyPressed(KeyEvent e) {
   			
   			if(e.getKeyCode()==KeyEvent.VK_ENTER)
   			{
   				
   				try
   				{
   																		
   					conn2 =DriverManager.getConnection("jdbc:ucanaccess://bansal.accdb");  
   					 Statement statement1 = conn2.createStatement();
   		    			String query1=  "select *  from  uhid where uhid = '"+uhid.getText().toString()+"' ";
   		    			 ResultSet rs1 = statement1.executeQuery(query1);
   					 while (rs1.next())
   				            {  
   								
   								reg_name.setText(rs1.getString("name"));
   								reg_fname.setText(rs1.getString("fname"));
   								reg_mobile.setText(rs1.getString("mobile"));
   								reg_city.setText(rs1.getString("city"));
   								reg_state.setText(rs1.getString("state"));
   								reg_address.setText(rs1.getString("Address"));
   								sex2.setSelectedItem(rs1.getString("sex"));
   								reg_age.setText(rs1.getString("age"));
   								reg_state.setText(rs1.getString("state"));
   							
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
    panel_4.add(uhid);
    
    JButton btnNewButton = new JButton("Room Manager");
    btnNewButton.setForeground(new Color(0, 0, 255));
    btnNewButton.setFont(new Font("Verdana", Font.BOLD, 18));
    btnNewButton.addActionListener(new ActionListener() {
    	public void actionPerformed(ActionEvent arg0) {
    		
    		
    		String arr[] = {"ss"};
			Room_Manager.main(arr);
    		
    	}
    });
    btnNewButton.setBounds(424, 198, 190, 31);
    panel_4.add(btnNewButton);
    
    JLabel lblReason = new JLabel("Diagnose");
    lblReason.setForeground(new Color(60, 179, 113));
    lblReason.setFont(new Font("SansSerif", Font.BOLD, 18));
    lblReason.setBounds(474, 101, 109, 40);
    panel_4.add(lblReason);
    
    reasonchoice = new JComboBox();
    reasonchoice.addActionListener(new ActionListener() {
    	public void actionPerformed(ActionEvent arg0) {
    		
    		
    		/*ac2.removeAllItems();
    		if(reasonchoice.getSelectedItem().toString().equals("Operate"))
    		{	
    		ac2.removeAllItems();
			
    		try { 
    			conn1 =DriverManager.getConnection("jdbc:sqlite:print.sqlite"); 
    			Statement statement = conn1.createStatement();
                String query = "SELECT DISTINCT name FROM image ";
                ResultSet rs = statement.executeQuery(query);

                while (rs.next())
                {      
                   
                	
                	String s = rs.getString("name");
                	
                	ac2.addItem(s);
                	
                
                    
                }//end while
                conn1.close();
                } catch (Exception e1) {
                     e1.printStackTrace();
                }
    		}
    		else if(reasonchoice.getSelectedItem().toString().equals("Genral Admit"))
    		{
    			reason.setText("Genral Admit");
    		}	*/
    		
    		reason.append(reasonchoice.getSelectedItem().toString().concat(" "));
    	}
    });
    reasonchoice.setModel(new DefaultComboBoxModel(new String[] {"Genral Admit", "Operate", "App", "INGUINAL HERNIA", "LEFT PCNL", "LEFT URSL", "PUCL", "RIGHT RIRS", "TAH", "TURP", "VIU"}));
    reasonchoice.setForeground(new Color(0, 153, 0));
    reasonchoice.setFont(new Font("SansSerif", Font.PLAIN, 18));
    reasonchoice.setBounds(726, 104, 185, 39);
    panel_4.add(reasonchoice);
    
   
    
    JButton btnNewButton_1 = new JButton("Add Lab");
    btnNewButton_1.setForeground(new Color(0, 0, 255));
    btnNewButton_1.setFont(new Font("Verdana", Font.BOLD, 18));
    btnNewButton_1.addActionListener(new ActionListener() {
    	 public void actionPerformed(ActionEvent arg0) {
    		
    		
    		
    		
    		
    		String name =reg_name.getText().toString();
    		String mobile = reg_mobile.getText().toString();
    		
    		String lab_record = name.concat(mobile).concat("lab_report");
    		String lab_record1 = name.concat(mobile).concat("lab_report1");
    		
    		for(int j=0; j < lab_record.length(); j++) {
				 
				 lab_record = lab_record.replace(" ", "");
			
				 
				}
    		
    		
    		
    		
			
    		for(int j=0; j < lab_record1.length(); j++) {
				 
				 lab_record1 = lab_record1.replace(" ", "");
			
				 
				}
    		
    		
    		
    		
    		
    		
    		for(int j=0; j < lab_record.length(); j++) {
				 
				 lab_record = lab_record.replace(".", "");
			
				 
				}
   		
   		
   		
   		
			
   		for(int j=0; j < lab_record1.length(); j++) 
   		{
				 
				 lab_record1 = lab_record1.replace(".", "");
			
				 
		}
    		
    		
   		
   			
    		try
  			{
    			conn3 =DriverManager.getConnection("jdbc:ucanaccess://bsshlab.accdb");  
  				String query="CREATE  TABLE  "+lab_record+" (Sno INTEGER PRIMARY KEY  NOT NULL,Date Text,HB Text,Tlc Text,Creat Text,RBS Text,Ot_Pt Text,ALP Text,TBili Text,PSA Text,Viral Text,Blood Text,Other Text )";
  				PreparedStatement pst=conn3.prepareStatement(query);
  				
  				pst.executeUpdate();
  				
  			}
			
			catch(Exception e1)
			{
				e1.printStackTrace();
			}
    		
    		try
  			{
    			conn3 =DriverManager.getConnection("jdbc:ucanaccess://bsshlab.accdb");   
  				String query="CREATE  TABLE  "+lab_record1+" (record Text)";
  				PreparedStatement pst=conn3.prepareStatement(query);
  				
  				pst.executeUpdate();
  				
  				
  			}
			
			catch(Exception e1)
			{
				e1.printStackTrace();
			}
    		
    		String s[]= {lab_record,lab_record1};
    		lab_test.main(s);	
    		
    	}
    });
    btnNewButton_1.setBounds(424, 242, 190, 33);
    panel_4.add(btnNewButton_1);
    
    JButton btnNewButton_2 = new JButton("RELOAD");
    btnNewButton_2.setFont(new Font("Verdana", Font.BOLD, 18));
    btnNewButton_2.setForeground(new Color(0, 0, 255));
    btnNewButton_2.addActionListener(new ActionListener() {
    	public void actionPerformed(ActionEvent arg0) {
    		
    		name();
    	   
    		
    	}
    });
    btnNewButton_2.setBounds(638, 243, 174, 31);
    panel_4.add(btnNewButton_2);
    
    JButton btnAddService = new JButton("Add service");
    btnAddService.setForeground(new Color(0, 0, 255));
    btnAddService.setFont(new Font("Verdana", Font.BOLD, 18));
    btnAddService.addActionListener(new ActionListener() {
    	public void actionPerformed(ActionEvent arg0) {
    		
    		
    		String name =reg_name.getText().toString();
    		String mobile = reg_mobile.getText().toString();
    		
    		service = name.concat(mobile).concat("service");
    		for(int j=0; j < service.length(); j++) {
				 
				 service = service.replace(" ", "");
			
				 
				}
			
    		try
  			{
    			
    			conn =DriverManager.getConnection("jdbc:ucanaccess://sbbh.accdb"); 
    			String query="CREATE  TABLE  "+service+" (Sno INTEGER PRIMARY KEY  NOT NULL,Date Text, Service Text,qty Text,rate Text,Amount Text)";
  				Statement pst=conn.createStatement();
  				pst.executeUpdate(query);
  				
  				JOptionPane.showMessageDialog(null, service);
  				
  			}
			
			catch(Exception e1)
			{}
    		
    		String s[]= {service};
    		admitservice.main(s);
    		
    	}
    });
    btnAddService.setBounds(638, 196, 174, 33);
    panel_4.add(btnAddService);
    
    JLabel lblAddmisionDate = new JLabel("DOA\n");
    lblAddmisionDate.setForeground(new Color(60, 179, 113));
    lblAddmisionDate.setFont(new Font("SansSerif", Font.BOLD, 18));
    lblAddmisionDate.setBounds(1139, 115, 55, 24);
    panel_4.add(lblAddmisionDate);
    
    addmission_date = new JTextField();
    addmission_date.setText((String) null);
    addmission_date.setFont(new Font("Tahoma", Font.PLAIN, 22));
    addmission_date.setColumns(10);
    addmission_date.setBounds(1197, 110, 109, 33);
    panel_4.add(addmission_date);
    
    JButton transfer = new JButton("Room Transfer");
    transfer.setForeground(new Color(0, 0, 255));
    transfer.setFont(new Font("Verdana", Font.BOLD, 18));
    transfer.addActionListener(new ActionListener() {
    	public void actionPerformed(ActionEvent e) {
    		
    		String statu = "UNBook";
    		
    		JComboBox  cd2 = (JComboBox) new JComboBox<>();
    		JComboBox  cd3 = (JComboBox) new JComboBox<>();
    		try { 
    			conn =DriverManager.getConnection("jdbc:ucanaccess://sbbh.accdb");
    			Statement statement = conn.createStatement();
                String query = "SELECT DISTINCT room_no FROM book_room where status = '"+statu+"' ";
                ResultSet rs = statement.executeQuery(query);

                while (rs.next())
                {      
                   
                	
                	String s = rs.getString("room_no");
                	
                	cd2.addItem(s);
                	
                
                    
                }//end while
                conn.close();
                } catch (Exception e1) {
                     e1.printStackTrace();
                }
    		
    		
    		
    		
    		 JComponent[] inputs = new JComponent[] {
				       
			        	
					 	new JLabel("Room No"),
						cd2,
						new JLabel("Bed No"),
						cd3
						
			       
			        
			        
			};
    		 
    		 cd2.addActionListener(new ActionListener() {
			    	public void actionPerformed(ActionEvent arg0) {
			    		
			    		
			    		cd3.removeAllItems();
			    		String statuu = "UNBook";
			    		try { 
			    			conn =DriverManager.getConnection("jdbc:ucanaccess://sbbh.accdb");
			    			Statement statement = conn.createStatement();
			                String query = "SELECT DISTINCT bed_no FROM book_room where status = '"+statuu+"' AND room_no = '"+cd2.getSelectedItem().toString()+"' ";
			                
			                ResultSet rs = statement.executeQuery(query);

			                while (rs.next())
			                {      
			                   
			                	
			                	String s = rs.getString("bed_no");
			                	cd3.addItem(s);
			               
			                }//end while
			                conn.close();
			                } catch (Exception e1) {
			                     e1.printStackTrace();
			                }
			    			
			    		
			    		
			    		
			    	}
			    });
    		 
    		 int result = JOptionPane.showConfirmDialog(null, inputs, "Choice Room and Bed", JOptionPane.PLAIN_MESSAGE);
				if (result == JOptionPane.OK_OPTION) 
				{
					
					try
	    			{
	        			conn =DriverManager.getConnection("jdbc:ucanaccess://sbbh.accdb");
	    				String query ="Update  Book_room set status=? where bed_no = '"+red.getSelectedItem().toString()+"' AND room_no = '"+comboBox.getSelectedItem().toString()+"' "; 
	    				PreparedStatement ps  = conn.prepareStatement(query);
	    				
	    				
	    				ps.setString(1, "UNBook");
	    				
	    				
	    				
	    				ps.executeUpdate();
	    				ps.close();
	    				
	    			
	    				
	    			}
	    			catch(Exception ee)
	    			{
	    				ee.printStackTrace();
	    			}
					
					
					
					try
					{
						conn =DriverManager.getConnection("jdbc:ucanaccess://sbbh.accdb");
						String query ="Update  Book_room set status=? where bed_no = '"+cd3.getSelectedItem().toString()+"' AND room_no = '"+cd2.getSelectedItem().toString()+"' "; 
						PreparedStatement ps  = conn.prepareStatement(query);
						
						
						ps.setString(1, "Book");
						
						
						
						ps.executeUpdate();
						ps.close();
						
						
						
					
						
						
						

						
					}
					catch(Exception ee)
					{
						ee.printStackTrace();
					}
		    		
		    		try
					{
		    			conn =DriverManager.getConnection("jdbc:ucanaccess://sbbh.accdb");
						String query ="Update  ipd_admit set room_no=?,bed_no=? where date = '"+dd+"' AND time = '"+tt+"' "; 
						PreparedStatement ps  = conn.prepareStatement(query);
						
						
						ps.setString(1, cd2.getSelectedItem().toString());
						ps.setString(2,	cd3.getSelectedItem().toString());
						
						
						
						ps.executeUpdate();
						ps.close();
						
					
						
					}
					catch(Exception ee)
					{
						ee.printStackTrace();
					}
		    		room();
		    		try {
						data1();
					} catch (ClassNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
				}
    		
    		
    		
    		
    		
    	}
    });
    transfer.setBounds(829, 243, 190, 31);
    panel_4.add(transfer);
    
    JButton btnAddMedicine = new JButton("Add Medicine");
    btnAddMedicine.setForeground(new Color(0, 0, 255));
    btnAddMedicine.setFont(new Font("Verdana", Font.BOLD, 18));
    btnAddMedicine.addActionListener(new ActionListener() {
    	public void actionPerformed(ActionEvent e) {
    		
    		String name =reg_name.getText().toString();
    		String mobile = reg_mobile.getText().toString();
    		String date = addmission_date.getText().toString();
    		service = name.concat(mobile).concat("medicine");
    		
    		for(int j=0; j < service.length(); j++) {
				 
				 service = service.replace(" ", "");
			
				 
				}
			
    	
    		try
  			{
    			
    			conn =DriverManager.getConnection("jdbc:ucanaccess://sbbh.accdb"); 
    			String query="CREATE  TABLE  "+service+" (Sno INTEGER PRIMARY KEY  NOT NULL,Date Text, Drugs Text,Dose Text,Frequency Text,Days Text)";
  				Statement pst=conn.createStatement();
  				pst.executeUpdate(query);
  				
  			
  			}
			
			catch(Exception e1)
			{
				e1.printStackTrace();
			}
    		
    		String s[] = {service};
    		medicine.main(s);
    	
    	}
    });
    btnAddMedicine.setBounds(829, 197, 190, 35);
    panel_4.add(btnAddMedicine);
    
    JLabel lblRefby = new JLabel("RefBy");
    lblRefby.setForeground(new Color(60, 179, 113));
    lblRefby.setFont(new Font("SansSerif", Font.BOLD, 18));
    lblRefby.setBounds(10, 149, 69, 24);
    panel_4.add(lblRefby);
    
    rfby = new JTextField();
    rfby.setFont(new Font("Tahoma", Font.PLAIN, 22));
    rfby.setText(rfee);
    
    	rfby.setColumns(10);
    	rfby.setBounds(101, 148, 181, 26);
    	panel_4.add(rfby);
    	
    	categ = new JComboBox();
    	categ.setModel(new DefaultComboBoxModel(new String[] {"BSBY", "CASH", "PM", "PWM", "INSURANCE", "FREE"}));
    	categ.setOpaque(true);
    	categ.setForeground(new Color(0, 0, 255));
    	categ.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 20));
    	categ.setBackground(new Color(255, 255, 255));
    	categ.setBounds(1111, 62, 201, 38);
    	panel_4.add(categ);
    	
    	high_detail = new JComboBox();
    	high_detail.setModel(new DefaultComboBoxModel(new String[] {"None", "Diabtbes", "Hypertension", "Diabtbes+Hypertension"}));
    	high_detail.setOpaque(true);
    	high_detail.setForeground(Color.BLUE);
    	high_detail.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 20));
    	high_detail.setBackground(Color.WHITE);
    	high_detail.setBounds(295, 102, 174, 38);
    	panel_4.add(high_detail);
    	
    	JLabel lblBilling = new JLabel("Billing");
    	lblBilling.setForeground(new Color(60, 179, 113));
    	lblBilling.setFont(new Font("SansSerif", Font.BOLD, 18));
    	lblBilling.setBounds(10, 203, 91, 28);
    	panel_4.add(lblBilling);
    	
    	billing = new JComboBox();
    	billing.setModel(new DefaultComboBoxModel(new String[] {"Bill Yes", "Bill No"}));
    	billing.setOpaque(true);
    	billing.setForeground(Color.BLUE);
    	billing.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 20));
    	billing.setBackground(Color.WHITE);
    	billing.setBounds(101, 201, 119, 33);
    	panel_4.add(billing);
    	
    	dignose = new JTextField();
    	dignose.setText((String) null);
    	dignose.setFont(new Font("Tahoma", Font.PLAIN, 22));
    	dignose.setColumns(10);
    	dignose.setBounds(568, 104, 151, 35);
    	panel_4.add(dignose);
    	
    	JButton btnCancelAdmission = new JButton("Cancel");
    	btnCancelAdmission.addActionListener(new ActionListener() {
    		public void actionPerformed(ActionEvent arg0) {
    			
    			try
    			{
        			conn =DriverManager.getConnection("jdbc:ucanaccess://sbbh.accdb");
    				String query ="Update  Book_room set status=? where bed_no = '"+red.getSelectedItem().toString()+"' AND room_no = '"+comboBox.getSelectedItem().toString()+"' "; 
    				PreparedStatement ps  = conn.prepareStatement(query);
    				
    				
    				ps.setString(1, "UNBook");
    				
    				
    				
    				ps.executeUpdate();
    				ps.close();
    				
    			
    				
    			}
    			catch(Exception ee)
    			{
    				ee.printStackTrace();
    			}
        		
        		
        		String date;
        		LocalDateTime now = LocalDateTime.now();
        		date = dtf.format(now);
        		
        		
        		try
    			{
        			conn =DriverManager.getConnection("jdbc:ucanaccess://sbbh.accdb");
    				String query ="Update  ipd_admit set dis_date=?,status=? where date = '"+dd+"' AND time = '"+tt+"' "; 
    				PreparedStatement ps  = conn.prepareStatement(query);
    				
    				
    				ps.setString(1, date);
    				ps.setString(2,"Cancel");
    				
    				
    				
    				ps.executeUpdate();
    				ps.close();
    				
    			
    				
    			}
    			catch(Exception ee)
    			{
    				ee.printStackTrace();
    			}
        		room();
        		try {
					data1();
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
    			
    		}
    	});
    	btnCancelAdmission.setForeground(Color.BLUE);
    	btnCancelAdmission.setFont(new Font("Verdana", Font.BOLD, 18));
    	btnCancelAdmission.setBounds(1041, 197, 190, 32);
    	panel_4.add(btnCancelAdmission);
    	
    	JButton btnSticker = new JButton("Sticker");
    	btnSticker.addActionListener(new ActionListener() {
    		public void actionPerformed(ActionEvent arg0) {
    			
    			
    			
    			JTextField Choice = new JTextField();
				Choice.requestFocusInWindow();
				  JComponent[] inputs = new JComponent[] {
				        new JLabel("Date"),
				        	Choice,
				        	
				        new JLabel("Line choice"),
				        Choice,
				        
				      
				};
				int result = JOptionPane.showConfirmDialog(null, inputs, "Enter New Day Name Here", JOptionPane.PLAIN_MESSAGE);
				if (result == JOptionPane.OK_OPTION) {
					

					if(Choice.getText().toString().equals("1"))
					{
						
						
						printsticker1();
						
					}
					else if(Choice.getText().toString().equals("2"))
					{
						
						
						printline2();
						
					}	
					else if(Choice.getText().toString().equals("3"))
					{
						
						
						printline3();
						
					}	
					else if(Choice.getText().toString().equals("4"))
					{
						
						
						printline4();
						
					}	
					else if(Choice.getText().toString().equals("5"))
					{
						
						
						printline5();
						
					}
					else if(Choice.getText().toString().equals("6"))
					{
						
						
						printline6();
						
					}
					else if(Choice.getText().toString().equals("7"))
					{
						
						
						printline7();
						
					}	
					else if(Choice.getText().toString().equals("8"))
					{
						
						
						printline8();
						
					}
					
				}
    		
    		}
    	});
    	btnSticker.setForeground(Color.BLUE);
    	btnSticker.setFont(new Font("Verdana", Font.BOLD, 18));
    	btnSticker.setBounds(1041, 243, 190, 32);
    	panel_4.add(btnSticker);
    	
    	JButton btnImage = new JButton("Categ Update");
    	btnImage.addActionListener(new ActionListener() {
    		public void actionPerformed(ActionEvent e) {
    			
    			
    			
    			try
    			{
        			conn =DriverManager.getConnection("jdbc:ucanaccess://sbbh.accdb");
    				String query ="Update  ipd_admit set cate=? where ipd_no = '"+ipd.getText()+"'  "; 
    				PreparedStatement ps  = conn.prepareStatement(query);
    				
    				
    				ps.setString(1, categ.getSelectedItem().toString());
    			
    				
    				
    				
    				ps.executeUpdate();
    				ps.close();
    				
    			
    				
    			}
    			catch(Exception ee)
    			{
    				ee.printStackTrace();
    			}
        		
    			String value = "Admit"; 
       			
       			try
    			{
    																	
    				conn =DriverManager.getConnection("jdbc:ucanaccess://sbbh.accdb");
    				String query= "select *  from  ipd_admit where status = '"+value+"' ";
    				PreparedStatement statement= conn.prepareStatement(query);
    				ResultSet rs=statement.executeQuery();
    				contable.setModel(DbUtils.resultSetToTableModel(rs));
    				rs.close();
    				statement.close();
    				
    			}
    			catch(SQLException e1)
    			{
    					e1.printStackTrace();
    			}
    			
    		}
    	});
    	btnImage.setForeground(Color.BLUE);
    	btnImage.setFont(new Font("Verdana", Font.BOLD, 20));
    	btnImage.setBounds(40, 243, 185, 32);
    	panel_4.add(btnImage);
    	
    	JScrollPane scrollPane_11 = new JScrollPane();
    	scrollPane_11.setBounds(919, 115, 209, 77);
    	panel_4.add(scrollPane_11);
    	
    	reason = new JTextArea();
    	scrollPane_11.setViewportView(reason);
    	
    	JButton btnUpdateUhid = new JButton("update uhid");
    	btnUpdateUhid.addActionListener(new ActionListener() {
    		public void actionPerformed(ActionEvent e) {
    			
    			
    			try
    			{
    				conn =DriverManager.getConnection("jdbc:ucanaccess://sbbh.accdb");
    				String query ="Update uhid set name=?,fname=? where uhid = '"+uhid.getText().toString()+"'  "; 
    				PreparedStatement ps  = conn.prepareStatement(query);
    				
    				
    				ps.setString(1, reg_name.getText());
    				ps.setString(2, reg_fname.getText());
    				
    				
    				ps.executeUpdate();
    				ps.close();
    				
    				
    			
    				
    			}
    			catch(Exception ee)
    			{
    				ee.printStackTrace();
    			}
    			
    		}
    	});
    	btnUpdateUhid.setForeground(Color.BLUE);
    	btnUpdateUhid.setFont(new Font("Verdana", Font.BOLD, 18));
    	btnUpdateUhid.setBounds(1129, 159, 190, 32);
    	panel_4.add(btnUpdateUhid);
    	
    	JButton btnDu = new JButton("DIGNO");
    	btnDu.addActionListener(new ActionListener() {
    		public void actionPerformed(ActionEvent e) {
    			
    			try
    			{
        			conn =DriverManager.getConnection("jdbc:ucanaccess://sbbh.accdb");
    				String query ="Update  ipd_admit set diagnose=? where ipd_no = '"+ipd.getText()+"'  "; 
    				PreparedStatement ps  = conn.prepareStatement(query);
    				
    				
    				ps.setString(1, dignose.getText());
    			
    				
    				
    				
    				ps.executeUpdate();
    				ps.close();
    				
    			
    				
    			}
    			catch(Exception ee)
    			{
    				ee.printStackTrace();
    			}
    			
    			String value = "Admit"; 
       			
       			try
    			{
    																	
    				conn =DriverManager.getConnection("jdbc:ucanaccess://sbbh.accdb");
    				String query= "select *  from  ipd_admit where status = '"+value+"' ";
    				PreparedStatement statement= conn.prepareStatement(query);
    				ResultSet rs=statement.executeQuery();
    				contable.setModel(DbUtils.resultSetToTableModel(rs));
    				rs.close();
    				statement.close();
    				
    			}
    			catch(SQLException e1)
    			{
    					e1.printStackTrace();
    			}
    			
    		}
    	});
    	btnDu.setForeground(Color.BLUE);
    	btnDu.setFont(new Font("Verdana", Font.BOLD, 7));
    	btnDu.setBounds(1241, 197, 68, 24);
    	panel_4.add(btnDu);
    	
    	JScrollPane scrollPane_1 = new JScrollPane();
    	scrollPane_1.setBounds(10, 6, 1303, 176);
    	panel_3.add(scrollPane_1);
    	
    	contable = new JTable();
    	contable.addMouseListener(new MouseAdapter() {
    		@Override
    		public void mouseClicked(MouseEvent arg0) {
    			
    			
    			
    			
    			switch(check)
    			{
    			case 0:
    			i = contable.getSelectedRow();
    			ipd.setText(contable.getValueAt(i, 0).toString());
    			reg_name.setText(contable.getValueAt(i, 1).toString());
    			reg_fname.setText(contable.getValueAt(i, 2).toString());
    			reg_mobile.setText(contable.getValueAt(i, 3).toString());
    			reg_city.setText(contable.getValueAt(i, 4).toString());
    			reg_state.setText(contable.getValueAt(i, 5).toString());
    			reg_address.setText(contable.getValueAt(i, 6).toString());
    			sex2.setSelectedItem(contable.getValueAt(i, 7).toString());
    			reg_age.setText(contable.getValueAt(i, 8).toString());
    			addmission_date.setText(contable.getValueAt(i, 9).toString());
    			re_drname.setText(contable.getValueAt(i, 11).toString());
    			comboBox.setSelectedItem(contable.getValueAt(i, 12).toString());
    			red.setSelectedItem(contable.getValueAt(i, 13).toString());
    			reason.setText(contable.getValueAt(i, 14).toString());
    			
    			
    			roomm = contable.getValueAt(i, 12).toString();
    			ward = contable.getValueAt(i, 13).toString();
    			
    			rfby.setText(contable.getValueAt(i, 16).toString());
    			categ.setSelectedItem(contable.getValueAt(i, 17).toString());
    			high_detail.setSelectedItem(contable.getValueAt(i, 18).toString());
    			billing.setSelectedItem(contable.getValueAt(i, 20).toString());
    			uhid.setText(contable.getValueAt(i, 21).toString());
    			dignose.setText(contable.getValueAt(i, 22).toString());
    			
    			
    			dd = contable.getValueAt(i, 9).toString();
    			tt = contable.getValueAt(i, 10).toString();
    			dis = contable.getValueAt(i, 15).toString();
    			
    			
    			
    			
    			String namee =contable.getValueAt(i, 1).toString();
	    		String mobilee = contable.getValueAt(i, 3).toString();
	    		
	    		
	    		
	    		lbl.setText(namee.concat(mobilee));
	    		mrd = contable.getValueAt(i, 23).toString();
	    		
	    		
	    		rename = contable.getValueAt(i, 1).toString();
	    		redod =  contable.getValueAt(i, 15).toString();
	    		
	    		break;
	    		
    			case 1:
    				
    				
    			
        			i = contable.getSelectedRow();
        			ipd.setText(contable.getValueAt(i, 0).toString());
        			reg_name.setText(contable.getValueAt(i, 1).toString());
        			reg_fname.setText(contable.getValueAt(i, 2).toString());
        			reg_mobile.setText(contable.getValueAt(i, 3).toString());
        			reg_city.setText(contable.getValueAt(i, 4).toString());
        			reg_state.setText(contable.getValueAt(i, 5).toString());
        			reg_address.setText(contable.getValueAt(i, 6).toString());
        			sex2.setSelectedItem(contable.getValueAt(i, 7).toString());
        			reg_age.setText(contable.getValueAt(i, 8).toString());
        			addmission_date.setText(contable.getValueAt(i, 9).toString());
        			re_drname.setText(contable.getValueAt(i, 11).toString());
        			
        			comboBox.setSelectedItem(contable.getValueAt(i, 15).toString());
        			red.setSelectedItem(contable.getValueAt(i, 16).toString());
        			
        			reason.setText(contable.getValueAt(i, 18).toString());
        			
        			rfby.setText(contable.getValueAt(i, 12).toString());
        			categ.setSelectedItem(contable.getValueAt(i, 13).toString());
        			high_detail.setSelectedItem(contable.getValueAt(i, 14).toString());
        			billing.setSelectedItem(contable.getValueAt(i, 21).toString());
        			uhid.setText(contable.getValueAt(i, 22).toString());
        			dignose.setText(contable.getValueAt(i, 17).toString());
        			
        			
        			dd = contable.getValueAt(i, 9).toString();
        			tt = contable.getValueAt(i, 10).toString();
        			dis = contable.getValueAt(i, 15).toString();
        			
        			
        			rstatus = contable.getValueAt(i, 20).toString();
        			
        			
    	    		
    	    		break;
    	    			
	    		
	    		
    			}
    		}
    	});
    	contable.setSelectionForeground(new Color(255, 255, 255));
    	contable.setSelectionBackground(new Color(51, 204, 255));
    	contable.setFont(new Font("Tahoma", Font.PLAIN, 11));
    	contable.setRowHeight(30);
    	
   
    	scrollPane_1.setViewportView(contable);
    	panel_2.setLayout(gl_panel_2);
   	
   	JPanel addmission = new JPanel();
   	Regis.addTab("Addmission Paper", null, addmission, null);
   	addmission.setLayout(null);
   	
   	JPanel panel_7 = new JPanel();
   	panel_7.setBounds(10, 11, 1327, 600);
   	addmission.add(panel_7);
   	panel_7.setLayout(null);
   	
   	JScrollPane scrollPane_5 = new JScrollPane();
   	scrollPane_5.setBounds(20, 30, 631, 318);
   	panel_7.add(scrollPane_5);
   	
   	hindi = new JTextArea(10,20);
   	
   	hindi.setLineWrap(true);
   	hindi.setWrapStyleWord(true);
   	hindi.setFont(new Font("Kruti Dev 165", Font.PLAIN, 16));
   	
   	scrollPane_5.setViewportView(hindi);
   	
   	JButton btnWord = new JButton("Print");
   	btnWord.setFont(new Font("Lucida Grande", Font.PLAIN, 58));
   	btnWord.setBounds(1008, 494, 309, 95);
   	btnWord.addActionListener(new ActionListener() {
   		public void actionPerformed(ActionEvent arg0) {
   			
   			
   			
   			/*try {
   				s = hindi.getText().toString();
   				
				FileOutputStream  outputStream = new FileOutputStream("indor.docx");
				XWPFDocument doc = new XWPFDocument();
				XWPFParagraph paraTit = doc.createParagraph();
				paraTit.setAlignment(ParagraphAlignment.CENTER);
				XWPFRun paraTitRun =paraTit.createRun();
				paraTitRun.setBold(true);
				paraTitRun.setFontSize(12);
				paraTitRun.setText(english.getText().toString());
				paraTitRun.setText(s);
				doc.write(outputStream);
				outputStream.close();
				JOptionPane.showMessageDialog(null, "The Document Created");
				Desktop.getDesktop().open(new File("indor.docx"));
				
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
   			*/
   			
   			printopd1();
   			
   		}
   	});
   	panel_7.add(btnWord);
   	
   	JScrollPane scrollPane_6 = new JScrollPane();
   	scrollPane_6.setBounds(661, 30, 656, 318);
   	panel_7.add(scrollPane_6);
   	
   	english = new JTextArea();
   	scrollPane_6.setViewportView(english);
   	
   	JScrollPane scrollPane_4 = new JScrollPane();
   	scrollPane_4.setBounds(20, 359, 625, 218);
   	panel_7.add(scrollPane_4);
   	
   	english2 = new JTextArea();
   	scrollPane_4.setViewportView(english2);
   	
   	JPanel dischargepanel = new JPanel();
   	Regis.addTab("Discharge Summary", null, dischargepanel, null);
   	dischargepanel.setLayout(null);
   	
   	JPanel discharge = new JPanel();
   	discharge.setBounds(10, 11, 1337, 613);
   	dischargepanel.add(discharge);
   	discharge.setLayout(null);
   	
   	JScrollPane scrollPane = new JScrollPane();
   	scrollPane.setBounds(15, 53, 567, 150);
   	discharge.add(scrollPane);
   	
   	table = new JTable();
   	scrollPane.setViewportView(table);
   	
   	JButton btnNewButton_5 = new JButton("Lab Report");
   	btnNewButton_5.setFont(new Font("Tahoma", Font.BOLD, 18));
   	btnNewButton_5.addActionListener(new ActionListener() {
   		public void actionPerformed(ActionEvent arg0) {
   			
   			
   			String lab_record = lbl.getText().toString().concat("lab_report");
   			String lab_record1 = lbl.getText().toString().concat("lab_report1");
   			
   			for(int j=0; j < lab_record.length(); j++) 
   			{
				 
				 lab_record = lab_record.replace(" ", "");
			
				 
			}
   			
   			
   			
   			for(int j=0; j < lab_record1.length(); j++) 
   			{
				 
				 lab_record1 = lab_record1.replace(" ", "");
			
				 
			}
   			
   			try
			{
   															
   				conn3 =DriverManager.getConnection("jdbc:ucanaccess://bsshlab.accdb");
				String query= "select *  from  "+lab_record+" ";
				PreparedStatement statement= conn3.prepareStatement(query);
				ResultSet rs=statement.executeQuery();
				table.setModel(DbUtils.resultSetToTableModel(rs));
				rs.close();
				statement.close();
				
			}
			catch(SQLException e1)
			{
					e1.printStackTrace();
			}
   			
   			try{
   				conn3 =DriverManager.getConnection("jdbc:ucanaccess://bsshlab.accdb");
   				String query="Select * from "+lab_record1+" ";
   				PreparedStatement pst=conn3.prepareStatement(query);
   				ResultSet rs=pst.executeQuery();
   				while(rs.next())
   				{
   				
   					investigation.append(rs.getString("record"));
   					investigation.append("\n");
   				}
   				
   				rs.close();
   				pst.close();
   			}
   			catch(Exception ee)
   			{
   				ee.printStackTrace();
   			}
   			
   		}
   	});
   	btnNewButton_5.setBounds(15, 11, 171, 31);
   	discharge.add(btnNewButton_5);
   	
   	lbl = new JLabel("");
   	
   	lbl.setFont(new Font("Tahoma", Font.BOLD, 18));
   	lbl.setBounds(196, 11, 264, 31);
   	discharge.add(lbl);
   	
   	JScrollPane scrollPane_3 = new JScrollPane();
   	scrollPane_3.setBounds(15, 296, 567, 131);
   	discharge.add(scrollPane_3);
   	
   	med = new JTable();
   	med.setModel(jana);
   	scrollPane_3.setViewportView(med);
   	
   	JButton btnMedicine = new JButton("Medicine");
   	btnMedicine.setFont(new Font("Tahoma", Font.BOLD, 18));
   	btnMedicine.addActionListener(new ActionListener() {
   		public void actionPerformed(ActionEvent e) {
   			
   			
   			

   			String lab_record = lbl.getText().toString().concat("medicine");
   			
   			for(int j=0; j < lab_record.length(); j++) 
   			{
				 
				 lab_record = lab_record.replace(" ", "");
			
				 
			}
   			
   			
   			
   			/*while(jana.getRowCount() > 0)
   			{
   				
   				for(int i =0; i < jana.getRowCount();i++)
   				{
   					jana.removeRow(i);
   				}
   			}	*/
   			
   			try
			{
																	
   				conn =DriverManager.getConnection("jdbc:ucanaccess://sbbh.accdb"); 
				String query= "select *  from  "+lab_record+" ";
				PreparedStatement statement= conn.prepareStatement(query);
				ResultSet rs=statement.executeQuery();
				while (rs.next())
		            {  
						
					
					
				 		
						rows2[0]= rs.getString("Drugs");
						
						rows2[1]= rs.getString("Dose");
						
						rows2[2]= rs.getString("Frequency");
						
						rows2[3]= rs.getString("Days");
						
						jana.addRow(rows2);
						
			
		            }//end while
		
				rs.close();
				statement.close();
				
			}
			catch(SQLException e1)
			{
					e1.printStackTrace();
			}
   			
   			
   			/*int row = med.getRowCount();
   			int coloumn = med.getColumnCount();
   			for(int i=0;i<row;i++)
				
			{	
			
				
				//String col_name = table.getColumnName(k).toString();
				//textArea.append(col_name);
				//textArea.append("\n");
				
				
	   				
	   					for(int j=0;j<coloumn;j++)
	   					{
	   					//String ta = table.getValueAt(j, 1).toString();	
	   					String s = med.getValueAt(i,j).toString();
	   					textArea.append(s);
	   					textArea.append("\t\t");
	   					}
	   				textArea.append("\n");
	   			
			
			}
   			
   			textArea.append("\n");
   	*/
   			
   		}
   	});
   	btnMedicine.setBounds(15, 217, 171, 31);
   	discharge.add(btnMedicine);
   	
   	JLabel lblNewLabel = new JLabel("Clinical Examination");
   	lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
   	lblNewLabel.setBounds(592, 169, 203, 23);
   	discharge.add(lblNewLabel);
   	
   	JScrollPane scrollPane_7 = new JScrollPane();
   	scrollPane_7.setBounds(589, 203, 739, 101);
   	discharge.add(scrollPane_7);
   	
   	clinic = new JTextArea();
   	scrollPane_7.setViewportView(clinic);
   	
   	JLabel lblHistory = new JLabel("History");
   	lblHistory.setFont(new Font("Tahoma", Font.BOLD, 18));
   	lblHistory.setBounds(592, 327, 127, 23);
   	discharge.add(lblHistory);
   	
   	JScrollPane scrollPane_2 = new JScrollPane();
   	scrollPane_2.setBounds(595, 360, 733, 137);
   	discharge.add(scrollPane_2);
   	
   	History = new JTextArea();
   	scrollPane_2.setViewportView(History);
   	
   	JLabel lblInvestigation = new JLabel("Investigation");
   	lblInvestigation.setFont(new Font("Tahoma", Font.BOLD, 18));
   	lblInvestigation.setBounds(593, 508, 127, 23);
   	discharge.add(lblInvestigation);
   	
   	JScrollPane scrollPane_8 = new JScrollPane();
   	scrollPane_8.setBounds(595, 535, 733, 67);
   	discharge.add(scrollPane_8);
   	
   	investigation = new JTextArea();
   	scrollPane_8.setViewportView(investigation);
   	
   	JLabel lblOtNote = new JLabel("OT NOTE");
   	lblOtNote.setFont(new Font("Tahoma", Font.BOLD, 18));
   	lblOtNote.setBounds(592, 25, 127, 23);
   	discharge.add(lblOtNote);
   	
   	JScrollPane scrollPane_9 = new JScrollPane();
   	scrollPane_9.setBounds(592, 53, 736, 105);
   	discharge.add(scrollPane_9);
   	
   	otnote = new JTextArea();
   	scrollPane_9.setViewportView(otnote);
   	
   	JButton btnPrint_1 = new JButton("Print");
   	btnPrint_1.addActionListener(new ActionListener() {
   		public void actionPerformed(ActionEvent e) {
   			
   			String disname = lbl.getText().concat(dis);
   			
   			
   			for(int j=0; j < disname.length(); j++) {
				 
				 disname = disname.replace(" ", "");
			
				 
				}
   				disname = disname+".pdf";
   				
   				if(categ.getSelectedItem().toString().equals("BSBY"))
   				{
   					Document document = new Document(PageSize.A4,40,0,50,50);
   		   			try
   		   		      {     
   		   		         PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream(disname));
   		   		         document.open();
   		   		         Paragraph p = new Paragraph("",new com.itextpdf.text.Font(com.itextpdf.text.Font.FontFamily.TIMES_ROMAN,9,Font.BOLD));
   		   		         
   		   		         Paragraph p1 = new Paragraph("",new com.itextpdf.text.Font(com.itextpdf.text.Font.FontFamily.TIMES_ROMAN,12,Font.BOLD));
   		   		         BaseFont bf1 = BaseFont.createFont(BaseFont.HELVETICA, BaseFont.CP1252, BaseFont.NOT_EMBEDDED);
   		   		     	 
   		   		         
   		   		         try{ 	
   		   		        	 
   		   		        	 	conn1 =DriverManager.getConnection("jdbc:sqlite:print.sqlite"); 
   		   	 		        	String query="select * from  printipd";
   		   	 	 				PreparedStatement pst=conn1.prepareStatement(query);
   		   	 	 				ResultSet rs=pst.executeQuery();
   		   	 	 				byte[] b2=rs.getBytes("image1");
   		   	 	 				
   		   	 	 				pst.close();
   		   	 	 				rs.close();
   		   	 	 				
   		   	 	 				com.itextpdf.text.Image image1 = com.itextpdf.text.Image.getInstance(b2);
   		   	 	 				com.itextpdf.text.Image jpg=com.itextpdf.text.Image.getInstance(b2);
   		   	 	 				jpg.scaleToFit  (700, 850);
   		   	 	 				jpg.setAlignment(com.itextpdf.text.Image.UNDERLYING);
   		   	 	 				jpg.setAbsolutePosition(0, 0);
   		   	 	 				document.add(jpg);
   		   	 	 				
   		   	 	 				PdfContentByte cb2,cb3,cb4,cb5,cb6,cb7,cb8,cb9,cb10,cb11,cb12,cb13,cb14,cb15,cb16,cb17,cb18,cb19,cb20,cb21,cb22,cb23,cb24,cb25,cb26,cb27,cb28,cb29,cb30,cb31,cb32,cb33,cb34,cb35,cb36;
   		   	 	 				BaseFont bf = BaseFont.createFont(BaseFont.TIMES_ROMAN, BaseFont.CP1252, BaseFont.NOT_EMBEDDED);
   		   	 	 				
   		   	 	 				
   		   	 	 				String dooa = addmission_date.getText().toString();
   		   	 	 				String naam = reg_name.getText();
   		   	 	 				String ippd = ipd.getText();
   		   	 	 				String faather = reg_fname.getText();
   		   	 	 				String reefff = rfby.getText();
   		   	 	 				String sexx = reg_age.getText().toString().concat("/").concat(sex2.getSelectedItem().toString());
   		   	 	 				String cittty = reg_city.getText();
   		   	 	 				String highhh = high_detail.getSelectedItem().toString();
   		   	 	 				String operate = reason.getText();
   		   	 	 				String caatee = categ.getSelectedItem().toString();
   		   	 	 				String higgh = high_detail.getSelectedItem().toString();
   		   	 	 				String uhidd = uhid.getText();
   		   	 	 				String doa =  oprate_date.getText().toString(); 
   		   	 	 				String bs = billing.getSelectedItem().toString();
	   	 	 				
	   	 	 				
		   	 	 				cb3 = writer.getDirectContent();
		   	 	 				cb3.beginText();
		   	 	 				cb3.setFontAndSize(bf, 14);
		   	 	 				cb3.showTextAligned(PdfContentByte.ALIGN_LEFT, dooa, 100, 700, 0);
		   	 	 				cb3.endText();
	   	 	 				
	   	 	 				
	   	 	 				
	   	 	 				
	   	 	 				
			   	 	 			cb3 = writer.getDirectContent();
		   	 	 				cb3.beginText();
		   	 	 				cb3.setFontAndSize(bf, 14);
		   	 	 				cb3.showTextAligned(PdfContentByte.ALIGN_LEFT, doa, 280, 700, 0);
		   	 	 				cb3.endText();

	 	 				
	 	 				
	 	 				
		   	 	 				cb13 = writer.getDirectContent();
		   	 	 				cb13.beginText();
		   	 	 				cb13.setFontAndSize(bf, 14);
		   	 	 				cb13.showTextAligned(PdfContentByte.ALIGN_LEFT, dis, 421, 700, 0);
		   	 	 				cb13.endText();
	 	 				
	 	 				
		   	 	 				cb13 = writer.getDirectContent();
		   	 	 				cb13.beginText();
		   	 	 				cb13.setFontAndSize(bf, 14);
		   	 	 				cb13.showTextAligned(PdfContentByte.ALIGN_LEFT, re_drname.getText(), 120, 671, 0);
		   	 	 				cb13.endText();
	   	 	 				
	   	 	 				
	   	 	 				
			   	 	 			cb13 = writer.getDirectContent();
		   	 	 				cb13.beginText();
		   	 	 				cb13.setFontAndSize(bf, 14);
		   	 	 				cb13.showTextAligned(PdfContentByte.ALIGN_LEFT, highhh, 435, 671, 0);
		   	 	 				cb13.endText();
		 	 				
	 	 				
	 	 				
	 	 				
		   	 	 				cb4 = writer.getDirectContent();
		   	 	 				cb4.beginText();
		   	 	 				cb4.setFontAndSize(bf, 14);
		   	 	 				cb4.showTextAligned(PdfContentByte.ALIGN_LEFT, naam, 80, 745, 0);
		   	 	 				cb4.endText();
		 	 				
	 	 				
	 	 				
		   	 	 				cb6 = writer.getDirectContent();
		   	 	 				cb6.beginText();
		   	 	 				cb6.setFontAndSize(bf, 14);
		   	 	 				cb6.showTextAligned(PdfContentByte.ALIGN_LEFT, ippd, 100, 730, 0);
		   	 	 				cb6.endText();
	 	 				
	 	 				
								cb14 = writer.getDirectContent();
								cb14.beginText();
								cb14.setFontAndSize(bf, 14);
								cb14.showTextAligned(PdfContentByte.ALIGN_LEFT, uhidd, 350, 730, 0);
								cb14.endText();
							
								cb7 = writer.getDirectContent();
								cb7.beginText();
								cb7.setFontAndSize(bf, 14);
								cb7.showTextAligned(PdfContentByte.ALIGN_LEFT, sexx, 350, 745, 0);
								cb7.endText();
								
							
								cb8 = writer.getDirectContent();
								cb8.beginText();
								cb8.setFontAndSize(bf, 14);
								cb8.showTextAligned(PdfContentByte.ALIGN_LEFT, reefff, 350, 720, 0);
								cb8.endText();
							
							
							
							
							
								
								cb9 = writer.getDirectContent();
								cb9.beginText();
								cb9.setFontAndSize(bf, 14);
								cb9.showTextAligned(PdfContentByte.ALIGN_LEFT, cittty, 80, 721, 0);
								cb9.endText();
								
								
							
							
							
							
							
							cb12 = writer.getDirectContent();
							cb12.beginText();
							cb12.setFontAndSize(bf, 14);
							cb12.showTextAligned(PdfContentByte.ALIGN_LEFT, caatee, 500, 742, 0);
							cb12.endText();
							
							
							cb12 = writer.getDirectContent();
							cb12.beginText();
							cb12.setFontAndSize(bf, 14);
							cb12.showTextAligned(PdfContentByte.ALIGN_LEFT, mrd, 500, 730, 0);
							cb12.endText();
							
	   	 	 				
	   	 	 				
	   	 	 				p1.add("\n\n\n\n\n\n\n");
	   	 	 				
	   	 	 				
	   	 	 				p1.add("Clinical Examination:-");
	   	 	 				PdfPTable ce = new PdfPTable(1);
	   	 	 			
	   	 	 				ce.setWidthPercentage(100);
	   	 	 				String clinicc = clinic.getText().toString();
	   	 	 				ce.addCell(clinicc);
	   	 	 				p1.add(ce);
	   	 	 				
	   	 	 				
	   	 	 				
	   	 	 				p1.add("Diagnose/Opreate:-");
	   	 	 				PdfPTable de = new PdfPTable(1);
	   	 	 				de.setWidthPercentage(100);
	   	 	 				String dig = digno.getText().toString();
	   	 	 				de.addCell(dig);
	   	 	 				p1.add(de);
	   	 	 			

	   	 	 				
	   	 	 				p1.add("History:-");
	   	 	 				PdfPTable his = new PdfPTable(1);
	   	 	 				his.setWidthPercentage(100);
	   	 	 				String hitash = History.getText().toString();
	   	 	 				his.addCell(hitash);
	   	 	 				p1.add(his);
	   	 	 				
	   	 	 				
	   	 	 				
	   	 	 				p1.add("Biochemical Exam:-");
	   	 	 				
	   	 	 				PdfPTable tt = new PdfPTable(13);
	   	 	 				tt.setWidthPercentage(100);
	   	 	 				PdfPCell c1 = new PdfPCell(new Phrase("Sno"));
	   	 	 				tt.addCell(c1);
	 					
	 					
			 					c1 = new PdfPCell(new Phrase("Date"));
			 					tt.addCell(c1);
			 					
			 					c1 = new PdfPCell(new Phrase("HB"));
			 					tt.addCell(c1);
			 					
			 					c1 = new PdfPCell(new Phrase("TLC"));
			 					tt.addCell(c1);
			 					
			 					c1 = new PdfPCell(new Phrase("Creat"));
			 					tt.addCell(c1);
	 					
	 					
				 				c1 = new PdfPCell(new Phrase("RBS"));
		 						tt.addCell(c1);
		 					
		 						c1 = new PdfPCell(new Phrase("OT_PT"));
		 						tt.addCell(c1);
		 					
		 					
		 						c1 = new PdfPCell(new Phrase("ALP"));
		 						tt.addCell(c1);
	 	 				
	 	 				
			 					c1 = new PdfPCell(new Phrase("TBili"));
			 					tt.addCell(c1);
			 					
			 					c1 = new PdfPCell(new Phrase("PSA"));
			 					tt.addCell(c1);
			 					
			 					
			 					c1 = new PdfPCell(new Phrase("Viral"));
			 					tt.addCell(c1);
			 					
			 					c1 = new PdfPCell(new Phrase("Blood"));
			 					tt.addCell(c1);
			 					
			 					c1 = new PdfPCell(new Phrase("Other"));
			 					tt.addCell(c1);
		 					
 					// table se datta nikalana
 					int row = table.getRowCount();
 		   			int coloumn = table.getColumnCount();
 		   			
 		   			for(int i=0;i<row;i++)
 						
 					{	
 					
 		   				for(int j=0;j<coloumn;j++)
 			   			{
 			   						
 		   					String s = table.getValueAt(i,j).toString();
 			   				tt.addCell(s);
 			   					
 			   			}
 			   				
 			   			
 					
 					}
 		   			
	 						tt.addCell(c1);
	 						p1.add(tt);
	 						
		 	 				
	   	 	 				
		 	 				p1.add("Investigation:-");
	   	 	 				String invest = investigation.getText().toString();
	   	 	 				PdfPTable inveest = new PdfPTable(1);
	   	 	 				inveest.setWidthPercentage(100);
	   	 	 				inveest.addCell(invest);
	   	 	 				p1.add(inveest);
	   	 	 				
	   	 	 				
	   	 	 				
	   	 	 				
	   	 	 	
	 				
	 				p1.add("Treatment Advice On Discharge:-"); 
	 					
	 				PdfPTable ttt = new PdfPTable(4);
	 				ttt.setWidthPercentage(100);
	 				
					PdfPCell c2 = new PdfPCell(new Phrase("Drugs"));
					ttt.addCell(c2);
					
					
					
					
					c2 = new PdfPCell(new Phrase("Dose"));
					ttt.addCell(c2);
					
					c2 = new PdfPCell(new Phrase("Frequency"));
					ttt.addCell(c2);
					
					c2 = new PdfPCell(new Phrase("Days"));
					ttt.addCell(c2);
 					
	 					
 					int roww = med.getRowCount();
 		   			int coloumnn = med.getColumnCount();
 		   			for(int i=0;i<roww;i++)
 						
 					{	
 					
 		   				for(int j=0;j<coloumnn;j++)
 			   			{
 			   						
 		   					String s = med.getValueAt(i,j).toString();
 			   				ttt.addCell(s);
 			   					
 			   			}
 			   				
 			   			
 					
 					}
 		   				ttt.addCell(c2);
	   	 	 			p1.add(ttt);	
	   	 	 			p1.add("Operation Notes:-");
		 	 				
		 	 			String ott = otnote.getText().toString();
		 	 			PdfPTable ottnote = new PdfPTable(1);
		 	 			ottnote.setWidthPercentage(100);
		 	 			ottnote.setTotalWidth(500);
	 	 				ottnote.addCell(ott);
	 	 				p1.add(ottnote);
	 	 				
	 	 					
	
		 	 				
		 	 				
		 	 			
		 	 		try{ 	
	   		        	 
   		        	 	conn1 =DriverManager.getConnection("jdbc:sqlite:print.sqlite"); 
   	 		        	String query1="select * from  discharge where name = '"+sonu+"' ";
   	 	 				PreparedStatement pst1=conn1.prepareStatement(query1);
   	 	 				ResultSet rs1=pst1.executeQuery();
   	 	 				byte[] b3=rs1.getBytes("second");
   	 	 				
   	 	 				pst1.close();
   	 	 				rs1.close();
   	 	 				
   	 	 				com.itextpdf.text.Image image2 = com.itextpdf.text.Image.getInstance(b3);
   	 	 				com.itextpdf.text.Image jpg2=com.itextpdf.text.Image.getInstance(b3);
   	 	 				jpg2.scaleToFit  (500, 500);
   	 	 				jpg2.setAlignment(com.itextpdf.text.Image.UNDERLYING);
   	 	 				jpg2.setAbsolutePosition(0, 0);
   	 	 				
   	 	 				p1.add("Follow Up:- "+followup.getText());
   	 	 				PdfPTable followup = new PdfPTable(1);
	 	 				followup.setWidthPercentage(100);
	 	 				followup.addCell(jpg2);
	 	 				p1.add(followup);
   	 	 				 				
   	      	        }catch(Exception fe)
   	      	        {
   	      	        	fe.printStackTrace();
   	      	        }
   		
		 	 			
	   	 					
		 	 		
	   	 				
	   	 					
	   	 				
		 					
		 	 			
		 		   			p1.setAlignment(Element.ALIGN_JUSTIFIED);
		 		   			document.add(p1);
		 		   			document.setMargins(180, 108, 72, 36);
	   	 					
	   	 					document.add(p);
	   	 					
	   	 	 				
	   	 	 				document.close();
	   	 	 				writer.close();
	   	 	 				Desktop.getDesktop().open(new File(disname));
	   	 	 				
	   	      	        }catch(Exception fe)
	   	      	        {
	   	      	        	fe.printStackTrace();
	   	      	        }
   		   		         	
   		   	 				 
   		   		           
   		   		}
   		   			catch(Exception ee)
   		   			{
   		   				ee.printStackTrace();
   		   			}
   		   			
   		   			
   		   			
   		
   		   			
   				}
   				else
   				{
   					Document document = new Document(PageSize.A4,40,0,50,50);
   		   			try
   		   		      {     
   		   		         PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream(disname));
   		   		         document.open();
   		   		         Paragraph p = new Paragraph("",new com.itextpdf.text.Font(com.itextpdf.text.Font.FontFamily.TIMES_ROMAN,9,Font.BOLD));
   		   		         
   		   		   Paragraph p1 = new Paragraph("",new com.itextpdf.text.Font(com.itextpdf.text.Font.FontFamily.TIMES_ROMAN,12,Font.BOLD));
   		   		        /* p1 = new Paragraph();
   		   		         BaseFont base = BaseFont.createFont("c:/windows/fonts/arial.ttf", BaseFont.WINANSI, rootPaneCheckingEnabled, rootPaneCheckingEnabled);
   		   		         Font font = new Font(base, 11f, Font.BOLD);
   		   		         p1.setFont(font);*/
   		   		         BaseFont bf1 = BaseFont.createFont(BaseFont.HELVETICA, BaseFont.CP1252, BaseFont.NOT_EMBEDDED);
   		   		     	 
   		   		         
   		   		         try{ 	
   		   		        	 
   		   		        	 	conn1 =DriverManager.getConnection("jdbc:sqlite:print.sqlite"); 
   		   	 		        	String query="select * from  printipd";
   		   	 	 				PreparedStatement pst=conn1.prepareStatement(query);
   		   	 	 				ResultSet rs=pst.executeQuery();
   		   	 	 				byte[] b2=rs.getBytes("image");
   		   	 	 				
   		   	 	 				pst.close();
   		   	 	 				rs.close();
   		   	 	 				
   		   	 	 				com.itextpdf.text.Image image1 = com.itextpdf.text.Image.getInstance(b2);
   		   	 	 				com.itextpdf.text.Image jpg=com.itextpdf.text.Image.getInstance(b2);
   		   	 	 				jpg.scaleToFit  (700, 850);
   		   	 	 				jpg.setAlignment(com.itextpdf.text.Image.UNDERLYING);
   		   	 	 				jpg.setAbsolutePosition(0, 0);
   		   	 	 				document.add(jpg);
   		   	 	 				
   		   	 	 				PdfContentByte cb2,cb3,cb4,cb5,cb6,cb7,cb8,cb9,cb10,cb11,cb12,cb13,cb14,cb15,cb16,cb17,cb18,cb19,cb20,cb21,cb22,cb23,cb24,cb25,cb26,cb27,cb28,cb29,cb30,cb31,cb32,cb33,cb34,cb35,cb36;
   		   	 	 				BaseFont bf = BaseFont.createFont(BaseFont.TIMES_ROMAN, BaseFont.CP1252, BaseFont.NOT_EMBEDDED);
   		   	 	 				
   		   	 	 				
	   		   	 	 			String dooa = addmission_date.getText().toString();
		   	 	 				String naam = reg_name.getText();
		   	 	 				String ippd = ipd.getText();
		   	 	 				String faather = reg_fname.getText();
		   	 	 				String reefff = rfby.getText();
		   	 	 				String sexx = reg_age.getText().toString().concat("/").concat(sex2.getSelectedItem().toString());
		   	 	 				String cittty = reg_city.getText();
		   	 	 				String highhh = high_detail.getSelectedItem().toString();
		   	 	 				String operate = reason.getText();
		   	 	 				String caatee = categ.getSelectedItem().toString();
		   	 	 				String higgh = high_detail.getSelectedItem().toString();
		   	 	 				String uhidd = uhid.getText();
		   	 	 				String doa =  oprate_date.getText().toString(); 
		   	 	 				String bs = billing.getSelectedItem().toString();
		 	 				
	 	 				
	 	 				cb3 = writer.getDirectContent();
	 	 				cb3.beginText();
	 	 				cb3.setFontAndSize(bf, 14);
	 	 				cb3.showTextAligned(PdfContentByte.ALIGN_LEFT, dooa, 100, 700, 0);
	 	 				cb3.endText();
	 	 				
	 	 				
	 	 				
	 	 				
	 	 				
	 	 				cb3 = writer.getDirectContent();
	 	 				cb3.beginText();
	 	 				cb3.setFontAndSize(bf, 14);
	 	 				cb3.showTextAligned(PdfContentByte.ALIGN_LEFT, doa, 280, 700, 0);
	 	 				cb3.endText();

	 				
	 				
	 				
	 	 				cb13 = writer.getDirectContent();
	 	 				cb13.beginText();
	 	 				cb13.setFontAndSize(bf, 14);
	 	 				cb13.showTextAligned(PdfContentByte.ALIGN_LEFT, dis, 421, 700, 0);
	 	 				cb13.endText();
	 				
	 				
	 	 				cb13 = writer.getDirectContent();
	 	 				cb13.beginText();
	 	 				cb13.setFontAndSize(bf, 14);
	 	 				cb13.showTextAligned(PdfContentByte.ALIGN_LEFT, re_drname.getText(), 120, 671, 0);
	 	 				cb13.endText();
	 	 				
	 	 				
	 	 				
	 	 				cb13 = writer.getDirectContent();
	 	 				cb13.beginText();
	 	 				cb13.setFontAndSize(bf, 14);
	 	 				cb13.showTextAligned(PdfContentByte.ALIGN_LEFT, highhh, 435, 671, 0);
	 	 				cb13.endText();
	 				
	 				
	 				
	 				
	 	 				cb4 = writer.getDirectContent();
	 	 				cb4.beginText();
	 	 				cb4.setFontAndSize(bf, 14);
	 	 				cb4.showTextAligned(PdfContentByte.ALIGN_LEFT, naam, 80, 745, 0);
	 	 				cb4.endText();
	 				
	 				
	 				
	 	 				cb6 = writer.getDirectContent();
	 	 				cb6.beginText();
	 	 				cb6.setFontAndSize(bf, 14);
	 	 				cb6.showTextAligned(PdfContentByte.ALIGN_LEFT, ippd, 100, 730, 0);
	 	 				cb6.endText();
	 				
	 				
					cb14 = writer.getDirectContent();
					cb14.beginText();
					cb14.setFontAndSize(bf, 14);
					cb14.showTextAligned(PdfContentByte.ALIGN_LEFT, uhidd, 350, 730, 0);
					cb14.endText();
					
					cb7 = writer.getDirectContent();
					cb7.beginText();
					cb7.setFontAndSize(bf, 14);
					cb7.showTextAligned(PdfContentByte.ALIGN_LEFT, sexx, 350, 745, 0);
					cb7.endText();
					
					
					cb8 = writer.getDirectContent();
					cb8.beginText();
					cb8.setFontAndSize(bf, 14);
					cb8.showTextAligned(PdfContentByte.ALIGN_LEFT, reefff, 350, 720, 0);
					cb8.endText();
					
					
					
					
					
					
					cb9 = writer.getDirectContent();
					cb9.beginText();
					cb9.setFontAndSize(bf, 14);
					cb9.showTextAligned(PdfContentByte.ALIGN_LEFT, cittty, 80, 721, 0);
					cb9.endText();
					
					
					
					
					
					
					
					cb12 = writer.getDirectContent();
					cb12.beginText();
					cb12.setFontAndSize(bf, 14);
					cb12.showTextAligned(PdfContentByte.ALIGN_LEFT, caatee, 500, 742, 0);
					cb12.endText();
					
					
					cb12 = writer.getDirectContent();
					cb12.beginText();
					cb12.setFontAndSize(bf, 14);
					cb12.showTextAligned(PdfContentByte.ALIGN_LEFT, mrd, 500, 730, 0);
					cb12.endText();

						
   	 	 				
   	 	 				
						p1.add("\n\n\n\n\n\n\n");
   	 	 				
   	 	 				//p1.add("")
   	 	 				p1.add("Clinical Examination:-");
   	 	 				PdfPTable ce = new PdfPTable(1);
   	 	 			
   	 	 				ce.setWidthPercentage(100);
   	 	 				String clinicc = clinic.getText().toString();
   	 	 				ce.addCell(clinicc);
   	 	 				p1.add(ce);
   	 	 				
   	 	 				
   	 	 				
   	 	 				p1.add("Diagnose/Opreate:-");
   	 	 				PdfPTable de = new PdfPTable(1);
   	 	 				de.setWidthPercentage(100);
   	 	 				String dig = digno.getText().toString();
   	 	 				de.addCell(dig);
   	 	 				p1.add(de);
   	 	 			

   	 	 				
   	 	 				p1.add("History:-");
   	 	 				PdfPTable his = new PdfPTable(1);
   	 	 				his.setWidthPercentage(100);
   	 	 				String hitash = History.getText().toString();
   	 	 				his.addCell(hitash);
   	 	 				p1.add(his);
   	 	 				
   	 	 				
   	 	 				
   	 	 				p1.add("Biochemical Exam:-");
   	 	 				
   	 	 			PdfPTable tt = new PdfPTable(13);
	 	 				tt.setWidthPercentage(100);
	 	 				PdfPCell c1 = new PdfPCell(new Phrase("Sno"));
	 	 				tt.addCell(c1);
					
					
					c1 = new PdfPCell(new Phrase("Date"));
					tt.addCell(c1);
					
					c1 = new PdfPCell(new Phrase("HB"));
					tt.addCell(c1);
					
					c1 = new PdfPCell(new Phrase("TLC"));
					tt.addCell(c1);
					
				c1 = new PdfPCell(new Phrase("Creat"));
					tt.addCell(c1);
					
					c1 = new PdfPCell(new Phrase("RBS"));
				tt.addCell(c1);
					
				c1 = new PdfPCell(new Phrase("OT_PT"));
					tt.addCell(c1);
					
					
					c1 = new PdfPCell(new Phrase("ALP"));
				tt.addCell(c1);
	 				
	 				
				c1 = new PdfPCell(new Phrase("TBili"));
				tt.addCell(c1);
				
				c1 = new PdfPCell(new Phrase("PSA"));
				tt.addCell(c1);
				
				c1 = new PdfPCell(new Phrase("Viral"));
				tt.addCell(c1);
				
				c1 = new PdfPCell(new Phrase("Blood"));
				tt.addCell(c1);
				
				c1 = new PdfPCell(new Phrase("Other"));
				tt.addCell(c1);

					
					// table se datta nikalana
					int row = table.getRowCount();
		   			int coloumn = table.getColumnCount();
		   			for(int i=0;i<row;i++)
						
					{	
					
		   				for(int j=0;j<coloumn;j++)
			   			{
			   						
		   					String s = table.getValueAt(i,j).toString();
			   				tt.addCell(s);
			   					
			   			}
			   				
			   			
					
					}
		   			
 						tt.addCell(c1);
 						p1.add(tt);
 						
	 	 				
   	 	 				
	 	 				p1.add("Investigation:-");
   	 	 				String invest = investigation.getText().toString();
   	 	 				PdfPTable inveest = new PdfPTable(1);
   	 	 				inveest.setWidthPercentage(100);
   	 	 				inveest.addCell(invest);
   	 	 				p1.add(inveest);
   	 	 				
   	 	 				
   	 	 				
   	 	 				
   	 	 	
 				
 				p1.add("Treatment Advice On Discharge:-"); 
 					
 				PdfPTable ttt = new PdfPTable(4);
 				ttt.setWidthPercentage(100);
 				
				PdfPCell c2 = new PdfPCell(new Phrase("Drugs"));
				ttt.addCell(c2);
				
				
				
				
				c2 = new PdfPCell(new Phrase("Dose"));
				ttt.addCell(c2);
				
				c2 = new PdfPCell(new Phrase("Frequency"));
				ttt.addCell(c2);
				
				c2 = new PdfPCell(new Phrase("Days"));
				ttt.addCell(c2);
					
 					
					int roww = med.getRowCount();
		   			int coloumnn = med.getColumnCount();
		   			for(int i=0;i<roww;i++)
						
					{	
					
		   				for(int j=0;j<coloumnn;j++)
			   			{
			   						
		   					String s = med.getValueAt(i,j).toString();
			   				ttt.addCell(s);
			   					
			   			}
			   				
			   			
					
					}
		   			ttt.addCell(c2);
   	 	 			p1.add(ttt);	
   	 	 			p1.add("Operation Notes:-");
	 	 				
	 	 			String ott = otnote.getText().toString();
	 	 			PdfPTable ottnote = new PdfPTable(1);
	 	 			ottnote.setWidthPercentage(100);
	 	 			ottnote.setTotalWidth(500);
 	 				ottnote.addCell(ott);
 	 				p1.add(ottnote);
	 	 		
	 	 				
	 	 				
	 	 			
	 	 		try{ 	
   		        	 
		        	 	conn1 =DriverManager.getConnection("jdbc:sqlite:print.sqlite"); 
	 		        	String query1="select * from  discharge where name = '"+sonu+"' ";
	 	 				PreparedStatement pst1=conn1.prepareStatement(query1);
	 	 				ResultSet rs1=pst1.executeQuery();
	 	 				byte[] b3=rs1.getBytes("second");
	 	 				
	 	 				pst1.close();
	 	 				rs1.close();
	 	 				
	 	 				com.itextpdf.text.Image image2 = com.itextpdf.text.Image.getInstance(b3);
	 	 				com.itextpdf.text.Image jpg2=com.itextpdf.text.Image.getInstance(b3);
	 	 				jpg2.scaleToFit  (200, 200);
	 	 				jpg2.setAlignment(com.itextpdf.text.Image.UNDERLYING);
	 	 				jpg2.setAbsolutePosition(0, 0);
	 	 				
	 	 				p1.add("Follow Up:- "+followup.getText());
	 	 				PdfPTable followup = new PdfPTable(1);
 	 				followup.setWidthPercentage(100);
 	 				followup.addCell(jpg2);
 	 				p1.add(followup);
	 	 				 				
	      	        }catch(Exception fe)
	      	        {
	      	        	fe.printStackTrace();
	      	        }
		
	 	 			
   	 					
	 	 		
   	 				
   	 					
   	 				
	 					
	 	 			
	 		   			p1.setAlignment(Element.ALIGN_JUSTIFIED);
	 		   			document.add(p1);
	 		   			document.setMargins(180, 108, 72, 36);
   	 					
   	 					document.add(p);
   	 					
   	 	 				
   	 	 				document.close();
   	 	 				writer.close();
   	 	 				Desktop.getDesktop().open(new File(disname));
	   	 	 				
	   	      	        }catch(Exception fe)
	   	      	        {
	   	      	        	fe.printStackTrace();
	   	      	        }
   		   		         	
   		   	 				 
   		   		           
   		   		}
   		   			catch(Exception ee)
   		   			{
   		   			ee.printStackTrace();
   		   			}
   		   			
   		   			
   		   			
   		   			
   				}	
   				
   				
   			
   			
   		}
   	});
   	btnPrint_1.setFont(new Font("Tahoma", Font.BOLD, 26));
   	btnPrint_1.setBounds(389, 571, 193, 35);
   	discharge.add(btnPrint_1);
   	
   	JLabel lblDiagnoseoperate = new JLabel("Diagnose/Operate");
   	lblDiagnoseoperate.setForeground(new Color(60, 179, 113));
   	lblDiagnoseoperate.setFont(new Font("SansSerif", Font.BOLD, 18));
   	lblDiagnoseoperate.setBounds(15, 452, 203, 40);
   	discharge.add(lblDiagnoseoperate);
   	
   	JScrollPane scrollPane_10 = new JScrollPane();
   	scrollPane_10.setBounds(223, 439, 348, 79);
   	discharge.add(scrollPane_10);
   	
   	digno = new JTextArea();
   	scrollPane_10.setViewportView(digno);
   	
   	JButton btnSave = new JButton("Save");
   	btnSave.addActionListener(new ActionListener() {
   		public void actionPerformed(ActionEvent arg0) {
   			
   			
			
   			String time;
			LocalDateTime now = LocalDateTime.now();
			time = addmission_date.getText();
   			
   			
   			String name =reg_name.getText().toString();
    		String mobile = reg_mobile.getText().toString();
    		
    		String lab_record = name.concat(mobile).concat("lab_report").concat(time);
    		String med_record = name.concat(mobile).concat("med_report").concat(time);
    		String dis_record = name.concat(mobile).concat("dis_report").concat(time);
    		
    		for(int j=0; j < lab_record.length(); j++) {
				 
				 
    				lab_record = lab_record.replace(" ", "");
			
				 
				}
			
    		for(int j=0; j < lab_record.length(); j++) {
				 
				 
    			
    				lab_record = lab_record.replace("-", "");
			
				 
				}
    		
    		for(int j=0; j < lab_record.length(); j++) {
				 
				 
    			
				lab_record = lab_record.replace(".", "");
		
			 
			}
    		
    		for(int j=0; j < med_record.length(); j++) {
				 
				 med_record = med_record.replace(" ", "");
			
				 
				}
			
    		for(int j=0; j < med_record.length(); j++) {
				 
				 med_record = med_record.replace("-", "");
			
				 
				}
    		
    		for(int j=0; j < med_record.length(); j++) {
				 
				 med_record = med_record.replace(".", "");
			
				 
				}

    		
    		
    		
    	
    		
    		
    		try
  			{
    			
    			conn3 =DriverManager.getConnection("jdbc:ucanaccess://bsshlab.accdb"); 
    			String query="CREATE  TABLE  "+med_record+" (Drugs Text,Dose Text,Frequency Text,Days Text)";
  				Statement pst=conn3.createStatement();
  				pst.executeUpdate(query);
  				
  			
  			}
			
			catch(Exception e1)
			{
				e1.printStackTrace();
			}
    		
    		
    		
    		try
  			{
    			conn3 =DriverManager.getConnection("jdbc:ucanaccess://bsshlab.accdb");  
  				String query="CREATE  TABLE  "+lab_record+" (Sno Text,Date Text,HB Text,Tlc Text,Creat Text,RBS Text,Ot_Pt Text,ALP Text,TBili Text)";
  				PreparedStatement pst=conn3.prepareStatement(query);
  				
  				pst.executeUpdate();
  				
  			}
    		catch(Exception e)
    		{
    			e.printStackTrace();
    		}
    		
    		
    		
    		String iddd = "1";
    		try{
				
    			conn1 =DriverManager.getConnection("jdbc:sqlite:print.sqlite");
				String query1 = "Delete  From disreport where ipd = '"+ipd.getText()+"' ";
				PreparedStatement pst=conn1.prepareStatement(query1);
	  			pst.executeUpdate();
	  			//JOptionPane.showMessageDialog(null, "okk");	
	  			}
	  			catch(Exception e1)
	  			{
	  				//JOptionPane.showMessageDialog(null,e1);
	  			}
    		
    		
    		try{
				
    			conn1 =DriverManager.getConnection("jdbc:sqlite:print.sqlite");  
				String query1="Insert into  disreport  (dia,ot,clinic,invest,history,opr,opr1,ot_date,follow,ipd,uhid) values(?,?,?,?,?,?,?,?,?,?,?)";
				PreparedStatement pst=conn1.prepareStatement(query1);
				
				pst.setString(1,  digno.getText().toString());
				pst.setString(2,  otnote.getText().toString());
				pst.setString(3,  clinic.getText().toString());
				pst.setString(4,  investigation.getText().toString());    
				pst.setString(5,  History.getText().toString());
				pst.setString(6,  "1");
				pst.setString(7,  sonu);
				pst.setString(8,  oprate_date.getText().toString());
				pst.setString(9,  followup.getText().toString());
				pst.setString(10,  ipd.getText());
				pst.setString(11,  uhid.getText());
				pst.execute();
				
				JOptionPane.showMessageDialog(null, "DISCHARGE SAVED");
				
				conn1.close();
			}
    		
			catch(Exception e1)
			{
				e1.printStackTrace();
			}
    		
    		
    		
    		try{
				
				conn3 =DriverManager.getConnection("jdbc:ucanaccess://bsshlab.accdb"); 
				String query1 = "Delete *  From  "+lab_record+" ;";
				PreparedStatement pst=conn3.prepareStatement(query1);
	  			pst.executeUpdate();
	  			//JOptionPane.showMessageDialog(null, "okk");	
	  			}
	  			catch(Exception e1)
	  			{
	  				//JOptionPane.showMessageDialog(null,e1);
	  			}
    		
    		int roww = table.getRowCount();
    		try{
				
				conn3 =DriverManager.getConnection("jdbc:ucanaccess://bsshlab.accdb"); 
				String query1="Insert into  "+lab_record+"  (Sno,Date,HB,Tlc,Creat,RBS,Ot_Pt,ALP,TBili) values(?,?,?,?,?,?,?,?,?)";
				PreparedStatement pst=conn3.prepareStatement(query1);
				
				
				
				for(int row = 0; row<roww; row++)
				{
				    String sn = (String)table.getValueAt(row, 0).toString();
				    String date = (String)table.getValueAt(row, 1).toString();
				    String hb = (String)table.getValueAt(row, 2).toString();
				    String Tlc = (String)table.getValueAt(row, 3).toString();
				    String cre = (String)table.getValueAt(row, 4).toString();
				    String rbs = (String)table.getValueAt(row, 5).toString();
				    String ot = (String)table.getValueAt(row, 6).toString();
				    String alp = (String)table.getValueAt(row, 7).toString();
				    String tbilli = (String)table.getValueAt(row, 8).toString();

				
				     pst.setString(1,  sn);
				     pst.setString(2,  date);
				     pst.setString(3,  hb);
				     pst.setString(4,  Tlc);
				     pst.setString(5,  cre);
				     pst.setString(6,  rbs);
				     pst.setString(7,  ot);
				     pst.setString(8,  alp);
				     pst.setString(9,  tbilli);
				
				pst.execute();
				

				}
				conn3.close();
			}
    		
			catch(Exception e1)
			{
				e1.printStackTrace();
			}
    		
    		
    		
    		try{
				
				conn3 =DriverManager.getConnection("jdbc:ucanaccess://bsshlab.accdb"); 
				String query1 = "Delete *  From  "+med_record+" ;";
				PreparedStatement pst=conn3.prepareStatement(query1);
	  			pst.executeUpdate();
	  			//JOptionPane.showMessageDialog(null, "okk");	
	  			}
	  			catch(Exception e1)
	  			{
	  				//JOptionPane.showMessageDialog(null,e1);
	  			}
		
    		int rowww = med.getRowCount();
    		try{
				
				conn3 =DriverManager.getConnection("jdbc:ucanaccess://bsshlab.accdb"); 
				String query1="Insert into  "+med_record+"  (Drugs,Dose,Frequency,Days) values(?,?,?,?)";
				PreparedStatement pst=conn3.prepareStatement(query1);
				
				
				
				for(int row = 0; row<rowww; row++)
				{
				    String dr = (String)med.getValueAt(row, 0).toString();
				    String dos = (String)med.getValueAt(row, 1).toString();
				    String fre = (String)med.getValueAt(row, 2).toString();
				    String day = (String)med.getValueAt(row, 3).toString();
				   

				
				     pst.setString(1,  dr);
				     pst.setString(2,  dos);
				     pst.setString(3,  fre);
				     pst.setString(4,  day);
				   
				
				pst.execute();
				

				}
				conn3.close();
			}
    		
			catch(Exception e1)
			{
				e1.printStackTrace();
			}
   			
   		}
   	});
   	btnSave.setFont(new Font("Tahoma", Font.BOLD, 26));
   	btnSave.setBounds(379, 524, 203, 35);
   	discharge.add(btnSave);
   	
   	JLabel lblOperationDate = new JLabel("Operation Date");
   	lblOperationDate.setForeground(new Color(60, 179, 113));
   	lblOperationDate.setFont(new Font("SansSerif", Font.BOLD, 18));
   	lblOperationDate.setBounds(15, 535, 153, 28);
   	discharge.add(lblOperationDate);
   	
   	oprate_date = new JTextField();
   	oprate_date.setBounds(165, 530, 171, 31);
   	discharge.add(oprate_date);
   	oprate_date.setColumns(10);
   	
   	JLabel lblFollowUpDate = new JLabel("Follow up date");
   	lblFollowUpDate.setForeground(new Color(60, 179, 113));
   	lblFollowUpDate.setFont(new Font("SansSerif", Font.BOLD, 18));
   	lblFollowUpDate.setBounds(15, 576, 153, 28);
   	discharge.add(lblFollowUpDate);
   	
   	followup = new JTextField();
   	followup.setColumns(10);
   	followup.setBounds(165, 571, 171, 31);
   	discharge.add(followup);
   	
   	drugs = new JTextField();
   	drugs.setColumns(10);
   	drugs.setBounds(15, 246, 210, 38);
   	discharge.add(drugs);
   	
   	dose = new JTextField();
   	dose.setColumns(10);
   	dose.setBounds(230, 246, 81, 38);
   	discharge.add(dose);
   	
   	frequency = new JTextField();
   	frequency.setColumns(10);
   	frequency.setBounds(318, 246, 74, 38);
   	discharge.add(frequency);
   	
   	days = new JTextField();
   	days.addKeyListener(new KeyAdapter() {
   		@Override
   		public void keyPressed(KeyEvent e) {
   			
   			
   		
   			if(e.getKeyCode()==KeyEvent.VK_ENTER)
			{
   				
   				rows2[0]=  drugs.getText();
				
				rows2[1]= dose.getText();
				
				rows2[2]= frequency.getText();
				
				rows2[3]= days.getText();
				
				jana.addRow(rows2);
   				
			}
   		}
   	});
   	days.setColumns(10);
   	days.setBounds(404, 246, 167, 38);
   	discharge.add(days);
   //	Image img12345=new ImageIcon(this.getClass().getResource("/plus.png")).getImage();
   	
   	getContentPane().setLayout(groupLayout);
   	
	
   	name();
   	try {
		data1();
	} catch (ClassNotFoundException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	}
   	rgno();
   	room();
   	icd();
   /*	data();
   	data1();
   	city();
   	name();*/
   	//rgno1();
    //drname();  	
	}
	public void rgno()
	{
		
		id=0;
		
		try{
		
			conn =DriverManager.getConnection("jdbc:ucanaccess://sbbh.accdb");
			String query="Select DISTINCT ipd_no from  ipd_admit ";
			PreparedStatement pst=conn.prepareStatement(query);
			ResultSet rs=pst.executeQuery();
			while(rs.next())
			{
				id=rs.getInt("ipd_no");
				
			}
			sid=String.valueOf((id+1));
			ipd.setText(sid);
			rs.close();
			pst.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		
	
	
	}	
	
	
	public void mrdno()
	{
		
		id=0;
		
		try{
		
			conn1 =DriverManager.getConnection("jdbc:sqlite:print.sqlite"); 
			String query="Select mrd from  ipd_dis ";
			PreparedStatement pst=conn1.prepareStatement(query);
			ResultSet rs=pst.executeQuery();
			while(rs.next())
			{
				id=rs.getInt("mrd");
				
			}
			mrd=String.valueOf((id+1));
			
			rs.close();
			pst.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		
	
	
	}	
	
	public void icd()
	{
		
	
		
		try{
		
			conn1 =DriverManager.getConnection("jdbc:sqlite:print.sqlite"); 
			String query="Select * from  icd_code ";
			PreparedStatement pst=conn1.prepareStatement(query);
			ResultSet rs=pst.executeQuery();
			while(rs.next())
			{
				String s,s1;
				s=rs.getString("code");
				s1=rs.getString("name");
				
				s1 = s.concat(" ").concat(s1);
				reasonchoice.addItem(s1);
				
			}
			
			
			rs.close();
			pst.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		
	
	
	}	
	

	
	
	public void data1() throws ClassNotFoundException
	{
		
		
			
			try
			{
				Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");													
				conn =DriverManager.getConnection("jdbc:ucanaccess://sbbh.accdb");
				String query= "select *  from  ipd_admit";
				PreparedStatement statement= conn.prepareStatement(query);
				ResultSet rs=statement.executeQuery();
				contable.setModel(DbUtils.resultSetToTableModel(rs));
				rs.close();
				statement.close();
				
			}
			catch(SQLException e1)
			{
					e1.printStackTrace();
			}
			
		
	}
	
	
	
	public void room()
	{
		
		
		comboBox.removeAllItems();	
		try { 
			conn =DriverManager.getConnection("jdbc:ucanaccess://sbbh.accdb");
			Statement statement = conn.createStatement();
            String query = "SELECT DISTINCT room_no FROM book_room ";
            ResultSet rs = statement.executeQuery(query);

            while (rs.next())
            {      
               
            	
            	String s = rs.getString("room_no");
            	
            	comboBox.addItem(s);
            	
            
                
            }//end while
            conn.close();
            } catch (Exception e1) {
                 e1.printStackTrace();
            }
		
	}
	
	

	
	public void name()
	{
		
		ac.removeAllItems();
			
		try { 
			conn2 =DriverManager.getConnection("jdbc:ucanaccess://bansal.accdb");
			Statement statement = conn2.createStatement();
            String query = "SELECT DISTINCT name FROM uhid ";
            ResultSet rs = statement.executeQuery(query);

            while (rs.next())
            {      
               
            	
            	String s = rs.getString("name");
            	
            	ac.addItem(s);
            	
            
                
            }//end while
            conn2.close();
            } catch (Exception e1) {
                 e1.printStackTrace();
            }
		
	}
	
	
	public void printsticker2()
	{
		
		Document document = new Document(PageSize.A4,0,0,0,0);
		try
	      {     
	         PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream("print1.pdf"));
	         document.open();
	         Paragraph p = new Paragraph("",new com.itextpdf.text.Font(com.itextpdf.text.Font.FontFamily.TIMES_ROMAN,11));
	         try{ 	
	        	 
	        	 	conn1 =DriverManager.getConnection("jdbc:sqlite:print.sqlite"); 
 		        	String query="select * from  sticker";
 	 				PreparedStatement pst=conn1.prepareStatement(query);
 	 				ResultSet rs=pst.executeQuery();
 	 				byte[] b2=rs.getBytes("image");
 	 				pst.close();
 	 				rs.close();
 	 				
 	 				com.itextpdf.text.Image image1 = com.itextpdf.text.Image.getInstance(b2);
 	 				com.itextpdf.text.Image jpg=com.itextpdf.text.Image.getInstance(b2);
 	 				jpg.scaleToFit  (700, 850);
 	 				jpg.setAlignment(com.itextpdf.text.Image.UNDERLYING);
 	 				jpg.setAbsolutePosition(0, 0);
 	 				document.add(jpg);
 	 				
 	 				PdfContentByte cb2,cb3,cb4,cb5,cb6,cb7,cb8,cb9,cb10,cb11,cb12,cb13,cb14,cb15,cb16,cb17,cb18,cb19,cb20,cb21,cb22,cb23,cb24,cb25,cb26,cb27,cb28,cb29,cb30,cb31,cb32,cb33,cb34,cb35,cb36;
 	 				BaseFont bf = BaseFont.createFont(BaseFont.HELVETICA, BaseFont.CP1252, BaseFont.NOT_EMBEDDED);
 	 				Font f = new Font("Kruti Dev 165", Font.PLAIN, 13);
 	 				
 	 				
 	 				
 	 				
 					
 					String s,s1,s2,s3,s4,s5;
 					s = "Name  ".concat(reg_name.getText().toString());
 					s1 = (uhid.getText().toString());
 					s2 = ipd.getText().toString();
 					s2 = "UHID/ID  ".concat(s1.concat("/").concat(s2));
 					s3 = "Care of  ".concat(reg_fname.getText().toString());
 					s4 = "Operation  ".concat(reason.getText().toString());
 					s5 = "Category  ".concat(categ.getSelectedItem().toString()).concat("      Contact  ").concat(reg_mobile.getText().toString());
 					
 	 				//first sticker
 	 				cb2 = writer.getDirectContent();
 					cb2.beginText();
 	 				cb2.setFontAndSize(bf, 10);
 	 				cb2.showTextAligned(PdfContentByte.ALIGN_LEFT, s, 35, 805, 0);
 	 				cb2.endText();
 	 				
 	 				// second sticker
 	 				cb3 = writer.getDirectContent();
 					cb3.beginText();
 	 				cb3.setFontAndSize(bf, 10);
 	 				cb3.showTextAligned(PdfContentByte.ALIGN_LEFT, s,325, 805, 0);
 	 				cb3.endText();
 	 				
 	 				//first sticker
 	 				cb4 = writer.getDirectContent();
 					cb4.beginText();
 	 				cb4.setFontAndSize(bf, 10);
 	 				cb4.showTextAligned(PdfContentByte.ALIGN_LEFT, s2, 35,805, 0);
 	 				cb4.endText();
 	 				
 	 				//second sticker
 	 				cb5 = writer.getDirectContent();
 					cb5.beginText();
 	 				cb5.setFontAndSize(bf, 10);
 	 				cb5.showTextAligned(PdfContentByte.ALIGN_LEFT, s2, 325, 805, 0);
 	 				cb5.endText();
 	 				
 	 				
 	 				cb6 = writer.getDirectContent();
 					cb6.beginText();
 	 				cb6.setFontAndSize(bf, 10);
 	 				cb6.showTextAligned(PdfContentByte.ALIGN_LEFT, s3, 35, 786, 0);
 	 				cb6.endText();
 	 				
 	 				cb7 = writer.getDirectContent();
 					cb7.beginText();
 	 				cb7.setFontAndSize(bf, 10);
 	 				cb7.showTextAligned(PdfContentByte.ALIGN_LEFT, s3, 325, 786, 0);
 	 				cb7.endText();
 	 				
 	 				
 	 				cb8 = writer.getDirectContent();
 					cb8.beginText();
 	 				cb8.setFontAndSize(bf, 10);
 	 				cb8.showTextAligned(PdfContentByte.ALIGN_LEFT, s4, 35, 767, 0);
 	 				cb8.endText();
 	 				
 	 				
 	 				cb9 = writer.getDirectContent();
 					cb9.beginText();
 	 				cb9.setFontAndSize(bf, 10);
 	 				cb9.showTextAligned(PdfContentByte.ALIGN_LEFT, s4, 325, 767, 0);
 	 				cb9.endText();
 	 				
 	 				
 	 				
 	 				cb10 = writer.getDirectContent();
 					cb10.beginText();
 	 				cb10.setFontAndSize(bf, 10);
 	 				cb10.showTextAligned(PdfContentByte.ALIGN_LEFT, s5, 35, 755, 0);
 	 				cb10.endText();
 	 				
 	 				
 	 				
 	 				
 	 				
 	 				/*cb12 = writer.getDirectContent();
 					cb12.beginText();
 	 				cb12.setFontAndSize(bf, 10);
 	 				cb12.showTextAligned(PdfContentByte.ALIGN_LEFT, t5, 72, 675, 0);
 	 				cb12.endText();
 	 				
 	 				
 	 				cb13 = writer.getDirectContent();
 					cb13.beginText();
 	 				cb13.setFontAndSize(bf, 10);
 	 				cb13.showTextAligned(PdfContentByte.ALIGN_LEFT, t5, 307, 675, 0);
 	 				cb13.endText();
 	 				*/
 	 				
 	 				
 	 				document.add(p);
 	 				document.close();
 	 				writer.close();
 	 				Desktop.getDesktop().open(new File("print1.pdf"));
 	 				
      	        }catch(Exception fe)
      	        {
      	        	fe.printStackTrace();
      	        }
	         
	         	
 				 
	           
	}
		catch(Exception e)
		{}
	
	}
	
	
	
	public void printsticker12()
	{
		
		Document document = new Document(PageSize.A4,0,0,0,0);
		try
	      {     
	         PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream("print1.pdf"));
	         document.open();
	         Paragraph p = new Paragraph("",new com.itextpdf.text.Font(com.itextpdf.text.Font.FontFamily.TIMES_ROMAN,11));
	         try{ 	
	        	 
	        	 	conn1 =DriverManager.getConnection("jdbc:sqlite:print.sqlite"); 
 		        	String query="select * from  sticker";
 	 				PreparedStatement pst=conn1.prepareStatement(query);
 	 				ResultSet rs=pst.executeQuery();
 	 				byte[] b2=rs.getBytes("image");
 	 				pst.close();
 	 				rs.close();
 	 				
 	 				com.itextpdf.text.Image image1 = com.itextpdf.text.Image.getInstance(b2);
 	 				com.itextpdf.text.Image jpg=com.itextpdf.text.Image.getInstance(b2);
 	 				jpg.scaleToFit  (700, 850);
 	 				jpg.setAlignment(com.itextpdf.text.Image.UNDERLYING);
 	 				jpg.setAbsolutePosition(0, 0);
 	 				document.add(jpg);
 	 				
 	 				BaseFont bf = BaseFont.createFont(BaseFont.HELVETICA, BaseFont.CP1252, BaseFont.NOT_EMBEDDED);
 	 				Font f = new Font("Kruti Dev 165", Font.PLAIN, 13);
 	 				
 	 				
 	 				
 	 				
 					
 					String s,s1,s2,s3,s4,s5;
 					s = "Name  ".concat(reg_name.getText().toString());
 					s1 = (uhid.getText().toString());
 					s2 = ipd.getText().toString();
 					s2 = "UHID/ID  ".concat(s1.concat("/").concat(s2));
 					s3 = "Care of  ".concat(reg_fname.getText().toString());
 					s4 = "Operation  ".concat(reason.getText().toString());
 					s5 = "Category  ".concat(categ.getSelectedItem().toString()).concat("      Contact  ").concat(reg_mobile.getText().toString());
 					
 	 				//first sticker
 	 				cb2 = writer.getDirectContent();
 					cb2.beginText();
 	 				cb2.setFontAndSize(bf, 10);
 	 				cb2.showTextAligned(PdfContentByte.ALIGN_LEFT, s, 35, 805, 0);
 	 				cb2.endText();
 	 				
 	 				// second sticker
 	 				cb3 = writer.getDirectContent();
 					cb3.beginText();
 	 				cb3.setFontAndSize(bf, 10);
 	 				cb3.showTextAligned(PdfContentByte.ALIGN_LEFT, s,325, 805, 0);
 	 				cb3.endText();
 	 				
 	 				//first sticker
 	 				cb4 = writer.getDirectContent();
 					cb4.beginText();
 	 				cb4.setFontAndSize(bf, 10);
 	 				cb4.showTextAligned(PdfContentByte.ALIGN_LEFT, s2, 200,805, 0);
 	 				cb4.endText();
 	 				
 	 				//second sticker
 	 				cb5 = writer.getDirectContent();
 					cb5.beginText();
 	 				cb5.setFontAndSize(bf, 10);
 	 				cb5.showTextAligned(PdfContentByte.ALIGN_LEFT, s2, 500, 805, 0);
 	 				cb5.endText();
 	 				
 	 				
 	 				cb6 = writer.getDirectContent();
 					cb6.beginText();
 	 				cb6.setFontAndSize(bf, 10);
 	 				cb6.showTextAligned(PdfContentByte.ALIGN_LEFT, s3, 35, 786, 0);
 	 				cb6.endText();
 	 				
 	 				cb7 = writer.getDirectContent();
 					cb7.beginText();
 	 				cb7.setFontAndSize(bf, 10);
 	 				cb7.showTextAligned(PdfContentByte.ALIGN_LEFT, s3, 325, 786, 0);
 	 				cb7.endText();
 	 				
 	 				
 	 				cb8 = writer.getDirectContent();
 					cb8.beginText();
 	 				cb8.setFontAndSize(bf, 10);
 	 				cb8.showTextAligned(PdfContentByte.ALIGN_LEFT, s4, 35, 767, 0);
 	 				cb8.endText();
 	 				
 	 				
 	 				cb9 = writer.getDirectContent();
 					cb9.beginText();
 	 				cb9.setFontAndSize(bf, 10);
 	 				cb9.showTextAligned(PdfContentByte.ALIGN_LEFT, s4, 325, 767, 0);
 	 				cb9.endText();
 	 				
 	 				
 	 				
 	 				cb10 = writer.getDirectContent();
 					cb10.beginText();
 	 				cb10.setFontAndSize(bf, 10);
 	 				cb10.showTextAligned(PdfContentByte.ALIGN_LEFT, s5, 35, 755, 0);
 	 				cb10.endText();
 	 				
 	 				
 	 				
 	 				
 	 				
 	 				cb11 = writer.getDirectContent();
 					cb11.beginText();
 	 				cb11.setFontAndSize(bf, 10);
 	 				cb11.showTextAligned(PdfContentByte.ALIGN_LEFT, s5, 325, 755, 0);
 	 				cb11.endText();
 	 				
 	 				
 	 				
 	 				
 	 				
 	 				cb2 = writer.getDirectContent();
 					cb2.beginText();
 	 				cb2.setFontAndSize(bf, 10);
 	 				cb2.showTextAligned(PdfContentByte.ALIGN_LEFT, s, 35, 705, 0);
 	 				cb2.endText();
 	 				
 	 				// second sticker
 	 				cb3 = writer.getDirectContent();
 					cb3.beginText();
 	 				cb3.setFontAndSize(bf, 10);
 	 				cb3.showTextAligned(PdfContentByte.ALIGN_LEFT, s, 325, 705, 0);
 	 				cb3.endText();
 	 				
 	 				//first sticker
 	 				cb4 = writer.getDirectContent();
 					cb4.beginText();
 	 				cb4.setFontAndSize(bf, 10);
 	 				cb4.showTextAligned(PdfContentByte.ALIGN_LEFT, s2, 200,705, 0);
 	 				cb4.endText();
 	 				
 	 				//second sticker
 	 				cb5 = writer.getDirectContent();
 					cb5.beginText();
 	 				cb5.setFontAndSize(bf, 10);
 	 				cb5.showTextAligned(PdfContentByte.ALIGN_LEFT, s2, 500, 705, 0);
 	 				cb5.endText();
 	 				
 	 				
 	 				cb6 = writer.getDirectContent();
 					cb6.beginText();
 	 				cb6.setFontAndSize(bf, 10);
 	 				cb6.showTextAligned(PdfContentByte.ALIGN_LEFT, s3, 35, 686, 0);
 	 				cb6.endText();
 	 				
 	 				cb7 = writer.getDirectContent();
 					cb7.beginText();
 	 				cb7.setFontAndSize(bf, 10);
 	 				cb7.showTextAligned(PdfContentByte.ALIGN_LEFT, s3, 325, 686, 0);
 	 				cb7.endText();
 	 				
 	 				
 	 				cb8 = writer.getDirectContent();
 					cb8.beginText();
 	 				cb8.setFontAndSize(bf, 10);
 	 				cb8.showTextAligned(PdfContentByte.ALIGN_LEFT, s4, 35, 667, 0);
 	 				cb8.endText();
 	 				
 	 				
 	 				cb9 = writer.getDirectContent();
 					cb9.beginText();
 	 				cb9.setFontAndSize(bf, 10);
 	 				cb9.showTextAligned(PdfContentByte.ALIGN_LEFT, s4, 325, 667, 0);
 	 				cb9.endText();
 	 				
 	 				
 	 				
 	 				cb10 = writer.getDirectContent();
 					cb10.beginText();
 	 				cb10.setFontAndSize(bf, 10);
 	 				cb10.showTextAligned(PdfContentByte.ALIGN_LEFT, s5, 35, 655, 0);
 	 				cb10.endText();
 	 				
 	 				
 	 				
 	 				
 	 				
 	 				cb11 = writer.getDirectContent();
 					cb11.beginText();
 	 				cb11.setFontAndSize(bf, 10);
 	 				cb11.showTextAligned(PdfContentByte.ALIGN_LEFT, s5, 325, 655, 0);
 	 				cb11.endText();
 	 				
 	 				// second sticker
 	 				
 	 				
 	 				
 	 				
 	 				document.add(p);
 	 				document.close();
 	 				writer.close();
 	 				Desktop.getDesktop().open(new File("print1.pdf"));
 	 				
      	        }catch(Exception fe)
      	        {
      	        	fe.printStackTrace();
      	        }
	         
	         	
 				 
	           
	}
		catch(Exception e)
		{}
	
	}
	
	public void printsticker1()
	{
		
		Document document = new Document(PageSize.A4,0,0,0,0);
		try
	      {     
	         PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream("print1.pdf"));
	         document.open();
	         Paragraph p = new Paragraph("",new com.itextpdf.text.Font(com.itextpdf.text.Font.FontFamily.TIMES_ROMAN,11));
	         try{ 	
	        	 
	        	 	conn1 =DriverManager.getConnection("jdbc:sqlite:print.sqlite"); 
 		        	String query="select * from  sticker";
 	 				PreparedStatement pst=conn1.prepareStatement(query);
 	 				ResultSet rs=pst.executeQuery();
 	 				byte[] b2=rs.getBytes("image");
 	 				pst.close();
 	 				rs.close();
 	 				
 	 				com.itextpdf.text.Image image1 = com.itextpdf.text.Image.getInstance(b2);
 	 				com.itextpdf.text.Image jpg=com.itextpdf.text.Image.getInstance(b2);
 	 				jpg.scaleToFit  (700, 850);
 	 				jpg.setAlignment(com.itextpdf.text.Image.UNDERLYING);
 	 				jpg.setAbsolutePosition(0, 0);
 	 				document.add(jpg);
 	 				
 	 				BaseFont bf = BaseFont.createFont(BaseFont.HELVETICA, BaseFont.CP1252, BaseFont.NOT_EMBEDDED);
 	 				Font f = new Font("Kruti Dev 165", Font.PLAIN, 13);
 	 				
 	 				
 	 				
 	 				
 					
 					String s,s1,s2,s3,s4,s5;
 					s = "Name  ".concat(reg_name.getText().toString());
 					s1 = (uhid.getText().toString());
 					s2 = ipd.getText().toString();
 					s2 = "UHID/IPD  ".concat(s1.concat("/").concat(s2));
 					s3 = "Care of  ".concat(reg_fname.getText().toString());
 					s4 = "Operation  ".concat(reason.getText().toString());
 					s5 = "Category  ".concat(categ.getSelectedItem().toString()).concat("      Contact  ").concat(reg_mobile.getText().toString());
 					
 	 				//first sticker
 	 				cb2 = writer.getDirectContent();
 					cb2.beginText();
 	 				cb2.setFontAndSize(bf, 10);
 	 				cb2.showTextAligned(PdfContentByte.ALIGN_LEFT, s, 35, 800, 0);
 	 				cb2.endText();
 	 				
 	 				// second sticker
 	 				cb3 = writer.getDirectContent();
 					cb3.beginText();
 	 				cb3.setFontAndSize(bf, 10);
 	 				cb3.showTextAligned(PdfContentByte.ALIGN_LEFT, s,325, 800, 0);
 	 				cb3.endText();
 	 				
 	 				//first sticker
 	 				cb4 = writer.getDirectContent();
 					cb4.beginText();
 	 				cb4.setFontAndSize(bf, 10);
 	 				cb4.showTextAligned(PdfContentByte.ALIGN_LEFT, s2, 200,800, 0);
 	 				cb4.endText();
 	 				
 	 				//second sticker
 	 				cb5 = writer.getDirectContent();
 					cb5.beginText();
 	 				cb5.setFontAndSize(bf, 10);
 	 				cb5.showTextAligned(PdfContentByte.ALIGN_LEFT, s2, 500, 800, 0);
 	 				cb5.endText();
 	 				
 	 				
 	 				cb6 = writer.getDirectContent();
 					cb6.beginText();
 	 				cb6.setFontAndSize(bf, 10);
 	 				cb6.showTextAligned(PdfContentByte.ALIGN_LEFT, s3, 35, 781, 0);
 	 				cb6.endText();
 	 				
 	 				cb7 = writer.getDirectContent();
 					cb7.beginText();
 	 				cb7.setFontAndSize(bf, 10);
 	 				cb7.showTextAligned(PdfContentByte.ALIGN_LEFT, s3, 325, 781, 0);
 	 				cb7.endText();
 	 				
 	 				
 	 				cb8 = writer.getDirectContent();
 					cb8.beginText();
 	 				cb8.setFontAndSize(bf, 10);
 	 				cb8.showTextAligned(PdfContentByte.ALIGN_LEFT, s4, 35, 762, 0);
 	 				cb8.endText();
 	 				
 	 				
 	 				cb9 = writer.getDirectContent();
 					cb9.beginText();
 	 				cb9.setFontAndSize(bf, 10);
 	 				cb9.showTextAligned(PdfContentByte.ALIGN_LEFT, s4, 325, 762, 0);
 	 				cb9.endText();
 	 				
 	 				
 	 				
 	 				cb10 = writer.getDirectContent();
 					cb10.beginText();
 	 				cb10.setFontAndSize(bf, 10);
 	 				cb10.showTextAligned(PdfContentByte.ALIGN_LEFT, s5, 35, 750, 0);
 	 				cb10.endText();
 	 				
 	 				
 	 				
 	 				
 	 				
 	 				cb11 = writer.getDirectContent();
 					cb11.beginText();
 	 				cb11.setFontAndSize(bf, 10);
 	 				cb11.showTextAligned(PdfContentByte.ALIGN_LEFT, s5, 325, 750, 0);
 	 				cb11.endText();
 	 				
 	 				
 	 				
 	 				cb2 = writer.getDirectContent();
 					cb2.beginText();
 	 				cb2.setFontAndSize(bf, 10);
 	 				cb2.showTextAligned(PdfContentByte.ALIGN_LEFT, s, 35, 700, 0);
 	 				cb2.endText();
 	 				
 	 				// second sticker
 	 				cb3 = writer.getDirectContent();
 					cb3.beginText();
 	 				cb3.setFontAndSize(bf, 10);
 	 				cb3.showTextAligned(PdfContentByte.ALIGN_LEFT, s, 325, 700, 0);
 	 				cb3.endText();
 	 				
 	 				//first sticker
 	 				cb4 = writer.getDirectContent();
 					cb4.beginText();
 	 				cb4.setFontAndSize(bf, 10);
 	 				cb4.showTextAligned(PdfContentByte.ALIGN_LEFT, s2, 200,700, 0);
 	 				cb4.endText();
 	 				
 	 				//second sticker
 	 				cb5 = writer.getDirectContent();
 					cb5.beginText();
 	 				cb5.setFontAndSize(bf, 10);
 	 				cb5.showTextAligned(PdfContentByte.ALIGN_LEFT, s2, 500, 700, 0);
 	 				cb5.endText();
 	 				
 	 				
 	 				cb6 = writer.getDirectContent();
 					cb6.beginText();
 	 				cb6.setFontAndSize(bf, 10);
 	 				cb6.showTextAligned(PdfContentByte.ALIGN_LEFT, s3, 35, 681, 0);
 	 				cb6.endText();
 	 				
 	 				cb7 = writer.getDirectContent();
 					cb7.beginText();
 	 				cb7.setFontAndSize(bf, 10);
 	 				cb7.showTextAligned(PdfContentByte.ALIGN_LEFT, s3, 325, 681, 0);
 	 				cb7.endText();
 	 				
 	 				
 	 				cb8 = writer.getDirectContent();
 					cb8.beginText();
 	 				cb8.setFontAndSize(bf, 10);
 	 				cb8.showTextAligned(PdfContentByte.ALIGN_LEFT, s4, 35, 662, 0);
 	 				cb8.endText();
 	 				
 	 				
 	 				cb9 = writer.getDirectContent();
 					cb9.beginText();
 	 				cb9.setFontAndSize(bf, 10);
 	 				cb9.showTextAligned(PdfContentByte.ALIGN_LEFT, s4, 325, 662, 0);
 	 				cb9.endText();
 	 				
 	 				
 	 				
 	 				cb10 = writer.getDirectContent();
 					cb10.beginText();
 	 				cb10.setFontAndSize(bf, 10);
 	 				cb10.showTextAligned(PdfContentByte.ALIGN_LEFT, s5, 35, 650, 0);
 	 				cb10.endText();
 	 				
 	 				
 	 				
 	 				
 	 				
 	 				cb11 = writer.getDirectContent();
 					cb11.beginText();
 	 				cb11.setFontAndSize(bf, 10);
 	 				cb11.showTextAligned(PdfContentByte.ALIGN_LEFT, s5, 325, 650, 0);
 	 				cb11.endText();
 	 				
 	 				// second sticker
 	 				
 	 				
 	 				
 	 				
 	 				document.add(p);
 	 				document.close();
 	 				writer.close();
 	 				Desktop.getDesktop().open(new File("print1.pdf"));
 	 				
      	        }catch(Exception fe)
      	        {
      	        	fe.printStackTrace();
      	        }
	         
	         	
 				 
	           
	}
		catch(Exception e)
		{}
	
	}
	
	public void printopd()
	{
		
		Document document = new Document(PageSize.A4,0,0,0,0);
		try
	      {     
	         PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream("print1.pdf"));
	         document.open();
	         Paragraph p = new Paragraph("",new com.itextpdf.text.Font(com.itextpdf.text.Font.FontFamily.TIMES_ROMAN,11));
	         try{ 	
	        	 
	        	 	conn1 =DriverManager.getConnection("jdbc:sqlite:print.sqlite"); 
 		        	String query="select * from  printopd";
 	 				PreparedStatement pst=conn1.prepareStatement(query);
 	 				ResultSet rs=pst.executeQuery();
 	 				byte[] b2=rs.getBytes("image");
 	 				pst.close();
 	 				rs.close();
 	 				
 	 				com.itextpdf.text.Image image1 = com.itextpdf.text.Image.getInstance(b2);
 	 				com.itextpdf.text.Image jpg=com.itextpdf.text.Image.getInstance(b2);
 	 				jpg.scaleToFit  (550, 550);
 	 				jpg.setAlignment(com.itextpdf.text.Image.UNDERLYING);
 	 				jpg.setAbsolutePosition(0, 580);
 	 				document.add(jpg);
 	 				
 	 				PdfContentByte cb2,cb3,cb4,cb5,cb6,cb7,cb8,cb9,cb10,cb11,cb12,cb13,cb14,cb15,cb16,cb17,cb18,cb19,cb20,cb21,cb22,cb23,cb24,cb25,cb26,cb27,cb28,cb29,cb30,cb31,cb32,cb33,cb34,cb35,cb36;
 	 				BaseFont bf = BaseFont.createFont(BaseFont.HELVETICA, BaseFont.CP1252, BaseFont.NOT_EMBEDDED);
 	 				
 	 				
 	 				
 	 				
 	 				//JOptionPane.showMessageDialog(null, s);
 	 			
 	 				
 	 				
 	 				cb2 = writer.getDirectContent();
 					cb2.beginText();
 	 				cb2.setFontAndSize(bf, 10);
 	 				cb2.showTextAligned(PdfContentByte.ALIGN_LEFT, "+reg_name.getText()+", 148, 745, 0);
 	 				cb2.endText();
 	 				
 	 				cb3 = writer.getDirectContent();
 					cb3.beginText();
 	 				cb3.setFontAndSize(bf, 10);
 	 				cb3.showTextAligned(PdfContentByte.ALIGN_LEFT, date, 489, 745, 0);
 	 				cb3.endText();
 	 				
 	 				
 	 				cb4 = writer.getDirectContent();
 					cb4.beginText();
 	 				cb4.setFontAndSize(bf, 10);
 	 				cb4.showTextAligned(PdfContentByte.ALIGN_LEFT, t2, 30, 745, 0);
 	 				cb4.endText();
 	 				
 	 				cb5 = writer.getDirectContent();
 					cb5.beginText();
 	 				cb5.setFontAndSize(bf, 10);
 	 				cb5.showTextAligned(PdfContentByte.ALIGN_LEFT, t2, 250, 746, 0);
 	 				cb5.endText();
 	 				
 	 				
 	 				cb6 = writer.getDirectContent();
 					cb6.beginText();
 	 				cb6.setFontAndSize(bf, 10);
 	 				cb6.showTextAligned(PdfContentByte.ALIGN_LEFT, t3, 72, 699, 0);
 	 				cb6.endText();
 	 				
 	 				cb7 = writer.getDirectContent();
 					cb7.beginText();
 	 				cb7.setFontAndSize(bf, 10);
 	 				cb7.showTextAligned(PdfContentByte.ALIGN_LEFT, t3, 305, 699, 0);
 	 				cb7.endText();
 	 				
 	 				
 	 				cb8 = writer.getDirectContent();
 					cb8.beginText();
 	 				cb8.setFontAndSize(bf, 10);
 	 				cb8.showTextAligned(PdfContentByte.ALIGN_LEFT, s, 120, 650, 0);
 	 				cb8.endText();
 	 				
 	 				
 	 				cb9 = writer.getDirectContent();
 					cb9.beginText();
 	 				cb9.setFontAndSize(bf, 10);
 	 				cb9.showTextAligned(PdfContentByte.ALIGN_LEFT, s, 387, 654, 0);
 	 				cb9.endText();
 	 				
 	 				
 	 				
 	 				cb10 = writer.getDirectContent();
 					cb10.beginText();
 	 				cb10.setFontAndSize(bf, 10);
 	 				cb10.showTextAligned(PdfContentByte.ALIGN_LEFT, t4, 25, 590, 0);
 	 				cb10.endText();
 	 				
 	 				
 	 				cb11 = writer.getDirectContent();
 					cb11.beginText();
 	 				cb11.setFontAndSize(bf, 10);
 	 				cb11.showTextAligned(PdfContentByte.ALIGN_LEFT, t4, 235, 592, 0);
 	 				cb11.endText();
 	 				
 	 				
 	 				cb12 = writer.getDirectContent();
 					cb12.beginText();
 	 				cb12.setFontAndSize(bf, 10);
 	 				cb12.showTextAligned(PdfContentByte.ALIGN_LEFT, t5, 72, 675, 0);
 	 				cb12.endText();
 	 				
 	 				
 	 				cb13 = writer.getDirectContent();
 					cb13.beginText();
 	 				cb13.setFontAndSize(bf, 10);
 	 				cb13.showTextAligned(PdfContentByte.ALIGN_LEFT, t5, 307, 675, 0);
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
	
	
	public void printline8()
	{
		Document document = new Document(PageSize.A4,0,0,0,0);
		try
	      {     
	         PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream("print1.pdf"));
	         document.open();
	         Paragraph p = new Paragraph("",new com.itextpdf.text.Font(com.itextpdf.text.Font.FontFamily.TIMES_ROMAN,11));
	         try{ 	
	        	 
	        	 	conn1 =DriverManager.getConnection("jdbc:sqlite:print.sqlite"); 
 		        	String query="select * from  sticker";
 	 				PreparedStatement pst=conn1.prepareStatement(query);
 	 				ResultSet rs=pst.executeQuery();
 	 				byte[] b2=rs.getBytes("image");
 	 				pst.close();
 	 				rs.close();
 	 				
 	 				com.itextpdf.text.Image image1 = com.itextpdf.text.Image.getInstance(b2);
 	 				com.itextpdf.text.Image jpg=com.itextpdf.text.Image.getInstance(b2);
 	 				jpg.scaleToFit  (700, 850);
 	 				jpg.setAlignment(com.itextpdf.text.Image.UNDERLYING);
 	 				jpg.setAbsolutePosition(0, 0);
 	 				document.add(jpg);
 	 				
 	 				BaseFont bf = BaseFont.createFont(BaseFont.HELVETICA, BaseFont.CP1252, BaseFont.NOT_EMBEDDED);
 	 				Font f = new Font("Kruti Dev 165", Font.PLAIN, 13);
 	 				
 	 				
 	 				
 	 				
 					
 					String s,s1,s2,s3,s4,s5;
 					s = "Name  ".concat(reg_name.getText().toString());
 					s1 = (uhid.getText().toString());
 					s2 = ipd.getText().toString();
 					s2 = "UHID/IPD  ".concat(s1.concat("/").concat(s2));
 					s3 = "Care of  ".concat(reg_fname.getText().toString());
 					s4 = "Operation  ".concat(reason.getText().toString());
 					s5 = "Category  ".concat(categ.getSelectedItem().toString()).concat("      Contact  ").concat(reg_mobile.getText().toString());
 					
 	 				//first sticker
 					cb2 = writer.getDirectContent();
 					cb2.beginText();
 	 				cb2.setFontAndSize(bf, 10);
 	 				cb2.showTextAligned(PdfContentByte.ALIGN_LEFT, s, 35, 100, 0);
 	 				cb2.endText();
 	 				
 	 				// second sticker
 	 				cb3 = writer.getDirectContent();
 					cb3.beginText();
 	 				cb3.setFontAndSize(bf, 10);
 	 				cb3.showTextAligned(PdfContentByte.ALIGN_LEFT, s, 325, 100, 0);
 	 				cb3.endText();
 	 				
 	 				//first sticker
 	 				cb4 = writer.getDirectContent();
 					cb4.beginText();
 	 				cb4.setFontAndSize(bf, 10);
 	 				cb4.showTextAligned(PdfContentByte.ALIGN_LEFT, s2, 200,100, 0);
 	 				cb4.endText();
 	 				
 	 				//second sticker
 	 				cb5 = writer.getDirectContent();
 					cb5.beginText();
 	 				cb5.setFontAndSize(bf, 10);
 	 				cb5.showTextAligned(PdfContentByte.ALIGN_LEFT, s2, 500, 100, 0);
 	 				cb5.endText();
 	 				
 	 				
 	 				cb6 = writer.getDirectContent();
 					cb6.beginText();
 	 				cb6.setFontAndSize(bf, 10);
 	 				cb6.showTextAligned(PdfContentByte.ALIGN_LEFT, s3, 35, 81, 0);
 	 				cb6.endText();
 	 				
 	 				cb7 = writer.getDirectContent();
 					cb7.beginText();
 	 				cb7.setFontAndSize(bf, 10);
 	 				cb7.showTextAligned(PdfContentByte.ALIGN_LEFT, s3, 325, 81, 0);
 	 				cb7.endText();
 	 				
 	 				
 	 				cb8 = writer.getDirectContent();
 					cb8.beginText();
 	 				cb8.setFontAndSize(bf, 10);
 	 				cb8.showTextAligned(PdfContentByte.ALIGN_LEFT, s4, 35, 62, 0);
 	 				cb8.endText();
 	 				
 	 				
 	 				cb9 = writer.getDirectContent();
 					cb9.beginText();
 	 				cb9.setFontAndSize(bf, 10);
 	 				cb9.showTextAligned(PdfContentByte.ALIGN_LEFT, s4, 325, 62, 0);
 	 				cb9.endText();
 	 				
 	 				
 	 				
 	 				cb10 = writer.getDirectContent();
 					cb10.beginText();
 	 				cb10.setFontAndSize(bf, 10);
 	 				cb10.showTextAligned(PdfContentByte.ALIGN_LEFT, s5, 35, 50, 0);
 	 				cb10.endText();
 	 				
 	 				
 	 				
 	 				
 	 				
 	 				cb11 = writer.getDirectContent();
 					cb11.beginText();
 	 				cb11.setFontAndSize(bf, 10);
 	 				cb11.showTextAligned(PdfContentByte.ALIGN_LEFT, s5, 325, 50, 0);
 	 				cb11.endText();
 	 				// second sticker
 	 				
 	 				
 	 				
 	 				
 	 				document.add(p);
 	 				document.close();
 	 				writer.close();
 	 				Desktop.getDesktop().open(new File("print1.pdf"));
 	 				
      	        }catch(Exception fe)
      	        {
      	        	fe.printStackTrace();
      	        }
	         
	         	
 				 
	           
	}
		catch(Exception e)
		{}
	}
	
	
	
	public void printline7()
	{
		Document document = new Document(PageSize.A4,0,0,0,0);
		try
	      {     
	         PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream("print1.pdf"));
	         document.open();
	         Paragraph p = new Paragraph("",new com.itextpdf.text.Font(com.itextpdf.text.Font.FontFamily.TIMES_ROMAN,11));
	         try{ 	
	        	 
	        	 	conn1 =DriverManager.getConnection("jdbc:sqlite:print.sqlite"); 
 		        	String query="select * from  sticker";
 	 				PreparedStatement pst=conn1.prepareStatement(query);
 	 				ResultSet rs=pst.executeQuery();
 	 				byte[] b2=rs.getBytes("image");
 	 				pst.close();
 	 				rs.close();
 	 				
 	 				com.itextpdf.text.Image image1 = com.itextpdf.text.Image.getInstance(b2);
 	 				com.itextpdf.text.Image jpg=com.itextpdf.text.Image.getInstance(b2);
 	 				jpg.scaleToFit  (700, 850);
 	 				jpg.setAlignment(com.itextpdf.text.Image.UNDERLYING);
 	 				jpg.setAbsolutePosition(0, 0);
 	 				document.add(jpg);
 	 				
 	 				BaseFont bf = BaseFont.createFont(BaseFont.HELVETICA, BaseFont.CP1252, BaseFont.NOT_EMBEDDED);
 	 				Font f = new Font("Kruti Dev 165", Font.PLAIN, 13);
 	 				
 	 				
 	 				
 	 				
 					
 					String s,s1,s2,s3,s4,s5;
 					s = "Name  ".concat(reg_name.getText().toString());
 					s1 = (uhid.getText().toString());
 					s2 = ipd.getText().toString();
 					s2 = "UHID/IPD  ".concat(s1.concat("/").concat(s2));
 					s3 = "Care of  ".concat(reg_fname.getText().toString());
 					s4 = "Operation  ".concat(reason.getText().toString());
 					s5 = "Category  ".concat(categ.getSelectedItem().toString()).concat("      Contact  ").concat(reg_mobile.getText().toString());
 					
 	 				//first sticker
 					cb2 = writer.getDirectContent();
 					cb2.beginText();
 	 				cb2.setFontAndSize(bf, 10);
 	 				cb2.showTextAligned(PdfContentByte.ALIGN_LEFT, s, 35, 200, 0);
 	 				cb2.endText();
 	 				
 	 				// second sticker
 	 				cb3 = writer.getDirectContent();
 					cb3.beginText();
 	 				cb3.setFontAndSize(bf, 10);
 	 				cb3.showTextAligned(PdfContentByte.ALIGN_LEFT, s, 325, 200, 0);
 	 				cb3.endText();
 	 				
 	 				//first sticker
 	 				cb4 = writer.getDirectContent();
 					cb4.beginText();
 	 				cb4.setFontAndSize(bf, 10);
 	 				cb4.showTextAligned(PdfContentByte.ALIGN_LEFT, s2, 200,200, 0);
 	 				cb4.endText();
 	 				
 	 				//second sticker
 	 				cb5 = writer.getDirectContent();
 					cb5.beginText();
 	 				cb5.setFontAndSize(bf, 10);
 	 				cb5.showTextAligned(PdfContentByte.ALIGN_LEFT, s2, 500, 200, 0);
 	 				cb5.endText();
 	 				
 	 				
 	 				cb6 = writer.getDirectContent();
 					cb6.beginText();
 	 				cb6.setFontAndSize(bf, 10);
 	 				cb6.showTextAligned(PdfContentByte.ALIGN_LEFT, s3, 35, 181, 0);
 	 				cb6.endText();
 	 				
 	 				cb7 = writer.getDirectContent();
 					cb7.beginText();
 	 				cb7.setFontAndSize(bf, 10);
 	 				cb7.showTextAligned(PdfContentByte.ALIGN_LEFT, s3, 325, 181, 0);
 	 				cb7.endText();
 	 				
 	 				
 	 				cb8 = writer.getDirectContent();
 					cb8.beginText();
 	 				cb8.setFontAndSize(bf, 10);
 	 				cb8.showTextAligned(PdfContentByte.ALIGN_LEFT, s4, 35, 162, 0);
 	 				cb8.endText();
 	 				
 	 				
 	 				cb9 = writer.getDirectContent();
 					cb9.beginText();
 	 				cb9.setFontAndSize(bf, 10);
 	 				cb9.showTextAligned(PdfContentByte.ALIGN_LEFT, s4, 325, 162, 0);
 	 				cb9.endText();
 	 				
 	 				
 	 				
 	 				cb10 = writer.getDirectContent();
 					cb10.beginText();
 	 				cb10.setFontAndSize(bf, 10);
 	 				cb10.showTextAligned(PdfContentByte.ALIGN_LEFT, s5, 35, 150, 0);
 	 				cb10.endText();
 	 				
 	 				
 	 				
 	 				
 	 				
 	 				cb11 = writer.getDirectContent();
 					cb11.beginText();
 	 				cb11.setFontAndSize(bf, 10);
 	 				cb11.showTextAligned(PdfContentByte.ALIGN_LEFT, s5, 325, 150, 0);
 	 				cb11.endText();
 	 				
 	 				
 	 				
 	 				cb2 = writer.getDirectContent();
 					cb2.beginText();
 	 				cb2.setFontAndSize(bf, 10);
 	 				cb2.showTextAligned(PdfContentByte.ALIGN_LEFT, s, 35, 100, 0);
 	 				cb2.endText();
 	 				
 	 				// second sticker
 	 				cb3 = writer.getDirectContent();
 					cb3.beginText();
 	 				cb3.setFontAndSize(bf, 10);
 	 				cb3.showTextAligned(PdfContentByte.ALIGN_LEFT, s, 325, 100, 0);
 	 				cb3.endText();
 	 				
 	 				//first sticker
 	 				cb4 = writer.getDirectContent();
 					cb4.beginText();
 	 				cb4.setFontAndSize(bf, 10);
 	 				cb4.showTextAligned(PdfContentByte.ALIGN_LEFT, s2, 200,100, 0);
 	 				cb4.endText();
 	 				
 	 				//second sticker
 	 				cb5 = writer.getDirectContent();
 					cb5.beginText();
 	 				cb5.setFontAndSize(bf, 10);
 	 				cb5.showTextAligned(PdfContentByte.ALIGN_LEFT, s2, 500, 100, 0);
 	 				cb5.endText();
 	 				
 	 				
 	 				cb6 = writer.getDirectContent();
 					cb6.beginText();
 	 				cb6.setFontAndSize(bf, 10);
 	 				cb6.showTextAligned(PdfContentByte.ALIGN_LEFT, s3, 35, 81, 0);
 	 				cb6.endText();
 	 				
 	 				cb7 = writer.getDirectContent();
 					cb7.beginText();
 	 				cb7.setFontAndSize(bf, 10);
 	 				cb7.showTextAligned(PdfContentByte.ALIGN_LEFT, s3, 325, 81, 0);
 	 				cb7.endText();
 	 				
 	 				
 	 				cb8 = writer.getDirectContent();
 					cb8.beginText();
 	 				cb8.setFontAndSize(bf, 10);
 	 				cb8.showTextAligned(PdfContentByte.ALIGN_LEFT, s4, 35, 62, 0);
 	 				cb8.endText();
 	 				
 	 				
 	 				cb9 = writer.getDirectContent();
 					cb9.beginText();
 	 				cb9.setFontAndSize(bf, 10);
 	 				cb9.showTextAligned(PdfContentByte.ALIGN_LEFT, s4, 325, 62, 0);
 	 				cb9.endText();
 	 				
 	 				
 	 				
 	 				cb10 = writer.getDirectContent();
 					cb10.beginText();
 	 				cb10.setFontAndSize(bf, 10);
 	 				cb10.showTextAligned(PdfContentByte.ALIGN_LEFT, s5, 35, 50, 0);
 	 				cb10.endText();
 	 				
 	 				
 	 				
 	 				
 	 				
 	 				cb11 = writer.getDirectContent();
 					cb11.beginText();
 	 				cb11.setFontAndSize(bf, 10);
 	 				cb11.showTextAligned(PdfContentByte.ALIGN_LEFT, s5, 325, 50, 0);
 	 				cb11.endText();
 	 				// second sticker
 	 				
 	 				
 	 				
 	 				
 	 				
 	 				document.add(p);
 	 				document.close();
 	 				writer.close();
 	 				Desktop.getDesktop().open(new File("print1.pdf"));
 	 				
      	        }catch(Exception fe)
      	        {
      	        	fe.printStackTrace();
      	        }
	         
	         	
 				 
	           
	}
		catch(Exception e)
		{}
	}
	
	public void printline6()
	{
		Document document = new Document(PageSize.A4,0,0,0,0);
		try
	      {     
	         PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream("print1.pdf"));
	         document.open();
	         Paragraph p = new Paragraph("",new com.itextpdf.text.Font(com.itextpdf.text.Font.FontFamily.TIMES_ROMAN,11));
	         try{ 	
	        	 
	        	 	conn1 =DriverManager.getConnection("jdbc:sqlite:print.sqlite"); 
 		        	String query="select * from  sticker";
 	 				PreparedStatement pst=conn1.prepareStatement(query);
 	 				ResultSet rs=pst.executeQuery();
 	 				byte[] b2=rs.getBytes("image");
 	 				pst.close();
 	 				rs.close();
 	 				
 	 				com.itextpdf.text.Image image1 = com.itextpdf.text.Image.getInstance(b2);
 	 				com.itextpdf.text.Image jpg=com.itextpdf.text.Image.getInstance(b2);
 	 				jpg.scaleToFit  (700, 850);
 	 				jpg.setAlignment(com.itextpdf.text.Image.UNDERLYING);
 	 				jpg.setAbsolutePosition(0, 0);
 	 				document.add(jpg);
 	 				
 	 				BaseFont bf = BaseFont.createFont(BaseFont.HELVETICA, BaseFont.CP1252, BaseFont.NOT_EMBEDDED);
 	 				Font f = new Font("Kruti Dev 165", Font.PLAIN, 13);
 	 				
 	 				
 	 				
 	 				
 					
 					String s,s1,s2,s3,s4,s5;
 					s = "Name  ".concat(reg_name.getText().toString());
 					s1 = (uhid.getText().toString());
 					s2 = ipd.getText().toString();
 					s2 = "UHID/ID  ".concat(s1.concat("/").concat(s2));
 					s3 = "Care of  ".concat(reg_fname.getText().toString());
 					s4 = "Operation  ".concat(reason.getText().toString());
 					s5 = "Category  ".concat(categ.getSelectedItem().toString()).concat("      Contact  ").concat(reg_mobile.getText().toString());
 					
 	 				//first sticker
 					cb2 = writer.getDirectContent();
 					cb2.beginText();
 	 				cb2.setFontAndSize(bf, 10);
 	 				cb2.showTextAligned(PdfContentByte.ALIGN_LEFT, s, 35, 300, 0);
 	 				cb2.endText();
 	 				
 	 				// second sticker
 	 				cb3 = writer.getDirectContent();
 					cb3.beginText();
 	 				cb3.setFontAndSize(bf, 10);
 	 				cb3.showTextAligned(PdfContentByte.ALIGN_LEFT, s, 325, 300, 0);
 	 				cb3.endText();
 	 				
 	 				//first sticker
 	 				cb4 = writer.getDirectContent();
 					cb4.beginText();
 	 				cb4.setFontAndSize(bf, 10);
 	 				cb4.showTextAligned(PdfContentByte.ALIGN_LEFT, s2, 200,300, 0);
 	 				cb4.endText();
 	 				
 	 				//second sticker
 	 				cb5 = writer.getDirectContent();
 					cb5.beginText();
 	 				cb5.setFontAndSize(bf, 10);
 	 				cb5.showTextAligned(PdfContentByte.ALIGN_LEFT, s2, 500, 300, 0);
 	 				cb5.endText();
 	 				
 	 				
 	 				cb6 = writer.getDirectContent();
 					cb6.beginText();
 	 				cb6.setFontAndSize(bf, 10);
 	 				cb6.showTextAligned(PdfContentByte.ALIGN_LEFT, s3, 35, 281, 0);
 	 				cb6.endText();
 	 				
 	 				cb7 = writer.getDirectContent();
 					cb7.beginText();
 	 				cb7.setFontAndSize(bf, 10);
 	 				cb7.showTextAligned(PdfContentByte.ALIGN_LEFT, s3, 325, 281, 0);
 	 				cb7.endText();
 	 				
 	 				
 	 				cb8 = writer.getDirectContent();
 					cb8.beginText();
 	 				cb8.setFontAndSize(bf, 10);
 	 				cb8.showTextAligned(PdfContentByte.ALIGN_LEFT, s4, 35, 262, 0);
 	 				cb8.endText();
 	 				
 	 				
 	 				cb9 = writer.getDirectContent();
 					cb9.beginText();
 	 				cb9.setFontAndSize(bf, 10);
 	 				cb9.showTextAligned(PdfContentByte.ALIGN_LEFT, s4, 325, 262, 0);
 	 				cb9.endText();
 	 				
 	 				
 	 				
 	 				cb10 = writer.getDirectContent();
 					cb10.beginText();
 	 				cb10.setFontAndSize(bf, 10);
 	 				cb10.showTextAligned(PdfContentByte.ALIGN_LEFT, s5, 35, 250, 0);
 	 				cb10.endText();
 	 				
 	 				
 	 				
 	 				
 	 				
 	 				cb11 = writer.getDirectContent();
 					cb11.beginText();
 	 				cb11.setFontAndSize(bf, 10);
 	 				cb11.showTextAligned(PdfContentByte.ALIGN_LEFT, s5, 325, 250, 0);
 	 				cb11.endText();
 	 				
 	 				
 	 				
 	 				
 	 				
 	 				cb2 = writer.getDirectContent();
 					cb2.beginText();
 	 				cb2.setFontAndSize(bf, 10);
 	 				cb2.showTextAligned(PdfContentByte.ALIGN_LEFT, s, 35, 200, 0);
 	 				cb2.endText();
 	 				
 	 				// second sticker
 	 				cb3 = writer.getDirectContent();
 					cb3.beginText();
 	 				cb3.setFontAndSize(bf, 10);
 	 				cb3.showTextAligned(PdfContentByte.ALIGN_LEFT, s, 325, 200, 0);
 	 				cb3.endText();
 	 				
 	 				//first sticker
 	 				cb4 = writer.getDirectContent();
 					cb4.beginText();
 	 				cb4.setFontAndSize(bf, 10);
 	 				cb4.showTextAligned(PdfContentByte.ALIGN_LEFT, s2, 200,200, 0);
 	 				cb4.endText();
 	 				
 	 				//second sticker
 	 				cb5 = writer.getDirectContent();
 					cb5.beginText();
 	 				cb5.setFontAndSize(bf, 10);
 	 				cb5.showTextAligned(PdfContentByte.ALIGN_LEFT, s2, 500, 200, 0);
 	 				cb5.endText();
 	 				
 	 				
 	 				cb6 = writer.getDirectContent();
 					cb6.beginText();
 	 				cb6.setFontAndSize(bf, 10);
 	 				cb6.showTextAligned(PdfContentByte.ALIGN_LEFT, s3, 35, 181, 0);
 	 				cb6.endText();
 	 				
 	 				cb7 = writer.getDirectContent();
 					cb7.beginText();
 	 				cb7.setFontAndSize(bf, 10);
 	 				cb7.showTextAligned(PdfContentByte.ALIGN_LEFT, s3, 325, 181, 0);
 	 				cb7.endText();
 	 				
 	 				
 	 				cb8 = writer.getDirectContent();
 					cb8.beginText();
 	 				cb8.setFontAndSize(bf, 10);
 	 				cb8.showTextAligned(PdfContentByte.ALIGN_LEFT, s4, 35, 162, 0);
 	 				cb8.endText();
 	 				
 	 				
 	 				cb9 = writer.getDirectContent();
 					cb9.beginText();
 	 				cb9.setFontAndSize(bf, 10);
 	 				cb9.showTextAligned(PdfContentByte.ALIGN_LEFT, s4, 325, 162, 0);
 	 				cb9.endText();
 	 				
 	 				
 	 				
 	 				cb10 = writer.getDirectContent();
 					cb10.beginText();
 	 				cb10.setFontAndSize(bf, 10);
 	 				cb10.showTextAligned(PdfContentByte.ALIGN_LEFT, s5, 35, 150, 0);
 	 				cb10.endText();
 	 				
 	 				
 	 				
 	 				
 	 				
 	 				cb11 = writer.getDirectContent();
 					cb11.beginText();
 	 				cb11.setFontAndSize(bf, 10);
 	 				cb11.showTextAligned(PdfContentByte.ALIGN_LEFT, s5, 325, 150, 0);
 	 				cb11.endText();
 	 				// second sticker
 	 				
 	 				
 	 				
 	 				
 	 				document.add(p);
 	 				document.close();
 	 				writer.close();
 	 				Desktop.getDesktop().open(new File("print1.pdf"));
 	 				
      	        }catch(Exception fe)
      	        {
      	        	fe.printStackTrace();
      	        }
	         
	         	
 				 
	           
	}
		catch(Exception e)
		{}
	}
	
	
	public void printline5()
	{
		Document document = new Document(PageSize.A4,0,0,0,0);
		try
	      {     
	         PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream("print1.pdf"));
	         document.open();
	         Paragraph p = new Paragraph("",new com.itextpdf.text.Font(com.itextpdf.text.Font.FontFamily.TIMES_ROMAN,11));
	         try{ 	
	        	 
	        	 	conn1 =DriverManager.getConnection("jdbc:sqlite:print.sqlite"); 
 		        	String query="select * from  sticker";
 	 				PreparedStatement pst=conn1.prepareStatement(query);
 	 				ResultSet rs=pst.executeQuery();
 	 				byte[] b2=rs.getBytes("image");
 	 				pst.close();
 	 				rs.close();
 	 				
 	 				com.itextpdf.text.Image image1 = com.itextpdf.text.Image.getInstance(b2);
 	 				com.itextpdf.text.Image jpg=com.itextpdf.text.Image.getInstance(b2);
 	 				jpg.scaleToFit  (700, 850);
 	 				jpg.setAlignment(com.itextpdf.text.Image.UNDERLYING);
 	 				jpg.setAbsolutePosition(0, 0);
 	 				document.add(jpg);
 	 				
 	 				BaseFont bf = BaseFont.createFont(BaseFont.HELVETICA, BaseFont.CP1252, BaseFont.NOT_EMBEDDED);
 	 				Font f = new Font("Kruti Dev 165", Font.PLAIN, 13);
 	 				
 	 				
 	 				
 	 				
 					
 					String s,s1,s2,s3,s4,s5;
 					s = "Name  ".concat(reg_name.getText().toString());
 					s1 = (uhid.getText().toString());
 					s2 = ipd.getText().toString();
 					s2 = "UHID/ID  ".concat(s1.concat("/").concat(s2));
 					s3 = "Care of  ".concat(reg_fname.getText().toString());
 					s4 = "Operation  ".concat(reason.getText().toString());
 					s5 = "Category  ".concat(categ.getSelectedItem().toString()).concat("      Contact  ").concat(reg_mobile.getText().toString());
 					
 	 				//first sticker
 					cb2 = writer.getDirectContent();
 					cb2.beginText();
 	 				cb2.setFontAndSize(bf, 10);
 	 				cb2.showTextAligned(PdfContentByte.ALIGN_LEFT, s, 35, 400, 0);
 	 				cb2.endText();
 	 				
 	 				// second sticker
 	 				cb3 = writer.getDirectContent();
 					cb3.beginText();
 	 				cb3.setFontAndSize(bf, 10);
 	 				cb3.showTextAligned(PdfContentByte.ALIGN_LEFT, s, 325, 400, 0);
 	 				cb3.endText();
 	 				
 	 				//first sticker
 	 				cb4 = writer.getDirectContent();
 					cb4.beginText();
 	 				cb4.setFontAndSize(bf, 10);
 	 				cb4.showTextAligned(PdfContentByte.ALIGN_LEFT, s2, 200,400, 0);
 	 				cb4.endText();
 	 				
 	 				//second sticker
 	 				cb5 = writer.getDirectContent();
 					cb5.beginText();
 	 				cb5.setFontAndSize(bf, 10);
 	 				cb5.showTextAligned(PdfContentByte.ALIGN_LEFT, s2, 500, 400, 0);
 	 				cb5.endText();
 	 				
 	 				
 	 				cb6 = writer.getDirectContent();
 					cb6.beginText();
 	 				cb6.setFontAndSize(bf, 10);
 	 				cb6.showTextAligned(PdfContentByte.ALIGN_LEFT, s3, 35, 381, 0);
 	 				cb6.endText();
 	 				
 	 				cb7 = writer.getDirectContent();
 					cb7.beginText();
 	 				cb7.setFontAndSize(bf, 10);
 	 				cb7.showTextAligned(PdfContentByte.ALIGN_LEFT, s3, 325, 381, 0);
 	 				cb7.endText();
 	 				
 	 				
 	 				cb8 = writer.getDirectContent();
 					cb8.beginText();
 	 				cb8.setFontAndSize(bf, 10);
 	 				cb8.showTextAligned(PdfContentByte.ALIGN_LEFT, s4, 35, 362, 0);
 	 				cb8.endText();
 	 				
 	 				
 	 				cb9 = writer.getDirectContent();
 					cb9.beginText();
 	 				cb9.setFontAndSize(bf, 10);
 	 				cb9.showTextAligned(PdfContentByte.ALIGN_LEFT, s4, 325, 362, 0);
 	 				cb9.endText();
 	 				
 	 				
 	 				
 	 				cb10 = writer.getDirectContent();
 					cb10.beginText();
 	 				cb10.setFontAndSize(bf, 10);
 	 				cb10.showTextAligned(PdfContentByte.ALIGN_LEFT, s5, 35, 350, 0);
 	 				cb10.endText();
 	 				
 	 				
 	 				
 	 				
 	 				
 	 				cb11 = writer.getDirectContent();
 					cb11.beginText();
 	 				cb11.setFontAndSize(bf, 10);
 	 				cb11.showTextAligned(PdfContentByte.ALIGN_LEFT, s5, 325, 350, 0);
 	 				cb11.endText();
 	 				
 	 				
 	 				cb2 = writer.getDirectContent();
 					cb2.beginText();
 	 				cb2.setFontAndSize(bf, 10);
 	 				cb2.showTextAligned(PdfContentByte.ALIGN_LEFT, s, 35, 300, 0);
 	 				cb2.endText();
 	 				
 	 				// second sticker
 	 				cb3 = writer.getDirectContent();
 					cb3.beginText();
 	 				cb3.setFontAndSize(bf, 10);
 	 				cb3.showTextAligned(PdfContentByte.ALIGN_LEFT, s, 325, 300, 0);
 	 				cb3.endText();
 	 				
 	 				//first sticker
 	 				cb4 = writer.getDirectContent();
 					cb4.beginText();
 	 				cb4.setFontAndSize(bf, 10);
 	 				cb4.showTextAligned(PdfContentByte.ALIGN_LEFT, s2, 200,300, 0);
 	 				cb4.endText();
 	 				
 	 				//second sticker
 	 				cb5 = writer.getDirectContent();
 					cb5.beginText();
 	 				cb5.setFontAndSize(bf, 10);
 	 				cb5.showTextAligned(PdfContentByte.ALIGN_LEFT, s2, 500, 300, 0);
 	 				cb5.endText();
 	 				
 	 				
 	 				cb6 = writer.getDirectContent();
 					cb6.beginText();
 	 				cb6.setFontAndSize(bf, 10);
 	 				cb6.showTextAligned(PdfContentByte.ALIGN_LEFT, s3, 35, 281, 0);
 	 				cb6.endText();
 	 				
 	 				cb7 = writer.getDirectContent();
 					cb7.beginText();
 	 				cb7.setFontAndSize(bf, 10);
 	 				cb7.showTextAligned(PdfContentByte.ALIGN_LEFT, s3, 325, 281, 0);
 	 				cb7.endText();
 	 				
 	 				
 	 				cb8 = writer.getDirectContent();
 					cb8.beginText();
 	 				cb8.setFontAndSize(bf, 10);
 	 				cb8.showTextAligned(PdfContentByte.ALIGN_LEFT, s4, 35, 262, 0);
 	 				cb8.endText();
 	 				
 	 				
 	 				cb9 = writer.getDirectContent();
 					cb9.beginText();
 	 				cb9.setFontAndSize(bf, 10);
 	 				cb9.showTextAligned(PdfContentByte.ALIGN_LEFT, s4, 325, 262, 0);
 	 				cb9.endText();
 	 				
 	 				
 	 				
 	 				cb10 = writer.getDirectContent();
 					cb10.beginText();
 	 				cb10.setFontAndSize(bf, 10);
 	 				cb10.showTextAligned(PdfContentByte.ALIGN_LEFT, s5, 35, 250, 0);
 	 				cb10.endText();
 	 				
 	 				
 	 				
 	 				
 	 				
 	 				cb11 = writer.getDirectContent();
 					cb11.beginText();
 	 				cb11.setFontAndSize(bf, 10);
 	 				cb11.showTextAligned(PdfContentByte.ALIGN_LEFT, s5, 325, 250, 0);
 	 				cb11.endText();
 	 				// second sticker
 	 				
 	 				
 	 				
 	 				
 	 				document.add(p);
 	 				document.close();
 	 				writer.close();
 	 				Desktop.getDesktop().open(new File("print1.pdf"));
 	 				
      	        }catch(Exception fe)
      	        {
      	        	fe.printStackTrace();
      	        }
	         
	         	
 				 
	           
	}
		catch(Exception e)
		{}
	}
	
	public void printline4()
	{
		Document document = new Document(PageSize.A4,0,0,0,0);
		try
	      {     
	         PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream("print1.pdf"));
	         document.open();
	         Paragraph p = new Paragraph("",new com.itextpdf.text.Font(com.itextpdf.text.Font.FontFamily.TIMES_ROMAN,11));
	         try{ 	
	        	 
	        	 conn1 =DriverManager.getConnection("jdbc:sqlite:print.sqlite"); 
 		        	String query="select * from  sticker";
 	 				PreparedStatement pst=conn1.prepareStatement(query);
 	 				ResultSet rs=pst.executeQuery();
 	 				byte[] b2=rs.getBytes("image");
 	 				pst.close();
 	 				rs.close();
 	 				
 	 				com.itextpdf.text.Image image1 = com.itextpdf.text.Image.getInstance(b2);
 	 				com.itextpdf.text.Image jpg=com.itextpdf.text.Image.getInstance(b2);
 	 				jpg.scaleToFit  (700, 850);
 	 				jpg.setAlignment(com.itextpdf.text.Image.UNDERLYING);
 	 				jpg.setAbsolutePosition(0, 0);
 	 				document.add(jpg);
 	 				
 	 				BaseFont bf = BaseFont.createFont(BaseFont.HELVETICA, BaseFont.CP1252, BaseFont.NOT_EMBEDDED);
 	 				Font f = new Font("Kruti Dev 165", Font.PLAIN, 13);
 	 				
 	 				
 	 				
 	 				
 					
 					String s,s1,s2,s3,s4,s5;
 					s = "Name  ".concat(reg_name.getText().toString());
 					s1 = (uhid.getText().toString());
 					s2 = ipd.getText().toString();
 					s2 = "UHID/IPD  ".concat(s1.concat("/").concat(s2));
 					s3 = "Care of  ".concat(reg_fname.getText().toString());
 					s4 = "Operation  ".concat(reason.getText().toString());
 					s5 = "Category  ".concat(categ.getSelectedItem().toString()).concat("      Contact  ").concat(reg_mobile.getText().toString());
 					
 	 				//first sticker
 					cb2 = writer.getDirectContent();
 					cb2.beginText();
 	 				cb2.setFontAndSize(bf, 10);
 	 				cb2.showTextAligned(PdfContentByte.ALIGN_LEFT, s, 35, 500, 0);
 	 				cb2.endText();
 	 				
 	 				// second sticker
 	 				cb3 = writer.getDirectContent();
 					cb3.beginText();
 	 				cb3.setFontAndSize(bf, 10);
 	 				cb3.showTextAligned(PdfContentByte.ALIGN_LEFT, s, 325, 500, 0);
 	 				cb3.endText();
 	 				
 	 				//first sticker
 	 				cb4 = writer.getDirectContent();
 					cb4.beginText();
 	 				cb4.setFontAndSize(bf, 10);
 	 				cb4.showTextAligned(PdfContentByte.ALIGN_LEFT, s2, 200,500, 0);
 	 				cb4.endText();
 	 				
 	 				//second sticker
 	 				cb5 = writer.getDirectContent();
 					cb5.beginText();
 	 				cb5.setFontAndSize(bf, 10);
 	 				cb5.showTextAligned(PdfContentByte.ALIGN_LEFT, s2, 500, 500, 0);
 	 				cb5.endText();
 	 				
 	 				
 	 				cb6 = writer.getDirectContent();
 					cb6.beginText();
 	 				cb6.setFontAndSize(bf, 10);
 	 				cb6.showTextAligned(PdfContentByte.ALIGN_LEFT, s3, 35, 481, 0);
 	 				cb6.endText();
 	 				
 	 				cb7 = writer.getDirectContent();
 					cb7.beginText();
 	 				cb7.setFontAndSize(bf, 10);
 	 				cb7.showTextAligned(PdfContentByte.ALIGN_LEFT, s3, 325, 481, 0);
 	 				cb7.endText();
 	 				
 	 				
 	 				cb8 = writer.getDirectContent();
 					cb8.beginText();
 	 				cb8.setFontAndSize(bf, 10);
 	 				cb8.showTextAligned(PdfContentByte.ALIGN_LEFT, s4, 35, 462, 0);
 	 				cb8.endText();
 	 				
 	 				
 	 				cb9 = writer.getDirectContent();
 					cb9.beginText();
 	 				cb9.setFontAndSize(bf, 10);
 	 				cb9.showTextAligned(PdfContentByte.ALIGN_LEFT, s4, 325, 462, 0);
 	 				cb9.endText();
 	 				
 	 				
 	 				
 	 				cb10 = writer.getDirectContent();
 					cb10.beginText();
 	 				cb10.setFontAndSize(bf, 10);
 	 				cb10.showTextAligned(PdfContentByte.ALIGN_LEFT, s5, 35, 450, 0);
 	 				cb10.endText();
 	 				
 	 				
 	 				
 	 				
 	 				
 	 				cb11 = writer.getDirectContent();
 					cb11.beginText();
 	 				cb11.setFontAndSize(bf, 10);
 	 				cb11.showTextAligned(PdfContentByte.ALIGN_LEFT, s5, 325, 450, 0);
 	 				cb11.endText();
 	 				// second sticker
 	 				cb2 = writer.getDirectContent();
 					cb2.beginText();
 	 				cb2.setFontAndSize(bf, 10);
 	 				cb2.showTextAligned(PdfContentByte.ALIGN_LEFT, s, 35, 400, 0);
 	 				cb2.endText();
 	 				
 	 				// second sticker
 	 				cb3 = writer.getDirectContent();
 					cb3.beginText();
 	 				cb3.setFontAndSize(bf, 10);
 	 				cb3.showTextAligned(PdfContentByte.ALIGN_LEFT, s, 325, 400, 0);
 	 				cb3.endText();
 	 				
 	 				//first sticker
 	 				cb4 = writer.getDirectContent();
 					cb4.beginText();
 	 				cb4.setFontAndSize(bf, 10);
 	 				cb4.showTextAligned(PdfContentByte.ALIGN_LEFT, s2, 200,400, 0);
 	 				cb4.endText();
 	 				
 	 				//second sticker
 	 				cb5 = writer.getDirectContent();
 					cb5.beginText();
 	 				cb5.setFontAndSize(bf, 10);
 	 				cb5.showTextAligned(PdfContentByte.ALIGN_LEFT, s2, 500, 400, 0);
 	 				cb5.endText();
 	 				
 	 				
 	 				cb6 = writer.getDirectContent();
 					cb6.beginText();
 	 				cb6.setFontAndSize(bf, 10);
 	 				cb6.showTextAligned(PdfContentByte.ALIGN_LEFT, s3, 35, 381, 0);
 	 				cb6.endText();
 	 				
 	 				cb7 = writer.getDirectContent();
 					cb7.beginText();
 	 				cb7.setFontAndSize(bf, 10);
 	 				cb7.showTextAligned(PdfContentByte.ALIGN_LEFT, s3, 325, 381, 0);
 	 				cb7.endText();
 	 				
 	 				
 	 				cb8 = writer.getDirectContent();
 					cb8.beginText();
 	 				cb8.setFontAndSize(bf, 10);
 	 				cb8.showTextAligned(PdfContentByte.ALIGN_LEFT, s4, 35, 362, 0);
 	 				cb8.endText();
 	 				
 	 				
 	 				cb9 = writer.getDirectContent();
 					cb9.beginText();
 	 				cb9.setFontAndSize(bf, 10);
 	 				cb9.showTextAligned(PdfContentByte.ALIGN_LEFT, s4, 325, 362, 0);
 	 				cb9.endText();
 	 				
 	 				
 	 				
 	 				cb10 = writer.getDirectContent();
 					cb10.beginText();
 	 				cb10.setFontAndSize(bf, 10);
 	 				cb10.showTextAligned(PdfContentByte.ALIGN_LEFT, s5, 35, 350, 0);
 	 				cb10.endText();
 	 				
 	 				
 	 				
 	 				
 	 				
 	 				cb11 = writer.getDirectContent();
 					cb11.beginText();
 	 				cb11.setFontAndSize(bf, 10);
 	 				cb11.showTextAligned(PdfContentByte.ALIGN_LEFT, s5, 325, 350, 0);
 	 				cb11.endText();
 	 				
 	 				
 	 				
 	 				document.add(p);
 	 				document.close();
 	 				writer.close();
 	 				Desktop.getDesktop().open(new File("print1.pdf"));
 	 				
      	        }catch(Exception fe)
      	        {
      	        	fe.printStackTrace();
      	        }
	         
	         	
 				 
	           
	}
		catch(Exception e)
		{}
	}
	
	public void printline3()
	{
		Document document = new Document(PageSize.A4,0,0,0,0);
		try
	      {     
	         PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream("print1.pdf"));
	         document.open();
	         Paragraph p = new Paragraph("",new com.itextpdf.text.Font(com.itextpdf.text.Font.FontFamily.TIMES_ROMAN,11));
	         try{ 	
	        	 
	        	 	conn1 =DriverManager.getConnection("jdbc:sqlite:print.sqlite"); 
 		        	String query="select * from  sticker";
 	 				PreparedStatement pst=conn1.prepareStatement(query);
 	 				ResultSet rs=pst.executeQuery();
 	 				byte[] b2=rs.getBytes("image");
 	 				pst.close();
 	 				rs.close();
 	 				
 	 				com.itextpdf.text.Image image1 = com.itextpdf.text.Image.getInstance(b2);
 	 				com.itextpdf.text.Image jpg=com.itextpdf.text.Image.getInstance(b2);
 	 				jpg.scaleToFit  (700, 850);
 	 				jpg.setAlignment(com.itextpdf.text.Image.UNDERLYING);
 	 				jpg.setAbsolutePosition(0, 0);
 	 				document.add(jpg);
 	 				
 	 				BaseFont bf = BaseFont.createFont(BaseFont.HELVETICA, BaseFont.CP1252, BaseFont.NOT_EMBEDDED);
 	 				Font f = new Font("Kruti Dev 165", Font.PLAIN, 13);
 	 				
 	 				
 	 				
 	 				
 					
 					String s,s1,s2,s3,s4,s5;
 					s = "Name  ".concat(reg_name.getText().toString());
 					s1 = (uhid.getText().toString());
 					s2 = ipd.getText().toString();
 					s2 = "UHID/IPD  ".concat(s1.concat("/").concat(s2));
 					s3 = "Care of  ".concat(reg_fname.getText().toString());
 					s4 = "Operation  ".concat(reason.getText().toString());
 					s5 = "Category  ".concat(categ.getSelectedItem().toString()).concat("      Contact  ").concat(reg_mobile.getText().toString());
 					
 	 				//first sticker
 					cb2 = writer.getDirectContent();
 					cb2.beginText();
 	 				cb2.setFontAndSize(bf, 10);
 	 				cb2.showTextAligned(PdfContentByte.ALIGN_LEFT, s, 35, 600, 0);
 	 				cb2.endText();
 	 				
 	 				// second sticker
 	 				cb3 = writer.getDirectContent();
 					cb3.beginText();
 	 				cb3.setFontAndSize(bf, 10);
 	 				cb3.showTextAligned(PdfContentByte.ALIGN_LEFT, s, 325, 600, 0);
 	 				cb3.endText();
 	 				
 	 				//first sticker
 	 				cb4 = writer.getDirectContent();
 					cb4.beginText();
 	 				cb4.setFontAndSize(bf, 10);
 	 				cb4.showTextAligned(PdfContentByte.ALIGN_LEFT, s2, 200,600, 0);
 	 				cb4.endText();
 	 				
 	 				//second sticker
 	 				cb5 = writer.getDirectContent();
 					cb5.beginText();
 	 				cb5.setFontAndSize(bf, 10);
 	 				cb5.showTextAligned(PdfContentByte.ALIGN_LEFT, s2, 500, 600, 0);
 	 				cb5.endText();
 	 				
 	 				
 	 				cb6 = writer.getDirectContent();
 					cb6.beginText();
 	 				cb6.setFontAndSize(bf, 10);
 	 				cb6.showTextAligned(PdfContentByte.ALIGN_LEFT, s3, 35, 581, 0);
 	 				cb6.endText();
 	 				
 	 				cb7 = writer.getDirectContent();
 					cb7.beginText();
 	 				cb7.setFontAndSize(bf, 10);
 	 				cb7.showTextAligned(PdfContentByte.ALIGN_LEFT, s3, 325, 581, 0);
 	 				cb7.endText();
 	 				
 	 				
 	 				cb8 = writer.getDirectContent();
 					cb8.beginText();
 	 				cb8.setFontAndSize(bf, 10);
 	 				cb8.showTextAligned(PdfContentByte.ALIGN_LEFT, s4, 35, 562, 0);
 	 				cb8.endText();
 	 				
 	 				
 	 				cb9 = writer.getDirectContent();
 					cb9.beginText();
 	 				cb9.setFontAndSize(bf, 10);
 	 				cb9.showTextAligned(PdfContentByte.ALIGN_LEFT, s4, 325, 562, 0);
 	 				cb9.endText();
 	 				
 	 				
 	 				
 	 				cb10 = writer.getDirectContent();
 					cb10.beginText();
 	 				cb10.setFontAndSize(bf, 10);
 	 				cb10.showTextAligned(PdfContentByte.ALIGN_LEFT, s5, 35, 550, 0);
 	 				cb10.endText();
 	 				
 	 				
 	 				
 	 				
 	 				
 	 				cb11 = writer.getDirectContent();
 					cb11.beginText();
 	 				cb11.setFontAndSize(bf, 10);
 	 				cb11.showTextAligned(PdfContentByte.ALIGN_LEFT, s5, 325, 550, 0);
 	 				cb11.endText();
 	 				// second sticker
 	 				
 	 				cb2 = writer.getDirectContent();
 					cb2.beginText();
 	 				cb2.setFontAndSize(bf, 10);
 	 				cb2.showTextAligned(PdfContentByte.ALIGN_LEFT, s, 35, 500, 0);
 	 				cb2.endText();
 	 				
 	 				// second sticker
 	 				cb3 = writer.getDirectContent();
 					cb3.beginText();
 	 				cb3.setFontAndSize(bf, 10);
 	 				cb3.showTextAligned(PdfContentByte.ALIGN_LEFT, s, 325, 500, 0);
 	 				cb3.endText();
 	 				
 	 				//first sticker
 	 				cb4 = writer.getDirectContent();
 					cb4.beginText();
 	 				cb4.setFontAndSize(bf, 10);
 	 				cb4.showTextAligned(PdfContentByte.ALIGN_LEFT, s2, 200,500, 0);
 	 				cb4.endText();
 	 				
 	 				//second sticker
 	 				cb5 = writer.getDirectContent();
 					cb5.beginText();
 	 				cb5.setFontAndSize(bf, 10);
 	 				cb5.showTextAligned(PdfContentByte.ALIGN_LEFT, s2, 500, 500, 0);
 	 				cb5.endText();
 	 				
 	 				
 	 				cb6 = writer.getDirectContent();
 					cb6.beginText();
 	 				cb6.setFontAndSize(bf, 10);
 	 				cb6.showTextAligned(PdfContentByte.ALIGN_LEFT, s3, 35, 481, 0);
 	 				cb6.endText();
 	 				
 	 				cb7 = writer.getDirectContent();
 					cb7.beginText();
 	 				cb7.setFontAndSize(bf, 10);
 	 				cb7.showTextAligned(PdfContentByte.ALIGN_LEFT, s3, 325, 481, 0);
 	 				cb7.endText();
 	 				
 	 				
 	 				cb8 = writer.getDirectContent();
 					cb8.beginText();
 	 				cb8.setFontAndSize(bf, 10);
 	 				cb8.showTextAligned(PdfContentByte.ALIGN_LEFT, s4, 35, 462, 0);
 	 				cb8.endText();
 	 				
 	 				
 	 				cb9 = writer.getDirectContent();
 					cb9.beginText();
 	 				cb9.setFontAndSize(bf, 10);
 	 				cb9.showTextAligned(PdfContentByte.ALIGN_LEFT, s4, 325, 462, 0);
 	 				cb9.endText();
 	 				
 	 				
 	 				
 	 				cb10 = writer.getDirectContent();
 					cb10.beginText();
 	 				cb10.setFontAndSize(bf, 10);
 	 				cb10.showTextAligned(PdfContentByte.ALIGN_LEFT, s5, 35, 450, 0);
 	 				cb10.endText();
 	 				
 	 				
 	 				
 	 				
 	 				
 	 				cb11 = writer.getDirectContent();
 					cb11.beginText();
 	 				cb11.setFontAndSize(bf, 10);
 	 				cb11.showTextAligned(PdfContentByte.ALIGN_LEFT, s5, 325, 450, 0);
 	 				cb11.endText();
 	 				
 	 				
 	 				document.add(p);
 	 				document.close();
 	 				writer.close();
 	 				Desktop.getDesktop().open(new File("print1.pdf"));
 	 				
      	        }
	         	catch(Exception fe)
      	        {
      	        	fe.printStackTrace();
      	        }
	         
	         	
 				 
	           
	}
		catch(Exception e)
		{}
	}
	
	public void printline2()
	{
		Document document = new Document(PageSize.A4,0,0,0,0);
		try
	      {     
	         PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream("print1.pdf"));
	         document.open();
	         Paragraph p = new Paragraph("",new com.itextpdf.text.Font(com.itextpdf.text.Font.FontFamily.TIMES_ROMAN,11));
	         try{ 	
	        	 
	        	 	conn1 =DriverManager.getConnection("jdbc:sqlite:print.sqlite"); 
 		        	String query="select * from  sticker";
 	 				PreparedStatement pst=conn1.prepareStatement(query);
 	 				ResultSet rs=pst.executeQuery();
 	 				byte[] b2=rs.getBytes("image");
 	 				pst.close();
 	 				rs.close();
 	 				
 	 				com.itextpdf.text.Image image1 = com.itextpdf.text.Image.getInstance(b2);
 	 				com.itextpdf.text.Image jpg=com.itextpdf.text.Image.getInstance(b2);
 	 				jpg.scaleToFit  (700, 850);
 	 				jpg.setAlignment(com.itextpdf.text.Image.UNDERLYING);
 	 				jpg.setAbsolutePosition(0, 0);
 	 				document.add(jpg);
 	 				
 	 				BaseFont bf = BaseFont.createFont(BaseFont.HELVETICA, BaseFont.CP1252, BaseFont.NOT_EMBEDDED);
 	 				Font f = new Font("Kruti Dev 165", Font.PLAIN, 13);
 	 				
 	 				
 	 				
 	 				
 					
 					String s,s1,s2,s3,s4,s5;
 					s = "Name  ".concat(reg_name.getText().toString());
 					s1 = (uhid.getText().toString());
 					s2 = ipd.getText().toString();
 					s2 = "UHID/IPD  ".concat(s1.concat("/").concat(s2));
 					s3 = "Care of  ".concat(reg_fname.getText().toString());
 					s4 = "Operation  ".concat(reason.getText().toString());
 					s5 = "Category  ".concat(categ.getSelectedItem().toString()).concat("      Contact  ").concat(reg_mobile.getText().toString());
 					
 	 				//first sticker
 	 				cb2 = writer.getDirectContent();
 					cb2.beginText();
 	 				cb2.setFontAndSize(bf, 10);
 	 				cb2.showTextAligned(PdfContentByte.ALIGN_LEFT, s, 35, 700, 0);
 	 				cb2.endText();
 	 				
 	 				// second sticker
 	 				cb3 = writer.getDirectContent();
 					cb3.beginText();
 	 				cb3.setFontAndSize(bf, 10);
 	 				cb3.showTextAligned(PdfContentByte.ALIGN_LEFT, s, 325, 700, 0);
 	 				cb3.endText();
 	 				
 	 				//first sticker
 	 				cb4 = writer.getDirectContent();
 					cb4.beginText();
 	 				cb4.setFontAndSize(bf, 10);
 	 				cb4.showTextAligned(PdfContentByte.ALIGN_LEFT, s2, 200,700, 0);
 	 				cb4.endText();
 	 				
 	 				//second sticker
 	 				cb5 = writer.getDirectContent();
 					cb5.beginText();
 	 				cb5.setFontAndSize(bf, 10);
 	 				cb5.showTextAligned(PdfContentByte.ALIGN_LEFT, s2, 500, 700, 0);
 	 				cb5.endText();
 	 				
 	 				
 	 				cb6 = writer.getDirectContent();
 					cb6.beginText();
 	 				cb6.setFontAndSize(bf, 10);
 	 				cb6.showTextAligned(PdfContentByte.ALIGN_LEFT, s3, 35, 681, 0);
 	 				cb6.endText();
 	 				
 	 				cb7 = writer.getDirectContent();
 					cb7.beginText();
 	 				cb7.setFontAndSize(bf, 10);
 	 				cb7.showTextAligned(PdfContentByte.ALIGN_LEFT, s3, 325, 681, 0);
 	 				cb7.endText();
 	 				
 	 				
 	 				cb8 = writer.getDirectContent();
 					cb8.beginText();
 	 				cb8.setFontAndSize(bf, 10);
 	 				cb8.showTextAligned(PdfContentByte.ALIGN_LEFT, s4, 35, 662, 0);
 	 				cb8.endText();
 	 				
 	 				
 	 				cb9 = writer.getDirectContent();
 					cb9.beginText();
 	 				cb9.setFontAndSize(bf, 10);
 	 				cb9.showTextAligned(PdfContentByte.ALIGN_LEFT, s4, 325, 662, 0);
 	 				cb9.endText();
 	 				
 	 				
 	 				
 	 				cb10 = writer.getDirectContent();
 					cb10.beginText();
 	 				cb10.setFontAndSize(bf, 10);
 	 				cb10.showTextAligned(PdfContentByte.ALIGN_LEFT, s5, 35, 650, 0);
 	 				cb10.endText();
 	 				
 	 				
 	 				
 	 				
 	 				
 	 				cb11 = writer.getDirectContent();
 					cb11.beginText();
 	 				cb11.setFontAndSize(bf, 10);
 	 				cb11.showTextAligned(PdfContentByte.ALIGN_LEFT, s5, 325, 650, 0);
 	 				cb11.endText();
 	 				
 	 				
 	 				cb2 = writer.getDirectContent();
 					cb2.beginText();
 	 				cb2.setFontAndSize(bf, 10);
 	 				cb2.showTextAligned(PdfContentByte.ALIGN_LEFT, s, 35, 600, 0);
 	 				cb2.endText();
 	 				
 	 				// second sticker
 	 				cb3 = writer.getDirectContent();
 					cb3.beginText();
 	 				cb3.setFontAndSize(bf, 10);
 	 				cb3.showTextAligned(PdfContentByte.ALIGN_LEFT, s, 325, 600, 0);
 	 				cb3.endText();
 	 				
 	 				//first sticker
 	 				cb4 = writer.getDirectContent();
 					cb4.beginText();
 	 				cb4.setFontAndSize(bf, 10);
 	 				cb4.showTextAligned(PdfContentByte.ALIGN_LEFT, s2, 200,600, 0);
 	 				cb4.endText();
 	 				
 	 				//second sticker
 	 				cb5 = writer.getDirectContent();
 					cb5.beginText();
 	 				cb5.setFontAndSize(bf, 10);
 	 				cb5.showTextAligned(PdfContentByte.ALIGN_LEFT, s2, 500, 600, 0);
 	 				cb5.endText();
 	 				
 	 				
 	 				cb6 = writer.getDirectContent();
 					cb6.beginText();
 	 				cb6.setFontAndSize(bf, 10);
 	 				cb6.showTextAligned(PdfContentByte.ALIGN_LEFT, s3, 35, 581, 0);
 	 				cb6.endText();
 	 				
 	 				cb7 = writer.getDirectContent();
 					cb7.beginText();
 	 				cb7.setFontAndSize(bf, 10);
 	 				cb7.showTextAligned(PdfContentByte.ALIGN_LEFT, s3, 325, 581, 0);
 	 				cb7.endText();
 	 				
 	 				
 	 				cb8 = writer.getDirectContent();
 					cb8.beginText();
 	 				cb8.setFontAndSize(bf, 10);
 	 				cb8.showTextAligned(PdfContentByte.ALIGN_LEFT, s4, 35, 562, 0);
 	 				cb8.endText();
 	 				
 	 				
 	 				cb9 = writer.getDirectContent();
 					cb9.beginText();
 	 				cb9.setFontAndSize(bf, 10);
 	 				cb9.showTextAligned(PdfContentByte.ALIGN_LEFT, s4, 325, 562, 0);
 	 				cb9.endText();
 	 				
 	 				
 	 				
 	 				cb10 = writer.getDirectContent();
 					cb10.beginText();
 	 				cb10.setFontAndSize(bf, 10);
 	 				cb10.showTextAligned(PdfContentByte.ALIGN_LEFT, s5, 35, 550, 0);
 	 				cb10.endText();
 	 				
 	 				
 	 				
 	 				
 	 				
 	 				cb11 = writer.getDirectContent();
 					cb11.beginText();
 	 				cb11.setFontAndSize(bf, 10);
 	 				cb11.showTextAligned(PdfContentByte.ALIGN_LEFT, s5, 325, 550, 0);
 	 				cb11.endText();
 	 				
 	 				// second sticker
 	 				
 	 				
 	 				
 	 				
 	 				document.add(p);
 	 				document.close();
 	 				writer.close();
 	 				Desktop.getDesktop().open(new File("print1.pdf"));
 	 				
      	        }catch(Exception fe)
      	        {
      	        	fe.printStackTrace();
      	        }
	         
	         	
 				 
	           
	}
		catch(Exception e)
		{}
	}
	
	public static String[] printbutton3()
	{
		int tablerow1= table.getRowCount();
		JOptionPane.showMessageDialog(null, tablerow1);
		String [] table_1valueslenghth=new String[9*tablerow1];
		JOptionPane.showMessageDialog(null, tablerow1*9);
		for(int i=0;i<tablerow1*9;i++)
		{
			table_1valueslenghth[i]=	(String) table.getValueAt(i/9, 0);
			JOptionPane.showMessageDialog(null, table_1valueslenghth[i]);
			table_1valueslenghth[i+1] =(String)  table.getValueAt(i/9, 1);
			//JOptionPane.showMessageDialog(null, table_1valueslenghth[i+1]);
			table_1valueslenghth[i+2]=	(String) table.getValueAt(i/9, 2);
			//JOptionPane.showMessageDialog(null, table_1valueslenghth[i+2]);
			table_1valueslenghth[i+3]=	(String) table.getValueAt(i/9, 3);
			//JOptionPane.showMessageDialog(null, table_1valueslenghth[i+3]);
			table_1valueslenghth[i+4]=	(String) table.getValueAt(i/9, 4);
			table_1valueslenghth[i+5]=	(String) table.getValueAt(i/9, 5);
			table_1valueslenghth[i+6]=	(String) table.getValueAt(i/9, 6);
			table_1valueslenghth[i+7]=	(String) table.getValueAt(i/9, 7);
			table_1valueslenghth[i+8]=	(String) table.getValueAt(i/9, 8);
			i=i+9;
		}
		return table_1valueslenghth;
	}
	
	
	
	
	
	
	 public void printopd1()
	{
		
		
		
		
		if(categ.getSelectedItem().toString().equals("BSBY"))
		{
			
			
			 BufferedImage img = new BufferedImage(hindi.getWidth(), hindi.getHeight(), BufferedImage.TYPE_INT_RGB);
	         Graphics2D g2d = img.createGraphics();
	         hindi.printAll(g2d);
	         g2d.dispose();

	         try {
	             ImageIO.write(img, "png", new File("chck.png"));
	         } catch (IOException ex) {
	             ex.printStackTrace();
	         }
	         
	         
	        
			
			
			Document document = new Document(PageSize.A4,40,0,0,0);
			try
		      {     
		         PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream("adm.pdf"));
		         document.open();
		       
		         Paragraph p = new Paragraph("",new com.itextpdf.text.Font(com.itextpdf.text.Font.FontFamily.TIMES_ROMAN,9,Font.BOLD));
		         
		         
		       
		         
		         BaseFont bf1 = BaseFont.createFont(BaseFont.HELVETICA, BaseFont.CP1252, BaseFont.NOT_EMBEDDED);
		         f = new Font("Kruti Dev 165", Font.PLAIN, 16);
		         Paragraph pp = new Paragraph("",new com.itextpdf.text.Font(com.itextpdf.text.Font.FontFamily.TIMES_ROMAN,9,Font.BOLD));
		         
		         
		       
		         filename = "chck.png";
		         try{
						
						File image = new File(filename);
						FileInputStream fis = new FileInputStream(image);
						ByteArrayOutputStream bos = new ByteArrayOutputStream();
						byte[] buf = new byte[1024];
						for(int redNum;(redNum = fis.read(buf)) != -1;)
						{
							bos.write(buf,0,redNum);
						}
							CR = bos.toByteArray();	
						
					}
					catch(Exception e)
					{
						e.printStackTrace();
					}
		         
		         String value = "1";
		         try{
		        	 	conn1 =DriverManager.getConnection("jdbc:sqlite:print.sqlite"); 
						String query="update adform set back = ? where sno = '"+value+"' ";
						PreparedStatement pst=conn1.prepareStatement(query);
						pst.setBytes(1, CR);
						pst.execute();
						
						pst.close();
						
					}
					catch(Exception e)
					{
						e.printStackTrace();
					}
		         
		         try{ 	
		        	 
		        	 	conn1 =DriverManager.getConnection("jdbc:sqlite:print.sqlite"); 
	 		        	String query="select * from  adform";
	 	 				PreparedStatement pst=conn1.prepareStatement(query);
	 	 				ResultSet rs=pst.executeQuery();
	 	 				byte[] b2=rs.getBytes("first1");
	 	 				byte[] b3=rs.getBytes("back");
	 	 				pst.close();
	 	 				rs.close();
	 	 				
	 	 				com.itextpdf.text.Image image1 = com.itextpdf.text.Image.getInstance(b2);
	 	 				com.itextpdf.text.Image jpg=com.itextpdf.text.Image.getInstance(b2);
	 	 				jpg.scaleToFit  (700, 850);
	 	 				jpg.setAlignment(com.itextpdf.text.Image.UNDERLYING);
	 	 				jpg.setAbsolutePosition(0, 0);
	 	 				document.add(jpg);
	 	 				
	 	 				PdfContentByte cb2,cb3,cb4,cb5,cb6,cb7,cb8,cb9,cb10,cb11,cb12,cb13,cb14,cb15,cb16,cb17,cb18,cb19,cb20,cb21,cb22,cb23,cb24,cb25,cb26,cb27,cb28,cb29,cb30,cb31,cb32,cb33,cb34,cb35,cb36;
	 	 				BaseFont bf = BaseFont.createFont(BaseFont.TIMES_ROMAN, BaseFont.CP1252, BaseFont.NOT_EMBEDDED);
	 	 				
	 	 				
	 	 				String dooa = addmission_date.getText().toString();
	 	 				String naam = reg_name.getText();
	 	 				String ippd = ipd.getText();
	 	 				String faather = reg_fname.getText();
	 	 				String reefff = rfby.getText();
	 	 				String sexx = 	sex2.getSelectedItem().toString();
	 	 				String cittty = reg_city.getText();
	 	 				String rooom = comboBox.getSelectedItem().toString().concat("/").concat(red.getSelectedItem().toString());
	 	 				String operate = reason.getText();
	 	 				String caatee = categ.getSelectedItem().toString();
	 	 				String higgh = high_detail.getSelectedItem().toString();
	 	 				String uhidd = uhid.getText();
	 	 				String drr = re_drname.getText();
	 	 				String age = reg_age.getText().toString();
	 	 				String status = billing.getSelectedItem().toString();
	 	 				String dignoo = dignose.getText().toString();
	 	 				
	 	 				
	 	 				
	 	 				String s = english.getText().toString();
	 	 				
	 	 				p.add("\n\n\n\n\n\n\n\n\n\n\n\n");
	 	 				

	 					p.add(s);
	 	 				
	 					String s1 = english2.getText().toString();
	 					
	 					p.add("\n\n\n");
	 					p.add(s1);
	 					
	 					
	 					
	 					
	 					
	 					
	 					
	 					
	 					
	 					
	 					
	 	 				
	 	 				cb3 = writer.getDirectContent();
	 					cb3.beginText();
	 	 				cb3.setFontAndSize(bf, 12);
	 	 				cb3.showTextAligned(PdfContentByte.ALIGN_LEFT, dooa, 210, 794, 0);
	 	 				cb3.endText();
	 	 				
	 	 				
	 	 				cb4 = writer.getDirectContent();
	 					cb4.beginText();
	 	 				cb4.setFontAndSize(bf, 12);
	 	 				cb4.showTextAligned(PdfContentByte.ALIGN_LEFT, naam, 80, 765, 0);
	 	 				cb4.endText();
	 	 				
	 	 				cb5 = writer.getDirectContent();
	 					cb5.beginText();
	 	 				cb5.setFontAndSize(bf, 12);
	 	 				cb5.showTextAligned(PdfContentByte.ALIGN_LEFT, faather, 150, 752, 0);
	 	 				cb5.endText();
	 	 				
	 	 				
	 	 				cb6 = writer.getDirectContent();
	 					cb6.beginText();
	 	 				cb6.setFontAndSize(bf, 12);
	 	 				cb6.showTextAligned(PdfContentByte.ALIGN_LEFT, ippd, 390, 780, 0);
	 	 				cb6.endText();
	 	 				
	 	 				
	 	 				cb14 = writer.getDirectContent();
	 					cb14.beginText();
	 	 				cb14.setFontAndSize(bf, 12);
	 	 				cb14.showTextAligned(PdfContentByte.ALIGN_LEFT, uhidd, 520, 780, 0);
	 	 				cb14.endText();
	 	 				
	 	 				cb7 = writer.getDirectContent();
	 					cb7.beginText();
	 	 				cb7.setFontAndSize(bf, 12);
	 	 				cb7.showTextAligned(PdfContentByte.ALIGN_LEFT, sexx+"  AGE:-"+age, 420, 752, 0);
	 	 				cb7.endText();
	 	 				
	 	 				
	 	 				cb8 = writer.getDirectContent();
	 					cb8.beginText();
	 	 				cb8.setFontAndSize(bf, 12);
	 	 				cb8.showTextAligned(PdfContentByte.ALIGN_LEFT, reefff, 80, 736, 0);
	 	 				cb8.endText();
	 	 				
	 	 				
	 	 				
	 	 				cb8 = writer.getDirectContent();
	 					cb8.beginText();
	 	 				cb8.setFontAndSize(bf, 12);
	 	 				cb8.showTextAligned(PdfContentByte.ALIGN_LEFT, dignoo, 330, 736, 0);
	 	 				cb8.endText();
	 	 				
	 	 				
	 	 				
	 	 				
	 	 				
	 	 				
	 	 				cb9 = writer.getDirectContent();
	 					cb9.beginText();
	 	 				cb9.setFontAndSize(bf, 12);
	 	 				cb9.showTextAligned(PdfContentByte.ALIGN_LEFT, cittty, 80, 721, 0);
	 	 				cb9.endText();
	 	 				
	 	 				
	 	 				
	 	 				cb10 = writer.getDirectContent();
	 					cb10.beginText();
	 	 				cb10.setFontAndSize(bf, 12);
	 	 				cb10.showTextAligned(PdfContentByte.ALIGN_LEFT, operate, 120, 706, 0);
	 	 				cb10.endText();
	 	 				
	 	 				
	 	 				cb10 = writer.getDirectContent();
	 					cb10.beginText();
	 	 				cb10.setFontAndSize(bf, 12);
	 	 				cb10.showTextAligned(PdfContentByte.ALIGN_LEFT, drr, 120, 692, 0);
	 	 				cb10.endText();
	 	 				
	 	 				
	 	 				cb10 = writer.getDirectContent();
	 					cb10.beginText();
	 	 				cb10.setFontAndSize(bf, 12);
	 	 				cb10.showTextAligned(PdfContentByte.ALIGN_LEFT, higgh, 370, 692, 0);
	 	 				cb10.endText();
	 	 				
	 	 				
	 	 				cb11 = writer.getDirectContent();
	 					cb11.beginText();
	 	 				cb11.setFontAndSize(bf, 12);
	 	 				cb11.showTextAligned(PdfContentByte.ALIGN_LEFT, rooom, 400, 721, 0);
	 	 				cb11.endText();
	 	 				
	 	 				
	 	 				cb12 = writer.getDirectContent();
	 					cb12.beginText();
	 	 				cb12.setFontAndSize(bf, 12);
	 	 				cb12.showTextAligned(PdfContentByte.ALIGN_LEFT, caatee, 348, 706, 0);
	 	 				cb12.endText();
	 	 				
	 	 				
	 	 				
	 	 				cb12 = writer.getDirectContent();
	 					cb12.beginText();
	 	 				cb12.setFontAndSize(bf, 12);
	 	 				cb12.showTextAligned(PdfContentByte.ALIGN_LEFT, status, 520, 706, 0);
	 	 				cb12.endText();
	 	 				
	 	 				
	 	 				
	 	 				
	 	 				
	 	 				
	 	 			
	 	 				
	 	 				document.setMargins(155, 155, 260, 260);
	 	 	            document.add(p);
	 	 				document.close();
	 	 				writer.close();
	 	 				Desktop.getDesktop().open(new File("adm.pdf"));
	 	 				
	      	        }catch(Exception fe)
	      	        {
	      	        	fe.printStackTrace();
	      	        }
		         
		         	
	 				 
		           
		}
			catch(Exception e)
			{}
			
			
	/*		Document document1 = new Document(PageSize.A4,40,0,0,0);
			try
		      {     
		         PdfWriter writer = PdfWriter.getInstance(document1, new FileOutputStream("print2.pdf"));
		         document1.open();
		         Paragraph p = new Paragraph("",new com.itextpdf.text.Font(com.itextpdf.text.Font.FontFamily.TIMES_ROMAN,9,Font.BOLD));
		         
		         
		       
		         
		        
		         
		       
		        
		         
		         try{ 	
		        	 
		        	 	conn1 =DriverManager.getConnection("jdbc:sqlite:print.sqlite"); 
	 		        	String query="select * from  adform";
	 	 				PreparedStatement pst=conn1.prepareStatement(query);
	 	 				ResultSet rs=pst.executeQuery();
	 	 				byte[] b2=rs.getBytes("back");
	 	 			
	 	 				pst.close();
	 	 				rs.close();
	 	 				
	 	 				com.itextpdf.text.Image image1 = com.itextpdf.text.Image.getInstance(b2);
	 	 				com.itextpdf.text.Image jpg=com.itextpdf.text.Image.getInstance(b2);
	 	 				jpg.scaleToFit  (500, 550);
	 	 				jpg.setAlignment(com.itextpdf.text.Image.UNDERLYING);
	 	 				jpg.setAbsolutePosition(30, 300);
	 	 				document1.add(jpg);
	 	 				
	 	 				
	 	 				
	 	 				
	 	 				
	 	 				
	 	 				
	 	 				document1.add(p);
	 	 				document1.close();
	 	 				writer.close();
	 	 				Desktop.getDesktop().open(new File("print2.pdf"));
	 	 				
	      	        }catch(Exception fe)
	      	        {
	      	        	JOptionPane.showMessageDialog(null, fe);
	      	        }
		         
		         	
	 				 
		           
		}
			catch(Exception e)
			{}*/
			
			
			
		}	
		
		
		else
		{
			 BufferedImage img = new BufferedImage(hindi.getWidth(), hindi.getHeight(), BufferedImage.TYPE_INT_RGB);
	         Graphics2D g2d = img.createGraphics();
	         hindi.printAll(g2d);
	         g2d.dispose();

	         try {
	             ImageIO.write(img, "png", new File("chck.png"));
	         } catch (IOException ex) {
	             ex.printStackTrace();
	         }
	         
	         
	        
			
			
			Document document = new Document(PageSize.A4,40,0,0,0);
			try
		      {     
		         PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream("adm.pdf"));
		         document.open();
		       
		         Paragraph p = new Paragraph("",new com.itextpdf.text.Font(com.itextpdf.text.Font.FontFamily.TIMES_ROMAN,9,Font.BOLD));
		         
		         
		       
		         
		         BaseFont bf1 = BaseFont.createFont(BaseFont.HELVETICA, BaseFont.CP1252, BaseFont.NOT_EMBEDDED);
		         f = new Font("Kruti Dev 165", Font.PLAIN, 16);
		         Paragraph pp = new Paragraph("",new com.itextpdf.text.Font(com.itextpdf.text.Font.FontFamily.TIMES_ROMAN,9,Font.BOLD));
		         
		         
		       
		         filename = "chck.png";
		         try{
						
						File image = new File(filename);
						FileInputStream fis = new FileInputStream(image);
						ByteArrayOutputStream bos = new ByteArrayOutputStream();
						byte[] buf = new byte[1024];
						for(int redNum;(redNum = fis.read(buf)) != -1;)
						{
							bos.write(buf,0,redNum);
						}
							CR = bos.toByteArray();	
						
					}
					catch(Exception e)
					{
						e.printStackTrace();
					}
		         
		         String value = "1";
		         try{
		        	 	conn1 =DriverManager.getConnection("jdbc:sqlite:print.sqlite"); 
						String query="update adform set back = ? where sno = '"+value+"' ";
						PreparedStatement pst=conn1.prepareStatement(query);
						pst.setBytes(1, CR);
						pst.execute();
						
						pst.close();
						
					}
					catch(Exception e)
					{
						e.printStackTrace();
					}
		         
		         try{ 	
		        	 
		        	 	conn1 =DriverManager.getConnection("jdbc:sqlite:print.sqlite"); 
	 		        	String query="select * from  adform";
	 	 				PreparedStatement pst=conn1.prepareStatement(query);
	 	 				ResultSet rs=pst.executeQuery();
	 	 				byte[] b2=rs.getBytes("first");
	 	 				//byte[] b3=rs.getBytes("back");
	 	 				pst.close();
	 	 				rs.close();
	 	 				
	 	 				com.itextpdf.text.Image image1 = com.itextpdf.text.Image.getInstance(b2);
	 	 				com.itextpdf.text.Image jpg=com.itextpdf.text.Image.getInstance(b2);
	 	 				jpg.scaleToFit  (700, 850);
	 	 				jpg.setAlignment(com.itextpdf.text.Image.UNDERLYING);
	 	 				jpg.setAbsolutePosition(0, 0);
	 	 				document.add(jpg);
	 	 				
	 	 				PdfContentByte cb2,cb3,cb4,cb5,cb6,cb7,cb8,cb9,cb10,cb11,cb12,cb13,cb14,cb15,cb16,cb17,cb18,cb19,cb20,cb21,cb22,cb23,cb24,cb25,cb26,cb27,cb28,cb29,cb30,cb31,cb32,cb33,cb34,cb35,cb36;
	 	 				BaseFont bf = BaseFont.createFont(BaseFont.TIMES_ROMAN, BaseFont.CP1252, BaseFont.NOT_EMBEDDED);
	 	 				
	 	 				
	 	 				String dooa = addmission_date.getText().toString();
	 	 				String naam = reg_name.getText();
	 	 				String ippd = ipd.getText();
	 	 				String faather = reg_fname.getText();
	 	 				String reefff = rfby.getText();
	 	 				String sexx = 	sex2.getSelectedItem().toString();
	 	 				String cittty = reg_city.getText();
	 	 				String rooom = comboBox.getSelectedItem().toString().concat("/").concat(red.getSelectedItem().toString());
	 	 				String operate = reason.getText();
	 	 				String caatee = categ.getSelectedItem().toString();
	 	 				String higgh = high_detail.getSelectedItem().toString();
	 	 				String uhidd = uhid.getText();
	 	 				String drr = re_drname.getText();
	 	 				String age = reg_age.getText().toString();
	 	 				String status = billing.getSelectedItem().toString();
	 	 				String dignoo = dignose.getText().toString();
	 	 				
	 	 				
	 	 				
	 	 				String s = english.getText().toString();
	 	 				
	 	 				p.add("\n\n\n\n\n\n\n\n\n\n\n\n");
	 	 				

	 					p.add(s);
	 	 				
	 					String s1 = english2.getText().toString();
	 					
	 					p.add("\n\n\n");
	 					p.add(s1);
	 					
	 					
	 					
	 					
	 					
	 					
	 					
	 					
	 					
	 					
	 					
	 	 				
	 	 				cb3 = writer.getDirectContent();
	 					cb3.beginText();
	 	 				cb3.setFontAndSize(bf, 12);
	 	 				cb3.showTextAligned(PdfContentByte.ALIGN_LEFT, dooa, 210, 794, 0);
	 	 				cb3.endText();
	 	 				
	 	 				
	 	 				cb4 = writer.getDirectContent();
	 					cb4.beginText();
	 	 				cb4.setFontAndSize(bf, 12);
	 	 				cb4.showTextAligned(PdfContentByte.ALIGN_LEFT, naam, 80, 765, 0);
	 	 				cb4.endText();
	 	 				
	 	 				cb5 = writer.getDirectContent();
	 					cb5.beginText();
	 	 				cb5.setFontAndSize(bf, 12);
	 	 				cb5.showTextAligned(PdfContentByte.ALIGN_LEFT, faather, 150, 752, 0);
	 	 				cb5.endText();
	 	 				
	 	 				
	 	 				cb6 = writer.getDirectContent();
	 					cb6.beginText();
	 	 				cb6.setFontAndSize(bf, 12);
	 	 				cb6.showTextAligned(PdfContentByte.ALIGN_LEFT, ippd, 390, 780, 0);
	 	 				cb6.endText();
	 	 				
	 	 				
	 	 				cb14 = writer.getDirectContent();
	 					cb14.beginText();
	 	 				cb14.setFontAndSize(bf, 12);
	 	 				cb14.showTextAligned(PdfContentByte.ALIGN_LEFT, uhidd, 520, 780, 0);
	 	 				cb14.endText();
	 	 				
	 	 				cb7 = writer.getDirectContent();
	 					cb7.beginText();
	 	 				cb7.setFontAndSize(bf, 12);
	 	 				cb7.showTextAligned(PdfContentByte.ALIGN_LEFT, sexx+"  AGE:-"+age, 420, 752, 0);
	 	 				cb7.endText();
	 	 				
	 	 				
	 	 				cb8 = writer.getDirectContent();
	 					cb8.beginText();
	 	 				cb8.setFontAndSize(bf, 12);
	 	 				cb8.showTextAligned(PdfContentByte.ALIGN_LEFT, reefff, 80, 736, 0);
	 	 				cb8.endText();
	 	 				
	 	 				
	 	 				
	 	 				cb8 = writer.getDirectContent();
	 					cb8.beginText();
	 	 				cb8.setFontAndSize(bf, 12);
	 	 				cb8.showTextAligned(PdfContentByte.ALIGN_LEFT, dignoo, 330, 736, 0);
	 	 				cb8.endText();
	 	 				
	 	 				
	 	 				
	 	 				
	 	 				
	 	 				
	 	 				cb9 = writer.getDirectContent();
	 					cb9.beginText();
	 	 				cb9.setFontAndSize(bf, 12);
	 	 				cb9.showTextAligned(PdfContentByte.ALIGN_LEFT, cittty, 80, 721, 0);
	 	 				cb9.endText();
	 	 				
	 	 				
	 	 				
	 	 				cb10 = writer.getDirectContent();
	 					cb10.beginText();
	 	 				cb10.setFontAndSize(bf, 12);
	 	 				cb10.showTextAligned(PdfContentByte.ALIGN_LEFT, operate, 120, 706, 0);
	 	 				cb10.endText();
	 	 				
	 	 				
	 	 				cb10 = writer.getDirectContent();
	 					cb10.beginText();
	 	 				cb10.setFontAndSize(bf, 12);
	 	 				cb10.showTextAligned(PdfContentByte.ALIGN_LEFT, drr, 120, 692, 0);
	 	 				cb10.endText();
	 	 				
	 	 				
	 	 				cb10 = writer.getDirectContent();
	 					cb10.beginText();
	 	 				cb10.setFontAndSize(bf, 12);
	 	 				cb10.showTextAligned(PdfContentByte.ALIGN_LEFT, higgh, 370, 692, 0);
	 	 				cb10.endText();
	 	 				
	 	 				
	 	 				cb11 = writer.getDirectContent();
	 					cb11.beginText();
	 	 				cb11.setFontAndSize(bf, 12);
	 	 				cb11.showTextAligned(PdfContentByte.ALIGN_LEFT, rooom, 400, 721, 0);
	 	 				cb11.endText();
	 	 				
	 	 				
	 	 				cb12 = writer.getDirectContent();
	 					cb12.beginText();
	 	 				cb12.setFontAndSize(bf, 12);
	 	 				cb12.showTextAligned(PdfContentByte.ALIGN_LEFT, caatee, 344, 706, 0);
	 	 				cb12.endText();
	 	 				
	 	 				
	 	 				
	 	 				cb12 = writer.getDirectContent();
	 					cb12.beginText();
	 	 				cb12.setFontAndSize(bf, 12);
	 	 				cb12.showTextAligned(PdfContentByte.ALIGN_LEFT, status, 520, 706, 0);
	 	 				cb12.endText();
	
	 	 				
	 	 				
	 	 				
	 	 				
	 	 			
	 	 				
	 	 				document.setMargins(155, 155, 260, 260);
	 	 	            document.add(p);
	 	 				document.close();
	 	 				writer.close();
	 	 				Desktop.getDesktop().open(new File("adm.pdf"));
	 	 				
	      	        }catch(Exception fe)
	      	        {
	      	        	fe.printStackTrace();
	      	        }
		         
		         	
	 				 
		           
		}
			catch(Exception e)
			{}
			
			
			/*Document document1 = new Document(PageSize.A4,0,0,0,0);
			try
		      {     
		         PdfWriter writer = PdfWriter.getInstance(document1, new FileOutputStream("print2.pdf"));
		         document1.open();
		         Paragraph p = new Paragraph("",new com.itextpdf.text.Font(com.itextpdf.text.Font.FontFamily.TIMES_ROMAN,9,Font.BOLD));
		         
		         
		       
		         
		        
		         
		       
		        
		         
		         try{ 	
		        	 
		        	 	conn1 =DriverManager.getConnection("jdbc:sqlite:print.sqlite"); 
	 		        	String query="select * from  adform";
	 	 				PreparedStatement pst=conn1.prepareStatement(query);
	 	 				ResultSet rs=pst.executeQuery();
	 	 				byte[] b2=rs.getBytes("back");
	 	 			
	 	 				pst.close();
	 	 				rs.close();
	 	 				
	 	 				com.itextpdf.text.Image image1 = com.itextpdf.text.Image.getInstance(b2);
	 	 				com.itextpdf.text.Image jpg=com.itextpdf.text.Image.getInstance(b2);
	 	 				jpg.scaleToFit  (500, 550);
	 	 				jpg.setAlignment(com.itextpdf.text.Image.UNDERLYING);
	 	 				jpg.setAbsolutePosition(0, 300);
	 	 				document1.add(jpg);
	 	 				
	 	 				
	 	 				
	 	 				
	 	 				
	 	 				
	 	 				
	 	 				document1.add(p);
	 	 				document1.close();
	 	 				writer.close();
	 	 				Desktop.getDesktop().open(new File("print2.pdf"));
	 	 				
	      	        }catch(Exception fe)
	      	        {
	      	        	JOptionPane.showMessageDialog(null, fe);
	      	        }
		         
		         	
	 				 
		           
		}
			catch(Exception e)
			{}*/
			
			
		}	
	
	}
}

