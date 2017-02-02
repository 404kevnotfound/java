
import java.math.*;
import java.util.*;
import java.lang.Math;



public class Dices
{ 	

	public int ran1 = 0 ; 
	public int ran2 = 0 ; 
	public int ran3 = 0 ;
  

	public int roll()
	{
		this.ran1 = (int)(Math.random()* 10000) % 6 + 1;  
		return ran1;
		
	}
	public int roll2()
	{ 
		this.ran2 = (int)(Math.random()* 10000) % 6 + 1;
		return ran2;
	
	}
	public int roll3()
	{

		this.ran3 = (int)(Math.random()* 10000) % 6 + 1;
		return ran3 ;
	}


}