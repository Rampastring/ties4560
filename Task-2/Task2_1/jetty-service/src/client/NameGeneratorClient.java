package client;

import localhost._8080.namegenerator.*;

public class NameGeneratorClient {
    public NameGeneratorClient() {}
	
    public String getFullName(Gender gender) {
    	NameGeneratorServiceImplService nameGeneratorService = new NameGeneratorServiceImplService();
    	NameGeneratorService soap = nameGeneratorService.getNameGeneratorServicePort();
    	return soap.generateName(gender);
    }
    
    public String getFirstName(Gender gender, int syllableCount) {
    	NameGeneratorServiceImplService nameGeneratorService = new NameGeneratorServiceImplService();
    	NameGeneratorService soap = nameGeneratorService.getNameGeneratorServicePort();
    	return soap.generateFirstName(gender, syllableCount);
    }
    
    public String getLastName(int syllableCount) {
    	NameGeneratorServiceImplService nameGeneratorService = new NameGeneratorServiceImplService();
    	NameGeneratorService soap = nameGeneratorService.getNameGeneratorServicePort();
    	return soap.generateLastName(syllableCount);
    }
}
