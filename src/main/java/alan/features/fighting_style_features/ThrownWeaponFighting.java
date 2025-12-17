package alan.features.fighting_style_features;

import alan.Constants;
import alan.Constants.DAMAGE_TYPE;
import alan.creatures.Creature;
import alan.features.FeatureAbstract;
import alan.grid_panel.Cell;

public class ThrownWeaponFighting extends FeatureAbstract{

    public ThrownWeaponFighting(){
        setClassFeatureKey(Constants.FEATURE.THROWN_WEAPON_FIGHTING);
        setClassFeatureName();
        setFeatureLevel(1);
        setPassive(true);
        setFeatType(Constants.FEAT_TYPE.FIGHTING_STYLE);
    }

    @Override
    public void cast(Creature caster, Creature target, Creature[] targetList, Cell cell, DAMAGE_TYPE damage_type,
            int spellLevel) {
        // TODO Auto-generated method stub
        super.cast(caster, target, targetList, cell, damage_type, spellLevel);
        caster.setThrownAttackDamageBonus(2);
    }

    @Override
    public String descreiption() {
        // TODO Auto-generated method stub
        return """
               When you hit with a ranged attack roll using a\r
               weapon that has the Thrown property, you gain a\r
               +2 bonus to the damage roll.""" //
        //
        ;
    }
}
