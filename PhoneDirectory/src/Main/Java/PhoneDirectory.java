package Main.Java;

import java.io.*;
import java.util.Properties;

/**
 * @author Kezzia
 *
 */
public class PhoneDirectory {


		public static void Properties() {
			Properties prop = new Properties();
			InputStream fileInput = null;
			
			try {
				fileInput = new FileInputStream("C:\\Users\\Kezzia\\Desktop\\Phone_Directory\\PhoneDirectory\\src\\Main\\Resources\\phone.properties");
				
				prop.load(fileInput);
				System.out.println(prop.getProperty("path"));
			} catch (IOException ex) {
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
	public void addEntry(String name, String number) throws IOException {
		//create \n character
		String newLine = System.getProperty("line.separator");

		//prop info
		Properties prop = new Properties();
		InputStream fileInput = null;
		fileInput = new FileInputStream("C:\\Users\\Kezzia\\Desktop\\Phone_Directory\\PhoneDirectory\\src\\Main\\Resources\\phone.properties");
		prop.load(fileInput);
		
		//it appends the new info to the file
		Writer fileWriter = new FileWriter((prop.getProperty("path")), true);  //appends to file
		fileWriter.write(name + " " + number);
		//inserts line break so everything is on a new line
		fileWriter.write(System.lineSeparator());
		fileWriter.close();
		
		//it prints what was just added
		System.out.println("Adding:"); System.out.println("Name: " + name);
		System.out.println("Number: " + number);
		System.out.println(newLine);
		//pass
	}
	
	//given a name, deletes name and num from directory
	public void deleteEntry(String name) throws IOException {
		Properties prop = new Properties();
		InputStream fileInput = null;
		fileInput = new FileInputStream("C:\\Users\\Kezzia\\Desktop\\Phone_Directory\\PhoneDirectory\\src\\Main\\Resources\\phone.properties");
		prop.load(fileInput);		
		
		try {
	        // input the file content to the String "input"
			String newLine = System.getProperty("line.separator");
			
			//initialising ostream
	        BufferedReader file = new BufferedReader( new FileReader( (prop.getProperty("path") )) );
	        String line;
	        String input = "";

    		System.out.println("Deleting:");
    		System.out.println("Name: " + name);
    		System.out.println(newLine);
	        
    		//iterates through the file line by line
	        while ((line = file.readLine()) != null) {
	        	
	        	//if the name is included in that line, delete it
	        	if (line.toLowerCase().contains(name.toLowerCase())) {
	        		line = "";
		        	input += line;
	        	}
	        	//otherwise add it to the input
	        	else {
	        		input += line + newLine;
	        	}

	        }
	        
	        file.close();

	        // it writes the new string with the replaced line over the same file
	        FileOutputStream fileOut = new FileOutputStream((prop.getProperty("path")));
	        fileOut.write(input.getBytes());
	        fileOut.close();

	    } catch (Exception e) {
	        System.out.println("Problem reading file.");
	    }
	}
	
	
	
	
	//given a name, returns a num from the directory
	public String getNumber(String name) throws IOException {
		Properties prop = new Properties();
		InputStream fileInput = null;
		fileInput = new FileInputStream("C:\\Users\\Kezzia\\Desktop\\Phone_Directory\\PhoneDirectory\\src\\Main\\Resources\\phone.properties");
		prop.load(fileInput);
		String newLine = System.getProperty("line.separator");
		
		
		
		try {
	        // input the file content to the String "input"
	        BufferedReader file = new BufferedReader(new FileReader((prop.getProperty("path"))));
	        String line;

	        while ((line = file.readLine()) != null) {
	        	
	        	if (line.toLowerCase().contains(name.toLowerCase())) {
	        		String[] splitString = line.split(" ");
	        		        		
	        		
	    	        file.close();
	        		return splitString[2];
	        	}
	        }
	       

			file.close();
			
	    } catch (Exception e) {
	        System.out.println("Problem reading file.");
	    }
		
		return "That user was not found";
	}	
	
	
	
	
	//given a name and num, changes entry with matching name
	public void changeEntry(String name, String number) throws IOException {
		Properties prop = new Properties();
		InputStream fileInput = null;
		fileInput = new FileInputStream("C:\\Users\\Kezzia\\Desktop\\Phone_Directory\\PhoneDirectory\\src\\Main\\Resources\\phone.properties");
		prop.load(fileInput);
		
		
		
		
		try {
	        // input the file content to the String "input"
			String newLine = System.getProperty("line.separator");
	        BufferedReader file = new BufferedReader(new FileReader(( prop.getProperty("path") )));
	        String line;
	        String input = "";
	        
	        //it iterates over the file line by line
	        while ((line = file.readLine()) != null) {
	        	
	        	//when it finds a line with a matching name, it overwrites it with the new info
	        	if (line.toLowerCase().contains(name.toLowerCase())) {
	        		line = name + " " + number;
	        	}
	        	
	        	input += line + newLine;
	        }
	        
	        //prints what was just added
    		System.out.println("Adding:");
    		System.out.println("Name: " + name);
    		System.out.println("Number: " + number);
    		System.out.println(newLine);
	        file.close();

	        // overwriting the old file
	        FileOutputStream fileOut = new FileOutputStream((prop.getProperty("path")));
	        fileOut.write(input.getBytes());
	        fileOut.close();

	    } catch (Exception e) {
	        System.out.println("Problem reading file.");
	    }
	}

}

