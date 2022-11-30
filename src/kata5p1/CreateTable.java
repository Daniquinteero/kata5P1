package kata5p1;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CreateTable {
    public static void CreateNewTable(String u){
        String url = "jdbc:sqlite:" + u;
        
        String sql = "create table if not exists email (id integer PRIMARY KEY AUTOINCREMENT, direccion text NOT NULL)";
        
        try {
            Connection conn = DriverManager.getConnection(url);
            Statement st = conn.createStatement();
            st.execute(sql);
            System.out.println("Tabla creada");
        } catch (SQLException ex) {
            ex.getMessage();
        }
        
    }
}
