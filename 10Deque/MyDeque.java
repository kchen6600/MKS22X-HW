import java.util.*;
public class MyDeque{

    private String[] dequeary;
    private int front, back, size;
    public MyDeque(){
	dequeary = new String[10];
	//	front = 0;
	//	back = 0;
	size = 0;
    }

    private void resize(){
	String[] bigger;
	bigger = new String[dequeary.length *2];
	int i = 0;
	for (int j = front; j < size+front; j++){
	    int ind = j % dequeary.length;
	    bigger[i] = dequeary[ind];
	    i+=1;
	}
	dequeary = bigger;
	front = 0;
	back = size -1;
    }
    //add the element to the specified side
    //double capacity when full
    public void addFirst (String str){
	if (str == null){
	    throw new NullPointerException("Cannot add null elements");
	}
	if (size == dequeary.length){
	    resize();
	}
	
	if (size != 0){
	    if(front == 0){
		dequeary[dequeary.length - 1]= str;
		front = dequeary.length - 1;
	    }
	    else{
		dequeary[front-1] = str;
		front -=1;
	    }
	}
	if (size == 0){
	    dequeary[0] = str;
	}
	
	//	dequeary[front] = str;
	size += 1;
	
    }

    public void addLast (String str){
	if (str == null){
	    throw new NullPointerException("Cannot add null elements");
	}
	if (size == dequeary.length){
	    resize();
	}
	if (size!= 0){
	    back = (back+1) % (dequeary.length);
	}
	dequeary[back] = str;
	size +=1;
    }


    //retrieve and remove the element from the specified side
    public String removeFirst(){

	if (size!= 0){
	     String removed = dequeary[front];
	    front = (front + 1) % (dequeary.length);
	    size -=1;
	    return removed;
	}
	else{
	    throw new NoSuchElementException("no elements");
	}
    }

    public String removeLast(){
	if (size!= 0){
	    String removed = dequeary[back];
	    
	    if(back!= 0){
		back -=1;
	    }
	    else{
		back = dequeary.length-1;
	    }
		
	    size -=1;
	    return removed;
	}
	else{
	    throw new NoSuchElementException("no elements");
	}
    }

    //retrieve element from the specified side
    public String getFirst(){
	if (size!= 0){
	    return dequeary[front];
	}
	else{
	    throw new NoSuchElementException("no elements");
	}
    }

    public String getLast(){
	if (size!=0){
	    return dequeary[back];
	}
	else{
	    throw new NoSuchElementException("no elements");
	}
    }

    
    public String toString(){
	if (size == 0){
	    return "[]";
	}
	String str = "[";
	for(int i = front; i < size+front; i++){
		str += dequeary[i % dequeary.length]+",";
	    
	}
    
	return str.substring(0, str.length() - 1) + "]";
    }

    public static void main(String[] args){
	MyDeque md = new MyDeque();
	//System.out.println(md.getFirst());
	md.addFirst("hi");
	System.out.println(md);
	md.addLast("bye");
       	System.out.println(md);
	//	md.addFirst("yo");
	//	System.out.println(md.getFirst());
	//	System.out.println(md.getLast());
	//	System.out.println(md.removeLast());
	//	System.out.println(md);
	System.out.println("RemoveFirst, removing hi, arry should = [bye]");
	System.out.println(md.removeFirst());
	System.out.println(md);
    }
    
}
