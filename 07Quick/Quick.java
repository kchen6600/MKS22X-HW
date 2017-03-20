public class Quick{

    public static void swap(int[]data, int first, int second){
	int t = data[first];
	data[first] = data[second];
	data[second] = t;
    }


     public static int part(int[] data, int start, int end){
	int pivot = (int)(Math.random() * data.length);

	swap(data, pivot, end);

	
	int begin = start;
	for(int i = start; i < end; i++){
	    if(data[i] < data[end]){ //if element is less than or equal to element at the pivot
		//swap
		swap(data, begin, i);
		begin+=1;

	      
	    }
	}
	//swap
	swap(data, begin, end);

	return begin;
		
    }


    public static int select(int[]data, int k){
	return quickhelper(data, k, 0, data.length-1);
    }


    public static int quickhelper(int[]data, int k, int start, int end){
	int pivotindex = part(data, 0, data.length-1);
	if (pivotindex == k){
	    return data[k];
	}
	else if(k > pivotindex){
	    return quickhelper(data, k, start, pivotindex-1);
	}
	else{
	    return quickhelper(data, k, pivotindex-1, end);
	}
    }
   
    public static void main(String[]args){

	//int[] arr = new int[]{1, 0, 10, 11, 2, 2, 5, 0, 8, 7};
	//System.out.println(part(arr,0,arr.length));

	int[] arr = new int[]{2, 10, 15, 23, 0, 0, 5};
	System.out.println(select(arr, 0));
	System.out.println(select(arr, 1));
	System.out.println(select(arr, 2));
	System.out.println(select(arr, 3));
	System.out.println(select(arr, 4));
	System.out.println(select(arr, 5));
	/**	
	for(int i = 0; i < arr.length; i++){
	    // System.out.print(arr[i]+" ");
	    System.out.println(quickselect(arr,i));
      	}
	**/

	

	
    }

    
}
