package logic.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import logic.entity.Artist;
import logic.entity.Event;
import logic.entity.Place;

public class EventDao {
	//passo 0, dichiaro variabili
			private static String USER = "root";
			private static String PASS = "0000";
		    private static String DB_URL = "jdbc:mysql://localhost:3306/provafinale?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
			private static String DRIVER_CLASS_NAME = "com.mysql.cj.jdbc.Driver";
			
			public List<Event> getLiveEvents() {
				Statement stmt = null;
		        Connection conn = null;
		        List<Event> liveEvents = new ArrayList<Event>();
		        
		        try {
		        	//STEP 2: loading dinamico del driver mysql
		            Class.forName(DRIVER_CLASS_NAME);
		            
		         // STEP 3: apertura connessione
		            conn = DriverManager.getConnection(DB_URL, USER, PASS);
		            
		            
		        	//conn = GeneralUserConnection.getUserConnection();
		         // STEP 4.1: creazione ed esecuzione della query
		            stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
		                    ResultSet.CONCUR_READ_ONLY);
		            String sql = "SELECT * FROM events"; 
		            ResultSet rs = stmt.executeQuery(sql);
		            
		            if (!rs.first()) { // rs not empty
		            	
		            	return null;
		            }
		         // riposizionamento del cursore
		            rs.first();
		            do {
		            	// lettura colonne
		            	String name  = rs.getString("name");
		            	String place = rs.getString("place");
		            	String description = rs.getString("description");
		            	String artist = rs.getString("artist");
		            	Event liveEv = new Event(name, artist, description, place); //creates event entity
		            	liveEvents.add(liveEv);
		            	
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
				return liveEvents;
		        
			}
			
			public void newEvent(String name, String artist, String description, String place){
				Statement stmt = null;
		        Connection conn = null;
		        
		        try {
		        	// STEP 2: loading dinamico del driver mysql
		            Class.forName(DRIVER_CLASS_NAME);
		            
		         // STEP 3: apertura connessione
		            conn = DriverManager.getConnection(DB_URL, USER, PASS); 
		            
		        	
		         // STEP 4.1: creazione ed esecuzione della query
		            stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
		                    ResultSet.CONCUR_READ_ONLY); 
		        	
		            String sql = "INSERT INTO events (name, artist, description, place) VALUES ('" +name+"','"+artist+"','"+description+"','"+place+"')";
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
			
			public void deleteLiveEvent(String title) {
				Statement stmt = null;
		        Connection conn = null;
		        
		        try {
		        	// STEP 2: loading dinamico del driver mysql
		            Class.forName(DRIVER_CLASS_NAME);
		            
		         // STEP 3: apertura connessione
		            conn = DriverManager.getConnection(DB_URL, USER, PASS); 
		            
		        	
		         // STEP 4.1: creazione ed esecuzione della query
		            stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
		                    ResultSet.CONCUR_READ_ONLY); 
		        	
		            String sql = "DELETE FROM events WHERE name = '" +title+"'";
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
			
			public Event getEvent(String artist) {
				Statement stmt = null;
		        Connection conn = null;
		        Event e= null;
		        try {
		        	//STEP 2: loading dinamico del driver mysql
		            Class.forName(DRIVER_CLASS_NAME);
		            
		         // STEP 3: apertura connessione
		            conn = DriverManager.getConnection(DB_URL, USER, PASS);
		            
		        	//conn = GeneralUserConnection.getUserConnection();
		         // STEP 4.1: creazione ed esecuzione della query
		            stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
		                    ResultSet.CONCUR_READ_ONLY);
		            String sql = "SELECT * FROM events WHERE artist = '" +artist+"'";
		            ResultSet rs = stmt.executeQuery(sql);
		            
		            if (!rs.first()) { // rs not empty
		            	return null;
		            }
		         // riposizionamento del cursore
		            rs.first();
		            
		         // lettura colonne
		            String name  = rs.getString("name");
	            	String place = rs.getString("place");
	            	String description = rs.getString("description");
	            	String art = rs.getString("artist");
		         //create entity
		            e = new Event(name, art, description, place);
		            // STEP 6: Clean-up dell'ambiente
		            rs.close();
		            stmt.close();
		            conn.close();
		        } catch (SQLException se) {
		            // Errore durante l'apertura della connessione
		            se.printStackTrace();
		        } catch (Exception e1) {
		            // Errore nel loading del driver
		            e1.printStackTrace();
		            
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
				return e;
			}

}
