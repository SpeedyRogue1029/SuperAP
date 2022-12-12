import pkg.*;
import java.util.*;
import java.time.*;
import java.lang.*;

class main {
	public static void main(String args[]) {
		/*
			Create an ArrayList of 100 Nodes
			Store random integers in each of them
			Print out all of the values
		*/
		ArrayList<Node> Bruh = new ArrayList<Node>();
		for(int cntr = 0; cntr < 100; cntr++)
		{
			Node Heya = new Node((int)(Math.random()*10));
			if(cntr == 99)
			{
				Bruh.add(Heya);
			}
			else
			{
				Bruh.add(Heya);
			}
			System.out.print(Bruh.get(cntr).getData());
		}
	}
}
