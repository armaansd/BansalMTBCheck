import java.sql.*;
public class Connect
{
public static void main (String[] args)
{
Connection conn = null;
try
{
String userName = "MTB FIRST";
String password = "mtb@123";
String url = "jdbc:sqlite:\\10.0.0.6\\bansal hospital sgnr raj\\print.sqlite";
Class.forName ("org.sqlite.JDBC").newInstance ();
conn = DriverManager.getConnection (url, userName, password);
System.out.println ("Database connection established");
}
catch (Exception e)
{
System.err.println ("Cannot connect to database server");
}
finally
{
if (conn != null)
{
try
{
conn.close ();
System.out.println ("Database connection terminated");
}
catch (Exception e) { /* ignore close errors */ }
}
}
}
}