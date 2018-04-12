package SOAP.service;

import javax.xml.ws.Endpoint;

public class CalculatriceServerPublisher {
	public static void main(String[] arge) {
		Endpoint.publish("http://127.0.0.1:9876/calculatrice", new CalculatriceServerImpl());
	}
}
