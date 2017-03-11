import java.io.*;
import java.util.*;

public class USACO {
    private static int[][] lakeGrid;

    public static int bronze(String filename) {
	Scanner sc = null;
	try {
	    File f = new File(filename);
	    Scanner sc = new Scanner(f);
	}
	catch(Exception e){
	    System.out.println("File not found!");
	    System.exit(0);
	}
	    Scanner firstline = new Scanner(sc.nextLine());
	    int r = Integer.parseInt(firstline.next());
	    int c = Integer.parseInt(firstline.next());
	    int e = Integer.parseInt(firstline.next());
	    int n = Integer.parseInt(firstline.next());
	    
	    lakeGrid = new int[r][c];

	    for (int i = 0; i < r; i++){
		for (int j = 0; j < c; j++){
		    lakeGrid[i][j] = Integer.parseInt(sc.next());
		}
	    }
	    for (int ins = 0; ins < n; ins++){
		int row = Integer.parseInt(sc.next());
		int col = Integer.parseInt(sc.next());
		int depth = Integer.parseInt(sc.next());
		stomp(row, col, depth);
	    }
	    return volume(e);
    }

    private static void stomp(int row, int col, int depth ) {
	int mrow = row;
	int mcol = col;
	int m = lakeGrid[row][col];
	for(int r = row; r < row + 3; r++){
	    for(int c = col; c < col + 3; c++){
		if (lakeGrid[r][c] > m){
		    m = lakeGrid[r][c];
		    mrow = r;
		    mcol = c;
		}
	    }
	}
	lakeGrid[mrow][mcol] -= depth;
	int ans = m - depth;
	//	return ans;

    }

    private static int volume(int elev){
	int total = 0;
	for (int r = 0; r < lakeGrid.length; r++){
	    for(int c = 0; c < lakeGrid[r].length; c++){
		if (c < elev){
		    total += elev - c;
		}
	    }
	}
	return total * 72 * 72;

    
    }

    
}
