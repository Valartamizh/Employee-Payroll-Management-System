package com.wipro.payroll.util;

public class InvalidInputException extends Exception{

	private static final long serialVersionUID = 1L;

	public InvalidInputException(String string) {
		super(string);
	}

	@Override
	public String toString() {
		return "InvalidInputException - Check the Input and retry";
	}

}
