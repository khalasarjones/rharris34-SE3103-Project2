package model;
import java.awt.Font;
import java.awt.Color;
import java.awt.Graphics2D;

public class GameOver implements ViewControllerListener{
    
    
    private static Font serifFont = new Font("Serif", Font.BOLD, 24);
    final Color normalColor = Color.YELLOW;
    private boolean hasGameOver = false;

    public void setGameOver(boolean hasGameOver){
        this.hasGameOver=hasGameOver;
    }

    @Override
    public void render(Graphics2D g2) {

        if (hasGameOver) {
            g2.setColor(normalColor);
            g2.setFont(serifFont);
            g2.drawString("Game Over", 600/2, 700/2);
        }
    }
}
