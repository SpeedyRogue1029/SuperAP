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
		Node prevNode = null;
		int current = 0;
		if(head == null)
		{
			head = bruh;
		}		
		else
		{
			prevNode = head;
		}
		while(true)
		{
			if(pos == 0)
			{
				bruh.setNext(head);
				head = bruh;
				break;
			}
			if(prevNode.getNext() == null)
			{
				prevNode.setNext(bruh);
				break;
			}
			if(current == pos)
			{
				bruh.setNext(prevNode.getNext());
				prevNode.setNext(bruh);
				prevNode = prevNode.getNext();
				break;
			}
			prevNode = prevNode.getNext();
			current++;
		}
	}

	/*
		Remove the node at the given position
		If no position exists, don't change the list
	*/
	public void remove(int pos)
	{
		int posNew = pos - 1;
		Node previousNode = head;

		if(previousNode == null){
			return;
		}

		int nextPos = 0;

		while(true){
			if(nextPos == posNew)
			{
				if(previousNode.getNext().getNext() == null)
				{
					previousNode.setNext(null);
					return;
				}
				if(previousNode.getNext() != null && previousNode.getNext().getNext() != null)
				{
					previousNode.setNext(previousNode.getNext().getNext());
					return;
				}
				// System.out.println("CAUGHT");
			}
			if(previousNode.getNext() != null)
			{
				previousNode = previousNode.getNext();
				nextPos++;
				// System.out.println("UP 1: " + nextPos);
			}
		}
	}


	/*
		Swap two Nodes with the two positions given
	*/
	public void swap(int pos1, int pos2)
	{
		int data = get(pos1);
		System.out.println(data);
		int data2 = get(pos2);
		System.out.println(data2);


		insert(pos1, data2);
		remove(pos1 + 1);


		insert(pos2, data);
		remove(pos2 + 1);
	}

	/*
		Print all data values in the LinkedList 
	*/
	public void printList()
	{
		int currPos = 0;
		Node currNode = head;
		while(true)
		{
			System.out.println(currNode.getData());
			currNode = currNode.getNext();
			currPos++;
			if(currNode == null)
			break;
		}
	}
}
