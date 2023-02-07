package Persistencia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.*;

public class PoolConnection
{
	private Connection con ;
	private static PoolConnection pool;
	
	
	public static PoolConnection getPoolConnection()
	{
		if (pool== null)
			pool =new PoolConnection();
		return pool;
	}
	
	public Connection connect()
	{
		try
		{
            String userName = "A_Interactivas_01";
            String password = "A_Interactivas_01";
            String url = "jdbc:sqlserver://192.168.6.202";
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            con = DriverManager.getConnection (url, userName, password);
            return con;
        }
        catch (Exception e)
        {
            System.err.println ("Cannot connect to database server");
            return null;
        }
	}
	
	
	public void closeConnections()
	{
		try
		{
			con.close();
		}
		catch (Exception e)
        {
            System.err.println ("Cannot connect to database server");
        }    
	}
	
	public  Connection getConnection()
	{
		Connection con = null;
		con = connect();
		return con;
	}
}