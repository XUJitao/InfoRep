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
			Registry registry = LocateRegistry.getRegistry(port);
			List<Product> products = new ArrayList<>();
			Product iphoneX = (Product)registry.lookup("IphoneXCallback");
			Product pixel2 = (Product)registry.lookup("Pixel2Callback");
			products.add(iphoneX);
			products.add(pixel2);
			stubBidder = (Bidder)UnicastRemoteObject.exportObject(bidder, 0);
			stubNotification = (Notification)UnicastRemoteObject.exportObject(notifaction, 0);
			String notificationCallbackName = "NotificationCallback";
			int nbNotif = 1;
			while (true) {
				String temp = notificationCallbackName + new String(nbNotif);
				if(!Arrays.asList(registry.list()).contains(temp)) {
					registry.bind(temp, stubNotification);
					break;
				}
				else {
					nbNotif++;
				}
			}
			System.out.println("Service NotificationCallback lie au registre.")
			
			while (true) { 
				System.out.println("Saisir le nom de produit et le prix d'enchère, SVP. Exit pour ne pas faire enchère.");
				sc = new Scanner(System.in);
				String bid = sc.nextLine();
				if (bid.equalsIgnoreCase("exit")) {
					break;
				}
				String[] parts = bid.split(" ");
				Stirng productName = parts[0];
				String bidPrice = parts[1];
				for (Product p : products) {
					if (p.getName().equalsIgnoreCase(productName)) {
						p.bid(stubBidder, bidPrice, stubNotification);
					}
				}
			}
		}
		catch (Exception e) {
			System.out.println("Client exception: " + e);
		}
	}
}
