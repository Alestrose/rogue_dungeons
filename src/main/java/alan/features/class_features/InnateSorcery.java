package alan.features.class_features;

import alan.Constants;
import alan.Constants.DAMAGE_TYPE;
import alan.creatures.Creature;
import alan.features.FeatureAbstract;
import alan.grid_panel.Cell;

public class InnateSorcery extends FeatureAbstract{

    public InnateSorcery() {
        setClassFeatureKey(Constants.FEATURE.INNATE_SORCERY);
        setClassFeatureName();
        setFeatureLevel(1);
        setDuration((byte) 10);
        setBonus(true);
        setActive(true);
        setFeatType(Constants.FEAT_TYPE.CLASS);
    }

    @Override
    public void cast(Creature caster, Creature target, Creature[] targetList, Cell cell, DAMAGE_TYPE damage_type,
            int spellLevel) {
        caster.setSpellSaveDCBonus(1);
        caster.setSpellAttackRollAdvantage(true);
    }

    @Override
    public String descreiption() {
        return """
               An event in your past left an indelible mark on you,\r
               infusing you with simmering magic. As a Bonus\r
               Action, you can unleash that magic for 1 minute,\r
               during which you gain the following benefits:\r
               \u2022 The spell save DC of your Sorcerer spells\r
               increases by 1.\r
               \u2022 You have Advantage on the attack rolls of\r
               Sorcerer spells you cast.\r
               You can use this feature twice, and you regain all\r
               expended uses of it when you fin ish a Long Rest.\r
               """ //
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

    @Override
    public void onLevelUp(int lvl) {
        // TODO Auto-generated method stub
        super.onLevelUp(lvl);
    }

    
}
