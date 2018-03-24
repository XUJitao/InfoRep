import java.rmi.registry.*;
import java.rmi.server.UnicastRemoteObject;

public class Client {
	public static void main(String args[]) {
		String machine = "localhost";
		int port = 1099;
		Bidder stubBidder, bidder = new BidderImpl();
		if(args.length == 3) {
			machine = args[0];
			port = Integer.parseInt(args[1]);
		}
		else if(args.length == 2) {
			machine = args[0];
		}
		try {
			Registry registry = LocateRegistry.getRegsitry(machine, port);
			
		}
		catch (Exception e) {
			System.out.println("Client exception: " + e);
		}
	}
}
