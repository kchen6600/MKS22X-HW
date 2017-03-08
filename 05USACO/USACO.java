import java.io.*;
import java.util.*;

public class USACO {
    private int[][] lakeGrid;

    public static int bronze(String filename) {
	try {
	    File f = new File(filename);
	    Scanner sc = new Scanner(f);
	    int rowNum = 0;
	    int colNum = 0;

	    String line1 = "";
	    while ( sc.hasNextLine() ) {
		if ( rowNum == 0 ) {
		    line1 = sc.nextLine();
		}
		rowNum++;
	    }
	    String[] split = line1.split(" ");
	    int r = Integer.parseInt( split[0] );
	    int c = Integer.parseInt( split[1] );
	    int e = Integer.parseInt( split[2] );
	    int n = Integer.parseInt( split[3] );

	    lakeGrid = new int[r][c];

	}
	catch(FileNotFoundException e) {
	}
    }

    private static void stomp( int row, int col, int depth ) {
    }
