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
        setDefaultSkillMap();
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

    public void grantSkillAdvantage(Constants.SKILL_KEY skill_key) {
        Skill skill = skillMap.get(skill_key);
        if (skill != null) {
            skill.setHasAdvantage(true);
        }
    }

    private void setDefaultSkillMap(){
        skillMap.put(Constants.SKILL_KEY.ATHLETICS, new Skill("athletics", getStrengthMod(), getProficiencyBonus()));
        skillMap.put(Constants.SKILL_KEY.ACROBATICS, new Skill("acrobatics", getDexterityMod(), getProficiencyBonus()));
        skillMap.put(Constants.SKILL_KEY.SLEIGHT_OF_HAND, new Skill("sleight of Hand", getDexterityMod(), getProficiencyBonus()));
        skillMap.put(Constants.SKILL_KEY.STEALTH, new Skill("stealth", getDexterityMod(), getProficiencyBonus()));
        skillMap.put(Constants.SKILL_KEY.ARCANA, new Skill("arcana", getIntelligenceMod(), getProficiencyBonus()));
        skillMap.put(Constants.SKILL_KEY.HISTORY, new Skill("history", getIntelligenceMod(), getProficiencyBonus()));
        skillMap.put(Constants.SKILL_KEY.INVESTIGATION, new Skill("investigation", getIntelligenceMod(), getProficiencyBonus()));
        skillMap.put(Constants.SKILL_KEY.NATURE, new Skill("nature", getIntelligenceMod(), getProficiencyBonus()));
        skillMap.put(Constants.SKILL_KEY.RELIGION, new Skill("religion", getIntelligenceMod(), getProficiencyBonus()));
        skillMap.put(Constants.SKILL_KEY.ANIMAL_HANDLING, new Skill("animal handling", getWisdomMod(), getProficiencyBonus()));
        skillMap.put(Constants.SKILL_KEY.INSIGHT, new Skill("insight", getWisdomMod(), getProficiencyBonus()));
        skillMap.put(Constants.SKILL_KEY.MEDICINE, new Skill("medicine", getWisdomMod(), getProficiencyBonus()));
        skillMap.put(Constants.SKILL_KEY.PERCEPTION, new Skill("perception", getWisdomMod(), getProficiencyBonus()));
        skillMap.put(Constants.SKILL_KEY.SURVIVAL, new Skill("survival", getWisdomMod(), getProficiencyBonus()));
        skillMap.put(Constants.SKILL_KEY.DECEPTION, new Skill("deception", getCharismaMod(), getProficiencyBonus()));
        skillMap.put(Constants.SKILL_KEY.INTIMIDATION, new Skill("intimidation", getCharismaMod(), getProficiencyBonus()));
        skillMap.put(Constants.SKILL_KEY.PERFORMANCE, new Skill("performance", getCharismaMod(), getProficiencyBonus()));
        skillMap.put(Constants.SKILL_KEY.PERSUASION, new Skill("persuasion", getCharismaMod(), getProficiencyBonus()));
        skillMap.put(Constants.SKILL_KEY.STRENGTH, new Skill("strength", getStrengthMod(), getProficiencyBonus()));
        skillMap.put(Constants.SKILL_KEY.DEXTERITY, new Skill("dexterity", getDexterityMod(), getProficiencyBonus()));
        skillMap.put(Constants.SKILL_KEY.CONSTITUTION, new Skill("constitution", getConstitutionMod(), getProficiencyBonus()));
        skillMap.put(Constants.SKILL_KEY.INTELLIGENCE, new Skill("intelligence", getIntelligenceMod(), getProficiencyBonus()));
        skillMap.put(Constants.SKILL_KEY.WISDOM, new Skill("wisdom", getWisdomMod(), getProficiencyBonus()));
        skillMap.put(Constants.SKILL_KEY.CHARISMA, new Skill("charisma", getCharismaMod(), getProficiencyBonus()));
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
