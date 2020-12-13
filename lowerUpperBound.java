class lowerUpperBound{
	public static void main(String ars[])
	{
		int[] array={1,2,2,2,3,3,3,9,11};
		System.out.println(lowerBound(array,2));
		System.out.println(upperBound(array,2));

		System.out.println(lowerBound(array,3));
		System.out.println(lowerBound(array,3));
	}
	public static int lowerBound(int[] arr,int data)
	{
		int low=0;
		int high=arr.length-1;
		int ans=-1;
		while(low<=high)
		{
			int mid=(low+high)/2;
			if(arr[mid]==data)
			{
				ans=data;
				high=mid-1;
			}
			else if(data<=arr[mid])
			{
				high=mid-1;
			}
			else
				low=mid+1;
		}
		return ans;
	}
	public static int upperBound(int[] arr,int data)
	{
		int low=0;
		int high=arr.length-1;
		int ans=-1;
		while(low<=high)
		{
			int mid=(low+high)/2;
			if(arr[mid]==data)
			{
				ans=data;
				low=mid+1;
			}
			else if(data<=arr[mid])
			{
				high=mid-1;
			}
			else
				low=mid+1;
		}
		return ans;
	}
}