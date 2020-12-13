class QuickSorting{
	public static void main(String[] args)
	{
		int[] arr={40,20,90,30,70,10,80,60,50};
		quickSort(arr,0,arr.length-1);
		for(int i=0;i<arr.length;i++)
		{
			System.out.println(i + " ");
		}
	}
	public static void quickSort(int[] arr, int lo, int hi)
	{
		if(lo>=hi)
			return;
		//partioning
		int mid=(lo+hi)/2;
		int pivot=arr[mid];
		int left=lo;
		int right=hi;
		while(left<=right)
		{
			while(arr[left]<pivot)
			{
				left++;
			}
			while(arr[right]>pivot){
				right--;
			}
			if(left<=right)
			{
				int temp;
				temp=arr[left];
				arr[left]=arr[right];
				arr[right]=temp;
			}
		}
		//smaller problem
		quickSort(arr,lo,right);
		quickSort(arr,left,hi);
	}
}
