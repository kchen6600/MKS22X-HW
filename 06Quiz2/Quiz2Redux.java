import java.util.*;
public class Quiz2Redux{

    public static String name(){
	return "Chen,Karen";
    }
    public static ArrayList<String>combinations(String s){
	ArrayList<String>words= new ArrayList<String>();
	help(words, 0, s, "" );
	Collections.sort(words);
	return words;
    }
    private static void help(ArrayList<String> words, int begin, String s, String newstr){
	if (s.length() == begin){
	    words.add(newstr);
	    return;
	}
	help(words,begin+1,s,newstr);
	help(words,begin+1,s,s.substring(begin,begin+1)+newstr);

    }

    public static void main(String[]args){
	System.out.println(combinations("abcd"));
	System.out.println(combinations("kji"));
    }
}
