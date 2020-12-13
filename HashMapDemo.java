import java.util.*;
import java.util.HashMap;

public class HashMapDemo{
	public static void main(String[] args){
		HashMap<String,Integer> map=new HashMap<>();
		map.put("USA",200);
		map.put("UK",175);
		map.put("India",300);
		map.put("China",350);
		System.out.println(map);
		map.put("Sweden",100);
		map.put("India",325);
		System.out.println(map.get("India"));
		System.out.println(map.get("RSA"));
		map.remove("USA");
		System.out.println(map.containsKey("India"));
		System.out.println(map.containsKey("USA"));
		System.out.println("****KEYS********");
		Set<String> keys=map.keySet();
		for(String key:keys){
			System.out.println(key);
		}
		System.out.println("*****VALUE*******");
		Collection<Integer> values=map.values();
		for(Integer value:values){
			System.out.println(value);
		}
		System.out.println("*****EntrySET********");
		Set<Map.Entry<String,Integer>> entries=map.entrySet();
		for(Map.Entry<String,Integer> entry:entries){
			System.out.println(entry.getKey()+"=>"+entry.getValue());
		}

		//maximum occuring char
		System.out.println("****Max occuring Character****");
		String str="aabbaaabcdda";
		System.out.println(getMaxFreq(str));

		//Intersection of two array
		System.out.println("****Intersection of two array****");
		int[] one={5,1,3,4,7};
		int[] two={2,4,3,5,7,10,15};
		ArrayList<Integer> list=getIntersection(one,two);
		System.out.println(list);
	}
	public static char getMaxFreq(String str){
		HashMap<Character,Integer> map=new HashMap<>();
		for(int i=0;i<str.length();i++){
			char cc=str.charAt(i);
			if(map.containsKey(cc)){
				int ov=map.get(cc);
				int nv=ov+1;
				map.put(cc,nv);
			}
			else{
				map.put(cc,1);
			}
		}
		char maxChar='\0';
		int max=0;
		Set<Map.Entry<Character,Integer>> entries=map.entrySet();
		for(Map.Entry<Character,Integer> entry:entries){
			if(entry.getValue()>max){
				max=entry.getValue();
				maxChar=entry.getKey();
			}
		}
		System.out.println(max);
		return maxChar;
	}

	//code intersection
	public static ArrayList<Integer> getIntersection(int[] one,int[] two){
		HashMap<Integer,Boolean> map=new HashMap<>();
		ArrayList<Integer> list=new ArrayList<>();
		for(int i=0;i<one.length;i++){
			map.put(one[i],false);
		}
		for(int j=0;j<two.length;j++){
			if(map.containsKey(two[j])){
				map.put(two[j],true);
			}
		}
		Set<Map.Entry<Integer,Boolean>> entries=map.entrySet();
		for(Map.Entry<Integer,Boolean> entry:entries){
			if(entry.getValue()){
				list.add(entry.getKey());
			}
		}
		return list;
	}

}