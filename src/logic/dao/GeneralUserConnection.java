package logic.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class GeneralUserConnection {
	//applying singleton pattern
	
		private static Connection conn=null;
		
		private static String user = "root";
		private static String pass = "0000";
	    private static String dbUrl = "jdbc:mysql://localhost:3306/provafinale?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
		private static String driverClassName = "com.mysql.jdbc.Driver";
		
		private GeneralUserConnection() {
			
		}
		
		public static Connection getUserConnection() throws ClassNotFoundException, SQLException {
			if(conn!=null) return conn;
	    	else {
	    		Class.forName(driverClassName);
	        	conn=DriverManager.getConnection(dbUrl,user,pass);
	    		return conn;    		
	    	}
		}
		
		public static void closeUserConnection() throws SQLException {
			conn.close();
			conn=null;
		}
}
