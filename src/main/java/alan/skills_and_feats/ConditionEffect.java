package alan.skills_and_feats;

import alan.creatures.Creature;

public class ConditionEffect {
    // Each creature has one of each condition. By default isActive is set to false
    // Conditons can be set to active via Creature class methods
    
    private String conditionName;
    private boolean hasAdvantage, isInvulnerable, isActive;
    private int duration;
    private Creature sourceCaster;      // The creature which applied this condition to the target

    

    public ConditionEffect(String conditionName){
        this.conditionName = conditionName;
        isActive = false;
    }

    public String getConditionName() {
        return conditionName;
    }

    public void setConditionName(String conditionName) {
        this.conditionName = conditionName;
    }

    public boolean isHasAdvantage() {
        return hasAdvantage;
    }

    public void setHasAdvantage(boolean hasAdvantage) {
        this.hasAdvantage = hasAdvantage;
    }

    public boolean isInvulnerable() {
        return isInvulnerable;
    }

    public void setInvulnerable(boolean isInvulnerable) {
        this.isInvulnerable = isInvulnerable;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean isActive) {
        if(isInvulnerable) this.isActive = false; 
        else this.isActive = isActive;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public Creature getSourceCaster() {
        return sourceCaster;
    }

    public void setSourceCaster(Creature sourceCaster) {
        this.sourceCaster = sourceCaster;
    }

    
}
