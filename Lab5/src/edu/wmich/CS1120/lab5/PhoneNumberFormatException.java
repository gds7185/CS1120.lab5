package edu.wmich.CS1120.lab5;

public class PhoneNumberFormatException extends Exception {
    
    String PHONE_NUMBER;

	public PhoneNumberFormatException(String phoneNumber) {
   	 
   	 PHONE_NUMBER = phoneNumber;
	}
    
	public String getPhoneNumber() {
   	 
   	 return PHONE_NUMBER;
	}
}
