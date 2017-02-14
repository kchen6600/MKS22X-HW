public class QueenBoard{

    private int[][]board;
    private int solutionCount;

    public QueenBoard(int size){
	board = new int[size][size];
	for (int i = 0; i < size; i++){
	    for (int j = i; j < size; j++){
		board[i][j] = 0;
	    }
	}
	solutionCount = -1;
    }

    private void addQueen(int r,int c){
	int size = board.length;

	for (int j = c+1; j < size; j++){
	    board[r][j] +=1;
	}
	for(int j2 = c-1; j2 > -1; j2--){
	    if(board[j2][c] != -1){
		board[j2][c] +=1;
	    }
	}
	for (int i = r+1; i < size; i++){
	    board[i][c] += 1;
	}
	for (int i2 = r-1; i2 > -1; i2--){
	    if(board[i2][c] != -1){
		board[i2][c] +=1;
	    }
	}
	for (int k =1; r+k < size && k+c < size; k++){
	    board[r+k][k+c] +=1;
	}
	for(int m =1; r-m > -1 && c-m >-1; m++){
	    if(board[r-m][c-m] != -1){
		board[r-m][c-m] +=1;
	    }
	}
	for(int n =1; r+n < size && c-n > -1; n++){
	    board[r+n][c-n] +=1;
	}
	for (int o=1; r-o > -1 && o+c < size; o++){
	    if(board[r-o][o+c] != -1){
		board[r-o][o+c] +=1;
	    }
	}

       	board[r][c] = -1;
    }

    private void removeQueen(int r,int c){
	int size = board.length;



	for (int j = c+1; j < size; j++){
	    board[r][j] -=1;
	}
	for(int j2 = c-1; j2 > -1; j2--){
	    if(board[j2][c] != -1){
		board[j2][c] -=1;
	    }
	}
	for (int i = r+1; i < size; i++){
	    board[i][c] -= 1;
	}
	for (int i2 = r-1; i2 > -1; i2--){
	    if(board[i2][c] != -1){
		board[i2][c] -=1;
	    }
	}
	for (int k =1; r+k < size && k+c < size; k++){
	    board[r+k][k+c] -=1;
	}
	for(int m =1; r-m > -1 && c-m >-1; m++){
	    if(board[r-m][c-m] != -1){
		board[r-m][c-m] -=1;
	    }
	}
	for(int n =1; r+n < size && c-n > -1; n++){
	    board[r+n][c-n]-=1;
	}
	for (int o=1; r-o > -1 && o+c < size; o++){
	    if(board[r-o][o+c] != -1){
		board[r-o][o+c] -=1;
	    }
	}
	board[r][c] = 0;
    }
    
    public void solve(){
	solveH(0);
    }

    private boolean solveH(int col){

	int size = board.length;

	if (col >= size){
	    return true;
	}

	for(int row = 0; row < size; row++){
	    if(board[row][col] == 0){
		addQueen(row, col);
		if (solveH(col+1)){
		    return true;
	        }
		else{
		    removeQueen(row,col);
		}
	    }
	}
	return false;
	
	
    }
    
    public void countSolutions(){
	solutionCount = 0;
	countH(0);	
    }

    public void countH(int col){
        int size = board.length;
	if (col >= size){
	    solutionCount += 1;
	    return;
	}

	for (int row = 0; row < size; row++){
	    if (board[row][col] == 0){
		addQueen(row, col);
		countH(col+1);
		removeQueen(row, col);
	    }
	}
    }
	

    public int getSolutionCount(){
	return solutionCount;
    }
    
    public String toString(){
	int size = board.length;
	String str = "";
	for (int i = 0; i < size; i++){
	    for (int j = 0; j < size; j++){
		if (board[i][j] == -1){
		    str += "Q";
	        }
	        else{
		    str += "_ ";
		}
  
	    }
	    str += "\n";
	}
	return str;
    }
    

    public static void main (String[]args){
	QueenBoard b = new QueenBoard(10);
	System.out.println(b);
       	b.countSolutions();
       	//b.solve();
	//	System.out.println(b);
	System.out.println(b.getSolutionCount());
    }


}
