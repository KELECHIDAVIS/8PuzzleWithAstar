import java.util.ArrayList;
import java.util.HashSet;

public class Astar
{

    public static ArrayList<Puzzle> Astar(Puzzle start, Puzzle goal)  // should return the path from the start to the end
    {

        //open list ; closed hashset
        ArrayList<Puzzle> openSet= new ArrayList<Puzzle>();
        HashSet<Puzzle> closedSet = new HashSet<Puzzle>();

        openSet.add(start);
        //loop
        while(openSet.size()>0)
        {
            Puzzle current = openSet.get(0);
            for(int i = 0; i<openSet.size(); i++)
            {
                if(current.fCost()>openSet.get(i).fCost()||(current.fCost()==openSet.get(i).fCost()&&openSet.get(i).h < current.h))  // if the f is less than current of if the f is equal to the current but its closer to the goal
                {
                    current = openSet.get(i);
                }
            }
            openSet.remove(current);
            closedSet.add(current);
            if(current == goal)
            {
                // retrace and return path
                System.out.println("Path found");
                //return;
            }

            // for each neighbor
            for(Puzzle neighbor : current.getNeighbors())
            {
                //if neighbor is not traversable or in the closed set : continue
                if(closedSet.contains(neighbor))
                    continue;

                //if new path to neighbor is shorter or neighbor is not in open
                int newCostToNeighbor = current.g + dist(current,neighbor); // the total cost it takes to get from the start to this neighbor node from this path

            }


        }



        //if path not found
        return null ;
    }

    public static int dist(Puzzle a ,Puzzle b) // returns the manhattan distance between one puzzle and another
    {
        int distance =0;

        return distance ;
    }

    public static ArrayList<Puzzle> retrace(Puzzle start, Puzzle goal)
    {
        ArrayList<Puzzle> path = new ArrayList<>();


        return path;
    }






}
