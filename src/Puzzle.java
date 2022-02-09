import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Puzzle
{
    int g, h ;
    int[][] goal = {{1,2,3},{4,5,6},{7,8,0}};
    int[][] grid ;

    public Puzzle(int[][] board )
    {
        this.grid = board;
    }



    public String toString()
    {
        String string ="" ;
        for(int i =0; i<grid.length; i++)
        {
            for(int j=0; j<grid[i].length; j++)
            {
                string+=grid[i][j];
                string+=" ";


            }
            string+="\n";
        }
        string+="______";
        return string;
    }

    public boolean solved()
    {
        for(int i =0 ; i<3; i++)
        {
            for(int j =0; j<3; j++)
            {
                if(grid[i][j]!=goal[i][j])
                    return false;
            }
        }
        return true;
    }

    public ArrayList<String> actions()
    {
        ArrayList<String> moves = new ArrayList<String> ();
        // find the zero
        int row =0, col = 0;
        for(int i =0; i<3; i++) // finds zero position
        {
            for(int j =0; j<3; j++)
            {
                if(grid[i][j]   ==0 )
                {
                    row =i;
                    col=j;
                }
            }
        }
        if(col>0)
            moves.add("RIGHT");
        if(col<2)
            moves.add("LEFT");
        if(row>0)
            moves.add("DOWN");
        if(row<2)
            moves.add("UP");

        return moves ;
    }
    public void move(String m)
    {
        // find the zero
        int row =0, col = 0;
        for(int i =0; i<3; i++) // finds zero position
        {
            for(int j =0; j<3; j++)
            {
                if(grid[i][j]   ==0 )
                {
                    row =i;
                    col=j;
                }
            }
        }
        switch(m)
        {
            case "RIGHT":
                swap(row,col,row,col-1);
                break;
            case "LEFT":
                swap(row,col,row,col+1);
                break;
            case "UP":
                swap(row,col,row+1,col);
                break;
            case "DOWN":
                swap(row,col,row-1,col);
                break;
        }
    }


    public void swap(int i1 ,int j1 , int i2 , int j2 )
    {
        int dummy = grid[i1][j1];
        grid[i1][j1]=grid[i2][j2];
        grid[i2][j2 ] = dummy;
    }


    public int manhattan() // returns manhattan dist from goal
    {

        //dont check dist for 0
        int dist =0;
        for(int i =0; i<3; i++)
        {
            for(int j =0; j<3;  j++)
            {
                if(grid[i][j]!=0)
                {
                    dist+= calcDist(i,j,grid[i][j]);
                }
            }
        }
        return dist;
    }
    public int calcDist(int row , int col  ,int num )
    {
        int realRow = 0 , realCol = 0;
        switch (num)
        {
            case 1:
                realRow =0;
                realCol = 0;
                break;
            case 2:
                realRow =0;
                realCol = 1;
                break;
            case 3:
                realRow =0;
                realCol = 2;
                break;
            case 4:
                realRow =1;
                realCol = 0;
                break;
            case 5:
                realRow =1;
                realCol = 1;
                break;
            case 6:
                realRow =1;
                realCol = 2;
                break;
            case 7:
                realRow =2;
                realCol = 0;
                break;
            case 8:
                realRow =2;
                realCol = 1;
                break;


        }
        return (int)((Math.abs(row-realRow))+(Math.abs(col-realCol)));
    }

    public Puzzle copy()
    {
        int[][] temp = new int[3][3];
        for(int i =0; i<3; i++)
        {
            for(int j=0; j<3; j++)
            {
                temp[i][j]=this.grid[i][j];
            }
        }
        return new Puzzle(temp);
    }








}
