package alan.skills_and_feats;

public class Ability {
    private String abilityName;
    private int abilityScore = 10;
    private int abilityMod = 0;
    private boolean saveAdvantage;
    private boolean saveDisadvantage;
    private boolean checkAdvantage;
    private boolean checkDisadvantage;
    private int saveBonus = 0;
    private int savePenalty = 0;

    public Ability(String abilityName){
        this.abilityName = abilityName;
    }

    /*
     * Getters & Setters
     */
    
    
    public String getAbilityName() {
        return abilityName;
    }

    public void setAbilityName(String abilityName) {
        this.abilityName = abilityName;
    }

    public boolean isSaveAdvantage() {
        return saveAdvantage;
    }

    public void setSaveAdvantage(boolean advantage) {
        if(isSaveDisadvantage()) this.saveDisadvantage = false;
        else this.saveAdvantage = advantage;
    }

    public boolean isSaveDisadvantage() {
        return saveDisadvantage;
    }

    public void setDisadvantage(boolean disadvantage) {
        if(isSaveAdvantage()) this.saveAdvantage = false;
        else this.saveDisadvantage = disadvantage;
    }

    public int getBonus() {
        return saveBonus;
    }

    public void setBonus(int bonus) {
        this.saveBonus = bonus;
    }

    public int getPenalty() {
        return savePenalty;
    }

    public void setPenalty(int penalty) {
        this.savePenalty = penalty;
    }

    public int getAbilityScore() {
        return abilityScore;
    }

    public void setAbilityScore(int abilityScore) {
        this.abilityScore = abilityScore;
        setAbilityMod();
    }

    public void setSaveDisadvantage(boolean saveDisadvantage) {
        this.saveDisadvantage = saveDisadvantage;
    }

    public int getSaveBonus() {
        return saveBonus;
    }

    public void setSaveBonus(int saveBonus) {
        this.saveBonus = saveBonus;
    }

    public int getSavePenalty() {
        return savePenalty;
    }

    public void setSavePenalty(int savePenalty) {
        this.savePenalty = savePenalty;
    }

    public int getAbilityMod() {
        return abilityMod;
    }

    public void setAbilityMod() {
        if(this.abilityScore >= 10) abilityMod = (abilityScore - 10) /2;
        else abilityMod = (abilityScore - 11) /2;
    }

    public void setAbilityMod(int abilityMod) {
        this.abilityMod = abilityMod;
    }

    public boolean isCheckAdvantage() {
        return checkAdvantage;
    }

    public void setCheckAdvantage(boolean checkAdvantage) {
        this.checkAdvantage = checkAdvantage;
    }

    public boolean isCheckDisadvantage() {
        return checkDisadvantage;
    }

    public void setCheckDisadvantage(boolean checkDisadvantage) {
        this.checkDisadvantage = checkDisadvantage;
    }
    
    
    
}
