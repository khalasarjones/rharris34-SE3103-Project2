package obstacle;

import java.util.ArrayList;

import model.Circle;
import model.Square;
import model.ViewControllerListener;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D.Double;

public class ObstacleManager implements ViewControllerListener{
    

    ArrayList<Obstacle> obstacle;

    final Color circleColor = Color.blue;
    final Color squareColor = Color.green;
    int nObstacle = 0; 

    public ObstacleManager() {
        obstacle=new ArrayList<>();
    }

    public void loadTestCollision(){
        Obstacle obstacleItem=new Obstacle();
        
        obstacleItem.circle= new Circle(200, 15, circleColor, 20);
        obstacleItem.square= new Square(400, 300, squareColor, 20);
        //obstacle.add(obstacleItem);
        nObstacle++;
    }
    public void loadObstacles() {

        Obstacle obstacleItem=new Obstacle();
        
        obstacleItem.circle= new Circle(getRandomLocationX(), getRandomLocationY(), circleColor, 20);
        obstacleItem.square= new Square(getRandomLocationX(), getRandomLocationY(), squareColor, 20);
        obstacle.add(obstacleItem);

        Obstacle obstacleItem1 = new Obstacle();
        obstacleItem1.circle= new Circle(getRandomLocationX(), getRandomLocationY(), circleColor, 20);
        obstacleItem1.square= new Square(getRandomLocationX(), getRandomLocationY(), squareColor, 20);
        obstacle.add(obstacleItem1);

        Obstacle obstacleItem2 = new Obstacle();
        obstacleItem2.circle= new Circle(getRandomLocationX(), getRandomLocationY(), circleColor, 20);
        obstacleItem2.square= new Square(getRandomLocationX(), getRandomLocationY(), squareColor, 20);
        obstacle.add(obstacleItem2);

        Obstacle obstacleItem3 = new Obstacle();
        obstacleItem3.circle = new Circle(getRandomLocationX(), getRandomLocationY(), circleColor, 20);
        obstacleItem3.square = new Square(getRandomLocationX(), getRandomLocationY(), squareColor, 20);
        obstacle.add(obstacleItem3);

        Obstacle obstacleItem4 = new Obstacle();
        obstacleItem4.circle= new Circle(getRandomLocationX(), getRandomLocationY(), circleColor, 20);
        obstacleItem4.square= new Square(getRandomLocationX(), getRandomLocationY(), squareColor, 20);
        obstacle.add(obstacleItem4);

        nObstacle = nObstacle + 5;

    }

    public void clearAll(){
        obstacle=new ArrayList<>();
        nObstacle=0;
    }

    @Override
    public void render(Graphics2D g2) {

        for (int i=0; i<obstacle.size();i++) {
            if(obstacle.get(i).collisionCircle==false)
                obstacle.get(i).circle.draw(g2);

            if (obstacle.get(i).collisionSquare==false)
                obstacle.get(i).square.draw(g2);
        }
        
    }

    public int getRandomLocationX() {
        int min=15;
        int max=700;
        return (int)(Math.random() * (max-min+1) + min);
    }
    public int getRandomLocationY() {
        int min=20;
        int max=570;
        return (int)(Math.random()*(max-min+1) + min);
    }

    public boolean checkCollisionOccur(Double collisionBox) {

        boolean isCollide = false;

        for (int i=0; i<obstacle.size(); i++) {

            if (!obstacle.get(i).collisionCircle) {

                if (hasSameLocation(collisionBox,obstacle.get(i).circle.getCollisionBox())) {
                    obstacle.get(i).collisionCircle=true;
                    isCollide=true;
                    return isCollide;
                }
            }
            if (!obstacle.get(i).collisionSquare) {

                if (hasSameLocation(collisionBox,obstacle.get(i).square.getCollisionBox())){
                    obstacle.get(i).collisionSquare=true;
                    isCollide = true;
                    return isCollide;
                }
            }
        }
        
        return isCollide;
    }


    public boolean hasSameLocation(Double carBox, Double objectBox) {
        if (carBox.intersects(objectBox))
            return true;
        else 
            return false;
    }
}