package edu.wmich.CS1120.lab5;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ContactInformationFormatter implements IContactInformationFormatter {

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
				System.out.println("Error: Incorrect Name Format");
			}
			
			//Phone Number
			try {
				formatPhoneNumber(line2);
			}
			catch(PhoneNumberFormatException e) {
				System.out.println("Error: Incorrect Phone Number Format");
			}
			
			//Email
			try {
				formatEmail(line3);
			}
			catch(EmailAddressFormatException e) {
				System.out.println("Error: Incorrect Email Address Format");
			}
			
			scan.close();
		
		//If input file is missing
		} catch (FileNotFoundException e) {
			
			System.out.println("Error: Input File Not Found");
			return;
		}
		
	}

	@Override
	public void formatEmail(String email) throws EmailAddressFormatException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void formatPhoneNumber(String phoneNumber) throws PhoneNumberFormatException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void formatName(String name) throws NameFormatException {
		// TODO Auto-generated method stub
		
	}

}
