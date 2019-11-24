import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.print.DocFlavor;
import javax.print.DocPrintJob;
import javax.print.PrintException;
import javax.print.PrintService;
import javax.print.PrintServiceLookup;
import javax.print.SimpleDoc;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.itextpdf.text.Document;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfWriter;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.io.File;
import java.io.FileOutputStream;
import java.math.BigDecimal;
import java.net.MalformedURLException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.awt.Color;
import java.awt.Desktop;

import javax.swing.JTextField;
import javax.swing.UIManager;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Billing extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField rr1;
	private JTextField rr2;
	private JTextField rr3;
	private JTextField rr4;
	private JTextField rr5;
	private JTextField rr6;
	private JTextField rr7;
	private JTextField rr8;
	private JTextField rr9;
	private JTextField cc1;
	private JTextField cc2;
	private JTextField cc3;
	private JTextField cc4;
	private JTextField cc5;
	private JTextField cc6;
	private JTextField cc7;
	private JTextField cc8;
	private JTextField cc9;
	private JTextField rr10;
	private JTextField cc10;
	private JTextField rr11;
	private JTextField cc11;
	private JTextField rr12;
	private JTextField cc12;
	private JTextField other1;
	private JTextField other2;
	private JTextField other3;

	JLabel labelname;
	DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd-MM-yyyy");
	Double a1,a2,a3,a4,a5,a6,a7,a8,a9,a10,a11,a12,total;
	int tot;
	String r1,r2,r3,r4,r5,r6,r7,r8,r9,r10,r11,r12;
	String c1,c2,c3,c4,c5,c6,c7,c8,c9,c10,c11,c12;
	String inword;
	String o11,o12,o13;
	/**
	 * Launch the application.
	 */
	
	static String bill,doa,dod,cd,room,ac,name,age,sex,ope,add,con,uhii;
	
	String bil;
	private JTextField textField;
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
	 
	public static void main(String[] args) {
		
		
		
   		
   		
   		bill = args[0];
   		doa =args[1];
   		dod = args[2];
   		cd = args[3];
   		room = args[4];
   		ac = args[5];
   		name = args[6];
   		age = args[7];
   		sex = args[8];
   		ope = args[9];
   		add = args[10];
   		con = args[11];
   		uhii = args[12];
		try {
			 try { UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");} 
			 catch (Exception e) { }	
			Billing dialog = new Billing();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public Billing() {
		setBounds(100, 1, 939, 739);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(Color.WHITE);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		
		//labelname.setText(name);
		JLabel lblRoomCharge = new JLabel("Room Charges");
		lblRoomCharge.setForeground(new Color(60, 179, 113));
		lblRoomCharge.setFont(new Font("SansSerif", Font.BOLD, 24));
		lblRoomCharge.setBounds(10, 64, 188, 38);
		contentPanel.add(lblRoomCharge);
		
		JLabel lblNursingCharge = new JLabel("Nursing Charges");
		lblNursingCharge.setForeground(new Color(60, 179, 113));
		lblNursingCharge.setFont(new Font("SansSerif", Font.BOLD, 24));
		lblNursingCharge.setBounds(10, 123, 209, 38);
		contentPanel.add(lblNursingCharge);
		
		JLabel lblOtCharge = new JLabel("OT Charges");
		lblOtCharge.setForeground(new Color(60, 179, 113));
		lblOtCharge.setFont(new Font("SansSerif", Font.BOLD, 24));
		lblOtCharge.setBounds(10, 182, 197, 38);
		contentPanel.add(lblOtCharge);
		
		JLabel lblOperationFees = new JLabel("Oxygen/gas/mon");
		lblOperationFees.setForeground(new Color(60, 179, 113));
		lblOperationFees.setFont(new Font("SansSerif", Font.BOLD, 24));
		lblOperationFees.setBounds(10, 236, 236, 38);
		contentPanel.add(lblOperationFees);
		
		JLabel lblVistingCharge = new JLabel("Operation");
		lblVistingCharge.setForeground(new Color(60, 179, 113));
		lblVistingCharge.setFont(new Font("SansSerif", Font.BOLD, 24));
		lblVistingCharge.setBounds(10, 292, 188, 38);
		contentPanel.add(lblVistingCharge);
		
		JLabel lblAnth = new JLabel("Visiting");
		lblAnth.setForeground(new Color(60, 179, 113));
		lblAnth.setFont(new Font("SansSerif", Font.BOLD, 24));
		lblAnth.setBounds(10, 344, 176, 38);
		contentPanel.add(lblAnth);
		
		JLabel lblOx = new JLabel("Anaesthetist");
		lblOx.setForeground(new Color(60, 179, 113));
		lblOx.setFont(new Font("SansSerif", Font.BOLD, 22));
		lblOx.setBounds(10, 401, 236, 43);
		contentPanel.add(lblOx);
		
		JLabel lblLabCharge = new JLabel("Lab Charges");
		lblLabCharge.setForeground(new Color(60, 179, 113));
		lblLabCharge.setFont(new Font("SansSerif", Font.BOLD, 24));
		lblLabCharge.setBounds(10, 455, 176, 39);
		contentPanel.add(lblLabCharge);
		
		JLabel lblMedicalCharge = new JLabel("Medical Charges");
		lblMedicalCharge.setForeground(new Color(60, 179, 113));
		lblMedicalCharge.setFont(new Font("SansSerif", Font.BOLD, 24));
		lblMedicalCharge.setBounds(10, 505, 209, 38);
		contentPanel.add(lblMedicalCharge);
		
		rr1 = new JTextField();
		rr1.setFont(new Font("Tahoma", Font.BOLD, 18));
		rr1.setText("---");
		rr1.setBounds(354, 53, 176, 38);
		contentPanel.add(rr1);
		rr1.setColumns(10);
		
		rr2 = new JTextField();
		rr2.setFont(new Font("Tahoma", Font.BOLD, 18));
		rr2.setText("---");
		rr2.setColumns(10);
		rr2.setBounds(354, 112, 176, 38);
		contentPanel.add(rr2);
		
		rr3 = new JTextField();
		rr3.setFont(new Font("Tahoma", Font.BOLD, 18));
		rr3.setText("---");
		rr3.setColumns(10);
		rr3.setBounds(354, 176, 176, 33);
		contentPanel.add(rr3);
		
		rr4 = new JTextField();
		rr4.setFont(new Font("Tahoma", Font.BOLD, 18));
		rr4.setText("---");
		rr4.setColumns(10);
		rr4.setBounds(354, 239, 176, 38);
		contentPanel.add(rr4);
		
		rr5 = new JTextField();
		rr5.setFont(new Font("Tahoma", Font.BOLD, 18));
		rr5.setText("---");
		rr5.setColumns(10);
		rr5.setBounds(354, 295, 176, 33);
		contentPanel.add(rr5);
		
		rr6 = new JTextField();
		rr6.setFont(new Font("Tahoma", Font.BOLD, 18));
		rr6.setText("---");
		rr6.setColumns(10);
		rr6.setBounds(354, 347, 176, 33);
		contentPanel.add(rr6);
		
		rr7 = new JTextField();
		rr7.setFont(new Font("Tahoma", Font.BOLD, 18));
		rr7.setText("---");
		rr7.setColumns(10);
		rr7.setBounds(354, 400, 176, 33);
		contentPanel.add(rr7);
		
		rr8 = new JTextField();
		rr8.setFont(new Font("Tahoma", Font.BOLD, 18));
		rr8.setText("---");
		rr8.setColumns(10);
		rr8.setBounds(354, 450, 176, 33);
		contentPanel.add(rr8);
		
		rr9 = new JTextField();
		rr9.setFont(new Font("Tahoma", Font.BOLD, 18));
		rr9.setText("---");
		rr9.setColumns(10);
		rr9.setBounds(354, 498, 176, 34);
		contentPanel.add(rr9);
		
		cc1 = new JTextField();
		cc1.setFont(new Font("Tahoma", Font.BOLD, 18));
		cc1.setColumns(10);
		cc1.setBounds(602, 48, 143, 38);
		contentPanel.add(cc1);
		
		cc2 = new JTextField();
		cc2.setFont(new Font("Tahoma", Font.BOLD, 18));
		cc2.setColumns(10);
		cc2.setBounds(602, 107, 143, 38);
		contentPanel.add(cc2);
		
		cc3 = new JTextField();
		cc3.setFont(new Font("Tahoma", Font.BOLD, 18));
		cc3.setColumns(10);
		cc3.setBounds(602, 171, 143, 33);
		contentPanel.add(cc3);
		
		cc4 = new JTextField();
		cc4.setFont(new Font("Tahoma", Font.BOLD, 18));
		cc4.setColumns(10);
		cc4.setBounds(602, 235, 143, 33);
		contentPanel.add(cc4);
		
		cc5 = new JTextField();
		cc5.setFont(new Font("Tahoma", Font.BOLD, 18));
		cc5.setColumns(10);
		cc5.setBounds(602, 288, 143, 38);
		contentPanel.add(cc5);
		
		cc6 = new JTextField();
		cc6.setFont(new Font("Tahoma", Font.BOLD, 18));
		cc6.setColumns(10);
		cc6.setBounds(602, 344, 143, 31);
		contentPanel.add(cc6);
		
		cc7 = new JTextField();
		cc7.setFont(new Font("Tahoma", Font.BOLD, 18));
		cc7.setColumns(10);
		cc7.setBounds(602, 390, 143, 33);
		contentPanel.add(cc7);
		
		cc8 = new JTextField();
		cc8.setFont(new Font("Tahoma", Font.BOLD, 18));
		cc8.setColumns(10);
		cc8.setBounds(602, 442, 143, 33);
		contentPanel.add(cc8);
		
		cc9 = new JTextField();
		cc9.setFont(new Font("Tahoma", Font.BOLD, 18));
		cc9.setColumns(10);
		cc9.setBounds(602, 491, 143, 36);
		contentPanel.add(cc9);
		
		rr10 = new JTextField();
		rr10.setFont(new Font("Tahoma", Font.BOLD, 18));
		rr10.setText("---");
		rr10.setColumns(10);
		rr10.setBounds(354, 552, 176, 33);
		contentPanel.add(rr10);
		
		cc10 = new JTextField();
		cc10.setFont(new Font("Tahoma", Font.BOLD, 18));
		cc10.setColumns(10);
		cc10.setBounds(602, 547, 143, 33);
		contentPanel.add(cc10);
		
		rr11 = new JTextField();
		rr11.setFont(new Font("Tahoma", Font.BOLD, 18));
		rr11.setText("---");
		rr11.setColumns(10);
		rr11.setBounds(354, 606, 176, 33);
		contentPanel.add(rr11);
		
		cc11 = new JTextField();
		cc11.setFont(new Font("Tahoma", Font.BOLD, 18));
		cc11.setColumns(10);
		cc11.setBounds(602, 601, 143, 28);
		contentPanel.add(cc11);
		
		rr12 = new JTextField();
		rr12.setFont(new Font("Tahoma", Font.BOLD, 18));
		rr12.setText("---");
		rr12.setColumns(10);
		rr12.setBounds(354, 660, 176, 35);
		contentPanel.add(rr12);
		
		cc12 = new JTextField();
		cc12.setFont(new Font("Tahoma", Font.BOLD, 18));
		cc12.setColumns(10);
		cc12.setBounds(602, 653, 143, 37);
		contentPanel.add(cc12);
		
		other1 = new JTextField();
		other1.setText("Other1");
		other1.setColumns(10);
		other1.setBounds(10, 554, 161, 38);
		contentPanel.add(other1);
		
		other2 = new JTextField();
		other2.setText("Other2");
		other2.setColumns(10);
		other2.setBounds(10, 607, 161, 30);
		contentPanel.add(other2);
		
		other3 = new JTextField();
		other3.setText("other3");
		other3.setColumns(10);
		other3.setBounds(10, 655, 161, 33);
		contentPanel.add(other3);
		
		JButton btnNewButton = new JButton("Print Bill");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				printopd();
			}
		});
		btnNewButton.setBounds(758, 653, 109, 33);
		contentPanel.add(btnNewButton);
		
		JLabel lblServices = new JLabel("Services");
		lblServices.setForeground(new Color(60, 179, 113));
		lblServices.setFont(new Font("SansSerif", Font.BOLD, 24));
		lblServices.setBounds(10, 11, 161, 38);
		contentPanel.add(lblServices);
		
		JLabel lblRemark = new JLabel("Remark");
		lblRemark.setForeground(new Color(60, 179, 113));
		lblRemark.setFont(new Font("SansSerif", Font.BOLD, 24));
		lblRemark.setBounds(354, 0, 161, 38);
		contentPanel.add(lblRemark);
		
		JLabel lblCharges = new JLabel("Charges");
		lblCharges.setForeground(new Color(60, 179, 113));
		lblCharges.setFont(new Font("SansSerif", Font.BOLD, 24));
		lblCharges.setBounds(602, -5, 161, 38);
		contentPanel.add(lblCharges);
		
		labelname = new JLabel("");
		labelname.setText(name);
		labelname.setForeground(new Color(60, 179, 113));
		labelname.setFont(new Font("SansSerif", Font.BOLD, 24));
		labelname.setBounds(715, 11, 218, 38);
		contentPanel.add(labelname);
		
		JLabel lblBillNo = new JLabel("Bill No.");
		lblBillNo.setForeground(new Color(60, 179, 113));
		lblBillNo.setFont(new Font("SansSerif", Font.BOLD, 24));
		lblBillNo.setBounds(772, 96, 161, 38);
		contentPanel.add(lblBillNo);
		
		textField = new JTextField();
		textField.setText(bill);
		textField.setFont(new Font("Tahoma", Font.BOLD, 18));
		textField.setColumns(10);
		textField.setBounds(772, 133, 143, 33);
		contentPanel.add(textField);
	}
	
	public void printopd()
	{
		String check = "jnipd";
		
		
		
		
		
		c1 = cc1.getText();
		c2 = cc2.getText();
		c3 = cc3.getText();
		
		c4 = cc4.getText();
		c5 = cc5.getText();
		c6 = cc6.getText();
		c7 = cc7.getText();
		c8 = cc8.getText();
		c9 = cc9.getText();
		c10 = cc10.getText();
		c11 = cc11.getText();
		c12 = cc12.getText();
		
		r1 = rr1.getText();
		r2 = rr2.getText();
		r3 = rr3.getText();
		r4 = rr4.getText();
		r5 = rr5.getText();
		r6 = rr6.getText();
		r7 = rr7.getText();
		
		r8 = rr8.getText();
		r9 = rr9.getText();
		
		r10 = rr10.getText();
		r11 = rr11.getText();
		r12 = rr12.getText();
		
		o11 = other1.getText();
		o12 = other2.getText();
		o13 = other3.getText();
		
		
		
		a1=0.0;
		a2=0.0;
		a3=0.0;
		a4=0.0;
		a5=0.0;
		a6=0.0;
		a7=0.0;
		a8=0.0;
		a9=0.0;
		a10=0.0;
		a11=0.0;
		a12=0.0;
		
		a1 = Double.parseDouble(cc1.getText());
		a2 = Double.parseDouble(cc2.getText());
		a3 = Double.parseDouble(cc3.getText());
		a4 = Double.parseDouble(cc4.getText());
		a5 = Double.parseDouble(cc5.getText());
		a6 = Double.parseDouble(cc6.getText());
		a7 = Double.parseDouble(cc7.getText());
		a8 = Double.parseDouble(cc8.getText());
		a9 = Double.parseDouble(cc9.getText());
		a10 = Double.parseDouble(cc10.getText());
		a11 = Double.parseDouble(cc11.getText());
		a12 = Double.parseDouble(cc12.getText());
		
		
		
		
		tot = (int) (a1+a2+a3+a4+a5+a6+a7+a8+a9+a10+a11+a12);
		tot = Math.round(tot);
		
		
		
		
		
		
		
			String date;
			LocalDateTime now = LocalDateTime.now();
			date = dtf.format(now);
			
			
			String pdf = name+dod;
			
			
			for(int j=0; j < pdf.length(); j++) {
				 
				 pdf = pdf.replace(" ", "");
			
				 
				}
			
			
			for(int j=0; j < pdf.length(); j++) {
				 
				 pdf = pdf.replace(".", "");
			
				 
				}
			String sss = "D:\\Temp\\";
				pdf = sss.concat(pdf+".pdf");
  				pdf = pdf+".pdf";
				
		Document document = new Document(PageSize.A4,0,0,0,0);
		try
	      {     
	         PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream(pdf));
	         document.open();
	         Paragraph p = new Paragraph("",new com.itextpdf.text.Font(com.itextpdf.text.Font.FontFamily.TIMES_ROMAN,11));
	         try{ 	
	        	 
	        	 	Connection conn =DriverManager.getConnection("jdbc:sqlite:print.sqlite"); 
 		        	String query="select image from  mtb where name = '"+check+"' ";
 	 				PreparedStatement pst=conn.prepareStatement(query);
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
 	 				
 	 				PdfContentByte cb1, cb2,cb3,cb4,cb5,cb6,cb7,cb8,cb9,cb10,cb11,cb12,cb13,cb14,cb15,cb16,cb17,cb18,cb19,cb20,cb21,cb22,cb23,cb24,cb25,cb26,cb27,cb28,cb29,cb30,cb31,cb32,cb33,cb34,cb35,cb36,cb37;
 	 				BaseFont bf = BaseFont.createFont(BaseFont.HELVETICA, BaseFont.CP1252, BaseFont.NOT_EMBEDDED);
 	 				
 	 				
 	 				
 	 				
 	 				
 	 			
 	 				
 	 				cb1 = writer.getDirectContent();
 					cb1.beginText();
 	 				cb1.setFontAndSize(bf, 10);
 	 				cb1.showTextAligned(PdfContentByte.ALIGN_LEFT, c1, 515,498, 0);
 	 				cb1.endText();
 	 				
 	 				cb2 = writer.getDirectContent();
 					cb2.beginText();
 	 				cb2.setFontAndSize(bf, 10);
 	 				cb2.showTextAligned(PdfContentByte.ALIGN_LEFT, c2, 515, 467, 0);
 	 				cb2.endText();
 	 				
 	 				cb3 = writer.getDirectContent();
 					cb3.beginText();
 	 				cb3.setFontAndSize(bf, 10);
 	 				cb3.showTextAligned(PdfContentByte.ALIGN_LEFT, c3, 515, 436, 0);
 	 				cb3.endText();
 	 				
 	 				
 	 				cb4 = writer.getDirectContent();
 					cb4.beginText();
 	 				cb4.setFontAndSize(bf, 10);
 	 				cb4.showTextAligned(PdfContentByte.ALIGN_LEFT, c4, 515, 405, 0);
 	 				cb4.endText();
 	 				
 	 				cb5 = writer.getDirectContent();
 					cb5.beginText();
 	 				cb5.setFontAndSize(bf, 10);
 	 				cb5.showTextAligned(PdfContentByte.ALIGN_LEFT, c5, 515, 348, 0);
 	 				cb5.endText();
 	 				
 	 				
 	 				cb6 = writer.getDirectContent();
 					cb6.beginText();
 	 				cb6.setFontAndSize(bf, 10);
 	 				cb6.showTextAligned(PdfContentByte.ALIGN_LEFT, c6, 515, 317, 0);
 	 				cb6.endText();
 	 				
 	 				cb7 = writer.getDirectContent();
 					cb7.beginText();
 	 				cb7.setFontAndSize(bf, 10);
 	 				cb7.showTextAligned(PdfContentByte.ALIGN_LEFT, c7, 515, 286, 0);
 	 				cb7.endText();
 	 				
 	 				
 	 				cb8 = writer.getDirectContent();
 					cb8.beginText();
 	 				cb8.setFontAndSize(bf, 10);
 	 				cb8.showTextAligned(PdfContentByte.ALIGN_LEFT, c8, 515, 255, 0);
 	 				cb8.endText();
 	 				
 	 				
 	 				cb9 = writer.getDirectContent();
 					cb9.beginText();
 	 				cb9.setFontAndSize(bf, 10);
 	 				cb9.showTextAligned(PdfContentByte.ALIGN_LEFT, c9, 515, 224, 0);
 	 				cb9.endText();
 	 				
 	 				
 	 				
 	 				cb10 = writer.getDirectContent();
 					cb10.beginText();
 	 				cb10.setFontAndSize(bf, 10);
 	 				cb10.showTextAligned(PdfContentByte.ALIGN_LEFT, c10, 515, 193, 0);
 	 				cb10.endText();
 	 				
 	 				
 	 				cb11 = writer.getDirectContent();
 					cb11.beginText();
 	 				cb11.setFontAndSize(bf, 10);
 	 				cb11.showTextAligned(PdfContentByte.ALIGN_LEFT, c11, 515, 162, 0);
 	 				cb11.endText();
 	 				
 	 				
 	 				cb12 = writer.getDirectContent();
 					cb12.beginText();
 	 				cb12.setFontAndSize(bf, 10);
 	 				cb12.showTextAligned(PdfContentByte.ALIGN_LEFT, c12, 515, 131, 0);
 	 				cb12.endText();
 	 				
 	 				
 	 				cb13 = writer.getDirectContent();
 					cb13.beginText();
 	 				cb13.setFontAndSize(bf, 10);
 	 				cb13.showTextAligned(PdfContentByte.ALIGN_LEFT, r1, 250, 498, 0);
 	 				cb13.endText();
 	 				
 	 				
 	 				
 	 				cb14 = writer.getDirectContent();
 					cb14.beginText();
 	 				cb14.setFontAndSize(bf, 10);
 	 				cb14.showTextAligned(PdfContentByte.ALIGN_LEFT, r2, 250, 467, 0);
 	 				cb14.endText();
 	 				
 	 				cb15 = writer.getDirectContent();
 					cb15.beginText();
 	 				cb15.setFontAndSize(bf, 10);
 	 				cb15.showTextAligned(PdfContentByte.ALIGN_LEFT, r3, 250, 436, 0);
 	 				cb15.endText();
 	 				
 	 				
 	 				cb16 = writer.getDirectContent();
 					cb16.beginText();
 	 				cb16.setFontAndSize(bf, 10);
 	 				cb16.showTextAligned(PdfContentByte.ALIGN_LEFT, r4, 250, 405, 0);
 	 				cb16.endText();
 	 				
 	 				cb17 = writer.getDirectContent();
 					cb17.beginText();
 	 				cb17.setFontAndSize(bf, 10);
 	 				cb17.showTextAligned(PdfContentByte.ALIGN_LEFT, r5, 250, 348, 0);
 	 				cb17.endText();
 	 				
 	 				
 	 				cb18 = writer.getDirectContent();
 					cb18.beginText();
 	 				cb18.setFontAndSize(bf, 10);
 	 				cb18.showTextAligned(PdfContentByte.ALIGN_LEFT, r6, 250, 317, 0);
 	 				cb18.endText();
 	 				
 	 				cb19 = writer.getDirectContent();
 					cb19.beginText();
 	 				cb19.setFontAndSize(bf, 10);
 	 				cb19.showTextAligned(PdfContentByte.ALIGN_LEFT, r7, 250, 286, 0);
 	 				cb19.endText();
 	 				
 	 				
 	 				cb20 = writer.getDirectContent();
 					cb20.beginText();
 	 				cb20.setFontAndSize(bf, 10);
 	 				cb20.showTextAligned(PdfContentByte.ALIGN_LEFT, r8, 250, 255, 0);
 	 				cb20.endText();
 	 				
 	 				
 	 				cb21 = writer.getDirectContent();
 					cb21.beginText();
 	 				cb21.setFontAndSize(bf, 10);
 	 				cb21.showTextAligned(PdfContentByte.ALIGN_LEFT, r9, 250, 224, 0);
 	 				cb21.endText();
 	 				
 	 				
 	 				cb22 = writer.getDirectContent();
 					cb22.beginText();
 	 				cb22.setFontAndSize(bf, 10);
 	 				cb22.showTextAligned(PdfContentByte.ALIGN_LEFT, r10, 250, 193, 0);
 	 				cb22.endText();
 	 				
 	 				
 	 				cb23 = writer.getDirectContent();
 					cb23.beginText();
 	 				cb23.setFontAndSize(bf, 10);
 	 				cb23.showTextAligned(PdfContentByte.ALIGN_LEFT, r11, 250, 162, 0);
 	 				cb23.endText();
 	 				
 	 				
 	 				cb24 = writer.getDirectContent();
 					cb24.beginText();
 	 				cb24.setFontAndSize(bf, 10);
 	 				cb24.showTextAligned(PdfContentByte.ALIGN_LEFT, r12, 250, 131, 0);
 	 				cb24.endText();
 	 				
 	 				
 	 				
 	 				
 	 				
 	 				
 	 				cb22 = writer.getDirectContent();
 					cb22.beginText();
 	 				cb22.setFontAndSize(bf, 10);
 	 				cb22.showTextAligned(PdfContentByte.ALIGN_LEFT, o11, 10, 193, 0);
 	 				cb22.endText();
 	 				
 	 				
 	 				cb23 = writer.getDirectContent();
 					cb23.beginText();
 	 				cb23.setFontAndSize(bf, 10);
 	 				cb23.showTextAligned(PdfContentByte.ALIGN_LEFT, o12, 10, 162, 0);
 	 				cb23.endText();
 	 				
 	 				
 	 				cb24 = writer.getDirectContent();
 					cb24.beginText();
 	 				cb24.setFontAndSize(bf, 10);
 	 				cb24.showTextAligned(PdfContentByte.ALIGN_LEFT, o13, 10, 131, 0);
 	 				cb24.endText();
 	 				
 	 				
 	 				
 	 				
 	 				
 	 				cb24 = writer.getDirectContent();
 					cb24.beginText();
 	 				cb24.setFontAndSize(bf, 10);
 	 				cb24.showTextAligned(PdfContentByte.ALIGN_LEFT, String.valueOf(tot)+"/-", 515, 100, 0);
 	 				cb24.endText();
 	 				
 	 				inword= Billing.convertToIndianCurrency(tot);
 	 				
 	 				
 	 				cb25 = writer.getDirectContent();
 					cb25.beginText();
 	 				cb25.setFontAndSize(bf, 10);
 	 				cb25.showTextAligned(PdfContentByte.ALIGN_LEFT, inword, 70, 90, 0);
 	 				cb25.endText();
 	 				
 	 				
 	 				
 	 				cb26 = writer.getDirectContent();
 					cb26.beginText();
 	 				cb26.setFontAndSize(bf, 10);
 	 				cb26.showTextAligned(PdfContentByte.ALIGN_LEFT, textField.getText(), 70,628, 0);
 	 				cb26.endText();
 	 				
 	 				
 	 				cb27 = writer.getDirectContent();
 					cb27.beginText();
 	 				cb27.setFontAndSize(bf, 10);
 	 				cb27.showTextAligned(PdfContentByte.ALIGN_LEFT, doa, 270,628, 0);
 	 				cb27.endText();
 	 				
 	 				
 	 				cb28 = writer.getDirectContent();
 					cb28.beginText();
 	 				cb28.setFontAndSize(bf, 10);
 	 				cb28.showTextAligned(PdfContentByte.ALIGN_LEFT, dod, 490,628, 0);
 	 				cb28.endText();
 	 				
 	 				cb29 = writer.getDirectContent();
 					cb29.beginText();
 	 				cb29.setFontAndSize(bf, 10);
 	 				cb29.showTextAligned(PdfContentByte.ALIGN_LEFT, cd, 128,611, 0);
 	 				cb29.endText();
 	 				
 	 				
 	 				cb30 = writer.getDirectContent();
 					cb30.beginText();
 	 				cb30.setFontAndSize(bf, 10);
 	 				cb30.showTextAligned(PdfContentByte.ALIGN_LEFT, room, 322,611, 0);
 	 				cb30.endText();
 	 				
 	 				
 	 				cb31 = writer.getDirectContent();
 					cb31.beginText();
 	 				cb31.setFontAndSize(bf, 10);
 	 				cb31.showTextAligned(PdfContentByte.ALIGN_LEFT, ac, 480,611, 0);
 	 				cb31.endText();
 	 				
 	 				
 	 				cb32 = writer.getDirectContent();
 					cb32.beginText();
 	 				cb32.setFontAndSize(bf, 10);
 	 				cb32.showTextAligned(PdfContentByte.ALIGN_LEFT, name, 60,593, 0);
 	 				cb32.endText();
 	 				
 	 				
 	 				cb33 = writer.getDirectContent();
 					cb33.beginText();
 	 				cb33.setFontAndSize(bf, 10);
 	 				cb33.showTextAligned(PdfContentByte.ALIGN_LEFT, age,475,593, 0);
 	 				cb33.endText();
 	 				
 	 				
 	 				
 	 				cb34 = writer.getDirectContent();
 					cb34.beginText();
 	 				cb34.setFontAndSize(bf, 10);
 	 				cb34.showTextAligned(PdfContentByte.ALIGN_LEFT, ope,150,575, 0);
 	 				cb34.endText();
 	 				
 	 				
 	 				cb35 = writer.getDirectContent();
 					cb35.beginText();
 	 				cb35.setFontAndSize(bf, 10);
 	 				cb35.showTextAligned(PdfContentByte.ALIGN_LEFT, add,70,559, 0);
 	 				cb35.endText();
 	 				
 	 				
 	 				
 	 				cb36 = writer.getDirectContent();
 					cb36.beginText();
 	 				cb36.setFontAndSize(bf, 10);
 	 				cb36.showTextAligned(PdfContentByte.ALIGN_LEFT, con,450,559, 0);
 	 				cb36.endText();
 	 				
 	 				
 	 				cb37 = writer.getDirectContent();
 					cb37.beginText();
 	 				cb37.setFontAndSize(bf, 10);
 	 				cb37.showTextAligned(PdfContentByte.ALIGN_LEFT, dod,492,648, 0);
 	 				cb37.endText();
 	 				
 	 				
 	 				
 	 				
 	 				
 	 				
 	 				
 	 				document.add(p);
 	 				document.close();
 	 				writer.close();
 	 				Desktop.getDesktop().open(new File(pdf));
 	 				
      	        }catch(Exception fe)
      	        {
      	        	fe.printStackTrace();
      	        }
	         
	         	
 				 
	           
	}
		catch(Exception e)
		{}
	
	}
}
