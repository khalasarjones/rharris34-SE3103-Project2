package model;

import java.awt.Color;
import java.awt.Graphics2D;

import controller.CarControllerListener;

public class MyCar implements CarControllerListener,ViewControllerListener {
    
    Circle frontTire;
    Circle rearTire;
    Square bottomBodyFront;
    Square bottomBodyRear; 
    Square topBody;
    
    public int isTopBodyHitted = 0;
    public int isFrontTireHitted = 0;
    public int isRearTireHitted = 0;
    public int isBottomBodyFrontHitted = 0;
    public int isbottomBodyRearHitted = 0;
    

    final Color normalColor = Color.YELLOW;
    final Color brokenColor = Color.RED; 
    final Color hideColor = Color.BLACK;

    private final int DISTANCE = 10; // at each arrow key press 

    public MyCar() {
        topBody = new Square(30, 15, normalColor, 30);
        bottomBodyRear = new Square(15, 45, normalColor, 30);
        rearTire = new Circle(15, 70, normalColor, 20);

        bottomBodyFront = new Square(45, 45, normalColor, 30);
        frontTire = new Circle(45, 70, normalColor, 20);

        initHitted();
    }

    private void initHitted(){
        isTopBodyHitted = 0;
        isFrontTireHitted = 0;
        isRearTireHitted = 0;
        isBottomBodyFrontHitted = 0;
        isbottomBodyRearHitted = 0;
    }


    public int getDISTANCE() {
        return DISTANCE;
    }

    public Circle getFrontTire(){
        return frontTire;
    }
    public Circle getRearTire(){
        return rearTire;
    }

    public Square getBottomBodyFront(){
        return bottomBodyFront;
    }
    public Square getBottomBodyRear(){
        return bottomBodyRear;
    }
    public Square getTopBody(){
        return topBody;
    }
    public void hitBottomBodyFront(){
        isBottomBodyFrontHitted++;
        updateColorMode();
    }
    public void hitBottomBodyRear(){
        isbottomBodyRearHitted++;
        updateColorMode();
    }
    public void hitRearTire(){
        isRearTireHitted++;
        updateColorMode();
    }
    public void hitFrontTire(){
        isFrontTireHitted++;
        updateColorMode();
    }
    public void hitTopBody(){
        isTopBodyHitted++;
        updateColorMode();
    }


    /* Check color after move the car */
    public void updateColorMode(){
        switch(isTopBodyHitted){
            case 2:
                topBody.setColor(hideColor);
                break;
            case 1:
                topBody.setColor(brokenColor);
                break;
            case 0:
                topBody.setColor(normalColor);
                break;
            default:
                topBody.setColor(hideColor);
        }

        switch(isbottomBodyRearHitted){
            case 2:
                bottomBodyRear.setColor(hideColor);
                break;
            case 1:
                bottomBodyRear.setColor(brokenColor);
                break;
            case 0:
                bottomBodyRear.setColor(normalColor);
                break;
            default:
                bottomBodyRear.setColor(hideColor);
        }

        switch(isBottomBodyFrontHitted){
            case 2:
                bottomBodyFront.setColor(hideColor);
                break;
            case 1:
                bottomBodyFront.setColor(brokenColor);
                break;
            case 0:
                bottomBodyFront.setColor(normalColor);
                break;
            default:
                bottomBodyFront.setColor(hideColor);
        }

        switch(isFrontTireHitted){
            case 2:
                frontTire.setColor(hideColor);
                break;
            case 1:
                frontTire.setColor(brokenColor);
                break;
            case 0:
                frontTire.setColor(normalColor);
                break;
            default:
                frontTire.setColor(hideColor);
        }

        switch(isRearTireHitted){
            case 2:
                rearTire.setColor(hideColor);
                break;
            case 1:
                rearTire.setColor(brokenColor);
                break;
            case 0:
                rearTire.setColor(normalColor);
                break;
            default:
                rearTire.setColor(hideColor);
        }

    }


    @Override
    public void render(Graphics2D g2) {
        topBody.draw(g2);
        bottomBodyFront.draw(g2);
        rearTire.draw(g2);
        bottomBodyRear.draw(g2);
        frontTire.draw(g2);
    }

    @Override
    public void moveForward() {
        topBody = new Square((int)topBody.getLocation().x+DISTANCE, (int)topBody.getLocation().y, normalColor, 30);
        
        bottomBodyRear = new Square((int)bottomBodyRear.getLocation().x+DISTANCE, (int)bottomBodyRear.getLocation().y, normalColor, 30);
        bottomBodyFront = new Square((int)bottomBodyFront.getLocation().x+DISTANCE, (int)bottomBodyFront.getLocation().y, normalColor, 30);
        
        rearTire = new Circle((int)rearTire.getLocation().x+DISTANCE, (int)rearTire.getLocation().y, normalColor, 20);
        frontTire = new Circle((int)frontTire.getLocation().x+DISTANCE, (int)frontTire.getLocation().y, normalColor, 20);

        updateColorMode();
    }


    @Override
    public void moveBackward() {
        topBody = new Square((int)topBody.getLocation().x-DISTANCE, (int)topBody.getLocation().y, normalColor, 30);
        
        bottomBodyRear = new Square((int)bottomBodyRear.getLocation().x-DISTANCE, (int)bottomBodyRear.getLocation().y, normalColor, 30);
        bottomBodyFront = new Square((int)bottomBodyFront.getLocation().x-DISTANCE, (int)bottomBodyFront.getLocation().y, normalColor, 30);
        
        rearTire = new Circle((int)rearTire.getLocation().x-DISTANCE, (int)rearTire.getLocation().y, normalColor, 20);
        frontTire = new Circle((int)frontTire.getLocation().x-DISTANCE, (int)frontTire.getLocation().y, normalColor, 20);
        
        updateColorMode();
    }


    @Override
    public void moveUpward() {
        topBody = new Square((int)topBody.getLocation().x, (int)topBody.getLocation().y-DISTANCE, brokenColor, 30);
        
        bottomBodyRear = new Square((int)bottomBodyRear.getLocation().x, (int)bottomBodyRear.getLocation().y-DISTANCE, normalColor, 30);
        bottomBodyFront = new Square((int)bottomBodyFront.getLocation().x, (int)bottomBodyFront.getLocation().y-DISTANCE, normalColor, 30);
        
        rearTire = new Circle((int)rearTire.getLocation().x, (int)rearTire.getLocation().y-DISTANCE, normalColor, 20);
        frontTire = new Circle((int)frontTire.getLocation().x, (int)frontTire.getLocation().y-DISTANCE, normalColor, 20);
        
        updateColorMode();
    }


    @Override
    public void moveDownward() {
        topBody = new Square((int)topBody.getLocation().x, (int)topBody.getLocation().y+DISTANCE, normalColor, 30);
        
        bottomBodyRear = new Square((int)bottomBodyRear.getLocation().x, (int)bottomBodyRear.getLocation().y+DISTANCE, normalColor, 30);
        bottomBodyFront = new Square((int)bottomBodyFront.getLocation().x, (int)bottomBodyFront.getLocation().y+DISTANCE, normalColor, 30);
        
        rearTire = new Circle((int)rearTire.getLocation().x, (int)rearTire.getLocation().y+DISTANCE, normalColor, 20);
        frontTire = new Circle((int)frontTire.getLocation().x, (int)frontTire.getLocation().y+DISTANCE, normalColor, 20);

        updateColorMode();
    }

    // This method will return the condition of car
    // If the car all part has been damaged it will return true: Game over
    public boolean hasCarDestroyed() {
        boolean gameOver = false;

        if(isBottomBodyFrontHitted>=2 && isbottomBodyRearHitted>=2 && isTopBodyHitted>=2 && isFrontTireHitted>=2 && isRearTireHitted>=2)
            gameOver=true;

        return gameOver;
    }

}
