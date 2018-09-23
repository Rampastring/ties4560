/**
 * 
 */
package com.ties4560.task3;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import beans.Order;

/**
 * @author Janita
 * @version 23.9.2018
 *
 */
@Path("orders")
public class OrdersResource {
	
	/**
	 * @param id orderId
	 * @return order by given id
	 */
	@GET
	@Path("/{orderId}")
	@Produces(MediaType.APPLICATION_JSON)
	public Order getOrder(@PathParam("orderId") int id) {
		// TODO: implementation
		return null;
	}
	
	/**
	 * @param order order to create
	 * @return created order
	 */
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Order createOrder(Order order) {
		// TODO: implementation
		return null;
	}
	
	/**
	 * @param id order's id
	 * @param order created order
	 * @return updated order
	 */
	@PUT
	@Path("/{orderId}")
	@Consumes(MediaType.APPLICATION_JSON)
	public Order updateOrder(@PathParam("orderId") int id, Order order) {
		// TODO: implementation
		return null;
	}

}
