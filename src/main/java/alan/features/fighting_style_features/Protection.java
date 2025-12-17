package alan.features.fighting_style_features;

import alan.Constants;
import alan.Constants.DAMAGE_TYPE;
import alan.creatures.Creature;
import alan.features.FeatureAbstract;
import alan.grid_panel.Cell;

public class Protection extends FeatureAbstract{

    public Protection(){
        setClassFeatureKey(Constants.FEATURE.PROTECTION);
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
               When a creature you can see attacks a target other\r
               than you that is within 5 feet of you, you can take a\r
               Reaction to interpose your Shield if you're holding\r
               one. You impose Disadvantage on the triggering\r
               attack roll and all other attack rolls against the tar-\r
               get until the start of your next turn if you remain\r
               within 5 feet of the target.""" //
        //
        //
        //
        //
        //
        ;
    }
}
