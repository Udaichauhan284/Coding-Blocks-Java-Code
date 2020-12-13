import java.util.Scanner;
class takeTwoDArrayInput{
	public static void main(String[] args)
	{
		int[][] arr=takeInput();
		for(int i=0;i<arr.length;i++)
		{
			for(int j=0;j<arr.length;j++)
			{
				System.out.print(arr[i][j]+" ");
			}
			System.out.println("");
		}
	}
	private static int[][] takeInput(){
		Scanner a=new Scanner(System.in);
		System.out.println("Enter the Number of Rows ");
		int rows=a.nextInt();
		int[][] arr= new int[rows][];
		for(int row=0;row<rows;row++)
		{
			System.out.println("Enter the no. of cols for rows "+row);
			int cols=a.nextInt();
			arr[row]=new int[cols];
			for(int col=0;col<cols;col++)
			{
				System.out.println("Enter the value for Row "+row+" and col "+col);
				arr[row][col]=a.nextInt();
			}
		}
		return arr;
	}
}