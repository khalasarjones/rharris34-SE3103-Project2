package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics; 
import java.awt.Graphics2D; 
 

import javax.swing.JPanel;

import model.GameOver;
import model.MyCar;
import obstacle.ObstacleManager;


public class Canvas extends JPanel{
    
    private GamePanel panel; 

    private MyCar car;
    ObstacleManager obstacleManager;

    private int selectIndex = -1;  // car starts at top right corner of canvas 

    private GameOver gameOver;

    public Canvas(GamePanel panel) {
        this.panel = panel;
        car=new MyCar();
        gameOver=new GameOver();
        obstacleManager=new ObstacleManager();
        obstacleManager.loadTestCollision();

        setPreferredSize(new Dimension(700, 600));
        setBackground(Color.BLACK);
    }

    @Override
    public void paintComponent(Graphics g) {

        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g; 

        car.render(g2);
        obstacleManager.render(g2);
        gameOver.render(g2);
    }

    public int getSelectIndex() {
        return selectIndex;
    }

    // fixCar Method
    public void fixCar(){
        car=new MyCar();
        gameOver.setGameOver(false);
    }
    

    public void resetObstaclesManager(){
        obstacleManager=new ObstacleManager();
        gameOver.setGameOver(false);
    }
    public void loadObstacles(){
        obstacleManager.loadObstacles();
    }


    public void checkCollisionOccurrences(){
    
        if(car.isTopBodyHitted<2){
            if(obstacleManager.checkCollisionOccur(car.getTopBody().getCollisionBox())){
                car.hitTopBody();
            }
        }

        if(car.isbottomBodyRearHitted<2){
            if(obstacleManager.checkCollisionOccur(car.getBottomBodyRear().getCollisionBox())){
                car.hitBottomBodyRear();
            }
        }

        if(car.isBottomBodyFrontHitted<2){
            if(obstacleManager.checkCollisionOccur(car.getBottomBodyFront().getCollisionBox())){
                car.hitBottomBodyFront();
            } 
        }

        if(car.isFrontTireHitted<2){
            if(obstacleManager.checkCollisionOccur(car.getFrontTire().getCollisionBox())){
                car.hitFrontTire();
            } 
        }

        if(car.isRearTireHitted<2){
            if(obstacleManager.checkCollisionOccur(car.getRearTire().getCollisionBox())){
                car.hitRearTire();
            } 
        }        

        if(car.hasCarDestroyed()){
            gameOver.setGameOver(true);
        }
        repaint();
    }


    public MyCar getMyCar() {
        return this.car;
    }
}
