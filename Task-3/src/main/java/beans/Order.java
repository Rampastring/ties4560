/**
 * 
 */
package beans;

import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author Janita
 * @version 23.9.2018
 *
 */
@XmlRootElement
public class Order {
	
	private int orderId;
	private List<OrderRow> rows;
	
	/**
	 * empty constructor
	 */
	public Order() {}
	
	/**
	 * @param id order id
	 * @param orderRows list of order rows
	 */
	public Order(int id, List<OrderRow> orderRows) {
		this.orderId = id;
		this.rows = orderRows;
	}

	/**
	 * @return the orderId
	 */
	public int getOrderId() {
		return orderId;
	}

	/**
	 * @param orderId the orderId to set
	 */
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	/**
	 * @return the rows
	 */
	public List<OrderRow> getRows() {
		return rows;
	}

	/**
	 * @param rows the rows to set
	 */
	public void setRows(List<OrderRow> rows) {
		this.rows = rows;
	}

}
