package alan;

public class PlayableCharacter extends Creature{
    
    public PlayableCharacter(String name, int health, int speed, String fileName, Cell location) {
        super(name, health, speed, fileName, location);
    }
    
    public PlayableCharacter(String name, int health, int speed, String fileName) {
        super(name, health, speed, fileName);
    }

}
