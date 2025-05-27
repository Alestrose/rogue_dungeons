package alan;

import java.awt.Graphics2D;

import javax.swing.JPanel;

public class GameManager {
    
    /*
     * This class is where all game assets are added and their positons. ie. basket, falling eggs, score tracker etc.
     * 
     */
    
    /*
     * Create instance of your class here
     */
    PlayableCharacter pc; 


    /*
     * Executed by GamePanel
     */
    public GameManager(){
        start();
    }
    

    /*
     * Initialize classes to be rendered here
     */
    private void start(){
        pc = new PlayableCharacter("Player One", 10, 35, "Fighter.png");
    }

    /*
     * Renders images to panel
     * Implement graphics.drawImage(image, int x position, int y position, int wifth, int height, panel); to render an image to the panel
     */
    public void drawSprites(Graphics2D graphics, JPanel panel){
        //Draw Basket
        //graphics.drawImage(basket.getImage(), basket.getX(), basket.getY(), basket.getWidth(), basket.getHeight(), panel);
    }

    /*
     * Implement class methods to run each frame here
     * basket.move();
     * egg.spawn();
     * etc.
     */
    public void update(){
        
    }
}
