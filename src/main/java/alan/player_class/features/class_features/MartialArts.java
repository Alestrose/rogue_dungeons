package alan.player_class.features.class_features;

import alan.Constants;
import alan.Constants.DAMAGE_TYPE;
import alan.creatures.Creature;
import alan.grid_panel.Cell;
import alan.player_class.features.FeatureAbstract;

public class MartialArts extends FeatureAbstract{

    public MartialArts(){
        setClassFeatureKey(Constants.FEATURE.MARTIAL_ARTS);
        setBonus(true);
        setActive(true);
        setFeatureLevel(1);
        setFeatType(Constants.FEAT_TYPE.CLASS);
        setDamageDie(6);
        setQuantityOfDie(1);
    }

    @Override
    public void cast(Creature caster, Creature target, Creature[] targetList, Cell cell, DAMAGE_TYPE damage_type,
            int spellLevel) {
        // TODO Auto-generated method stub
        super.cast(caster, target, targetList, cell, damage_type, spellLevel);
        if(!caster.isWearingArmor() && !caster.isHasShieldEquiped()){
            //rollToHitAC(caster, caster)
            if(rollToHitACMellee(target, caster)){
                target.damageHealth(rollDamage(getDamageDie(), getQuantityOfDie()) + caster.getAbilities().get(Constants.ABILITY.DEXTERITY).getAbilityMod());
            }
            
        }
    }

    @Override
    public void onLevelUp(int lvl) {
        // TODO Auto-generated method stub
        super.onLevelUp(lvl);
        switch (lvl) {
            case 5 -> {setDamageDie(8);}
            case 11 -> {setDamageDie(10);}
            case 17 -> {setDamageDie(12);}
            default -> {
            }
        }
    }

    @Override
    public String descreiption() {
        // TODO Auto-generated method stub
        return """
               Your practice of martial arts gives you mastery of\r
               combat styles that use your Unarmed Strike and\r
               Monk weapons, which are the following:\r
               Simple Melee weapons\r
               Martial Melee weapons that have the Light\r
               property\r
               You gain the following benefits while you are un-\r
               armed or wielding only Monk weapons and you\r
               aren't wearing armor or wielding a Shield.\r
               - I\r
               Bonus Unarmed Strike. You can make an Unarmed\r
               Strike as a Bonus Action.\r
               Martial Arts Die. You can roll ld6 in place of the\r
               normal damage of your Unarmed Strike or Monk\r
               weapons. This die changes as you gain Monk levels,\r
               as shown in the Martial Arts column of the Monk\r
               Features table.\r
               Dexterous Attacks. You can use your Dexterity\r
               modifier instead of your Strength modifier for the\r
               attack and damage rolls of your Unarmed Strikes\r
               and Monk weapons. In addition, when you use the\r
               Grapple or Shove option of your Unarmed Strike,\r
               you can use your Dexterity modifier instead of your\r
               Strength modifier to determine the save DC.""" //
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
        //
        //
        ;
    }

    
}
