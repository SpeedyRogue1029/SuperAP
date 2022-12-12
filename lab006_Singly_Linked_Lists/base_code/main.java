import pkg.*;
import java.util.*;
import java.time.*;
import java.lang.*;

class main {
	public static void main(String args[]) 
	{
		SinglyLinkedList bruh = new SinglyLinkedList();
		for(int cntr = 0; cntr < 20; cntr++)
		{
			bruh.insert(cntr, (int)(Math.random() * 20));
		}

		bruh.printList();

		System.out.println("");
		System.out.println("insert -1");
		System.out.println("");

		for(int cntr = 0; cntr < 20; cntr++){
			int randomPos = (int)(Math.random() * 20);
			bruh.insert(randomPos, -1);
		}

		bruh.printList();


		System.out.println("");
		System.out.println("reverse");
		System.out.println("");
		
		for(int cntr = 0; cntr < 20; cntr++)
		{
			bruh.swap(cntr, 39 - cntr);
		}

	



		bruh.printList();
		
	}
}
