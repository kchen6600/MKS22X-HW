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

	Frontier thefrontier = null;
	Location last = null;
	Location i = null;
	boolean astar = false;
	int r =0;
	int c = 0;
        boolean solved = false;
	
	//depthfirst
	if (style == 0){
	    thefrontier = new FrontierStack();
	}
	//breadthfirst
	if (style == 1){
	    thefrontier = new FrontierQueue();
	}
	//bestfirst
	if (style == 2){
	    thefrontier = new FrontierPriorityQueue();
	}
	//astar
	if (style == 3){
	    thefrontier = new FrontierPriorityQueue();
	    astar = true;
	}


	thefrontier.add(themaze.getStart());
	
	while(thefrontier.hasNext() && !solved){
	    if (toanimate){
		System.out.println(themaze.toString(50));
	    }
	    
	    i = thefrontier.next();

	    if (i.getDistanceToGoal() == 0){
		trace(i);
		solved = true;
	        
	    }
	    else{
		themaze.set(i.row(), i.col(), '.');
	        
		for(int st =1; st <=4;st++){
		    r = findRow(i, st);
		    c = findCol(i, st);
		    if (themaze.get(r, c) == ' '){
			thefrontier.add(new Location(r, c,i, dToStart(i), dToGoal(i), astar));
			themaze.set(r, c, '?');
		    }
		}
	    }
	}
	
    }

    public void trace(Location l){
	/**
	Location loc;
	int locrow = l.row();
	int loccol = l.col();
	themaze.set(locrow, loccol, 'E');
	**/
	while (l != null){
	    themaze.set(l.row(), l.col(), '@');
	    if (toanimate){
		System.out.println(themaze.toString(100));
	    }
	    l = l.getPrevious();
	}
	//	themaze.set(l.row(), l.col(), 'S');
	//	System.out.println(themaze.toString(200));
	
    }
	
	private int dToStart(Location l){
	    return Math.abs(themaze.getStart().row() - l.row()) + Math.abs(themaze.getStart().col() - l.col());
	}

	private int dToGoal(Location l){
	    return Math.abs(themaze.getEnd().row() - l.row()) + Math.abs(themaze.getEnd().col() - l.col());
	}

    private int findRow(Location l, int n){
	return  l.row() + (n%2) * (2-n);
    }

    private int findCol(Location l, int n){
        return  l.col() + ((n+1)%2) * (n-3);
    }

    public String toString(){
	if (toanimate){
	    return themaze.toString(200);
	}
	else{
	    return themaze.toString();
	}
    }

    public static void main(String[] args){
	MazeSolver t = new MazeSolver("data2.txt",true);
	t.solve(3);
	System.out.println(t);
    }
}
