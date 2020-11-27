import java.util.*;

class Sol{

	class Cell{
		int x,y,dis;
		Cell(int x, int y, int dis){
			this.x = x;
			this.y = y;
			this.dis = dis;
		}
	}

	boolean inSideTabel(int n,int x, int y){
		if(x >= 0 && x <= n && y >= 0 && y <= n){
			return true;
		}
		return false;
	}

	int minStep(int n, int[] knightPos, int[] targetPos){
		int[] dx = {-2, -1, 1, 2, -2, -1, 1, 2 };
		int[] dy = { -1, -2, -2, -1, 1, 2, 2, 1 };
		boolean[][] visited = new boolean[n+1][n+1];


		Cell knightCell = new Cell(knightPos[0], knightPos[1], 0);
		
		Queue<Cell> q = new LinkedList<Cell>();
		q.add(knightCell);
		visited[knightPos[0]][knightPos[1]] = true;

		while (q.peek() != null) {
			Cell currentCell = q.poll();

			if(currentCell.x == targetPos[0] && currentCell.y == targetPos[1]){
				return currentCell.dis;
			}

			for(int i=0; i<8; i++){
				int childX = currentCell.x - dx[i];
				int childY = currentCell.y - dy[i];
				if(inSideTabel(n, childX, childY) && visited[childX][childY] == false){
					q.add(new Cell(childX, childY, currentCell.dis + 1));
					visited[childX][childY] = true;
				}
			}
		}
		return Integer.MAX_VALUE;
	}
}

class StepsbyKnight{
	public static void main(String[] args) {
		int n = 20;
		int[] knightPos = {5,7};
		int[] targetPos = {15,20};
		Sol sol = new Sol();
		System.out.print(sol.minStep(n, knightPos, targetPos));
	}
}