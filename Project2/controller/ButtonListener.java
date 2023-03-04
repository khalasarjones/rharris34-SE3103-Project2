package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import view.GamePanel; 

public class ButtonListener implements ActionListener{

    // This is for Pressing Buttons in the program. 
    private GamePanel panel; 

    public ButtonListener(GamePanel panel) {
        this.panel = panel; 
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton button = (JButton) e.getSource();
        //System.out.println(button.getText()); 

        if ("Add 10".equals(button.getText())) {

            panel.getCanvas().loadObstacles();
            panel.getCanvas().repaint();

        } else if ("Clear All".equals(button.getText())) {

            panel.getCanvas().resetObstaclesManager();
            panel.getCanvas().repaint();

        } else if ("Fix Car".equals(button.getText())) {

            panel.getCanvas().fixCar();
            panel.getCanvas().repaint();
            
        } else
            System.out.println("Invalid button"); 
    }
}
