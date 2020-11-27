import java.util.*;

class pairNode implements Comparable<pairNode>{
	int distance;
	int x;
	int y;
	pairNode(int distance,int x,int y){
		this.distance = distance;
		this.x = x;
		this.y = y;
	}

	@Override
	public int compareTo(pairNode p){
		if(this.distance < p.distance)
			return 1;
		return -1;
	}
}

class sol{
	Queue<pairNode> pq = new PriorityQueue<>();

	void findClosestOrigin(int[][] a,int row,int col,int k){
		for(int i=0;i<k;i++){
			int x = a[i][0];
			int y = a[i][1];
			int distance = (x*x) + (y*y);
			pq.add(new pairNode(distance,x,y));
		}
		for(int i=k;i<row;i++){
			int x = a[i][0];
			int y = a[i][1];
			int distance = (x*x) + (y*y);
			if(distance < pq.peek().distance){
				pq.poll();
				pq.add(new pairNode(distance,x,y));
			}
		}
		while(pq.size() > 0){
			System.out.println(pq.peek().x+" "+pq.peek().y+" "+pq.peek().distance);
			System.out.println();
			pq.poll();
		}
	}
}

class kClosestOrigin{
	public static void main(String[] args) {
		int[][] a = {
						{1,3},
						{-2,2},
						{5,8},
						{0,1},
						{2,0}
					};
		int row = 5;
		int col = 2;
		int k = 3;
		sol s = new sol();
		s.findClosestOrigin(a,row,col,k);
	}
}