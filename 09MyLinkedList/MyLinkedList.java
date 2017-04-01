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
	LNode current = start;
	for (int i = 0; i < index; i++){
	    current = current.next;
	}
	return current.value;
    }

    public int set(int index, int newValue){
	LNode current = start;
	for (int i = 0; i < index; i++){
	    current = current.next;
	}
	int before = current.value;
	current.value = newValue;
	return before;
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
    }
}
