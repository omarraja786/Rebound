package Assignment2;



        import java.io.*;
        import java.util.Random;


public class GameViewTest
{

    public static void main(String[] args) throws FileNotFoundException {
        // test the view component

        Random r = new Random();
        int w = 20;
        int h = 20;
        int[][] a = new int[w][h];
        for (int i = 0; i < w; i++)
        {
            for (int j = 0; j < h; j++)
            {
                //  a[i][j] = r.nextInt(GameView.colors.length);
            }
        }

        GameView tv = new GameView(a);
        new JEasyFrame(tv, "Mohammed Omar Raja");

    }

    /*The main method that sets the width and height of the frame that is stored within a 2D Array. A nested for loop is used that defined the grid of square of a 20x20 grid.
    * No content is added to the for loop so that the grid remains invisible. A new object of GameView is then called with a parameter of a 2d array and the frame is opened.*/
}