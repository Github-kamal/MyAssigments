package week1.day1;

public class Fibonacci {

	public static void main(String[] args) {
		// Create a for loop to iterate the numbers to 8
		int fn = 0, f1 =0, f2 =1;	
		
		for (int i=0;i<=8;i++)
									
		{
			fn = f1+f2;
			f1 = f2;
			f2 = fn;
			if(fn<=8 || fn==0 || fn==1)
			{
			System.out.println(fn);
			}
		}

	}

}
