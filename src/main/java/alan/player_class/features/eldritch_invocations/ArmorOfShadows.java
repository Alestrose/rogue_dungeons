package alan.player_class.features.eldritch_invocations;

import alan.Constants;
import alan.Constants.DAMAGE_TYPE;
import alan.creatures.Creature;
import alan.grid_panel.Cell;
import alan.player_class.features.FeatureAbstract;
import alan.spells.level_one.MageArmor;

public class ArmorOfShadows extends FeatureAbstract{
    private MageArmor mageArmor = new MageArmor();

    public ArmorOfShadows() {
        setClassFeatureKey(Constants.FEATURE.ARMOR_OF_SHADOWS);
        setAction(true);
        setActive(true);
        setFeatureLevel(1);
        setFeatType(Constants.FEAT_TYPE.ELDRITCH_INVOCATION);
        
    }

    @Override
    public void cast(Creature caster, Creature target, Creature[] targetList, Cell cell, DAMAGE_TYPE damage_type,
            int spellLevel) {
        mageArmor.cast(caster, target, targetList, cell, damage_type, spellLevel);
    }

    @Override
    public String descreiption() {
        return """
               You can cast Mage Armor on yourself without ex-\r
               pending a spell slot.""" //
        ;
    }

    
    
}
