class sol{
	static int minNumberOfCoins(int[] coins,int[][] t,int sum,int coinsSize){
		for(int i=0;i<coinsSize+1;i++){
			for(int j=0;j<sum+1;j++){
				if(j == 0){
					t[i][j] = 0;
				}
				if(i == 0){
					t[i][j] = Integer.MAX_VALUE-1;
				}
			}
		}

		for(int i=1;i<coinsSize+1;i++){
			for(int j=1;j<sum+1;j++){
				if(coins[i-1] <= j){
					t[i][j] = Math.min( t[i][j-coins[i-1]]+1, t[i-1][j] );
				}else{
					t[i][j] = t[i-1][j];
				}
			}
		}
		return t[coinsSize][sum];
	}
}

class coinChange2{
	public static void main(String[] args) {
		int[] coins = {1,2,3};
		int sum = 3;
		int[][] t = new int[coins.length+1][sum+1];
		System.out.print(sol.minNumberOfCoins(coins, t, sum, coins.length));
	}
}