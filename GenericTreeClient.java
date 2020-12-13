import java.util.ArrayList;
import java.util.Scanner;
class GenericTree{
	public class Node{
		int data;
		ArrayList<Node> children;
		Node(int data){
			this.data=data;
			this.children=new ArrayList<>();
		}
	}
	private Node root;
	private int size;

	GenericTree(){
		Scanner s=new Scanner(System.in);
		this.root=takeInput(s,null,0);
	}
	//to take input of generic tree
	private Node takeInput(Scanner s, Node parent, int ithChild){
		if(parent==null){
			System.out.println("Enter the data for the root node");
		}
		else{
			System.out.println("Enter the data for the "+ithChild+"th child of "+parent.data);
		}
		int nodedata=s.nextInt();
		Node node = new Node(nodedata);
		this.size++;
		System.out.println("Enter the number of children for "+node.data);
		int children=s.nextInt();
		for(int i=0;i<children;i++){
			Node child=this.takeInput(s,node,i);
			node.children.add(child);
		}
		return node;
	}
	public void display(){
		this.display(this.root);
	}
	private void display(Node node){
		//node data
		String str=node.data+"=>";
		for(int i=0;i<node.children.size();i++){

			//add children data of current node
			str=str+node.children.get(i).data+" ";
		}
		str=str+", END";
		System.out.println(str);

		//display all node
		for(int i=0;i<node.children.size();i++){
			this.display(node.children.get(i));
		}
	}
}
public class GenericTreeClient{
	public static void main(String[] args){
		GenericTree tree=new GenericTree();
		tree.display();
	}
}