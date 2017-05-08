import java.util.*;
public class MyHeap{

    private String[] heaparray;
    private int size;
    private int direction; // 1 if max, -1 if min

    public MyHeap(){
	heaparray = new String[10];
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
	    
	    if (direction * heaparray[ind].compareTo(heaparray[childa]) < 0){
		swap(childa, ind);
		ind = 2 * ind;
	    }
	   
	    
	    else if (heaparray[ind].compareTo(heaparray[childb]) * direction < 0){
		swap(childb, ind);
		ind = 2 * ind + 1;
	    }
	    
	    else{
		break;
	    }
	    
	    /**
	    else{
		if(heaparray[ind].compareTo(heaparray[childb]) * direction < 0){
		    swap(childb, ind);
		    ind = 2*ind +1;
	        }
	    }
	    **/
	    
		    
	}
	    
	    
    }

    private void swap(int ind1, int ind2){
	String str = heaparray[ind1];
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

       	MyHeap b = new MyHeap(false);
	b.add("21");
	b.add("16");
	b.add("20");
	b.add("5");
	b.add("18");
	b.add("12");
	b.add("19");
	System.out.println(b);
       	String testb1 = b.peek();
       	System.out.println(test1);
	System.out.println(b.remove());
	System.out.println(b);
       	String testb = b.peek();
       	System.out.println(test);
    }
}
