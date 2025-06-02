package alan.grid_panel;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import alan.creatures.Creature;

public class Cell {
    private int x,y;                    
    private int width,height;
    private boolean isOccupied = false;
    private Creature occupant;
    protected String fileName;
    protected BufferedImage image;

    @SuppressWarnings("CallToPrintStackTrace")
    public Cell(int x,int y,int width, int height, String fileName){
        if(width>=height){
            this.x = x * height;
            this.y = y * height;
            this.width = height;
            this.height = height;
            
        }else{
            this.x = x * width;
            this.y = y * width;
            this.width = width;
            this.height = width;
        }
        

        this.fileName = fileName;
        
        // Initializes image from images folder. Image selected via fileName
        File pic = new File("images/" + fileName);
        try {
            image = ImageIO.read(pic);
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("file not found");
        }
    }

    /*
     * Getters & Setters
     */
    
    public BufferedImage getImage() {
        return image;
    }

    public void setImage(BufferedImage image) {
        this.image = image;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public boolean isOccupied() {
        return isOccupied;
    }

    public void setOccupied(boolean isOccupied) {
        this.isOccupied = isOccupied;
    }

    public Creature getOccupant() {
        return occupant;
    }

    public void setOccupant(Creature occupant) {
        this.occupant = occupant;
    }

    
    
    
}
