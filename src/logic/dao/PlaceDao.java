package logic.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


import logic.entity.Place;

public class PlaceDao {
	//passo 0, dichiaro variabili
		private static String user = "root";
		private static String pass = "showroome";
	    private static String dbUrl = "jdbc:mysql://localhost:3306/prova?autoReconnect=true&useSSL=false";
		private static String driverClassName = "com.mysql.cj.jdbc.Driver";
		
		public List<Place> getFreePlacesDao() {
			Statement stmt = null;
	        Connection conn = null;
	        List<Place> freePlaces = new ArrayList<>();
	        
	        try {
	        	//STEP 2: loading dinamico del driver mysql
	            Class.forName(driverClassName);
	            
	         // STEP 3: apertura connessione
	            conn = DriverManager.getConnection(dbUrl, user, pass);
	            
	            
	        	
	         // STEP 4.1: creazione ed esecuzione della query
	            stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
	                    ResultSet.CONCUR_READ_ONLY);
	            String sql = "SELECT * FROM places WHERE free = '" +""+"'";
	            ResultSet rs = stmt.executeQuery(sql);
	            
	            if (!rs.first()) { // rs not empty
	            	return freePlaces;
	            }
	         // riposizionamento del cursore
	            rs.first();
	            do {
	            	// lettura colonne
	            	String name  = rs.getString("name");
	            	String address = rs.getString("address");
	            	int capacity = rs.getInt("capacity");
	            	
	            	Place fPlace = new Place(name, capacity, address, null); //creates place entity
	            	freePlaces.add(fPlace);
	            }while(rs.next());
	            
	            
	            
	            
	         // STEP 6: Clean-up dell'ambiente
	            rs.close();
	            stmt.close();
	            conn.close();
	            
	        } catch (SQLException se) {
	            // Errore durante l'apertura della connessione
	            se.printStackTrace();
	        } catch (Exception e) {
	            // Errore nel loading del driver
	            e.printStackTrace();
	            
	        } finally {
	        	try {
	                if (stmt != null)
	                    stmt.close();
	            } catch (SQLException se2) {
	            	se2.printStackTrace();
	            }
	            try {
	                if (conn != null)
	                    conn.close();
	            } catch (SQLException se) {
	                se.printStackTrace();
	            }
	        }
			return freePlaces;
	        
		}
		
		public Place getPlace(String name) {
			Statement stmt = null;
	        Connection conn = null;
	        Place p= null;
	        try {
	        	//STEP 2: loading dinamico del driver mysql
	            Class.forName(driverClassName);
	            
	         // STEP 3: apertura connessione
	            conn = DriverManager.getConnection(dbUrl, user, pass);
	            
	         // STEP 4.1: creazione ed esecuzione della query
	            stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
	                    ResultSet.CONCUR_READ_ONLY);
	            String sql = "SELECT * FROM places WHERE name = '" +name+"'";
	            ResultSet rs = stmt.executeQuery(sql);
	            
	            if (!rs.first()) { // rs not empty
	            	return null;
	            }
	         // riposizionamento del cursore
	            rs.first();
	            
	         // lettura colonne
	            int capacity = rs.getInt("capacity");
	            String address = rs.getString("address");
	            String free = rs.getString("free");
	         //create entity
	            p = new Place(name, capacity, address, free);
	            // STEP 6: Clean-up dell'ambiente
	            rs.close();
	            stmt.close();
	            conn.close();
	        } catch (SQLException se) {
	            // Errore durante l'apertura della connessione
	            se.printStackTrace();
	        } catch (Exception e) {
	            // Errore nel loading del driver
	            e.printStackTrace();
	            
	        } finally {
	        	try {
	                if (stmt != null)
	                    stmt.close();
	            } catch (SQLException se2) {
	            	se2.printStackTrace();
	            }
	            try {
	                if (conn != null)
	                    conn.close();
	            } catch (SQLException se) {
	                se.printStackTrace();
	            }
	        }
			return p;
	        	
		}
	        
	    public void setBooked(String place, String artist) {
	    	Statement stmt = null;
	        Connection conn = null;
	        
	        try {
	        	// STEP 2: loading dinamico del driver mysql
	            Class.forName(driverClassName);
	            
	         // STEP 3: apertura connessione
	            conn = DriverManager.getConnection(dbUrl, user, pass); 
	            
	        	
	         // STEP 4.1: creazione ed esecuzione della query
	            stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
	                    ResultSet.CONCUR_READ_ONLY); 
	            String sql = null;
	            String vuota = "";
	            if (artist.equals("")) {
	            	sql = "UPDATE Places SET free = '" + vuota + "' WHERE name = '" + place + "';";
	            }
	            else {
	            	sql = "UPDATE Places SET free = '" + artist + "' WHERE name = '" + place + "';";
	            }
	            stmt.executeUpdate(sql);
	         // STEP 6: Clean-up dell'ambiente
	            stmt.close();
	            conn.close();
	        } catch (SQLException se) {
	            // Errore durante l'apertura della connessione
	            se.printStackTrace();
	        } catch (Exception e) {
	            // Errore nel loading del driver
	            e.printStackTrace();
	            
	        } finally {
	        	try {
	                if (stmt != null)
	                    stmt.close();
	            } catch (SQLException se2) {
	            	se2.printStackTrace();
	            }
	            try {
	                if (conn != null)
	                    conn.close();
	            } catch (SQLException se) {
	                se.printStackTrace();
	            }
	        }
		
	    }
	        
}
		

