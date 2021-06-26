package logic.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import logic.entity.Artist;
import logic.entity.RequestedShow;
import logic.entity.SponsoredShow;
import logic.utils.SessionSponsor;
import logic.utils.SessionUser;

public class SponsoredShowDao {
	
	private static String USER = "root";
	private static String PASS = "0000";
    private static String DB_URL = "jdbc:mysql://localhost:3306/provafinale?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
	private static String DRIVER_CLASS_NAME = "com.mysql.cj.jdbc.Driver";
	
	public SponsoredShow getSponsoredShow(String title) {
		Statement stmt = null;
        Connection conn = null;
        SponsoredShow result = null;
        try {
        	//STEP 2: loading dinamico del driver mysql
            Class.forName(DRIVER_CLASS_NAME);
            
         // STEP 3: apertura connessione
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            
         // STEP 4.1: creazione ed esecuzione della query
            stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            String sql = "SELECT * FROM sponsored_shows WHERE title = '" +title+"'";
            ResultSet rs = stmt.executeQuery(sql);
            
            if (!rs.first()) { // rs not empty
            	return null;
            }
         // riposizionamento del cursore
            rs.first();
            
         // lettura colonne
            String sponsor = rs.getString("sponsor");
            String partner = rs.getString("partner");
            String artist = rs.getString("artist");
            String description = rs.getString("description");
            String location = rs.getString("location");
            String capacity = rs.getString("capacity");
            
         //create entity
            result = new SponsoredShow(title, artist, sponsor, location, capacity, partner, description);
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
		
		return result;
	}
		
	public void hostSponsoredShow(SponsoredShow ss) {
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
        	
            String sql = "INSERT INTO sponsored_shows (title, artist, sponsor, location, capacity, partner, description) VALUES ('" +ss.getTitle()+"','"+ss.getArtist()+"','"+ss.getSponsor()+"','"+ss.getLocation()+"','"+ss.getCapacity()+"','"+ss.getPartner()+"','"+ss.getDescription()+"')";
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
	
	public void dismissShow() {
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
        	SessionUser su = SessionUser.getInstance();
            String host = su.getUsername();
            String sql = "DELETE FROM sponsored_shows WHERE sponsor = '" +host+"'";
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
	
	public List<SponsoredShow> getSponsoredShows(){
		Statement stmt = null;
        Connection conn = null;
        List<SponsoredShow> shows = new ArrayList<>();
        
        try {
        	//STEP 2: loading dinamico del driver mysql
            Class.forName(DRIVER_CLASS_NAME);
            
         // STEP 3: apertura connessione
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            
            
        	
         // STEP 4.1: creazione ed esecuzione della query
            stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            String sql = "SELECT * FROM sponsored_shows";
            ResultSet rs = stmt.executeQuery(sql);
            
            if (!rs.first()) { // rs not empty
            	return null;
            }
         // riposizionamento del cursore
            rs.first();
            do {
            	// lettura colonne
            	String title  = rs.getString("title");
            	String artist = rs.getString("artist");
            	String sponsor = rs.getString("sponsor");
            	String location = rs.getString("location");
            	String capacity = rs.getString("capacity");
            	String partner = rs.getString("partner");
            	String description = rs.getString("description");
            	
            	SponsoredShow ss = new SponsoredShow(title, artist, sponsor, location, capacity, partner, description);
            	shows.add(ss);
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
		return shows;
        
	}

}
