package alan.races;

import alan.creatures.PlayableCharacter;
import alan.grid_panel.Cell;

public class Human extends  PlayableCharacter implements RaceInterface{
    final String RACE_NAME = "Human";

    public Human(String name, String fileName, Cell location) {
        super(name, fileName, location);
        setCreatureType("Humanoid");
        setSpeed(30);
        setSize("Medium");
        setRaceName(RACE_NAME);
    }

    public Human(String name, String fileName) {
        super(name, fileName);
        setCreatureType("Humanoid");
        setSpeed(30);
        setSize("Medium");
        setRaceName(RACE_NAME);
    }

    /*
     * Methods
     */
    @Override
    public void setSpecialFeatures() {
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
