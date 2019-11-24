import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dialog;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Image;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JRootPane;
import javax.swing.JScrollBar;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

import net.proteanit.sql.DbUtils;

import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JComboBox;
import javax.swing.JComponent;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.InputMap;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.KeyStroke;
import javax.swing.UIManager;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.print.PrinterException;

import javax.swing.JCheckBox;
import javax.swing.SwingConstants;

public class salllery extends JDialog {

	private final JPanel contentPanel = new JPanel();
	DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd-MM-yyyy");
	String da;
	private static JTable table;
	private JTextField date;
	private JTextField pf;
	private JTextField ta;
	private JTextField name;
	private JLabel lblNewLabel;
	private JLabel lblNarration;
	Dialog dialog;
	private Object[] rows;
	DefaultTableModel model;
	String s,t;
	String gg;
	Double cre = 0.0;
	Double deb = 0.0;
	double cbala;
	private JLabel lblName;
	private JTextField daila;
	private JTextField sallery;
	private JTextField amt;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		
		try
		{
			UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
		}
		catch(Exception e)
		{
			
		}
		
		try {
			salllery dialog = new salllery();
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
	       
	    	  
	    		
	    	  String s[] = {"admin"};
	    	  MainPage.main(s);
	        

	      } 
	    } ;
	    InputMap inputMap = rootPane.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
	    inputMap.put(stroke, "ESCAPE");
	    rootPane.getActionMap().put("ESCAPE", actionListener);

	    return rootPane;
	  } 

	public salllery() {
		setTitle("Account Section");
		setBounds(100, 1, 1230, 917);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		//Image Imgh=new ImageIcon(this.getClass().getResource("/logo.png")).getImage();
	   	//setIconImage(Imgh);
		
		
		
		JScrollPane scrollPane = new JScrollPane();
		
		scrollPane.setBounds(12, 120, 1202, 382);
		contentPanel.add(scrollPane);
		
		
		model = new DefaultTableModel();
		rows = new Object[9];
		Object[] columns={"Date","Party","Credit","Debit","Narration","Cash Type","CBalance","Day","Tally",};
		
		model.setColumnIdentifiers(columns);
		
		table = new JTable();
		JTableHeader anHeader = table.getTableHeader();
	    anHeader.setForeground(new Color(0).black);
	    anHeader.setFont(new Font("Tahoma", Font.BOLD, 14));
	    anHeader.setBackground(new Color(0).black);
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				if(e.getClickCount() == 2)
				{
				int i = table.getSelectedRow();
				String v = table.getValueAt(i, 1).toString();
				String v1 = table.getValueAt(i, 6).toString();
				
				v = v1.concat(v);
				
				salllery dialog = new salllery();
				
				/*setVisible(false);
				String arr[]={v};
				view.main(arr);*/
				
				
				
				}
			}
		});
		
		table.setModel(model);
		table.setBounds(10, 11, 666, 194);
		table.setSelectionForeground(new Color(255, 255, 255));
		table.setSelectionBackground(new Color(0, 0, 128));
		table.setFont(new Font("Tahoma", Font.BOLD, 16));
		table.setRowHeight(30);
		scrollPane.setViewportView(table);
		
		JScrollBar sb = scrollPane.getVerticalScrollBar();
		sb.setValue( sb.getMaximum() );
		
		
		LocalDateTime now = LocalDateTime.now();
		da = dtf.format(now);
		date = new JTextField();
		date.setHorizontalAlignment(SwingConstants.CENTER);
		date.setFont(new Font("Tahoma", Font.BOLD, 20));
		date.setText(da);
		date.setBounds(15, 510, 159, 37);
		contentPanel.add(date);
		date.setColumns(10);
		
		pf = new JTextField();
		pf.setFont(new Font("Tahoma", Font.BOLD, 16));
		
		pf.setColumns(10);
		pf.setBounds(373, 573, 116, 37);
		contentPanel.add(pf);
		
		ta = new JTextField();
		ta.setFont(new Font("Tahoma", Font.BOLD, 16));
		
		ta.setColumns(10);
		ta.setBounds(635, 573, 116, 37);
		contentPanel.add(ta);
		
		name = new JTextField();
		name.setFont(new Font("Tahoma", Font.BOLD, 12));
		name.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				
				
				if(e.getKeyCode()==KeyEvent.VK_ENTER)
				{
					pf.requestFocusInWindow();
					
				}
				
			}
		});
		name.setColumns(10);
		name.setBounds(14, 573, 202, 37);
		contentPanel.add(name);
		
		lblNewLabel = new JLabel("TA");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel.setBounds(632, 549, 116, 16);
		contentPanel.add(lblNewLabel);
		
		lblNarration = new JLabel("PF");
		lblNarration.setHorizontalAlignment(SwingConstants.CENTER);
		lblNarration.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNarration.setBounds(334, 552, 196, 16);
		contentPanel.add(lblNarration);
		
		lblName = new JLabel("Name");
		lblName.setHorizontalAlignment(SwingConstants.CENTER);
		lblName.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblName.setBounds(4, 551, 196, 16);
		contentPanel.add(lblName);
		
		JLabel lblDa = new JLabel("DA");
		lblDa.setHorizontalAlignment(SwingConstants.CENTER);
		lblDa.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblDa.setBounds(469, 550, 196, 16);
		contentPanel.add(lblDa);
		
		daila = new JTextField();
		daila.setFont(new Font("Tahoma", Font.BOLD, 16));
		daila.setColumns(10);
		daila.setBounds(510, 573, 116, 37);
		contentPanel.add(daila);
		
		JLabel lblSallery = new JLabel("Sallery");
		lblSallery.setHorizontalAlignment(SwingConstants.CENTER);
		lblSallery.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblSallery.setBounds(205, 549, 196, 16);
		contentPanel.add(lblSallery);
		
		sallery = new JTextField();
		sallery.setFont(new Font("Tahoma", Font.BOLD, 12));
		sallery.setColumns(10);
		sallery.setBounds(228, 573, 137, 37);
		contentPanel.add(sallery);
		
		JLabel lblAmount = new JLabel("Amount");
		lblAmount.setHorizontalAlignment(SwingConstants.CENTER);
		lblAmount.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblAmount.setBounds(761, 547, 116, 16);
		contentPanel.add(lblAmount);
		
		amt = new JTextField();
		amt.setFont(new Font("Tahoma", Font.BOLD, 16));
		amt.setColumns(10);
		amt.setBounds(771, 573, 116, 37);
		contentPanel.add(amt);
		
		JButton btnNewButton = new JButton("Save");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					Connection conn1 =DriverManager.getConnection("jdbc:sqlite:print.sqlite"); 
					String query = "Insert into  sallery (date,name,sallery,pf,da,ta,amount) values(?,?,?,?,?,?,?) ";
					PreparedStatement pst = conn1.prepareStatement(query);
					pst.setString(1, date.getText());
					pst.setString(2, name.getText());
					pst.setString(3, sallery.getText());
					pst.setString(4, pf.getText());
					pst.setString(5, daila.getText());
					pst.setString(6, ta.getText());
					pst.setString(7, amt.getText());
					
					pst.execute();
					pst.close();
					
					
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				try
				{
																		
					Connection conn1 =DriverManager.getConnection("jdbc:sqlite:print.sqlite");
					String query= "select *  from  sallery ";
					PreparedStatement statement= conn1.prepareStatement(query);
					ResultSet rs=statement.executeQuery();
					table.setModel(DbUtils.resultSetToTableModel(rs));
					rs.close();
					statement.close();
					
				}
				catch(SQLException e1)
				{
						e1.printStackTrace();
				}
				
			}
		});
		btnNewButton.setBounds(761, 622, 117, 29);
		contentPanel.add(btnNewButton);
		
		
		
		try
		{
																
			Connection conn1 =DriverManager.getConnection("jdbc:sqlite:print.sqlite");
			String query= "select *  from  sallery ";
			PreparedStatement statement= conn1.prepareStatement(query);
			ResultSet rs=statement.executeQuery();
			table.setModel(DbUtils.resultSetToTableModel(rs));
			rs.close();
			statement.close();
			
		}
		catch(SQLException e1)
		{
				e1.printStackTrace();
		}
		
	}
	
	public void sum()
	{
		cre = 0.0;
		deb = 0.0;
		for(int i = 0; i < model.getRowCount(); i++)
		{
			cre = cre + Double.parseDouble(model.getValueAt(i, 2).toString());
			deb = deb + Double.parseDouble(model.getValueAt(i, 3).toString());
		}	
		
		
		Double tot = 0.0;
		tot = cre - deb;
		tot = Math.abs(tot);
		if(tot<0.0)
		{
			//JOptionPane.showMessageDialog(null, " g");
		daila.setForeground(new Color(255, 0, 0));	
		daila.setText(String.valueOf(tot));
		
		}
		else if(tot>0.0)
		{
			JOptionPane.showMessageDialog(null, " gg");
			daila.setForeground(new Color(0, 0, 205));	
			daila.setText(String.valueOf(tot));

		}	
	}
	
	public static String[] printbutton3()
	{
		int tablerow1= table.getRowCount();
		//JOptionPane.showMessageDialog(null, tablerow1);
		String [] table_1valueslenghth=new String[5*tablerow1];
		//JOptionPane.showMessageDialog(null, tablerow1*4);
		for(int i=0;i<tablerow1*7;i++)
		{
			table_1valueslenghth[i]=	(String) table.getValueAt(i/7, 0);
			//JOptionPane.showMessageDialog(null, table_1valueslenghth[i]);
			table_1valueslenghth[i+1] =(String)  table.getValueAt(i/7, 1);
			//JOptionPane.showMessageDialog(null, table_1valueslenghth[i+1]);
			table_1valueslenghth[i+2]=	(String) table.getValueAt(i/7, 2).toString();
			//JOptionPane.showMessageDialog(null, table_1valueslenghth[i+2]);
			table_1valueslenghth[i+3]=	(String) table.getValueAt(i/7, 3).toString();
			//JOptionPane.showMessageDialog(null, table_1valueslenghth[i+3]);
			table_1valueslenghth[i+4]=	(String) table.getValueAt(i/7, 4);
			//JOptionPane.showMessageDialog(null, table_1valueslenghth[i+4]);
			table_1valueslenghth[i+5]=	(String) table.getValueAt(i/7, 5);
			
			table_1valueslenghth[i+6]=	(String) table.getValueAt(i/7, 6);
			i=i+6;
		}
		return table_1valueslenghth;
	}
}
