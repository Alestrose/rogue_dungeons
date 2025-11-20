package alan.player_class.features.fighting_style_features;

import alan.Constants;
import alan.Constants.DAMAGE_TYPE;
import alan.creatures.Creature;
import alan.grid_panel.Cell;
import alan.player_class.features.FeatureAbstract;

public class UnarmedFighting extends FeatureAbstract{

    public UnarmedFighting(){
        setClassFeatureKey(Constants.FEATURE.UNARMED_FIGHTING);
        setClassFeatureName();
        setFeatureLevel(1);
        setPassive(true);
        setFeatType(Constants.FEAT_TYPE.FIGHTING_STYLE);
    }

    // Needs to be implemented when attack types are done
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
               When you hit with your Unarmed Strike and deal\r
               damage, you can deal Bludgeoning damage equal\r
               to 1d6 plus your Strength modifier instead of the\r
               normal damage of an Unarmed Strike. If you aren't\r
               holding any weapons or a Shield when you make the\r
               attack roll, the d6 becomes a d8.\r
               At the start of each of your turns, you can deal\r
               ld4 Bludgeoning damage to one creature Grap-\r
               pled by you.""" //
        //
        //
        //
        //
        //
        //
        //
        ;
    }
}
