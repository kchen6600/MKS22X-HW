public class Location implements Comparable<Location>{
    private int row, col;
    private Location previous;
    private int distanceToStart;
    private int distanceToGoal;
    private boolean aStar;

    public Location(int r, int c, Location prev, int distToStart, int distToGoal){
	row = r;
	col = c;
	previous = prev;
	distanceToStart = distToStart;
	distanceToGoal = distToGoal;
	aStar = true;
    }

    public Location(int r, int c, Location prev, int distToStart, int distToGoal, boolean star){
	row = r;
	col = c;
	previous = prev;
	distanceToStart = distToStart;
	distanceToGoal = distToGoal;
	aStar = star;
    }
    /**
    public int getDistanceToStart(){
	
    }

    public int getDistanceToGoal(){
    }
    **/

    public Location getPrevious(){
	return this.previous;
    }

    public int CompareTo(Location other){
	if (aStar){
	    if((this.distanceToStart + this.distanceToGoal) < (other.distanceToStart + other.distanceToGoal)){
		return -1;
	    }
	    else if((this.distanceToStart + this.distanceToGoal) > (other.distanceToStart + other.distanceToGoal)){
		return 1;
	    }
	    else{
		return 0;
	    }
	}
	else{
	    if(this.distanceToGoal < other.distanceToGoal){
		return -1;
	    }
	    else if (this.distanceToGoal > other.distanceToGoal){
		return 1;
	    }
	    else{
		return 0;
	    }
	}
    }
}
