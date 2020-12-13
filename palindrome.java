import java.util.*;
class palindrome{
	public static void main(String[] args){
		int temp;
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		int rev=0;
		int rem;
		temp=n;
		while(temp>0){
			rem=temp%10;
			temp=temp/10;
			rev=rev*10+rem;
		}
		if(n==rev){
			System.out.println("yes its palindrome");
		}
		else{
			System.out.println("no its not palindrome");
		}

	}
}