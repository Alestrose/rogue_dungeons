package alan.player_class.class_features;

import alan.Constants.DAMAGE_TYPE;
import alan.creatures.Creature;
import alan.grid_panel.Cell;

public class WeaponMastery extends ClassFeatureAbstract{
    private int maxNumberOfMasteries;

    public WeaponMastery(){

    }

    @Override
    public void cast(Creature caster, Creature target, Creature[] targetList, Cell cell, DAMAGE_TYPE damage_type, int spellLevel) {
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

    /*
     * Getters and Setters
     */
    
     public int getMaxNumberOfMasteries() {
        return maxNumberOfMasteries;
    }

    public void setMaxNumberOfMasteries(int maxNumberOfMasteries) {
        this.maxNumberOfMasteries = maxNumberOfMasteries;
    }

}
