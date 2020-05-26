import java.util.*;

public class Weapons {
//if there was a new weapon added, ill create a function to make the new weapon a instance of the specifc child class
//based on the attributes of the new weapon such as reload time and damage.

	String WeaponName;
	int damage;
	int reloadTime;
	int ammo;

	public void setDamage(int d)  
	{
		damage = d; 
	}

	public class Sniper extends Weapons{ //making a child class and "weapons" is the parent class
            //an instance of the Sniper class can used methods derived in Weapons(parent) class and sniper(child) class

	}

	public class Shotgun extends Weapons{

	}
}