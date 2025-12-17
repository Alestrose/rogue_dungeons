package alan.features.fighting_style_features;

import alan.Constants;
import alan.Constants.DAMAGE_TYPE;
import alan.creatures.Creature;
import alan.features.FeatureAbstract;
import alan.grid_panel.Cell;

public class TwoWeaponFighting extends FeatureAbstract{

    public TwoWeaponFighting(){
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
    }

    @Override
    public String descreiption() {
        // TODO Auto-generated method stub
        return """
               When you make an extra attack as a result of using\r
               a weapon that has the Light property, you can add\r
               your ability modifier to the damage of that attack if\r
               you aren't already adding it to the damage.""" //
        //
        //
        ;
    }
}
