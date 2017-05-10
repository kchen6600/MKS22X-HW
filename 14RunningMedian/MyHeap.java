import java.util.*;
public class MyHeap{
    private Integer[] heaparray;
    private int size;
    private int direction; // 1 if max, -1 if min

    public MyHeap(){
	heaparray = new Integer[10];
	size = 0;
	direction = 1;
    }

    public MyHeap(boolean minmax){
	if (minmax){
	    direction = 1;
	}
	else{
	    direction = -1;
	}
	heaparray = new Integer[10];
	size = 0;
    }

    public Integer size(){
	return size;
    }
    
    public void add(Integer str){
	//resize the array
	if (size+1 >= heaparray.length){
	    Integer[] heaparray2 = new Integer[heaparray.length *2];
	    for (int i = 1; i < heaparray.length; i++){
		heaparray2[i] = heaparray[i];
	    }
	    heaparray = heaparray2;
	}
	heaparray[size+1] = str;
	size += 1;
	pushUp();
    }


    public Integer remove(){
	if(size < 1){
	    throw new IllegalArgumentException();
	}
	Integer removed = heaparray[1];
	heaparray[1] = heaparray[size];
	size -= 1;
	pushDown();
	return removed;
    }

    public Integer peek(){
	if (size < 1){
	    throw new IllegalArgumentException();
	}
	return heaparray[1];
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
    
    private void swap(int ind1, int ind2){
	Integer str = heaparray[ind1];
	heaparray[ind1] = heaparray[ind2];
	heaparray[ind2] = str;
	//System.out.println("swapped!");
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
	/**
	MyHeap a = new MyHeap();
	a.add("5");
	a.add("4");
	a.add("3");
	a.add("2");
	a.add("1");
	System.out.println(a);
       	String test1 = a.peek();
       	System.out.println(test1);
	System.out.println(a.remove());
	System.out.println(a);
       	String test = a.peek();
       	System.out.println(test);
	**/
       	MyHeap b = new MyHeap(true);
	b.add(21);
	b.add(16);
	b.add(20);
	b.add(5);
	b.add(18);
	b.add(12);
	b.add(19);
	System.out.println(b);
       	Integer testb1 = b.peek();
       	System.out.println(testb1);
	System.out.println(b.remove());
	System.out.println(b);
       	Integer testb = b.peek();
       	System.out.println(testb);
    }
}
