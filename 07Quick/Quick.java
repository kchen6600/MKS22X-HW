public class Quick{

    public static void swap(int[]data, int first, int second){
	int t = data[first];
	data[first] = data[second];
	data[second] = t;
    }
    
    public static int part(int[] data, int start, int end){
	int pivot = (int)(Math.random() * data.length);

	swap(data, pivot, end-1);

	
	int begin = start;
	for(int i = start; i < end - 1; i++){
	    if(data[i] < data[end-1]){ //if element is less than or equal to element at the pivot
		//swap
		swap(data, begin, i);
		begin+=1;

	      
	    }
	}
	//swap
	swap(data, begin, end-1);

	return begin;
		
    }


    public static int quickselect(int[]data, int k){
	return -1;
    }
    public static void main(String[]args){

	int[] arr = new int[]{1, 3, 10, 11, 2, 5, 0, 8, 7};
	System.out.println(part(arr,0,9));
	for(int i = 0; i < arr.length; i++){
	    System.out.print(arr[i]+" ");
	}
    }

    
}
