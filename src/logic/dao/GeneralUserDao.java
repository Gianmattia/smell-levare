package logic.dao;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Random;

import logic.entity.GeneralUser;

import logic.exceptions.DuplicateUsernameException;


public class GeneralUserDao {
	/*
	 * 1) Caricare il Driver
	 * 2) Aprire una Connessione al Database
	 * 3) Creare un Oggetto Statement
	 * 4) Interagire con il Database
	 * 5) Gestire e visualizzare i risultati ottenuti dalle ResultSet.
	 */
	//passo 0, dichiaro variabili
	private static String user = "root";
	private static String pass = "showroome";
    private static String dbUrl = "jdbc:mysql://localhost:3306/prova?autoReconnect=true&useSSL=false";
	private static String driverClassName = "com.mysql.cj.jdbc.Driver";
	
	
	
	public GeneralUser login(String username1, String password){
		// STEP 1: dichiarazioni
        Statement stmt = null;
        Connection conn = null;
        GeneralUser u= null;
        
        try {
        	//STEP 2: loading dinamico del driver mysql
            Class.forName(driverClassName);
            
         // STEP 3: apertura connessione
            conn = DriverManager.getConnection(dbUrl, user, pass);
            
         // STEP 4.1: creazione ed esecuzione della query
            stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            String sql = "SELECT * FROM users WHERE username = '" +username1+"'";
            ResultSet rs = stmt.executeQuery(sql);
            
            if (!rs.first()) { // rs not empty
            	return null;
            }
         // riposizionamento del cursore
            rs.first();
                        
         // lettura colonne
            String usrnm = rs.getString("username");
            String psswrd = rs.getString("password");
            int id = rs.getInt("idusers");
            
            if (!usrnm.equals(username1)|| !psswrd.equals(password)) {
            	
            	return null;
            }
            
            u = new GeneralUser(usrnm, psswrd, id);
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
		return u;
        
	}
	
	public void register(int iduser, String username, String password) throws DuplicateUsernameException {
		
		// STEP 1: dichiarazioni
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
        	
            String sql = "INSERT INTO users (idusers, username, password) VALUES ('" +iduser+"','"+username+"','"+password+"')";
            stmt.executeUpdate(sql);
         // STEP 6: Clean-up dell'ambiente
            stmt.close();
            conn.close();
        } catch (SQLException se) {
        	throw new DuplicateUsernameException("username gia' in uso");
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
	
	public int getMaxId() {
		// STEP 1: dichiarazioni
        Statement stmt = null;
        Connection conn = null;
        Random rand;
        int i=9999;
		try {
			rand = SecureRandom.getInstanceStrong();
			i = rand.nextInt(9000);
		} catch (NoSuchAlgorithmException e1) {
			e1.printStackTrace();
		}  
        
        try {
        	//STEP 2: loading dinamico del driver mysql
            Class.forName(driverClassName);
            
         // STEP 3: apertura connessione
            conn = DriverManager.getConnection(dbUrl, user, pass);
            
         // STEP 4.1: creazione ed esecuzione della query
            stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            String sql = "SELECT MAX(idusers) FROM users";
            ResultSet rs = stmt.executeQuery(sql);
            
            if (!rs.first()) { // rs not empty
            	//i starts randomized so that if anything happens it's probable that there won't be any double
            	return i;
            }
         // riposizionamento del cursore
            rs.first();
                        
         // lettura colonne
            
            i = rs.getInt(1);
            
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
		return i;
        
	}
}
