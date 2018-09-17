package webServices;

import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService
public class MyWebServiceImpl implements MyWebService {
	@Override
	@WebMethod
	public String helloName(String name) {
		// TODO Auto-generated method stub
		return "Hello there " + name;
	}
}
