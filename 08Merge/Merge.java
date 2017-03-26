import java.util.*;
import java.io.*;
public class Merge{

    /**
       worked on merge with Katherine Vasilkin
    **/

    public static String name(){
	return "Chen,Karen";
    }

    public static void mergesort(int[]ary){ //more params tbd
    //split the array in half recursively
    }

    public static void merge(int[]a, int[]b, int[] destination){

	int i = 0;
	int j = 0;
	int l = 0;
	
	while (i <= a.length && j <= b.length && l < destination.length){
	    if (i == a.length){
		destination[l] = b[j];
		j++;
		l++;
	    }
	    else if (j == b.length){
		destination[l] = a[i];
		i++;
		l++;
	    }
	    else if (a[i] < b[j]){
		destination[l] = a[i];
		i++;
		l++;
	    }
	    else if(b[j] < a[i]){
		destination[l] = b[j];
		j++;
		l++;
	    }
	}
    }
	       
	
    

    public static void main(String[] args){
	int [] a = {1, 3,  5, 7, 9, 11 };
	int [] b = {2, 4, 6, 8, 10 };
	int[] dest = new int[a.length + b.length];
	merge (a, b, dest);
	System.out.println(Arrays.toString(dest));

    }


	
}
    
