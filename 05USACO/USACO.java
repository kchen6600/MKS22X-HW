import java.io.*;
import java.util.*;

public class USACO {
    private int[][] lakeGrid;
    private int r;
    private int c;
    private int e;
    private int n;

    public USACO(){
    }

    public static String name(){
	return "Chen,Karen";
    }

    /**
       partner: Evan Chen
    **/

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

    private int numr, numc, t, startr, startc, endr, endc;
    private int[][]pastureGrid;
    private int[][]pastureGrid2;
    public int silver(String filename){

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
        numr = Integer.parseInt(firstline.next());
	numc = Integer.parseInt(firstline.next());
        t = Integer.parseInt(firstline.next());

	pastureGrid = new int[numr][numc];
	pastureGrid2 = new int[numr][numc];

	for(int i = 0; i < numr; i++){
	    String next = sc.next();
	    for(int j = 0; j < numc; j++){
		if(next.charAt(j) == '*'){
		    pastureGrid[i][j] = -1;
		    pastureGrid2[i][j] = -1;
		}
	        else{
		    pastureGrid[i][j] = 0;
		    pastureGrid2 = 0;
		}
	    }
	}

	startr = sc.nextInt()-1;
	startc = sc.nextInt()-1;
	endr = sc.nextInt()-1;
	endc = sc.nextInt()-1;

	return -1;
    }

    private int solvewalks(){
	pastureGrid[startr][startc] = 1;
	for(int i = 0; i < t; i++){
	    for (int j = 0; j < numr; j++){
		for(int k = 0; k < numc; k++){
		    int total = 0;
		    if(pastureGrid[j][k+1]!= -1 && k+1 < numc){
			total += pastureGrid[j][k+1];
		    }
		    if(pastureGrid[j][k-1]!= -1 && k-1 >= 0){
			total += pastureGrid[j][k-1];
		    }
		    if(pastureGrid[j+1][k]!= -1 && j+1 < numr){
			total += pastureGrid[j+1][k];
		    }
		    if(pastureGrid[j-1][k]!= -1 && j-1 >= 0){
			total += pastureGrid[j-1][k];
		    }
		    if(pastureGrid[j][k]!=-1){
			pastureGrid2[j][k] = total;
		    }
		}
	    }
	}
	
		
    }

}
