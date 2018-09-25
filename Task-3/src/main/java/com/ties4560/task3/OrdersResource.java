/**
 * 
 */
package com.ties4560.task3;

import java.util.HashMap;
import java.util.List;

import javax.inject.Singleton;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.DELETE;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import beans.Order;
import beans.OrderRow;

/**
 * @author Janita, Jere, Rami
 * @version 25.9.2018
 *
 */
@Path("orders")
@Singleton
public class OrdersResource {
	
	private HashMap<Integer, Order> orderMap = new HashMap<Integer, Order>();
	
	/**
	 * @param id orderId
	 * @return order by given id
	 */
	@GET
	@Path("/{orderId}")
	@Produces(MediaType.APPLICATION_JSON)
	public Order getOrder(@PathParam("orderId") int id) {		
		return orderMap.get(id);
	}
	
	/**
	 * @param order order to create
	 * @return created order
	 */
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Order createOrder(Order order) {
		orderMap.put(order.getOrderId(), order);
		return order;
	}
	
	/**
	 * @param id order's id
	 * @param order created order
	 * @return updated order
	 */
	@PUT
	@Path("/{orderId}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Order updateOrder(@PathParam("orderId") int id, List<OrderRow> orderRows) {
		Order order = orderMap.get(id);
		order.setRows(orderRows);
		
		return order;
	}
	
	/**
	 * @param id orderId
	 * @return order by given id
	 */
	@DELETE
	@Path("/{orderId}")
	@Produces(MediaType.APPLICATION_JSON)
	public Order deleteOrder(@PathParam("orderId") int id) {		
		return orderMap.remove(id);
	}

}
