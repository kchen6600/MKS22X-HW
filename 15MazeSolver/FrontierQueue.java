import java.util.*;

public class FrontierQueue implements Frontier{
    LinkedList<Location> locations = new LinkedList<Location>();

    public FrontierQueue(){
    }

    public void add (Location l){
	locations.add(l);
    }

    public Location next(){
	return locations.remove();
    }

    public Location peek(){
	return locations.peek();
    }

    public boolean hasNext(){
	return locations.size() != 0;
    }

    public int size(){
	return locations.size();
    }
}
