package Main.Java;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

public class PhoneDirectory {
	

	//given a name and number, adds both to directory
	void addEntry(String name, String number) throws IOException {
		//print name and number
		Writer fileWriter = new FileWriter("directory.txt", true);  //appends to file
		fileWriter.write("\n" + name + " " + number);		
		fileWriter.close();
		
		System.out.println("Name: " + name);
		System.out.println("Phone number: " + number);
		//pass
	}
	
	//given a name, deletes name and num from directory
	void deleteEntry(String name) {
		//pass
	}
	
	//given a name, returns a num from the directory
	//String getNumber(String name) {
		//pass
	//}
	
	//given a name and num, changes entry with matching name
	void changeEntry(String name, String number) {
		//pass
	}

}
