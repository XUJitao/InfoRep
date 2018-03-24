import java.rmi.RemoteException;

public class ProductImpl implements Product {
	private String name;
	private int price;
	private ArrayList<Bidder> bidders;

	public ProductImpl(String name, int price) {
		this.name = name;
		this.price = price;
		this.bidders = new ArrayList<Bidder>();
	}

	public boolean setPrice(int price) throws RemoteException {
		if (price > this.price) {
			this.price = price;
			return true;
		}
		else {
			return false;
		}
	}

	public ArrayList<Bidder> getBidders() throws RemoteException {
		return this.bidders;
	}

	public void addBidder(Bidder bidder) throws RemoteException {
		this.bidders.append(bidder);
	}
}
