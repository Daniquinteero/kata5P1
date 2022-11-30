package kata5p1;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SelectApp {
    private final String url;

    public SelectApp(String url) {
        this.url = "jdbc:sqlite:" + url;
    }
    
    private Connection connect(){
        
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url);
        } catch (SQLException ex) {
            ex.getMessage();
            
        }
        return conn;
    }
    
    public void selectAll(){
        
        String sql = "SELECT * FROM PEOPLE";
        
        try (Connection conn = this.connect();
                Statement st = conn.createStatement();
                ResultSet rs = st.executeQuery(sql)){
            
            while (rs.next()){
                System.out.println(rs.getInt(1) + "\t" +
                                    rs.getString(2) + "\t" +
                                    rs.getString(3) + "\t" +
                                    rs.getString(4) + "\t");
            }
            
        } catch (SQLException ex) {
            ex.getMessage();
        }
    }
}
