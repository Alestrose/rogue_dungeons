package alan.races;

import alan.Constants;
import alan.creatures.PlayableCharacter;
import alan.grid_panel.Cell;

public class Goliath extends PlayableCharacter implements RaceInterface{
    final String RACE_NAME = "Goliath";
    public enum GIANT_ANCESTRY {CLOUD_GIANT, FIRE_GIANT, FROST_GIANT, HILL_GIANT, STONE_GIANT, STORM_GIANT};
    GIANT_ANCESTRY ancestry;

    public Goliath(String name, String fileName, GIANT_ANCESTRY ancestry) {
        super(name, fileName);
        setCreatureType("Humanoid");
        setSpeed(35);
        setSize(Constants.CREATURE_SIZE.MEDIUM);
        setRaceName(RACE_NAME);
        this.ancestry = ancestry;
        setSpecialFeatures();
    }

    public Goliath(String name, String fileName, Cell location, GIANT_ANCESTRY ancestry) {
        super(name, fileName, location);
        setCreatureType("Humanoid");
        setSpeed(35);
        setSize(Constants.CREATURE_SIZE.MEDIUM);
        setRaceName(RACE_NAME);
        this.ancestry = ancestry;
        setSpecialFeatures();
    }

    /*
     * Methods
     */
    @Override
    public final void setSpecialFeatures() {
        // Powerful Build
        grantConditionAdvantage(Constants.CONDITION_KEY.GRAPPLED);
        // Giant Ancestry
        switch (ancestry) {
            case CLOUD_GIANT -> {// 
            }
            case FIRE_GIANT -> {// 
            }
            case FROST_GIANT -> {// 
            }
            case HILL_GIANT -> {// 
            }
            case STONE_GIANT -> {// 
            }
            case STORM_GIANT -> {// 
            }
            default -> throw new AssertionError();
        }
        
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
