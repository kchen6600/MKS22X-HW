public class RunningMedian{
    //max <= median
    private MyHeap maxheap;
    //min >= median
    private MyHeap minheap;
    
    public RunningMedian(){
	maxheap = new MyHeap();
	minheap = new MyHeap(false);
    }

    public double getMedian(){
	if (maxheap.size() == minheap.size()){
	    return (maxheap.peek() + minheap.peek()) / 2.0;
	}
	else if (maxheap.size() < minheap.size()){
	    return 0.0 + minheap.peek();
	}
	else{
	    return 0.0 + maxheap.peek();
	}
    }

    public void add(Integer val){
	int maxsize = maxheap.size();
	int minsize = minheap.size();
	//both empty
	if (maxheap.size() == 0 && minheap.size() == 0){
	    maxheap.add(val);
	}
	//max empty
	else if (maxheap.size() == 0 && minheap.peek().compareTo(val) < 0){
	    maxheap.add(maxheap.remove());
	    maxheap.add(val);
	}
	else if (getMedian() < val){
	    minheap.add(val);
	    if (minheap.size() - maxheap.size() > 1){
		maxheap.add(minheap.remove());
	    }
	}
	else{
	    maxheap.add(val);
	    if (maxheap.size() - minheap.size() > 1){
		minheap.add(maxheap.remove());
	    }
	}
	
    }

    public String toString(){
	return getMedian() + "";
    }

    public static void main(String[] args){
	RunningMedian test = new RunningMedian();
	test.add(7);
	System.out.println(test);
	test.add(2);
	test.add(9);
	test.add(10);
	test.add(1);
	System.out.println(test);
	for (int i = 0; i < 1000; i++){
	    test.add((int)(Math.random() * 60000));
	}
	System.out.println(test);
    }



    
}
