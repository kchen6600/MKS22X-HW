public class MyDeque{

    private String[] dequeary;
    private int front, back, size;
    public MyDeque(){
	dequeary = new String[10];
	front = 0;
	back = 0;
	size = 0;
    }

    private void resize(){
	String[] bigger;
	bigger = new String[dequeary.length *2];
	int i = 0;
	for (int j = front; j < size+front; j++){
	    int ind = i % dequeary.length;
	    bigger[j] = dequeary[i];
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
		front = dequeary.length - 1;
	    }
	    else{
		front -=1;
	    }
	}
	dequeary[front] = str;
	size += 1;
	
    }

    /** to be written
    public void addLast (String str){
    }

    //retrieve and remove the element from the specified side
    public String removeFirst(){
    }

    public String removeLast(){
    }

    //retrieve element from the specified side
    public String getFirst(){
    }

    public String getLast(){
    }

    **/
    public String toString(){
	if (size == 0){
	    return "[]";
	}
	String str = "[";
	for(int i = 0; i < size; i++){
	    if(dequeary[i] == null){
		str += "null,";
	    }
	    else{
		str += dequeary[i]+",";
	    }
	}
	return str.substring(0, str.length() - 1) + "]";
    }

    public static void main(String[] args){
	MyDeque md = new MyDeque();
	System.out.println(md);
	md.addFirst("hi");
	System.out.println(md);
    }
    
}
