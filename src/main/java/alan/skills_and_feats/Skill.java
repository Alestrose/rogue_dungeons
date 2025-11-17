package alan.skills_and_feats;

public class Skill {
    private String skillName;
    private int abilityModifier;
    private int proficiencyBonus;
    private int value;
    private int valueBonus = 0;
    private boolean hasProficiency = false;
    private boolean hasAdvantage = false;


    public Skill(String skillName, int abilityModifier, int proficiencyBonus){
        this.skillName = skillName;
        this.abilityModifier = abilityModifier;
        this.proficiencyBonus = proficiencyBonus;
        this.value = abilityModifier + valueBonus;
    }

    /*
     * Getters & Setters
     */
    public String getSkillName() {
        return skillName;
    }

    public void setSkillName(String skillName) {
        this.skillName = skillName;
    }

    public int getAbilityModifier() {
        return abilityModifier;
    }

    public void setAbilityModifier(int abilityModifier) {
        this.abilityModifier = abilityModifier;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public boolean isHasProficiency() {
        return hasProficiency;
    }

    public void setHasProficiency(boolean hasProficiency) {
        if(hasProficiency) value = abilityModifier + proficiencyBonus;
        else if(!hasProficiency) value = abilityModifier;
        this.hasProficiency = hasProficiency;
    }

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

    public int getValueBonus() {
        return valueBonus;
    }

    public void setValueBonus(int valueBonus) {
        this.valueBonus = valueBonus;
        this.value = abilityModifier + valueBonus;
    }
    
    
}
