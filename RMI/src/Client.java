import java.rmi.registry.*;
import java.rmi.server.UnicastRemoteObject;
import java.util.*;

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
			Registry registry = LocateRegistry.getRegistry(port);
			stubBidder = (Bidder)UnicastRemoteObject.exportObject(bidder, 0);
			stubNotification = (Notification)UnicastRemoteObject.exportObject(notification, 0);
			String notificationCallbackName = "NotificationCallback";
			int nbNotif = 1;
			while (true) {
				String temp = notificationCallbackName + nbNotif;
				if(!Arrays.asList(registry.list()).contains(temp)) {
					registry.bind(temp, stubNotification);
					break;
				}
				else {
					nbNotif++;
				}
				System.out.println(temp);
			}
			System.out.println("Service NotificationCallback lie au registre.");
			
			while (true) { 
				System.out.println("Saisir le nom de produit et le prix d'enchère, SVP. Exit pour ne pas faire enchère.");
				sc = new Scanner(System.in);
				String bid = sc.nextLine();
				if (bid.equalsIgnoreCase("exit")) {
					UnicastRemoteObject.unexportObject(notification, true);
					break;
				}
				String[] parts = bid.split(" ");
				String productName = parts[0];
				int bidPrice = Integer.parseInt(parts[1]);
				ArrayList<Product> products = notification.getProductList();
				for (Product p : products) {
					if (p.getName().equalsIgnoreCase(productName)) {
						p.bid(bidPrice, stubNotification);
						break;
					}
				}
			}
		}
		catch (Exception e) {
			System.out.println("Client exception: " + e);
		}
	}
}
