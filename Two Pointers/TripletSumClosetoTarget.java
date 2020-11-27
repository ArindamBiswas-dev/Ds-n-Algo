import java.util.*;

class Sol{
	int solution(int[] a,int length,int target){
		int mainDiff = Integer.MAX_VALUE;

		for(int x=0;x<length;x++){

			int y = x+1;
			int z = length-1;
			int diff = Integer.MAX_VALUE;

			while(y < z){

				int tempDiff = target - a[x] -a[y] - a[z];

				System.out.println("tempDiff : "+tempDiff);

				if(tempDiff == 0){
					return target - tempDiff;
				}

				if(Math.abs(mainDiff) > Math.abs(tempDiff)){
					mainDiff = tempDiff;
				}

				if(tempDiff < 0){
					y++;
				} else {
					z--;
				}

			}

		}
		return mainDiff;
	}
}

class TripletSumClosetoTarget{
	public static void main(String[] args) {
		int[] a = {-2, 0, 1, 2};
		int target = 1;
		Arrays.sort(a);
		Sol sol = new Sol();
		System.out.print(sol.solution(a,a.length,target));
	}
}