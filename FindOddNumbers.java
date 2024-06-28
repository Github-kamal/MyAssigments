package week1.day2;

public class FindOddNumbers {

	public static void main(String[] args) {
		// initialize the variable
		int maxRange = 10;
		//for loop to iterate the value from 1 to 10
		for (int i=1; i<=maxRange; ++i)
		{
			//Use modulus operator and find the reminder and compare with 1
			if(i%2==1)
			{
				System.out.println(i+ " is a odd number");
			}
			else
			System.out.println(i + " is a even number");
		}
		
		

	}

}
