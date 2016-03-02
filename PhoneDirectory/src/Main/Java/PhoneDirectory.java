package Main.Java;

import java.io.*;

public class PhoneDirectory {
	

	//given a name and number, adds both to directory
	void addEntry(String name, String number) throws IOException {
		//print name and number
		Writer fileWriter = new FileWriter("directory.txt", true);  //appends to file
		fileWriter.write(name + " " + number);
		fileWriter.write(System.lineSeparator());
		fileWriter.close();
		
		System.out.println("Name: " + name);
		System.out.println("Phone number: " + number);
		//pass
	}
	
	//given a name, deletes name and num from directory
	void deleteEntry(String name) {
		try {
	        // input the file content to the String "input"
			String newLine = System.getProperty("line.separator");
	        BufferedReader file = new BufferedReader(new FileReader("directory.txt"));
	        String line;
	        String input = "";

	        while ((line = file.readLine()) != null) {
	        	
	        	if (line.toLowerCase().contains(name.toLowerCase())) {
	        		System.out.println("Match");
	        		line = "";
	        	}
	        	
	        	input += line + newLine;
	        	System.out.println(input);
	        }
	        file.close();

	        // write the new String with the replaced line OVER the same file
	        FileOutputStream fileOut = new FileOutputStream("directory.txt");
	        fileOut.write(input.getBytes());
	        fileOut.close();

	    } catch (Exception e) {
	        System.out.println("Problem reading file.");
	    }
	}
	
	//given a name, returns a num from the directory
	String getNumber(String name) {
		try {
	        // input the file content to the String "input"
	        BufferedReader file = new BufferedReader(new FileReader("directory.txt"));
	        String line;

	        while ((line = file.readLine()) != null) {
	        	
	        	if (line.toLowerCase().contains(name.toLowerCase())) {
	        		System.out.println("Match");
	        		String[] splitString = line.split(" ");
	        		
	    	        file.close();
	        		return splitString[1];
	        	}
	        }

			file.close();
			
	    } catch (Exception e) {
	        System.out.println("Problem reading file.");
	    }
		
		return "Not found";
	}	
	
	
	//given a name and num, changes entry with matching name
	void changeEntry(String name, String number) {
		//pass
	}

}

