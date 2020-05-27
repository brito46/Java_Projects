import java.util.*;
import java.io.File;
import java.io.FileNotFoundException;

//next tasks is to replace the word regardless with however
//C:\Users\jbrit\Documents\Atomm

public class FileTracker9000 {
     public static void main(String []args) throws FileNotFoundException{

     	File file = new File("C:\\Users\\jbrit\\Documents\\Atomm\\StoryTime.txt"); //we pass the path of the file

     	Scanner scan = new Scanner(file); //scanning the new file created called "file" 
                                            
          Scanner myScan = new Scanner(System.in); 
          System.out.println("What word do you want to track? \n");
          String WantedWord = myScan.nextLine(); //waiting for user to put word they want to track
          String LowerWantedWord = WantedWord.toLowerCase();//in case user's first letter is capitalized
          String UpperWantedWord = WantedWord.substring(0, 1).toUpperCase() + WantedWord.substring(1); 
          //in case user's first letter is not capatlized

     	String fileContent = "";
          //you could've done filecontent.toLowerCase(); after line 27 but that would've made unnecessary changes.
          int tracking = 0;

     	while(scan.hasNext()){ //it'll stay in while loop until it scans every line in file

     		fileContent = fileContent.concat(scan.next() ); 
               if(fileContent.contains(UpperWantedWord) || fileContent.contains(LowerWantedWord)) tracking +=1;
               fileContent = ""; //clearing it to test new word
                                 //if I would've used StringBuilder: sb.delete(0,sb.length());
               //i initially tried scan.nextLine(), but I realized the word we're looking can be repeated
               //in the same line, which is why I'm testing per word
               //to save time, a function can be written to check every word if word is detected in current line
     	}
          System.out.println("The number of times the file said " + WantedWord + " was: " + tracking + " time(s)!");
     }
 }