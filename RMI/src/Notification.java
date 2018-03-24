import java.rmi.Remote;
import java.rmi.RemoteException;
import java.utils.ArrayList;

public interface Notification extends Remote {
	public void productList() throws  RemoteException;
	public void notifierOffer(List<Bidder> bidders) throws RemoteException;
	public void refuseOffer(Bidder bidder) throws RemoteException;
	public void notifierEnd(List<Bidder> bidders) throws RemoteException; 
}