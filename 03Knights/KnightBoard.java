public class KnightBoard{

    private int[][]board;
    private String str = "";

    public KnightBoard(int startingRows, int startingCols){
	board = new int[startingRows][startingCols];
	for (int i = 0; i < board.length; i++){
	    for (int j = i; j < board[i].length; j++){
		board[i][j] = 0;
	    }
	}
    }

    public String toString(){
    }

    public void solve(){
	solve(0,0,1);
    }

    private boolean solveH(int row, int col, int level){
       	if (level > row*col){
	    return true;
	}
	if (board[row][col] != 0){
	    return false;
	}

	board[row][col] = level;

        if (canBePlaced(row+1, col+2) && solveH(row+1, col+2, level+1)){
	    return true;
	}

	if (canBePlaced(row-1, col-2) && solveH(row-1, col-2, level+1)){
	    return true;
	}

	if (canBePlaced(row+2, col+1) && solveH(row+2, col+1, level+1)){
	    return true;
	}

	if (canBePlaced(row-2, col-1) && solveH(row-2, col-1, level+1)){
	    return true;
	}

	if (canBePlaced(row+1, col-2) && solveH(row+1, col-2, level+1)){
	    return true;
	}

	if (canBePlaced(row-1, col +2) && solveH(row-1, col+2, level+1)){
	    return true;
	}

	if (canBePlaced(row+2, col-1) && solveH(row+2, col-1, level+1)){
	    return true;
	}

	if (canBePlaced(row-2, col+1) && solveH(row-2, col+1, level+1)){
	    return true;
	}

	board[row][col] = 0;
	return false;
    }


    private boolean canBePlaced(int row, int col){
	if (board[row][col] == 0){
	    return true;
	}
	return false;
    }

    public static void main(String[]args){
    }
}
