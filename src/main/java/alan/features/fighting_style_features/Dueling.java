package alan.features.fighting_style_features;

import alan.Constants;
import alan.Constants.DAMAGE_TYPE;
import alan.creatures.Creature;
import alan.features.FeatureAbstract;
import alan.grid_panel.Cell;

public class Dueling extends FeatureAbstract{

    public Dueling(){
        setClassFeatureKey(Constants.FEATURE.DUELING);
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
               When you're holding a Melee weapon in one hand\r
               and no other weapons, you gain a +2 bonus to dam-\r
               age rolls with that weapon""" //
        //
        ;
    }
}
