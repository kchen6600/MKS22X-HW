public class MyLinkedList{

    private static LNode start;
    private int size;

    public MyLinkedList(){
	start = null;
	size = 0;
    }
    
    public boolean add(int value){

	if (size == 0){
	    start = new LNode(value, null);
	}
	else{
	    LNode current = start;
	    while(current.next != null){
		current = current.next;
	    }
	    current.next = new LNode(value, null);
	}
	size+=1;
	return true;
    }

    public void add (int index, int value){
	if (index <= size && index >= 0){
	    if (size == 0){
		start = new LNode(value, null);
	    }
	    else if (index == 0){
	        LNode current = new LNode(value, start);
		start = current;
	    }
	    else if (index == size){
		add(value);
	    }
	    else{
		LNode current = start;
		int i = index;
		while (i > 1){
		    current = current.next;
		    i -= 1;
		}
		LNode nextNode = current.next;
		current.next = new LNode(value, nextNode);
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
	LNode i = start;
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
	    LNode current = start;
	    for (int i = 0; i < index; i++){
		current = current.next;
	    }
	    return current.value;
	}
	else{
	    throw new IndexOutOfBoundsException();
	}
    }

    public int set(int index, int newValue){
       	if (index < size && index >= 0){
	    LNode current = start;
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
	LNode current = start;
	for (int i = 0; i < size; i++){
	    if (current.value == value){
		return i;
	    }
	}
	return -1;
    }

    public int remove(int index){
	int before = -1;
	LNode current = start;
	if (index < size && index >= 0){
	    if (index == 0){
		before = start.value;
		start = start.next;
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
	public LNode next;
	public int value;
	
	public LNode(){
	    value = 0;
	    next = null;
	}
	
	public LNode(int val, LNode n){
	    value = val;
	    next = n;
	}

    }

    public static void main(String[] args){
	MyLinkedList l = new MyLinkedList();
	System.out.println(l);
	l.add(3);
	System.out.println(l);
	l.add(5);
	System.out.println(l.get(1));
	l.set(1, 2);
	System.out.println(l.get(1));

	System.out.println(l.indexOf(2));
	System.out.println(l.indexOf(3));
        l.add(0,0);
	l.add(1,0);
	l.add(2,0);
	System.out.println(l);
	l.add(5, 0);
	System.out.println(l);
	System.out.println(l.remove(5));
	System.out.println(l);
	System.out.println(l.remove(0));
	System.out.println(l.remove(1));
	System.out.println(l);
	
    }
}
