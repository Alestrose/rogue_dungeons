package alan.features.class_features;

import alan.Constants;
import alan.Constants.DAMAGE_TYPE;
import alan.creatures.Creature;
import alan.features.FeatureAbstract;
import alan.grid_panel.Cell;

public class UnarmoredDefense extends FeatureAbstract{
    Constants.CLASS playerClass;

    public UnarmoredDefense(Constants.CLASS playerClass){
        this.playerClass = playerClass;
        setClassFeatureKey(Constants.FEATURE.UNARMORED_DEFENSE);
        setPassive(true);
        setFeatureLevel(1);
        setFeatType(Constants.FEAT_TYPE.CLASS);
    }

    @Override
    public void cast(Creature caster, Creature target, Creature[] targetList, Cell cell, DAMAGE_TYPE damage_type, int spellLevel) {
        if(playerClass == Constants.CLASS.BARBARIAN) caster.getArmorClass().setHasUnarmoredDefenseBarbarianFeat(true);
        if(playerClass == Constants.CLASS.MONK) caster.getArmorClass().setHasUnarmoredDefenseMonkFeat(true);
        caster.getArmorClass().setAC();
    }

    @Override
    public String descreiption() {
        return """
               (Barbarian) While you aren't wearing any armor, your base Ar-\r
               mor Class equals 10 plus your Dexterity and Consti-\r
               tution modifiers. You can use a Shield and still gain\r
               this benefit.
               (Monk) While you aren't wearing armor or wielding a
                Shield, your base Armor Class equals 10 plus your
                Dexterity and Wisdom modifiers""" //
        //
        //
        ;
    }

    @Override
    public void onLevelUp(int lvl) {
        // TODO Auto-generated method stub

    }

    

}
