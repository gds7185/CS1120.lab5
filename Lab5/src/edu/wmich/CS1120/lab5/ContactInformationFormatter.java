package edu.wmich.CS1120.lab5;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ContactInformationFormatter implements IContactInformationFormatter {

	FormatExceptionHandler Err = new FormatExceptionHandler();
	
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
			
			File file = new File("C:\\Users\\jacob\\Desktop\\CS II\\Lab 5\\" + fileName);//CHANGE TO YOUR DIRECTORY
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
				//String message1 = "Error: Incorrect Name Format";
				Err.handleNameFormatException(e);
			}
			
			//Phone Number
			try {
				formatPhoneNumber(line2);
			}
			catch(PhoneNumberFormatException e) {
				//String message2 = "Error: Incorrect Phone Number Format";
				Err.handlePhoneNumberFormatException(e);
			}
			
			//Email
			try {
				formatEmail(line3);
			}
			catch(EmailAddressFormatException e) {

				Err.handleEmailFormatException(e);
			}
			
			scan.close();
		
		//If input file is missing
		} catch (FileNotFoundException e) {
			
			//System.out.println("Error: Input File Not Found");
			Err.handleFileNotFoundException(e);
		}
		
	}

	@Override
	public void formatEmail(String email) throws EmailAddressFormatException {
		// TODO create a loop to look for the @ symbol in the given email address. if one is not found it will 
		//throw an error
//		boolean correct = false;
//		
//		for (int r = 0; r < email.length();r++) {
//			
//			if (email.charAt(r) == '@') {
//				correct = true;
//			}
//		}
//		if (correct) {
//			
//			System.out.println(email.toLowerCase());
//		}
//		
//		else {
//			
//			throw new EmailAddressFormatException("Incorrect Email Address Format");
//		}
		
		for(int i = 0; i < email.length(); i++) {
			
			if(email.charAt(i) >= 65 && email.charAt(i) <= 90) {
				
				throw new EmailAddressFormatException(email);
			}
		}
	}

	@Override
	public void formatPhoneNumber(String phoneNumber) throws PhoneNumberFormatException {
		// TODO Auto-generated method stub
		int[] number = new int[10];
		char[] charArr = new char[phoneNumber.length()];
		int i = 0;
		int j = 0;
		
		while(j != phoneNumber.length()) {
			charArr[j] = phoneNumber.charAt(j);
			if (charArr[j] == 1 || charArr[j] == 2 || charArr[j] == 3 || charArr[j] == 4 || charArr[j] == 5 || 
					charArr[j] == 6 || charArr[j] == 7 || charArr[j] == 8 || charArr[j] == 9 || charArr[j] == 0) {
				number[i] = charArr[j];
				i++;
				j++;
			}
			else {
				j++;
			}
		}
		if(i != 10) { //a statement that will throw an error if the phone number is not 10 digits long
			PhoneNumberFormatException e = null;
			Err.handlePhoneNumberFormatException(e);
		}
		String phoneNum = "(";
		for(int k = 0; k<3;k++) {
			phoneNum = phoneNum + number[k];
		}
		phoneNum = phoneNum + ") ";
		for(int w = 3; w<6;w++) {
			phoneNum = phoneNum + number[w];
		}
		phoneNum = phoneNum + "-";
		for(int y = 6; y<10;y++) {
			phoneNum = phoneNum + number[y];
		}
		System.out.println(phoneNum);
	}

	@Override
	public void formatName(String name) throws NameFormatException {
		// TODO Auto-generated method stub
		String nameArr[] = new String [2];
		String nameStr ="";
		char nameChar;
		nameArr = name.split(name, ' ');
		for (int a = 0; a < 2; a++) {
			for (int b = 0; b < nameArr[a].length(); b++) {
				String h = null;
				if (b == 0) {
					nameChar = nameArr[a].charAt(b);
					h = h + nameChar;
					h.toUpperCase();
					nameStr = nameStr + h;
				}
				else if (b == nameArr[a].length()-1) {
					nameChar = nameArr[a].charAt(b);
					h = h + nameChar;
					h.toLowerCase();
					nameStr = nameStr + h + " ";
				}
				else {
					nameChar = nameArr[a].charAt(b);
					h = h + nameChar;
					h.toLowerCase();
					nameStr = nameStr + h;
				}
			}
		}
		System.out.println(nameStr);
	}

}
