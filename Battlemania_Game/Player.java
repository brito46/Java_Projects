import java.util.*;



//setters and getters
//setters:methods that can easily set a certain variable from a class
//getters:methods that can easily get a variable from a class
public class Player{ //general stuff what we will need for the players

	String name; //every player should have a name
	int power; //every player should have a power 

	public void setName(String n)  //public means its accesible to everything in our program; void mean method doesnt return anything
	{
		name = n; 

	} //n is a local variable because it can only be referenced from our method

	public String getName() //get needs to return something; no parameters needed for this to get something from a class
	{
		return name; 

	}
	public void setPower(int p)  
	{
		power = p; 

	}
	public int getPower()  //returning the attribute of the object of the class
	{
		return power; 

	}
}