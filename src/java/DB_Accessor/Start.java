/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package DB_Accessor;

/**
 *
 * @author Corbin
 */
public class Start {
    public static void main(String[] args) {
        DBStrategy find = new FindRecords();
        DBStrategy edit = new EditRecord();
        DBStrategy add = new InsertRecord();
        DBStrategy delete = new DeleteRecord();
       
        find.AccessDB();
        edit.setItemName("Pizza");
        edit.setItemPrice("13");
        edit.setRecord("1");
        edit.AccessDB();
        find.AccessDB();
        
    }
}
