package alan.races;

import alan.Constants;
import alan.creatures.PlayableCharacter;
import alan.grid_panel.Cell;

public class Gnome extends PlayableCharacter implements RaceInterface{
    final String RACE_NAME = "Gnome";
    public enum GNOMISH_LINEAGE {DROW, HIGH_ELF, WOOD_ELF};
    GNOMISH_LINEAGE lineage;

    public Gnome(String name, String fileName) {
        super(name, fileName);
        setCreatureType("Humanoid");
        setSpeed(30);
        setSize(Constants.CREATURE_SIZE.SMALL);
        setRaceName(RACE_NAME);
        setSpecialFeatures();
    }

    public Gnome(String name, String fileName, Cell location) {
        super(name, fileName, location);
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
        // Darkvision
        setDarkVision(60);
        // Gnomish Cunning
        grantSkillAdvantage(Constants.SKILL_KEY.CHARISMA);
        grantSkillAdvantage(Constants.SKILL_KEY.INTELLIGENCE);
        grantSkillAdvantage(Constants.SKILL_KEY.WISDOM);
        
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
