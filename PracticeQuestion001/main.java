import pkg.*;
import java.util.Scanner;
import java.util.Random;

class main {
	public static void main(String args[]) {
		// Your code goes below here
		
		Random values = new Random();
		//int[] i = new int[5];
		int [] i = {-4,  -5, 4, 5};
		int[] v = new int[4];/*
		for(int cntr = 0; cntr < i.length; cntr++)
		{
			i[cntr] = values.nextInt(10)+1;
			System.out.print(i[cntr]+" ");
		}*/
		System.out.println("");
		ProductMaker hello = new ProductMaker(i,v);
		hello.setProducts();
		
	}
}
