package alan.player_class.class_features;

import alan.Constants;
import alan.Constants.DAMAGE_TYPE;
import alan.creatures.Creature;
import alan.grid_panel.Cell;

public class UnarmoredDefenseBarbarian extends ClassFeatureAbstract{

    public UnarmoredDefenseBarbarian(){
        setClassFeatureKey(Constants.CLASS_FEATURE.UNARMORED_DEFENSE_BARBARIAN);
        setPassive(true);
        setFeatureLevel(1);
    }

    @Override
    public void cast(Creature caster, Creature target, Creature[] targetList, Cell cell, DAMAGE_TYPE damage_type, int spellLevel) {
        if(!caster.isWearingArmor()){
            caster.setAc(caster.getBaseAC() + caster.getAbilities().get(Constants.ABILITY.DEXTERITY).getAbilityMod() + caster.getAbilities().get(Constants.ABILITY.STRENGTH).getAbilityMod());
        }else System.err.println(caster.getName() + " must not be wearing armor");
    }

    @Override
    public String descreiption() {
        // TODO Auto-generated method stub
        return """
               While you aren't wearing any armor, your base Ar-\r
               mor Class equals 10 plus your Dexterity and Consti-\r
               tution modifiers. You can use a Shield and still gain\r
               this benefit.""" //
        //
        //
        ;
    }

    @Override
    public void onLevelUp(int lvl) {
        // TODO Auto-generated method stub

    }

    

}
