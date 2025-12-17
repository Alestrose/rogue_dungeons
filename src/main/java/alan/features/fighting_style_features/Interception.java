package alan.features.fighting_style_features;

import alan.Constants;
import alan.Constants.DAMAGE_TYPE;
import alan.creatures.Creature;
import alan.features.FeatureAbstract;
import alan.grid_panel.Cell;

public class Interception extends FeatureAbstract{

    public Interception(){
        setClassFeatureKey(Constants.FEATURE.INTERCEPTION);
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
               When a creature you can see hits another creature\r
               within 5 feet of you with an attack roll, you can\r
               take a Reaction to reduce the damage dealt to the\r
               target by ldl0 plus your Proficiency Bonus. You\r
               must be holding a Shield or a Simple or Martial\r
               weapon to use this Reaction.""" //
        //
        //
        //
        //
        ;
    }
}
