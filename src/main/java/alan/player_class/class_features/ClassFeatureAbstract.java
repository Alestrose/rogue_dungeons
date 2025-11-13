package alan.player_class.class_features;

import alan.Constants;
import alan.Constants.DAMAGE_TYPE;
import alan.creatures.Creature;
import alan.creatures.PartyPlayers;
import alan.grid_panel.Cell;
import alan.grid_panel.Grid;

public abstract class ClassFeatureAbstract {
    Grid grid;
    PartyPlayers partyPlayers;

    private Constants.CLASS playerClass;
    private Constants.CLASS_FEATURE classFeatureKey;
    private String classFeatureName;
    private int featureLevel;
    private boolean reaction = false;
    private boolean action = false;
    private boolean bonus = false;
    private boolean freeCast = false;
    private boolean isActive = false;
    private boolean isPassive = false;
    private DAMAGE_TYPE damage_type;
    private DAMAGE_TYPE secondary_damage_type;
    private Constants.ABILITY savingThrow;
    private Creature caster;
    private Creature target;
    private Creature[] targetList;
    private Cell cell;


    // Constructor
    public ClassFeatureAbstract(Constants.CLASS_FEATURE classFeatureKey){
        String s = classFeatureKey.name().toLowerCase().replace('_', ' ');
        this.classFeatureName = s.substring(0, 1).toUpperCase() + s.substring(1);
        
        grid = Grid.getInstance(0, 0);
        partyPlayers = PartyPlayers.getInstance();
    }


    /* 
     * Getters and Setters
     */

    public Grid getGrid() {
        return grid;
    }

    public void setGrid(Grid grid) {
        this.grid = grid;
    }

    public PartyPlayers getPartyPlayers() {
        return partyPlayers;
    }

    public void setPartyPlayers(PartyPlayers partyPlayers) {
        this.partyPlayers = partyPlayers;
    }

    public Constants.CLASS getPlayerClass() {
        return playerClass;
    }

    public void setPlayerClass(Constants.CLASS playerClass) {
        this.playerClass = playerClass;
    }

    public String getClassFeatureName() {
        return classFeatureName;
    }

    public void setClassFeatureName(String classFeatureName) {
        this.classFeatureName = classFeatureName;
    }

    public int getFeatureLevel() {
        return featureLevel;
    }

    public void setFeatureLevel(int featureLevel) {
        this.featureLevel = featureLevel;
    }

    public boolean isReaction() {
        return reaction;
    }

    public void setReaction(boolean reaction) {
        this.reaction = reaction;
    }

    public boolean isAction() {
        return action;
    }

    public void setAction(boolean action) {
        this.action = action;
    }

    public boolean isBonus() {
        return bonus;
    }

    public void setBonus(boolean bonus) {
        this.bonus = bonus;
    }

    public boolean isFreeCast() {
        return freeCast;
    }

    public void setFreeCast(boolean freeCast) {
        this.freeCast = freeCast;
    }

    public DAMAGE_TYPE getDamage_type() {
        return damage_type;
    }

    public void setDamage_type(DAMAGE_TYPE damage_type) {
        this.damage_type = damage_type;
    }

    public DAMAGE_TYPE getSecondary_damage_type() {
        return secondary_damage_type;
    }

    public void setSecondary_damage_type(DAMAGE_TYPE secondary_damage_type) {
        this.secondary_damage_type = secondary_damage_type;
    }

    public Constants.ABILITY getSavingThrow() {
        return savingThrow;
    }

    public void setSavingThrow(Constants.ABILITY savingThrow) {
        this.savingThrow = savingThrow;
    }

    public Creature getCaster() {
        return caster;
    }


    public void setCaster(Creature caster) {
        this.caster = caster;
    }

    public Creature getTarget() {
        return target;
    }

    public void setTarget(Creature target) {
        this.target = target;
    }

    public Creature[] getTargetList() {
        return targetList;
    }

    public void setTargetList(Creature[] targetList) {
        this.targetList = targetList;
    }

    public Cell getCell() {
        return cell;
    }

    public void setCell(Cell cell) {
        this.cell = cell;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean isActive) {
        this.isActive = isActive;
    }


    public boolean isPassive() {
        return isPassive;
    }

    public void setPassive(boolean isPassive) {
        this.isPassive = isPassive;
    }

    public Constants.CLASS_FEATURE getClassFeatureKey() {
        return classFeatureKey;
    }

    public void setClassFeatureKey(Constants.CLASS_FEATURE classFeatureKey) {
        this.classFeatureKey = classFeatureKey;
    }
    
}
