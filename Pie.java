package Assignment2;

import java.awt.*;


public class Pie extends Shape {

    protected int x;
    protected int y;
    protected int length;
    protected int width;
    protected int firstAngle;
    protected int secondAngle;
    protected int rotationAngle;
    //Declares the variables that will be used to define the pie shape

    public Pie(int x, int y, int width, int length, int firstAngle, int secondAngle,int rotationAngle) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.length = length;
        this.firstAngle = firstAngle;
        this.secondAngle = secondAngle;
        this.rotationAngle = rotationAngle;
        shapeList.add(this);
    }

    //Creates a constructer that will refer the object to each of the variables and adds the the object to the collection list.

    public void draw(Graphics g) {
        Graphics2D pie = (Graphics2D)g;
        pie.rotate(Math.toDegrees(rotationAngle));
        pie.setColor(Color.darkGray);
        pie.fillArc(x,y,width,length,secondAngle,firstAngle);

    }

    //Creates a draw method that allows the user to draw the pie shape, rotate it and set the colour.

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

//No methods were needed for the pie shape, but I added the getter method just incase it is required in the program.
