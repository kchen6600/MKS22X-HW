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
    }

    public String toString(){
    }

    public static void main(String[] args){
	RunningMedian test = new RunningMedian();
    }



    
}
