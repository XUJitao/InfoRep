import java.rmi.registry.*;
import java.util.*;

public class Serveur {
	public static void main(String args[]) {
		int port = 1099;
		if(args.length == 1)
			port = Integer.parseInt(args[0]);
		try {
			Product stubIphone = (Product)UnicastRemobeObject.exportObject(new ProductImpl("Iphone", 500), 0);
			Product stubPixel = (Product)UnicastRemobeObject.exportObject(new ProductImpl("Pixel2", 400), 0);
			Registry registry = LocateRegistry.getRegistry(port);
			if(!Arrays.asList(registry.list()).contains("IphoneCallback")) {
				registry.bind("IphoneCallback", stubIphone);
			}
			else {
				registry.rebind("ProductCallback", stubIphone);
			}
			if(!Arrays.asList(registry.list()).contains("PixelCallback")) {
				registry.bind("ProductCallback", stubPixel);
			}
			else {
				registry.rebind("ProductCallback", stubPixel);
			}
			System.out.println("Service ProductCallback lie au registre");
		}
		catch (Exception e) {
			System.out.println(e);
		}
	}
}
