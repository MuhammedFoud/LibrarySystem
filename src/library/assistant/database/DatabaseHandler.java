/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package library.assistant.database;

import com.mysql.cj.xdevapi.Statement;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;

/**
 *
 * @author mohamad
 */
public class DatabaseHandler {

    private static DatabaseHandler handler = null;

    private static final String DB_URL = "jdbc:derby:database;create=true";
    private static Connection conn = null;
    private static Statement stmt = null;

    public DatabaseHandler() {
        createConnection();        
    }
    
    
    
    
    private static void createConnection() {
        try {
            Class.forName("org.apache.derby.jdbc.EmbeddedDriver").newInstance();
            conn = DriverManager.getConnection(DB_URL);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
    /*
    void setBookTable() {
        String TABLE_NAME = "BOOK";
        try{
            stmt =(Statement) conn.createStatement();
            DatabaseMetaData dbm = conn.getMetaData();            
            ResultSet tables = dbm.getTables(null, null, TABLE_NAME.toUpperCase(), null);
            if(tables.next()){
                System.out.println("Table "+TABLE_NAME +" already exists.");
            }else{
                stmt.execute("CREATE TABLE " +TABLE_NAME+ "("
                        +"      id varchar(200) primary key,\n"
                        +"      title varchar(200),\n"
                        +"      auther varchar(200),\n"
                        +"      publisher varchar(200),\n"
                        +"      isAvail boolean default true,\n"
                        +" )");
            }
        }catch{
        }
    }*/
}
