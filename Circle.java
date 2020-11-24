package Assignment2;

import java.awt.*;


public class Circle extends Shape {

    protected int centreX;
    protected int centreY;
    protected int radius;
    protected int angle;

    //Declares the variables that will be used to define the circle shape

    public Circle(int centreX, int centreY, int radius, int angle) {
        this.centreX = centreX;
        this.centreY = centreY;
        this.radius = radius;
        this.angle = angle;
        shapeList.add(this);
    }

    //Creates a constructer that will refer the object to each of the variables and adds the the object to the collection list.

    public void draw(Graphics g) {
        Graphics2D circle = (Graphics2D)g;
        circle.rotate(Math.toDegrees(angle));
        circle.setColor(Color.green);
        circle.fillOval(centreX,centreY,radius,radius);

    }

    //Creates a draw method that allows the user to draw a circle, rotate it and set the colour.

    public int incrementX() {
        return 0;
    }
    public int decrementX() {return 0;}
    public int getX() {
        return centreX;
    }
    public int getY() {
        return centreY;
    }
    public void setX(int value){
        this.centreX = value;
    }
    public void setY(int value){
        this.centreY = value;
    }
    public boolean intersects(Rectangle a) {return false;}

    public int ballX() {
        centreX+=GameView.ballDirX;
        return centreX;
    }


    public int ballY() {
        centreY+=GameView.ballDirY;
        return centreY;
    }

    /*Since the class is abstract I need to add the methods that are defined in the shape class since it extends it, but only some need to be used such as returning
     * the value of the x coordinates, and setting the value for updating. The methods that are not needed return 0 or false.
      *
      * BallX and BallY allow the direction of the ball to be changed and returns the new centre coordinate of the circle.*/


}
