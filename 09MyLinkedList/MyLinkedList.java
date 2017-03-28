public class MyLinkedList{

    LNode start;
    private int size;


    public static void add(){
	
    }

    public static int size(){
	return size;
    }

    public static String toString(){
    }

    private class LNode{
	private int n;
	private int val;

	public LNode(int value, int next){
	    val = value;
	    n = next;
	}

	public int next(){
	    return n;
	}

	public int value(){
	    return val;
	}
    }
}
