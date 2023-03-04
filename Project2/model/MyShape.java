package model;

import java.awt.Color; 
import java.awt.Graphics2D; 
import java.awt.geom.Point2D; 

public abstract class MyShape implements CollisionListener {
    
    
    private final Point2D.Double location;
    private Color color; 
    private final int size; 

    public MyShape(Point2D.Double location, Color color, int size) {

        this.location = location;
        this.color = color;
        this.size = size; 
    }

    public abstract void draw(Graphics2D g2); 

    // getters 
    public Point2D.Double getLocation() {
        return location;
    }

    public Color getColor() {
        return color;
    }

    public int getSize() {
        return size;
    }

    public void setColor(Color color){
        this.color=color;
    }

}
