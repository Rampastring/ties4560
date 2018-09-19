
package localhost._8080.namegenerator;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the localhost._8080.namegenerator package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _GenerateNameResponse_QNAME = new QName("http://localhost:8080/NameGenerator", "generateNameResponse");
    private final static QName _GenerateLastName_QNAME = new QName("http://localhost:8080/NameGenerator", "generateLastName");
    private final static QName _GetMaleFirstNameSyllables_QNAME = new QName("http://localhost:8080/NameGenerator", "getMaleFirstNameSyllables");
    private final static QName _MapStringToGender_QNAME = new QName("http://localhost:8080/NameGenerator", "mapStringToGender");
    private final static QName _GetFemaleFirstNameSyllablesResponse_QNAME = new QName("http://localhost:8080/NameGenerator", "getFemaleFirstNameSyllablesResponse");
    private final static QName _GetFemaleFirstNameSyllables_QNAME = new QName("http://localhost:8080/NameGenerator", "getFemaleFirstNameSyllables");
    private final static QName _GetLastNameSyllables_QNAME = new QName("http://localhost:8080/NameGenerator", "getLastNameSyllables");
    private final static QName _GenerateLastNameResponse_QNAME = new QName("http://localhost:8080/NameGenerator", "generateLastNameResponse");
    private final static QName _GenerateFirstName_QNAME = new QName("http://localhost:8080/NameGenerator", "generateFirstName");
    private final static QName _GenerateName_QNAME = new QName("http://localhost:8080/NameGenerator", "generateName");
    private final static QName _GetLastNameSyllablesResponse_QNAME = new QName("http://localhost:8080/NameGenerator", "getLastNameSyllablesResponse");
    private final static QName _GetMaleFirstNameSyllablesResponse_QNAME = new QName("http://localhost:8080/NameGenerator", "getMaleFirstNameSyllablesResponse");
    private final static QName _GenerateFirstNameResponse_QNAME = new QName("http://localhost:8080/NameGenerator", "generateFirstNameResponse");
    private final static QName _MapStringToGenderResponse_QNAME = new QName("http://localhost:8080/NameGenerator", "mapStringToGenderResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: localhost._8080.namegenerator
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link GetFemaleFirstNameSyllables }
     * 
     */
    public GetFemaleFirstNameSyllables createGetFemaleFirstNameSyllables() {
        return new GetFemaleFirstNameSyllables();
    }

    /**
     * Create an instance of {@link GetLastNameSyllables }
     * 
     */
    public GetLastNameSyllables createGetLastNameSyllables() {
        return new GetLastNameSyllables();
    }

    /**
     * Create an instance of {@link GenerateLastNameResponse }
     * 
     */
    public GenerateLastNameResponse createGenerateLastNameResponse() {
        return new GenerateLastNameResponse();
    }

    /**
     * Create an instance of {@link GenerateFirstName }
     * 
     */
    public GenerateFirstName createGenerateFirstName() {
        return new GenerateFirstName();
    }

    /**
     * Create an instance of {@link GenerateName }
     * 
     */
    public GenerateName createGenerateName() {
        return new GenerateName();
    }

    /**
     * Create an instance of {@link GetLastNameSyllablesResponse }
     * 
     */
    public GetLastNameSyllablesResponse createGetLastNameSyllablesResponse() {
        return new GetLastNameSyllablesResponse();
    }

    /**
     * Create an instance of {@link GetMaleFirstNameSyllablesResponse }
     * 
     */
    public GetMaleFirstNameSyllablesResponse createGetMaleFirstNameSyllablesResponse() {
        return new GetMaleFirstNameSyllablesResponse();
    }

    /**
     * Create an instance of {@link GenerateFirstNameResponse }
     * 
     */
    public GenerateFirstNameResponse createGenerateFirstNameResponse() {
        return new GenerateFirstNameResponse();
    }

    /**
     * Create an instance of {@link MapStringToGenderResponse }
     * 
     */
    public MapStringToGenderResponse createMapStringToGenderResponse() {
        return new MapStringToGenderResponse();
    }

    /**
     * Create an instance of {@link GenerateNameResponse }
     * 
     */
    public GenerateNameResponse createGenerateNameResponse() {
        return new GenerateNameResponse();
    }

    /**
     * Create an instance of {@link GenerateLastName }
     * 
     */
    public GenerateLastName createGenerateLastName() {
        return new GenerateLastName();
    }

    /**
     * Create an instance of {@link MapStringToGender }
     * 
     */
    public MapStringToGender createMapStringToGender() {
        return new MapStringToGender();
    }

    /**
     * Create an instance of {@link GetMaleFirstNameSyllables }
     * 
     */
    public GetMaleFirstNameSyllables createGetMaleFirstNameSyllables() {
        return new GetMaleFirstNameSyllables();
    }

    /**
     * Create an instance of {@link GetFemaleFirstNameSyllablesResponse }
     * 
     */
    public GetFemaleFirstNameSyllablesResponse createGetFemaleFirstNameSyllablesResponse() {
        return new GetFemaleFirstNameSyllablesResponse();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GenerateNameResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://localhost:8080/NameGenerator", name = "generateNameResponse")
    public JAXBElement<GenerateNameResponse> createGenerateNameResponse(GenerateNameResponse value) {
        return new JAXBElement<GenerateNameResponse>(_GenerateNameResponse_QNAME, GenerateNameResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GenerateLastName }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://localhost:8080/NameGenerator", name = "generateLastName")
    public JAXBElement<GenerateLastName> createGenerateLastName(GenerateLastName value) {
        return new JAXBElement<GenerateLastName>(_GenerateLastName_QNAME, GenerateLastName.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetMaleFirstNameSyllables }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://localhost:8080/NameGenerator", name = "getMaleFirstNameSyllables")
    public JAXBElement<GetMaleFirstNameSyllables> createGetMaleFirstNameSyllables(GetMaleFirstNameSyllables value) {
        return new JAXBElement<GetMaleFirstNameSyllables>(_GetMaleFirstNameSyllables_QNAME, GetMaleFirstNameSyllables.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link MapStringToGender }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://localhost:8080/NameGenerator", name = "mapStringToGender")
    public JAXBElement<MapStringToGender> createMapStringToGender(MapStringToGender value) {
        return new JAXBElement<MapStringToGender>(_MapStringToGender_QNAME, MapStringToGender.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetFemaleFirstNameSyllablesResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://localhost:8080/NameGenerator", name = "getFemaleFirstNameSyllablesResponse")
    public JAXBElement<GetFemaleFirstNameSyllablesResponse> createGetFemaleFirstNameSyllablesResponse(GetFemaleFirstNameSyllablesResponse value) {
        return new JAXBElement<GetFemaleFirstNameSyllablesResponse>(_GetFemaleFirstNameSyllablesResponse_QNAME, GetFemaleFirstNameSyllablesResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetFemaleFirstNameSyllables }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://localhost:8080/NameGenerator", name = "getFemaleFirstNameSyllables")
    public JAXBElement<GetFemaleFirstNameSyllables> createGetFemaleFirstNameSyllables(GetFemaleFirstNameSyllables value) {
        return new JAXBElement<GetFemaleFirstNameSyllables>(_GetFemaleFirstNameSyllables_QNAME, GetFemaleFirstNameSyllables.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetLastNameSyllables }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://localhost:8080/NameGenerator", name = "getLastNameSyllables")
    public JAXBElement<GetLastNameSyllables> createGetLastNameSyllables(GetLastNameSyllables value) {
        return new JAXBElement<GetLastNameSyllables>(_GetLastNameSyllables_QNAME, GetLastNameSyllables.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GenerateLastNameResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://localhost:8080/NameGenerator", name = "generateLastNameResponse")
    public JAXBElement<GenerateLastNameResponse> createGenerateLastNameResponse(GenerateLastNameResponse value) {
        return new JAXBElement<GenerateLastNameResponse>(_GenerateLastNameResponse_QNAME, GenerateLastNameResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GenerateFirstName }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://localhost:8080/NameGenerator", name = "generateFirstName")
    public JAXBElement<GenerateFirstName> createGenerateFirstName(GenerateFirstName value) {
        return new JAXBElement<GenerateFirstName>(_GenerateFirstName_QNAME, GenerateFirstName.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GenerateName }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://localhost:8080/NameGenerator", name = "generateName")
    public JAXBElement<GenerateName> createGenerateName(GenerateName value) {
        return new JAXBElement<GenerateName>(_GenerateName_QNAME, GenerateName.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetLastNameSyllablesResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://localhost:8080/NameGenerator", name = "getLastNameSyllablesResponse")
    public JAXBElement<GetLastNameSyllablesResponse> createGetLastNameSyllablesResponse(GetLastNameSyllablesResponse value) {
        return new JAXBElement<GetLastNameSyllablesResponse>(_GetLastNameSyllablesResponse_QNAME, GetLastNameSyllablesResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetMaleFirstNameSyllablesResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://localhost:8080/NameGenerator", name = "getMaleFirstNameSyllablesResponse")
    public JAXBElement<GetMaleFirstNameSyllablesResponse> createGetMaleFirstNameSyllablesResponse(GetMaleFirstNameSyllablesResponse value) {
        return new JAXBElement<GetMaleFirstNameSyllablesResponse>(_GetMaleFirstNameSyllablesResponse_QNAME, GetMaleFirstNameSyllablesResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GenerateFirstNameResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://localhost:8080/NameGenerator", name = "generateFirstNameResponse")
    public JAXBElement<GenerateFirstNameResponse> createGenerateFirstNameResponse(GenerateFirstNameResponse value) {
        return new JAXBElement<GenerateFirstNameResponse>(_GenerateFirstNameResponse_QNAME, GenerateFirstNameResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link MapStringToGenderResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://localhost:8080/NameGenerator", name = "mapStringToGenderResponse")
    public JAXBElement<MapStringToGenderResponse> createMapStringToGenderResponse(MapStringToGenderResponse value) {
        return new JAXBElement<MapStringToGenderResponse>(_MapStringToGenderResponse_QNAME, MapStringToGenderResponse.class, null, value);
    }

}
