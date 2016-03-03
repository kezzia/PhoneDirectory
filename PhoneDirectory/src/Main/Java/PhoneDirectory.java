package Main.Java;

import java.io.*;
import java.util.Properties;

public class PhoneDirectory {


		public static void Properties() {
			Properties prop = new Properties();
			InputStream fileInput = null;
			
			try {
				fileInput = new FileInputStream("C:\\Users\\Kezzia\\Desktop\\Phone_Directory\\PhoneDirectory\\src\\Main\\Resources\\phone.properties");
				
				prop.load(fileInput);
				System.out.println(prop.getProperty("path"));
			} catch (IOException ex) {
				// TODO Auto-generated catch block
				ex.printStackTrace();
			} finally {
				if (fileInput != null) {
					try {
						fileInput.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}

		}

	
	
	
	
	
	
	
	
	
	
	
	

	//given a name and number, adds both to directory
	void addEntry(String name, String number) throws IOException {
		//print name and number

		Properties prop = new Properties();
		InputStream fileInput = null;
		fileInput = new FileInputStream("C:\\Users\\Kezzia\\Desktop\\Phone_Directory\\PhoneDirectory\\src\\Main\\Resources\\phone.properties");
		prop.load(fileInput);
		//System.out.println(prop.getProperty("path"));
		
		
		Writer fileWriter = new FileWriter((prop.getProperty("path")), true);  //appends to file
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
	        BufferedReader file = new BufferedReader(new FileReader("C:\\Users\\Kezzia\\Desktop\\" +
																	"Phone_Directory\\PhoneDirectory\\src\\Main\\" +
																	"Resources\\directory.txt"));
	        String line;
	        String input = "";

	        while ((line = file.readLine()) != null) {
	        	
	        	if (line.toLowerCase().contains(name.toLowerCase())) {
	        		line = "";
	        	}
	        	
	        	input += line + newLine;
	        	System.out.println(input);
	        }
	        
    		System.out.println("That user was not found");
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
	        BufferedReader file = new BufferedReader(new FileReader("C:\\Users\\Kezzia\\Desktop\\Phone_Directory\\PhoneDirectory\\src\\Main\\Resources\\directory.txt"));
	        String line;

	        while ((line = file.readLine()) != null) {
	        	
	        	if (line.toLowerCase().contains(name.toLowerCase())) {
	        		String[] splitString = line.split(" ");
	        		        		
	        		
	    	        file.close();
	        		return splitString[1];
	        	}
	        }
	       

			file.close();
			
	    } catch (Exception e) {
	        System.out.println("Problem reading file.");
	    }
		
		return "That user was not found";
	}	
	
	
	//given a name and num, changes entry with matching name
	void changeEntry(String name, String number) {
		try {
	        // input the file content to the String "input"
			String newLine = System.getProperty("line.separator");
	        BufferedReader file = new BufferedReader(new FileReader("/PhoneDirectory/src/Main/Resources/directory.txt"));
	        String line;
	        String input = "";

	        while ((line = file.readLine()) != null) {
	        	
	        	if (line.toLowerCase().contains(name.toLowerCase())) {
	        		System.out.println("Match");
	        		line = name + " " + number;
	        	}
	        	
	        	input += line + newLine;
	        	System.out.println(input);
	        }
    		System.out.println("That user was not found");
	        file.close();

	        // write the new String with the replaced line OVER the same file
	        FileOutputStream fileOut = new FileOutputStream("/PhoneDirectory/src/Main/Resources/directory.txt");
	        fileOut.write(input.getBytes());
	        fileOut.close();

	    } catch (Exception e) {
	        System.out.println("Problem reading file.");
	    }
	}

}

