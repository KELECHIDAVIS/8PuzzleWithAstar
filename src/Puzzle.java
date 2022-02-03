import java.util.ArrayList;

public class Puzzle
{
    int g, h ;
    Puzzle parent;
    int[][] grid ;

    Puzzle(int[][] grid)
    {
       this.grid = new int[grid.length][grid[0].length];
       for(int i =0; i<grid.length; i++)
       {
           for(int j=0; j<grid[i].length; j++)
           {
               this.grid[i][j]   = grid[i][j];
           }
       }
    }


    public void print()
    {
        for(int i =0; i<grid.length; i++)
        {
            for(int j=0; j<grid[i].length; j++)
            {
                System.out.print(grid[i][j]+" ");


            }
            System.out.println();
        }
        System.out.println("______");
    }

    public void move(char move)
    {

        int x = zeroX();
        int y = zeroY();
        if(x>=0&&x<grid[0].length&&y>=0&&y<grid.length)
        {
            switch(move)
            {
                case 'r':
                    swap(y,x,y,x-1);
                    break;
                case 'l':
                    swap(y,x,y,x+1);
                    break;
                case 'u':
                    swap(y,x,y+1,x);
                    break;
                case 'd':
                    swap(y,x,y-1,x);
                    break;
            }
        }

    }

    public void swap(int i1, int j1 ,int i2, int j2){
        int dummy = grid[i1][j1];
        grid[i1][j1] = grid[i2][j2];
        grid[i2][j2] = dummy ;
    }
    public  ArrayList<Puzzle> getNeighbors()
    {
        ArrayList<Puzzle> neighbors = new ArrayList<>();
        int x = zeroX();
        int y= zeroY();
        if(x>0)
        {
            Puzzle right = new Puzzle(grid);
            right.move('r');
            neighbors.add(right);
        }
        if(y>0)
        {
            Puzzle down = new Puzzle(grid);
            down.move('d');
            neighbors.add(down);
        }
        if(x<2)
        {
            Puzzle left = new Puzzle(grid);
            left.move('l');
            neighbors.add(left);
        }
        if(y<2)
        {
            Puzzle up = new Puzzle(grid);
            up.move('u');
            neighbors.add(up);
        }


        return neighbors ;
    }


    public int zeroX()
    {
        for(int i =0; i<grid.length; i++)
        {
            for(int j=0; j<grid[i].length; j++)
            {
                if(grid[i][j]==0)
                {
                    return j;
                }
            }
        }
        return 0;
    }
    public int zeroY()
    {
        for(int i =0; i<grid.length; i++)
        {
            for(int j=0; j<grid[i].length; j++)
            {
                if(grid[i][j]==0)
                {
                    return i;
                }
            }
        }
        return 0;
    }



    public int fCost()
    {
        return g+h;
    }
}
