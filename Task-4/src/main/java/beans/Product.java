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
public class Product {
	
	private int productId;
	private String name;
	private String category;
	
	/**
	 * empty constructor
	 */
	public Product() {}
	
	/**
	 * @param id product id
	 * @param productName name of the product
	 * @param productCategory category that product belongs to
	 */
	public Product(int id, String productName, String productCategory) {
		this.productId = id;
		this.name = productName;
		this.category = productCategory;
	}
	
	/**
	 * @return the productId
	 */
	public int getProductId() {
		return productId;
	}
	/**
	 * @param productId the productId to set
	 */
	public void setProductId(int productId) {
		this.productId = productId;
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	@Override
	public String toString() {
		return "Product id: " + productId + ", product name: " + name + ", Product's category: " + category;
	}

	/**
	 * @return the category
	 */
	public String getCategory() {
		return category;
	}

	/**
	 * @param category the category to set
	 */
	public void setCategory(String category) {
		this.category = category;
	}

}
