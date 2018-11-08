package edu.wmich.CS1120.lab5;

import java.io.FileNotFoundException;

public class FormatExceptionHandler implements IFormatExceptionHandler{

    @Override
    public void handleFileNotFoundException(FileNotFoundException e) {
   	 
   	 System.out.print("file not found.\n\n");
    }

    @Override
    public void handlePhoneNumberFormatException(PhoneNumberFormatException e) {
   	 
   	 //Get phone number, and remove all non-numeric characters
   	 String phoneNumber = e.getPhoneNumber().replaceAll("[^\\d.]", "");;
   	 
   	 //Using StringBuilder to properly format number with ( ) and -
   	 StringBuilder format = new StringBuilder(phoneNumber);
   	 
   	 //Insert parenthesis and dashes in correct positions
   	 format.insert(0,"(");
   	 format.insert(4, ")");
   	 format.insert(5,"-");
   	 format.insert(9, "-");
   	 
   	 System.out.println(format);
    }

    @Override
    public void handleEmailFormatException(EmailAddressFormatException e) {

   	 //Print email in all lowercase, followed by new line
   	 System.out.println(e.getEmail().toLowerCase());
   	 System.out.println("");
    }

    @Override
    public void handleNameFormatException(NameFormatException e) {
   	 
   	 //Get name and convert everything to lowercase
   	 String name = e.getName().toLowerCase();
    
   	 //Then convert first char in each name to uppercase...
   	 
   	 //Split name into 2 strings
   	 String[] nameArr = name.split(" ",2);
   	 
   	 //Loop that runs twice
   	 for(int i = 0; i < 2; i++) {
   		 
   		 //Take first letter and make it uppercase
   		 char firstLetter = Character.toUpperCase(nameArr[i].charAt(0));
   		 
   		 //User StringBuilder to replace first letter with capitalized letter
   		 StringBuilder capital = new StringBuilder(nameArr[i]);
   		 capital.setCharAt(0, firstLetter);
   		 
   		 //Print the capitalized word
   		 System.out.print(capital);
   		 
   		 //If first word, print space. If second word, print new line
   		 if(i == 0) {
   			 System.out.print(" ");
   		 }
   		 else {
   			 System.out.print("\n");
   		 }
   	 }
    }

}


