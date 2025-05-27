package alan;

public class PlayableCharacter extends Creature{
    
    public PlayableCharacter(String name, int health, int speed, String fileName, String playerClass, String playerRace) {
        super(name, health, speed, fileName, playerClass, playerRace);
    }
    
    public PlayableCharacter(String name, int health, int speed, String fileName, Cell location, String playerClass, String playerRace) {
        super(name, health, speed, fileName, location, playerClass, playerRace);

    }
    
    

    
    /*
     * Getters & Setters
     */
    

}
