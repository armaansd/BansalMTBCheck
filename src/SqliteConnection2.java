import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;

public class SqliteConnection2
{

	static Connection conn=null;
	

	
	public static Connection dbconnector2()
	{
		
		try{
		Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
		Connection conn =DriverManager.getConnection("jdbc:ucanaccess://sbbh.accdb");  
		JOptionPane.showMessageDialog(null, "Data Base Connected");
	    return conn;
		}
		catch(Exception e)
		{
			e.printStackTrace();
		
		return null;
		}
	
	}
	


	
}
