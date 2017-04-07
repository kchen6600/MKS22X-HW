public class MyLinkedList{

    private static LNode head;
    private static LNode tail;
    private int size;

    public MyLinkedList(){
	head = null;
	size = 0;
	tail = null;
    }
    
    /** to be written

    public void addAfter(LNode location, LNode TBA){

	
    }

    public void add(int index, int value){
    }

    public void add(int value){
    add(size, value);
}

public int get(int index){
return getNthNode(index).value;
}

public int set(int index, int value){
LNode target = getNthNode(index);
int ans = target.value;
target.value = value;
return ans;
}

    public String toStringDebug(){
    }

    **/
    
    public boolean add(int value){

	if (size == 0){
	    head = new LNode(value);
	}
	else{
	    LNode current = head;
	    while(current.next != null){
		current = current.next;
	    }
	    current.next = new LNode(value);
	}
	size+=1;
	return true;
    }

    public void add (int index, int value){
	if (index <= size && index >= 0){
	    if (size == 0){
		head = new LNode(value);
	    }
	    else if (index == 0){
	        LNode current = new LNode(value, null, head);
		head = current;
	    }
	    else if (index == size){
		add(value);
	    }
	    else{
		LNode current = head;
		int i = index;
		while (i > 1){
		    current = current.next;
		    i -= 1;
		}
		LNode prevNode = current.prev;
		LNode nextNode = current.next;
		current.next = new LNode(value, prevNode, nextNode);
		prevNode.next = current;
		nextNode.prev = current;
	    }
	    size += 1;
	}
	
        else{
	    throw new IndexOutOfBoundsException();
	}
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

    public int get(int index){
       	if (index < size && index >= 0){
	    LNode current = head;
	    for (int i = 0; i < index; i++){
		current = current.next;
	    }
	    return current.value;
	}
	else{
	    throw new IndexOutOfBoundsException();
	}
    }

    public LNode getNthNode(int index){
	if (index < size && index >= 0){
	    LNode current = head;
	    for (int i = 0; i < index; i++){
		current = current.next;
	    }
	    return current;
	}
	else{
	    throw new IndexOutOfBoundsException();
	}
	
    }

    public int set(int index, int newValue){
       	if (index < size && index >= 0){
	    LNode current = head;
	    for (int i = 0; i < index; i++){
		current = current.next;
	    }
	    int before = current.value;
	    current.value = newValue;
	    return before;
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
	int before = -1;
	LNode current = head;
	if (index < size && index >= 0){
	    if (index == 0){
		before = head.value;
		head = head.next;
	    }
	    else if(index == size){
		for(int i = 0; i < index - 2; i++){
		    current = current.next;
		}
		before = current.next.value;
		current.next = null;
	    }
	    else{
		for (int i = 0; i < index - 1; i++){
		    current = current.next;
		}
		before = current.next.value;
		current.next = current.next.next;
	    }
	    size -= 1;
	    return before;
	}
	else{
	    throw new IndexOutOfBoundsException();
	}
		
    }
	    
        

    class LNode{
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
	/**
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
	System.out.println(l.getNthNode(1));
	
    }
}
