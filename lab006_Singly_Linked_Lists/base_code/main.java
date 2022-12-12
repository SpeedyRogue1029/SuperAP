import pkg.*;
import java.util.*;
import java.time.*;
import java.lang.*;

class main {
	public static void main(String args[]) {
		SinglyLinkedList bruh = new SinglyLinkedList();
		for(int cntr = 0; cntr < 20; cntr++)
		{
			bruh.insert(cntr,(int)(Math.random()*30));
		}
		bruh.printList();
		
		
	}
}
