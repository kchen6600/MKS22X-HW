public class MazeSolver{

    private Maze themaze;
    private boolean toanimate;
    
    public MazeSolver(String filename){
	this(filename, false);
    }

    public MazeSolver(String filename, boolean animate){
	themaze = new Maze(filename);
	toanimate = animate;
    }

    public void solve(){
	solve(1);
    }

    public void solve(int style){
    }

    public String toString(){
	if (toanimate){
	    return toString(500);
	}
	else{
	    return themaze.toString();
	}
    }
}
