package alan.races;

import alan.Constants;
import alan.creatures.PlayableCharacter;
import alan.player_class.PlayerClass;
import alan.grid_panel.Cell;

public class Aasimar extends PlayableCharacter implements RaceInterface{
    final String RACE_NAME = "Aasimar";

    public Aasimar(String name, String fileName, PlayerClass primaryClass) {
        super(name, fileName, primaryClass);
        setCreatureType("Humanoid");
        setSpeed(30);
        setSize(Constants.CREATURE_SIZE.MEDIUM);
        setRaceName(RACE_NAME);
        setSpecialFeatures();
    }

    public Aasimar(String name, String fileName, Cell location, PlayerClass primaryClass) {
        super(name, fileName, location, primaryClass);
        setCreatureType("Humanoid");
        setSpeed(30);
        setSize(Constants.CREATURE_SIZE.MEDIUM);
        setRaceName(RACE_NAME);
        setSpecialFeatures();
    }

    /*
     * Methods
     */
    @Override
    public final void setSpecialFeatures() {
        // Darkvision
        setDarkVision(60);
        // Celestial Resistance
        addResistance(Constants.DAMAGE_TYPE.NECROTIC);
        addResistance(Constants.DAMAGE_TYPE.RADIANT);
        
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
