/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package EasyOrganizer.db;

import EasyOrganizer.model.EasyOrganizerModel;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author jonatan
 */
public class DBHandler {
    private Connection conn;
    
    public DBHandler() {
        conn = new SqliteConnectionFactory().connect();
        createDB();
    }
    
    public void createDB(){
        try {
            Statement stmt = conn.createStatement();
            String sql = "CREATE TABLE appointments " +
                    "(id INTEGER PRIMARY KEY AUTOINCREMENT ," +
                    " title TEXT NOT NULL, " +
                    " description TEXT NOT NULL, " +
                    " subject TEXT NOT NULL, " +
                    " date INTEGER NOT NULL)";
            stmt.executeQuery(sql);
            stmt.close();
        } catch (SQLException ex) {
            System.out.println("DB ALREADY EXISTS!");
        }
    }
    
    public boolean insert(EasyOrganizerModel eom){
        String sql = "INSERT INTO appointments(title,description, subject, date) VALUES(?,?,?,?)";
        PreparedStatement pstmt;
        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, eom.getTitle());
            pstmt.setString(2, eom.getDescription());
            pstmt.setString(3, eom.getSubject());
            pstmt.setLong(4, eom.getDate().getTime());
            pstmt.executeUpdate();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(DBHandler.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
    
    public List<EasyOrganizerModel> selectAll(){
        List eoms = new ArrayList<EasyOrganizerModel>();
        String sql = "SELECT id, title, description, subject, date FROM appointments";
        
        
        try {
           Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            // loop through the result set
            while (rs.next()) {
                eoms.add(new EasyOrganizerModel(rs.getInt("id"),
                        rs.getString("title"),
                        rs.getString("subject"),
                        rs.getString("description"),
                        new Date(rs.getLong("date"))));
            }
            stmt.close();
            return eoms;
        } catch (SQLException ex) {
            Logger.getLogger(DBHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return null;
    }
    
    public EasyOrganizerModel selectById(int id){
        EasyOrganizerModel eom = null;
        String sql = "SELECT id, title, description, subject, date FROM appointments WHERE id="+id;
        
        try {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            // loop through the result set
            while (rs.next()) {
                eom = new EasyOrganizerModel(rs.getInt("id"),
                        rs.getString("title"),
                        rs.getString("subject"),
                        rs.getString("description"),
                        new Date(rs.getLong("date")));
            }
            stmt.close();
            return eom;
        } catch (SQLException ex) {
            Logger.getLogger(DBHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return null;
    }
    
    public boolean delete(int id){
        String sql = "DELETE FROM appointments WHERE id = ?";
        
        PreparedStatement pstmt;
        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, id);
            pstmt.executeUpdate();
            return true;
        } catch (SQLException ex) {
            return false;
        }
        
    }
    
    public boolean update(EasyOrganizerModel eom){
        String sql = "UPDATE appointments SET title = ? , "
                + "subject = ?,"
                + "description = ?,"
                + "date = ? "
                + "WHERE id = ?";
        
        PreparedStatement pstmt;
        
        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, eom.getTitle());
            pstmt.setString(2, eom.getSubject());
            pstmt.setString(3, eom.getDescription());
            pstmt.setString(4, eom.getDate().toString());
            pstmt.setInt(5, eom.getId());
            // update
            pstmt.executeUpdate();
            pstmt.close();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(DBHandler.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        // set the corresponding param
        
        
    }
    
}
