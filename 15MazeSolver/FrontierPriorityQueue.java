import java.util.*;
public class FrontierPriorityQueue implements Frontier{


    private PriorityQueue<Location> locations;
    private int size;
    
    public FrontierPriorityQueue(){
        locations = new PriorityQueue<Location>();
    }

    public void add(Location l){
	locations.add(l);
    }

    public Location next(){
	return locations.remove();
    }

    public int size(){
	return locations.size();
    }

    public String toString(){
	return locations.toString();
    }
    
}
