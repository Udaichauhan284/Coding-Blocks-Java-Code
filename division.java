import java.util.*;
class division{
	public static void main(String args[])
	{
		long int n;
		ArrayList<long int> arr = new ArrayList<long int>();
		Scanner sc=new Scanner(System.in);
		n=sc.nextLong();
		for(int i=1;i<=sqrt(n);i++)
		{
			if(n%i==0){
				if(n/i==i){
					System.out.print(i+ " ");
				}
				else{
					System.out.println(i+ " ");
					arr.add(i);
				}
			}
		}
		for(int i=arr.length-1;i>=0;i--){
			System.out.println(arr[i]+" ");
		}
	}
}