import java.util.*;
public class reverseString{
	public static void main(String args[]){
		Scanner sc=new Scanner(System.in);
		String str="";
		String reverse="";
		int count=0;
		System.out.println("Enter the string ");
		str=sc.nextLine();
		int length=str.length();
		for(int i=length-1;i>=0;i--){
			reverse+=str.charAt(i);
		}
		System.out.println("Reverse String "+reverse);
		for(int i=0;i<=length-1;i++){
			if(str.charAt(i)==reverse.charAt(i)){
				count=count+1;
			}
		}
		System.out.println(count);
	}
}