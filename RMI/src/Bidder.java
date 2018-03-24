import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Bidder extends Remote {
	public void show(String info) throws RemoteException;
}
