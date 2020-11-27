import java.util.*;

class Sol{
	boolean isHappyUsingHashSet(int x){
		HashSet<Integer> set = new HashSet<Integer>();

		while(!set.contains(x)){
			set.add(x);
			int sum = 0;

			while(x > 0){
				sum += (x%10) * (x%10);
				x = x/10;
			}

			x = sum;
			// System.out.println(x);
		}
		return (x == 1) ? true : false;
	}

	boolean isHappy(int x){
		int fastPointer = x;
		int slowPointer = x;

		do{
			slowPointer = squreSum(slowPointer);
			fastPointer = squreSum(squreSum(fastPointer));
		} while(fastPointer != slowPointer);

		return (fastPointer == 1) ? true : false;
	}

	int squreSum(int x){
		int sum = 0;

		while(x > 0){
			sum += (x%10) * (x%10);
			x = x/10;
		}

		return sum;
	}
}

class HappyNumber{
	public static void main(String[] args) {
		int x = 23;
		Sol sol = new Sol();
		System.out.println(sol.isHappyUsingHashSet(x));
		System.out.println(sol.isHappy(x));
	}
}