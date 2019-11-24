import java.awt.Desktop;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JRootPane;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.AbstractAction;
import javax.swing.DefaultComboBoxModel;
import javax.swing.InputMap;

import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.toedter.calendar.JDateChooser;

import net.proteanit.sql.DbUtils;

import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.KeyStroke;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

import org.apache.tools.ant.taskdefs.JikesOutputParser;

import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileOutputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.awt.event.ActionEvent;

public class REPORT {

	private JFrame frame;
	private JTable print;
	JComboBox comboBox;
	JDateChooser dateChooser_1,dateChooser;
	DefaultTableModel print_model;
	private Object[] rows1;
	Connection conn=null;
	Connection conn1 = null;
	Connection conn2 = null;
	
	java.util.Date fromm1;
	java.util.Date too1;
	java.util.Date get;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					REPORT window = new REPORT();
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
	
	
	public REPORT() {
		initialize();
		conn=SqliteConnection.dbconnector();
		conn1=SqliteConnection.dbconnector1();
		conn2=SqliteConnection.dbconnector2();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	
	protected JRootPane createRootPane() { 
	    JRootPane rootPane = new JRootPane();
	    KeyStroke stroke = KeyStroke.getKeyStroke("ESCAPE");
	    AbstractAction actionListener = new AbstractAction() { 
	      public void actionPerformed(ActionEvent actionEvent) { 
	       
	    	  
	    		
	    	  String s[] = {"admin"};
	    	  MainPage.main(s);
	        

	      } 
	    } ;
	    InputMap inputMap = rootPane.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
	    inputMap.put(stroke, "ESCAPE");
	    rootPane.getActionMap().put("ESCAPE", actionListener);

	    return rootPane;
	  } 

	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 1, 1230, 917);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		 comboBox= new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"UB_RPD", "BB_RPD", "OPB_RPD", "JN_RPD"}));
		comboBox.setBounds(6, 20, 154, 27);
		frame.getContentPane().add(comboBox);
		
		dateChooser = new JDateChooser();
		dateChooser.setBounds(6, 71, 164, 41);
		frame.getContentPane().add(dateChooser);
		
		JDateChooser dateChooser_1 = new JDateChooser();
		dateChooser_1.setBounds(195, 71, 164, 41);
		frame.getContentPane().add(dateChooser_1);
		
		JButton btnNewButton = new JButton("OPD");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				double dd = 0.0;
	   			double ddd= 0.0;
	   			double d4 = 0.0;
	   			double d5 = 0.0;
				
	   			
	   			
	   			
	   				
	   				
	   				
	   			print_model.addColumn("sno");
	   			print_model.addColumn("patient");
	   			print_model.addColumn("Amount");
	   			print_model.addColumn("Net");
	   			print_model.addColumn("Discount");
	   			print_model.addColumn("Due");
	   			
	   			if(comboBox.getSelectedItem().toString().equals("UB_RPD"))
	   			{
	   				
	   				
	   				
	   				
	   			
	   			dd=0.0;
	   				
	   			 DateFormat fd = new SimpleDateFormat("dd-MM-yyyy");
	 			
	 			
	   			String from = fd.format(dateChooser.getDate());
				String to = fd.format(dateChooser_1.getDate());
		
				try {
					fromm1 = new SimpleDateFormat("dd-MM-yyyy").parse(from);
					too1 = new SimpleDateFormat("dd-MM-yyyy").parse(to);
					
				} catch (ParseException ee) {
					// TODO Auto-generated catch block
					ee.printStackTrace();
				}	   				
	 			double amt = 0.0;
	 			String a = "0.0",b = "0.0",c = "0.0",d="0.0",e1 = "0.0",f = "0.0",g = "0.0";
	 		  
		   			
	 			try
				{
																		
					    conn =DriverManager.getConnection("jdbc:ucanaccess://bansal.accdb");  
					    Statement statement1 = conn.createStatement();
		    			String query1=  "select rg,date,refby,name,mobile,charge  from  "+comboBox.getSelectedItem().toString()+"   ";
		    			 ResultSet rs1 = statement1.executeQuery(query1);
		    			 while (rs1.next())
				            {  
		    				 
		    				 rows1 = new Object[15];
								rows1[0]= rs1.getString("rg");
								rows1[1]= rs1.getString("date");
								rows1[2]= rs1.getString("refby");
								rows1[3]= rs1.getString("name");
								rows1[4]= rs1.getString("mobile");
								rows1[5] = rs1.getString("charge");
								
								String ss = rs1.getString("date");
								try {
								
									
									get = new SimpleDateFormat("dd-MM-yyyy").parse(ss);
									
									
								} catch (ParseException ee) {
									// TODO Auto-generated catch block
									ee.printStackTrace();
								}
								
								if(get.after(fromm1)&&get.before(too1))
								{	
									
								
									print_model.addRow(rows1);
								
									
									
								}
								else
								{
									//JOptionPane.showMessageDialog(null, "No");
								}
								
					
				            }//end while
				
					rs1.close();
					statement1.close();
					
				}
				catch(SQLException e1e)
				{
						JOptionPane.showMessageDialog(null, e1e);
				}
			   			
		            
		   			 
		   			
	   				
	   				Document document = new Document(PageSize.A4_LANDSCAPE,40,0,50,50);
			   			try
			   		      {     
			   		         PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream("printreport.pdf"));
			   		         document.open();
			   		         Paragraph p = new Paragraph("",new com.itextpdf.text.Font(com.itextpdf.text.Font.FontFamily.TIMES_ROMAN,9,Font.BOLD));
			   		         
			   		         Paragraph p1 = new Paragraph("",new com.itextpdf.text.Font(com.itextpdf.text.Font.FontFamily.TIMES_ROMAN,12,Font.BOLD));
			   		         BaseFont bf1 = BaseFont.createFont(BaseFont.HELVETICA, BaseFont.CP1252, BaseFont.NOT_EMBEDDED);
			   		     	 
			   		         com.itextpdf.text.Font font = new com.itextpdf.text.Font(bf1, 12);
			   		         
			   		         
			   		         
			   		         
			   		         	p1.add("OPD Report OF DR. UJJWAL BANSAL Date Between  "+from+" To "+to);
			   		         
			   		         	
			   		         	
			   		         	
			   		         	PdfPTable ttt = new PdfPTable(6);
			   		         	
			   		         	
			   		         	//ttt.getDefaultCell().setBorder(PdfPCell.NO_BORDER);
				 				ttt.setWidthPercentage(100);
				 				
								
				 				
				 				
				 				
								
								
								
								PdfPCell c2 = new PdfPCell(new Phrase("Recipt No",font));
								ttt.addCell(c2);
								
								
								
								
								c2 = new PdfPCell(new Phrase("Date",font));
								ttt.addCell(c2);
								
								c2 = new PdfPCell(new Phrase("REF BY",font));
								ttt.addCell(c2);
								
								
								
								
								c2 = new PdfPCell(new Phrase("Patient Name",font));
								ttt.addCell(c2);
								
								
								
								
								c2 = new PdfPCell(new Phrase("Mobile",font));
								ttt.addCell(c2);
								
								
								c2 = new PdfPCell(new Phrase("Charge",font));
								ttt.addCell(c2);

			 					
				 					
			 					int roww = print.getRowCount();
			 		   			int coloumnn = print.getColumnCount();
			 		   			ddd=0.0;
			 		   			for(int i=0;i<roww;i++)
			 						
			 					{	
			 					
			 		   				for(int j=0;j<coloumnn;j++)
			 			   			{
			 		   					
			 			   						
			 		   					String s = print.getValueAt(i,j).toString();
			 			   				ttt.addCell(s);
			 			   				
			 			   					
			 			   			}
			 		   				d5 = d5 + Double.parseDouble(print.getValueAt(i,5).toString());
			 		   				
			 			   			
			 		   				//JOptionPane.showMessageDialog(null, ddd);
			 					}
			 		   				
			 		   			
			 		   				
			 		   				
			 		   				
			 		   				
			 		   				ttt.addCell(c2);
				   	 	 			p1.add(ttt);	
			   		         
			   		         
				   	 	 		
				   	 	 		
				   	 	 		
					   	 	 	p1.add("\n");
				   	 	 		p1.add("Total Collection     ");
				   	 	 		p1.add(String.valueOf(d5));
				   	 	 		
			 		   			p1.setAlignment(Element.ALIGN_JUSTIFIED);
			 		   			document.add(p1);
			 		   			document.setMargins(180, 108, 72, 36);
		   	 					
		   	 					document.add(p);
		   	 					
		   	 	 				
		   	 	 				document.close();
		   	 	 				writer.close();
		   	 	 				Desktop.getDesktop().open(new File("printreport.pdf"));
			   		         
			   		         
			   		      }
			   			
			   			catch(Exception ee)
			   			{
			   				ee.printStackTrace();
			   			}

		   			}
	   			
	   			
	   			
	   			
	   			
	   			
	   			
	   			
	   			
	   			else if(comboBox.getSelectedItem().toString().equals("BB_RPD"))
	   			{
	   				
	   				
	   				
	   				
	   			
	   			dd=0.0;
	   				
	   			 DateFormat fd = new SimpleDateFormat("dd-MM-yyyy");
	 			
	 			
	   			String from = fd.format(dateChooser.getDate());
				String to = fd.format(dateChooser_1.getDate());
		
				try {
					fromm1 = new SimpleDateFormat("dd-MM-yyyy").parse(from);
					too1 = new SimpleDateFormat("dd-MM-yyyy").parse(to);
					
				} catch (ParseException ee) {
					// TODO Auto-generated catch block
					ee.printStackTrace();
				}	   				
	 			double amt = 0.0;
	 			String a = "0.0",b = "0.0",c = "0.0",d="0.0",e1 = "0.0",f = "0.0",g = "0.0";
	 		  
		   			
	 			try
				{
																		
					    conn =DriverManager.getConnection("jdbc:ucanaccess://bansal.accdb");  
					    Statement statement1 = conn.createStatement();
		    			String query1=  "select rg,date,refby,name,mobile,charge  from  "+comboBox.getSelectedItem().toString()+"   ";
		    			 ResultSet rs1 = statement1.executeQuery(query1);
		    			 while (rs1.next())
				            {  
		    				 
		    				 rows1 = new Object[15];
								rows1[0]= rs1.getString("rg");
								rows1[1]= rs1.getString("date");
								rows1[2]= rs1.getString("refby");
								rows1[3]= rs1.getString("name");
								rows1[4]= rs1.getString("mobile");
								rows1[5] = rs1.getString("charge");
								
								String ss = rs1.getString("date");
								try {
								
									
									get = new SimpleDateFormat("dd-MM-yyyy").parse(ss);
									
									
								} catch (ParseException ee) {
									// TODO Auto-generated catch block
									ee.printStackTrace();
								}
								
								if(get.after(fromm1)&&get.before(too1))
								{	
									
								
									print_model.addRow(rows1);
								
									
									
								}
								else
								{
									//JOptionPane.showMessageDialog(null, "No");
								}
								
					
				            }//end while
				
					rs1.close();
					statement1.close();
					
				}
				catch(SQLException e1e)
				{
						JOptionPane.showMessageDialog(null, e1e);
				}
			   			
		            
		   			 
		   			
	   				
	   				Document document = new Document(PageSize.A4_LANDSCAPE,40,0,50,50);
			   			try
			   		      {     
			   		         PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream("printreport.pdf"));
			   		         document.open();
			   		         Paragraph p = new Paragraph("",new com.itextpdf.text.Font(com.itextpdf.text.Font.FontFamily.TIMES_ROMAN,9,Font.BOLD));
			   		         
			   		         Paragraph p1 = new Paragraph("",new com.itextpdf.text.Font(com.itextpdf.text.Font.FontFamily.TIMES_ROMAN,12,Font.BOLD));
			   		         BaseFont bf1 = BaseFont.createFont(BaseFont.HELVETICA, BaseFont.CP1252, BaseFont.NOT_EMBEDDED);
			   		     	 
			   		         com.itextpdf.text.Font font = new com.itextpdf.text.Font(bf1, 12);
			   		         
			   		         
			   		         
			   		         
			   		         	p1.add("OPD Report OF DR. BHARTI BANSAL Date Between  "+from+" To "+to);
			   		         
			   		         	
			   		         	
			   		         	
			   		         	PdfPTable ttt = new PdfPTable(6);
			   		         	
			   		         	
			   		         	//ttt.getDefaultCell().setBorder(PdfPCell.NO_BORDER);
				 				ttt.setWidthPercentage(100);
				 				
								
				 				
				 				
				 				
								
								
								
								PdfPCell c2 = new PdfPCell(new Phrase("Recipt No",font));
								ttt.addCell(c2);
								
								
								
								
								c2 = new PdfPCell(new Phrase("Date",font));
								ttt.addCell(c2);
								
								c2 = new PdfPCell(new Phrase("REF BY",font));
								ttt.addCell(c2);
								
								
								
								
								c2 = new PdfPCell(new Phrase("Patient Name",font));
								ttt.addCell(c2);
								
								
								
								
								c2 = new PdfPCell(new Phrase("Mobile",font));
								ttt.addCell(c2);
								
								
								c2 = new PdfPCell(new Phrase("Charge",font));
								ttt.addCell(c2);

			 					
				 					
			 					int roww = print.getRowCount();
			 		   			int coloumnn = print.getColumnCount();
			 		   			ddd=0.0;
			 		   			for(int i=0;i<roww;i++)
			 						
			 					{	
			 					
			 		   				for(int j=0;j<coloumnn;j++)
			 			   			{
			 		   					
			 			   						
			 		   					String s = print.getValueAt(i,j).toString();
			 			   				ttt.addCell(s);
			 			   				
			 			   					
			 			   			}
			 		   				d5 = d5 + Double.parseDouble(print.getValueAt(i,5).toString());
			 		   				
			 			   			
			 		   				//JOptionPane.showMessageDialog(null, ddd);
			 					}
			 		   				
			 		   			
			 		   				
			 		   				
			 		   				
			 		   				
			 		   				ttt.addCell(c2);
				   	 	 			p1.add(ttt);	
			   		         
			   		         
				   	 	 		
				   	 	 		
				   	 	 		
					   	 	 	p1.add("\n");
				   	 	 		p1.add("Total Collection     ");
				   	 	 		p1.add(String.valueOf(d5));
				   	 	 		
			 		   			p1.setAlignment(Element.ALIGN_JUSTIFIED);
			 		   			document.add(p1);
			 		   			document.setMargins(180, 108, 72, 36);
		   	 					
		   	 					document.add(p);
		   	 					
		   	 	 				
		   	 	 				document.close();
		   	 	 				writer.close();
		   	 	 				Desktop.getDesktop().open(new File("printreport.pdf"));
			   		         
			   		         
			   		      }
			   			
			   			catch(Exception ee)
			   			{
			   				ee.printStackTrace();
			   			}

		   			}
	   			
	   			
	   			else if(comboBox.getSelectedItem().toString().equals("OPB_RPD"))
	   			{
	   				
	   				
	   				
	   				
	   			
	   			dd=0.0;
	   				
	   			 DateFormat fd = new SimpleDateFormat("dd-MM-yyyy");
	 			
	 			
	   			String from = fd.format(dateChooser.getDate());
				String to = fd.format(dateChooser_1.getDate());
		
				try {
					fromm1 = new SimpleDateFormat("dd-MM-yyyy").parse(from);
					too1 = new SimpleDateFormat("dd-MM-yyyy").parse(to);
					
				} catch (ParseException ee) {
					// TODO Auto-generated catch block
					ee.printStackTrace();
				}	   				
	 			double amt = 0.0;
	 			String a = "0.0",b = "0.0",c = "0.0",d="0.0",e1 = "0.0",f = "0.0",g = "0.0";
	 		  
		   			
	 			try
				{
																		
					    conn =DriverManager.getConnection("jdbc:ucanaccess://bansal.accdb");  
					    Statement statement1 = conn.createStatement();
		    			String query1=  "select rg,date,refby,name,mobile,charge  from  "+comboBox.getSelectedItem().toString()+"   ";
		    			 ResultSet rs1 = statement1.executeQuery(query1);
		    			 while (rs1.next())
				            {  
		    				 
		    				 rows1 = new Object[15];
								rows1[0]= rs1.getString("rg");
								rows1[1]= rs1.getString("date");
								rows1[2]= rs1.getString("refby");
								rows1[3]= rs1.getString("name");
								rows1[4]= rs1.getString("mobile");
								rows1[5] = rs1.getString("charge");
								
								String ss = rs1.getString("date");
								try {
								
									
									get = new SimpleDateFormat("dd-MM-yyyy").parse(ss);
									
									
								} catch (ParseException ee) {
									// TODO Auto-generated catch block
									ee.printStackTrace();
								}
								
								if(get.after(fromm1)&&get.before(too1))
								{	
									
								
									print_model.addRow(rows1);
								
									
									
								}
								else
								{
									//JOptionPane.showMessageDialog(null, "No");
								}
								
					
				            }//end while
				
					rs1.close();
					statement1.close();
					
				}
				catch(SQLException e1e)
				{
						JOptionPane.showMessageDialog(null, e1e);
				}
			   			
		            
		   			 
		   			
	   				
	   				Document document = new Document(PageSize.A4_LANDSCAPE,40,0,50,50);
			   			try
			   		      {     
			   		         PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream("printreport.pdf"));
			   		         document.open();
			   		         Paragraph p = new Paragraph("",new com.itextpdf.text.Font(com.itextpdf.text.Font.FontFamily.TIMES_ROMAN,9,Font.BOLD));
			   		         
			   		         Paragraph p1 = new Paragraph("",new com.itextpdf.text.Font(com.itextpdf.text.Font.FontFamily.TIMES_ROMAN,12,Font.BOLD));
			   		         BaseFont bf1 = BaseFont.createFont(BaseFont.HELVETICA, BaseFont.CP1252, BaseFont.NOT_EMBEDDED);
			   		     	 
			   		         com.itextpdf.text.Font font = new com.itextpdf.text.Font(bf1, 12);
			   		         
			   		         
			   		         
			   		         
			   		         	p1.add("OPD Report OF DR. O.P. BANSAL Date Between  "+from+" To "+to);
			   		         
			   		         	
			   		         	
			   		         	
			   		         	PdfPTable ttt = new PdfPTable(6);
			   		         	
			   		         	
			   		         	//ttt.getDefaultCell().setBorder(PdfPCell.NO_BORDER);
				 				ttt.setWidthPercentage(100);
				 				
								
				 				
				 				
				 				
								
								
								
								PdfPCell c2 = new PdfPCell(new Phrase("Recipt No",font));
								ttt.addCell(c2);
								
								
								
								
								c2 = new PdfPCell(new Phrase("Date",font));
								ttt.addCell(c2);
								
								c2 = new PdfPCell(new Phrase("REF BY",font));
								ttt.addCell(c2);
								
								
								
								
								c2 = new PdfPCell(new Phrase("Patient Name",font));
								ttt.addCell(c2);
								
								
								
								
								c2 = new PdfPCell(new Phrase("Mobile",font));
								ttt.addCell(c2);
								
								
								c2 = new PdfPCell(new Phrase("Charge",font));
								ttt.addCell(c2);

			 					
				 					
			 					int roww = print.getRowCount();
			 		   			int coloumnn = print.getColumnCount();
			 		   			ddd=0.0;
			 		   			for(int i=0;i<roww;i++)
			 						
			 					{	
			 					
			 		   				for(int j=0;j<coloumnn;j++)
			 			   			{
			 		   					
			 			   						
			 		   					String s = print.getValueAt(i,j).toString();
			 			   				ttt.addCell(s);
			 			   				
			 			   					
			 			   			}
			 		   				d5 = d5 + Double.parseDouble(print.getValueAt(i,5).toString());
			 		   				
			 			   			
			 		   				//JOptionPane.showMessageDialog(null, ddd);
			 					}
			 		   				
			 		   			
			 		   				
			 		   				
			 		   				
			 		   				
			 		   				ttt.addCell(c2);
				   	 	 			p1.add(ttt);	
			   		         
			   		         
				   	 	 		
				   	 	 		
				   	 	 		
					   	 	 	p1.add("\n");
				   	 	 		p1.add("Total Collection     ");
				   	 	 		p1.add(String.valueOf(d5));
				   	 	 		
			 		   			p1.setAlignment(Element.ALIGN_JUSTIFIED);
			 		   			document.add(p1);
			 		   			document.setMargins(180, 108, 72, 36);
		   	 					
		   	 					document.add(p);
		   	 					
		   	 	 				
		   	 	 				document.close();
		   	 	 				writer.close();
		   	 	 				Desktop.getDesktop().open(new File("printreport.pdf"));
			   		         
			   		         
			   		      }
			   			
			   			catch(Exception ee)
			   			{
			   				ee.printStackTrace();
			   			}

		   			}
	   			
	   			
	   			
	   			
	   			
	   			else if(comboBox.getSelectedItem().toString().equals("JN_RPD"))
	   			{
	   				
	   				
	   				
	   				
	   			
	   			dd=0.0;
	   				
	   			 DateFormat fd = new SimpleDateFormat("dd-MM-yyyy");
	 			
	 			
	   			String from = fd.format(dateChooser.getDate());
				String to = fd.format(dateChooser_1.getDate());
		
				try {
					fromm1 = new SimpleDateFormat("dd-MM-yyyy").parse(from);
					too1 = new SimpleDateFormat("dd-MM-yyyy").parse(to);
					
				} catch (ParseException ee) {
					// TODO Auto-generated catch block
					ee.printStackTrace();
				}	   				
	 			double amt = 0.0;
	 			String a = "0.0",b = "0.0",c = "0.0",d="0.0",e1 = "0.0",f = "0.0",g = "0.0";
	 		  
		   			
	 			try
				{
																		
					    conn =DriverManager.getConnection("jdbc:ucanaccess://bansal.accdb");  
					    Statement statement1 = conn.createStatement();
		    			String query1=  "select rg,date,refby,name,mobile,charge  from  "+comboBox.getSelectedItem().toString()+"   ";
		    			 ResultSet rs1 = statement1.executeQuery(query1);
		    			 while (rs1.next())
				            {  
		    				 
		    				 rows1 = new Object[15];
								rows1[0]= rs1.getString("rg");
								rows1[1]= rs1.getString("date");
								rows1[2]= rs1.getString("refby");
								rows1[3]= rs1.getString("name");
								rows1[4]= rs1.getString("mobile");
								rows1[5] = rs1.getString("charge");
								
								String ss = rs1.getString("date");
								try {
								
									
									get = new SimpleDateFormat("dd-MM-yyyy").parse(ss);
									
									
								} catch (ParseException ee) {
									// TODO Auto-generated catch block
									ee.printStackTrace();
								}
								
								if(get.after(fromm1)&&get.before(too1))
								{	
									
								
									print_model.addRow(rows1);
								
									
									
								}
								else
								{
									//JOptionPane.showMessageDialog(null, "No");
								}
								
					
				            }//end while
				
					rs1.close();
					statement1.close();
					
				}
				catch(SQLException e1e)
				{
						JOptionPane.showMessageDialog(null, e1e);
				}
			   			
		            
		   			 
		   			
	   				
	   				Document document = new Document(PageSize.A4_LANDSCAPE,40,0,50,50);
			   			try
			   		      {     
			   		         PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream("printreport.pdf"));
			   		         document.open();
			   		         Paragraph p = new Paragraph("",new com.itextpdf.text.Font(com.itextpdf.text.Font.FontFamily.TIMES_ROMAN,9,Font.BOLD));
			   		         
			   		         Paragraph p1 = new Paragraph("",new com.itextpdf.text.Font(com.itextpdf.text.Font.FontFamily.TIMES_ROMAN,12,Font.BOLD));
			   		         BaseFont bf1 = BaseFont.createFont(BaseFont.HELVETICA, BaseFont.CP1252, BaseFont.NOT_EMBEDDED);
			   		     	 
			   		         com.itextpdf.text.Font font = new com.itextpdf.text.Font(bf1, 12);
			   		         
			   		         
			   		         
			   		         
			   		         	p1.add("OPD Report OF DR. JITENDER NAGPAL Date Between  "+from+" To "+to);
			   		         
			   		         	
			   		         	
			   		         	
			   		         	PdfPTable ttt = new PdfPTable(6);
			   		         	
			   		         	
			   		         	//ttt.getDefaultCell().setBorder(PdfPCell.NO_BORDER);
				 				ttt.setWidthPercentage(100);
				 				
								
				 				
				 				
				 				
								
								
								
								PdfPCell c2 = new PdfPCell(new Phrase("Recipt No",font));
								ttt.addCell(c2);
								
								
								
								
								c2 = new PdfPCell(new Phrase("Date",font));
								ttt.addCell(c2);
								
								c2 = new PdfPCell(new Phrase("REF BY",font));
								ttt.addCell(c2);
								
								
							
								
								
								c2 = new PdfPCell(new Phrase("Patient Name",font));
								ttt.addCell(c2);
								
								
								
								
								c2 = new PdfPCell(new Phrase("Mobile",font));
								ttt.addCell(c2);
								
								
								c2 = new PdfPCell(new Phrase("Charge",font));
								ttt.addCell(c2);

			 					
				 					
			 					int roww = print.getRowCount();
			 		   			int coloumnn = print.getColumnCount();
			 		   			ddd=0.0;
			 		   			for(int i=0;i<roww;i++)
			 						
			 					{	
			 					
			 		   				for(int j=0;j<coloumnn;j++)
			 			   			{
			 		   					
			 			   						
			 		   					String s = print.getValueAt(i,j).toString();
			 			   				ttt.addCell(s);
			 			   				
			 			   					
			 			   			}
			 		   				d5 = d5 + Double.parseDouble(print.getValueAt(i,5).toString());
			 		   				
			 			   			
			 		   				//JOptionPane.showMessageDialog(null, ddd);
			 					}
			 		   				
			 		   			
			 		   				
			 		   				
			 		   				
			 		   				
			 		   				ttt.addCell(c2);
				   	 	 			p1.add(ttt);	
			   		         
			   		         
				   	 	 		
				   	 	 		
				   	 	 		
					   	 	 	p1.add("\n");
				   	 	 		p1.add("Total Collection     ");
				   	 	 		p1.add(String.valueOf(d5));
				   	 	 		
			 		   			p1.setAlignment(Element.ALIGN_JUSTIFIED);
			 		   			document.add(p1);
			 		   			document.setMargins(180, 108, 72, 36);
		   	 					
		   	 					document.add(p);
		   	 					
		   	 	 				
		   	 	 				document.close();
		   	 	 				writer.close();
		   	 	 				Desktop.getDesktop().open(new File("printreport.pdf"));
			   		         
			   		         
			   		      }
			   			
			   			catch(Exception ee)
			   			{
			   				ee.printStackTrace();
			   			}

		   			}
	   			
			}
		});
		btnNewButton.setBounds(40, 126, 117, 29);
		frame.getContentPane().add(btnNewButton);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(14, 167, 1082, 187);
		frame.getContentPane().add(scrollPane);
		
		print = new JTable();
		print_model = new DefaultTableModel();
		print.setModel(print_model);
		scrollPane.setViewportView(print);
		
		JButton btnBack = new JButton("BACK");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String arr[] = {"admin"};
				MainPage.main(arr);
			}
		});
		btnBack.setBounds(582, 19, 117, 29);
		frame.getContentPane().add(btnBack);
		
		JComboBox drname2 = new JComboBox();
		drname2.setModel(new DefaultComboBoxModel(new String[] {"Dr.Ujjwal Bansal", "Dr.Bharti Bansal", "Dr.O.P. Bansal", "Dr. Jitender Nagpal", "All"}));
		drname2.setBounds(178, 20, 154, 27);
		frame.getContentPane().add(drname2);
		
		JComboBox categ = new JComboBox();
		categ.setModel(new DefaultComboBoxModel(new String[] {"BSBY", "CASH", "All"}));
		categ.setBounds(344, 20, 154, 27);
		frame.getContentPane().add(categ);
		
		JButton btnIpd = new JButton("IPD");
		btnIpd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				print_model.addColumn("IPD NO");
	   			print_model.addColumn("NAME");
	   			print_model.addColumn("Address");
	   			print_model.addColumn("DATE");
	   			print_model.addColumn("SURGERY");
	   			print_model.addColumn("DIS DATE");
	   			print_model.addColumn("CATE");
	   			print_model.addColumn("REFF BY");
				
				
				
				
				DateFormat fd = new SimpleDateFormat("dd-MM-yyyy");
	 			
	 			
	 			String from = fd.format(dateChooser.getDate());
	 			String to = fd.format(dateChooser_1.getDate());
		
				
				/*JOptionPane.showMessageDialog(null, from);
				JOptionPane.showMessageDialog(null, to);*/
				
				String s = categ.getSelectedItem().toString();
				if(s.equals("All"))
					
				{
					
					try {
						fromm1 = new SimpleDateFormat("dd-MM-yyyy").parse(from);
						too1 = new SimpleDateFormat("dd-MM-yyyy").parse(to);
						
					} catch (ParseException ee) {
						// TODO Auto-generated catch block
						ee.printStackTrace();
					}	   				
		 			
		 		  
			   			
		 			try
					{
																			
						    conn2 =DriverManager.getConnection("jdbc:ucanaccess://sbbh.accdb");  
						    Statement statement1 = conn2.createStatement();
			    			String query1=  "select ipd_no,name,Address,date,diagnose,dis_date,cate,refby from ipd_admit";
			    			 ResultSet rs1 = statement1.executeQuery(query1);
			    			 while (rs1.next())
					            {  
			    				 
			    				 rows1 = new Object[15];
									rows1[0]= rs1.getString("ipd_no");
									rows1[1]= rs1.getString("name");
									rows1[2]= rs1.getString("Address");
									rows1[3]= rs1.getString("date");
									rows1[4]= rs1.getString("diagnose");
									rows1[5] = rs1.getString("dis_date");
									rows1[6] = rs1.getString("cate");
									rows1[7] = rs1.getString("refby");
									
									String ss = rs1.getString("date");
									System.out.println(ss);
									try {
									
										
										get = new SimpleDateFormat("dd-MM-yyyy").parse(ss);
										
										
									} catch (ParseException ee) {
										// TODO Auto-generated catch block
										ee.printStackTrace();
									}
									
									if(get.after(fromm1)&&get.before(too1))
									{	
										
									
										print_model.addRow(rows1);
									
										
										
									}
									else
									{
										//JOptionPane.showMessageDialog(null, "No");
									}
									
						
					            }//end while
					
						rs1.close();
						statement1.close();
						
					}
					catch(SQLException e1e)
					{
							JOptionPane.showMessageDialog(null, e1e);
					}
					
				}
				else if(s.equals("BSBY"))
				{
					try {
						fromm1 = new SimpleDateFormat("dd-MM-yyyy").parse(from);
						too1 = new SimpleDateFormat("dd-MM-yyyy").parse(to);
						
					} catch (ParseException ee) {
						// TODO Auto-generated catch block
						ee.printStackTrace();
					}	   				
		 			
		 		  
			   			
		 			try
					{
																			
						    conn2 =DriverManager.getConnection("jdbc:ucanaccess://sbbh.accdb");  
						    Statement statement1 = conn2.createStatement();
			    			String query1=  "select ipd_no,name,Address,date,diagnose,dis_date,cate,refby from ipd_admit where cate = '"+categ.getSelectedItem().toString()+"' ";
			    			 ResultSet rs1 = statement1.executeQuery(query1);
			    			 while (rs1.next())
					            {  
			    				 
			    				 rows1 = new Object[15];
									rows1[0]= rs1.getString("ipd_no");
									rows1[1]= rs1.getString("name");
									rows1[2]= rs1.getString("Address");
									rows1[3]= rs1.getString("date");
									rows1[4]= rs1.getString("diagnose");
									rows1[5] = rs1.getString("dis_date");
									rows1[6] = rs1.getString("cate");
									rows1[7] = rs1.getString("refby");
									
									String ss = rs1.getString("date");
									System.out.println(ss);
									try {
									
										
										get = new SimpleDateFormat("dd-MM-yyyy").parse(ss);
										
										
									} catch (ParseException ee) {
										// TODO Auto-generated catch block
										ee.printStackTrace();
									}
									
									if(get.after(fromm1)&&get.before(too1))
									{	
										
									
										print_model.addRow(rows1);
									
										
										
									}
									else
									{
										//JOptionPane.showMessageDialog(null, "No");
									}
									
						
					            }//end while
					
						rs1.close();
						statement1.close();
						
					}
					catch(SQLException e1e)
					{
							JOptionPane.showMessageDialog(null, e1e);
					}
				}
				
				
				
				else if(s.equals("CASH"))
				{
					try {
						fromm1 = new SimpleDateFormat("dd-MM-yyyy").parse(from);
						too1 = new SimpleDateFormat("dd-MM-yyyy").parse(to);
						
					} catch (ParseException ee) {
						// TODO Auto-generated catch block
						ee.printStackTrace();
					}	   				
		 			
		 		  
			   			
		 			try
					{
																			
						    conn2 =DriverManager.getConnection("jdbc:ucanaccess://sbbh.accdb");  
						    Statement statement1 = conn2.createStatement();
			    			String query1=  "select ipd_no,name,Address,date,diagnose,dis_date,cate,refby from ipd_admit where cate = '"+categ.getSelectedItem().toString()+"' ";
			    			 ResultSet rs1 = statement1.executeQuery(query1);
			    			 while (rs1.next())
					            {  
			    				 
			    				 rows1 = new Object[15];
									rows1[0]= rs1.getString("ipd_no");
									rows1[1]= rs1.getString("name");
									rows1[2]= rs1.getString("Address");
									rows1[3]= rs1.getString("date");
									rows1[4]= rs1.getString("diagnose");
									rows1[5] = rs1.getString("dis_date");
									rows1[6] = rs1.getString("cate");
									rows1[7] = rs1.getString("refby");
									
									String ss = rs1.getString("date");
									System.out.println(ss);
									try {
									
										
										get = new SimpleDateFormat("dd-MM-yyyy").parse(ss);
										
										
									} catch (ParseException ee) {
										// TODO Auto-generated catch block
										ee.printStackTrace();
									}
									
									if(get.after(fromm1)&&get.before(too1))
									{	
										
									
										print_model.addRow(rows1);
									
										
										
									}
									else
									{
										//JOptionPane.showMessageDialog(null, "No");
									}
									
						
					            }//end while
					
						rs1.close();
						statement1.close();
						
					}
					catch(SQLException e1e)
					{
							JOptionPane.showMessageDialog(null, e1e);
					}
				}
				
				
				
				else
				{
					try {
						fromm1 = new SimpleDateFormat("dd-MM-yyyy").parse(from);
						too1 = new SimpleDateFormat("dd-MM-yyyy").parse(to);
						
					} catch (ParseException ee) {
						// TODO Auto-generated catch block
						ee.printStackTrace();
					}	   				
		 			
		 		  
			   			
		 			try
					{
																			
						    conn2 =DriverManager.getConnection("jdbc:ucanaccess://sbbh.accdb");  
						    Statement statement1 = conn2.createStatement();
			    			String query1=  "select ipd_no,name,Address,date,diagnose,dis_date,cate,refby from ipd_admit where cate = '"+categ.getSelectedItem().toString()+"' AND doctorname = '"+drname2.getSelectedItem().toString()+"' ";
			    			 ResultSet rs1 = statement1.executeQuery(query1);
			    			 while (rs1.next())
					            {  
			    				 
			    				 rows1 = new Object[15];
									rows1[0]= rs1.getString("ipd_no");
									rows1[1]= rs1.getString("name");
									rows1[2]= rs1.getString("Address");
									rows1[3]= rs1.getString("date");
									rows1[4]= rs1.getString("diagnose");
									rows1[5] = rs1.getString("dis_date");
									rows1[6] = rs1.getString("cate");
									rows1[7] = rs1.getString("refby");
									
									String ss = rs1.getString("date");
									System.out.println(ss);
									try {
									
										
										get = new SimpleDateFormat("dd-MM-yyyy").parse(ss);
										
										
									} catch (ParseException ee) {
										// TODO Auto-generated catch block
										ee.printStackTrace();
									}
									
									if(get.after(fromm1)&&get.before(too1))
									{	
										
									
										print_model.addRow(rows1);
									
										
										
									}
									else
									{
										//JOptionPane.showMessageDialog(null, "No");
									}
									
						
					            }//end while
					
						rs1.close();
						statement1.close();
						
					}
					catch(SQLException e1e)
					{
							JOptionPane.showMessageDialog(null, e1e);
					}
				}
				
				
				
			
				
				
			}
		});
		btnIpd.setBounds(195, 126, 117, 29);
		frame.getContentPane().add(btnIpd);
		
		JButton btnPrintIpdReport = new JButton("PRINT IPD REPORT");
		btnPrintIpdReport.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				Document document = new Document(PageSize.A4.rotate());
				DateFormat fd = new SimpleDateFormat("dd-MM-yyyy");
	 			
	 			
	 			String from = fd.format(dateChooser.getDate());
	 			String to = fd.format(dateChooser_1.getDate());
	   			try
	   		      {     
	   		         PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream("bssh.pdf"));
	   		         document.open();
	   		         Paragraph p = new Paragraph("",new com.itextpdf.text.Font(com.itextpdf.text.Font.FontFamily.TIMES_ROMAN,9,Font.BOLD));
	   		         
	   		         Paragraph p1 = new Paragraph("",new com.itextpdf.text.Font(com.itextpdf.text.Font.FontFamily.TIMES_ROMAN,12,Font.BOLD));
	   		         BaseFont bf1 = BaseFont.createFont(BaseFont.HELVETICA, BaseFont.CP1252, BaseFont.NOT_EMBEDDED);
	   		     	 
	   		         com.itextpdf.text.Font font = new com.itextpdf.text.Font(bf1, 12);
	   		         
	   		         
	   		         
	   		         
	   		         
	   		         
	   		         	p1.add("BANSAL SUPERSPECIALITY HOSPITAL IPD REPORT  Date Between  "+from+" To "+to);
	   		         	
	   		         	
	   		         	PdfPTable ttt = new PdfPTable(8);
	   		         	
	   		         	
	   		         	//ttt.getDefaultCell().setBorder(PdfPCell.NO_BORDER);
		 				ttt.setWidthPercentage(100);
		 				
						
		 				
		 				
		 				
		 				
						
						
						PdfPCell c2 = new PdfPCell(new Phrase("IPD NO",font));
						ttt.addCell(c2);
						
						
						
						
						c2 = new PdfPCell(new Phrase("Name",font));
						ttt.addCell(c2);
						
						c2 = new PdfPCell(new Phrase("Address",font));
						ttt.addCell(c2);
						
						
					
						
						
						c2 = new PdfPCell(new Phrase("Date",font));
						ttt.addCell(c2);
						
						
						
						
						c2 = new PdfPCell(new Phrase("Surgery",font));
						ttt.addCell(c2);
						
						
						c2 = new PdfPCell(new Phrase("Dis Date",font));
						ttt.addCell(c2);
						
						
						c2 = new PdfPCell(new Phrase("Cate",font));
						ttt.addCell(c2);
						
						
						c2 = new PdfPCell(new Phrase("Ref By",font));
						ttt.addCell(c2);

	 					
		 					
	 					int roww = print.getRowCount();
	 		   			int coloumnn = print.getColumnCount();
	 		   			
	 		   			for(int i=0;i<roww;i++)
	 						
	 					{	
	 					
	 		   				for(int j=0;j<coloumnn;j++)
	 			   			{
	 		   					
	 			   						
	 		   					String ss = print.getValueAt(i,j).toString();
	 			   				ttt.addCell(ss);
	 			   				
	 			   					
	 			   			}
	 		   				
	 		   				
	 			   			
	 		   				//JOptionPane.showMessageDialog(null, ddd);
	 					}
	 		   				
	 		   			
	 		   				
	 		   				
	 		   				
	 		   				
	 		   				ttt.addCell(c2);
		   	 	 			p1.add(ttt);	
	   		         
	   		         
		   	 	 		
		   	 	 		
		   	 	 		
			   	 	 
		   	 	 		
	 		   			p1.setAlignment(Element.ALIGN_JUSTIFIED);
	 		   			document.add(p1);
	 		   			document.setMargins(180, 108, 72, 36);
   	 					
   	 					document.add(p);
   	 					
   	 	 				
   	 	 				document.close();
   	 	 				writer.close();
   	 	 				Desktop.getDesktop().open(new File("bssh.pdf"));
	   		         
	   		         
	   		      }
	   			
	   			catch(Exception ee)
	   			{
	   				ee.printStackTrace();
	   			}
			}
		});
		btnPrintIpdReport.setBounds(322, 123, 176, 29);
		frame.getContentPane().add(btnPrintIpdReport);
	}
}
