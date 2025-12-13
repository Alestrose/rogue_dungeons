package alan.player_class.features.eldritch_invocations;

import alan.Constants;
import alan.Constants.DAMAGE_TYPE;
import alan.creatures.Creature;
import alan.grid_panel.Cell;
import alan.player_class.features.FeatureAbstract;
import alan.spells.level_one.FindFamiliar;

public class PactOfTheChain extends FeatureAbstract{
    private final FindFamiliar findFamiliar = new FindFamiliar();

    public PactOfTheChain() {
        setClassFeatureKey(Constants.FEATURE.PACT_OF_THE_CHAIN);
        setAction(true);
        setActive(true);
        setFeatureLevel(1);
        setFeatType(Constants.FEAT_TYPE.ELDRITCH_INVOCATION);
        
    }

    @Override
    public void cast(Creature caster, Creature target, Creature[] targetList, Cell cell, DAMAGE_TYPE damage_type,
            int spellLevel) {
        
        findFamiliar.cast(caster, target, targetList, cell, damage_type, spellLevel);
    }

    @Override
    public String descreiption() {
        return """
               You learn the Find Familiar spell and can cast it as a\r
               Magic action without expending a spell slot.\r
               When you cast the spell, you choose one of the\r
               normal forms for your familiar or one of the fol-\r
               lowing special forms: Imp, Pseudodragon, Qua-\r
               sit, Skeleton, Slaad Tadpole, Sphinx of Wonder,\r
               Sprite, or Venomous Snake (see appendix B for the\r
               familiar's stat block).\r
               Additionally, when you take the Attack action,\r
               you can forgo one of your own attacks to allow\r
               your familiar to make one attack of its own with its\r
               Reaction.""" //
        //
        //
        //
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
