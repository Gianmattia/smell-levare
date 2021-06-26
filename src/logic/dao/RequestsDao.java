package logic.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import logic.entity.RequestedShow;

import logic.utils.SessionArtist;
import logic.utils.SessionSponsor;
import logic.utils.SessionUser;

public class RequestsDao {
	private static String user = "root";
	private static String pass = "showroome";
    private static String dbUrl = "jdbc:mysql://localhost:3306/prova?autoReconnect=true&useSSL=false";
	private static String driverClassName = "com.mysql.cj.jdbc.Driver";
	
	//string declared for code smell avoidance
	String h = "host";
    String t ="title";
    String p = "partner";
    String ar = "artist";
    String d = "description";
    String apAr = "approvedArtist";
    String apPa = "approvedPartner";
	
	public RequestedShow getQueuedShow() {
		Statement stmt = null;
        Connection conn = null;
        RequestedShow result = null;
        try {
        	//STEP 2: loading dinamico del driver mysql
            Class.forName(driverClassName);
            
         // STEP 3: apertura connessione
            conn = DriverManager.getConnection(dbUrl, user, pass);
            
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
            String host = rs.getString(h);
            String title = rs.getString(t);
            String partner = rs.getString(p);
            String artist = rs.getString(ar);
            String description = rs.getString(d);
            String approvedArtist = rs.getString(apAr);
            String approvedPartner = rs.getString(apPa);
            
         //create entity
            result = new RequestedShow(host, title, partner, artist, description, approvedArtist, approvedPartner);
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
	
	public RequestedShow getQueuedShowByTitle(String title) {
		Statement stmt = null;
        Connection conn = null;
        RequestedShow result = null;
        try {
        	//STEP 2: loading dinamico del driver mysql
            Class.forName(driverClassName);
            
         // STEP 3: apertura connessione
            conn = DriverManager.getConnection(dbUrl, user, pass);
            
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
            
            String host = rs.getString(h);
            String partner = rs.getString(p);
            String artist = rs.getString(ar);
            String description = rs.getString(d);
            String approvedArtist = rs.getString(apAr);
            String approvedPartner = rs.getString(apPa);
         //create entity
            result = new RequestedShow(host, title, partner, artist, description, approvedArtist, approvedPartner);
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
	
	public List<RequestedShow> getRequests(){
		Statement stmt = null;
        Connection conn = null;
        List<RequestedShow> lrs = new ArrayList<>();
        SessionArtist instance = SessionArtist.getInstance();
        
        try {
        	//STEP 2: loading dinamico del driver mysql
            Class.forName(driverClassName);
            
         // STEP 3: apertura connessione
            conn = DriverManager.getConnection(dbUrl, user, pass);
            
            
        	
         // STEP 4.1: creazione ed esecuzione della query
            stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            String sql = "SELECT * FROM sponsored_shows_queue WHERE artist = '" +instance.getUsername()+"'";
            ResultSet rs = stmt.executeQuery(sql);
            
            if (!rs.first()) { // rs not empty
            	return lrs;
            }
         // riposizionamento del cursore
            rs.first();
            do {
            	// lettura colonne
            	 String host = rs.getString(h);
                 String title = rs.getString(t);
                 String partner = rs.getString(p);
                 String artist = rs.getString(ar);
                 String description = rs.getString(d);
                 String approvedArtist = rs.getString(apAr);
                 String approvedPartner = rs.getString(apPa);
            	
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
            Class.forName(driverClassName);
            
         // STEP 3: apertura connessione
            conn = DriverManager.getConnection(dbUrl, user, pass); 
            
        	
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
            Class.forName(driverClassName);
            
         // STEP 3: apertura connessione
            conn = DriverManager.getConnection(dbUrl, user, pass); 
            
        	
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
