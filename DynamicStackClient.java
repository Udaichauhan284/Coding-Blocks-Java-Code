class DynamicStack extends StackUsingArray{
	public DynamicStack() throws Exception{
		this(DEFAULT_CAPACITY);
	}
	public DynamicStack(int capacity) throws Exception{
		super(capacity);
	}
	public void push(int item) throws Exception{
		if(this.size()==this.data.length){
			int[] arr=new int[2*this.data.length];
			for(int i=0;i<this.size();i++){
				arr[i]=this.data[i];
			}
			this.data=arr;
		}
		super.push(item);
	}
}
class DynamicStackClient{
	public static void main(String[] args) throws Exception{
		StackUsingArray stack=new DynamicStack(5);
		for(int i=0;i<5;i++){
			stack.push(i*10);
		}
		stack.display();
		stack.push(60);
		stack.push(70);
		stack.display();
	}
}