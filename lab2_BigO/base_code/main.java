import pkg.*;
import java.util.*;
import java.time.*;
import java.lang.*;


class main {
static ArrayList<Integer> data = new ArrayList<Integer>();

	public void randomize(int[] x)
	{
		Random r = new Random();
		for(int cntr = 0; cntr < x.length; cntr++)
		{
			x[cntr] = r.nextInt(200001);
			data.add(x[cntr]);
		}
	}

	public boolean search(int[] x, int y)
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

	/*public void bubble(int[] x)
	{

	}

	public void insertion(int[] x)
	{

	}

	public void selection(int[] x)
	{

	}*/

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

			//

			finish = System.nanoTime();
			System.out.println("Started: " + start);
			System.out.println("Finished: " + finish);
			System.out.println("Duration: " + (finish-start));
			System.out.println("");
		}
	}
}
