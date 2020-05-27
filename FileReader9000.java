import java.util.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;


public class FileReader9000 {
     public static void main(String []args) throws IOException{

     	//the file we wanted to read was http://textfiles.com/100/captmidn.txt

     	File file = new File("C:/Users/jbrit/Documents/captmidn.txt"); //about to open a new file; 
     	                    //we pass the path of the file as a string; i put the location of where my file can be found

     	Scanner scan = new Scanner(file); //scanning file; but we usually make it scan our input

     	String fileContent = "This is an updated file revise by JB\n";

     	while(scan.hasNextLine()){ //it'll stay in while loop until it scans every line
     		// System.out.println(scan.nextLine()); //scan the first line of file and printing it out and move to next line
     		                                     //this loop will print every line of the file

     		fileContent = fileContent.concat(scan.nextLine() + "\n"); //exporting the file to a new one by storing it to string
     		//concat is almost as same as append by adding string to the end of string, but append allows string characters to be added to end as well
     	}

     	FileWriter writer = new FileWriter("C:/Users/jbrit/Documents/updatedFile.txt"); //adding the path of the new file;also called new file as "updatedfile"
     	writer.write(fileContent);                                                    //this new file was created by the java program
     	writer.close(); 
     }
 }