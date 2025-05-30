package alan.races;

import alan.Constants;
import alan.creatures.PlayableCharacter;
import alan.grid_panel.Cell;

public class Tiefling extends PlayableCharacter implements RaceInterface{
    final String RACE_NAME = "Tiefling";
    public enum FIENDISH_LEGACY {ABYSSAL, CHTHONIC, INFERNAL};
    FIENDISH_LEGACY legacy;

    public Tiefling(String name, String fileName, FIENDISH_LEGACY legacy) {
        super(name, fileName);
        setCreatureType("Humanoid");
        setSpeed(30);
        setSize(Constants.CREATURE_SIZE.MEDIUM);
        setRaceName(RACE_NAME);
        this.legacy = legacy;
        setSpecialFeatures();
    }

    public Tiefling(String name, String fileName, Cell location, FIENDISH_LEGACY legacy) {
        super(name, fileName, location);
        setCreatureType("Humanoid");
        setSpeed(30);
        setSize(Constants.CREATURE_SIZE.MEDIUM);
        setRaceName(RACE_NAME);
        this.legacy = legacy;
        setSpecialFeatures();
    }

    /*
     * Methods
     */
    @Override
    public final void setSpecialFeatures() {
        // Darkvision
        setDarkVision(60);
        //Fiendish Legacy
        switch (legacy) {
            case ABYSSAL -> {// get Poison Spray cantrip
                grantResistance(Constants.DAMAGE_TYPE.POISON);
            }
            case CHTHONIC -> {// get Chill Touch cantrip
                grantResistance(Constants.DAMAGE_TYPE.NECROTIC);
            }
            case INFERNAL -> {// get Fire Bolt cantrip
                grantResistance(Constants.DAMAGE_TYPE.FIRE);
            }
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
