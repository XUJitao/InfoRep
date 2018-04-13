package SOAP.service;

import javax.jws.WebService;

@WebService(endpointInterface = "SOAP.service.CalculatriceServer")
public class CalculatriceServerImpl implements CalculatriceServer {

	public int addition(int a, int b) throws NonPositiveException {
		if (a <= 0 || b <= 0) {
			throw new NonPositiveException("L'opérande entré doit être positif");
		}
		return a + b;
	}

	public int soustraction(int a, int b) throws NonPositiveException {
		if (a <= 0 || b <= 0) {
			throw new NonPositiveException("Erreur: L'opérande entré doit être positif");
		}
		if (a - b <= 0) {
			throw new NonPositiveException("Erreur: Le résultat est négatif ou 0 ");
		}
		return a - b;
	}

	public int multiplication(int a, int b) throws NonPositiveException {
		if (a <= 0 || b <= 0) {
			throw new NonPositiveException("L'opérande entré doit être positif");
		}
		return a * b;
	}
	
	public int division(int a, int b) throws NonPositiveException {
		if (a <= 0 || b <= 0) {
			throw new NonPositiveException("L'opérande entré doit être positif");
		}
		return a / b;
	}
}
