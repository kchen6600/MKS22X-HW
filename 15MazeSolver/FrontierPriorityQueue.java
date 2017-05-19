public class FrontierPriorityQueue implements Frontier{


    private Location[] heaparray;
    private int size;
    private int direction;
    
    public FrontierPriorityQueue(){
	hepaarray = new Location[10];
	size = 0;
	direction = -1;
    }
	
    public FrontierPriorityQueue(boolean minmax){
	if (minmax){
	    direction = -1;
	}
	else{
	    direction = 1;
	}
	heaparray = new Location[10];
	size = 0;
    }

    //minheap
    public void add(Location str){
	if (size+1 >= heaparray.length){
	    Location[] heaparray2 = new Location[heaparray.length *2];
	    for (int i = 1; i < heaparray.length; i++){
		heaparray2[i] = heaparray[i];
	    }
	    heaparray = heaparray2;
	}
	heaparray[size+1] = str;
	size+=1;
	pushUp();
    }

    private void pushUp(){
	int ind = size;
	int parent = ind / 2;
	while (ind > 1){
	    if( direction * heaparray[ind].compareTo(heaparray[parent]) > 0){
		//do a swap
		swap(parent, ind);
	       	ind = parent;
	       	parent /= 2;
	    }
	    else{
		break;
	    }
	}
    }

        private void pushDown() {
        int ind = 1;
	int childa = 2*ind;
	int childb = 2*ind+1;
	while(ind < size) {
	    //no children case
	    if(childa > size){
		break;
	    }
	    //one child case
	    else if(childb > size) {
		if(direction*heaparray[ind].compareTo(heaparray[childa]) < 0) {
		    swap(ind, childa);
		}
		break;
	    }
	    //two children cases
	    else {
		//correct placing
		if(direction*heaparray[ind].compareTo(heaparray[childa]) > 0 && direction*heaparray[ind].compareTo(heaparray[childb]) > 0) {
		    break;
		}
		else if(direction*heaparray[ind].compareTo(heaparray[childa]) < 0 && direction*heaparray[ind].compareTo(heaparray[childb]) > 0) {  
		    swap(ind, childa);
		    ind = childa;
		}
		else if(direction*heaparray[ind].compareTo(heaparray[childa]) > 0 && direction*heaparray[ind].compareTo(heaparray[childb])< 0) {    
		    swap(ind, childb);
		    ind = childb;
		}
		else {
		    if(direction*heaparray[childa].compareTo(heaparray[childb]) < 0){	     
			swap(ind, childb);
			ind = childb;
		    }
		    else{
			swap(ind, childa);
			ind = childa;
		    }
		}
		
		childa = ind * 2;
		childb = childa + 1;
	    }
	}
    }
    
    public Location remove(){
	if(size < 1){
	    throw new IllegalArgumentException();
	}
	Location removed = heaparray[1];
	heaparray[1] = heaparray[size];
	size -= 1;
	pushDown();
	return removed;
    }
    
    public Location peek(){
	if (size < 1){
	    throw new IllegalArgumentException();
	}
	return heaparray[1];
    }
    /**
    public Location next(){
    }
    **/
    

    private void swap(int ind1, int ind2){
	Location str = heaparray[ind1];
	heaparray[ind1] = heaparray[ind2];
	heaparray[ind2] = str;
	//System.out.println("swapped!");
    }

    
    
}
