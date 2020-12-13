import java.util.Scanner;
class primeNumber{
	public static void main(String args[]){
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		int counter=0;
		String primeNums="";
		for(int i=0;i<n;i++)
		{
			for(int num=i;num>=1;num++)
			{
				if(i%num==0)
				{
					counter=counter+1;
				}
			}
			if(counter==2)
			{
				
				primeNums=primeNums+i+" ";
			}
		}
		System.out.println("Prime Number from 1 to "+n);
		System.out.println(primeNums);
	}
}