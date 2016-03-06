package Test.Java;

import java.io.*;
import java.util.Scanner;
import Main.Java.PhoneDirectory;


/**
 * @author Kezzia
 *
 */
public class Main {

	public static void main(String[] args) throws IOException {
		//get name and number
		Scanner in = new Scanner(System.in);
		PhoneDirectory directory = new PhoneDirectory();

		
		System.out.println("Adding a new entry");
			directory.addEntry("Kezzia Carter", "6317036208");
			directory.addEntry("Kerenha Carter", "8684707876");
		
			
		System.out.println("Deleting an entry");
			directory.deleteEntry("Kerenha Carter");
		
			
		System.out.println("Adding a new entry");
			directory.addEntry("Maya Ramesar", "8684707876");
		
			
		System.out.println("3. Find a phone number");
			System.out.println(directory.getNumber("Kezzia Carter"));
			System.out.println(directory.getNumber("Maya Ramesar"));
		
		
		System.out.println("4. Alter an entry");
			directory.changeEntry("Kezzia Carter", "555");
			directory.changeEntry("Maya Ramesar", "666");

	
		
		
		in.close();

	}

}
