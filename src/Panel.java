import javax.swing.*;
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
        int answer = JOptionPane.showConfirmDialog(null, "Input a starting position?","Starting Prompt" , JOptionPane.YES_NO_CANCEL_OPTION);
        if(answer ==0)
        {
            String input = JOptionPane.showInputDialog("Input board as a 1 dimensional string Ex: 123456780"); // has to be 9 letters
            for(int i =0; i<input.length(); i++)
            {
                int row =i/3; int col =i%3;
                board[row][col  ] = Integer.parseInt(""+input.charAt(i));
            }
        }
        this.start();

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
                System.out.print(steps+": ");
                System.out.print(n.action+"| ");



            }

            solve=false;

        }
    }

    @Override
    public void paint(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        g2.clearRect(0,0,610,620);
        g2.setStroke(new BasicStroke(5));
        for(int i=0; i<3; i++)
        {
            for(int j =0 ; j<3; j++)
            {
                if(board[i][j]!=0)
                {
                    g2.setFont(new Font("Ink Free",Font.BOLD,40));
                    g2.drawRect(j*200,i*200,200,200);
                    g2.drawString(board[i][j]+"", j*200+100,i*200+100);

                }

            }
        }
    }
    public void arrSwap(int i1 ,int j1 , int i2 , int j2 )
    {
        int dummy = board[i1][j1];
        board[i1][j1]=board[i2][j2];
        board[i2][j2 ] = dummy;
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if(e.getKeyCode()== KeyEvent.VK_Q)
        {
            solve = true;
            System.out.println("pressed");
        }
        if((e.getKeyCode()==KeyEvent.VK_DOWN||e.getKeyCode()==KeyEvent.VK_LEFT||e.getKeyCode()==KeyEvent.VK_RIGHT||e.getKeyCode()==KeyEvent.VK_UP)){
            // find the zero
            int row =0, col = 0;
            for(int i =0; i<3; i++) // finds zero position
            {
                for(int j =0; j<3; j++)
                {
                    if(board[i][j]   ==0 )
                    {
                        row =i;
                        col=j;
                    }
                }
            }
            switch(e.getKeyCode())
            {
                case KeyEvent.VK_RIGHT:
                    if(col>0)
                        arrSwap(row,col,row,col-1);
                    break;
                case KeyEvent.VK_LEFT:
                    if(col<2)
                        arrSwap(row,col,row,col+1);
                    break;
                case KeyEvent.VK_UP:
                    if(row<2)
                        arrSwap(row,col,row+1,col);
                    break;
                case KeyEvent.VK_DOWN:
                    if(row>0)
                        arrSwap(row,col,row-1,col);
                    break;
            }

            /*for(int i =0; i<3; i++) // finds zero position
            {
                for(int j =0; j<3; j++)
                {
                    System.out.print(board[i][j]+" ");
                }
                System.out.println();
            }*/

        }


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
