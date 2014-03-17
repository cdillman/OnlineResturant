/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Model;

import java.util.Objects;

/**
 *
 * @author Corbin
 */
public class MenuItem {
    private String itemID;
    private String itemName;
    private String itemPrice;

    public MenuItem(){
    }
    
    public MenuItem(String itemID, String itemName, String itemPrice){
        this.itemID = itemID;
        this.itemName = itemName;
        this.itemPrice = itemPrice;
    }
    
    public String getItemID() {
        return itemID;
    }

    public void setItemID(String itemID) {
        this.itemID = itemID;
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

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 97 * hash + Objects.hashCode(this.itemID);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final MenuItem other = (MenuItem) obj;
        if (!Objects.equals(this.itemID, other.itemID)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return  itemID +  itemName +  itemPrice;
    }
    
    
}
