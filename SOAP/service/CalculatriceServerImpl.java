package SOAP.service;

import javax.jws.WebService;

@WebService(endpointInterface = "SOAP.service.CalculatriceServer")
public class CalculatriceServerImpl implements CalculatriceServer {
	public int addition(int a, int b) {
		return a + b;
	}

	public int soustraction(int a, int b) {
		return a - b;
	}

	public int multiplication(int a, int b) {
		return a * b;
	}
	
	public int division(int a, int b) {
		return a / b;
	}
}
