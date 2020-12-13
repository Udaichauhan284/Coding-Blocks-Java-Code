// O(n) complexity
class fact{
	public static void main(String args[]){
		System.out.println(factorial(5));
	}
	static int factorial(int n){
		if(n==0 || n==1){
			return 1;
		}
		else{
			int i=n;
			int facti=1;
			while(n/i !=n){
				facti=facti*i;
				i--;
			}
			return facti;
		}
		
	}
}