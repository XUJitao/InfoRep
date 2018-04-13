
package client;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the client package. 
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

    private final static QName _EntreeNonEntierException_QNAME = new QName("http://service.SOAP/", "EntreeNonEntierException");
    private final static QName _Multiplication_QNAME = new QName("http://service.SOAP/", "multiplication");
    private final static QName _DiviseurNullException_QNAME = new QName("http://service.SOAP/", "DiviseurNullException");
    private final static QName _Addition_QNAME = new QName("http://service.SOAP/", "addition");
    private final static QName _Division_QNAME = new QName("http://service.SOAP/", "division");
    private final static QName _DivisionResponse_QNAME = new QName("http://service.SOAP/", "divisionResponse");
    private final static QName _EntreeNegatifException_QNAME = new QName("http://service.SOAP/", "EntreeNegatifException");
    private final static QName _GetOperande_QNAME = new QName("http://service.SOAP/", "getOperande");
    private final static QName _GetOperandeResponse_QNAME = new QName("http://service.SOAP/", "getOperandeResponse");
    private final static QName _MultiplicationResponse_QNAME = new QName("http://service.SOAP/", "multiplicationResponse");
    private final static QName _Soustraction_QNAME = new QName("http://service.SOAP/", "soustraction");
    private final static QName _SoustractionResponse_QNAME = new QName("http://service.SOAP/", "soustractionResponse");
    private final static QName _AdditionResponse_QNAME = new QName("http://service.SOAP/", "additionResponse");
    private final static QName _ResultatNegatifException_QNAME = new QName("http://service.SOAP/", "ResultatNegatifException");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: client
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link SoustractionResponse }
     * 
     */
    public SoustractionResponse createSoustractionResponse() {
        return new SoustractionResponse();
    }

    /**
     * Create an instance of {@link ResultatNegatifException }
     * 
     */
    public ResultatNegatifException createResultatNegatifException() {
        return new ResultatNegatifException();
    }

    /**
     * Create an instance of {@link AdditionResponse }
     * 
     */
    public AdditionResponse createAdditionResponse() {
        return new AdditionResponse();
    }

    /**
     * Create an instance of {@link MultiplicationResponse }
     * 
     */
    public MultiplicationResponse createMultiplicationResponse() {
        return new MultiplicationResponse();
    }

    /**
     * Create an instance of {@link Soustraction }
     * 
     */
    public Soustraction createSoustraction() {
        return new Soustraction();
    }

    /**
     * Create an instance of {@link Division }
     * 
     */
    public Division createDivision() {
        return new Division();
    }

    /**
     * Create an instance of {@link DivisionResponse }
     * 
     */
    public DivisionResponse createDivisionResponse() {
        return new DivisionResponse();
    }

    /**
     * Create an instance of {@link GetOperande }
     * 
     */
    public GetOperande createGetOperande() {
        return new GetOperande();
    }

    /**
     * Create an instance of {@link GetOperandeResponse }
     * 
     */
    public GetOperandeResponse createGetOperandeResponse() {
        return new GetOperandeResponse();
    }

    /**
     * Create an instance of {@link EntreeNegatifException }
     * 
     */
    public EntreeNegatifException createEntreeNegatifException() {
        return new EntreeNegatifException();
    }

    /**
     * Create an instance of {@link EntreeNonEntierException }
     * 
     */
    public EntreeNonEntierException createEntreeNonEntierException() {
        return new EntreeNonEntierException();
    }

    /**
     * Create an instance of {@link Multiplication }
     * 
     */
    public Multiplication createMultiplication() {
        return new Multiplication();
    }

    /**
     * Create an instance of {@link DiviseurNullException }
     * 
     */
    public DiviseurNullException createDiviseurNullException() {
        return new DiviseurNullException();
    }

    /**
     * Create an instance of {@link Addition }
     * 
     */
    public Addition createAddition() {
        return new Addition();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link EntreeNonEntierException }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.SOAP/", name = "EntreeNonEntierException")
    public JAXBElement<EntreeNonEntierException> createEntreeNonEntierException(EntreeNonEntierException value) {
        return new JAXBElement<EntreeNonEntierException>(_EntreeNonEntierException_QNAME, EntreeNonEntierException.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Multiplication }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.SOAP/", name = "multiplication")
    public JAXBElement<Multiplication> createMultiplication(Multiplication value) {
        return new JAXBElement<Multiplication>(_Multiplication_QNAME, Multiplication.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DiviseurNullException }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.SOAP/", name = "DiviseurNullException")
    public JAXBElement<DiviseurNullException> createDiviseurNullException(DiviseurNullException value) {
        return new JAXBElement<DiviseurNullException>(_DiviseurNullException_QNAME, DiviseurNullException.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Addition }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.SOAP/", name = "addition")
    public JAXBElement<Addition> createAddition(Addition value) {
        return new JAXBElement<Addition>(_Addition_QNAME, Addition.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Division }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.SOAP/", name = "division")
    public JAXBElement<Division> createDivision(Division value) {
        return new JAXBElement<Division>(_Division_QNAME, Division.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DivisionResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.SOAP/", name = "divisionResponse")
    public JAXBElement<DivisionResponse> createDivisionResponse(DivisionResponse value) {
        return new JAXBElement<DivisionResponse>(_DivisionResponse_QNAME, DivisionResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link EntreeNegatifException }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.SOAP/", name = "EntreeNegatifException")
    public JAXBElement<EntreeNegatifException> createEntreeNegatifException(EntreeNegatifException value) {
        return new JAXBElement<EntreeNegatifException>(_EntreeNegatifException_QNAME, EntreeNegatifException.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetOperande }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.SOAP/", name = "getOperande")
    public JAXBElement<GetOperande> createGetOperande(GetOperande value) {
        return new JAXBElement<GetOperande>(_GetOperande_QNAME, GetOperande.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetOperandeResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.SOAP/", name = "getOperandeResponse")
    public JAXBElement<GetOperandeResponse> createGetOperandeResponse(GetOperandeResponse value) {
        return new JAXBElement<GetOperandeResponse>(_GetOperandeResponse_QNAME, GetOperandeResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link MultiplicationResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.SOAP/", name = "multiplicationResponse")
    public JAXBElement<MultiplicationResponse> createMultiplicationResponse(MultiplicationResponse value) {
        return new JAXBElement<MultiplicationResponse>(_MultiplicationResponse_QNAME, MultiplicationResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Soustraction }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.SOAP/", name = "soustraction")
    public JAXBElement<Soustraction> createSoustraction(Soustraction value) {
        return new JAXBElement<Soustraction>(_Soustraction_QNAME, Soustraction.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SoustractionResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.SOAP/", name = "soustractionResponse")
    public JAXBElement<SoustractionResponse> createSoustractionResponse(SoustractionResponse value) {
        return new JAXBElement<SoustractionResponse>(_SoustractionResponse_QNAME, SoustractionResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AdditionResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.SOAP/", name = "additionResponse")
    public JAXBElement<AdditionResponse> createAdditionResponse(AdditionResponse value) {
        return new JAXBElement<AdditionResponse>(_AdditionResponse_QNAME, AdditionResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ResultatNegatifException }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.SOAP/", name = "ResultatNegatifException")
    public JAXBElement<ResultatNegatifException> createResultatNegatifException(ResultatNegatifException value) {
        return new JAXBElement<ResultatNegatifException>(_ResultatNegatifException_QNAME, ResultatNegatifException.class, null, value);
    }

}
