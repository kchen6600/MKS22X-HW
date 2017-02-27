public class Recursion{ 
 public static String name(){
    return "Chen,Karen";
 }

 public static boolean closeEnough(double num, double num2){
     double difference = .00000000001;
     if (num == 0 && num2 == 0){
	 return Math.abs(num - num2) < difference;
     }
     if (num == 0){
	 return ((Math.abs(num-num2)) / num2) < difference;
     }
     return ((Math.abs(num - num2))/ num) < difference;
     
 }

 public static double sqrt(double n){

     if (n < 0){
	 throw new IllegalArgumentException();
     }
     if (closeEnough(n, 0)){
	 return 0;
     }
     else{
	 return sqrt2(n, 1);
     }
 }

 public static double sqrt2(double n, double guess){
     if (closeEnough(n, guess * guess)){
	 return guess;
     }
     else{
	 return sqrt2(n, ((n/guess + guess)/2));
     }
 }
   
 public static void main(String[]args){
     System.out.println(closeEnough(1.00000000000000001, 1.0));
     System.out.println(closeEnough(1.0000000001, 1.0));
     System.out.println(closeEnough(0, 0.000001));
     System.out.println(sqrt(4.0));
     System.out.println(closeEnough(sqrt(4.0),2));
     System.out.println(sqrt(100));
     System.out.println(sqrt(901));
     System.out.println(sqrt(0.000000));
 }

}
