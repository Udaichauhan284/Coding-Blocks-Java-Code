//Calculator 

import java.util.*;
class calculator{
	public static void main(String ar[])
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the value of First number ");
		int a=sc.nextInt();
		System.out.println("The value of first number "+a);
		
		System.out.println("\nEnter the value of Second Number ");
		int b=sc.nextInt();
		System.out.println("The value of second number "+b);
		

		System.out.println("Enter 1 to Addition ");
		System.out.println("Enter 2 to Subtraction ");
		System.out.println("Enter 3 to Multiplication ");
		System.out.println("Enter 4 to Divide ");

		System.out.println("\nEnter the choice of your ");
		int choice=sc.nextInt();
		switch(choice){
			case 1:
			int sum=a+b;
			System.out.println("Addition of two number is "+sum);
			break;
			case 2:
			int sub=a-b;
			System.out.println("Subtraction of two number is "+sub);
			break;
			case 3:
			int mul=a*b;
			System.out.println("Multiplication of two number is "+mul);
			break;
			case 4:
			int div=a/b;
			System.out.println("Division of two number is "+div);
			break;
			default:
			System.out.println("Please choose correct number ");
		}
	}
}