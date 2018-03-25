import java.rmi.registry.*;
import java.util.*;

public class Serveur {
	public static void main(String args[]) {
		int port = 1099;
		if(args.length == 1)
			port = Integer.parseInt(args[0]);
		try {
			List<Product> productList = new ArrayList<>();
			Product stubIphone = (Product)UnicastRemobeObject.exportObject(new ProductImpl("IphoneX", 500, 900), 0);
			Product stubPixel2 = (Product)UnicastRemobeObject.exportObject(new ProductImpl("Pixel2", 400， 700), 0);
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
				registry.bind("Pixel2Callback", stubPixel);
			}
			else {
				registry.rebind("Pixel2Callback", stubPixel);
			}
			System.out.println("Service IphoneXCallback et Pixel2Callback lient au registre.");

			Notification n = (Notification)registry.lookup("NotificationCallback");
			n.setProductList(productList);
		}
		catch (Exception e) {
			System.out.println(e);
		}
	}
}
