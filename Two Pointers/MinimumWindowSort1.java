import java.util.*;

class Sol{
	int solution(int[] a, int length){
		int firstOutofOrder = -1;
		int lastOutofOrder = -1;
		int x = 0;
		int y = length-1;
		int count = 0;

		while(x < y){
			if(x > 0 && a[x] < a[x-1] && firstOutofOrder == -1){
				firstOutofOrder = x;
			}
			if(y < length-1 && a[y] > a[y+1] && lastOutofOrder == -1){
				lastOutofOrder = y;
			}
			x++;
			y--;
		}

		int min = Integer.MAX_VALUE;
		int max = Integer.MIN_VALUE;

		for(int i=firstOutofOrder; i<=lastOutofOrder; i++){
			if(a[i] < min){
				min = a[i];
			}
			if(a[i] > max){
				max = a[i];
			}
		}

		count = lastOutofOrder - firstOutofOrder + 1;

		x = 0;
		while(x < firstOutofOrder){
			if(a[x] > min){
				count++;
			}
			x++;
		}

		y = length-1;
		while(y > lastOutofOrder){
			if(a[y] < max){
				count++;
			}
			y--;
		}

		return count;
	}
}

class MinimumWindowSort1{
	public static void main(String[] args) {
		int[] a = {1, 2, 3};
		int length = a.length;
		Sol sol = new Sol();
		System.out.print(sol.solution(a,length));
	}
}