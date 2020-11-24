package Assignment2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;


public class Rankings{
    boolean play = GameView.getPlay();
    boolean gameover = GameView.getGameOver();
    ArrayList<Integer> lst = GameView.getRanking();


    File fileModified = new File("src/Assignment2/scores.txt");

    public void leaderboard() {
        if (play == false && gameover == true) {
            JFrame frame = new JFrame("View Rankings");
            frame.setVisible(true);
            frame.setSize(400,100);
            frame.setLocationRelativeTo(null);
            JPanel mainPanel = new JPanel();
            frame.add(mainPanel);

            JButton allTime = new JButton("Top 10 All Time Rankings");
            JButton dayRanking = new JButton("Top 10 Rankings (24 Hour)");
            mainPanel.add(allTime);
            mainPanel.add(dayRanking);

            allTime.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    JFrame frame = new JFrame("All Time Rankings");
                    frame.setVisible(true);
                    frame.setSize(300,300);
                    frame.setLocationRelativeTo(null);
                    JPanel allPanel = new JPanel();
                    frame.add(allPanel);
                    JTextArea rank = new JTextArea();
                    rank.setFont(new Font("Arial Black", Font.BOLD, 12));
                    rank.setEditable(false);

                    for (int all = 0; all < lst.size(); all++) {
                        if (all < 10) {
                            rank.append("Rank #" + (all+1) + ": " + lst.get(all) + " point(s)" + "\n");
                        }
                    }
                    allPanel.add(rank);
                }
            });

            /*This method is for the leaderboards (Top All time ranking). I could not use button handlers so I had to add individual action listeners
         * to the button. Each button opens up a jframe with a non editable text area. A for loop is used to iterate through the sorted rankings list and print only the top 10.
          * Even if there are less than 10 entries it will not bring up an index out of bounds error due to the condition check. The text is then added to the panel.*/

            dayRanking.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {

                    try {
                        JFrame frame = new JFrame("24 Hour Rankings");
                        frame.setVisible(true);
                        frame.setSize(300,300);
                        frame.setLocationRelativeTo(null);
                        JPanel dayRanking = new JPanel();
                        frame.add(dayRanking);
                        JTextArea ranks = new JTextArea();
                        ranks.setFont(new Font("Arial Black", Font.BOLD, 12));
                        ranks.setEditable(false);

                        long MILLIS_PER_DAY = 24 * 60 * 60 * 1000L;

                        LocalDateTime currentTime = LocalDateTime.now().minusDays(1);

                        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
                        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

                        String formatDateTime = currentTime.format(formatter);
                        String formatFileTime = sdf.format(fileModified.lastModified());


                        Date date_current = sdf.parse(formatDateTime);
                        Date date_added = sdf.parse(formatFileTime);
                        boolean lessThanDay = Math.abs(date_current.getTime() - date_added.getTime()) < MILLIS_PER_DAY;

                        for (int day = 0; day < lst.size(); day++) {
                            if (day < 10 && lessThanDay) {
                                ranks.append("Rank #" + (day+1) + ": " + lst.get(day) + " point(s)" + "\n");
                            }
                        }
                        dayRanking.add(ranks);
                    }
                    catch (ParseException e1) {
                        e1.printStackTrace();
                    }
                }
            });

        }

        /*For this action listener on the button, it again opens up a frame however it gets the current time - 1 day, and then the time the file was modified. If the file modified
         * is within 24 hours then it will print the rankings otherwise it will not. Formatting is used so that the times are the same format. */

    }
}
