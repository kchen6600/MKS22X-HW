import java.util.*;
public class StackCalc{

    private static boolean isOperator(String op){
	return (op.equals("+"))||(op.equals("-"))||(op.equals("/"))||(op.equals("*"))||(op.equals("%"));
    }

    private static Double evalhelp(double num1, double num2, String op){
	if (op.equals("+")){
	    return num1 + num2;
	}
	else if (op.equals("-")){
	    return num1 - num2;
	}
	else if (op.equals("/")){
	    return num1 / num2;
	}
	else if (op.equals("*")){
	    return num1 * num2;
	}
	else if (op.equals("%")){
	    return num1 % num2;
	}
	else{
	    return 0.0;
	}
    }

    public static Double eval(String str){
	String[] tokens = str.split(" ");
	Stack<Double> nums = new Stack<Double>();
        for (String token : tokens){
	    if (isOperator(token)){
		Double num2 = nums.pop();
		Double num1 = nums.pop();
		Double ans = evalhelp(num1, num2, token);
		nums.push(ans);
	    }
	    else{
		nums.push(Double.parseDouble(token));
	    }
	}
	return nums.pop();
    }

    public static void main(String[] args){
	System.out.println(eval("10 2.0 +") + " should be 12.0");
	System.out.println(eval("11 3 - 4 + 2.5 *")+" should be 30.0");
	System.out.println(eval("8 2 + 99 9 - * 2 + 9 -")+" should be 893.0");
	System.out.println(eval("10 2 -"));//8.0
	System.out.println(eval("10 2 + 10 * 1 + 1 1 1 + + + 10 10 + -"));//104.0
    }
}
