import java.rmi.RemoteException;
import java.util.ArrayList;

public class ProductImpl implements Product {
	private String name;
	private int price;
	private int expectedPrice;
	private Bidder owner;
	private ArrayList<Bidder> bidders;
	private boolean finished;

	public ProductImpl(String name, int initialPrice, int expectedPrice) {
		this.name = name;
		this.price = initialPrice;
		this.expectedPrice = expectedPrice;
		this.owner = null;
		this.bidders = new ArrayList<Bidder>();
		this.finished = false;
	}

	public void bid(Bidder bidder, int price, Notification n) throws RemoteException {
		if (this.finished = true) {
			return;
		}

		boolean success = false;
		if (price > this.price) {
			this.price = price;
			this.owner = bidder;
			if (!this.bidders.contains(bidder)) {
				this.bidders.add(bidder);
			}
			success = true;
		}
		if (success == true) {
			n.notifierOffer(this);
		} else {
			n.refuseOffer(this);
		}
		if (this.price >= this.expectedPrice) {
			this.finished = true;
			n.notifierEnd(this);
			n.notifierOwner(this);
		}
	}

	public ArrayList<Bidder> getBidders() throws RemoteException {
		return this.bidders;
	}

	public String getName() throws RemoteException {
		return this.name;
	}

	public int getPrice() throws RemoteException {
		return this.price;
	}
}
