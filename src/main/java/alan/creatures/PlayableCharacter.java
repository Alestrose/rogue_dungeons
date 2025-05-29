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

    public void grantSkillProficiency(String skillName) {
        Skill skill = skillMap.get(skillName);
        if (skill != null) {
            skill.setHasProficiency(true);
        }
    }

    public void grantResistance(String resistanceName){
        resistances.put(resistanceName, true);
    }

    private void setDefaultSkillMap(){
        skillMap.put("athletics", new Skill("athletics", getStrength(), getProficiencyBonus()));
        skillMap.put("acrobatics", new Skill("acrobatics", getDexterity(), getProficiencyBonus()));
        skillMap.put("sleight of Hand", new Skill("sleight of Hand", getDexterity(), getProficiencyBonus()));
        skillMap.put("stealth", new Skill("stealth", getDexterity(), getProficiencyBonus()));
        skillMap.put("arcana", new Skill("arcana", getIntelligence(), getProficiencyBonus()));
        skillMap.put("history", new Skill("history", getIntelligence(), getProficiencyBonus()));
        skillMap.put("investigation", new Skill("investigation", getIntelligence(), getProficiencyBonus()));
        skillMap.put("nature", new Skill("nature", getIntelligence(), getProficiencyBonus()));
        skillMap.put("religion", new Skill("religion", getIntelligence(), getProficiencyBonus()));
        skillMap.put("animal handling", new Skill("animal handling", getWisdom(), getProficiencyBonus()));
        skillMap.put("insight", new Skill("insight", getWisdom(), getProficiencyBonus()));
        skillMap.put("medicine", new Skill("medicine", getWisdom(), getProficiencyBonus()));
        skillMap.put("perception", new Skill("perception", getWisdom(), getProficiencyBonus()));
        skillMap.put("survival", new Skill("survival", getWisdom(), getProficiencyBonus()));
        skillMap.put("deception", new Skill("deception", getCharisma(), getProficiencyBonus()));
        skillMap.put("intimidation", new Skill("intimidation", getCharisma(), getProficiencyBonus()));
        skillMap.put("performance", new Skill("performance", getCharisma(), getProficiencyBonus()));
        skillMap.put("persuasion", new Skill("persuasion", getCharisma(), getProficiencyBonus()));
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
