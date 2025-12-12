package alan.player_class.features.eldritch_invocations;

import alan.Constants;
import alan.Constants.DAMAGE_TYPE;
import alan.creatures.Creature;
import alan.grid_panel.Cell;
import alan.player_class.features.FeatureAbstract;

public class EldritchMind extends FeatureAbstract{

    public EldritchMind() {
        setClassFeatureKey(Constants.FEATURE.ELDRITCH_MIND);
        setPassive(true);
        setFeatureLevel(1);
        setFeatType(Constants.FEAT_TYPE.ELDRITCH_INVOCATION);
    }

    @Override   // Grants the caster advantage on constitution concentration checks
    public void cast(Creature caster, Creature target, Creature[] targetList, Cell cell, DAMAGE_TYPE damage_type,
            int spellLevel) {
        caster.getAbilities().get(Constants.ABILITY.CONSTITUTION).setConcentrationAdvantage(true);
    }

    @Override
    public String descreiption() {
        return """
               You have Advantage on Constitution saving throws\r
               that you make to maintain Concentration.""" //
        ;
    }

    
}
