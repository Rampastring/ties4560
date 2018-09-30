/**
 * 
 */
package beans;

import java.io.Serializable;
import java.security.Principal;

/**
 * @author Janita
 * @version 30.9.2018
 *
 */
public class Credential implements Serializable, Principal {
	
	/**
	 * Empty constructor.
	 */
	public Credential() {}
	
	/**
	 * Basic constructor.
	 * 
	 * @param username name for the user
	 * @param password password
	 */
	public Credential(String username, String password) {
		this.name = username;
		this.password = password;
	}

	/**
	 * uses default serialVersionUID
	 */
	private static final long serialVersionUID = 1L;
	private String name;
	private String password;
	
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
	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}
	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	
}
