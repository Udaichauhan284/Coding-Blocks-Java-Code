import java.util.*;
import java.util.HashMap;
class Trie{
	private class Node{
		char data;
		HashMap<Character,Node> children;
		boolean isTerminal;
		Node(char data, boolean isTerminal){
			this.data=data;
			this.children=new HashMap<>();
			this.isTerminal=isTerminal;
		}
	}
	private int numWords;
	private Node root;

	Trie(){
		this.root=new Node('\0',false);
		this.numWords=0;
	}
	public int numWords(){
		return this.numWords;
	}
	public void addWord(String word){
		this.addWord(this.root,word);
	}
	private void addWord(Node parent,String word){
		if(word.length()==0){
			if(parent.isTerminal){
				//word already exist
			}
			else{
				parent.isTerminal=true;
				this.numWords++;
			}
			return;
		}
		char cc=word.charAt(0);
		String ros=word.substring(1);
		Node child=parent.children.get(cc);
		if(child==null){
			child=new Node(cc,false);
			parent.children.put(cc,child);
		}
		this.addWord(child,ros);
	}

	public void display(){
		this.display(this.root,"");
	}
	private void display(Node node,String osf){
		if(node.isTerminal){
			String todisplay=osf.substring(1)+node.data;
			System.out.println(todisplay);
		}
		Set<Map.Entry<Character,Node>> entries=node.children.entrySet();
		for(Map.Entry<Character,Node> entry:entries){
			this.display(entry.getValue(), osf+node.data);

		}
	}
	public boolean search(String word){
		return this.search(this.root,word);
	}
	private boolean search(Node parent,String word){
		if(word.length()==0){
			if(parent.isTerminal){
				return true;
			}else{
				return false;
			}
		}
		char cc=word.charAt(0);
		String ros=word.substring(1);
		Node child=parent.children.get(cc);
		if(child==null){
			return false;
		}
		return this.search(child,ros);
	}

	public void remove(String word){
		this.remove(this.root,word);
	}
	private void remove(Node parent, String word){
		if(word.length()==0){
			if(parent.isTerminal){
				parent.isTerminal=fasle;
				this.numWords--;
			}
			else{
				//word is a part of some other
			}
			return;
		}
		char cc=word.charAt(0);
		String ros=word.substring(1);
		Node child=parent.children.get(cc);
		if(child==null){
			return;
		}
		this.remove(child,ros);
		if(!child.isTerminal&&child.children.size()=0){
			parent.children.remove(cc);
		}
	}
}
public class TrieClient{
	public static void main(String[] args){
		Trie trie=new Trie();
		trie.addWord("art");
		trie.addWord("arts");
		trie.addWord("bug");
		trie.addWord("boy");
		trie.addWord("sea");
		trie.addWord("seen");
		trie.addWord("see");
		trie.addWord("amit");

		trie.display();

		System.out.println("*****Searching******");
		System.out.println(trie.search("arts"));

	}	
}