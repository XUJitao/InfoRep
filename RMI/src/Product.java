import java.rmi.Remote;
import java.rmi.RemoteException;
import java.utils.ArrayList;

public interface Product extends Remote {
	public boolean setPrice(int price) throws RemoteException;
	public ArrayList<Bidder> getBidders() throws RemoteException;
}
