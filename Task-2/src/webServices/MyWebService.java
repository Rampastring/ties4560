package webServices;

import javax.jws.WebService;

@WebService
public interface MyWebService {
	public String helloName(String name);
}
