package SOAP.service;

import javax.xml.ws.Endpoint;

public class CalculatriceServerPublisher {
	public static void main(String[] arge) {
		Endpoint.publish("http://192.168.1.111:9876/calculatrice", new CalculatriceServerImpl());
	}
}
