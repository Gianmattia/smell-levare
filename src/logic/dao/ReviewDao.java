package logic.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import logic.entity.Artist;
import logic.entity.Place;
import logic.entity.Review;

public class ReviewDao {
	
	private static String USER = "root";
	private static String PASS = "0000";
    private static String DB_URL = "jdbc:mysql://localhost:3306/provafinale?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
	private static String DRIVER_CLASS_NAME = "com.mysql.cj.jdbc.Driver";
	
	public List<Review> getReview(String artist) {
		Statement stmt = null;
        Connection conn = null;
        List<Review> r= new ArrayList<Review>();
        try {
        	//STEP 2: loading dinamico del driver mysql
            Class.forName(DRIVER_CLASS_NAME);
            
         // STEP 3: apertura connessione
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            
         // STEP 4.1: creazione ed esecuzione della query
            stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            String sql = "SELECT * FROM reviews WHERE artist = '" +artist+"'";
            ResultSet rs = stmt.executeQuery(sql);
            
            if (!rs.first()) { // rs not empty
            	return null;
            }
         // riposizionamento del cursore
            rs.first();
            do {
            	// lettura colonne
            	String author  = rs.getString("author");
            	String art = rs.getString("artist");
            	String review = rs.getString("review");
            	
            	Review rev = new Review(author, art, review); //creates review entity
            	r.add(rev);
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
		return r;
             
            
	}
	
	public void submitReview(String author, String artist, String review) {
		// STEP 1: dichiarazioni
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
        	
            String sql = "INSERT INTO reviews (author, artist, review) VALUES ('" +author+"','"+artist+"','"+review+"')";
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

