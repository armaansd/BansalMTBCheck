import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;

public class SqliteConnection
{

	static Connection conn=null;
	static Connection conn1=null;
	static Connection conn2=null;
	static Connection conn3=null;
	
	public static Connection dbconnector()
	{
		
		try{
		Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
		conn =DriverManager.getConnection("jdbc:ucanaccess://bansal.accdb");  
		//JOptionPane.showMessageDialog(null, "Data Base Connected");
	    return conn;
		}
		catch(Exception e)
		{
			e.printStackTrace();
		
		return null;
		}
	
	}
	
	public static Connection dbconnector3()
	{
		
		try{
		Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
		conn3 =DriverManager.getConnection("jdbc:ucanaccess://bsshlab.accdb");  
		//JOptionPane.showMessageDialog(null, "Data Base Connected");
	    return conn3;
		}
		catch(Exception e)
		{
			e.printStackTrace();
		
		return null;
		}
	
	}
	
	public static Connection dbconnector2()
	{
		
		try{
			Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
			conn2 =DriverManager.getConnection("jdbc:ucanaccess://sbbh.accdb");  
			//JOptionPane.showMessageDialog(null, "Data Base Connected");
	    return conn2;
		}
		catch(Exception e)
		{
			e.printStackTrace();
		
		return null;
		}
	
	}
	public static Connection dbconnector1()
	{
		try{
		Class.forName("org.sqlite.JDBC");
		conn1 =DriverManager.getConnection("jdbc:sqlite:print.sqlite"); 
		//JOptionPane.showMessageDialog(null, "Data Base Connected");
	    return conn1;
		}
		catch(Exception e)
		{
			JOptionPane.showMessageDialog(null, e);
		
		return null;
		}
	
	}
	public static Connection workdbconnector()
	{
		try{
		Class.forName("org.sqlite.JDBC");
		Connection conn =DriverManager.getConnection("jdbc:sqlite:D:\\config.sqlite"); 
	    return conn;
		}
		catch(Exception e)
		{
			JOptionPane.showMessageDialog(null, e);
		
		return null;
		}
	}


	
}
