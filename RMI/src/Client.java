import java.rmi.registry.*;
import java.rmi.server.UnicastRemoteObject;
import java.util.Scanner;

public class Client {
	public static void main(String args[]) {
		String machine = "localhost";
		int port = 1099;
		Bidder stubBidder, bidder = new BidderImpl();
		Notification stubNotification, notification = new NotificationImpl();
		Scanner sc;
		if(args.length == 3) {
			machine = args[0];
			port = Integer.parseInt(args[1]);
		}
		else if(args.length == 2) {
			machine = args[0];
		}
		try { 
			Registry registry = LocateRegistry.getRegsitry(machine, port);
			Product iphoneX = (Product)registry.lookup("IphoneXCallback");
			Product pixel2 = (Product)registry.lookup("Pixel2Callback");
			
			stubNotification = (Notification)UnicastRemoteObject.exportObject(notifaction, 0);
			Registry registry = LocateRegistry.getRegistry(port);
			if(!Arrays.asList(registry.list()).contains("NotificationCallback")) {
				registry.bind("NotificationCallback", stubNotification);
			}
			else {
				registry.rebind("NotificationCallback", stubNotification);
			}
			System.out.println("Service NotificationCallback lie au registre.")
			
			System.out.println("Saisir le nom de produit et le prix d'enchère, SVP. Exit pour ne pas faire enchère.");
			sc = new Scanner(System.in);
			String bid = sc.nextLine();
			if (bid.equalsIgnoreCase("exit")) {
				break;
			}
			String[] parts = bid.split(" ");
			Stirng productName = parts[0];
			String bidPrice = parts[1];
		}
		catch (Exception e) {
			System.out.println("Client exception: " + e);
		}
	}
}
