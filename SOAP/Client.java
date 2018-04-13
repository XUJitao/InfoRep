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
			int operande1 = Integer.parseInt(composants[0]);
			int operande2 = Integer.parseInt(composants[2]);
			String operation = composants[1];
			int result = 0;
			try {
				switch(operation) {
					case "+":
						result = port.addition(operande1, operande2);
						break;
					case "-":
						result = port.soustraction(operande1, operande2);
						break;
					case "*":
						result = port.multiplication(operande1, operande2);
						break;
					case "/":
						result = port.division(operande1, operande2);
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
