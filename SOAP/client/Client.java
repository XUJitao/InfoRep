package client;

import client.CalculatriceServerImplService;
import client.CalculatriceServer;
import java.util.Scanner;

public class Client {
	
	public static void main(String[] args) throws NonPositiveException_Exception {
		Scanner sc;
		CalculatriceServerImplService service = new CalculatriceServerImplService();
		CalculatriceServer port = service.getCalculatriceServerImplPort();
		while(true) {
			System.out.println("Saisir la formule à calculer, séparer l'opérande et l'opération par espace");
			sc = new Scanner(System.in);
			String calcul = sc.nextLine();
			if (calcul.equalsIgnoreCase("exit"))
				break;
			String[] composants = calcul.split(" ");
			String operande1 = composants[0];
			String operande2 = composants[2];
			String operation = composants[1];
			int result = 0;
			try {
				int op1 = port.getOperande(operande1);
				int op2 = port.getOperande(operande2);
				switch(operation) {
					case "+":
						result = port.addition(op1, op2);
						break;
					case "-":
						result = port.soustraction(op1, op2);
						break;
					case "*":
						result = port.multiplication(op1, op2);
						break;
					case "/":
						result = port.division(op1, op2);
						break;
				}
				System.out.println("Le résultat est : " + result);
			}
			catch (NonPositiveException_Exception e) {
				System.err.println(e.getMessage());
			}
		}
	}
}
