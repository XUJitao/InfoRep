import java.rmi.RemoteException;
import java.util.*;

public class NotificationImpl implements Notification {
	private ArrayList<Product> prods = new ArrayList<>();

	public void setProductList(ArrayList<Product> prods) throws RemoteException{
		this.prods = prods;
	}

	public ArrayList<Product> getProductList() throws RemoteException{
		return this.prods;
	}

	public void productList() throws RemoteException {
		for (int i = 0; i < prods.size(); i++) {
			System.out.println("Produit: " + prods.get(i).getName() + " Prix actuel: " + prods.get(i).getPrice());
		}
	}

	public void notifierOffer(Product prod) throws RemoteException {
		System.out.println("Le prix actuel de produit: " + prod.getName() +" est " + prod.getPrice());
	}

	public void refuseOffer(Product prod) throws RemoteException {
		System.out.println("Le prix proposé n'est pas accepté. Veuillez proposer un nouveau");
		notifierOffer(prod);
	}

	public void notifierEnd(Product prod) throws RemoteException {
		System.out.println("L'enchère du produit: " + prod.getName() + " est déjà fermé");
	}

	public void notifierOwner(Product prod) throws RemoteException {
		System.out.println("Vous avez réussi d'acheté " + prod.getName() + " avec le prix " + prod.getPrice());
	}
}
