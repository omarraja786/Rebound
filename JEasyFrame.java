package Assignment2;



import javax.swing.*;
import java.awt.*;


public class JEasyFrame extends JFrame {
    public Component comp;
    public JEasyFrame(Component comp, String title) {
        super(title);
        this.comp = comp;
        getContentPane().add(BorderLayout.CENTER, comp);
        pack();
        this.setVisible(true);
        this.setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        repaint();
    }
}

/*A class that extends JFrame, that adds the frame to the center of the component, sets the frame to visible and prevents resizing. When the X is pressed
     * the application closes and stops running. The relative location is set too null so that the whole frame appears on the centre of the monitor regardless of the screen size
      * The method then calls the repaint method to redraw any changes made.*/
