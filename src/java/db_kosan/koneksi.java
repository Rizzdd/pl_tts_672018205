
package db_kosan;

import java.sql.Connection;
import java.sql.DriverManager;

public class koneksi {
    private String dbDriver = "com.mysql.jdbc.Driver";
    private String dbUsername = "root";
    private String dbPassword = "";
    private String dbURL = "jdbc:mysql://localhost:3306/db_coba?zeroDateTimeBehavior=CONVERT_TO_NULL";
    
    private Connection kon;
    
    public koneksi(){ 
        try{
            Class.forName(dbDriver);
            kon = DriverManager.getConnection(dbURL, dbUsername, dbPassword);
        } catch (Exception e){
            kon = null;
        }
    }
    
    public Connection getkon(){
        return kon;
    }
    
}
