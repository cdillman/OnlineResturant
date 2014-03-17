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
public class DBAccessor {

    private Connection conn;
    private String driverClassName;
    private String url;
    private String userName;
    private String password;

    public void FindRecords() {
        DBAccessor db = new DBAccessor();
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
            System.exit(1);  // terminate program
        } catch (SQLException sqlex) {
            System.err.println("Error: Unable to connect to database!");
            sqlex.printStackTrace();
            System.exit(1);  // terminate program
        }

        Statement stmt = null;
        ResultSet rs = null;

                //=======================================
        // Do a Query
        //=======================================
        String sql = "SELECT * FROM menu";

        try {
            stmt = db.conn.createStatement();
            rs = stmt.executeQuery(sql);

            System.out.println("============================");
            System.out.println("Output from MySQL Server...");
            System.out.println("============================");

            int count = 0;
            while (rs.next()) {
                System.out.println("\nRecord No: " + (count + 1));
                System.out.println("ID: " + rs.getInt("Item_ID")); // named field
                System.out.println("Item: " + rs.getString("Item_Name")); // named field
                System.out.println("Price: " + rs.getString("Item_Price"));
                count++;
            }
            System.out.println("==================\n" + count + " records found.");
        } catch (SQLException sqle) {
            System.out.println(sqle);
        } catch (Exception e) {
            System.out.println(e);
        } finally {
			// Make sure we close the statement and connection objects no matter what.
            // Since these also throw checked exceptions, we need a nested try-catch
            try {
                stmt.close();
                db.conn.close();
            } catch (Exception e) {
                System.out.println(e);
            }
        } 
    }
    
    public void UpdateRecord(){
            DBAccessor db = new DBAccessor();
        db.driverClassName = "com.mysql.jdbc.Driver";
        db.url = "jdbc:mysql://localhost:3306/resturant";
        db.userName = "root";
        db.password = "admin";
        String itemName = "Hamburger";
        String itemPrice = "5";
        String record = "1";

        try {
            Class.forName(db.driverClassName);
            db.conn = DriverManager.getConnection(db.url, db.userName, db.password);
        } catch (ClassNotFoundException cnfex) {
            System.err.println(
                    "Error: Failed to load JDBC driver!");
            cnfex.printStackTrace();
            System.exit(1);  // terminate program
        } catch (SQLException sqlex) {
            System.err.println("Error: Unable to connect to database!");
            sqlex.printStackTrace();
            System.exit(1);  // terminate program
        }

        Statement stmt = null;
        ResultSet rs = null;
        String sql = "SELECT * FROM menu";
        
        try {
            
            stmt = db.conn.createStatement();
            rs = stmt.executeQuery(sql);
        
        int recId = Integer.parseInt(record); // pick an existing id from your search results
                        sql = "UPDATE menu SET Item_Name = '" + itemName + "', Item_Price ='" + itemPrice + "'"
                                + " WHERE Item_ID = " + recId;
//                        
//                        // Notice that we use "excuteUpdate" for any write operations
//                        // Also notice that this returns an integer for the number of records affected
                        int updateCount = stmt.executeUpdate(sql);
        }  catch (SQLException sqle) {
			System.out.println(sqle);
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			// Make sure we close the statement and connection objects no matter what.
			// Since these also throw checked exceptions, we need a nested try-catch
			try {
				stmt.close();
				db.conn.close();
			} catch(Exception e) {
				System.out.println(e);
			}
        }
    }
    
    public void AddRecord(){
            DBAccessor db = new DBAccessor();
        db.driverClassName = "com.mysql.jdbc.Driver";
        db.url = "jdbc:mysql://localhost:3306/resturant";
        db.userName = "root";
        db.password = "admin";
        String itemName = "Poppers";
        String itemPrice = "4.95";

        try {
            Class.forName(db.driverClassName);
            db.conn = DriverManager.getConnection(db.url, db.userName, db.password);
        } catch (ClassNotFoundException cnfex) {
            System.err.println(
                    "Error: Failed to load JDBC driver!");
            cnfex.printStackTrace();
            System.exit(1);  // terminate program
        } catch (SQLException sqlex) {
            System.err.println("Error: Unable to connect to database!");
            sqlex.printStackTrace();
            System.exit(1);  // terminate program
        }

        Statement stmt = null;
        ResultSet rs = null;
        String sql = "SELECT * FROM menu";
        
        try {
            
            stmt = db.conn.createStatement();
            rs = stmt.executeQuery(sql);
        
       int updateCount;
//                         No need for an id if it is autogenerated by the database server
                        sql = "INSERT INTO menu (Item_Name,Item_Price)"
                                + " VALUES('" + itemName + "','" + itemPrice + "')";
                        
//                         Notice that we use "excuteUpdate" for any write operations
//                         Also notice that this returns an integer for the number of records affected
                        updateCount = stmt.executeUpdate(sql);
//                        
//                        // Notice that we use "excuteUpdate" for any write operations
//                        // Also notice that this returns an integer for the number of records affected
                        
        }  catch (SQLException sqle) {
			System.out.println(sqle);
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			// Make sure we close the statement and connection objects no matter what.
			// Since these also throw checked exceptions, we need a nested try-catch
			try {
				stmt.close();
				db.conn.close();
			} catch(Exception e) {
				System.out.println(e);
			}
        }
    }
    
        public void DeleteRecord(){
            DBAccessor db = new DBAccessor();
        db.driverClassName = "com.mysql.jdbc.Driver";
        db.url = "jdbc:mysql://localhost:3306/resturant";
        db.userName = "root";
        db.password = "admin";
        String itemID = "3";

        try {
            Class.forName(db.driverClassName);
            db.conn = DriverManager.getConnection(db.url, db.userName, db.password);
        } catch (ClassNotFoundException cnfex) {
            System.err.println(
                    "Error: Failed to load JDBC driver!");
            cnfex.printStackTrace();
            System.exit(1);  // terminate program
        } catch (SQLException sqlex) {
            System.err.println("Error: Unable to connect to database!");
            sqlex.printStackTrace();
            System.exit(1);  // terminate program
        }

        Statement stmt = null;
        ResultSet rs = null;
        String sql = "SELECT * FROM menu";
        
        try {
            
            stmt = db.conn.createStatement();
            rs = stmt.executeQuery(sql);
        
       int updateCount;
       int deleteId = Integer.parseInt(itemID); // replace this with an existing id to delete
                        sql = "DELETE FROM menu WHERE"
                                + " Item_ID = " + deleteId;
                        updateCount = stmt.executeUpdate(sql);
//                        
//                        // Notice that we use "excuteUpdate" for any write operations
//                        // Also notice that this returns an integer for the number of records affected
                        
        }  catch (SQLException sqle) {
			System.out.println(sqle);
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			// Make sure we close the statement and connection objects no matter what.
			// Since these also throw checked exceptions, we need a nested try-catch
			try {
				stmt.close();
				db.conn.close();
			} catch(Exception e) {
				System.out.println(e);
			}
        }
    }
    public static void main(String[] args) {
        DBAccessor db = new DBAccessor();
        
        db.FindRecords();
        
        db.UpdateRecord();
        db.AddRecord();
        db.FindRecords();
        
        db.DeleteRecord();
        db.FindRecords();
    }
}
