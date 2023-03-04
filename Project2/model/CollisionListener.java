package model;

import java.awt.geom.Rectangle2D; 

public interface CollisionListener {
    
    Rectangle2D.Double getCollisionBox(); 
}
