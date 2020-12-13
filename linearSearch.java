public class linearSearch{
	public static void main(String arr[])
	{
		int [] array={10,30,35,40,65};;
		System.out.println(linear(array,35));
	}
	public static int linear(int[] arr, int item)
	{
		for(int i=0;i<arr.length;i++)
			{
				if(arr[i]==item)
				{
					return i;
				}
			}
			return -1;
	}
}