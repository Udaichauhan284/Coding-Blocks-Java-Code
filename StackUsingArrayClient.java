class StackUsingArray{
	protected int[] data;
	protected int top;

	public static final int DEFAULT_CAPACITY=10;
	public StackUsingArray() throws Exception{
		this(DEFAULT_CAPACITY);
	}
	public StackUsingArray(int capacity) throws Exception{
		if(capacity<1){
			throw new Exception("Invalid capacity");
		}
		this.data=new int[capacity];
		this.top=-1;
	}
	public int size(){
		return this.top+1;
	}
	public boolean isEmpty(){
		return this.size()==0;
	}
	public void push(int value) throws Exception{
		if(this.size()==this.data.length){
			throw new Exception("Stack is full");
		}
		this.top++;
		this.data[this.top]=value;
	}
	public int pop() throws Exception{
		if(this.size()==0){
			throw new Exception("stack is empty");
		}
		int rv=this.data[this.top];
		this.data[this.top]=0;
		this.top--;
		return rv;
	}
	public int top() throws Exception{
		if(this.size()==0){
			throw new Exception("stack is empty");
		}
		int topv=this.data[this.top];
		return topv;
	}
	//O(n)
	public void display(){
		for(int i=this.top;i>=0;i--){
			System.out.print(this.data[i]+",");
		}
		System.out.print("END");
	}
}
public class StackUsingArrayClient{
	public static void main(String[] args) throws Exception{
		StackUsingArray stack = new StackUsingArray(5);
		for(int i=1;i<5;i++){
			stack.push(i*10);
		}
		stack.display();

		//Revers
		StackUsingArray helper = new StackUsingArray(5);
		reverseStack(stack,helper,0);
		stack.display();
	}

	public static void reverseStack(StackUsingArray stack,StackUsingArray helper,int index) throws Exception{
		if(stack.isEmpty()){
			return;
		}
		int item=stack.pop();
		reverseStack(stack,helper,index+1);
		helper.push(item);
		if(index==0){
			while(!helper.isEmpty()){
				stack.push(helper.pop());
			}
		}
	}
}