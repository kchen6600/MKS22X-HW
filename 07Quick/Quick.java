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


	int p1 = ((int)(Math.random() * (end+1-start))) + start;
	int p2 = ((int)(Math.random() * (end+1-start))) + start;
	int p3 = ((int)(Math.random() * (end+1-start))) + start;

	int pivot;
	if ((p1 <= p2 && p1 >= p3) || (p1 <= p3 && p1 >= p2)){
	    pivot = p1;
	}
	else if ((p2 <= p1 && p2 >= p3) || (p2 <= p3 && p2 >= p1)){
	    pivot = p2;
	}

	//	if ((p3 <= p2 && p3 >= p1) || (p3 <= p1 && p3 >= p2)){
	else{
	    pivot = p3;
	}
	swap(data, pivot, start);
        int pivotnum = data[pivot];
	int last = end;
	int lt = start;
	int gt = end;
	int i = start;
	while (i <= gt){
	    if (data[i] == pivotnum){
		i++;
	    }
	    else if (data[i] < pivotnum){
		swap(data, i, lt);
		lt++;
		i++;
	    }
	    else{
		swap(data, i, gt);
		gt--;
	    }
	}
	return lt;



		   
		
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

	if (start == end){
	    return;
	}

	int ran = (int)(Math.random() * (1+ end - start)) + start;

	swap(data, start, ran);

	int i = start + 1;
	int gt = end;
	int lt = start;
	int num = data[lt];

	while( gt >= i){
	    if(num == data[i]){
		i++;
	    }
	    else if (num > data[i]){
		swap (data, lt, i);
		lt+=1;
		i+=1;
	    }
	    else{
		swap (data, gt, i);
		gt -=1;
	    }
	}
	if (end > start){
	    quicksortH(data, gt, end);
	    quicksortH(data, start, lt-1);
	}
    }
   
    public static void main(String[]args){


	//int[] arr = {2, 10, 15, 23, 0, 5};

	int[] arr = {999,999,999,4,1,0,3,2,999,999,999};
	
	int[] ar = new int[300000];
	int[] ar2 = new int[300000];
	for(int i = 0; i < 300000; i++){
	    int ran = (int)(Math.random()*30000+1);
	    ar[i] = ran;
	    ar2[i] = ran;
	}
	quicksort(ar);
	Arrays.sort(ar2);

	System.out.println(Arrays.equals(ar, ar2));
	    
	
	
	System.out.println(quickselect(arr, 0));
	System.out.println(quickselect(arr, 1));
	System.out.println(quickselect(arr, 2));
	System.out.println(quickselect(arr, 3));
	System.out.println(quickselect(arr, 4));
	System.out.println(quickselect(arr, 5));
       
	/**
	quicksort(arr);
	
	for(int i = 0; i < arr.length; i++){
	    System.out.print(arr[i]+" ");
	    // System.out.println(quickselect(arr,i));
      	}
	**/

	

	
    }

    
}
