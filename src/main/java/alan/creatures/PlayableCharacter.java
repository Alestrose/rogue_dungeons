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
        skillMap.put(Constants.SKILL_KEY.ATHLETICS, new Skill("athletics", abilities.get(Constants.ABILITY.STRENGTH).getAbilityMod(), getProficiencyBonus()));
        skillMap.put(Constants.SKILL_KEY.ACROBATICS, new Skill("acrobatics", abilities.get(Constants.ABILITY.DEXTERITY).getAbilityMod(), getProficiencyBonus()));
        skillMap.put(Constants.SKILL_KEY.SLEIGHT_OF_HAND, new Skill("sleight of Hand", abilities.get(Constants.ABILITY.DEXTERITY).getAbilityMod(), getProficiencyBonus()));
        skillMap.put(Constants.SKILL_KEY.STEALTH, new Skill("stealth", abilities.get(Constants.ABILITY.DEXTERITY).getAbilityMod(), getProficiencyBonus()));
        skillMap.put(Constants.SKILL_KEY.ARCANA, new Skill("arcana", abilities.get(Constants.ABILITY.INTELLIGENCE).getAbilityMod(), getProficiencyBonus()));
        skillMap.put(Constants.SKILL_KEY.HISTORY, new Skill("history", abilities.get(Constants.ABILITY.INTELLIGENCE).getAbilityMod(), getProficiencyBonus()));
        skillMap.put(Constants.SKILL_KEY.INVESTIGATION, new Skill("investigation", abilities.get(Constants.ABILITY.INTELLIGENCE).getAbilityMod(), getProficiencyBonus()));
        skillMap.put(Constants.SKILL_KEY.NATURE, new Skill("nature", abilities.get(Constants.ABILITY.INTELLIGENCE).getAbilityMod(), getProficiencyBonus()));
        skillMap.put(Constants.SKILL_KEY.RELIGION, new Skill("religion", abilities.get(Constants.ABILITY.INTELLIGENCE).getAbilityMod(), getProficiencyBonus()));
        skillMap.put(Constants.SKILL_KEY.ANIMAL_HANDLING, new Skill("animal handling", abilities.get(Constants.ABILITY.WISDOM).getAbilityMod(), getProficiencyBonus()));
        skillMap.put(Constants.SKILL_KEY.INSIGHT, new Skill("insight", abilities.get(Constants.ABILITY.WISDOM).getAbilityMod(), getProficiencyBonus()));
        skillMap.put(Constants.SKILL_KEY.MEDICINE, new Skill("medicine", abilities.get(Constants.ABILITY.WISDOM).getAbilityMod(), getProficiencyBonus()));
        skillMap.put(Constants.SKILL_KEY.PERCEPTION, new Skill("perception", abilities.get(Constants.ABILITY.WISDOM).getAbilityMod(), getProficiencyBonus()));
        skillMap.put(Constants.SKILL_KEY.SURVIVAL, new Skill("survival", abilities.get(Constants.ABILITY.WISDOM).getAbilityMod(), getProficiencyBonus()));
        skillMap.put(Constants.SKILL_KEY.DECEPTION, new Skill("deception", abilities.get(Constants.ABILITY.CHARISMA).getAbilityMod(), getProficiencyBonus()));
        skillMap.put(Constants.SKILL_KEY.INTIMIDATION, new Skill("intimidation", abilities.get(Constants.ABILITY.CHARISMA).getAbilityMod(), getProficiencyBonus()));
        skillMap.put(Constants.SKILL_KEY.PERFORMANCE, new Skill("performance", abilities.get(Constants.ABILITY.CHARISMA).getAbilityMod(), getProficiencyBonus()));
        skillMap.put(Constants.SKILL_KEY.PERSUASION, new Skill("persuasion", abilities.get(Constants.ABILITY.CHARISMA).getAbilityMod(), getProficiencyBonus()));
        skillMap.put(Constants.SKILL_KEY.STRENGTH, new Skill("strength", abilities.get(Constants.ABILITY.STRENGTH).getAbilityMod(), getProficiencyBonus()));
        skillMap.put(Constants.SKILL_KEY.DEXTERITY, new Skill("dexterity", abilities.get(Constants.ABILITY.DEXTERITY).getAbilityMod(), getProficiencyBonus()));
        skillMap.put(Constants.SKILL_KEY.CONSTITUTION, new Skill("constitution", abilities.get(Constants.ABILITY.CONSTITUTION).getAbilityMod(), getProficiencyBonus()));
        skillMap.put(Constants.SKILL_KEY.INTELLIGENCE, new Skill("intelligence", abilities.get(Constants.ABILITY.INTELLIGENCE).getAbilityMod(), getProficiencyBonus()));
        skillMap.put(Constants.SKILL_KEY.WISDOM, new Skill("wisdom", abilities.get(Constants.ABILITY.WISDOM).getAbilityMod(), getProficiencyBonus()));
        skillMap.put(Constants.SKILL_KEY.CHARISMA, new Skill("charisma", abilities.get(Constants.ABILITY.CHARISMA).getAbilityMod(), getProficiencyBonus()));
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
