package SOAP.service;

public class NonPositiveException extends Exception {
	public NonPositiveException() {
		super();
	}

	public NonPositiveException(String message) {
		super(message);
	}
}
