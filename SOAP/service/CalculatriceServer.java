package SOAP.service;

import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;

@WebService
public interface CalculatriceServer {
	@WebMethod
	public int addition(int a, int b);

	@WebMethod
	public int soustraction(int a, int b) throws ResultatNegatifException;

	@WebMethod
	public int multiplication(int a, int b);

	@WebMethod
	public int division(int a, int b) throws DiviseurNullException;

	@WebMethod
	public int getOperande(String operande) throws EntreeNegatifException, EntreeNonEntierException;
}