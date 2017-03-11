import java.io.*;
import java.util.*;

public class USACO {
    private int[][] lakeGrid;
    private int r;
    private int c;
    private int e;
    private int n;

    public int bronze(String filename) {

	Scanner sc = null;
	try {
	    File f = new File(filename);
	    sc = new Scanner(f);
	}
	catch(Exception e){
	    System.out.println("File not found!");
	    System.exit(0);
	}

	    Scanner firstline = new Scanner(sc.nextLine());
	    r = Integer.parseInt(firstline.next());
	    c = Integer.parseInt(firstline.next());
	    e = Integer.parseInt(firstline.next());
	    n = Integer.parseInt(firstline.next());
	    
	    lakeGrid = new int[r][c];
	
	    for (int i = 0; i < r; i++){
		Scanner next = new Scanner(sc.nextLine());
		for (int j = 0; j < c; j++){
		    lakeGrid[i][j] = next.nextInt();
		}
	    }

	    while (sc.hasNextLine()){
		Scanner ins = new Scanner(sc.nextLine());
		int row = ins.nextInt() -1;
		int col = ins.nextInt() -1;
		int depth = ins.nextInt();
	        int height = stomp(row, col, depth);
		
		for (int i = row; i < row+3; i++){
		    for(int j = col; j < col+3; j++){
			if (lakeGrid[i][j] > height){
			    lakeGrid[i][j] = height;
			}
		    }
		}
	    }
	    return volume(e);
    }

    private int stomp(int row, int col, int depth ) {
	int mrow = row;
	int mcol = col;
	int m = lakeGrid[row][col];
	for(int i = row; i < row + 3; i++){
	    for(int j = col; j < col + 3; j++){
		if (lakeGrid[i][j] > m){
		    m = lakeGrid[i][j];
		    mrow = i;
		    mcol = j;
		}
	    }
	}
	lakeGrid[mrow][mcol] -= depth;
        int ans = m - depth;
       	return ans;

    }

    private int volume(int elev){
	int total = 0;

	for(int i = 0; i < r; i++){
	    for(int j = 0; j <c; j++){
		if(lakeGrid[i][j] < e){
		    total += e - lakeGrid[i][j];
		}
	    }
	}
	return total * 72 * 72;

    
    }

  
    
}
