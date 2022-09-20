package pkg;
import java.util.Scanner;
import java.util.Random;

public class ProductMaker 
{
	private int[] data1;
	private int[] data2;

	public ProductMaker(int[] x, int[] y)
	{
		data1 = x;
		data2 = y;
	}

	public void setProducts()
	{
		int product = 1;
		for(int cntr = 0; cntr < data1.length; cntr++)
		{
			product = product * data1[cntr];
		}
		for(int cntr = 0; cntr < data1.length; cntr++)
		{
			data2[cntr] = product / data1[cntr];
			System.out.print(data2[cntr] + " ");
		}
	}

}
