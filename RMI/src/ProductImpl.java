import java.rmi.RemoteException;

public class ProductImpl implements Product {
	private String name;
	private int price;
	private int expectedPrice;
	private Bidder owner;
	private ArrayList<Bidder> bidders;

	public ProductImpl(String name, int initialPrice, int expectedPrice) {
		this.name = name;
		this.price = initialPrice;
		this.expectedPrice = expectedPrice;
		this.owner = null;
		this.bidders = new ArrayList<Bidder>();
	}

	public void bid(Bidder bidder, int price) throws RemoteException {
		boolean success = false;
		NotificationImpl n = new NotificationImpl();
		if (price > this.price) {
			this.price = price;
			this.owner = bidder;
			if (!this.bidders.contains(bidder)) {
				this.bidders.add(bidder);
			}
			success = true;
		}
		if (success == True) {
			n.notifierOffer(this.getBidders());
		} else {
			n.refuseOffer(bidder);
		}
		if (this.price >= this.expectedPrice) {
			notifierOwner(this);
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
