import javax.swing.JFrame;

import view.*;

public class Main {


     public static void main(String[] args) {

        JFrame window = new JFrame();
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setLocation(500, 100);
        window.setTitle("Project 2 - Car Collision"); 

        GamePanel windowGamePanel = new GamePanel(window);

        windowGamePanel.init();
        window.pack();
        window.setVisible(true);
    }
}