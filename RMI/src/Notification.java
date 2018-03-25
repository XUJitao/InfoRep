import java.rmi.Remote;
import java.rmi.RemoteException;
import java.utils.ArrayList;

public interface Notification extends Remote {
	public void productList() throws  RemoteException;
	public void notifierOffer(Product prod) throws RemoteException;
	public void refuseOffer(Product prod ) throws RemoteException;
	public void notifierEnd(Product prod) throws RemoteException;
	public void notifierOwner(Product prod) throws RemoteException;
}
