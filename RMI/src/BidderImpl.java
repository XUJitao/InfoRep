import java.rmi.RemoteException;

public class BidderImpl implements Bidder {
	public void show(String info) throws RemoteException {
		System.out.println(info + "\n");
	}
}
