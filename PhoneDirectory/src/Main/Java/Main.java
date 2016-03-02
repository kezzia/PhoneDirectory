package Main.Java;

import java.io.*;
import java.util.Scanner;


public class Main {

	public static void main(String[] args) throws IOException {
		//get name and number
		Scanner in = new Scanner(System.in);
		PhoneDirectory directory = new PhoneDirectory();

		System.out.println("What would you like to do? ");
		System.out.println("1. Add a new entry");
		System.out.println("2. Delete an entry");
		System.out.println("3. Find a phone number");
		System.out.println("4. Alter an entry");

		
		int answer = in.nextInt();
		in.nextLine(); // we need this to consume the linebreak otherwise it skips
		
		if (answer == 1) {
			System.out.println("Enter a name: ");
			String nameInput = in.nextLine();
	 
			System.out.println("Enter that user's number: ");
			String numInput = in.nextLine();
			
			directory.addEntry(nameInput, numInput);	
		}
		
		else if (answer == 2) {
			System.out.println("Enter the user to delete: ");
			String nameInput = in.nextLine();
			
			directory.deleteEntry(nameInput);
		}
		
		else if (answer == 3) {
			System.out.println("Enter the user's name: ");
			String nameInput = in.nextLine();
			
			System.out.println(directory.getNumber(nameInput));
		}

		else {
			System.out.println("Bye :)");		
		}
		

		
	
		
		
		in.close();

	}

}
