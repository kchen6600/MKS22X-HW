import java.util.*;
public class MazeSolver{

    private Maze themaze;
    private boolean toanimate,astar;
    
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
	astar = false;
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
	
	
	while(thefrontier.size()>0 && !solved){
     
	    
	    i = thefrontier.next();
	    
	    if (i.getDistanceToGoal() == 0){
		//	trace(i);
		while(i.hasPrevious()){
		    i = i.getPrevious();
		    themaze.set(i.row(),i.col(),'@');
		    if (toanimate){
			System.out.println(themaze.toString(50));
		    }
		}
		themaze.set(themaze.getStart().row(), themaze.getStart().col(), 'S');
		themaze.set(themaze.getEnd().row(),themaze.getStart().row(),'E');
		if (toanimate){
		    System.out.println(themaze.toString(50));
		}
		solved = true;
	    }
	    
	    else{
		themaze.set(i.row(), i.col(), '.');
	        
	        for(Location cur : theneighbors(i)){
		    if (cur != null){
			thefrontier.add(cur);
			themaze.set(cur.row(),cur.col(), '?');
		    }
		}
	    }
	    if (toanimate){
		System.out.println(themaze.toString(50));
	    }
	}
	
    }

	
    private int dToStart(int or, int oc){
	return Math.abs(themaze.getStart().row() - or) + Math.abs(themaze.getStart().col() - oc);
    }
    private int dToGoal(int or, int oc){
	return Math.abs(themaze.getEnd().row() - or) + Math.abs(themaze.getEnd().col() - oc);
    }

    private int findRow(Location l, int n){
	return  l.row() + (n%2) * (2-n);
    }

    private int findCol(Location l, int n){
        return  l.col() + ((n+1)%2) * (n-3);
    }

    private ArrayList<Location> theneighbors(Location check){
	ArrayList<Location> thelist = new ArrayList<Location>();
	int[][] possibles = { {1,0},{-1,0},{0,1},{0,-1}};

	for(int[]possible : possibles){
	    if(themaze.get(check.row() + possible[0], check.col() + possible[1]) == ' '){
		thelist.add(new Location(check.row()+possible[0], check.col()+possible[1], check, dToStart(check.row()+possible[0], check.col()+possible[1]),dToGoal(check.row()+possible[0], check.col()+possible[1]),astar));
	    }
	}
	return thelist;
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
	t.solve(2);
	System.out.println(t);
    }
}
