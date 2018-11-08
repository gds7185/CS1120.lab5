package edu.wmich.CS1120.lab5;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ContactInformationFormatter implements IContactInformationFormatter {

    FormatExceptionHandler handler = new FormatExceptionHandler();
    
    @Override
    public void readContactInformation(String[] filePaths) {
   	 
   	 //Call formatContactInformation once for each file path
   	 for(int i = 0; i < filePaths.length; i++) {
   		 
   		 formatContactInformation(filePaths[i]);
   	 }
    }

    @Override
    public void formatContactInformation(String fileName) {
   			 
   	 //Instantiate scanner for file, and handle error if no file is found
   	 try {
   		 
   		 File file = new File(fileName);//CHANGE TO YOUR DIRECTORY
   		 Scanner scan = new Scanner(file);
   		 
   		 //Store txt input in Strings
   		 String line1 = scan.nextLine();//name
   		 String line2 = scan.nextLine();//number
   		 String line3 = scan.nextLine();//email
   		 
   		 //Name
   		 try {
   			 formatName(line1);
   		 }
   		 catch(NameFormatException e) {
   			 
   			 handler.handleNameFormatException(e);
   		 }
   		 
   		 //Phone Number
   		 try {
   			 formatPhoneNumber(line2);
   		 }
   		 catch(PhoneNumberFormatException e) {
   			 
   			 handler.handlePhoneNumberFormatException(e);
   		 }
   		 
   		 //Email
   		 try {
   			 formatEmail(line3);
   		 }
   		 catch(EmailAddressFormatException e) {

   			 handler.handleEmailFormatException(e);
   		 }
   		 
   		 scan.close();
   	 
   	 //If input file is missing
   	 } catch (FileNotFoundException e) {
   		 
   		 System.out.print(fileName + " Error: ");
   		 handler.handleFileNotFoundException(e);
   	 }
   	 
    }

    @Override
    public void formatEmail(String email) throws EmailAddressFormatException {
   	 
   	 //loop through each character in email
   	 for(int i = 0; i < email.length(); i++) {
   		 
   		 //if character is uppercase
   		 if(email.charAt(i) >= 65 && email.charAt(i) <= 90) {
   			 
   			 throw new EmailAddressFormatException(email);
   		 }
   	 }
   	 System.out.println(email);
   	 System.out.println("");
    }

    @Override
    public void formatPhoneNumber(String phoneNumber) throws PhoneNumberFormatException {
   	 
   	 //Check if phone number is formatted correctly with parentheses and dashes
   	 if(phoneNumber.charAt(0) != '(' || phoneNumber.charAt(4) != ')'
   		 || phoneNumber.charAt(5) != '-' || phoneNumber.charAt(9) != '-') {
   		 
   		 throw new PhoneNumberFormatException(phoneNumber);
   	 }
   	 else {
   		 System.out.println(phoneNumber);
   	 }
    }

    @Override
    public void formatName(String name) throws NameFormatException {
   	 
   	 //Split name into array at the space
   	 String nameArr[] = new String[2];
   	 nameArr = name.split(" ",2);
    
   	 //Check if first letters are NOT capital (check once for each word)
   	 for(int i = 0; i < 2; i++) {
   		 
   		 //if first letter is lowercase
   		 if(nameArr[i].charAt(0) >= 97 && nameArr[i].charAt(0) <= 122) {
   			 
   			 throw new NameFormatException(name);
   		 }
   		 
   		 //Nested loop, check if other characters ARE capital (starting at second letter)
   		 for(int j = 1; j < nameArr[i].length(); j++) {
   			 
   			 //if letter is uppercase
   			 if(nameArr[i].charAt(j) >= 65 && nameArr[i].charAt(j) <= 90) {
   				 
   				 throw new NameFormatException(name);
   			 }
   		 }
   	 }
   	 //If no exceptions, print name
   	 System.out.println(name);
    }
}

