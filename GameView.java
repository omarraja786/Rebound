package Assignment2;



import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
import javax.swing.Timer;

//All required imports.

public class GameView extends JComponent implements ActionListener{
    public static Shape[] shapes;

    static ArrayList<Integer> ranking = new ArrayList<Integer>();  //An array list to read the file into the list.

    FileReader file = new FileReader("src/Assignment2/scores.txt");


    int[][] a;
    int w, h;
    static int size = 20;
    public static boolean play = false;
    public static int score = 0;
    public static boolean gameover = false;
    public static boolean scorewritten = false;

    private Timer timer;
    public int delay = 10;


    public static int ballDirX = -1;
    public static int ballDirY = -2;

    //All required variables to be used in the program.


    public GameView(int[][] a) throws FileNotFoundException {


        Shape[] shapes = new Shape[5];
        shapes[1] = new Rectangle(180,390,50,8,0);
        shapes[2] = new Circle (199,365,10,0);
        shapes[3] = new Rectangle(0,0,410,3,0);
        this.shapes = shapes;

        //Creates the paddle,ball and top wall stored in an array and references the instance to the object.

        this.a = a;
        w = a.length;
        h = a[0].length;

        MyKeyListener listener = new MyKeyListener();
        addKeyListener(listener);
        setFocusable(true);
        setFocusTraversalKeysEnabled(false);

        //Adds the key listener to the program so that key presses are recognised.

        timer = new Timer(delay, this);
        timer.start();

        //Creates the timer object and starts it(speed of the ball). The delay is in milliseconds for the initial and next event.

    }

    public static boolean getPlay() {
        return play;
    }

    public static boolean getGameOver() {
        return gameover;
    }

    public static int getScore() {
        return score;
    }

    public static ArrayList<Integer> getRanking() {return ranking;}

    //Getter methods for the boolean values of play,gameover and the points gained.



    public void paintComponent(Graphics g)
    {
            for (int i = 0; i < w; i++)
            {
                for (int j = 0; j < h; j++)
                {
                    g.setColor(Color.darkGray);
                    g.fillRect(1,1,410,410);

                    g.setColor(Color.yellow);
                    g.fillRect(0,0,410,3);

                    shapes[1].draw(g);
                    shapes[2].draw(g);

                    g.setColor(Color.white);
                    g.setFont(new Font("serif",Font.BOLD, 20));
                    g.drawString("Score:"+score,330,30);

                    /*This is where the objects are actually drawn using the paint component on to the frame and the score text is added to the top right and remains there always.*/

                    if(play == false && gameover == false) {
                        g.setColor(Color.white);
                        g.setFont(new Font("serif",Font.BOLD, 17));
                        g.drawString("Press the left or right arrow key to start the game",20,190);
                    }
                    /*Different conditions are used here depending on the stage of the game to show different messages. If the game hasn't been started but its not due to the round ending,
                     * then it displays how to start the game*/

                    else if (gameover == true && play == false) {
                        int index = ranking.indexOf(score);

                        g.setColor(Color.RED);
                        g.setFont(new Font("serif",Font.BOLD, 17));
                        g.drawString("Press Space to restart game",100,50);

                        g.setColor(Color.WHITE);
                        g.setFont(new Font("serif",Font.BOLD, 20));
                        g.drawString("Ranking: #" + (index+1) ,140,100);

                    }

                    /*If the game is over, it shows how to restart the game and the current ranking of that score in the all time ranking using the indexOf. Need to add 1 so that
                     * the text starts from Rank 1 rather than rank 0. */

                    if(gameover == true && play == false && !scorewritten) {

                        scorewritten = true;
                        saveScore write = new saveScore();
                        write.outputScore();
                        try {
                            Scanner input = new Scanner(file);
                            while(input.hasNextInt())
                            {
                                ranking.add(input.nextInt());
                                Collections.sort(ranking);
                                Collections.reverse(ranking);
                            }
                            input.close();
                        }
                        catch(Exception e) {
                            e.printStackTrace();
                        }
                        Rankings callRanking = new Rankings();
                        callRanking.leaderboard();
                    }
                }
            }
            /*The reason for this code is to first call the save score class that saves it to the text file.
             Then the scores file is read into the list so that it can be sorted. A boolean for score written is used so that there are no duplicate entries when writing due to
              there being a for loop. The reverse function makes the high scores highest -> lowest. The rankings method is then called to allow the leaderboard to be displayed*/
    }

    public Dimension getPreferredSize() {
        return new Dimension(w * size, h * size);
    }   //Sets the dimension to 400 pixels (20x20).

    @Override
    public void actionPerformed(ActionEvent e) {
        Rectangle a = new Rectangle(shapes[2].getX(), shapes[2].getY(), 10,10,0);
        Rectangle b = new Rectangle(shapes[1].getX(),shapes[1].getY(),50,8,0);
        Rectangle c = new Rectangle(shapes[3].getX(),shapes[3].getY(),410,1,0);

        /*3 rectangles are created, the paddle, the wall at the top and one rectangle that defines the circle (using a 10x10 rectangle). The reason for this is so that
         * I can detect when the ball intersects (collides) with the paddle or the wall since there is no intersection method for a oval. */

        if(play == true) {
            if(a.intersects(b)) {
                ballDirY = -(ballDirY);
            }

            if(a.intersects(c)) {
                score+=1;
                if(timer.getDelay() > 4) {
                    timer.setDelay(timer.getDelay() - 1);
                    timer.restart();
                }
            }

            /*If the game is set to true, and the ball collides with the paddle, it changes the direction to negative (opposite direction)
             * If the ball collides with the wall, it adds one to the score, and increases the speed by 1 delay */


            shapes[2].ballX();
            shapes[2].ballY();
            if(shapes[2].getX() < 0) {
                ballDirX = Math.abs(ballDirX);
            }

            if(shapes[2].getY() < 0) {
                ballDirY = Math.abs(ballDirY);
            }
            if(shapes[2].getX() > 407) {
                ballDirX = -ballDirX;
            }

            /*For the above 3 if statements, it sets the bounds of the left wall, right wall and top wall. If the x is less than 0 or greater than 407 (width) or hits y = 0,it redirects the ball.
             **/

            if(shapes[2].getY() > 390 ) {
                play = false;
                ballDirX = 0;
                ballDirY = 0;
                timer.setDelay(10);
                shapes[2].setX(199);
                shapes[2].setY(365);
                shapes[1].setX(180);
                shapes[1].setY(390);
                gameover = true;
            }
            /*If the y coordinate of the ball is > 390 (past the paddle). The game is over, all the variables are set to default including the speed of the ball. */
        }
        repaint();
    }



    public class MyKeyListener implements KeyListener{
        //New Class for the KeyListener (Ian mentioned in an email as long as they are not an inner class of the main function but in the same file it is fine)


        @Override
        public void keyTyped(KeyEvent e) {}

        @Override
        public void keyReleased(KeyEvent e) {}


        @Override
        public void keyPressed(KeyEvent e) {
            if(e.getKeyCode() == KeyEvent.VK_RIGHT && gameover == false) {
                if(shapes[1].getX() >= 360) {
                    shapes[1].setX(360);
                }
                else {
                    moveRight();
                }
            }


            if(e.getKeyCode() == KeyEvent.VK_LEFT && gameover == false) {
                if(shapes[1].getX() < 10) {
                    shapes[1].setX(10);
                }
                else {
                    moveLeft();
                }
            }

            /*If the right key is pressed and the game is not over, but the x coordinate is greater than 360 (past the size of the width), then it sets the value of x to 360
            * so that it cannot get past 360. Otherwise it calls the moveRight function. The same applies for the left key however it changes the value is set to the bound of the left wall.*/

            if(e.getKeyCode() == KeyEvent.VK_SPACE) {
                if(play == false && gameover == true) {
                    ballDirX = -1;
                    ballDirY = -2;
                    score = 0;
                    play = true;
                    gameover = false;
                    scorewritten = false;
                }
            }
        }

        /*If the user presses space at the end of the round, the variables are set to play, and the ball direction starts to move. */

        public void moveRight() {
            play = true;
            shapes[1].incrementX();
        }

        public void moveLeft() {
            play = true;
            shapes[1].decrementX();
        }

        /*These functions set play = true (otherwise idle), and increments or decrements the position of the paddle. */
    }
}
