import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class Panel extends GamePanel{
    int[][] board = {{1,2,3},{5,7,8},{6,4,0}};
    ArrayList<Node> path;
    boolean solve = false;
    public Panel()
    {



    }

    @Override
    public void update() {
        if(solve)
        {
            Puzzle puzzle = new Puzzle(board);
            Solver s = new Solver(puzzle);
            path = s.solve();
            int steps =0;


            for(Node n : path)
            {
                steps++;
                System.out.println(steps);
                System.out.println(n.action);
                System.out.println(n.puzzle.toString());

            }
            this.start();
            solve=false;
        }
    }

    @Override
    public void paint(Graphics g) {
        for(int i=0; i<3; i++)
        {
            for(int j =0 ; j<3; j++)
            {
                if(board[i][j]!=0)
                {
                    g.drawRect(j*200,i*200,200,200);
                    g.drawString(board[i][j]+"", j*200+100,i*200+100);
                }

            }
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    @Override
    public void mouseDragged(MouseEvent e) {

    }

    @Override
    public void mouseMoved(MouseEvent e) {

    }
}
