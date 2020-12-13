class insertionSort{
	public static void main(String ars[])
	{
		int[] array={99,11,88,55,44,77};
		insertion(array);
		display(array);
	}	
	public static void insertion(int[] arr)
	{
		for(int counter=0;counter<=arr.length-1;counter++)
		{
			int val=arr[counter];
			int j=counter-1;
			while(j>=0 && arr[j]>val)
			{
				arr[j+1]=arr[j];
				j--;
			}
			arr[j+1]=val;
		}
	}
	public static void display(int[] arr)
	{
		for(int i=0; i<arr.length;i++)
		{
			System.out.println(arr[i]);
		}
	}

}