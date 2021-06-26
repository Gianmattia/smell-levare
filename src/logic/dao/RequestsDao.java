package logic.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import logic.entity.RequestedShow;
import logic.entity.Sponsor;
import logic.utils.SessionArtist;
import logic.utils.SessionSponsor;
import logic.utils.SessionUser;

public class RequestsDao {
	private static String USER = "root";
	private static String PASS = "0000";
    private static String DB_URL = "jdbc:mysql://localhost:3306/provafinale?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
	private static String DRIVER_CLASS_NAME = "com.mysql.cj.jdbc.Driver";
	
	public RequestedShow getQueuedShow() {
		Statement stmt = null;
        Connection conn = null;
        RequestedShow result = null;
        try {
        	//STEP 2: loading dinamico del driver mysql
            Class.forName(DRIVER_CLASS_NAME);
            
         // STEP 3: apertura connessione
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            
        	SessionSponsor instance = SessionSponsor.getInstance();
         // STEP 4.1: creazione ed esecuzione della query
            stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            String sql = "SELECT * FROM sponsored_shows_queue WHERE host = '" +instance.getUsername()+"'";
            ResultSet rs = stmt.executeQuery(sql);
            
            if (!rs.first()) { // rs not empty
            	return null;
            }
         // riposizionamento del cursore
            rs.first();
            
         // lettura colonne
            String host = rs.getString("host");
            String title = rs.getString("title");
            String partner = rs.getString("partner");
            String artist = rs.getString("artist");
            String description = rs.getString("description");
            String approvedArtist = rs.getString("approvedArtist");
            String approvedPartner = rs.getString("approvedPartner");
            
         //create entity
            result = new RequestedShow(host, title, partner, artist, description, approvedArtist, approvedPartner);
            // STEP 6: Clean-up dell'ambiente
            rs.close();
            stmt.close();
            //UserConnection.closeUserConnection();
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
	
	public RequestedShow getQueuedShowByTitle(String title) {
		Statement stmt = null;
        Connection conn = null;
        RequestedShow result = null;
        try {
        	//STEP 2: loading dinamico del driver mysql
            Class.forName(DRIVER_CLASS_NAME);
            
         // STEP 3: apertura connessione
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            
         // STEP 4.1: creazione ed esecuzione della query
            stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            String sql = "SELECT * FROM sponsored_shows_queue WHERE title = '" +title+"'";
            ResultSet rs = stmt.executeQuery(sql);
            
            if (!rs.first()) { // rs not empty
            	return null;
            }
         // riposizionamento del cursore
            rs.first();
            
         // lettura colonne
            String host = rs.getString("host");
            String partner = rs.getString("partner");
            String artist = rs.getString("artist");
            String description = rs.getString("description");
            String approvedArtist = rs.getString("approvedArtist");
            String approvedPartner = rs.getString("approvedPartner");
            
         //create entity
            result = new RequestedShow(host, title, partner, artist, description, approvedArtist, approvedPartner);
            // STEP 6: Clean-up dell'ambiente
            rs.close();
            stmt.close();
            //UserConnection.closeUserConnection();
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
	
	public List<RequestedShow> getRequests(){
		Statement stmt = null;
        Connection conn = null;
        List<RequestedShow> lrs = new ArrayList<RequestedShow>();
        SessionArtist instance = SessionArtist.getInstance();
        
        try {
        	//STEP 2: loading dinamico del driver mysql
            Class.forName(DRIVER_CLASS_NAME);
            
         // STEP 3: apertura connessione
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            
            
        	
         // STEP 4.1: creazione ed esecuzione della query
            stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            String sql = "SELECT * FROM sponsored_shows_queue WHERE artist = '" +instance.getUsername()+"'";
            ResultSet rs = stmt.executeQuery(sql);
            
            if (!rs.first()) { // rs not empty
            	return null;
            }
         // riposizionamento del cursore
            rs.first();
            do {
            	// lettura colonne
            	String host  = rs.getString("host");
            	String title  = rs.getString("title");
            	String partner  = rs.getString("partner");
            	String artist  = rs.getString("artist");
            	String description  = rs.getString("description");
            	String approvedArtist  = rs.getString("approvedArtist");
            	String approvedPartner  = rs.getString("approvedPartner");
            	
            	RequestedShow rqsh = new RequestedShow(host, title, partner, artist, description, approvedArtist, approvedPartner);
            	lrs.add(rqsh);
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
		return lrs;
        
	}
	
	public void updateApprovedArtist(String title, String state) {
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
            String sql = "UPDATE sponsored_shows_queue SET approvedArtist = '" + state + "' WHERE title = '" + title + "';";
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
	
	public void deleteRequest() {
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
            String sql = "DELETE FROM sponsored_shows_queue WHERE host = '" +host+"'";
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
