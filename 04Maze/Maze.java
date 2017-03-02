import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Maze{

    private char[][]maze;
    private boolean animate;
    private int srow;
    private int scol;

    /*Constructor loads a maze text file, and sets animate to false by default.
      1. The file contains a rectangular ascii maze, made with the following 4 characters:
      '#' - locations that cannot be moved onto
      ' ' - locations that can be moved onto
      'E' - the location of the goal (exactly 1 per file)
      'S' - the location of the start(exactly 1 per file)

      2. The maze has a border of '#' around the edges. So you don't have to check for out of bounds!
      3. When the file is not found OR there is no E or S then: print an error and exit the program.
    */
    public Maze(String filename) throws FileNotFoundException{
	animate = false;
	try{
	    File textfile = new File(filename);
	    Scanner scan = new Scanner(textfile);
	    int lineNumber = 1;
	    boolean efound = false;
	    boolean sfound = false;
	    while (scan.hasNextLine()){
		lineNumber++;
		String line = scan.nextLine();
		for (int r = 0; r < lineNumber; r++){
		    for (int c = 0; c < line.length(); c++){
			maze[r][c] = line.charAt(c);
			if (line.charAt(c) == 'E'){
			    efound = true;
			}
			if (line.charAt(c) == 'S'){
			    sfound = true;
			    srow = r;
			    scol = c;
			}
		    }
		}
	    }
	    if(!(efound && sfound)){
		System.out.println("Missing E or S");
		System.exit(0);
	    }
	}
	catch(FileNotFoundException e){
	    System.out.println("Invalid file!");
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
            int startr=srow,startc=scol;
            //Initialize starting row and startint col with the location of the S. 
            maze[startr][startc] = ' ';//erase the S, and start solving!
            return solve(startr,startc);
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

	maze[row][col] = '@';
	
	if(maze[row][col] == 'E'){
	    return true;
	}
       
	if(maze[row][col+1] == ' '){
	    solve(row, col+1);
	}

	if(maze[row+1][col] == ' '){
	    solve(row+1, col);
	}

	if(maze[row][col-1] == ' '){
	    solve(row, col-1);
	}

	if(maze[row-1][col] == ' '){
	    solve(row-1, col);
	}

	else{
	    maze[row][col] = '.';
	}


	
        //COMPLETE SOLVE
        return false; //so it compiles
    }

}
