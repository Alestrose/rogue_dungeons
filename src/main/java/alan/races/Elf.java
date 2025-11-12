package alan.races;

import alan.Constants;
import alan.Constants.CONDITION_KEY;
import alan.creatures.PlayableCharacter;
import alan.grid_panel.Cell;
import alan.player_class.PlayerClass;

public class Elf extends PlayableCharacter implements RaceInterface{
    final String RACE_NAME = "Elf";
    private final Constants.SKILL_KEY SKILL_KEY;
    public enum ELVEN_LINEAGE {DROW, HIGH_ELF, WOOD_ELF};
    ELVEN_LINEAGE lineage;

    public Elf(String name, String fileName, PlayerClass primaryClass, Constants.SKILL_KEY skill_key, ELVEN_LINEAGE lineage) {
        super(name, fileName, primaryClass);
        setCreatureType("Humanoid");
        setSpeed(30);
        setSize(Constants.CREATURE_SIZE.MEDIUM);
        setRaceName(RACE_NAME);
        this.lineage = lineage;
        this.SKILL_KEY = skill_key;
        setSpecialFeatures();
    }

    public Elf(String name, String fileName, Cell location, PlayerClass primaryClass, Constants.SKILL_KEY skill_key, ELVEN_LINEAGE lineage) {
        super(name, fileName, location, primaryClass);
        setCreatureType("Humanoid");
        setSpeed(30);
        setSize(Constants.CREATURE_SIZE.MEDIUM);
        setRaceName(RACE_NAME);
        this.lineage = lineage;
        this.SKILL_KEY = skill_key;
        setSpecialFeatures();
    }

    /*
     * Methods
     */
    @Override
    public final void setSpecialFeatures() {
        // Darkvision
        setDarkVision(60);
        // Keen Senses
        grantSkillProficiency(SKILL_KEY);
        // Fey Ancestry
        grantConditionAdvantage(CONDITION_KEY.CHARMED);
        // Elven Lineage
        switch (lineage) {
            case DROW -> setDarkVision(120) /* Gets Dancing Lights cantrip */;
            case HIGH_ELF -> {/* Gets Prestidigitation cantrip */ }
            case WOOD_ELF -> setSpeed(35) /* Gets Druid Craft cantrip */;
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
