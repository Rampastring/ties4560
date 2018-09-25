/**
 * 
 */
package com.ties4560.task3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import beans.Product;

/**
 * @author Janita, Rami, Jaro
 * @version 25.9.2018
 *
 */
@Path("products")
public class ProductsResource {
	
	private List<Product> productList = Arrays.asList(new Product(1, "Oxford University Press Solo Time For Violin Book 1", "Sheet music"), 
			new Product(2, "Squier Classic Vibe Strat MN 2TS", "Guitar"),
			new Product(3, "Epiphone Les Paul 100 Ebony", "Guitar"),
			new Product(4, "Yamaha B3EPE Upright piano, black", "Piano"),
			new Product(5, "GROTRIAN-STEINWEG GS132PE Upright piano, white", "Piano"));
	
	/**
	 * @return list of products in the music store
	 */
	@GET
	//@Produces(MediaType.TEXT_PLAIN)
	public Response getProducts(@QueryParam("category") String category) {
		List<Product> returnedList;
		if (category == null || category.equals("")) {
			returnedList = new ArrayList<Product>(productList);
		} else {
			returnedList = new ArrayList<Product>();
			for (Product product : productList) {
				if (product.getCategory().equals(category)) {
					returnedList.add(product);
				}
			}
		}
		
		return Response.status(Status.OK).entity(returnedList).build();
		//return productList.stream().map(Product::toString()).collect(Collectors.joining("\r\n"));
	}

	@GET
	@Path("/{productId}")
	//@Produces(MediaType.APPLICATION_JSON)
	public Response getProduct(@PathParam("productId") int id) {
		for (Product product : productList) {
			if (product.getProductId() == id) {
				return Response.status(Status.OK).entity(product).build();
			}
		}
		
		throw new DataNotFoundException("Product with id "+id+" was not found.");
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	// @Produces(MediaType.APPLICATION_JSON)
	public Response createProduct(Product product) {
		productList.add(product);
		return Response.status(Status.CREATED).entity(product).build();
	}
}
