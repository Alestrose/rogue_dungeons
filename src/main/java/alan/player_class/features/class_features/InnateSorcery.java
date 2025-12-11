package alan.player_class.features.class_features;

import alan.Constants;
import alan.Constants.DAMAGE_TYPE;
import alan.creatures.Creature;
import alan.grid_panel.Cell;
import alan.player_class.features.FeatureAbstract;

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
        // TODO Auto-generated method stub
        caster.setSpellSaveDCBonus(1);
        caster.setSpellAttackRollAdvantage(true);
        super.cast(caster, target, targetList, cell, damage_type, spellLevel);
    }

    @Override
    public String descreiption() {
        // TODO Auto-generated method stub
        return super.descreiption();
    }

    @Override
    public void onLevelUp(int lvl) {
        // TODO Auto-generated method stub
        super.onLevelUp(lvl);
    }

    
}
