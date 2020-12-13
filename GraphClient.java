import java.util.HashMap;
import java.util.ArrayList;
import java.util.*;
class Graph{
	private class Vertex{
		HashMap<String,Integer> nbrs=new HashMap<>();
	}
	HashMap<String, Vertex> vtces;

	public Graph(){
		vtces=new HashMap<>();
	}

	public int numVertex(){
		return this.vtces.size();
	}
	public boolean containsVertex(String vname){
		return this.vtces.containsKey(vname);
	}
	public void addVertex(String vname){
		Vertex vtx=new Vertex();
		vtces.put(vname,vtx);
	}
	public void removeVertex(String vname){
		Vertex vtx= vtces.get(vname);
		ArrayList<String> keys=new ArrayList<>(vtx.nbrs.keySet());
		for(String key:keys){
			Vertex nbrVtx=vtces.get(key);
			nbrVtx.nbrs.remove(vname);
		}
		vtces.remove(vname);
	}


	//Edges 
	public int numEdges(){  
		//add the total sum of neighour nodes of one node
		//and in this method every edges count 2 times.
		int count=0;
		ArrayList<String> keys=new ArrayList<>(vtces.keySet());
		for(String key:keys){
			Vertex vtx=vtces.get(key);
			count=count+vtx.nbrs.size();
		}
		return count/2;
	}
	public boolean containsEdge(String vname1, String vname2){
		Vertex vtx1=vtces.get(vname1);
		Vertex vtx2=vtces.get(vname2);

		if(vtx1==null || vtx2==null || !vtx1.nbrs.containsKey(vname2)){
			return false;
		}
		return true;
	}
	public void addEdge(String vname1,String vname2,int cost){
		Vertex vtx1=vtces.get(vname1); //2k
		Vertex vtx2=vtces.get(vname2); //4k

		if(vtx1==null || vtx2==null || vtx1.nbrs.containsKey(vname2)){
			return;
		}

		vtx1.nbrs.put(vname2,cost); //2k nbrs put C with a given cost
		vtx2.nbrs.put(vname1,cost); //4k nbrs put A with a given cost
	}
	public void removeEdge(String vname1,String vname2){
		Vertex vtx1=vtces.get(vname1); //2k
		Vertex vtx2=vtces.get(vname2); //4k

		if(vtx1==null || vtx2==null || !vtx1.nbrs.containsKey(vname2)){
			return;
		}
		vtx1.nbrs.remove(vname2); //2k nbrs remove C
		vtx2.nbrs.remove(vname1); //4k nbrs remove A
	}

	public void display(){

		System.out.println("---------------------");
		ArrayList<String> keys=new ArrayList<>(vtces.keySet());
		for(String key:keys){
			Vertex vtx=vtces.get(key);
			System.out.println(key+":"+vtx.nbrs);
		}

		System.out.println("----------------------");
	}

	//hasPath
	public boolean hasPath(String vname1,String vname2,HashMap<String,Boolean> processd){
		processd.put(vname1,true);
		
		//direct path
		if(containsEdge(vname1,vname2)){
			return true;
		}
		//devote the wrk to nbhbros
		Vertex vtx=vtces.get(vname1);
		ArrayList<String> nbrs=new ArrayList<>(vtx.nbrs.keySet());
		for(String nbr:nbrs){
			if(!processd.containsKey(nbr) && hasPath(nbr,vname2,processd)){
				return true;
			}
		}
		return false;
	}

	private class Pair{
		String vname;
		String psf;
	}

	//Breath First Search
	public boolean bfs(String src,String det){

		HashMap<String,Booelan> processed=new HashMap<>();
		LinkedList<Pair> queue=new LinkedList<>();

		//crate new pair
		Pair sp=new Pair();
		sp.vname=src;
		sp.psf=src;

		//put the new pair in queue
		queue.addLast(sp);

		//while queue is not empty keep on doing work
		while(!queue.isEmpty()){

			//remove a pair from queue
			Pair rp=queue.removeFirst();

			if(processed.containsKey(rp.vname)){
				continue;
			}

			//processed put
			processed.put(rp.vname,true);

			//DP
			if(containsEdge(rp.vname,dst)){
				//printing the path
				System.out.println(rp.psf+dst);
				return true;
			}
			//nbrs
			Vertex rpvtx=vtces.get(rp.vname);
			ArrayList<String> nbrs=new ArrayList<>(rpvtx.nbrs.keySet());
			
			//loop on nbrs
			for(String nbr:nbrs){

				//process only umprocessed nbrs
				if(!processed.containsKey(nbr)){
					Pair np=new Pair();
					np.vname=nbr;
					np.psf=rp.psf+nbr;
					queue.addLast(np);
				}
			}
		}
		return false;
	}

	//Depth First Search Use Stack
	public boolean dfs(String src,String det){

		HashMap<String,Booelan> processed=new HashMap<>();
		LinkedList<Pair> stack=new LinkedList<>();

		//crate new pair
		Pair sp=new Pair();
		sp.vname=src;
		sp.psf=src;

		//put the new pair in stack
		stack.addFirst(sp);

		//while queue is not empty keep on doing work
		while(!stack.isEmpty()){

			//remove a pair from queue
			Pair rp=stack.removeFirst();

			if(processed.containsKey(rp.vname)){
				continue;
			}

			//processed put
			processed.put(rp.vname,true);

			//DP
			if(containsEdge(rp.vname,dst)){
				//printing the path
				System.out.println(rp.psf+dst);
				return true;
			}
			//nbrs
			Vertex rpvtx=vtces.get(rp.vname);
			ArrayList<String> nbrs=new ArrayList<>(rpvtx.nbrs.keySet());
			
			//loop on nbrs
			for(String nbr:nbrs){

				//process only umprocessed nbrs
				if(!processed.containsKey(nbr)){
					Pair np=new Pair();
					np.vname=nbr;
					np.psf=rp.psf+nbr;
					stack.addFirst(np);
				}
			}
		}
		return false;
	}

	//Breath First Traversal
	public void bft(){

		HashMap<String,Booelan> processed=new HashMap<>();
		LinkedList<Pair> queue=new LinkedList<>();

		ArrayList<String> keys=new ArrayList<>(vtces.keySet());

		//for every node reapeat the process
		for(String key:keys){
			if(processed.containsKey(key)){
				continue;
			}
		//crate new pair
		Pair sp=new Pair();
		sp.vname=key;
		sp.psf=key;

		//put the new pair in queue
		queue.addLast(sp);

		//while queue is not empty keep on doing work
		while(!queue.isEmpty()){

			//remove a pair from queue
			Pair rp=queue.removeFirst();

			if(processed.containsKey(rp.vname)){
				continue;
			}

			//processed put
			processed.put(rp.vname,true);

			//syso
			System.out.println(rp.name+"via"+rp.psf);
			//nbrs
			Vertex rpvtx=vtces.get(rp.vname);
			ArrayList<String> nbrs=new ArrayList<>(rpvtx.nbrs.keySet());
			
			//loop on nbrs
			for(String nbr:nbrs){

				//process only umprocessed nbrs
				if(!processed.containsKey(nbr)){
					Pair np=new Pair();
					np.vname=nbr;
					np.psf=rp.psf+nbr;
					queue.addLast(np);
				}
			}
		}
		}
	}

	//Deapht Search Traversal
	public void dft(String src,String det){

		HashMap<String,Booelan> processed=new HashMap<>();
		LinkedList<Pair> stack=new LinkedList<>();
		ArrayList<String> keys=new ArrayList<>(vtces.keySet());

		for(String key:keys){
			if(processed.containsKey(key)){
				continue;
			}

			//crate new pair
		Pair sp=new Pair();
		sp.vname=src;
		sp.psf=src;

		//put the new pair in stack
		stack.addFirst(sp);

		//while queue is not empty keep on doing work
		while(!stack.isEmpty()){

			//remove a pair from queue
			Pair rp=stack.removeFirst();

			if(processed.containsKey(rp.vname)){
				continue;
			}

			//processed put
			processed.put(rp.vname,true);

			//DP
			System.out.println(rp.name+"via"+rp.psf)
			//nbrs
			Vertex rpvtx=vtces.get(rp.vname);
			ArrayList<String> nbrs=new ArrayList<>(rpvtx.nbrs.keySet());
			
			//loop on nbrs
			for(String nbr:nbrs){

				//process only umprocessed nbrs
				if(!processed.containsKey(nbr)){
					Pair np=new Pair();
					np.vname=nbr;
					np.psf=rp.psf+nbr;
					stack.addFirst(np);
				}
			}
		}
		}
	}

	//isCyclic
	public boolean isCyclic(){

		HashMap<String,Booelan> processed=new HashMap<>();
		LinkedList<Pair> queue=new LinkedList<>();

		ArrayList<String> keys=new ArrayList<>(vtces.keySet());

		//for every node reapeat the process
		for(String key:keys){
			if(processed.containsKey(key)){
				continue;
			}
		//crate new pair
		Pair sp=new Pair();
		sp.vname=key;
		sp.psf=key;

		//put the new pair in queue
		queue.addLast(sp);

		//while queue is not empty keep on doing work
		while(!queue.isEmpty()){

			//remove a pair from queue
			Pair rp=queue.removeFirst();

			if(processed.containsKey(rp.vname)){
				return true; //tell that cyclic is present
			}

			//processed put
			processed.put(rp.vname,true);

			//syso
			//System.out.println(rp.name+"via"+rp.psf);
			//nbrs
			Vertex rpvtx=vtces.get(rp.vname);
			ArrayList<String> nbrs=new ArrayList<>(rpvtx.nbrs.keySet());
			
			//loop on nbrs
			for(String nbr:nbrs){

				//process only umprocessed nbrs
				if(!processed.containsKey(nbr)){
					Pair np=new Pair();
					np.vname=nbr;
					np.psf=rp.psf+nbr;
					queue.addLast(np);
				}
			}
		}
	}
	return false;
}

	//isConnected
	public boolean isConnected(){

		int flag=0;
		HashMap<String,Booelan> processed=new HashMap<>();
		LinkedList<Pair> queue=new LinkedList<>();

		ArrayList<String> keys=new ArrayList<>(vtces.keySet());

		//for every node reapeat the process
		for(String key:keys){
			if(processed.containsKey(key)){
				continue;
			}
			flag++;
		//crate new pair
		Pair sp=new Pair();
		sp.vname=key;
		sp.psf=key;

		//put the new pair in queue
		queue.addLast(sp);

		//while queue is not empty keep on doing work
		while(!queue.isEmpty()){

			//remove a pair from queue
			Pair rp=queue.removeFirst();

			if(processed.containsKey(rp.vname)){
				continue;
			}

			//processed put
			processed.put(rp.vname,true);

			//syso
			//System.out.println(rp.name+"via"+rp.psf);
			//nbrs
			Vertex rpvtx=vtces.get(rp.vname);
			ArrayList<String> nbrs=new ArrayList<>(rpvtx.nbrs.keySet());
			
			//loop on nbrs
			for(String nbr:nbrs){

				//process only umprocessed nbrs
				if(!processed.containsKey(nbr)){
					Pair np=new Pair();
					np.vname=nbr;
					np.psf=rp.psf+nbr;
					queue.addLast(np);
				}
			}
		}
	}
	if(flag>=2){
		return false;
	}else{
		return true;
	}
}

	//isTree
	public boolean isTree(){
		return !isCyclic() && isConnected();
	}

	//get Connected Component
	public ArrayList<ArrayList<String>> getCC(){

		ArrayList<ArrayList<String>> ans= new ArrayList<>();
		HashMap<String,Booelan> processed=new HashMap<>();
		LinkedList<Pair> queue=new LinkedList<>();

		ArrayList<String> keys=new ArrayList<>(vtces.keySet());

		//for every node reapeat the process
		for(String key:keys){
			if(processed.containsKey(key)){
				continue;
			}

			//for new component sub arraylist
			ArrayList<String> subans=new ArrayList<>();
		//crate new pair
		Pair sp=new Pair();
		sp.vname=key;
		sp.psf=key;

		//put the new pair in queue
		queue.addLast(sp);

		//while queue is not empty keep on doing work
		while(!queue.isEmpty()){

			//remove a pair from queue
			Pair rp=queue.removeFirst();

			if(processed.containsKey(rp.vname)){
				continue;
			}

			//processed put
			processed.put(rp.vname,true);

			//syso
			subans.add(rp.vname);
			//nbrs
			Vertex rpvtx=vtces.get(rp.vname);
			ArrayList<String> nbrs=new ArrayList<>(rpvtx.nbrs.keySet());
			
			//loop on nbrs
			for(String nbr:nbrs){

				//process only umprocessed nbrs
				if(!processed.containsKey(nbr)){
					Pair np=new Pair();
					np.vname=nbr;
					np.psf=rp.psf+nbr;
					queue.addLast(np);
				}
			}
		}
		//put sub ans in final ans
		ans.add(subans);
	}
	return ans;
}

	//PRIMS ALGORITHM
	private class PrimsPair implements Comparable<PrimsPair>{
		String vname;
		String acqvname;
		int cost;

		@Override
		public int compareTo(PrimsPair o){
			return o.cost-this.cost;
		}
	}
	public Graph prims(){
		Graph mst=new Graph();
		HashMap<String,PrimsPair> map=new HashMap<>();
		HeapGeneric<PrimsPair> heap=new HeapGeneric<>();
		
		//make a pair and put in heap and map
		for(String key:vtces.keySet()){
			PrimsPair np=new PrimsPair();
			np.vname=key;
			np.acqvname=null;
			np.cost=Integer.MAX_VALUE;
			heap.add(np);
			map.put(key,np);
		}
		//till the heap is not empty keep on removing the pairs
		while(!heap.isEmpty()){
			//remove a pair
			PrimsPair rp=heap.remove();
			map.remove(rp.vname);

			//add to MST
			if(rp.acqvname==null){
				mst.addVertex(rp.vname);
			}else{
				mst.addVertex(rp.vname);
				mst.addEdge(rp.vname,rp.acqvname,rp.cost);
			}
			//nbrs
			for(String nbr:vtces.get(rp.vname).nbrs.keySet()){
				
				//work for nbrs which are in heap
				if(map.containsKey(nbr)){
					//get the oc and nc
					int oc=map.get(nbr).cost;
					int nc=vtces.get(rp.vname).nbrs.get(nbr);

					//update the pair only when nc < oc
					if(nc<oc){
						PrimsPair gp=map.get(nbr);
						gp.acqvname=rp.vname;
						gp.cost=nc;

						heap.updatePriority(gp);
					}
				}
			}
		}
		return mst;
	}

	//Dijkstra Algorithm
	private class DijkstraPair implements Comparable<DijkstraPair>{
		String vname;
		String psf;
		int cost;

		@Override
		public int compareTo(DijkstraPair o){
			return o.cost-this.cost;
		}
	}
	public HashMap<String, Integer> dijkstra(String src){
		HashMap<String,Integer> ans=new HashMap<>();
		HashMap<String,DijkstraPair> map=new HashMap<>();
		HeapGeneric<DijkstraPair> heap=new HeapGeneric<>();
		
		//make a pair and put in heap and map
		for(String key:vtces.keySet()){
			DijkstraPair np=new DijkstraPair();
			np.vname=key;
			np.psf="";
			np.cost=Integer.MAX_VALUE;
			if(key.equals(src)){
				np.cost=0;
				np.psf=key;
			}
			heap.add(np);
			map.put(key,np);
		}
		//till the heap is not empty keep on removing the pairs
		while(!heap.isEmpty()){
			//remove a pair
			DijkstraPair rp=heap.remove();
			map.remove(rp.vname);

			//add to ans
			ans.put(rp.vname,rp.cost);
			
			//nbrs
			for(String nbr:vtces.get(rp.vname).nbrs.keySet()){
				
				//work for nbrs which are in heap
				if(map.containsKey(nbr)){
					//get the oc and nc
					int oc=map.get(nbr).cost;
					int nc=rp.cost+vtces.get(rp.vname).nbrs.get(nbr);

					//update the pair only when nc < oc
					if(nc<oc){
						DijkstraPair gp=map.get(nbr);
						gp.psf=rp.psf+rp.vname;
						gp.cost=nc;

						heap.updatePriority(gp);
					}
				}
			}
		}
		return mst;
	}
}

public class GraphClient{
	public static void main(String[] args){
		Graph graph=new Graph();

		graph.addVertex("A");
		graph.addVertex("B");
		graph.addVertex("C");
		graph.addVertex("D");
		graph.addVertex("E");
		graph.addVertex("F");
		graph.addVertex("G");

		graph.addEdge("A","B",2);
		graph.addEdge("A","D",3);
		graph.addEdge("B","C",1);
		graph.addEdge("C","D",8);
		graph.addEdge("D","E",10);
		graph.addEdge("E","F",45);
		graph.addEdge("E","G",7);
		graph.addEdge("F","G",8);

		graph.display();
		System.out.println(graph.numVertex());
		System.out.println(graph.numEdges());

		System.out.println(graph.containsEdge("A","C"));
		System.out.println(graph.containsEdge("E","F"));

		System.out.println("---hasPath----");
		System.out.println(graph.hasPath("A","F",new HashMap<>()));
		graph.bft();
	}
}