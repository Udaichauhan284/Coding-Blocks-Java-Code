import java.util.Scanner;
public class arrayOps{
	public static void main(String ar[])
	{
		int[] array= takeInput();
		display(array);
	}
static Scanner scc= new Scanner(System.in);
	public static int[] takeInput(){
		System.out.println("Enter the array size ?");
		int n=scc.nextInt();
		int[] arr=new int[n];
		for(int i=0;i<arr.length;i++){
			System.out.println("Enter the value for "+ i+ "index");
			arr[i]=scc.nextInt();
		}
		return arr;
	}
	public static void display(int arr[])
	{
		for(int i=0;i<arr.length;i++)
		{
			System.out.println(arr[i]);
		}
	}
}