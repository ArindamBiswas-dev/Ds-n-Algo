import java.util.*;

class Sol{
	int solution(int[] a, int length){

		int[] b = new int[length];
		int k = 0;
		for(Integer i : a){
			b[k++] = i;
		}
		Arrays.sort(b);

		int x = 0;
		int y = length-1;
		int start = -1;
		int end = -1;

		while(x < y){

			if(a[x] != b[x] && start == -1){
				start = x;
			}
			if(a[y] != b[y] && end == -1){
				end = y;
			}
			x++;
			y--;

		}
		return (end-start+1 != 1) ? end-start+1 : 0;
	}
}

class MinimumWindowSort{
	public static void main(String[] args) {
		int[] a = {1, 2, 5, 3, 7, 10, 9, 12};
		int length = a.length;
		Sol sol = new Sol();
		System.out.print(sol.solution(a,length));
	}
}