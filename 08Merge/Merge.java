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

	if (ary.length <= 1){
	    return;
	}

	else{
	    int[] l = new int[ary.length /2];
	    int[] r = new int[ary.length - l.length];

	    int rind = 0;
	    for (int lind = 0; lind < ary.length; lind++){
		if (lind < l.length){
		    l[lind] = ary[lind];
		}
		else{
		    r[rind] = ary[lind];
		    rind+=1;
		}
	    }

	    mergesort(l);
	    mergesort(r);
	    merge(l, r, ary);
	}

	    
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
	    else if (a[i] <= b[j]){
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
	//merge (a, b, dest);
	//System.out.println(Arrays.toString(dest));
	int [] ran = { 0, 1, 1, 1, 1, 0, 3, 9, 6, 7, 4};
	mergesort(ran);
	System.out.println(Arrays.toString(ran));

    }


	
}
    
