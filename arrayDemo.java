public class arrayDemo {
    public static void main(String ar[])
    {
        //declare
        int[] arr = null;
        //System.out.println(arr);
        arr=new int[5];
        //System.out.println(arr);
        // System.out.println(arr[0]);
        // System.out.println(arr[1]);
        // System.out.println(arr[2]);
        // System.out.println(arr[3]);
        // System.out.println(arr[4]);

        //set
        arr[0]=10;
        arr[1]=20;
        arr[2]=30;
        arr[3]=40;
        arr[4]=50;
        //print
        // for(int i=0; i< arr.length; i++)
        // {
        //     System.out.println(arr[i]);
        // }

        //in reverse order
    //     for(int i=arr.length-1; i>=0;i--)
    //     {
    //         System.out.println(arr[i]);
    //     }

    //enhamced Loop
    // for(int val:arr)
    // {
    //     System.out.println(val);
    // }
    
    int a=0; 
    int j=2;
    System.out.println(arr[a] + " "+ arr[j]);
    Swap(arr,a,j);
    System.out.println(arr[a]+ " "+ arr[j]);
    }
    public static void Swap(int[] arr,int a,int j){
        int temp=arr[a];
        arr[a]=arr[j];
        arr[j]=temp;
    }
}