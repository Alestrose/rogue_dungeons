package alan.player_class.features;

import alan.Constants;
import alan.Constants.DAMAGE_TYPE;
import alan.creatures.Creature;
import alan.creatures.PartyPlayers;
import alan.grid_panel.Cell;
import alan.grid_panel.Grid;
import alan.interfaces.DiceRoll;
import alan.spells.SpellInterface;

public abstract class FeatureAbstract implements DiceRoll, SpellInterface{
    Grid grid;
    PartyPlayers partyPlayers;

    private Constants.FEATURE classFeatureKey;
    private String classFeatureName;
    private byte duration;
    private int resourceQuanity;
    private int featureLevel;
    private int damageDie;                        
    private int quantityOfDie;                      
    private int quantityOfDieIncrementer;         
    private int secondaryDamageDie;                
    private int quantityOfSecondaryDieIncrementer;
    private boolean reaction = false;
    private boolean action = false;
    private boolean bonus = false;
    private boolean freeCast = false;
    private boolean isActive = false;       // Denotes feature which must be activley triggered
    private boolean isPassive = false;      // Denotes feature which is always active
    private DAMAGE_TYPE damage_type;
    private DAMAGE_TYPE secondary_damage_type;
    private Constants.FEAT_TYPE featType;
    private Constants.ABILITY savingThrow;
    private Creature caster;
    private Creature target;
    private Creature[] targetList;
    private Cell cell;


    // Constructor
    public FeatureAbstract(){
        
        grid = Grid.getInstance(0, 0);
        partyPlayers = PartyPlayers.getInstance();
    }

    

    /*
     * Methods
     */

    public void update(Creature owner){

    }

    @Override
    public void cast(Creature caster, Creature target, Creature[] targetList, Cell cell, DAMAGE_TYPE damage_type,
            int spellLevel) {
        // TODO Auto-generated method stub
        
    }



    @Override
    public String descreiption() {
        // TODO Auto-generated method stub
        return null;
    }



    @Override
    public void onLevelUp(int lvl) {
        // TODO Auto-generated method stub
        
    }

    @Override       // Returns damage roll based on damage die and quanity of damage die
    public int rollDamage(int damageDie, int quantityOfDie) {
        int total = 0;
        for (int i = 0; i < quantityOfDie; i++) {
            total += random.nextInt(damageDie) + 1;
        }
        return total;
    }

    @Override       // Returns true if target specified ability modifier plus a random d20 is greater than or equal to casters spell save DC
    public boolean rollSpellSaveCheck(Creature target, Creature caster, Constants.ABILITY ability) {
        return random.nextInt(20)+1 + target.getAbilities().get(ability).getAbilityMod() >= caster.getSpellSaveDC();
    }

    @Override       // Returns true if target spell attack bonus plus a random d20 is greater than or equal to targets AC
    public boolean rollToHitAC(Creature target, Creature caster) {
        return random.nextInt(20)+1 + caster.getSpellAttackBonus() >= target.getArmorClass().getAC();
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

    public String getClassFeatureName() {
        return classFeatureName;
    }

    public void setClassFeatureName() {
        String s = classFeatureKey.name().toLowerCase().replace('_', ' ');
        this.classFeatureName = s.substring(0, 1).toUpperCase() + s.substring(1);
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

    public Constants.FEATURE getClassFeatureKey() {
        return classFeatureKey;
    }

    public void setClassFeatureKey(Constants.FEATURE classFeatureKey) {
        this.classFeatureKey = classFeatureKey;
    }

    public void setClassFeatureName(String classFeatureName) {
        this.classFeatureName = classFeatureName;
    }

    public int getDamageDie() {
        return damageDie;
    }

    public void setDamageDie(int damageDie) {
        this.damageDie = damageDie;
    }

    public int getQuantityOfDie() {
        return quantityOfDie;
    }

    public void setQuantityOfDie(int quantityOfDie) {
        this.quantityOfDie = quantityOfDie;
    }

    public int getQuantityOfDieIncrementer() {
        return quantityOfDieIncrementer;
    }

    public void setQuantityOfDieIncrementer(int quantityOfDieIncrementer) {
        this.quantityOfDieIncrementer = quantityOfDieIncrementer;
    }

    public int getSecondaryDamageDie() {
        return secondaryDamageDie;
    }

    public void setSecondaryDamageDie(int secondaryDamageDie) {
        this.secondaryDamageDie = secondaryDamageDie;
    }

    public int getQuantityOfSecondaryDieIncrementer() {
        return quantityOfSecondaryDieIncrementer;
    }

    public void setQuantityOfSecondaryDieIncrementer(int quantityOfSecondaryDieIncrementer) {
        this.quantityOfSecondaryDieIncrementer = quantityOfSecondaryDieIncrementer;
    }

    public byte getDuration() {
        return duration;
    }

    public void setDuration(byte duration) {
        this.duration = duration;
    }

    public int getResourceQuanity() {
        return resourceQuanity;
    }

    public void setResourceQuanity(int resourceQuanity) {
        this.resourceQuanity = resourceQuanity;
    }



    public Constants.FEAT_TYPE getFeatType() {
        return featType;
    }



    public void setFeatType(Constants.FEAT_TYPE featType) {
        this.featType = featType;
    }
    
    
    
}
