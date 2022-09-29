import pkg.*;
import java.util.Scanner;
import java.util.Random;


class main {
	static int max;
	public static void main(String args[]) {
		int x = 120;
		max = 1;
		for(int cntr = x; cntr > 10; cntr = cntr/10)
		{
			max = max*10;
		}
		System.out.print(palindromeNumbers(x));
	}

	public static boolean palindromeNumbers(int bruh)
	{
		int subtracter1 = 0;
		int subtracter2 = 0;
		boolean yo = false;
		for(int cntr = 10; max >= cntr; cntr = cntr*10)
		{
			int checker1 = bruh/max;
			int checker2 = bruh%cntr;
			if(checker1 > 10)
			{
				subtracter1 = bruh/((max*10))*10;
				subtracter2 = bruh%max;
			}
			if((checker1 - subtracter1) == (checker2 - subtracter2))
			{
				yo = true;
			}
			max = max/10;
		}
		return yo;
	}
}
