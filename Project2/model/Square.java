package model;



import java.awt.Color; 
import java.awt.Graphics2D; 
import java.awt.geom.Rectangle2D; 
import java.awt.geom.Point2D; 


public class Square extends MyShape {
    
    public Square(int x, int y, Color color, int size) {
        super(new Point2D.Double(x, y), color, size);
    }

    @Override
    public void draw(Graphics2D g2) {
        g2.setColor(getColor());
        int size = getSize();
        double x = getLocation().x - size / 2; 
        double y = getLocation().y - size / 2; 
        g2.fill(new Rectangle2D.Double(x, y, size, size));
    }

    @Override
    public Rectangle2D.Double getCollisionBox() {
        double size = getSize() * 0.9;
        double x = getLocation().x - size / 2;
        double y = getLocation().y - size / 2; 
        return new Rectangle2D.Double(x, y, size, size); 
    }
}

