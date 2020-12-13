import java.util.Scanner;
public class binarySearch{
	public static void main(String[] args) {
		
		Scanner sc=new Scanner(System.in);
		int[] array={5,10,11,13,15,18,25,30,32,35,40,45,50};
		display(array);
		System.out.println("Enter the number you want to show their Index");
		int n=sc.nextInt();
		System.out.println(binaryy(array,n));
	}
	public static int binaryy(int[] arr,int item)
	{
		int lo=0;
		int hi=arr.length-1;
	

		while(lo<=hi)
		{
			int mid=(lo+hi)/2;

			if(arr[mid]<item)
			{
				lo=mid+1;
			}
			else if(arr[mid]>item)
			{
				hi=mid-1;
			}
			else{
				return mid;
			}
		}
		return -1;
	}
	public static void display(int[] arr)
	{
		for(int i=0; i<arr.length;i++)
		{
			System.out.println(arr[i]);
		}
	}
}