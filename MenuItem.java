/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package nitknightcanteen;

import java.math.BigDecimal;

/**
 * This class characterizes an individual menu item 
 * We import big decimal to handle the problem of arbitrarily long decimal places
 * We write a toString() method to easily return important information about the item
 */
public class MenuItem {

	private final String itemName;
	private final BigDecimal itemPrice;
	
	public MenuItem(String itemName, BigDecimal itemPrice) {
		
		this.itemName = itemName;
		this.itemPrice = itemPrice;
	}
	
	public String getName(){
		return itemName;
	}
	
	public BigDecimal getCost(){
		return itemPrice;
	}
	
	public String itemToString(){
		String info = itemName + "\n" + itemPrice;
		return info;
	}
        public String itemToString1(){
		String info = itemName + " " + itemPrice;
		return info;
	}
		
}



