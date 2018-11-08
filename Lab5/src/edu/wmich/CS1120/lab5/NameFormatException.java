package edu.wmich.CS1120.lab5;

public class NameFormatException extends Exception{

    String NAME;

	public NameFormatException(String name) {
   	 
   	 NAME = name;
	}
    
	public String getName() {
   	 
   	 return NAME;
	}
}
