/**
 * 
 */
package beans;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author Janita
 * @version 23.9.2018
 *
 */
@XmlRootElement
public class OrderRow {
	
	private int amount;
	private String productName;
	
	/**
	 * empty constructor
	 */
	public OrderRow() {
	}
	
	/**
	 * @param name order row's name
	 * @param amount how many of the products to be ordered
	 */
	public OrderRow(String name, int amount) {
		this.amount = amount;
		this.productName = name;
	}
	
	/**
	 * @return the productName
	 */
	public String getProductName() {
		return productName;
	}
	/**
	 * @param productName the productName to set
	 */
	public void setProductName(String productName) {
		this.productName = productName;
	}
	/**
	 * @return the amount
	 */
	public int getAmount() {
		return amount;
	}
	/**
	 * @param amount the amount to set
	 */
	public void setAmount(int amount) {
		this.amount = amount;
	}

}
