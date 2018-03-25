import java.rmi.RemoteException;
import java.util.ArrayList;

public class NotificationImpl implements Product {
	private ArrayList<Product> prods;

	public void productList() throws RemoteException {
		for (int i = 0; i < prods.size(); i++) {
			System.out.println("Produit: " + prods.get(i).getName() + "    Prix: " + prods.get(i).getPrice());
		}
	}

	public void notifierOffer(Product prod) throws RemoteException {
		System.out.println("Le produit: " + prod.getName() +" a un nouveau prix: " + prod.getPrice());
	}

	public void refuseOffer(Product prod) throws RemoteException {
		System.out.println("Le prix proposé n'est pas accepté. Veuillez proposer un nouveau");
		notifierOffer(prod);
	}

	public void notifierEnd(Product prod) throws RemoteException {
		System.out.println("L'enchères du produit: " + prod.getName() " est déjà fermé");
	}
}
