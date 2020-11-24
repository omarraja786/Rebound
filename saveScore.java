package Assignment2;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;


public class saveScore {

        public void outputScore() {

            File file = new File("src/Assignment2/scores.txt");

            boolean play = GameView.getPlay();
            boolean gameover = GameView.getGameOver();
            int score = GameView.getScore();
            boolean scorewritten = false;

            //Creates the values using the public static variables defined in GameView.


            if (play == false && gameover == true && !scorewritten) {
                try {
                    FileWriter fw = new FileWriter(file.getAbsoluteFile(), true);
                    PrintWriter pw = new PrintWriter(fw);
                    pw.println(score);
                    scorewritten = true;
                    pw.close();
                    fw.close();

                } catch (IOException x) {
                    System.out.println("File not found");
                    x.printStackTrace();
                }
            }
        }

        /*Creates a method that will try to write to a file, append the file (so it doesn't overwrite), and print the score to the file on a new line IF the game is over, the game
         * is not in play and the score has not yet been written. Once it does this, it sets the score written to true and closes the file opening. If the file cannot be found
          * an error is shown stating so.*/
}
