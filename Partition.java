public class Partition{
    public static int[] part(int[] data, int start, int end){

	int[]result = new int[data.length];
	int pivot = new Random().nextInt(data.length);
	int num = data[pivot];

	int begin = 0;
	int last = data.length -1;
	for(int i = start; i <= end; i++){
	    if (i != pivot){
		if( data[i] <= num){
		    result[begin] = data[i];
		    begin +=1;
		}
		if(data[i] > num){
		    result[last] = data[i];
		    last+=1;
		}
	    }
	}

	result[begin] = data[pivot];
	return result;
	    
		
    }
}
