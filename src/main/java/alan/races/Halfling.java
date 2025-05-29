package alan.races;

import alan.creatures.PlayableCharacter;
import alan.grid_panel.Cell;

public class Halfling extends PlayableCharacter implements RaceInterface{
    final String RACE_NAME = "Halfling";

    public Halfling(String name, String fileName) {
        super(name, fileName);
        setCreatureType("Humanoid");
        setSpeed(30);
        setSize("Small");
        setRaceName(RACE_NAME);
        setSpecialFeatures();
    }

    public Halfling(String name, String fileName, Cell location) {
        super(name, fileName, location);
        setCreatureType("Humanoid");
        setSpeed(30);
        setSize("Small");
        setRaceName(RACE_NAME);
        setSpecialFeatures();
    }

    /*
     * Methods
     */
    @Override
    public final void setSpecialFeatures() {
        
    }

    @Override
    public void onLevelUpRace(){

    }

    @Override
    public void onShortRestRace() {
        
    }

    @Override
    public void onLongRestRace() {

    }

    /*
     * Getters & Setters
     */
    public String getRACE_NAME() {
        return RACE_NAME;
    }
}
