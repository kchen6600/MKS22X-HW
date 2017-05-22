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
	int[] ds = {-1,1};
	
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


	while(thefrontier.hasNext()){
	    i = thefrontier.next();

	    if(dToGoal(i) == 0){
		while(i.hasPrevious()){
		    themaze.set(i.row(), i.col(), '@');
		    i = i.getPrevious();
		}
		themaze.set(themaze.getStart().row(), themaze.getStart().col(), '@');
		themaze.set(themaze.getEnd().row(), themaze.getEnd().col(), '@');
		break;
	    }

	    themaze.set(i.row(), i.col(), '.');
	    for(int st =1; st <=4;st++){
		r = findRow(i, st);
		c = findCol(i, st);
		if (r < themaze.getMaxRows() && r > 0 && c > 0 && c < themaze.getMaxCols() && themaze.get(r, c) == ' '){
		    thefrontier.add(new Location(r, c,i, dToStart(i), dToGoal(i), astar));
		    themaze.set(r, c, '?');
		}
	    }
	}
	
    }

	private int dToStart(Location l){
	    return Math.abs(themaze.getStart().row() - l.row()) + Math.abs(themaze.getStart().col() - l.col());
	}

	private int dToGoal(Location l){
	    return Math.abs(themaze.getEnd().row() - l.row()) + Math.abs(themaze.getEnd().col() - l.col());
	}

	private int findRow(Location l, int n){
	    if (n == 0){
		return l.row()+1;
	    }
	    else if (n==1){
		return l.row() -1;
	    }
	    else{
		return l.row();
	    }
	}

	private int findCol(Location l, int n){
	    if (n == 3){
		return l.col() + 1;
	    }
	    else if(n == 4){
		return l.col() - 1;
	    }
	    else{
		return l.col();
	    }
	}

    public String toString(){
	if (toanimate){
	    return themaze.toString(20);
	}
	else{
	    return themaze.toString();
	}
    }

    public static void main(String[] args){
	MazeSolver t = new MazeSolver("data2.txt");
	t.solve(1);
	System.out.println(t);
    }
}
