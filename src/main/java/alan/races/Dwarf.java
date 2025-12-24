package alan.races;

import alan.Constants;
import alan.creatures.PlayableCharacter;
import alan.player_class.PlayerClass;
import alan.grid_panel.Cell;

public class Dwarf extends PlayableCharacter implements RaceInterface{
    final String RACE_NAME = "Dwarf";

    public Dwarf(String name, String fileName, PlayerClass primaryClass) {
        super(name, fileName, primaryClass);
        setCreatureType("Humanoid");
        setSpeed(30);
        setSize(Constants.CREATURE_SIZE.MEDIUM);
        setRaceName(RACE_NAME);
        setSpecialFeatures();
        // Dwarven Toughness
        setMaxHealth(getMaxHealth()+1);
    }

    public Dwarf(String name, String fileName, Cell location, PlayerClass primaryClass) {
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
        setDarkVision(120);
        //Dwarven Resilience
        addResistance(Constants.DAMAGE_TYPE.POISON);
        grantConditionAdvantage(Constants.CONDITION_KEY.POISONED);
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
