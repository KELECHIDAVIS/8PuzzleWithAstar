import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Main
{
    static class Test implements Comparable<Test >
    {
        int h ;
        public Test(int h )
        {
            this.h =h;
        }
        public String toString()
        {
            return this.h+  "";
        }


        @Override
        public int compareTo(Test o) {
            return this.h - o.h;
        }
    }

    public static void main(String[] args)
    {


        Panel panel = new Panel() ;
        Frame frame = new Frame("8 Puzzle", 610,640,panel);



    }
}
