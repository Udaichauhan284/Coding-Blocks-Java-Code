//kth Node from End

public class kthNodeFromEnd{
	public int NodeFromEnd(int k) throws Exception{
		if(k<=0 || k>this.size){
			throw new Exception("invalid value of k");
		}
		Node slow=this.head;
		Node fast=this.head;
		for(int i=0;i<k;i++){
			fast=fast.next;
		}
		while(fast!=null){
			slow=slow.next;
			fast=fast.next;
		}
		return slow.data;
	}
	public static void main(String args[]){
		
	}
}