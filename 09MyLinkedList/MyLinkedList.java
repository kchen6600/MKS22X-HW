public class MyLinkedList{

    LNode start;
    private int size = 0;


    public static void add(int value){
	LNode i = start;
	while(i.next() != null){
	    i = i.next();
	}
	i = new LNode(value, null);
	
    }

    public static int size(){
	return size;
    }

    public static String toString(){
    }

    private class LNode{
	private LNode next;
	private int value;

	public LNode(){
	    value = 0;
	    next = null;
	}
	
	public LNode(int val, int n){
	    value = val;
	    next = n;
	}

	public LNode next(){
	    return next;
	}

    }
}
