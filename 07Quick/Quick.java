import java.util.Random;
public class Quick{
    public static int part(int[] data, int start, int end){
	int pivot = new Random().nextInt(end-start);
	

	int begin = start - 1;

	for(int i = start; i <= end - 1; i++){
	    if(data[i] <= data[pivot]){ //if element is less than or equal to element at the pivot
		begin+=1;
		//swap
		int temp = data[begin];
		data[begin] = data[i];
		data[i] = temp;
	    }
	}
	//swap
	int temp = data[begin+1];
	data[begin+1] = data[end];
	data[end] = temp;

	return pivot;
		
    }


    public static int quickselect(int[]data, int k){
    }
    public static void main(String[]args){

	int[] arr = new int[]{1, 3, 10, 11, 2, 5, 0, 8, 7, 0};
	System.out.println(part(arr,0,9));
	for(int i = 0; i < arr.length; i++){
	    System.out.print(arr[i]+" ");
	}
    }

    
}
