package alan;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public abstract class Creature {
    private String name;
    private int health;
    private int speed;
    private int x,y;
    private int width, height;
    protected  String fileName;
    protected  BufferedImage image;
    private Cell location;

    // No Cell location Constructor
    public Creature(String name, int health, int speed, String fileName){
        this.name = name;
        this.health = health;
        this.speed = speed;
        this.fileName = fileName;
        
        // Initializes image from images folder. Image selected via fileName
        File pic = new File("images/" + fileName);
        try {
            image = ImageIO.read(pic);
        } catch (IOException e) {
            System.out.println("file not found");
        }
    }

    // Specified Cell location constructor
    public Creature(String name, int health, int speed, String fileName, Cell location){
        this.name = name;
        this.health = health;
        this.speed = speed;
        this.fileName = fileName;
        this.location = location;
        this.x = location.getX();
        this.y = location.getY();
        this.width = location.getWidth();
        this.height = location.getHeight();
        
        // Initializes image from images folder. Image selected via fileName
        File pic = new File("images/" + fileName);
        try {
            image = ImageIO.read(pic);
        } catch (IOException e) {
            System.out.println("file not found");
        }
    }

    /*
     * Methods
     */

    public void move(){

    }

    // For use in "GameManager.drawSprites()"
    public void drawCreature(Graphics2D graphics, JPanel panel){
        graphics.drawImage(getImage(), getX(), getY(), getWidth(), getHeight(), panel);
    }
    

    /*
     * Getters & Setters
     */

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
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

    public BufferedImage getImage() {
        return image;
    }

    public void setImage(BufferedImage image) {
        this.image = image;
    }

    public Cell getLocation() {
        return location;
    }

    public void setLocation(Cell location) {
        this.location = location;
        this.x = location.getX();
        this.y = location.getY();
        this.width = location.getWidth();
        this.height = location.getHeight();
    }

    

    






}




