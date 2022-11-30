package kata5p1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class TableDataInsertion {
    
    
    private Connection connect() {
        
        String url = "jdbc:sqlite:kata5.db";
        
        Connection conn = null;
        
        try {
            conn = DriverManager.getConnection(url);
                    
        } catch (SQLException ex) {
            ex.getMessage();
        }
        return conn;
    }
    
    public void insertList(Iterable<String> email){
        String sql = "insert into email(direccion) VALUES(?)";
        try (Connection conn = this.connect();
                PreparedStatement pst = conn.prepareStatement(sql)) {
            
            for (String object : email) {
                pst.setString(1, object);
                pst.executeUpdate();
            }

            
        } catch (SQLException ex) {
            ex.getMessage();
        }
    }
}
