public class maxInArray{
	public static void main(String arr[])
	{
		int[] array={10,5,15,1,20,40};
		System.out.println(maxinarr(array));
	}
	public static int maxinarr(int[] arr)
	{
		int max=Integer.MIN_VALUE;
		for(int i=0;i<arr.length;i++)
		{
			if(arr[i]>max)
			{
				max=arr[i];
			}
		}
		return max;
	}
}