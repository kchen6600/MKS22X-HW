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
	Location i;
	boolean astar = false;
	int r,c;
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

	thefrontier.add(themaze.getStart());

	while (thefrontier != null){
	    System.out.println(themaze.toString(100));
	    i = thefrontier.next();
	    r = i.getRow();
	    c = i.getCol();
	    if (i.getDistanceToGoal() == 0){
		trace(i);
		return;
	    }
	    else{
		themaze.set(r, c, '@');
	    }
	}

	for (int st = 0; i < dir.length; st++){
	    int drst = Math.abs(themaze.getStart().getRow() - (r+dir[i])) + Math.abs(themaze.getStart().getCol() - c); 
	    int drend = Math.abs(themaze.getEnd().getRow() - (r+dir[i])) + Math.abs(themaze.getEnd().getCol() - c);
	    int dcst = Math.abs(themaze.getStart().getRow() - r) + Math.abs(themaze.getStart().getCol() - (c+dir[i]));
	    int dcend = Math.abs(themaze.getEnd().getRow() - (r)) + Math.abs(themaze.getEnd().getCol() - (c+dir[i]));

	    if(themaze.get(r, dir[i]+ c) != '@' && themaze.get(r, dir[i]+ c) != '.' && themaze.get(r,dir[i]+ c) != '#'){
		thefrontier.add(new Location(r, dir[i]+ c, i, dcst, dcend,astar));
		themaze.set(r,dir[i]+ c, '?');
	    }

	    if(themaze.get(r+dir[i], c) != '@' && themaze.get(r+dir[i], c) != '.' && themaze.get(r+dir[i], c) != '#'){
		thefrontier.add(new Location(r + dir[i], c, i, drst, drend,astar));
		themaze.set(r+dir[i], c, '?');
	    }
	}

        themaze.set(r, c, '.');
				
    }

    public void trace(Location l){
	Location i;
	int r;
	int c;
	r = l.getRow();
	c = l.getCol();
	maze.set(r, c,'E');
	i = l.getPrevious();
	while(i.getDistanceToStart() != 0){
	    System.out.println(themaze.toString(100));
	    r = i.getRow();
	    c = i.getCol();
	    themaze.set(r, c, '@');
	    i = i.getPrevious();
	}
	r = i.getRow();
	c = i.getCol();
	themaze.set(r,c, 'S');
	System.out.println(themaze.toString(200));
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
