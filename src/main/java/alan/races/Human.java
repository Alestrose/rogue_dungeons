package alan.races;

import alan.Constants;
import alan.creatures.PlayableCharacter;
import alan.grid_panel.Cell;
import alan.player_class.PlayerClass;

public class Human extends  PlayableCharacter implements RaceInterface{
    final String RACE_NAME = "Human";
    final Constants.SKILL_KEY SkilledTrait;
    private Boolean hasHeroicInspiration = true;

    public Human(String name, String fileName, PlayerClass primaryClass, Constants.SKILL_KEY skill) {
        super(name, fileName, primaryClass);
        setCreatureType("Humanoid");
        setSpeed(30);
        setSize(Constants.CREATURE_SIZE.MEDIUM);
        setRaceName(RACE_NAME);
        setSpecialFeatures();
        this.SkilledTrait = skill;
    }

    public Human(String name, String fileName, Cell location, PlayerClass primaryClass, Constants.SKILL_KEY skill) {
        super(name, fileName, location, primaryClass);
        setCreatureType("Humanoid");
        setSpeed(30);
        setSize(Constants.CREATURE_SIZE.MEDIUM);
        setRaceName(RACE_NAME);
        setSpecialFeatures();
        this.SkilledTrait = skill;
    }

    /*
     * Methods
     */
    @Override
    public final void setSpecialFeatures() {
        grantSkillProficiency(SkilledTrait);
    }

    @Override
    public void onLevelUpRace(){
        
    }

    @Override
    public void onShortRestRace() {

    }

    @Override
    public void onLongRestRace() {
        setHasHeroicInspiration(true);
    }

    /*
     * Getters & Setters
     */
    public String getRACE_NAME() {
        return RACE_NAME;
    }

    public Constants.SKILL_KEY getSkilledTrait() {
        return SkilledTrait;
    }

    public Boolean getHasHeroicInspiration() {
        return hasHeroicInspiration;
    }

    public void setHasHeroicInspiration(Boolean hasHeroicInspiration) {
        this.hasHeroicInspiration = hasHeroicInspiration;
    }

    

    

    

    


}
