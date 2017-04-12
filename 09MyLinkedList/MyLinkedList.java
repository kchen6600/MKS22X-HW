import java.util.*;
import java.io.*;
public class MyLinkedList implements Iterable<Integer>{

    public Iterator<Integer> iterator(){
	return new MyLinkedListIterator(this);
    }

    public class MyLinkedListIterator implements Iterator<Integer>{
	MyLinkedList l;
	LNode current;
	public MyLinkedListIterator(MyLinkedList llist){
	    l = llist;
	    current = llist.head;
	}

	public boolean hasNext(){
	    return !(current == null);
	}

	public Integer next(){
	    if(hasNext()){
		int i = current.value;
		current = current.next;
		return i;
	    }
	    else{
		throw new NoSuchElementException();
	    }
	}

	public void remove(){
	    throw new UnsupportedOperationException();
	}
    }

    private static LNode head;
    private static LNode tail;
    private int size;

    public MyLinkedList(){
	head = null;
	size = 0;
	tail = null;
    }
    
    public void add(int value){

	add(size, value);
    }

    public void add (int index, int value){
	if (index <= size && index >= 0){
	    if (size == 0){
		head = new LNode(value);
		tail = head;
	    }
	    else if (index == 0){
	        LNode current = new LNode(value, null, head);
		head.prev = current;
		head = head.prev;
	    }
	    else if (index == size){
		LNode current = new LNode(value, tail, null);
		tail.next = current;
		tail = tail.next;
	    }
	    else{

		LNode prevNode = getNthNode(index - 1);
		LNode nextNode = prevNode.next;

		prevNode.next = new LNode(value, prevNode, nextNode);
		nextNode.prev = prevNode.next;
	    }
	    size += 1;
	}
	
        else{
	    throw new IndexOutOfBoundsException();
	}
    }

    public void addAfter(LNode location, LNode TBA){
	if (location.next != null){
	    TBA.next = location.next;
	    TBA.prev = location;
	    location.next = TBA.next;
	}
	else{
	    TBA.next = null;
	    TBA.prev = location;
	    location.next = TBA;
	    tail = TBA;
	}
	size +=1;
    }
	

    public int size(){
	return size;
    }

    public String toString(){
	LNode i = head;
	if(i == null){
	    return "[]";
	}
	String str = "[";
	while(i != null){
	    str += i.value;
	    if(i.next == null){
		str += "]";
	    }
	    else{
		str += ", ";
	    }
	    i = i.next;
	}
	return str;
    }

    public String toStringDebug(){
	LNode i = head;
	if(i == null){
	    return "[]";
	}
	
	String str = "[ (null) " + i.value + " (" + i.next.value + "), ";
	i = i.next;
	while(i.next != null){
	    str += "(" + i.prev.value+") "+i.value +" (" + i.next.value + "), ";
	    i= i.next;
	}
	return str + "(" + i.prev.value + "(null)";
    }


    public int get(int index){
	if (index < size && index >= 0){
	    return getNthNode(index).value;
	}
	else{
	    throw new IndexOutOfBoundsException();
	}
    }

    public LNode getNthNode(int index){
	LNode current = head;
	LNode n = null;
	int i = 0;
	while(i < size()){
	    if (i == index){
		n = current;
		i = size() + 1;
	    }
	    else{
	        current = current.next;
	    }
	    i++;
	}
	return n;
	
    }
    
    public int set(int index, int value){
	if (index < size && index >= 0){
	    LNode old = getNthNode(index);
	    int n = old.value;
	    old.value = value;
	    return n;
	}
	else{
	    throw new IndexOutOfBoundsException();
	}
    }

    public int indexOf(int value){
	LNode current = head;
	for (int i = 0; i < size; i++){
	    if (current.value == value){
		return i;
	    }
	}
	return -1;
    }

    public void remove(LNode x){
	LNode before = x.prev;
	LNode current = x;
	LNode after = x.next;

	before.next = after;
	after.prev = before;
    }


    
    public int remove(int index){
       	if (index < size && index >= 0){
	    LNode current = getNthNode(index);
	    LNode prevNode = current.prev;
	    LNode nextNode = current.next;
	    if(index > 0){
		prevNode.next = nextNode;
	    }
	    else{
		head = nextNode;
	    }
	    if (index < size - 1){
		nextNode.prev = prevNode;
	    }
	    else{
		tail = prevNode;
	    }
	    size -=1;
	    return current.value;
	}
	else{
	    throw new IndexOutOfBoundsException();
	}
		
    }
	    
        

    private class LNode{
	public LNode prev;
	public LNode next;
	public int value;
	
	public LNode(){
	    prev = null;
	    value = 0;
	    next = null;
	}
	
	public LNode(int val, LNode p, LNode n){
	    prev = p;
	    value = val;
	    next = n;
	}

	public LNode(int val){
	    prev = null;
	    value = val;
	    next = null;
	}

	public String toString(){
	    return value + "";
	}

    }

    public static void main(String[] args){
	MyLinkedList l = new MyLinkedList();
	System.out.println(l);
	l.add(3);
	System.out.println(l);
	l.add(5);
	//System.out.println(l.get(1));
	//	l.set(1, 2);
	System.out.println(l.get(1));
	System.out.println(l);
	//	System.out.println(l.indexOf(2));
	//	System.out.println(l.indexOf(3));
	
        l.add(0,0);
	System.out.println(l);
	
	l.add(1,0);
	l.add(2,0);
	System.out.println(l);
	l.add(5, 0);
	System.out.println(l);
	/**
	System.out.println(l.remove(5));
	System.out.println(l);
	System.out.println(l.remove(0));
	System.out.println(l.remove(1));
	System.out.println(l);
	**/
	System.out.println(l.get(1));
	System.out.println(l.set(1, 2));
	System.out.println(l.remove(5));
	System.out.println(l);
	
    }
}
