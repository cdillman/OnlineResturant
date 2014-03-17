/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package DBAccessor;

import java.sql.*;

/**
 *
 * @author Corbin
 */
public class DB_Reader {
    
    private Connection conn;
    private String driver;
    private String url;
    private String user;
    private String pass;
    
    public static void main(String[] args) {
        
        DB_Reader db = new DB_Reader();
        
        db.driver = "com.mysql.jdbc.Driver";
        db.url = "jdbc:mysql://localhost:3306/sakila";
        db.user = "admin";
        db.pass = "admin";
        
        try{
            Class.forName(db.driver);
            db.conn = DriverManager.getConnection(db.url, db.user, db.pass);
        }
        catch(ClassNotFoundException cnfex){
            System.err.println(
			  "Error: Failed to load JDBC driver!" );
		   cnfex.printStackTrace();
		   System.exit( 1 );  // terminate program
		}
		catch ( SQLException sqlex ) {
		   System.err.println( "Error: Unable to connect to database!" );
		   sqlex.printStackTrace();
		   System.exit( 1 );  // terminate program
		}
        
        Statement stmt = null;
	ResultSet rs = null;
        
        String sql = "SELECT * FROM menu";
        
        try{
            stmt = db.conn.createStatement();
            rs = stmt.executeQuery(sql);
            
            int count = 0;
            while (rs.next()){
                System.out.println(count + 1);
                System.out.println("ITEM ID: " + rs.getString("ITEM_ID"));
                System.out.println("ITEM NAME: " + rs.getString("ITEM_NAME"));
                System.out.println("PRICE: " + rs.getString("PRICE"));
                count ++;
                
            }
            System.out.println("reccords found");
            
        } catch (SQLException sqle) {
            System.out.println(sqle);
        } catch (Exception e) {
            System.out.println(e);
        } finally {
        
            try {
                stmt.close();
                db.conn.close();
            } catch (Exception e){
                System.out.println(e);
            }
        }
    }
}
