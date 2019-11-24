

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import java.awt.GraphicsEnvironment;
import javax.swing.border.BevelBorder;

public class start extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private final JLabel lblNewLabel = new JLabel("New label");
	static start frame;
	// Launch the application.
	 
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
				frame	 = new start();
                frame.setUndecorated(true);
			    frame.setVisible(true);

					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public start() {
		setUndecorated(true);
//		Image Imgh=new ImageIcon(this.getClass().getResource("/LOGO.png")).getImage();
    	
    //	setIconImage(Imgh);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(700, 700, 513, 506);
		setLocation(GraphicsEnvironment.getLocalGraphicsEnvironment().getCenterPoint().x-451/2,GraphicsEnvironment.getLocalGraphicsEnvironment().getCenterPoint().y-454/2);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(0, 0, 0), new Color(255, 255, 255), Color.WHITE, new Color(255, 255, 255)));
		setContentPane(contentPane);

		
			setBackground(new Color(255, 255, 255));
	
			getContentPane().setLayout(null);
			contentPane.setLayout(null);
			
			final JProgressBar progressBar = new JProgressBar();
			progressBar.setForeground(new Color(0, 255, 0));
			
		
			Thread clock=new Thread()
			{

		
			public void run()
			{
				try {
					for(int i=0;i<=110;i++)
					{progressBar.setValue(i);
					
					sleep(50);
					
					}
					setVisible(false);
					String s[] = {"s"};
					login.main(s);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			};
		    clock.start();
			progressBar.setBounds(16, 449, 490, 14);
			getContentPane().add(progressBar);
			lblNewLabel.setBackground(new Color(255, 255, 255));
			lblNewLabel.setBounds(12, -32, 346, 36);
			contentPane.add(lblNewLabel);
       			
			JLabel label = new JLabel("");
			Image img1=new ImageIcon(this.getClass().getResource("/splash.jpg")).getImage();
			label.setIcon( new ImageIcon(img1));
			label.setBounds(10, 6, 505, 496);
			contentPane.add(label);
	}
}
/*
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import net.proteanit.sql.DbUtils;

import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.security.auth.RefreshFailedException;
import javax.security.auth.Refreshable;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import javax.swing.border.TitledBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JList;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;
import java.awt.Color;
import javax.swing.table.DefaultTableModel;
import javax.swing.ListSelectionModel;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JSeparator;
import javax.swing.JProgressBar;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import javax.swing.JScrollBar;
import java.awt.event.AdjustmentListener;
import java.awt.event.AdjustmentEvent;
import javax.swing.JPopupMenu;
import java.awt.Component;
import javax.swing.UIManager;
import javax.swing.JCheckBox;
import java.awt.SystemColor;

/*public class employee extends JFrame {

	private JPanel contentPane;
    private JComboBox comboBox;
	private JList list;
	private JComboBox comboBox_1;
    /**
	 
	 * 
	 * Launch the application.
	 
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					employee frame = new employee();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 Connection connection=null;
	private JTextField Id;
	private JTextField Name;
	private JTextField Address;
	private JButton btnUpdate;
	private JTable table;
	private JTextField textField;
	private JScrollPane scrollPane_1;
	private   JPanel panel_1;
	private   JPanel panel_2;
	private JTextField reg;
	private JTextField age;
	private JTextField city;
	private JTextField contact;
	private JTextField doctor;
	private JTextField date;
	 private JComboBox comboBox_2 ;
	 private JComboBox health;
	public void fillcombobox()
	{   
	/*	try{
			comboBox.removeAllItems();
			String query="select * from   empollyee;";
			PreparedStatement pst=connection.prepareStatement(query);
			ResultSet rs=pst.executeQuery();
			while(rs.next())
			{
			   comboBox.addItem(rs.getString("name"));
			} 
			pst.close();
			rs.close();
		}
		catch(Exception e){
			JOptionPane.showMessageDialog(null, e);
		}

		
	}
	public void RefreshTable() {
		
	/*		try{
				String query="select * from   empollyee;";
				PreparedStatement pst=connection.prepareStatement(query);
				ResultSet rs=pst.executeQuery();
				table.setModel(DbUtils.resultSetToTableModel(rs));
				pst.close();
				rs.close();
			}
			catch(Exception e){
				JOptionPane.showMessageDialog(null, e);
			}
			

	}
     public void RefreshList()
     {
  	 try{
				DefaultListModel DLM=new DefaultListModel();
				//DLM.addElement("waheguru");
				//list.setModel(DLM);

				String query="select * from   Record ;";
				PreparedStatement pst=connection.prepareStatement(query);
				
				ResultSet rs=pst.executeQuery();
				
				while(rs.next())
				{
				  
				   DLM.addElement(rs.getString("Name"));
				   list.setModel(DLM);
				}
				list.setModel(DLM);
				pst.close();
				rs.close();
			}
			catch(Exception e){
				JOptionPane.showMessageDialog(null, e);
			}

     }
	
	public employee() {
		
		connection =sqliteconnection.dbconnector();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1218, 780);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnFile = new JMenu("File");
		menuBar.add(mnFile);
		
		JMenu mnNew = new JMenu("New");
		mnFile.add(mnNew);
		
		JSeparator separator = new JSeparator();
		mnFile.add(separator);
		
		JMenuItem mntmOpen = new JMenuItem("Open");
		mnFile.add(mntmOpen);
		
		JMenuItem mntmExit = new JMenuItem("Exit                            ");
		mntmExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(JFrame.EXIT_ON_CLOSE);
			}
		});
		mnFile.add(mntmExit);
		
		JMenu mnEdit = new JMenu("Edit");
		menuBar.add(mnEdit);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		Id = new JTextField();
		Id.setBounds(616, 87, 116, 22);
		contentPane.add(Id);
		Id.setColumns(10);
		
		JLabel lblId = new JLabel("Id");
		lblId.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblId.setBounds(562, 89, 38, 16);
		contentPane.add(lblId);
		
		comboBox = new JComboBox();
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try{
					String query="select * from   empollyee where name=?;";
					PreparedStatement pst=connection.prepareStatement(query);
					pst.setString(1, (String)comboBox.getSelectedItem());
					ResultSet rs=pst.executeQuery();
					
					while(rs.next())
					{
					   Id.setText(rs.getString("id"));
					   Name.setText(rs.getString("Name"));
					   Address.setText(rs.getString("Address"));
					}
					pst.close();
					rs.close();
				}
				catch(Exception e){
					JOptionPane.showMessageDialog(null, e);
				}

				
			}
		});
		comboBox.setBounds(12, 101, 191, 33);
		contentPane.add(comboBox);
		
		JButton btnLoadList = new JButton("Load List");
		btnLoadList.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try{
					DefaultListModel DLM=new DefaultListModel();
					//DLM.addElement("waheguru");
					//list.setModel(DLM);

					String query="select * from   Record ;";
					PreparedStatement pst=connection.prepareStatement(query);
					
					ResultSet rs=pst.executeQuery();
					
					while(rs.next())
					{
					  
					   DLM.addElement(rs.getString("Name"));
					   list.setModel(DLM);
					}
					pst.close();
					rs.close();
				}
				catch(Exception e){
					JOptionPane.showMessageDialog(null, e);
				}


			}
		});
		btnLoadList.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnLoadList.setBounds(915, 176, 127, 25);
		contentPane.add(btnLoadList);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(1082, 90, 78, 380);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
		/*		try{
		 		    int row=table.getSelectedRow();
		 			String Id_= (table.getModel().getValueAt(row, 0)).toString();
		 			  
		 			String query="select * from   empollyee where id='"+Id_+"';";
		 			PreparedStatement pst=connection.prepareStatement(query);
		 			
		 			ResultSet rs=pst.executeQuery();
		 			
		 			while(rs.next())
		 			{
		 			   Id.setText(rs.getString("id"));
		 			   Name.setText(rs.getString("Name"));
		 			   Address.setText(rs.getString("Address"));
		 			}
		 			pst.close();
		 			rs.close();
		 		}
		 		catch(Exception e){
		 			JOptionPane.showMessageDialog(null, e);
		 		}		
		 
			}
		});
		scrollPane.setViewportView(table);
		
		JScrollBar scrollBar = new JScrollBar();
		scrollPane.setColumnHeaderView(scrollBar);
		
		JScrollBar scrollBar_1 = new JScrollBar();
		scrollPane.setColumnHeaderView(scrollBar_1);
		scrollBar_1.addAdjustmentListener(new AdjustmentListener() {
			public void adjustmentValueChanged(AdjustmentEvent arg0) {
				
			}
		});
		 
		 scrollPane_1 = new JScrollPane();
		 scrollPane_1.setBounds(876, 226, 194, 322);
		 contentPane.add(scrollPane_1);
		 
		  list = new JList();
		  scrollPane_1.setViewportView(list);
		  list.addMouseListener(new MouseAdapter() {
		  	@Override
		  	public void mouseClicked(MouseEvent arg0) {
		  		try{
		  		    int row=list.getSelectedIndex();
		  			String Name_= (list.getModel().getElementAt(row)).toString();
		  			  
		  			String query="select * from   Record where Name='"+Name_+"';";
		  			PreparedStatement pst=connection.prepareStatement(query);
		  			
		  			ResultSet rs=pst.executeQuery();
		  			
		  			while(rs.next())
		  			{
		  			   reg.setText(rs.getString("id"));
		  			   Name.setText(rs.getString("Name"));
		  			   age.setText(rs.getString("Age"));
		/*  			   comboBox_2.set(rs.getString("Name"));
		  			   Name.setText(rs.getString("Name"));
		  			   Name.setText(rs.getString("Name"));
		  			   Name.setText(rs.getString("Name"));
		  			   Name.setText(rs.getString("Name"));
		  			   Name.setText(rs.getString("Name"));
		  			   Name.setText(rs.getString("Name"));
		  			   Name.setText(rs.getString("Name"));
		  			   
		  			   Address.setText(rs.getString("Address"));
		  			   
		  				String query ="insert into Record (id,name,age,sex,address,city,contact,doctor,date) values(   ?,?,?,?,?,?,?,?,?)";
			  			PreparedStatement pst=connection.prepareStatement(query);
			  			pst.setString(1, reg.getText());
			  			pst.setString(2,Name.getText() );
			  			pst.setString(3, age.getText()); 
			  				pst.setString(5, Address.getText());
			  					pst.setString(4, (String)comboBox_2.getSelectedItem());
			  						
			  							pst.setString(6, city.getText());
			  								pst.setString(7, contact.getText());
			  									pst.setString(8, doctor.getText());
			  									pst.setString(9, date.getText());
	  									
		  			}
		  			pst.close();
		  			rs.close();
		  		}
		  		catch(Exception e){
		  			JOptionPane.showMessageDialog(null, e);
		  		}		
		  	}
		  });
		  list.setFont(new Font("Tahoma", Font.BOLD, 17));
	      
		
		 

		 textField = new JTextField();
		 textField.addKeyListener(new KeyAdapter() {
		 	@Override
		 	public void keyReleased(KeyEvent arg0) {
		 		try{
		 			 String selected=(String)  comboBox_1.getSelectedItem();
					String query="select * from   empollyee where "+selected+"= '"+textField.getText()+"';";
					PreparedStatement pst=connection.prepareStatement(query);
					ResultSet rs=pst.executeQuery();
					table.setModel(DbUtils.resultSetToTableModel(rs));
					pst.close();
					rs.close();
				}
				catch(Exception e){
					JOptionPane.showMessageDialog(null, e);
				}
			
		 	}
		 });
		 
		 textField.setBounds(806, 82, 200, 33);
		 contentPane.add(textField);
		 textField.setColumns(10);
		 
		 comboBox_1 = new JComboBox();
		 comboBox_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		 comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"Id", "Name", "Address", "Password"}));

		 comboBox_1.setBounds(828, 123, 157, 27);
		 contentPane.add(comboBox_1);
		  
		  btnUpdate = new JButton("update");
		  btnUpdate.setBounds(31, 268, 147, 41);
		  contentPane.add(btnUpdate);
		  btnUpdate.addActionListener(new ActionListener() {
		  	public void actionPerformed(ActionEvent arg0) {
		  /*		try{
		  			String query="update empollyee set name='"+Name.getText()+"',address='"+Address.getText()+"' where id="+Id.getText()+";";
		  			PreparedStatement pst=connection.prepareStatement(query);
		  			
		  		   pst.execute();
		  			 JOptionPane.showMessageDialog(null,"Data updated");
		  			 pst.close();
		  			
		  		}
		  		catch(Exception e)
		  		{
	               JOptionPane.showMessageDialog(null, e);				
		  		}
		  		RefreshTable();
		  		fillcombobox();
		  		RefreshList();
		  	}
		  });
		  btnUpdate.setFont(new Font("Tahoma", Font.BOLD, 17));
		  
		  JButton btnNewButton = new JButton("Delete");
		  btnNewButton.setBounds(31, 384, 147, 41);
		  contentPane.add(btnNewButton);
		  btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 17));
		  
		  
		  

		  
		  JButton btnLoadEmployeeData = new JButton("Table");
		  btnLoadEmployeeData.setBounds(31, 324, 147, 41);
		  contentPane.add(btnLoadEmployeeData);
		  btnLoadEmployeeData.addActionListener(new ActionListener() {
		  	public void actionPerformed(ActionEvent arg0) {
		  /*		try{
		  			String query="select * from   empollyee;";
		  			PreparedStatement pst=connection.prepareStatement(query);
		  			ResultSet rs=pst.executeQuery();
		  			table.setModel(DbUtils.resultSetToTableModel(rs));
		  			pst.close();
		  			rs.close();
		  		}
		  		catch(Exception e){
		  			JOptionPane.showMessageDialog(null, e);
		  		}
		  		
		  	}}
		  });
		  btnLoadEmployeeData.setFont(new Font("Tahoma", Font.BOLD, 15));
		  
		  JPanel panel_7 = new JPanel();
		  panel_7.setBounds(91, 45, 56, -35);
		  contentPane.add(panel_7);
		  panel_7.setLayout(null);
		  
		  JPanel panel_4 = new JPanel();
		  panel_4.setBorder(new TitledBorder(null, " ", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		  panel_4.setBounds(256, 142, 614, 574);
		  contentPane.add(panel_4);
		  panel_4.setLayout(null);
		  
		   panel_1 = new JPanel();
		   panel_1.setBounds(6, 18, 602, 549);
		   panel_4.add(panel_1);
		   
		   panel_1.setBackground(UIManager.getColor("Panel.background"));
		   panel_1.setVisible(false);
		  panel_1.setLayout(null);
		  
		  Name = new JTextField();
		  Name.setBounds(168, 123, 310, 21);
		  panel_1.add(Name);
		  Name.setColumns(10);
		  
		  Address = new JTextField();
		  Address.setBounds(130, 277, 399, 22);
		  panel_1.add(Address);
		  Address.setColumns(10);
		  
		  reg = new JTextField();
		  reg.setBounds(102, 57, 177, 22);
		  panel_1.add(reg);
		  reg.setColumns(10);
		  
		  JLabel lblNewLabel = new JLabel("Reg. No");
		  lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		  lblNewLabel.setBounds(34, 58, 67, 19);
		  panel_1.add(lblNewLabel);
		  
		  JLabel lblAge = new JLabel("Age   :");
		  lblAge.setFont(new Font("Tahoma", Font.BOLD, 16));
		  lblAge.setBounds(35, 158, 95, 22);
		  panel_1.add(lblAge);
		  
		  age = new JTextField();
		  age.setBounds(131, 158, 116, 22);
		  panel_1.add(age);
		  age.setColumns(10);
		  
		  JLabel lblSex = new JLabel("Sex  :");
		  lblSex.setFont(new Font("Tahoma", Font.BOLD, 16));
		  lblSex.setBounds(45, 213, 56, 16);
		  panel_1.add(lblSex);
		  
		   comboBox_2 = new JComboBox();
		   comboBox_2.setModel(new DefaultComboBoxModel(new String[] {"Male","female"}));
		  comboBox_2.setBounds(130, 212, 117, 21);
		  panel_1.add(comboBox_2);
		  
		  JLabel lblNewLabel_2 = new JLabel("Date  :");
		  lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 15));
		  lblNewLabel_2.setBounds(320, 52, 123, 29);
		  panel_1.add(lblNewLabel_2);
		  
		  JPanel panel_3 = new JPanel();
		 
		  panel_3.setBounds(12, 18, 578, 518);
		  panel_1.add(panel_3);
		  panel_3.setLayout(null);
		  
		  JSeparator separator_2 = new JSeparator();
		  separator_2.setBounds(0, 76, 557, 2);
		  panel_3.add(separator_2);
		  
		  JSeparator separator_3 = new JSeparator();
		  separator_3.setBounds(12, 232, 545, 9);
		  panel_3.add(separator_3);
		  
		  JSeparator separator_4 = new JSeparator();
		  separator_4.setBounds(0, 407, 557, 2);
		  panel_3.add(separator_4);
		  
		  JLabel lblAddress = new JLabel("Address  :");
		  lblAddress.setBounds(22, 262, 81, 16);
		  panel_3.add(lblAddress);
		  lblAddress.setFont(new Font("Tahoma", Font.BOLD, 16));
		  
		  JLabel lblCity = new JLabel("City  :");
		  lblCity.setBounds(31, 310, 56, 16);
		  panel_3.add(lblCity);
		  lblCity.setFont(new Font("Tahoma", Font.BOLD, 16));
		  
		  JLabel lblNewLabel_1 = new JLabel("Contact No.  :");
		  lblNewLabel_1.setBounds(12, 352, 111, 16);
		  panel_3.add(lblNewLabel_1);
		  lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		  
		  city = new JTextField();
		  city.setBounds(109, 308, 193, 22);
		  panel_3.add(city);
		  city.setColumns(10);
		  
		  contact = new JTextField();
		  contact.setBounds(129, 350, 116, 22);
		  panel_3.add(contact);
		  contact.setColumns(10);
		  
		  date = new JTextField();
		  date.setBounds(376, 40, 116, 22);
		  panel_3.add(date);
		  date.setColumns(10);
		   comboBox_2.setModel(new DefaultComboBoxModel(new String[] {"Male","female"}));
		   
		   JLabel lblName = new JLabel("Patient's Name  :");
		   lblName.setBounds(12, 105, 140, 22);
		   panel_3.add(lblName);
		   lblName.setFont(new Font("Tahoma", Font.BOLD, 16));
		   
		   JPanel panel_5 = new JPanel();
		   panel_5.setBounds(0, 0, 578, 518);
		   panel_3.add(panel_5);
		   panel_5.setLayout(null);
		   
		   JButton btnSave = new JButton("Save");
		   btnSave.setBounds(169, 480, 78, 25);
		   panel_5.add(btnSave);
		   btnSave.addActionListener(new ActionListener() {
		   	public void actionPerformed(ActionEvent arg0) {
		   	   try{
		   			String query ="insert into Record (id,name,age,sex,address,city,contact,doctor,date) values(   ?,?,?,?,?,?,?,?,?)";
		   			PreparedStatement pst=connection.prepareStatement(query);
		   			pst.setString(1, reg.getText());
		   			pst.setString(2,Name.getText() );
		   			pst.setString(3, age.getText()); 
		   				pst.setString(5, Address.getText());
		   					pst.setString(4, (String)comboBox_2.getSelectedItem());
		   						
		   							pst.setString(6, city.getText());
		   								pst.setString(7, contact.getText());
		   									pst.setString(8, doctor.getText());
		   									pst.setString(9, date.getText());
		   									//	pst.setString(10, age.getText());
		   			pst.execute();
		   			 JOptionPane.showMessageDialog(null,"Data Saved");
		   			 pst.close();
		   			
		   		}
		   		catch(Exception e)
		   		{
	               JOptionPane.showMessageDialog(null, e);				
		   		}
		   		RefreshList();
	//	  		RefreshTable();
		//fillcombobox();
		   	}
		   });
		   btnSave.setFont(new Font("Tahoma", Font.BOLD, 18));
		   
		   JLabel lblDoctor = new JLabel("Doctor");
		   lblDoctor.setBounds(26, 422, 67, 16);
		   panel_5.add(lblDoctor);
		   lblDoctor.setFont(new Font("Tahoma", Font.BOLD, 16));
		   
		   doctor = new JTextField();
		   doctor.setBounds(94, 430, 185, 22);
		   panel_5.add(doctor);
		   doctor.setText("   ");
		   doctor.setColumns(10);
		   
		   JButton btnNewButton_1 = new JButton("Next");
		   btnNewButton_1.setBounds(271, 480, 97, 25);
		   panel_5.add(btnNewButton_1);
		   
		   JButton btnClose = new JButton("Close");
		   btnClose.setBounds(394, 480, 97, 25);
		   panel_5.add(btnClose);
		   
		    health = new JComboBox();
		    health.setBounds(362, 416, 183, 30);
		    panel_5.add(health);
		    
		    JLabel lblHealthAlert = new JLabel("Health Alert  :");
		    lblHealthAlert.setBounds(404, 390, 117, 19);
		    panel_5.add(lblHealthAlert);
		    lblHealthAlert.setFont(new Font("Tahoma", Font.BOLD, 16));
		   btnNewButton_1.addActionListener(new ActionListener() {
		   	public void actionPerformed(ActionEvent arg0) {
		   		panel_5.setVisible(true);
		   		panel_3.setVisible(false);
		   	}
		   });
		   
		   JSeparator separator_5 = new JSeparator();
		   separator_5.setBounds(45, 521, 545, 2);
		   panel_1.add(separator_5);
		   String alert[]={};
		  
		  JLabel label = new JLabel("");
		  label.setBounds(22, 597, 56, 16);
		  contentPane.add(label);
		  
		  JButton btnAbout = new JButton("About");
		  btnAbout.setBounds(31, 214, 147, 41);
		  contentPane.add(btnAbout);
		  
		  JButton btnNewPatient = new JButton("New patient");
		  btnNewPatient.setBounds(31, 160, 147, 41);
		  contentPane.add(btnNewPatient);
		  
		  JPanel panel = new JPanel();
		  panel.setBackground(SystemColor.controlHighlight);
		  panel.setBounds(0, 0, 1200, 57);
		  contentPane.add(panel);
		  panel.setLayout(null);
		  btnNewPatient.addActionListener(new ActionListener() {
		  	public void actionPerformed(ActionEvent arg0) {
	          
		  	   panel_1.setVisible(true);
		  	  // panel_2.setVisible(false);
		  		
		  		
		  	}
		  });
		  btnAbout.addActionListener(new ActionListener() {
		  	public void actionPerformed(ActionEvent arg0) {
		  		//panel_2.setVisible(true);
		  		panel_1.setVisible(false);
		  	}
		  });
		  btnNewButton.addActionListener(new ActionListener() {
		  	public void actionPerformed(ActionEvent arg0) {
		  		int action =JOptionPane.showConfirmDialog(null,"Do you really want to Delete the Data...",  "Warning",JOptionPane.YES_NO_OPTION);
		  		if(action==0){
		  		try{
		  			String query="DELETE FROM empollyee WHERE id='"+Id.getText()+"';";
		  			PreparedStatement pst=connection.prepareStatement(query);
		  			
		  		    pst.execute();
		  			JOptionPane.showMessageDialog(null,"Data Deleted");
		  			pst.close();
		  			
		  		   }
		  		catch(Exception e)
		  		{
	               JOptionPane.showMessageDialog(null, e);				
		  		}
		  		RefreshList();
		  		RefreshTable();
		  		fillcombobox();
		  	}}
		  	});
		 RefreshList();
		fillcombobox();
		RefreshTable(); 
       
      
	}
	private static void addPopup(Component component, final JPopupMenu popup) {
		component.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			public void mouseReleased(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			private void showMenu(MouseEvent e) {
				popup.show(e.getComponent(), e.getX(), e.getY());
			}
		});
	}
}*/