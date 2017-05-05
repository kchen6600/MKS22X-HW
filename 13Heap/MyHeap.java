import java.util.*;
public class MyHeap{

    private String[] heaparray;
    private int size;
    private int direction; // 1 if max, -1 if min

    public MyHeap(){
	heaparray = new String[10];
	size = 0;
    }

    public MyHeap(boolean minmax){
	if (minmax){
	    direction = 1;
	}
	else{
	    direction = -1;
	}
    }

    public void add(String str){
	heaparray[size+1] = str;
	size += 1;
	pushUp();
    }

    public String remove(){
	if(size < 1){
	    throw new IllegalArgumentException();
	}
	String removed = heaparray[1];
	heaparray[1] = heaparray[size];
	size -= 1;
	pushDown();
	return removed;
    }

    public String peek(){
	if (size < 1){
	    throw new IllegalArgumentException();
	}
	return heaparray[1];
    }

    private void pushUp(){
	int ind = size;
	int parent = ind / 2;
	while (ind > 1 && direction * heaparray[ind].compareTo(heaparray[parent]) > 0){
		//do a swap
		swap(parent, ind);
		ind = parent;
		parent /= 2;
	    }
		
    }

    private void pushDown(){
	int ind = 1;
	int childa = 2*ind;
	int childb = 2*ind+1;
	String str = "";
	while (ind < size){
	    if (childa > size){
		break;
	    }
	    else if (direction * heaparray[ind].compareTo(heaparray[childa]) < 0){
		    swap(childa, ind);
		    ind = 2;
	    }
		else{
		    if(heaparray[ind].compareTo(heaparray[childb]) * direction < 0){
			swap(childb, ind);
			ind = 2*ind +1;
		    }
		}
		    
	}
	    
	    
    }

    private void swap(int ind1, int ind2){
	String str = heaparray[ind1];
	heaparray[ind1] = heaparray[ind2];
	heaparray[ind2] = str;
    }
	    
   
    public String toString(){
	String str = "[";
	for (int i = 1; i <= size; i++){
	    str += heaparray[i];
	    if (i < size){
		str += " ";
	    }
	}
	return str += "]";
    }

    public static void main(String[]args){
    }
}
