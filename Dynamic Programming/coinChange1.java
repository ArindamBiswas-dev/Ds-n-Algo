class coinChange{

	int coinChangeRecursion(int[] coins,int sum,int len){
		if(len == 0 && sum == 0){
			return 1;
		}
		if(len == 0){
			return 0;
		}

		if(coins[len-1] <= sum){
			return (coinChangeRecursion(coins,sum-coins[len-1],len) + coinChangeRecursion(coins,sum,len-1)); 
		}
		return coinChangeRecursion(coins,sum,len-1);
	}

	int coinChangeMemorization(int[] coins,int sum,int len,int[][] t){
		if(len == 0 && sum == 0){
			return 1;
		}
		if(len == 0){
			return 0;
		}
		if(t[len][sum] != -1){
			return t[len][sum];
		}

		if(coins[len-1] <= sum){
			t[len][sum] = (coinChangeMemorization(coins,sum-coins[len-1],len,t) + coinChangeMemorization(coins,sum,len-1,t));
			return t[len][sum]; 
		}
		t[len][sum] = coinChangeMemorization(coins,sum,len-1,t);
		return t[len][sum];
	}

	int coinChangeBottomUp(int[] coins,int sum,int len,int[][] t){
		for(int i=1;i<len+1;i++){
			for(int j=1;j<sum+1;j++){
				if(coins[i-1] <= j){
					t[i][j] = (t[i][j-coins[i-1]]+t[i-1][j]);
				}else{
					t[i][j] = t[i-1][j];
				}
			}
		}
		return t[len][sum];
	}
}

class coinChange1{
	public static void main(String[] args) {
		coinChange ccr = new coinChange();
		int[] coins = {1,2,3};
		int sum = 4;
		System.out.println(ccr.coinChangeRecursion(coins,sum,coins.length));

		int[][] t = new int[coins.length+1][sum+1];
		for(int i=0;i<coins.length+1;i++){
			for(int j=0;j<sum+1;j++){
				if(i == 0){
					t[i][j] = 0;
				}
				if(j == 0){
					t[i][j] = 1;
				}
			}
		}
		System.out.println(ccr.coinChangeBottomUp(coins,sum,coins.length,t));
		
		for(int i=1;i<coins.length+1;i++){
			for(int j=1;j<sum+1;j++){
				t[i][j] = -1;
			}
		}
		System.out.println(ccr.coinChangeMemorization(coins,sum,coins.length,t));
	}
}