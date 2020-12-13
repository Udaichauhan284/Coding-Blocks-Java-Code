import java.util.Scanner;
public class ganeshPattern{
	public static void main(String ar[])
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the value of n ");
		int n=sc.nextInt();

		//first component
		System.out.print("*");
		for(int i=1;i<=(n-3)/2;i++)
		{
			System.out.print(" ");
		}
		for(int i=1;i<=(n+1)/2;i++)
		{
			System.out.print("*");
		}
		System.out.println("");

		//second 
		for(int rows=1;rows<=(n-3)/2;rows++)
		{
			System.out.print("*");
		}
		for(int i=1;i<=(n-3)/2;i++)
		{
			System.out.print(" ");
		}
		System.out.print("*");
		System.out.println(" ");

		//third
		for(int i=1;i<=n;i++)
		{
			System.out.print("*");
		}

		//forth
		for(int rows=1;rows<=(n-3)/2;rows++)
		{
			for(int i=1;i<=(n-3)/2+1;i++)
			{
				System.out.print(" ");
			}
			System.out.print("*");
			for(int i=1;i<=(n-3)/2;i++)
			{
				System.out.print(" ");
			}
			System.out.print("*");
		}
		for(int rows=1;rows<=(n+1)/2;rows++)
		{
			System.out.print("*");
		}
		for(int i=1;i<=(n-3)/2;i++)
		{
			System.out.print(" ");
		}
		System.out.print("*");
		System.out.println(" ");
	}
}