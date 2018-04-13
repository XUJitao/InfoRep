package SOAP.service;

import javax.jws.WebService;

@WebService(endpointInterface = "SOAP.service.CalculatriceServer")
public class CalculatriceServerImpl implements CalculatriceServer {

	public int addition(int a, int b) throws EntreeNegatifException {
		if (a < 0 || b < 0) {
			throw new EntreeNegatifException("L'opérande entré doit être non négatif");
		}
		return a + b;
	}

	public int soustraction(int a, int b) throws EntreeNegatifException ,ResultatNegatifException{
		if (a < 0 || b < 0) {
			throw new EntreeNegatifException("Erreur: L'opérande entré doit être non négatif");
		}
		if (a - b < 0) {
			throw new ResultatNegatifException("Erreur: Le résultat est négatif.");
		}
		return a - b;
	}

	public int multiplication(int a, int b) throws EntreeNegatifException {
		if (a < 0 || b < 0) {
			throw new EntreeNegatifException("L'opérande entré doit être non négatif");
		}
		return a * b;
	}
	
	public int division(int a, int b) throws EntreeNegatifException, DiviseurNullException{
		if (a < 0 || b < 0) {
			throw new EntreeNegatifException("L'opérande entré doit être non négatif");
		}
		if (b == 0) {
			throw new DiviseurNullException("Pour la division, le diviseur ne peut pas être null.");
		}
		return a / b;
	}

	public int getOperande(String operande) throws EntreeNegatifException, EntreeNonEntierException {
		if (Integer.parseInt(operande) < 0) {
			throw new EntreeNegatifException("L'opérande entré doit être non négatif.");
		}

		if (operande.contains(".")) {
			throw new EntreeNonEntierException("L'opérande entré doit être entier.");
		}

		int opInt = Integer.parseInt(operande);

		return opInt;
	}
}
