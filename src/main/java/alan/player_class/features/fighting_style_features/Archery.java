package alan.player_class.features.fighting_style_features;

import alan.Constants;
import alan.Constants.DAMAGE_TYPE;
import alan.creatures.Creature;
import alan.grid_panel.Cell;
import alan.player_class.features.FeatureAbstract;

public class Archery extends FeatureAbstract{

    public Archery(){
        setClassFeatureKey(Constants.FEATURE.ARCHERY);
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
        caster.setRangedAttackRollBonus(2);
    }

    @Override
    public String descreiption() {
        // TODO Auto-generated method stub
        return super.descreiption();
    }

    


}
