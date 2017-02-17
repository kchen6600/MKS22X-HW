public class KnightBoard{

    private int[][]board;
    private String str = "";
    private int rowsize;
    private int colsize;

    public KnightBoard(int startingRows, int startingCols){
	board = new int[startingRows][startingCols];
	for (int i = 0; i < board.length; i++){
	    for (int j = 0; j < board[i].length; j++){
		board[i][j] = 0;
	    }
	}
	rowsize = startingRows;
	colsize = startingCols;
    }

    public String toString(){
	for (int i = 0; i < board.length; i++){
	    for (int j = 0; j <board[i].length; j++){
		str += board[i][j] + " ";
	    }
	    str+= "\n";
	}
	return str;
    }

    public void solve(){
	//	solveH((board.length)/2,(board[0].length)/2,1);
	solveH(0,0,1);
    }

    private boolean solveH(int row, int col, int level){
	
       	if (level > rowsize * colsize ){
	    return true;
	}
	if (!canBePlaced(row,col)){
	    return false;
	}

	board[row][col] = level;

        if (solveH(row+1, col+2, level+1)){
	    return true;
	}

	
	if (solveH(row+1, col-2, level+1)){
	    return true;
	}

	if (solveH(row+2, col+1, level+1)){
	    return true;
	}
       	if (solveH(row+2, col-1, level+1)){
	    return true;
	}
	if (solveH(row-1, col-2, level+1)){
	    return true;
	}

	
	if (solveH(row-2, col-1, level+1)){
	    return true;
	}

	if (solveH(row-1, col+2, level+1)){
	    return true;
	}


	if (solveH(row-2, col+1, level+1)){
	    return true;
	}

	board[row][col] = 0;
	return false;
    }


    private boolean canBePlaced(int row, int col){
	if (row >= rowsize || col >= colsize || row < 0 || col < 0){
	    return false;
	}
	if (board[row][col] == 0){
	    return true;
	}
	return false;
    }

    public static void main(String[]args){
	KnightBoard b = new KnightBoard(8,7);
       	b.solve();
	System.out.println(b);
    }
}
