//Dutch Flag Problem
class zeroOneTwo{
	public static void main(String args[])
	{
		int[] arr={0,1,0,2,1,0,2,1,2};
		int[] ans=sort(arr);
		for(int val:ans){
			System.out.println(val + " ");
		}
	}
	public static int[] sort(int[] arr)
	{
		int lo=0;
		int mid=0;
		int high=arr.length-1;
		while(mid<=high)
		{
			if(arr[mid]==0)
			{
				swap(arr,lo,mid);
				lo++;
				mid++;
			}
			else if(arr[mid]==1)
			{
				mid++;
			}
			else{
				swap(arr,mid,high);
				high--;
			}
		}
		return arr;
	}
	public static void swap(int[] arr, int i, int j)
	{
		int temp=arr[i];
		arr[i]=arr[j];
		arr[j]=temp;
	}
}