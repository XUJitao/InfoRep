import java.rmi.registry.*;
import java.rmi.server.UnicastRemoteObject;
import java.util.*;

public class Serveur {
	public static void main(String args[]) {
		int port = 1099;
		if(args.length == 1)
			port = Integer.parseInt(args[0]);
		try {
			ArrayList<Product> productList = new ArrayList<>();
			Product stubIphone = (Product)UnicastRemoteObject.exportObject(new ProductImpl("IphoneX", 500, 900), 0);
			Product stubPixel2 = (Product)UnicastRemoteObject.exportObject(new ProductImpl("Pixel2", 400, 700), 0);
			productList.add(stubIphone);
			productList.add(stubPixel2);
			Registry registry = LocateRegistry.getRegistry(port);
			if(!Arrays.asList(registry.list()).contains("IphoneXCallback")) {
				registry.bind("IphoneXCallback", stubIphone);
			}
			else {
				registry.rebind("IphoneXCallback", stubIphone);
			}
			if(!Arrays.asList(registry.list()).contains("Pixel2Callback")) {
				registry.bind("Pixel2Callback", stubPixel2);
			}
			else {
				registry.rebind("Pixel2Callback", stubPixel2);
			}
			System.out.println("Service IphoneXCallback et Pixel2Callback lient au registre.");

			ArrayList<Notification> notificationList = new ArrayList<>();
			
			String[] callbackNameList = registry.list();
			int nbCallback = callbackNameList.length;
			for (int i = 0; i < callbackNameList.length; i++) {
				if (callbackNameList[i].startsWith("NotificationCallback")) {
					notificationList.add((Notification)registry.lookup(callbackNameList[i]));
				}
			}

			for (Notification n : notificationList) {
				n.setProductList(productList);
				n.productList();
			}

			while (true) {
				callbackNameList = registry.list();
				if (nbCallback < callbackNameList.length) {
					System.out.println("New product added.");
					for (int i = nbCallback; i < callbackNameList.length; i++) {
						if (callbackNameList[i].startsWith("NotificationCallback")) {
							notificationList.add((Notification)registry.lookup(callbackNameList[i]));
						}
					}
					nbCallback = callbackNameList.length;
				}
			}
		}
		catch (Exception e) {
			System.out.println(e);
		}
	}
}
