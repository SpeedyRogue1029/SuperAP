package pkg;
import java.util.Scanner;
import java.util.Random;


public class SinglyLinkedList {
	Node head;

	/* 
		Postcondition: The head will be null 
	*/
	public SinglyLinkedList() 
	{
		head = null;
	}
	/* 
		Receives an integer position, searches through the SinglyLinkedList for the position and returns the data at that positon
	   	If the position doesn't exist, it returns -1
	*/ 
	public int get(int pos)
	{
		Node curr = head;
		for(int cntr = 0; cntr < pos; cntr++)
		{
			curr = curr.getNext();
			if(cntr == pos - 1)
			{
				if(curr.getNext() != null)
				{
					return curr.getNext().getData();
				}
			}
		}
		return -1;
	}

	/*
		Insert a new Node at the given position with the data given
	*/
	public void insert(int pos, int data)
	{
		Node bruh = new Node(data);
		Node curr = head;
		for(int cntr = 0; cntr < pos; cntr++)
		{
			if(curr == null)
			{
				curr = bruh;
			}
			else
			if(curr.getNext() == null)
			{
				curr.setNext(bruh);
			}
			else
			if((pos-1) == cntr)
			{
				Node curr2 = curr.getNext();
				bruh.setNext(curr2);
				curr.setNext(bruh);
			}
			curr = curr.getNext();
		}		
	}

	/*
		Remove the node at the given position
		If no position exists, don't change the list
	*/
	public void remove(int pos)
	{
		Node curr = head;
		for(int cntr = 0; cntr < pos; cntr++)
		{
			if(curr.getNext() == null)
			{
				curr = null;
				break;
			}
			else
			if(cntr == pos-1 && pos == 1)
			{
				curr = null;
				break;
			}
			if(cntr == pos-1)
			{
				Node curr2 = curr.getNext();
				Node curr3 = curr2.getNext();
				curr.setNext(curr3);
				
				curr2 = null;
				break;
			}
			curr = curr.getNext();
		}		
	}

	/*
		Swap two Nodes with the two positions given
	*/
	public void swap(int pos1, int pos2)
	{
		Node curr = head;
		Node curr2 = null;
		Node curr3 = null;
		for(int cntr = 0; cntr < pos2; cntr++)
		{
			if(cntr == pos1-1)
			{
				curr2 = curr;
			}
			if(cntr == pos2-1)
			{
				curr3 = curr;
				curr2.setNext(curr3.getNext());
				curr3.setNext(curr2.getNext());
			}
		}		
	}

	/*
		Print all data values in the LinkedList 
	*/
	public void printList()
	{
		Node a = head;
		while(a != null)
		{
			System.out.println(a.getData());
			a = a.getNext();
		}
	}
}
