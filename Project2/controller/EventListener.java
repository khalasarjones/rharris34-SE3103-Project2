package controller;

import java.awt.event.KeyListener;

import view.GamePanel;

import java.awt.event.KeyEvent; 

public class EventListener implements KeyListener,CarControllerListener {

    // EventListener is for moving the car around with Arrow Keys
    public static final int MOVEMENT = 5; 
    private GamePanel panel; 


    public EventListener(GamePanel panel) {
        this.panel = panel; 
    }
    
    // Moves the Car made of Shapes with the Arrow Keys
    @Override
    public void keyPressed(KeyEvent e) {

        var key = e.getKeyCode();
        switch (key) {
            case KeyEvent.VK_LEFT:
                moveBackward();
                break;
            case KeyEvent.VK_RIGHT:
               moveForward();
                break; 
            case KeyEvent.VK_UP:
               moveUpward();
                break; 
            case KeyEvent.VK_DOWN:
                moveDownward();
                break; 
        }
        panel.getCanvas().repaint();

    }


    @Override
    public void keyTyped(KeyEvent e) {
    
    }


    @Override
    public void keyReleased(KeyEvent e) {
    
    }


    @Override
    public void moveForward() {
        panel.getMyCar().moveForward();
        panel.getCanvas().checkCollisionOccurrences();
    }


    @Override
    public void moveBackward() {
        panel.getMyCar().moveBackward();
        panel.getCanvas().checkCollisionOccurrences();
    }


    @Override
    public void moveUpward() {
        panel.getMyCar().moveUpward();
        panel.getCanvas().checkCollisionOccurrences();
    }


    @Override
    public void moveDownward() {
        panel.getMyCar().moveDownward();
        panel.getCanvas().checkCollisionOccurrences();
    }
    
}
