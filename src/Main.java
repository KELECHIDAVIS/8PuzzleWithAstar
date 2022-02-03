public class Main
{
    public static int[][] startArr = {
            {2,6,3},
            {1,0,8},
            {4,5,7},};
    public static int[][] gArr = {
            {1,2,3},
            {4,5,6},
            {7,8,0},};
    public static Puzzle start =new Puzzle(startArr), goal = new Puzzle(gArr);
    public static void main(String[] args)
    {
        start.print();


    }
}
