import java.util.*;

class MyClass{
	public static void main(String[] args) {
		Queue<Integer> q1 = new LinkedList<Integer>();
		Queue<Integer> q2 = new LinkedList<Integer>();
		int totalTime1 = 0;
		int totalTime2 = 0;

		Scanner sc = new Scanner(System.in);
		for(int i=0; i<10; i++){
			int x = sc.nextInt();
			if(x < 10 || x > 100){
				System.out.println("INVALID INPUT");
			} else {
				if(x > 60 && q2.size() < 5){
					q2.add(x);
				} else {
					q1.add(x);
				}
			}
		}

		totalTime1 = q1.size()*15;
		totalTime2 = q2.size()*15;
		System.out.println("QUEUE1 TIME:"+totalTime1+"mins");
		System.out.println("QUEUE2 TIME:"+totalTime2+"mins");
	}
}
