class noOfIsland{

	void makeCalltoAdj(int[][] v,int row,int col){
		if( row<0 || col<0 || row>v.length-1 || col>v[0].length-1 || v[row][col] != 1 ){
			return;
		}

		v[row][col] = 2;
		makeCalltoAdj(v,row-1,col);
		makeCalltoAdj(v,row+1,col);
		makeCalltoAdj(v,row,col-1);
		makeCalltoAdj(v,row,col+1);
	}

	int countIsland(int[][] v,int rows,int cols){
		int count = 0;
		for(int i=0;i<rows;i++){
			for(int j=0;j<cols;j++){
				if(v[i][j] == 1){
					count++;
					makeCalltoAdj(v,i,j);
				}
			}
		}
		return count;
	}

	public static void main(String[] args) {
		int[][] v = {
						{1,1,0,0,0},
						{1,1,1,0,0},
						{0,0,1,0,0},
						{1,0,0,0,1},
						{1,1,0,0,0},
					};

		noOfIsland ni = new noOfIsland();
		System.out.print(ni.countIsland(v,5,5));
	}
}