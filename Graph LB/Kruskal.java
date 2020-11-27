import java.util.*;

class Node{
	int parent;
	int rank;

	Node(){
		parent = -1;
		rank = 0;
	}
}

class Edge implements Comparable<Edge>{
	int src;
	int dest;
	int wt;

	public int compareTo(Edge e2){
		return (this.wt - e2.wt);
	}
}

class Kruskal{
	static Node[] pnr;
	static Edge[] edgeList;
	static Edge[] mst;

	public static void main(String[] args) {
		int V = 6;
		int E = 10;

		pnr = new Node[V];
		for(int k = 0; k<V; k++){
			pnr[k] = new Node();
		}

		edgeList = new Edge[E];

		mst = new Edge[V-1];

		// taking the input
		Scanner sc = new Scanner(System.in);
		for(int i=0; i<E; i++){
			System.out.println("Enter your "+(i+1)+" Edge");
			Edge temp = new Edge();
			temp.src = sc.nextInt();
			temp.dest = sc.nextInt();
			temp.wt = sc.nextInt();
			edgeList[i] = temp;
		}

		// sorting by edge weight
		Arrays.sort(edgeList);

		for(int i=0; i<E; i++){
			System.out.print(edgeList[i].wt+" ");
		}

		// calling the kruskal function
		kruskal(V, E);
	}

	static void kruskal(int V, int E){
		int i = 0;
		int j = 0;

		while(i < V-1 && j < E){
			int fromP = findParent(edgeList[j].src);
			int toP = findParent(edgeList[j].dest);

			if(fromP == toP){
				++j;
				continue;
			}

			unionP(fromP, toP);
			mst[i++] = edgeList[j];
		}

		System.out.println();
		
		for(i=0; i<V-1; i++){
			System.out.println("src "+mst[i].src+" dest "+mst[i].dest+" wt "+mst[i].wt);
		}
	}

	static int findParent(int v){
		if(pnr[v].parent == -1){
			return v;
		}

		return pnr[v].parent = findParent(pnr[v].parent);
	}

	static void unionP(int fromP, int toP){
		if(pnr[fromP].rank > pnr[toP].rank){
			pnr[toP].parent = fromP;
		}
		else if(pnr[toP].rank > pnr[fromP].rank){
			pnr[fromP].parent = toP;
		}
		else {
			pnr[toP].rank += 1;
			pnr[fromP].parent = toP;
		}
	}
}