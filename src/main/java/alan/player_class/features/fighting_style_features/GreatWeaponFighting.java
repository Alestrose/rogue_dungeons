package alan.player_class.features.fighting_style_features;

import alan.Constants;
import alan.Constants.DAMAGE_TYPE;
import alan.creatures.Creature;
import alan.grid_panel.Cell;
import alan.player_class.features.FeatureAbstract;

public class GreatWeaponFighting extends FeatureAbstract{

    public GreatWeaponFighting(){
        setClassFeatureKey(Constants.FEATURE.GREAT_WEAPON_FIGHTING);
        setClassFeatureName();
        setFeatureLevel(1);
        setPassive(true);
        setFeatType(Constants.FEAT_TYPE.FIGHTING_STYLE);
    }

    @Override
    public void update(Creature owner) {
        // TODO Auto-generated method stub
        super.update(owner);

    }

    // Needs to be implemented when attack types and equipment are done
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
               When you roll damage for an attack you make with\r
               a Melee weapon that you are holding with two\r
               hands, you can treat any 1 or 2 on a damage die as a\r
               3. The weapon must have the Two-Handed or Versa-\r
               tile property to gain this benefit.""" //
        //
        //
        //
        ;
    }
}
