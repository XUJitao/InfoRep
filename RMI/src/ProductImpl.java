import java.rmi.RemoteException;

public class ProductImpl implements Product {
	private String name;
	private int price;
	private Bidder owner;
	private ArrayList<Bidder> bidders;

	public ProductImpl(String name, int price) {
		this.name = name;
		this.price = price;
		this.owner = null;
		this.bidders = new ArrayList<Bidder>();
	}

	public boolean bid(Bidder bidder, int price) throws RemoteException {
		if (price > this.price) {
			this.price = price;
			this.owner = bidder;
			if (!this.bidders.contains(bidder))
				this.bidders.add(bidder);
			return true;
		}
		else {
			return false;
		}
	}

	public ArrayList<Bidder> getBidders() throws RemoteException {
		return this.bidders;
	}
}
