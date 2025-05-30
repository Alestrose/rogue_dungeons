package alan.races;

import alan.Constants;
import alan.creatures.PlayableCharacter;
import alan.grid_panel.Cell;

public class Dragonborn extends PlayableCharacter implements RaceInterface{
    final String RACE_NAME = "Dragonborn";
    public enum DRACONIC_ANCESTRY {BLACK, BLUE, BRASS, BRONZE, COPPER, GOLD, GREEN, RED, SILVER, WHITE};
    DRACONIC_ANCESTRY ancestry;

    public Dragonborn(String name, String fileName, DRACONIC_ANCESTRY ancestry) {
        super(name, fileName);
        setCreatureType("Humanoid");
        setSpeed(30);
        setSize(Constants.CREATURE_SIZE.MEDIUM);
        setRaceName(RACE_NAME);
        this.ancestry = ancestry;
        setSpecialFeatures();
    }

    public Dragonborn(String name, String fileName, Cell location, DRACONIC_ANCESTRY ancestry) {
        super(name, fileName, location);
        setCreatureType("Humanoid");
        setSpeed(30);
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
        // Darkvision
        setDarkVision(60);

        // Draconic Acestry
        switch (ancestry) {
            case BLACK: grantResistance(Constants.DAMAGE_TYPE.ACID); break;
            case BLUE: grantResistance(Constants.DAMAGE_TYPE.LIGHTNING); break;
            case BRASS: grantResistance(Constants.DAMAGE_TYPE.FIRE); break;
            case BRONZE: grantResistance(Constants.DAMAGE_TYPE.LIGHTNING); break;
            case COPPER: grantResistance(Constants.DAMAGE_TYPE.ACID); break;
            case GOLD: grantResistance(Constants.DAMAGE_TYPE.FIRE); break;
            case GREEN: grantResistance(Constants.DAMAGE_TYPE.POISON); break;
            case RED: grantResistance(Constants.DAMAGE_TYPE.FIRE); break;
            case SILVER: grantResistance(Constants.DAMAGE_TYPE.ICE); break;
            case WHITE: grantResistance(Constants.DAMAGE_TYPE.ICE); break;
            default:
                throw new AssertionError();
        }
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
