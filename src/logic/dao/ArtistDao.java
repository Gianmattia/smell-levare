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

public class ArtistDao {
	private static String USER = "root";
	private static String PASS = "0000";
    private static String DB_URL = "jdbc:mysql://localhost:3306/provafinale?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
	private static String DRIVER_CLASS_NAME = "com.mysql.cj.jdbc.Driver";
	
	public Artist getArtist(String name) {
		Statement stmt = null;
        Connection conn = null;
        Artist a= null;
        try {
        	//STEP 2: loading dinamico del driver mysql
            Class.forName(DRIVER_CLASS_NAME);
            
         // STEP 3: apertura connessione
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            
        	//conn = GeneralUserConnection.getUserConnection();
         // STEP 4.1: creazione ed esecuzione della query
            stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            String sql = "SELECT * FROM artists WHERE username = '" +name+"'";
            ResultSet rs = stmt.executeQuery(sql);
            
            if (!rs.first()) { // rs not empty
            	return null;
            }
         // riposizionamento del cursore
            rs.first();
            
         // lettura colonne
            String usrnm = rs.getString("username");
            String psswrd = rs.getString("password");
            String email = rs.getString("email");
            String description = rs.getString("description");
            String talent = rs.getString("talent");
         //create entity
            a = new Artist(usrnm, psswrd, email, description, talent);
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
		return a;
        	
	}
	
	public Artist artistLogin(String username, String password) {
		Statement stmt = null;
        Connection conn = null;
        Artist a= null;
        try {
        	//STEP 2: loading dinamico del driver mysql
            Class.forName(DRIVER_CLASS_NAME);
            
         // STEP 3: apertura connessione
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            
        	//conn = GeneralUserConnection.getUserConnection();
         // STEP 4.1: creazione ed esecuzione della query
            stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            String sql = "SELECT * FROM artists WHERE username = '" +username+"'";
            ResultSet rs = stmt.executeQuery(sql);
            
            if (!rs.first()) { // rs not empty
            	return null;
            }
         // riposizionamento del cursore
            rs.first();
            
         // lettura colonne
            String usrnm = rs.getString("username");
            String psswrd = rs.getString("password");
            String email = rs.getString("email");
            String description = rs.getString("description");
            String talent = rs.getString("talent");
            
            if (!usrnm.equals(username)|| !psswrd.equals(password)) {
            	//controllo 
            	return null;
            }
         //create entity
            a = new Artist(usrnm, psswrd, email, description, talent);
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
		return a;
	}
	
	public void updateArtist(String artist, String email, String talent, String description) {
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
            if(!email.equals("")) {
            	String sql = "UPDATE artists SET email = '" + email + "' WHERE username = '" + artist + "';";
            	stmt.executeUpdate(sql);
            }
            if(!talent.equals("")) {
            	String sql1 = "UPDATE artists SET talent = '" + talent + "' WHERE username = '" + artist + "';";
            	stmt.executeUpdate(sql1);
            }
            if(!description.equals("")) {
            	String sql2 = "UPDATE artists SET description = '" + description + "' WHERE username = '" + artist + "';";
            	stmt.executeUpdate(sql2);
            }
            
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
	
	public List<Artist> getArtists(){
		Statement stmt = null;
        Connection conn = null;
        List<Artist> artists = new ArrayList<>();
        
        try {
        	//STEP 2: loading dinamico del driver mysql
            Class.forName(DRIVER_CLASS_NAME);
            
         // STEP 3: apertura connessione
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            
            
        	
         // STEP 4.1: creazione ed esecuzione della query
            stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            String sql = "SELECT * FROM artists";
            ResultSet rs = stmt.executeQuery(sql);
            
            if (!rs.first()) { // rs not empty
            	return null;
            }
         // riposizionamento del cursore
            rs.first();
            do {
            	// lettura colonne
            	String name  = rs.getString("username");
            	String password = rs.getString("password");
            	String email = rs.getString("email");
            	String description = rs.getString("description");
            	String talent = rs.getString("talent");
            	
            	Artist art = new Artist(name, password, email, description, talent);
            	artists.add(art);
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
		return artists;
        
	}
	
public void registerArtist(String username, String password, String email, String description, String talent) {
		
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
        	
            String sql = "INSERT INTO artists (username, password, email, description, talent) VALUES ('" +username+"','"+password+"','"+email+"','"+description+"','"+talent+"')";
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

