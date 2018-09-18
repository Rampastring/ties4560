package webServices;

import javax.jws.WebService;

import webServices.NameGeneratorServiceImpl.Gender;

@WebService
public interface NameGeneratorService {
	
	public String generateName(Gender gender);

	Gender mapStringToGender(String gender);
}
