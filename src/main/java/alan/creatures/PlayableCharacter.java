package alan.creatures;

import java.util.HashMap;
import java.util.Map;

import alan.grid_panel.Cell;
import alan.skills_and_feats.Skill;

public class PlayableCharacter extends Creature{
    private boolean hasAdvantage = false;
    private int proficiencyBonus = 0;

    protected Map<String, Skill> skillMap = new HashMap<>();


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

    public void setDefaultSkillMap(){
        skillMap.put("Athletics", new Skill("Athletics", getStrength(), getProficiencyBonus()));
        skillMap.put("Acrobatics", new Skill("Acrobatics", getDexterity(), getProficiencyBonus()));
        skillMap.put("Sleight of Hand", new Skill("Sleight of Hand", getDexterity(), getProficiencyBonus()));
        skillMap.put("Stealth", new Skill("Stealth", getDexterity(), getProficiencyBonus()));
        skillMap.put("Arcana", new Skill("Arcana", getIntelligence(), getProficiencyBonus()));
        skillMap.put("History", new Skill("History", getIntelligence(), getProficiencyBonus()));
        skillMap.put("Investigation", new Skill("Investigation", getIntelligence(), getProficiencyBonus()));
        skillMap.put("Nature", new Skill("Nature", getIntelligence(), getProficiencyBonus()));
        skillMap.put("Religion", new Skill("Religion", getIntelligence(), getProficiencyBonus()));
        skillMap.put("Animal Handling", new Skill("Animal Handling", getWisdom(), getProficiencyBonus()));
        skillMap.put("Insight", new Skill("Insight", getWisdom(), getProficiencyBonus()));
        skillMap.put("Medicine", new Skill("Medicine", getWisdom(), getProficiencyBonus()));
        skillMap.put("Perception", new Skill("Perception", getWisdom(), getProficiencyBonus()));
        skillMap.put("Survival", new Skill("Survival", getWisdom(), getProficiencyBonus()));
        skillMap.put("Deception", new Skill("Deception", getCharisma(), getProficiencyBonus()));
        skillMap.put("Intimidation", new Skill("Intimidation", getCharisma(), getProficiencyBonus()));
        skillMap.put("Performance", new Skill("Performance", getCharisma(), getProficiencyBonus()));
        skillMap.put("Persuasion", new Skill("Persuasion", getCharisma(), getProficiencyBonus()));
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
