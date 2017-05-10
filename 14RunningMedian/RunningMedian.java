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
	    return (maxheap.size() + minheap.size()) / 2.0;
	}
	else if (maxheap.size() < minheap.size()){
	    return 0.0 + minheap.peek();
	}
	else{
	    return 0.0 + maxheap.peek();
	}
    }

    public void add(Integer val){
	//both empty
	if (maxheap.size() == 0 && minheap.size() == 0){
	    maxheap.add(val);
	}
	//max empty
	else if (maxheap.size() == 0 && minheap.peek().compareTo(val) < 0){
	    maxheap.add(maxheap.remove());
	    maxheap.add(val);
	}
	//other empty
	else if (minheap.size() == 0 && maxheap.peek().compareTo(val) < 0){
	    maxheap.add(minheap.remove());
	    maxheap.add(val);
	}
	else{
	    maxheap.add(val);
	}
	
    }

    public String toString(){
	return getMedian() + "";
    }

    public static void main(String[] args){
	RunningMedian test = new RunningMedian();
	test.add(7);
	System.out.println(test);
    }



    
}
