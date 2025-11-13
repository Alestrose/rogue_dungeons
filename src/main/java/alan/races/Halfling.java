package alan.races;

import alan.Constants;
import alan.creatures.PlayableCharacter;
import alan.player_class.PlayerClass;
import alan.grid_panel.Cell;

public class Halfling extends PlayableCharacter implements RaceInterface{
    final String RACE_NAME = "Halfling";

    public Halfling(String name, String fileName, PlayerClass primaryClass) {
        super(name, fileName, primaryClass);
        setCreatureType("Humanoid");
        setSpeed(30);
        setSize(Constants.CREATURE_SIZE.SMALL);
        setRaceName(RACE_NAME);
        setSpecialFeatures();
    }

    public Halfling(String name, String fileName, Cell location, PlayerClass primaryClass) {
        super(name, fileName, location, primaryClass);
        setCreatureType("Humanoid");
        setSpeed(30);
        setSize(Constants.CREATURE_SIZE.SMALL);
        setRaceName(RACE_NAME);
        setSpecialFeatures();
    }

    /*
     * Methods
     */
    @Override
    public final void setSpecialFeatures() {
        // Brave
        grantConditionAdvantage(Constants.CONDITION_KEY.FRIGHTENED);
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
