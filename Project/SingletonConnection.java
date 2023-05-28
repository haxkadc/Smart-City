package Project;


import java.sql.Connection;
import java.sql.DriverManager;
//import java.sql.ResultSet;
import java.sql.SQLException;


public  class SingletonConnection {
	private static SingletonConnection instance = null;
	public   Connection con;
	SingletonConnection()  //costruttore privato
	{
	}
	public static SingletonConnection getinstance () {
		if(instance==null)
		{
			instance = new SingletonConnection();	
			instance.con= instance.connessione();
		}
		
		return instance;
	}
	private  Connection  connessione ( )
	{
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con =  DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "SMARTCITY", "SMARTCITY");
         	

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return con;		
		}


	
	
}