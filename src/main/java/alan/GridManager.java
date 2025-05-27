package alan;

import java.awt.Graphics2D;

import javax.swing.JPanel;
public class GridManager {

    /*
     * This class is where all game assets are added and their positons. ie. basket, falling eggs, score tracker etc.
     * 
     */
    
    /*
     * Create instance of your class here
     */
    Grid grid;


    /*
     * Executed by GamePanel
     */
    public GridManager(){
        start();
    }
    

    /*
     * Initialize classes to be rendered here
     */
    private void start(){
        grid = new Grid(10, 10);
    }

    /*
     * Renders images to panel
     * Implement graphics.drawImage(image, int x position, int y position, int wifth, int height, panel); to render an image to the panel
     */
    public void drawSprites(Graphics2D graphics, JPanel panel){
        //Draw Basket
        //graphics.drawImage(basket.getImage(), basket.getX(), basket.getY(), basket.getWidth(), basket.getHeight(), panel);
        
        grid.drawGrid(grid, graphics, panel);


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
