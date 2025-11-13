package alan.player_class.class_features;

import alan.Constants;
import alan.Constants.DAMAGE_TYPE;
import alan.creatures.Creature;
import alan.grid_panel.Cell;

public class Rage extends ClassFeatureAbstract{
    private int resourceRage = 2;
    private int damageBonus = 2;

    public Rage(){
        setPlayerClass(Constants.CLASS.BARBARIAN);
        setClassFeatureKey(Constants.CLASS_FEATURE.RAGE);
        setClassFeatureName();
        setFeatureLevel(1);
        setDuration((byte) 100);
        setBonus(true);
        setActive(true);
        
    }

    @Override
    public void cast(Creature caster, Creature target, Creature[] targetList, Cell cell, DAMAGE_TYPE damage_type, int spellLevel) {
        if(!caster.isWearingArmor()){
            caster.setRaging(true);
            caster.setDamageRollIncrease(damageBonus);
            caster.getAbilities().get(Constants.ABILITY.STRENGTH).setSaveAdvantage(true);
            caster.getAbilities().get(Constants.ABILITY.STRENGTH).setCheckAdvantage(true);
        }else System.err.println("Can't do while wearing armor");
    }

    @Override
    public String descreiption() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void onLevelUp(int lvl) {
        switch (lvl) {
            case 3 -> {setResourceRage(3); }
            case 6 -> {setResourceRage(4);}
            case 9 -> {setDamageBonus(3);}
            case 12 -> {setResourceRage(5);}
            case 16 -> {setDamageBonus(4);}
            case 17 -> {setResourceRage(6);}
            default -> {}
        }
        
    }

    /*
     * Getters and Setters
     */

    public int getResourceRage() {
        return resourceRage;
    }

    public void setResourceRage(int resourceRage) {
        this.resourceRage = resourceRage;
    }

    public int getDamageBonus() {
        return damageBonus;
    }

    public void setDamageBonus(int damageBonus) {
        this.damageBonus = damageBonus;
    }

    
    
    
}
