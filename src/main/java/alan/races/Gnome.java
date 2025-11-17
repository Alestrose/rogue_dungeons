package alan.races;

import alan.Constants;
import alan.creatures.PlayableCharacter;
import alan.player_class.PlayerClass;
import alan.grid_panel.Cell;

public class Gnome extends PlayableCharacter implements RaceInterface{
    final String RACE_NAME = "Gnome";
    public enum GNOMISH_LINEAGE {FOREST, ROCK};
    GNOMISH_LINEAGE lineage;

    public Gnome(String name, String fileName, PlayerClass primaryClass, Constants.ABILITY spellCastAbility, GNOMISH_LINEAGE lineage) {
        super(name, fileName, primaryClass);
        setCreatureType("Humanoid");
        setSpeed(30);
        setSize(Constants.CREATURE_SIZE.SMALL);
        setRaceName(RACE_NAME);
        setSpellCastAbility(spellCastAbility);
        this.lineage = lineage;
        setSpecialFeatures();
    }

    public Gnome(String name, String fileName, Cell location, PlayerClass primaryClass, Constants.ABILITY spellCastAbility, GNOMISH_LINEAGE lineage) {
        super(name, fileName, location, primaryClass);
        setCreatureType("Humanoid");
        setSpeed(30);
        setSize(Constants.CREATURE_SIZE.SMALL);
        setRaceName(RACE_NAME);
        setSpellCastAbility(spellCastAbility);
        this.lineage = lineage;
        setSpecialFeatures();
    }

    /*
     * Methods
     */
    @Override
    public final void setSpecialFeatures() {
        // Darkvision
        setDarkVision(60);

        // Gnomish Cunning
        grantAbilitySaveAdvantage(Constants.ABILITY.INTELLIGENCE);
        grantAbilitySaveAdvantage(Constants.ABILITY.WISDOM);
        grantAbilitySaveAdvantage(Constants.ABILITY.CHARISMA);
        
        // Gnomish Lineage
        switch (lineage) {
            case FOREST -> {// Get Minor illusion cantrip, get Speak with Animals spell
            }
            case ROCK -> {// Get Mending and Prestidigitation cantrip
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
