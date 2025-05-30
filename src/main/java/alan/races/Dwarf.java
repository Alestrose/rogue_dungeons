package alan.races;

import alan.Constants;
import alan.creatures.PlayableCharacter;
import alan.grid_panel.Cell;

public class Dwarf extends PlayableCharacter implements RaceInterface{
    final String RACE_NAME = "Dwarf";

    public Dwarf(String name, String fileName) {
        super(name, fileName);
        setCreatureType("Humanoid");
        setSpeed(30);
        setSize(Constants.CREATURE_SIZE.MEDIUM);
        setRaceName(RACE_NAME);
        setSpecialFeatures();
        // Dwarven Toughness
        setMaxHealth(getMaxHealth()+1);
    }

    public Dwarf(String name, String fileName, Cell location) {
        super(name, fileName, location);
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
        setDarkVision(120);
        //Dwarven Resilience
        grantResistance(Constants.DAMAGE_TYPE.POISON);
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void onLevelUpRace(){
        // Dwarven Toughness
        setMaxHealth(getMaxHealth()+1);
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
