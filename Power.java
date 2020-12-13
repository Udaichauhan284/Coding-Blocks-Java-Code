//n to log n 
class Power{
	public static void main(String args[])
	{
		System.out.println(power(2,5));

	}
	public static int power(int x, int n)
	{
		if(n==0)
		{
			return 1;
		}
		int pnb2=power(x, n/2);
		if(n%2==1){
			return pnb2*pnb2*x;
		}
		else{
			return pnb2*pnb2;
		}
	}
}