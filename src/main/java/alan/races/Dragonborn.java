package alan.races;

import alan.Constants;
import alan.creatures.PlayableCharacter;
import alan.player_class.PlayerClass;
import alan.grid_panel.Cell;

public class Dragonborn extends PlayableCharacter implements RaceInterface{
    final String RACE_NAME = "Dragonborn";
    public enum DRACONIC_ANCESTRY {BLACK, BLUE, BRASS, BRONZE, COPPER, GOLD, GREEN, RED, SILVER, WHITE};
    DRACONIC_ANCESTRY ancestry;

    public Dragonborn(String name, String fileName, PlayerClass primaryClass, DRACONIC_ANCESTRY ancestry) {
        super(name, fileName, primaryClass);
        setCreatureType("Humanoid");
        setSpeed(30);
        setSize(Constants.CREATURE_SIZE.MEDIUM);
        setRaceName(RACE_NAME);
        this.ancestry = ancestry;
        setSpecialFeatures();
    }

    public Dragonborn(String name, String fileName, Cell location, PlayerClass primaryClass, DRACONIC_ANCESTRY ancestry) {
        super(name, fileName, location, primaryClass);
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
            case BLACK -> grantResistance(Constants.DAMAGE_TYPE.ACID);
            case BLUE -> grantResistance(Constants.DAMAGE_TYPE.LIGHTNING);
            case BRASS -> grantResistance(Constants.DAMAGE_TYPE.FIRE);
            case BRONZE -> grantResistance(Constants.DAMAGE_TYPE.LIGHTNING);
            case COPPER -> grantResistance(Constants.DAMAGE_TYPE.ACID);
            case GOLD -> grantResistance(Constants.DAMAGE_TYPE.FIRE);
            case GREEN -> grantResistance(Constants.DAMAGE_TYPE.POISON);
            case RED -> grantResistance(Constants.DAMAGE_TYPE.FIRE);
            case SILVER -> grantResistance(Constants.DAMAGE_TYPE.ICE);
            case WHITE -> grantResistance(Constants.DAMAGE_TYPE.ICE);
            default -> throw new AssertionError();
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
