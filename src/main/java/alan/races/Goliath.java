package alan.races;

import alan.Constants;
import alan.creatures.PlayableCharacter;
import alan.grid_panel.Cell;

public class Goliath extends PlayableCharacter implements RaceInterface{
    final String RACE_NAME = "Goliath";

    public Goliath(String name, String fileName) {
        super(name, fileName);
        setCreatureType("Humanoid");
        setSpeed(35);
        setSize(Constants.CREATURE_SIZE.MEDIUM);
        setRaceName(RACE_NAME);
        setSpecialFeatures();
    }

    public Goliath(String name, String fileName, Cell location) {
        super(name, fileName, location);
        setCreatureType("Humanoid");
        setSpeed(35);
        setSize(Constants.CREATURE_SIZE.MEDIUM);
        setRaceName(RACE_NAME);
        setSpecialFeatures();
    }

    /*
     * Methods
     */
    @Override
    public final void setSpecialFeatures() {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void onLevelUpRace() {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void onLongRestRace() {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void onShortRestRace() {
        // TODO Auto-generated method stub
        
    }

    /*
     * Getters & Setters
     */
    public String getRACE_NAME() {
        return RACE_NAME;
    }
    
}
