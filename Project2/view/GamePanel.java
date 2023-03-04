package view;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame; 
import javax.swing.JPanel;
import controller.ButtonListener;
import controller.EventListener;
import model.MyCar; 

public class GamePanel {

    private JFrame window; 
    private Canvas canvas;
    private JButton addTenButton = new JButton("Add 10");
    private JButton clearAllButton = new JButton("Clear All");
    private JButton fixCarButton = new JButton("Fix Car");

   public GamePanel(JFrame window) {
        this.window = window;
   }

   public void init() {
        Container cp = window.getContentPane();

        canvas = new Canvas(this);
        cp.add(BorderLayout.CENTER, canvas); 

        JPanel southPanel = new JPanel();
        cp.add(BorderLayout.SOUTH, southPanel);
        southPanel.setPreferredSize(new Dimension(200, 50));
        southPanel.setLayout(new GridLayout(1, 1));
      
        ButtonListener buttonListener = new ButtonListener(this);
        EventListener eventListener = new EventListener(this);

        window.addKeyListener(eventListener);

        addTenButton.setFocusable(false);
        clearAllButton.setFocusable(false);
        fixCarButton.setFocusable(false);


        addTenButton.addActionListener(buttonListener);
        clearAllButton.addActionListener(buttonListener);
        fixCarButton.addActionListener(buttonListener);

        southPanel.add(addTenButton);
        southPanel.add(clearAllButton);
        southPanel.add(fixCarButton);

   }

   public JFrame getWindow() {
       return window;
   }

   public Canvas getCanvas() {
       return canvas;
   }

   public JButton getAddTenButton() {
       return addTenButton;
   }

   public JButton getClearAllButton() {
       return clearAllButton;
   }

   public JButton getFixCarButton() {
       return fixCarButton;
   }

   public MyCar getMyCar(){
        return getCanvas().getMyCar();
   }

   public void refreshPanel(){
    canvas.repaint();
   }

}
