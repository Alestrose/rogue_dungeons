package alan.races;

import alan.Constants;
import alan.creatures.PlayableCharacter;
import alan.grid_panel.Cell;

public class Elf extends PlayableCharacter implements RaceInterface{
    final String RACE_NAME = "Elf";
    private Constants.SKILL_KEY skill_key;

    public Elf(String name, String fileName, Constants.SKILL_KEY skill_key) {
        super(name, fileName);
        setCreatureType("Humanoid");
        setSpeed(30);
        setSize(Constants.CREATURE_SIZE.MEDIUM);
        setRaceName(RACE_NAME);
        this.skill_key = skill_key;
        setSpecialFeatures();
    }

    public Elf(String name, String fileName, Cell location, Constants.SKILL_KEY skill_key) {
        super(name, fileName, location);
        setCreatureType("Humanoid");
        setSpeed(30);
        setSize(Constants.CREATURE_SIZE.MEDIUM);
        setRaceName(RACE_NAME);
        this.skill_key = skill_key;
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
        grantSkillProficiency(skill_key);
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
