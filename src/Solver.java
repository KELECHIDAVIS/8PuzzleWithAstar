import java.util.ArrayList;
import java.util.HashSet;
import java.util.PriorityQueue;

public class Solver {
    /*
    start is a Puzzle instance
     */
    Puzzle start ;
    public Solver(Puzzle start )
    {
        this.start = start ;

    }

    public ArrayList<Node> solve()
    {
        //Perform search then return path
        PriorityQueue<Node > queue = new PriorityQueue<>();
        Node first = new Node(this.start,null,null);
        queue.add(first);
        HashSet<String> seen = new HashSet<String>(); // makes it strings so its easier to compare
        seen.add(first.toString());
        while(!queue.isEmpty())
        {
            //sort the list according to the f
            Node node = queue.poll();
            if(node.solved())
            {
                return node.getPath();
            }

            for(String m: node.actions())
            {
                // first make a copy of the puzzle then make the move
                Puzzle p = node.puzzle.copy();
                p.move(m);// makes move
                Node child  = new Node(p,node,m );
                if(!seen.contains(child.toString()))
                {
                    queue.add(child);
                    seen.add(child.toString());
                }
            }
        }
        return null ;
    }

}
