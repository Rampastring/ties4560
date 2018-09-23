/**
 * 
 */
package com.ties4560.task3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import beans.Product;

/**
 * @author Janita
 * @version 23.9.2018
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
	@Produces(MediaType.TEXT_PLAIN)
	public String getProducts() {
		return productList.stream().map(Product::toString).collect(Collectors.joining("\r\n"));
	}

}
