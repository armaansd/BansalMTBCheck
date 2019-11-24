import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.AbstractAction;
import javax.swing.ImageIcon;
import javax.swing.InputMap;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JPanel;
import javax.swing.JRootPane;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import net.proteanit.sql.DbUtils;

import javax.swing.JTable;
import javax.swing.KeyStroke;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Image;
import java.awt.SystemColor;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class image_record extends JDialog {

	private final JPanel contentPanel = new JPanel();
	int col;
	DefaultTableModel model = 	new DefaultTableModel();
	static String s,s1;
	int id,k;
	String sid;
	String col_name;
	String entryy;
	DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd-MM-yyyy");
	Connection conn1 = null;
	private JTable table;
	
	JLabel lblNewLabel,lblNewLabel_1;
	String filename = null;
	Connection conn = null;
	byte[] CR = null;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		
		s = args[0];
		
		try {
			image_record dialog = new image_record();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	
	
	protected JRootPane createRootPane() { 
	    JRootPane rootPane = new JRootPane();
	    KeyStroke stroke = KeyStroke.getKeyStroke("ESCAPE");
	    AbstractAction actionListener = new AbstractAction() { 
	      public void actionPerformed(ActionEvent actionEvent) { 
	       
	    	  
	    		
	    	  String s[] = {"ss"};
	    	  AdmitPatient.main(s);
	    	  setVisible(false);
	        
	        

	      } 
	    } ;
	    InputMap inputMap = rootPane.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
	    inputMap.put(stroke, "ESCAPE");
	    rootPane.getActionMap().put("ESCAPE", actionListener);

	    return rootPane;
	  } 
	public image_record() {
		setBounds(100, 100, 865, 551);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			{
				model = new DefaultTableModel();
			}
		}
		{
			lblNewLabel = new JLabel("");
			lblNewLabel.setText(s);
			lblNewLabel.setForeground(new Color(32, 178, 170));
			lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
			lblNewLabel.setBounds(10, 11, 270, 38);
			contentPanel.add(lblNewLabel);
			
			
			lblNewLabel_1 = new JLabel("Browse");
			lblNewLabel_1.setBounds(10, 113, 390, 348);
			contentPanel.add(lblNewLabel_1);
			
			JScrollPane scrollPane = new JScrollPane();
			scrollPane.setBounds(452, 113, 387, 355);
			contentPanel.add(scrollPane);
			
			table = new JTable();
			table.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent arg0) {
					
					
					int i = table.getSelectedRow();
					try{
						conn1 =DriverManager.getConnection("jdbc:sqlite:print.sqlite");
						String query="select image from '"+s+"' where Sno = '"+table.getValueAt(i, 0).toString()+"' ";
						PreparedStatement pst=conn1.prepareStatement(query);
						ResultSet rs=pst.executeQuery();
						
							byte[] img = rs.getBytes("image");
							ImageIcon image = new ImageIcon(img);
							Image im = image.getImage();
							Image myimg = im.getScaledInstance(lblNewLabel_1.getWidth(), lblNewLabel_1.getHeight(), Image.SCALE_SMOOTH);
							ImageIcon newImage = new ImageIcon(myimg);
							lblNewLabel_1.setIcon(newImage);
					}
					catch(Exception ee)
					{
						
						ee.printStackTrace();
					}
					
				}
			});
			scrollPane.setViewportView(table);
			
			JButton btnNewButton = new JButton("Browse and Save");
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					
					JFileChooser chooser = new JFileChooser();
					chooser.showOpenDialog(null);
					File f = chooser.getSelectedFile();
					filename = f.getAbsolutePath();
					ImageIcon imageIcon = new ImageIcon(new ImageIcon(filename).getImage().getScaledInstance(lblNewLabel_1.getWidth(),lblNewLabel_1.getHeight(),Image.SCALE_SMOOTH));
					lblNewLabel_1.setIcon(imageIcon);
					
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
					catch(Exception ee)
					{
						JOptionPane.showMessageDialog(null, ee);
					}
					
					String date;
					LocalDateTime now = LocalDateTime.now();
					date = dtf.format(now);

					try{
						conn1 =DriverManager.getConnection("jdbc:sqlite:print.sqlite");
						String query="Select Sno from '"+s+"' ";
						PreparedStatement pst=conn1.prepareStatement(query);
						ResultSet rs=pst.executeQuery();
						while(rs.next())
						{
							id=rs.getInt("Sno");
						}
						sid=String.valueOf((id+1));
						rs.close();
						pst.close();
					}
					catch(Exception ee)
					{
						ee.printStackTrace();
					}
					
					try{
						conn1 =DriverManager.getConnection("jdbc:sqlite:print.sqlite");
						String query="insert into '"+s+"'(Sno,Date,image) values(?,?,?) ";
						PreparedStatement pst=conn1.prepareStatement(query);
						pst.setString(1, sid);
						pst.setString(2, date);
						pst.setBytes(3, CR);
						pst.execute();
						JOptionPane.showMessageDialog(null, "Data Saved !");
						pst.close();
						
					}
					catch(Exception ee)
					{
						ee.printStackTrace();
					}
					
					
					
					try
					{
																			
						conn1 =DriverManager.getConnection("jdbc:sqlite:print.sqlite"); 
						String query= "select *  from   '"+s+"' ";
						PreparedStatement statement= conn1.prepareStatement(query);
						ResultSet rs=statement.executeQuery();
						table.setModel(DbUtils.resultSetToTableModel(rs));
						rs.close();
						statement.close();				
						rs.close();
						
					}

					catch(SQLException e1)
					{
							e1.printStackTrace();
					
					}
					
					catch(Exception eee){
						
						eee.printStackTrace();
					
					}
					
					
				}
			});
			btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 18));
			btnNewButton.setBounds(10, 472, 200, 29);
			contentPanel.add(btnNewButton);
			data1();
		}
	}
	public void data1()
	{
		
		
			String date;
			LocalDateTime now = LocalDateTime.now();
			date = dtf.format(now);
				
		try
		{
																
			conn1 =DriverManager.getConnection("jdbc:sqlite:print.sqlite"); 
			String query= "select *  from   '"+s+"' ";
			PreparedStatement statement= conn1.prepareStatement(query);
			ResultSet rs=statement.executeQuery();
			table.setModel(DbUtils.resultSetToTableModel(rs));
			rs.close();
			statement.close();				
			rs.close();
			
		}

		catch(SQLException e1)
		{
				e1.printStackTrace();
		
		}
		
		catch(Exception eee){
			
			eee.printStackTrace();
		
		}
		
		
		try{
			conn1 =DriverManager.getConnection("jdbc:sqlite:print.sqlite");  
			String query="Select Sno from "+s+" ";
			PreparedStatement pst=conn1.prepareStatement(query);
			ResultSet rs=pst.executeQuery();
			while(rs.next())
			{
				id=rs.getInt("Sno");
			}
			sid=String.valueOf((id+1));
			rs.close();
			pst.close();
		}
		catch(Exception ee)
		{
			ee.printStackTrace();
		}
		
		
		
		
		
		
	}
}
