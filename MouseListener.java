package Assignment2;

import java.awt.event.MouseEvent;




public class MouseListener {

    boolean mouseDownBut1 = false;
    boolean mouseDownBut2 = false;
    public void mousePressed(MouseEvent e) {
        if (e.getButton() == MouseEvent.BUTTON1) {
            mouseDownBut1 = true;
        }

        else if (e.getButton() == MouseEvent.BUTTON2) {
            mouseDownBut2 = true;
        }
    }

    public void mouseReleased(MouseEvent e) {
        if (e.getButton() == MouseEvent.BUTTON1) {
            mouseDownBut1 = false;
        }
        else if (e.getButton() == MouseEvent.BUTTON2) {
            mouseDownBut2 = false;
        }
    }

    /*A mouse listener class that responds to the clicking of both buttons. If the button is pressed the boolean is set to true, if the button is released it is set to false.
     * The method is not used in my code however. */

}