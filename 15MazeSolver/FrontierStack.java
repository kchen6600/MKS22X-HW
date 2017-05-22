import java.util.*;
public class FrontierStack implements Frontier{
    Stack<Location> locations = new Stack<Location>();

    public FrontierStack(){
    }

    public void add (Location l){
	locations.push(l);
    }

    public Location next(){
	return locations.pop();
    }

    public Location peek(){
	return locations.peek();
    }

}
