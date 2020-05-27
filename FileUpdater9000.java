import java.util.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;


public class FileUpdater9000 {
     public static void main(String []args) throws IOException{

     	File file = new File("C:/Users/jbrit/Documents/Atomm/StoryTime.txt"); //we pass location of file

     	Scanner scan = new Scanner(file); 

          Scanner myScan = new Scanner(System.in); 
          System.out.println("What word do you want to replace?");
          String WantedWord = myScan.nextLine(); //waiting for user to put word they want to track
          String LowerWantedWord = WantedWord.toLowerCase();//in case user's first letter is capitalized
          String UpperWantedWord = WantedWord.substring(0, 1).toUpperCase() + WantedWord.substring(1); 

          System.out.println("What word do you want to replace " + WantedWord +  " with?");
          String newWord = myScan.nextLine(); //waiting for user to put word they want to track

          System.out.println("What are your initials");
          String initials = myScan.nextLine(); //waiting for user to put word they want to track

     	String fileContent = "";
          String revisedContent = "This is an updated file revise by " + initials + "\n" + "\n";

     	while(scan.hasNext()){ //it'll stay in while loop until it scans every word

               fileContent = fileContent.concat(scan.next() ); 
               if(fileContent.contains(UpperWantedWord) || fileContent.contains(LowerWantedWord)){
                    revisedContent = revisedContent.concat(newWord + " ");
               }
               else revisedContent = revisedContent.concat(fileContent + " ");
               fileContent = ""; //clearing it to test new word
     	}



     	FileWriter writer = new FileWriter("C:/Users/jbrit/Documents/Atomm/NewStoryTime.txt"); //adding the path of the new file
     	writer.write(revisedContent); //this new file was created by the java program
     	writer.close(); 
     }
 }