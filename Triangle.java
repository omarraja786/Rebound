package Assignment2;

import java.awt.*;


public class Triangle extends Shape {

    int[] xCoords;
    int[] yCoords;
    int corner = 3;
    protected int angle;

    //Declares the variables that will be used to define the triangle shape

    public Triangle(int[] xCoords, int[] yCoords, int corner, int angle) {
        this.xCoords = xCoords;
        this.yCoords = yCoords;
        this.corner = corner;
        this.angle = angle;
        shapeList.add(this);
    }

    //Creates a constructor, and adds the object to the collection.

    public void draw(Graphics g) {
        Graphics2D triangle = (Graphics2D)g;
        triangle.rotate(Math.toDegrees(angle));
        triangle.setColor(Color.red);
        triangle.fillPolygon(xCoords,yCoords,corner);
    }


    //Draws the shape with the attributes such as rotation and setting the colour. There was no triangle fill method so I had to use a polygon which connected 3 lines
    public int getX() {
        return 0;
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

//No methods were needed.
