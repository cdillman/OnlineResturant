/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package DB_Accessor;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Corbin
 */
public class EditRecord implements DBStrategy{
    private Connection conn;
    private String driverClassName;
    private String url;
    private String userName;
    private String password;
    private String itemName ;
    private String itemPrice;
    private String record;
    
    public void AccessDB(){
        UpdateRecord();
    }
    
    public void UpdateRecord(){
        EditRecord db = new EditRecord();
        db.driverClassName = "com.mysql.jdbc.Driver";
        db.url = "jdbc:mysql://localhost:3306/resturant";
        db.userName = "root";
        db.password = "admin";
        

        try {
            Class.forName(db.driverClassName);
            db.conn = DriverManager.getConnection(db.url, db.userName, db.password);
        } catch (ClassNotFoundException cnfex) {
            System.err.println(
                    "Error: Failed to load JDBC driver!");
            cnfex.printStackTrace();
            System.exit(1);  
        } catch (SQLException sqlex) {
            System.err.println("Error: Unable to connect to database!");
            sqlex.printStackTrace();
            System.exit(1); 
        }

        Statement stmt = null;
        ResultSet rs = null;
        String sql = "SELECT * FROM menu";
        
        try {
            
            stmt = db.conn.createStatement();
            rs = stmt.executeQuery(sql);
        
        int recId = Integer.parseInt(record);
        sql = "UPDATE menu SET Item_Name = '" + itemName + "', Item_Price ='" + itemPrice + "'"
                                + " WHERE Item_ID = " + recId;

        int updateCount = stmt.executeUpdate(sql);
        }  catch (SQLException sqle) {
			System.out.println(sqle);
		} catch (Exception e) {
			System.out.println(e);
		} finally {

            try {
				stmt.close();
				db.conn.close();
			} catch(Exception e) {
				System.out.println(e);
			}
        }
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getItemPrice() {
        return itemPrice;
    }

    public void setItemPrice(String itemPrice) {
        this.itemPrice = itemPrice;
    }

    public String getRecord() {
        return record;
    }

    public void setRecord(String record) {
        this.record = record;
    }
    
    
}
