package webServices;

import javax.jws.WebService;

import webServices.NameGeneratorServiceImpl.Gender;

@WebService
public interface NameGeneratorService {
	
	public String generateName(Gender gender);
	
	public String generateFirstName(Gender gender, int syllableCount);

	public String generateLastName(int syllableCount);
	
	Gender mapStringToGender(String gender);
}
