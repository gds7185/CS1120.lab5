package edu.wmich.CS1120.lab5;

public class EmailAddressFormatException extends Exception {

	String EMAIL = "";

    public EmailAddressFormatException(String email) {
        
    	EMAIL = email;
    }
    
    public String getEmail() {
    	
    	return EMAIL;
    }
}
