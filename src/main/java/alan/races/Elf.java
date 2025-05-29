package alan.races;

import alan.creatures.PlayableCharacter;
import alan.grid_panel.Cell;

public class Elf extends PlayableCharacter implements RaceInterface{
    final String RACE_NAME = "Elf";

    public Elf(String name, String fileName) {
        super(name, fileName);
        setCreatureType("Humanoid");
        setSpeed(30);
        setSize("Medium");
    }

    public Elf(String name, String fileName, Cell location) {
        super(name, fileName, location);
        setCreatureType("Humanoid");
        setSpeed(30);
        setSize("Medium");
    }

    /*
     * Methods
     */
    @Override
    public void setSpecialFeatures() {
        // Darkvision
        setDarkVision(60);
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void onLevelUpRace(){

    }

    /*
     * Getters & Setters
     */
    public String getRACE_NAME() {
        return RACE_NAME;
    }

    
    
    
}
