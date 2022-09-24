import pkg.*;
import java.util.*;
import java.time.*;
import java.lang.*;


class main {
static ArrayList<Integer> data = new ArrayList<Integer>();

	public static void randomize(int[] x)
	{
		Random r = new Random();
		for(int cntr = 0; cntr < x.length; cntr++)
		{
			x[cntr] = r.nextInt(200001);
			data.add(x[cntr]);
		}
		System.out.println("randomize done");
	}

	public static boolean search(int[] x, int y)
	{
		randomize(x);
		for(int cntr = 0; cntr < data.size(); cntr++)
		{
			if(data.get(cntr)==y)
			{
				return true;
			}
		}
		return false;
	}

	public static void bubble(int[] x)
	{	
		randomize(x);
		int length = data.size();
		for(int cntr = 0; cntr < length; cntr++)
		{
			for(int cntr2 = 1; cntr2 < length; cntr2++)
			{
				if(data.get(cntr2) < data.get(cntr2-1))
				{
					data.set(cntr2-1, data.get(cntr2));
					data.set(cntr2, data.get(cntr2-1));
				}
			}
		}
	}
	
	public static void insertion(int[] x)
	{
		randomize(x);
		int length = data.size();
		for(int cntr = 1; cntr < length; cntr++)
		{
			int bruh1 = cntr - 1;
			int bruh2 = cntr;

			while(bruh1 > 0)
			{
				if(data.get(bruh1) > data.get(bruh2))
				{
					data.set(bruh1, data.get(bruh2));
					data.set(bruh2, data.get(bruh1));
				}
				bruh1--;
			}
		}

	}

	public static void selection(int[] x)
	{
		randomize(x);
		int length = data.size();
		for(int cntr = 0; cntr < length; cntr++)
		{
			int cntr2 = cntr + 1;
			while(cntr2 < length)
			{
				if(data.get(cntr) > data.get(cntr2))
				{
					data.set(cntr, data.get(cntr2));
					data.set(cntr2, data.get(cntr));
				}
				cntr2++;
			}	
		}
	}

	static final long createdNano = System.nanoTime();

	public static void main(String args[]) {
		long start = System.nanoTime();
		long finish = System.nanoTime();
		System.out.println("Created: " + createdNano);
		
		int [] times = {10, 100, 1000, 10000, 100000, 1000000, 10000000};
		int [] nums = new int[100];


		System.out.println("-------------------Test-------------------");
		System.out.println("");
		for(int i : times){
			System.out.println("Interval: " + i);
			
			nums = new int[i];
			start = System.nanoTime();

			//  Put your method between these two comments
			selection(nums);
			//

			finish = System.nanoTime();
			System.out.println("Started: " + start);
			System.out.println("Finished: " + finish);
			System.out.println("Duration: " + (finish-start));
			System.out.println("");
		}
	}
}
