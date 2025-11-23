package alan.player_class.features.class_features;

import alan.Constants;
import alan.Constants.DAMAGE_TYPE;
import alan.creatures.Creature;
import alan.grid_panel.Cell;
import alan.player_class.features.FeatureAbstract;

public class LayOnHands extends FeatureAbstract{
    int hitPool;

    public LayOnHands(){
        setClassFeatureKey(Constants.FEATURE.LAY_ON_HANDS);
        setClassFeatureName();
        setFeatureLevel(1);
        setActive(true);
        setBonus(true);
        setFeatType(Constants.FEAT_TYPE.CLASS);
        setResourceQuanity(1);
        this.hitPool = 5*1;
    }

    /*
        Methods
     */

    @Override
    public void cast(Creature caster, Creature target, Creature[] targetList, Cell cell, DAMAGE_TYPE damage_type,
            int spellLevel) {
        // TODO Auto-generated method stub
        super.cast(caster, target, targetList, cell, damage_type, spellLevel);
        if(getResourceQuanity() > 0 && hitPool > 0){
            int targetMissingHealth = target.getMaxHealth() - target.getCurrentHealth();
            int toHeal = hitPool - targetMissingHealth;

            if (toHeal>0) {
                target.healHealth(toHeal);
                setHitPool(getHitPool()-toHeal);
            }else {
                target.healHealth(hitPool);
                setHitPool(0);
            }
        }
    }

    @Override
    public String descreiption() {
        // TODO Auto-generated method stub
        return """
               Your blessed touch can heal wounds. You have a\r
               pool of healing power that replenishes when you\r
               finish a Long Rest. With that pool, you can restore\r
               a total number of Hit Points equal to five times your\r
               Paladin level.\r
               As a Bonus Action, you can touch a creature\r
               (which could be yourself) and draw power from the\r
               pool of healing to restore a number of Hit Points to\r
               that creature, up to the maximum amount remain-\r
               ing in the pool.""" //
        //
        //
        //
        //
        //
        //
        //
        //
        ;
    }

    @Override
    public void onLevelUp(int lvl) {
        // TODO Auto-generated method stub
        super.onLevelUp(lvl);
        setHitPool(lvl*5);
    }

    @Override
    public void onLongRest() {
        // TODO Auto-generated method stub
        super.onLongRest();
    }

    @Override
    public void onShortRest() {
        // TODO Auto-generated method stub
        super.onShortRest();
    }

    /*
        Getters and Setters
     */

    public int getHitPool() {
        return hitPool;
    }

    public void setHitPool(int hitPool) {
        this.hitPool = hitPool;
    }

    
}
