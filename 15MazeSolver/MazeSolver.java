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

	for (int st = 0; st < ds.length; st++){
	    int drst = Math.abs(themaze.getStart().getRow() - (r+ds[st])) + Math.abs(themaze.getStart().getCol() - c); 
	    int drend = Math.abs(themaze.getEnd().getRow() - (r+ds[st])) + Math.abs(themaze.getEnd().getCol() - c);
	    int dcst = Math.abs(themaze.getStart().getRow() - r) + Math.abs(themaze.getStart().getCol() - (c+ds[st]));
	    int dcend = Math.abs(themaze.getEnd().getRow() - (r)) + Math.abs(themaze.getEnd().getCol() - (c+ds[st]));

	    if(themaze.get(r, ds[st]+ c) != '@' && themaze.get(r, ds[st]+ c) != '.' && themaze.get(r,ds[st]+ c) != '#'){
		thefrontier.add(new Location(r, ds[st]+ c, i, dcst, dcend,astar));
		themaze.set(r,ds[st]+ c, '?');
	    }

	    if(themaze.get(r+ds[st], c) != '@' && themaze.get(r+ds[st], c) != '.' && themaze.get(r+ds[st], c) != '#'){
		thefrontier.add(new Location(r + ds[st], c, i, drst, drend,astar));
		themaze.set(r+ds[st], c, '?');
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
	themaze.set(r, c,'E');
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
	    return themaze.toString();
	}
	else{
	    return themaze.toString();
	}
    }

}
