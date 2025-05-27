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
    PartyPlayers partyPlayers;

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
        grid = Grid.getInstance(10, 10);
        partyPlayers = PartyPlayers.getInstance();
        partyPlayers.addPlayers();


        // pc = new PlayableCharacter("Player One", 10, 35, "Fighter1.png", grid.getCellArray()[4][9]);
    }

    /*
     * Renders images to panel
     * Implement graphics.drawImage(image, int x position, int y position, int wifth, int height, panel); to render an image to the panel
     */
    public void drawSprites(Graphics2D graphics, JPanel panel){
        grid.drawGrid(grid, graphics, panel);
        drawParty(graphics, panel);

    }

    /*
     * Implement class methods to run each frame heres
     * basket.move();
     * egg.spawn();
     * etc.
     */
    public void update(){
        
    }

    /*
     * Methods
     */
    public void drawParty(Graphics2D graphics, JPanel panel){
        for (Creature i : partyPlayers.getParty()) {
            i.drawCreature(graphics, panel);
        }
    }

}
