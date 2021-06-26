package logic.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


import logic.entity.Sponsor;
import logic.exceptions.PendingRequestException;
import logic.utils.SessionSponsor;

public class SponsorDao {
	private static String user = "root";
	private static String pass = "showroome";
    private static String dbUrl = "jdbc:mysql://localhost:3306/prova?autoReconnect=true&useSSL=false";
	private static String driverClassName = "com.mysql.cj.jdbc.Driver";
	
	//strings declared for code smell avoidance
	String u = "username";
    String p = "password";
    String a = "activity";
    String c = "capacity";
    String d = "description";
	
	public Sponsor getSponsor(String username) {
		Statement stmt = null;
        Connection conn = null;
        Sponsor s = null;
        try {
        	//STEP 2: loading dinamico del driver mysql
            Class.forName(driverClassName);
            
         // STEP 3: apertura connessione
            conn = DriverManager.getConnection(dbUrl, user, pass);
            
         // STEP 4.1: creazione ed esecuzione della query
            stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            String sql = "SELECT * FROM sponsors WHERE username = '" +username+"'";
            ResultSet rs = stmt.executeQuery(sql);
            
            if (!rs.first()) { // rs not empty
            	return null;
            }
         // riposizionamento del cursore
            rs.first();
            
         // lettura colonne
            String usrnm = rs.getString(u);
            String psswrd = rs.getString(p);
            String activity = rs.getString(a);
            String capacity = rs.getString(c);
            String description = rs.getString(d);
            
         //create entity
            s = new Sponsor(usrnm, psswrd, activity, capacity, description);
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
		return s;
        	
	}
	
	public Sponsor loginSponsor(String username, String password) {
		Statement stmt = null;
        Connection conn = null;
        Sponsor s = null;
        try {
        	//STEP 2: loading dinamico del driver mysql
            Class.forName(driverClassName);
            
         // STEP 3: apertura connessione
            conn = DriverManager.getConnection(dbUrl, user, pass);
            
        	
         // STEP 4.1: creazione ed esecuzione della query
            stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            String sql = "SELECT * FROM sponsors WHERE username = '" +username+"'";
            ResultSet rs = stmt.executeQuery(sql);
            
            if (!rs.first()) { // rs not empty
            	return null;
            }
         // riposizionamento del cursore
            rs.first();
            
         // lettura colonne
            String usrnm = rs.getString(u);
            String psswrd = rs.getString(p);
            String activity = rs.getString(a);
            String capacity = rs.getString(c);
            String description = rs.getString(d);
            if (!usrnm.equals(username)|| !psswrd.equals(password)) {
            	//controllo 
            	return null;
            }
         //create entity
            s = new Sponsor(usrnm, psswrd, activity, capacity, description);
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
		return s;
        	
	}
	
	public List<Sponsor> getSponsors(){
		Statement stmt = null;
        Connection conn = null;
        List<Sponsor> sponsors = new ArrayList<>();
        
        try {
        	//STEP 2: loading dinamico del driver mysql
            Class.forName(driverClassName);
            
         // STEP 3: apertura connessione
            conn = DriverManager.getConnection(dbUrl, user, pass);
            
            
        	
         // STEP 4.1: creazione ed esecuzione della query
            stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            String sql = "SELECT * FROM sponsors";
            ResultSet rs = stmt.executeQuery(sql);
            
            if (!rs.first()) { // rs not empty
            	return sponsors;
            }
         // riposizionamento del cursore
            rs.first();
            do {
            	// lettura colonne
            	String name  = rs.getString("username");
            	String password = rs.getString("password");
            	String activity = rs.getString("activity");
            	String description = rs.getString("description");
            	String capacity = rs.getString("capacity");
            	
            	Sponsor spo = new Sponsor(name, password, activity, capacity, description);
            	sponsors.add(spo);
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
		return sponsors;
        
	}
	
	public void createSSQueue(String title, String artist, String partner, String description) throws PendingRequestException {
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
        	SessionSponsor ss = SessionSponsor.getInstance();
            String host = ss.getUsername();
            String no = "no";
        	String yes ="yes";
            if(partner.equals("")) {
            	String sql = "INSERT INTO sponsored_shows_queue (host, title, partner, artist, description, approvedArtist, approvedPartner) VALUES ('" +host+"','"+title+"','"+no+"','"+artist+"','"+description+"','"+no+"','"+yes+"')";
            	stmt.executeUpdate(sql);
            }
            else {
            	String sql = "INSERT INTO sponsored_shows_queue (host, title, partner, artist, description, approvedArtist, approvedPartner) VALUES ('" +host+"','"+title+"','"+partner+"','"+artist+"','"+description+"','"+no+"','"+no+"')";
            	stmt.executeUpdate(sql);
            }
         // STEP 6: Clean-up dell'ambiente
            stmt.close();
            conn.close();
        } catch (SQLException se) {
            throw new PendingRequestException("stai già contattando un artista");
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
