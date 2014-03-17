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
public interface DBStrategy {
    
    public void AccessDB();
    public void setItemName(String itemName);
    public void setItemPrice(String itemPrice);
    public void setRecord(String record);
    
}
