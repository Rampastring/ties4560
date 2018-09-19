package webServices;

import javax.xml.ws.Endpoint;

public class Publisher {
	public static void main(String[] args) {
		//Endpoint ep = Endpoint.create("http://localhost:8080", new NameGeneratorServiceImpl());
		Endpoint.publish("http://localhost:8080/NameGeneratorService", new NameGeneratorServiceImpl());
	}
}