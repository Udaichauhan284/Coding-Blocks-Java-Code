import java.util.*;
import java.util.HashMap;
class HuffmanEncoder{
	HashMap<Character,String> encoder;
	HashMap<String,Character> decoder;

	public HuffmanEncoder(String feeder){
		//create a freq map of this feeder string
		HashMap<Character,Integer> fmap=new HashMap<>();
		for(int i=0;i<=feeder.length();i++){
			char cc=feeder.charAt(i);
			if(fmap.containsKey(cc)){
				int ov=fmap.get(cc);
				ov=ov+1;
				fmap.put(cc,ov);
			}
			else{
				fmap.put(cc,1);
			}
		}

		//2.Create minheap of Trees.
		Heap<Node> minheap=new Heap<>(true);
		Set<Map.Entry<Character,Integer>> entryset=fmap.entrySet();
		for(Map.Entry<Character,Integer> entry:entryset){
			Node node=new Node(entry.getKey(),entry.getValue());
			minheap.add(node);
		}

		//3.combine nodes until one node is left in heap;
		while(minheap.size()!=1){
			Node minone=minheap.remove();
			Node mintwo=minheap.remove();

			Node combined=new Node(minone,mintwo);
			combined.data='\0';
			combined.cost=minone.cost+mintwo.cost;
			minheap.add(combined);
		}
		Node ft=minheap.remove();
		this.encoder=new HashMap<>();
		this.decoder=new HashMap<>();

		this.initEncoderDecoder(ft,"");
	}

	//Filling encoder and decoder
	private void initEncoderDecoder(){
		if(node==null){
			return;
		}
		if(node.left==null && node.right==null){
			this.encoder.put(node.data,osf);
			this.decoder.put(osf,node.data);
		}
		this.initEncoderDecoder(node.left,osf+"0");
		this.initEncoderDecoder(node.right,osf+"1");
	}

	public String encode(String source){
		String rv="";
		for(int i=0;i<source.length();i++){
			String code=this.encode.get(source.charAt(i));
			rv=rv+data;
		}
		return rv;
	}

	public String decode(String codedString){
		String rv="";
		String key="";
		for(int i=0;i<codedString.length();i++){
			key=key+codedString.charAt(i);
			if(this.decoder.containsKey(key)){
				rv=rv+this.decoder.get(key);
				key="";
			}
		}
		return rv;
	}
	private class Node implements Comparable<Node>{
		Character data;
		int cost;
		Node left;
		Node right;

		Node(char data,int cost){
			this.data=data;
			this.cost=cost;
			this.left=left;
			this.right=right;
		}

		Node(Node left,Node right){
			this.left=left;
			this.right=right;
		}

		//override
		public int compareTo(Node o){
			return this.cost-o.cost;
		}
	}
} 

public class HuffmanEncoderClient{
	public static void main(String[] args){
		String str="abbccda";
		HuffmanEncoder hf=new HuffmanEncoder(str);
		String codedString=hf.encode(str);
		System.out.println(codedString);
		String output=hf.decode(codedString);
		System.out.println(output);

		//BitSet
		BitSet bitSet=new BitSet(codedString.length());
		int bitcounter=0;
		for(Character c: codedString.toCharArray()){
			if(c.equals("1")){
				bitSet.set(bitcounter);
			}
			bitcounter++;
		}
		byte[] arr=bitSet.toByteArray();
		System.out.println("*************");
		System.out.println(arr.length);

	}
}

//010101101101110
//abbccda