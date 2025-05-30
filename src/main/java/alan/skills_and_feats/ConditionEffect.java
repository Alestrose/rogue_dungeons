package alan.skills_and_feats;

public class ConditionEffect {
    private String conditionName;

    private boolean hasAdvantage, isInvulnerable, isActive;
    private int duration;

    public ConditionEffect(String conditionName){
        this.conditionName = conditionName;
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

    
}
