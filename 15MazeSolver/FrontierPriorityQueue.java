import java.util.*;
public class FrontierPriorityQueue implements Frontier{


    private MyHeap locations;
    private int size;
    
    public FrontierPriorityQueue(){
        locations = new MyHeap(false);
    }

    public void add(Location l){
	size+=1;
	locations.add(l);
    }

    public Location next(){
	size-=1;
	return locations.remove();
    }

    public int size(){
	return locations.size();
    }

    public String toString(){
	return locations.toString();
    }

    public boolean hasNext(){
	return locations.size() != 0;
    }
    
}
