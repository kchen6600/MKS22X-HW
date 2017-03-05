import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Maze{

    private char[][]maze;
    private boolean animate;
    private int srow;
    private int scol;
    private boolean sfound = false;
    private boolean efound = false;

    /*Constructor loads a maze text file, and sets animate to false by default.
      1. The file contains a rectangular ascii maze, made with the following 4 characters:
      '#' - locations that cannot be moved onto
      ' ' - locations that can be moved onto
      'E' - the location of the goal (exactly 1 per file)
      'S' - the location of the start(exactly 1 per file)

      2. The maze has a border of '#' around the edges. So you don't have to check for out of bounds!
      3. When the file is not found OR there is no E or S then: print an error and exit the program.
    */
    public Maze(String filename){
	animate = false;
	try{
	    File f = new File(filename);
	    Scanner scan = new Scanner(f);
	    int linerow = 0;
	    int linecol = 0;
	    while (scan.hasNextLine()){
		linerow++;
		linecol = scan.nextLine().length();
	    }
	    
	    maze = new char[linerow][linecol];
	    
	    Scanner scan2 = new Scanner(f);
	    int row = 0;
	    while(scan2.hasNextLine()){
		String rowchar = scan2.nextLine();
		
		for(int c = 0; c < rowchar.length(); c++){
		    if(rowchar.charAt(c) == 'S'){
			srow = row;
			scol = c;
			sfound = true;
		    }
		    if(rowchar.charAt(c) == 'E'){
			efound = true;
		    }
		    maze[row][c] = rowchar.charAt(c);
		}
		row+=1;
	    }
	    
	    if (sfound == false || efound == false){
	        System.out.println("Missing S or E");
		System.exit(0);
	    }
	}
	catch(Exception e){
	    System.out.println("Invalid file");
	    System.exit(0);
	}
    }

    private void wait(int millis){ 
	try {
            Thread.sleep(millis);
         }
         catch (InterruptedException e) {
         }
     }
    
    public void setAnimate(boolean b){
        animate = b;
    }

    public void clearTerminal(){
        //erase terminal, go to top left of screen.
        System.out.println("\033[2J\033[1;1H");
    }


    /*Wrapper Solve Function
      Since the constructor exits when the file is not found or is missing an E or S, we can assume it exists.
    */
    public boolean solve(){
        
        //Initialize starting row and startint col with the location of the S.
        
        maze[srow][scol] = ' ';//erase the S, and start solving!
        return solve(srow,scol);
    }

    

    /*
      Recursive Solve function:

      A solved maze has a path marked with '@' from S to E.

      Returns true when the maze is solved,
      Returns false when the maze has no solution.

      Postcondition:
        The S is replaced with '@' but the 'E' is not.
        All visited spots that were not part of the solution are changed to '.'
        All visited spots that are part of the solution are changed to '@'
    */
    private boolean solve(int row, int col){
        if(animate){
            System.out.println("\033[2J\033[1;1H"+this);
            wait(20);
        }

	
	if(maze[row][col] == 'E'){
	    return true;
	}
       
	if(maze[row][col] == ' '){
	    maze[row][col] = '@';
	    if (solve(row+1, col)){
		return true;
	    }
	    if (solve(row, col-1)){
		return true;
	    }
	    if (solve(row-1, col)){
		return true;
	    }
	    if (solve (row, col+1)){
		return true;
	    }
	    maze[row][col] = '.';
	}
        
	
        //COMPLETE SOLVE
        return false; //so it compiles
    }

    public String toString(){
	String str = "";
	for (int r= 0; r < maze.length; r++){
	    for (int c=0; c < maze[r].length; c++){
		str += maze[r][c];
	    }
	    str += "\n";
	}
	return str;
    }

}
