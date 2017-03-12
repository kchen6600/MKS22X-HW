public class Driver{
    public static void main(String[] args){
	USACO x = new USACO();
       	System.out.println(x.bronze("testfile1.txt")); //34211
       	System.out.println(x.bronze("brtest2.txt")); //102762432
	System.out.println(x.bronze("brtest3.txt")); //1058992704
	System.out.println(x.bronze("brtest4.txt")); //753121152
	System.out.println(x.bronze("brtest5.txt")); //1028282688
	System.out.println(x.bronze("brtest6.txt")); //72207936
	System.out.println(x.bronze("brtest7.txt")); //265508928
	System.out.println(x.bronze("brtest8.txt")); //776609856
	System.out.println(x.bronze("brtest9.txt")); //2098830528
	System.out.println(x.bronze("brtest10.txt")); //211201344
	
        System.out.println(x.silver("siltestfile1.txt")); //1
	System.out.println(x.silver("siltestfile2.txt")); //74
	System.out.println(x.silver("siltestfile3.txt")); //6435
	System.out.println(x.silver("siltestfile4.txt")); //339246
	System.out.println(x.silver("siltestfile5.txt")); //0
       	System.out.println(x.silver("siltest6.txt")); //14396412
	System.out.println(x.silver("siltest7.txt")); //1533810
        System.out.println(x.silver("siltest8.txt")); //456055
	System.out.println(x.silver("siltest9.txt")); //28
	System.out.println(x.silver("siltest10.txt")); //1321670
	
    }
}
