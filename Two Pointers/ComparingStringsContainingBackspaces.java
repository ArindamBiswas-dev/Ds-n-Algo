import java.util.*;

class Sol{
	boolean solution(String a, String b, int len1, int len2){
		String a1 = "";
		String b1 = "";
		int x = len1-1;
		int y = len2-1;
		int count = 0;

		while(y >= 0){
			if(b.charAt(y) != '#'){

				b1 += b.charAt(y);
				--y;

			} else {

				while(b.charAt(y) == '#'){
					--y;
					count++;
					
				}
				y -= count;

			}
			count = 0;
		}
		System.out.println(b1);

		count = 0;
		while(x >= 0){
			if(a.charAt(x) != '#'){
				a1 += a.charAt(x);
				x--;
			} else {
				while(a.charAt(x) == '#'){
					x--;
					count++;
				}
				x -= count;
			}
			count = 0;
		}
		System.out.println(a1);

		if(a1.equals(b1)) return true;
		return false;
	}
}

class ComparingStringsContainingBackspaces{
	public static void main(String[] args) {
		String a = "xy#z";
		String b = "xyz#";
		int len1 = a.length();
		int len2 = b.length();
		Sol sol = new Sol();
		System.out.print(sol.solution(a,b,len1,len2));
	}
}