package Assignment2;

import org.w3c.dom.css.Rect;

import java.awt.*;


public class Rectangle extends Shape {

    protected int length;
    protected int width;
    protected int x;
    protected int y;
    protected int angle;
    //Declares the variables that will be used to define the rectangle shape

    public Rectangle(int x, int y, int width, int length, int angle) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.length = length;
        this.angle = angle;
        shapeList.add(this);
    }

    //Creates a constructer that will refer the object to each of the variables and adds the the object to the collection list.

    public boolean intersects(Rectangle r) {    //Uses intersect method defined for the java.awt.rectangle class
        int tw = this.width;
        int th = this.length;
        int rw = r.width;
        int rh = r.length;
        if (rw <= 0 || rh <= 0 || tw <= 0 || th <= 0) {
            return false;
        }
        int tx = this.x;
        int ty = this.y;
        int rx = r.x;
        int ry = r.y;
        rw += rx;
        rh += ry;
        tw += tx;
        th += ty;
        //      overflow || intersect
        return ((rw < rx || rw > tx) &&
                (rh < ry || rh > ty) &&
                (tw < tx || tw > rx) &&
                (th < ty || th > ry));
    }

    // This method was defined within the java rectangle class, but since my rectangle was an object I needed to use this method to know when two objects intersect.


    public void setX(int value){
        this.x = value;
    }

    public int getX(){
        return x;
    }

    public int incrementX(){
        x+=20;
        return x;
    }

    //Creates an increment method that chnages the x position of the rectangle by 20

    public int decrementX(){
        x-=20;
        return x;
    }

    //Decrement method that moves the object to the left by 20.

    public int ballX() {return 0;}
    public int ballY() {return 0;}
    public int getY() {
        return y;
    }
    public void setY(int value){
        this.y = value;
    }

    //Setter and getter methods


    public void draw(Graphics g) {
        Graphics2D rectangle = (Graphics2D)g;
        rectangle.rotate(Math.toDegrees(angle));
        rectangle.setColor(Color.cyan);
        rectangle.fillRect(x,y,width,length);

        //Draws the rectangle, fills it, and can also rotate it.
    }
}
