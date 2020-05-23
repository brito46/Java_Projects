import java.util.*;


public class mainGame {
     public static void main(String []args){

     	Player p1 = new Player();
     	Player p2 = new Player(); //a new instance of player class or a new object from player class

     	p1.power = 4; //you already setted power without actually using setPower method; so power = 4
     	p2.setPower(67); //basically the line above; set gives an option to be interactive so user can set it with a Cin 

     	Scanner myScan = new Scanner(System.in); //Cin

     	System.out.println("P1 set name:");
     
     	String P1Name = myScan.nextLine(); //waiting for a string input
     	p1.setName(P1Name);

     	System.out.println(p1.getName() + " has a power level of: " + p1.getPower());
     	System.out.println(p1.getName() + " Do you want to change your power? Type Yes or No");
     	String Answer = myScan.nextLine();

     	if(Answer.charAt(0) == 'Y')
     	{
     		System.out.println("Set new Power:");
     		int p1NewPower = myScan.nextInt(); //wating for int input
     		p1.setPower(p1NewPower); //changed power level
     		System.out.println("Saving...Beep...Boop...Bop! power level is now " + p1.getPower());//shows the updated power
     	}



     }
 }