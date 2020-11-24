package Assignment2;

import javafx.collections.transformation.SortedList;

import java.awt.*;
import java.util.*;
import java.util.List;



public abstract class Shape {
    protected List<Shape> shapeList = new ArrayList<>();
    public abstract void draw(Graphics g);
    public abstract int getX();
    public abstract int getY();
    public abstract int incrementX();
    public abstract int decrementX();
    public abstract int ballX();
    public abstract int ballY();
    public void setX(int x) {
        setX(x);
    }
    public void setY(int y) {
        setX(y);
    }
    public abstract boolean intersects(Rectangle b);
}

/*Creates an abstract class and instantiates any methods are to be used in the classes that extend the shape. Also created a list which is the collection
 * that all the shapes will be stored in. */