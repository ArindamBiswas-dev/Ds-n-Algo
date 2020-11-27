import java.util.*;

class Sol{
	void solution(int[] a, int length){
		int low = 0;
		int high = length-1;
		for(int i=0;i<=high;){
			if(a[i] == 0){
				swap(a,i,low);
				low++;
				i++;
			}
			else if(a[i] == 1){
				i++;
			}
			else{
				swap(a,i,high);
				high--;
			}
		}
	}

	void swap(int[] a, int i, int lh){
		int temp = a[i];
		a[i] = a[lh];
		a[lh] = temp;
	}
}

class DutchNationalFlagProblem{
	public static void main(String[] args) {
		int[] a = {1,0,1,2,1};
		int length = a.length;
		Sol sol = new Sol();
		sol.solution(a,length);
		for(Integer i : a){
			System.out.print(i+" ");
		}
	}
}