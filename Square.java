package Assignment2;

import java.awt.*;


public class Square extends Shape {

    protected int length;
    protected int width;
    protected int x;
    protected int y;
    protected int angle;

    //Declares the variables that will be used to define the square shape

    public Square(int x, int y, int width, int length, int angle) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.length = length;
        this.angle = angle;
        shapeList.add(this);
    }

    //Creates a constructer that will refer the object to each of the variables and adds the the object to the collection list.


    public void draw(Graphics g) {
        Graphics2D square = (Graphics2D)g;
        square.rotate(Math.toDegrees(angle));
        square.setColor(Color.green);
        square.fillRect(x,y,width,length);
    }


    //Creates a draw method that allows the user to draw the square shape, rotate it and set the colour.

    public int getX() {
        return x;
    }
    public int incrementX() {
        return 0;
    }
    public int decrementX() {
        return 0;
    }
    public int ballX() {return 0;}
    public int ballY() {return 0;}
    public int getY() {
        return 0;
    }
    public boolean intersects(Rectangle a) {return false;}
}

    //Any getter/setter methods are defined here, but since square isn't used in my game; I didn't add any other functions to the other methods.