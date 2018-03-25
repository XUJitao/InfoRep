import java.rmi.RemoteException;
import java.util.ArrayList;

public class ProductImpl implements Product {
	private String name;
	private int price;
	private int expectedPrice;
	private Notification owner;
	private ArrayList<Notification> notifs;
	private boolean finished;

	public ProductImpl(String name, int initialPrice, int expectedPrice) {
		this.name = name;
		this.price = initialPrice;
		this.expectedPrice = expectedPrice;
		this.owner = null;
		this.notifs = new ArrayList<Notification>();
		this.finished = false;
	}

	public void bid(int price, Notification n) throws RemoteException {
		if (this.finished == true) {
			n.notifierEnd(this);
			return;
		}

		boolean success = false;
		if (price > this.price) {
			this.price = price;
			this.owner = n;
			if (!this.notifs.contains(n)) {
				this.notifs.add(n);
			}
			success = true;
			for(int i = 0; i < this.notifs.size(); i++) {
				this.notifs.get(i).notifierOffer(this);
			}
		}
		if (success != true) {
			n.refuseOffer(this);
		}
		if (this.price >= this.expectedPrice) {
			this.finished = true;
			this.owner.notifierOwner(this);
			for (Notification notification : this.notifs) {
				notification.notifierEnd(this);
			}
		}
	}

	public ArrayList<Notification> getNotifs() throws RemoteException {
		return this.notifs;
	}

	public String getName() throws RemoteException {
		return this.name;
	}

	public int getPrice() throws RemoteException {
		return this.price;
	}
}
