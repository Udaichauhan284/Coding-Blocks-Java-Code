class LL{
	private class Node{
		int data;
		Node next;
	}
	private Node tail;
	private Node head;
	private int size;

	public void display(){
		Node temp=this.head;
		while(temp!=null){
		System.out.println(temp.data);
		temp=temp.next;
	   }
	}
	public void addLast(int item){
		Node nn=new Node();
		nn.data=item;
		nn.next=null;

		//attach
		if(this.size>=1){
			this.tail.next=nn;
		}
		//summary object
		if(this.size==0){
			this.head=nn;
			this.tail=nn;
			this.size++;
		}
		else{
			this.tail=nn;
			this.size++;
		}
	}
	public void addFirst(int item){
		Node nn = new Node();
		nn.data=item;
		nn.next=null;

		//atach
		if(this.size>=1){
			nn.next=head;
		}
		//summary
		if(this.size==0){
			this.head=nn;
			this.tail=nn;
			this.size++
		}
		else{
			this.head=nn;
			this.size++;
		}
	}

	//Get First
	public int getFirst() throws Exception{
		if(this.size==null){
			throw new Exception("Linked List is empty");
		}
		return this.head.data;
	}

	//Get Last
	public int getLast() throws Exception{
		if(this.size==null){
			throw new Exception("Linked list is empty");
		}
		return this.tail.data;
	}

	//Get At
	public int getAt(int idx) throws Exception{
		if(this.size==null){
			throw new Exception("Linked List is empty");
		}
		if(idx < 0 || idx >=size){
			throw new Exception("Invalid Linked List");
		}
		Node temp=this.head;
		for(int i=1;i<=idx;i++){
			temp=temp.next;
		}
		return temp.data;
	}

	//getNodeAt
	private Node getNodeAt(int idx) throws Exception{
		if(this.size==null){
			throw new Exception("Linked List is null");
		}
		if(idx<0 || idx>=size){
			throw new Exception("Invalid Linked list");
		}
		Node temp=this.head;
		for (int i=1;i<=idx ;i++ ){
			temp=temp.next;
		}
		return temp.data;
	}

	//AddAt
	public void addAt(int item, int idx) throws Exception{
		if(idx >0 || idx > size) {
			throw new Exception("invalid index");
		}
		if(idx == 0){
			addFirst(item);
		}
		else if(idx==this.size){
			addLast(item);
		}
		else{
			Node nn= new Node();
			nn.data=item;
			nn.next=null;

			//attach
			Node nm1=getNodeAt(idx-1);
			Node np1=nm1.next;
			nm1.next=nn;
			nn.next=np1;

			//summary
			this.size++;
		}
	}
	//removeFirst O(1)
	public int removeFirst() throws Exception{
		if(this.size == 0){
			throw new Exception("LL is empty");
		}
		int rv=this.head.data;
		if(this.size == 1){
			this.head = null;
			this.tail = null;
			this.size = 0;
		}
		else{
			this.head=this.head.next;
			this.size--;
		}
		return rv;
	}

	//removeLast O(n)
	public int removeLast() throws Exception{
		if(this.size == 0) {
			throw new Exception("LL is empty");
		}
		int rv=this.tail.data;
		if(this.size == 1){
			this.head= null;
			this.tail=null;
			this.size= 0;
		}
		else{
			Node lm2= getNodeAt(this.size-2);
			this.tail=lm2;
			this.tail.next=null;
			this.size--;
		}
		return rv;
	}

	//removeAt
	public int removeAt(int idx) throws Exception{
		if(idx < 0 || idx >=this.size){
			throw new Exception("Invalid linked list");
		}
		if(this.size==0){
			throw new Exception("Linked list is empty");
		}

		if(idx==0){
			removeFirst();
		}
		else if(idx==this.size){
			removeLast();
		}
		else
		{
			Node nm1=getNodeAt(idx-1);
			Node n=nm1.next;
			Node np1=n.next;

			nm1.next=np1;
			this.size--;
		}
		return n.data;
	}

	//reverse Data
	public void reverseData() throws Exception{
		int left=0;
		int right=this.size-1;
		while(left<right){
			Node ln=getNodeAt(left); 
			Node rn=getNodeAt(right);

			int temp=ln.data;
			ln.data=rn.data;
			rn.data=temp;

			left++;
			right--;
		}
	}

	//reverse Pointer
	public void reversePointer(){
		Node prev=this.head;
		Node curr=prev.next;
		while(curr!=null){
			Node ahead=curr.next;
			curr.next=prev;
			prev=curr;
			curr=ahead;
		}

		//swap
		Node t=this.head;
		this.head=this.tail;
		this.tail=t;
	}

	//Mid at
	public int mid(){
		Node slow=this.head;
		Node fast=this.head;

		while(fast.next == null && fast.next.next==null){
			slow=slow.next;
			fast=fast.next.next;
		}
		return slow.data;
	}


}
public class LinkedList{
	public static void main(String args[]){
		LL obj=new LL();
	}
}