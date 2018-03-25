import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

public interface Product extends Remote {
	public void bid(int price, Notification notif) throws RemoteException;
	public ArrayList<Notification> getNotifs() throws RemoteException;
	public String getName() throws RemoteException;
	public int getPrice() throws RemoteException;
}
