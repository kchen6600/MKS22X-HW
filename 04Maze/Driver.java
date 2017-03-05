public class Driver{

    public static void main(String[]args){
        Maze f;
        f = new Maze("data1.dat");//true animates the maze.
        
        f.setAnimate(true);
	f.solve();

         System.out.println(f);

	Maze l;
	l = new Maze("Maze1.txt");
	l.setAnimate(true);
	l.solve();
	System.out.println(l);

	//	Maze f2;
	// f2 = new Maze("data2.dat");//true animates the maze.
        
	// f2.setAnimate(true);
	//	f2.solve();
	//	System.out.println(f2);

       	Maze f3;
        f3 = new Maze("data3.dat");//true animates the maze.
        
        f3.setAnimate(true);
	f3.solve();
	System.out.println(f3);
    }
}
