class Lecture10{
	private int[] data;
	private int size;
	private int front;
	public static final int DEFAULT_CAPACITY=10;
	public Lecture10() throws Exception{
		this(DEFAULT_CAPACITY);
	}
	public Lecture10(int capacity) throws Exception{
		if(capacity<1){
			throw new Exception("invalid capacity");
		}
		this.data=new int[capacity];
		this.front =0;
		this.size=0;
	}
	public int size(){
		return this.size;
	}
	public boolean isEmpty(){
		return this.size()==0;
	}
	public void enqueue(int value) throws Exception{
		if(this.size==this.data.length){
			throw new Exception("Queue is full");
		}
		int av=(this.front+this.size)%this.data.length;
		this.data[av]=value;
		this.size++;
	}
	public int dequeue() throws Exception{
		if(this.size()==0){
			throw new Exception("Queue is empty");
		}
		int rv=this.data[this.front];
		this.front=(this.front+1)%this.data.length;
		this.size--;
		return rv;
	}
	public int front() throws Exception{
		if(this.size()==0){
			throw new Exception("Queue is empty");
		}
		int rv=this.data[this.front];
		return rv;
	}
	public void display(){
		for(int i=1;i<=this.size;i++){
			int ai=(this.front+1)%this.data.length;
			System.out.print(this.data[ai]+"=>");
		}
		System.out.print("end");
	}
}
public class QueueUsingArray{
	public static void main(String args[]){
		Lecture10 queue=new Lecture10(5);
		for(int i=0;i<5;i++){
			queue.enqueue(i*10);
			queue.display();
		}
	}	
}
