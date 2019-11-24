import java.awt.BorderLayout;
import java.awt.Desktop;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Font.FontFamily;
import com.itextpdf.text.Image;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileOutputStream;
import java.net.ConnectException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.awt.event.ActionEvent;

public class Demo extends JDialog {

	private final JPanel contentPanel = new JPanel();
	public static JCheckBox shirt,pent,coat,jacket,kurta,pjama;
	public static  JButton btnNext;
	static Demo dialog ;
	static Connection connection=null;
	
	static String t,t1,t2,t3,t4,t5,t6,t7,t8;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		/*t=args[0];
		t1=args[1];
		t2 =args[2];
		t3= args[3];
		t4 = args[4];
		t5 = args[5];
		t6 = args[6];
		t7 = args[7];
		t8 = args[8];
*/

		try {
			connection=SqliteConnection.dbconnector();
			dialog = new Demo();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	public static void printButton(String shirtData[])
	{
		
			
		
			
			
			Document document =new Document(PageSize.A4.rotate(),0,0,0,0);
			try {
				PdfWriter writer=PdfWriter.getInstance(document, new FileOutputStream("print.pdf"));
				document.open();
				Paragraph p=new Paragraph("",new Font(Font.FontFamily.TIMES_ROMAN,12));
				
				try{ 		
 		        	/*String query="select * from  print_ipd";
 	 				PreparedStatement pst=connection.prepareStatement(query);
 	 				ResultSet rs=pst.executeQuery();
 	 				byte[] b2=rs.getBytes("image");
 	 				pst.close();
 	 				rs.close();*/
 	 				
 	 				
					byte[] b2 = null;
 	 				Image image1 = Image.getInstance(b2);
 	 				PdfPTable nestedTable = new PdfPTable(1);	
 	 				float[] columnWidths = {2f, 2f};
 	 				try {nestedTable.setWidths(columnWidths);}
 	 				catch(Exception e){ }
 	 				nestedTable.setTotalWidth(PageSize.A4.getWidth());
 	 				nestedTable.setLockedWidth(true);
 	 				nestedTable.setHorizontalAlignment(Element.ALIGN_TOP);
 	 				//nestedTable.setWidthPercentage(110);
 	 				PdfPCell cell2 = new PdfPCell(image1,true);
 	 				cell2.setBorder(0); 
 	 				nestedTable.addCell(cell2);
 	 				p.add(nestedTable);

 	 				p.add("\n");
 	 				p.add("\n");
 	 				p.add("\n");
 	 				p.add("\n");
 	 				p.add("\n");
 	 				p.add("\n");
 	 				p.add("\n");
 	 				p.add("                      Regn:     "+t+"                                                                 			 "+"Date of Admissin: "+t3+"\n");
	 		        p.add("                      Name:     "+t1+"                                                                           "+"Date Of Discahrge: "+t4+"\n");
	 		        p.add("                      Under Doctor:  "+t2+"\n");
	 		        p.add("\n");
 	 				
 	 				PdfContentByte cb2,cb3,cb4,cb5,cb6,cb7,cb8,cb9,cb10,cb11,cb12,cb13,cb14,cb15,cb16,cb17,cb18,cb19,cb20,cb21,cb22,cb23,cb24,cb25,cb26,cb27,cb28,cb29,cb30,cb31,cb32,cb33,cb34,cb35,cb36;
	 				BaseFont bf = BaseFont.createFont(BaseFont.HELVETICA, BaseFont.CP1252, BaseFont.NOT_EMBEDDED);
	 				
	 				/*cb2 = writer.getDirectContent();
					cb2.beginText();
	 				cb2.setFontAndSize(bf, 10);
	 				cb2.showTextAligned(PdfContentByte.ALIGN_LEFT, t, 400, 500, 0);
	 				cb2.endText();	*/
				
 	 				
 	 				/*PdfPTable nestedTable = new PdfPTable(1);	
 	 				float[] columnWidths = {.3f};
 	 				try {nestedTable.setWidths(columnWidths);}
 	 				catch(Exception e){ }
 	 				
 	 				
 	 				nestedTable.setTotalWidth(PageSize.A4.rotate().getWidth());
 	 				nestedTable.setLockedWidth(true);
 	 				nestedTable.setHorizontalAlignment(Element.ALIGN_TOP);
 	 				
 	 				nestedTable.setWidthPercentage(10);
 	 				PdfPCell cell2 = new PdfPCell(image1,true);
 	 				cell2.setBorder(0); 
 	 				nestedTable.addCell(cell2);
 	 				p.add(nestedTable); */
 	 				
 	 			
	 				
      	        }catch(Exception fe)
      	        {}
				
				try{ 		
					PdfPTable nestedTable = new PdfPTable(1);
	 				float[] columnWidths = {1f};
	 				try {nestedTable.setWidths(columnWidths);}
	 				catch(Exception e){  }
	     			
	 				nestedTable.setWidthPercentage(150);
	     		    PdfPTable complainttable =  shirttable(shirtData);	
	     			PdfPCell cell1 = new PdfPCell(new Paragraph());
	                cell1.addElement(complainttable);
	                cell1.setPaddingTop(10);
	                cell1.setBorder(0);
	                nestedTable.setHorizontalAlignment(Element.ALIGN_LEFT);
	                nestedTable.addCell(cell1);
	  	             p.add(nestedTable);
	  	            
			            }catch(Exception e) {
			            	e.printStackTrace();
			            }
	      			
				
				 p.add("\n");
				 
				 p.add("\n");
				 p.add("                      	Advance Amount:  	"+t5+"\n");
 		         
 		         p.add("\n");
 		         p.add("                      	Total Billing:  	"+t6+"\n");
		         
		         p.add("\n");
		         p.add("                      	Pending:  			"+t7+"\n");
		         
		         p.add("\n");
		         p.add("                      	Refunded:  			"+t8+"\n");
 		         
				
				document.add(p);
				
				document.close();
				writer.close();
				Desktop.getDesktop().open(new File("print.pdf"));
			}
			catch(Exception e)
			{
				JOptionPane.showMessageDialog(null, e);
			}
	}
	

	/**
	 * Create the dialog.
	 */
	public Demo() {
		setBounds(100, 100, 175, 147);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		
		btnNext = new JButton("Next");
		btnNext.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				String[] Data= AdmitPatient.printbutton3();
				
				printButton(Data);
				
				dialog.dispose();
				
				

				
			}
		});
		btnNext.setBounds(15, 30, 147, 29);
		contentPanel.add(btnNext);
	}
	
	public static PdfPTable shirttable(String []tablevalues){
		Font bfBold12 = new Font(FontFamily.COURIER, 10, Font.BOLD); 
		 Font bf12 = new Font(FontFamily.TIMES_ROMAN, 9); 
		 
      PdfPTable table = new PdfPTable(8); // 3 columns.
      table.setWidthPercentage(60); //Width 100%
      table.setHorizontalAlignment(Element.ALIGN_LEFT);//Space before table
      

      //Set Column widths
      float[] columnWidths = {.2f,.2f,.2f,.2f,.2f,.2f,.2f,.2f,.2f};
      try {
			table.setWidths(columnWidths);
		} catch (DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
    //create a new cell with the specified Text and Font
		  PdfPCell cell = new PdfPCell(new Phrase("Lab Report", bfBold12));
		  //set the cell alignment
		 
	         cell.setHorizontalAlignment(Element.ALIGN_LEFT);
	         cell.setVerticalAlignment(Element.ALIGN_LEFT);
		  //set the cell column span in case you want to merge two or more cells
		     cell.setColspan(9);
		    cell.setBorder(0);
		    table.addCell(cell);
		    //insert column headings
		    insertCell(table, "Sno", Element.ALIGN_RIGHT, 1, bfBold12);
		    insertCell(table, "Date", Element.ALIGN_LEFT, 1, bfBold12);
		    insertCell(table, "HB", Element.ALIGN_LEFT, 1, bfBold12);
		    insertCell(table, "Tlc", Element.ALIGN_LEFT, 1, bfBold12);
		    insertCell(table, "Creat", Element.ALIGN_LEFT, 1, bfBold12);
		    insertCell(table, "RBS", Element.ALIGN_LEFT, 1, bfBold12);
		    insertCell(table, "Ot_Pt", Element.ALIGN_LEFT, 1, bfBold12);
		    insertCell(table, "ALP", Element.ALIGN_LEFT, 1, bfBold12);
		    insertCell(table, "TBili", Element.ALIGN_LEFT, 1, bfBold12);
		    
		    for(int i=0;i<tablevalues.length;i++){
		   	
		    insertCell(table, tablevalues[i], Element.ALIGN_RIGHT, 1, bf12);
		    }
		    
      return table;
 }
	

	
	private static void insertCell(PdfPTable table, String text, int align, int colspan, Font font){
		   
		  //create a new cell with the specified Text and Font
		  PdfPCell cell = new PdfPCell(new Phrase(text.trim(), font));
		  //set the cell alignment
		  cell.setHorizontalAlignment(align);
	        cell.setHorizontalAlignment(Element.ALIGN_LEFT);
	         cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
		  //set the cell column span in case you want to merge two or more cells
		  cell.setColspan(colspan);
		  //in case there is no text and you wan to create an empty row
		  if(text.trim().equalsIgnoreCase("")){
		   cell.setMinimumHeight(77f);
		  }
		  //add the call to the table
		  table.addCell(cell);
		   
		 }
	 	
}
