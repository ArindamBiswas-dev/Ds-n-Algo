// class cut{
// 	int cutting(int[] price, int N, int[] length, int len){
// 		int[][] t = new int[N+1][N+1];

// 		for(int i=0;i<N+1;i++){
// 			for(int j=0;j<N+1;j++){
// 				if(i == 0 || j == 0){
// 					t[i][j] = 0;
// 				}
// 			}
// 		}

// 		for(int i=1;i<N+1;i++){
// 			for(int j=1;j<N+1;j++){
// 				if(length[i-1] <= N){
// 					t[i][j] = Math.max( price[i-1] + t[i][N-length[i-1]], t[i-1][j]);
// 				}else{
// 					t[i][j] = t[i-1][j];
// 				}
// 			}
// 		}

// 		return t[N][N];
// 	}
// }

class cut {

// recursion
    int getMaxVal1(int[] lengths, int[] values, int N, int n){
        if (N ==0 || n == 0) return 0;
        if (N < lengths[n-1]){
            return getMaxVal1(lengths,values, N, n-1);
        }
            return Math.max(values[n-1]+getMaxVal1(lengths,values, N-lengths[n-1], n),

            				 getMaxVal1(lengths,values, N, n-1));
 
    }

// memorization - top down
    int getMaxVal2(int[] lengths, int[] values, int N, int n,int[][] t){
        if (N ==0 || n == 0) return 0;
        if(t[n][N] != -1) return t[n][N];
        if (N < lengths[n-1]){
            t[n][N] = getMaxVal2(lengths,values, N, n-1,t);
            return t[n][N];
        }
            t[n][N] = Math.max(values[n-1]+getMaxVal2(lengths,values, N-lengths[n-1], n,t),
            	
            				 getMaxVal2(lengths,values, N, n-1,t));
            return t[n][N];
    }

// bottom up
    int getMaxVal3(int[] lengths, int[] values, int N, int n,int[][] t){

    	for(int i=0;i<n+1;i++){
    		for(int j=0;j<N+1;j++){
    			if(i == 0 || j == 0){
    				t[i][j] = 0;
    			}
    		}
    	}

    	for(int i=1;i<n+1;i++){
    		for(int j=1;j<N+1;j++){
    			if(j < lengths[i-1]){
    				t[i][j] = t[i-1][j];
    			}else{
    				t[i][j] = Math.max(values[i-1]+t[i][j-lengths[i-1]], t[i-1][j]);
    			}
    		}
    	}

    	return t[n][N];
    }
 }

class rodCut{
	public static void main(String[] args) {
		int[][] t = new int[9][9];
		for(int i=0;i<9;i++){			// require for memorization
			for(int j=0;j<9;j++){
				t[i][j] = -1;
			}
		}
		int[] price = {1, 5, 8, 9, 10, 17, 17, 20};
		int[] length = {1,2,3,4,5,6,7,8};
		int N = 8;	// total length
		int n = length.length;	// length array size
		cut c = new cut();
		System.out.print(c.getMaxVal3(length,price,N,n,t));
	}
}