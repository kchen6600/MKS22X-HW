import java.util.*;
public class Quick{

    public static String name(){
	return "Chen,Karen";
    }

    public static void swap(int[]data, int first, int second){
	int t = data[first];
	data[first] = data[second];
	data[second] = t;
    }


    public static int part(int[] data, int start, int end){

	if (start == end){
	    return end;
	}
	
        int pivot = ((int)(Math.random() * (end+1-start))) + start;
	int pivotnum = data[pivot];
        swap(data, start, pivot);

	int begin = start+1;
	int last = end;
	while(begin < last){
	    if(data[begin] < pivotnum){
		begin+=1;
	    }
	    else{
		swap(data, begin, last);
		last-=1;
	    }
	}
	if(data[last] >= data[start]){
	    swap(data, start, last-1);
	    return last-1;
	}
	else{
	    swap(data, start, last);
	    return last;
	}
		
    }


    public static int quickselect(int[]data, int k){
	return quickhelper(data, k, 0, data.length-1);
    }


    public static int quickhelper(int[]data, int k, int start, int end){
	
	int pivotindex = part(data, start, end);
	if (pivotindex == k){
	    return data[k];
	}
	else{
	    if(k > pivotindex){
		return quickhelper(data, k, pivotindex+1,end);
	    }
	    else{
		return quickhelper(data, k, start, pivotindex-1);
	    }
        }

    }

    public static void quicksort(int[] data){
	quicksortH(data, 0, data.length-1);
    }

    public static void quicksortH(int[] data, int start, int end){

	if (end > start){
	    int i = part(data, start, end);
	    quicksortH(data, i+1, end);
	    quicksortH(data, start, i-1);
	}
    }
   
    public static void main(String[]args){


	//int[] arr = {2, 10, 15, 23, 0, 5};

	int[] arr = {999,999,999,4,1,0,3,2,999,999,999};
	/**
	System.out.println(select(arr, 0));
	System.out.println(select(arr, 1));
	System.out.println(select(arr, 2));
	System.out.println(select(arr, 3));
	System.out.println(select(arr, 4));
	System.out.println(select(arr, 5));
	**/
	quicksort(arr);
	
	for(int i = 0; i < arr.length; i++){
	    System.out.print(arr[i]+" ");
	    // System.out.println(quickselect(arr,i));
      	}
	

	

	
    }

    
}
