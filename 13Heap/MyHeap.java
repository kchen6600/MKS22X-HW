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
    }

    private void pushDown(){
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
}
