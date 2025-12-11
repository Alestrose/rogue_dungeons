package alan.player_class.features.class_features;

import alan.Constants;
import alan.Constants.DAMAGE_TYPE;
import alan.creatures.Creature;
import alan.grid_panel.Cell;
import alan.player_class.features.FeatureAbstract;

public class SneakAttack extends FeatureAbstract{

    public SneakAttack() {
        setClassFeatureKey(Constants.FEATURE.SNEAK_ATTACK);
        setAction(true);
        setActive(true);
        setFeatureLevel(1);
        setFeatType(Constants.FEAT_TYPE.CLASS);
        setDamageDie(6);
        setQuantityOfDie(1);
    }

    // Requires implementation of weapon attacks
    @Override
    public void cast(Creature caster, Creature target, Creature[] targetList, Cell cell, DAMAGE_TYPE damage_type,
            int spellLevel) {
        // TODO Auto-generated method stub
        super.cast(caster, target, targetList, cell, damage_type, spellLevel);
        if(caster.isAttackRollAdvantage()){
            target.damageHealth(rollDamage(getDamageDie(), getQuantityOfDie()));
        }
        
    }

    @Override
    public void onLevelUp(int lvl) {
        // TODO Auto-generated method stub
        super.onLevelUp(lvl);
        switch (lvl) {
            case 3 -> {setQuantityOfDie(2);}
            case 5 -> {setQuantityOfDie(3);}
            case 7 -> {setQuantityOfDie(4);}
            case 9 -> {setQuantityOfDie(5);}
            case 11 -> {setQuantityOfDie(6);}
            case 13 -> {setQuantityOfDie(7);}
            case 15 -> {setQuantityOfDie(8);}
            case 17 -> {setQuantityOfDie(9);}
            case 19 -> {setQuantityOfDie(10);}
            default -> {
            }
        }
    }

    @Override
    public String descreiption() {
        // TODO Auto-generated method stub
        return "";
    }
}
