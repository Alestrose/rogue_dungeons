package alan.creatures;

import java.util.HashMap;
import java.util.Map;

import alan.Constants;
import alan.grid_panel.Cell;
import alan.skills_and_feats.Skill;

public class PlayableCharacter extends Creature{
    private boolean hasAdvantage = false;
    private int proficiencyBonus = 0;

    protected Map<Constants.SKILL_KEY, Skill> skillMap = new HashMap<>();


    // Without location constructor
    public PlayableCharacter(String name, String fileName) {
        super(name, fileName);
        setClassFeatures();
        setDefaultSkillMap();
    }
    
    // With location constructor
    public PlayableCharacter(String name, String fileName, Cell location) {
        super(name, fileName, location);
        setClassFeatures();

    }

    /*
     * Methods
     */

    private  void setClassFeatures(){
        
    }
    
    public void onLongRest(){

    }
    
    public void onShortRest(){
        
    }

    public void onLevelUp(){

    }

    public void grantSkillProficiency(Constants.SKILL_KEY skill_key) {
        Skill skill = skillMap.get(skill_key);
        if (skill != null) {
            skill.setHasProficiency(true);
        }
    }

    public void grantResistance(Constants.DAMAGE_TYPE resistanceName){
        resistances.put(resistanceName, true);
    }

    private void setDefaultSkillMap(){
        skillMap.put(Constants.SKILL_KEY.ATHLETICS, new Skill("athletics", getStrength(), getProficiencyBonus()));
        skillMap.put(Constants.SKILL_KEY.ACROBATICS, new Skill("acrobatics", getDexterity(), getProficiencyBonus()));
        skillMap.put(Constants.SKILL_KEY.SLEIGHT_OF_HAND, new Skill("sleight of Hand", getDexterity(), getProficiencyBonus()));
        skillMap.put(Constants.SKILL_KEY.STEALTH, new Skill("stealth", getDexterity(), getProficiencyBonus()));
        skillMap.put(Constants.SKILL_KEY.ARCANA, new Skill("arcana", getIntelligence(), getProficiencyBonus()));
        skillMap.put(Constants.SKILL_KEY.HISTORY, new Skill("history", getIntelligence(), getProficiencyBonus()));
        skillMap.put(Constants.SKILL_KEY.INVESTIGATION, new Skill("investigation", getIntelligence(), getProficiencyBonus()));
        skillMap.put(Constants.SKILL_KEY.NATURE, new Skill("nature", getIntelligence(), getProficiencyBonus()));
        skillMap.put(Constants.SKILL_KEY.RELIGION, new Skill("religion", getIntelligence(), getProficiencyBonus()));
        skillMap.put(Constants.SKILL_KEY.ANIMAL_HANDLING, new Skill("animal handling", getWisdom(), getProficiencyBonus()));
        skillMap.put(Constants.SKILL_KEY.INSIGHT, new Skill("insight", getWisdom(), getProficiencyBonus()));
        skillMap.put(Constants.SKILL_KEY.MEDICINE, new Skill("medicine", getWisdom(), getProficiencyBonus()));
        skillMap.put(Constants.SKILL_KEY.PERCEPTION, new Skill("perception", getWisdom(), getProficiencyBonus()));
        skillMap.put(Constants.SKILL_KEY.SURVIVAL, new Skill("survival", getWisdom(), getProficiencyBonus()));
        skillMap.put(Constants.SKILL_KEY.DECEPTION, new Skill("deception", getCharisma(), getProficiencyBonus()));
        skillMap.put(Constants.SKILL_KEY.INTIMIDATION, new Skill("intimidation", getCharisma(), getProficiencyBonus()));
        skillMap.put(Constants.SKILL_KEY.PERFORMANCE, new Skill("performance", getCharisma(), getProficiencyBonus()));
        skillMap.put(Constants.SKILL_KEY.PERSUASION, new Skill("persuasion", getCharisma(), getProficiencyBonus()));
    }
    
    /*
     * Getters & Setters
     */
    
    public boolean isHasAdvantage() {
        return hasAdvantage;
    }

    public void setHasAdvantage(boolean hasAdvantage) {
        this.hasAdvantage = hasAdvantage;
    }

    public int getProficiencyBonus() {
        return proficiencyBonus;
    }

    public void setProficiencyBonus(int proficiencyBonus) {
        this.proficiencyBonus = proficiencyBonus;
    }
    

}
