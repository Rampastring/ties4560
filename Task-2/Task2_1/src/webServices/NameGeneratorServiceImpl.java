package webServices;

import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;
import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService
public class NameGeneratorServiceImpl implements NameGeneratorService {
	private List<String> _maleFirstNameSyllables = Arrays.asList(
			"mon", "fay", "shi",
			"zag", "blarg", "rash",
			"gabor", "lok", "izen",
			"co", "an", "dil", 
			"lin", "bry", "an", 
			"xin", "es", "jay");
	
	private List<String> _femaleFirstNameSyllables = Arrays.asList(
			"naw", "lor", "she",
			"karen", "la", "vin",
			"nita", "fem", "ela",
			"bon", "donna", "khi");
	
	private List<String> _lastNameSyllables = Arrays.asList(
			"malo", "zak", "abo",
			"wonk", "hago", "buzar",
			"jin", "ramus", "kolo",
			"web", "ber", "jor",
			"dan", "poz", "zon");
	

	@Override
	@WebMethod
	public String generateName(Gender gender) {
		return generateFirstName(gender) + " " + generateLastName();
	}
		
	private String generateFirstName(Gender gender) {
		String firstName = "";
		int numberOfSyllablesInFirstName = ThreadLocalRandom.current().nextInt(2, 4);
		
		List<String> firstNameSyllables = gender == Gender.MALE 
				? this.getMaleFirstNameSyllables()
				: this.getFemaleFirstNameSyllables();
		
		for (int i = 0; i < numberOfSyllablesInFirstName; i++)
    	{
			firstName += firstNameSyllables.get(ThreadLocalRandom.current().nextInt(0, firstNameSyllables.size()));
    	}
		
		return firstName.substring(0,1).toUpperCase() + firstName.substring(1).toLowerCase();
	}
	
	private String generateLastName() {
		String lastName = "";
		int numberOfSyllablesInLastName = ThreadLocalRandom.current().nextInt(1, 3);
		
		for (int i = 0; i < numberOfSyllablesInLastName; i++)
    	{
			lastName += this.getLastNameSyllables().get(ThreadLocalRandom.current().nextInt(0, this.getLastNameSyllables().size()));
    	}
		
		return lastName.substring(0,1).toUpperCase() + lastName.substring(1).toLowerCase();
	}
	
	public List<String> getMaleFirstNameSyllables() {
		return this._maleFirstNameSyllables;
	}
	
	public List<String> getFemaleFirstNameSyllables() {
		return this._femaleFirstNameSyllables;
	}
	
	public List<String> getLastNameSyllables() {
		return this._lastNameSyllables;
	}
	
	@Override
	@WebMethod
	public Gender mapStringToGender(String gender) {
		gender = gender.toLowerCase();
		
		switch (gender) {
			case "male":
				return Gender.MALE;
			case "female":
				return Gender.FEMALE;
			default:
				return Gender.FEMALE; // Sorry boys, it's just a simple implementation.
		}
	}
	
	public enum Gender {
		MALE, 
		FEMALE
	}
}
