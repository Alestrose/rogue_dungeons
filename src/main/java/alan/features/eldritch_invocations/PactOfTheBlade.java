package alan.features.eldritch_invocations;

import alan.Constants;
import alan.Constants.DAMAGE_TYPE;
import alan.creatures.Creature;
import alan.features.FeatureAbstract;
import alan.grid_panel.Cell;

public class PactOfTheBlade extends FeatureAbstract{

    public PactOfTheBlade() {
        setClassFeatureKey(Constants.FEATURE.PACT_OF_THE_BLADE);
        setBonus(true);
        setActive(true);
        setFeatureLevel(1);
        setFeatType(Constants.FEAT_TYPE.ELDRITCH_INVOCATION);
    }

    @Override
    public void cast(Creature caster, Creature target, Creature[] targetList, Cell cell, DAMAGE_TYPE damage_type,
            int spellLevel) {
        // Sets attack roll bonus to charisma modifier based on melle or ranged weapon
        if (caster.getEquipment().getMainHand().isMelee()) {
            caster.setMelleeAttackRollBonus(caster.getAbilities().get(Constants.ABILITY.CHARISMA).getAbilityMod());
        }else caster.setRangedAttackRollBonus(caster.getAbilities().get(Constants.ABILITY.CHARISMA).getAbilityMod());

        caster.getEquipment().getMainHand().setPactWeapon(true);
    }

    @Override
    public String descreiption() {
        // TODO Auto-generated method stub
        return """
               As a Bonus Action, you can conjure a pact weapon\r
               in your hand- a Simple or Martial Melee weapon of\r
               your choice with which you bond- or create a bond\r
               with a magic weapon you touch; you can't bond\r
               with a magic weapon if someone else is attuned to\r
               it or another Warlock is bonded w ith i . Unt il the\r
               bond ends, you have proficiency with the weapon,\r
               and you can use it as a Spellcasting Focus.\r
               Whenever you attack with the bonded weapon,\r
               you can use your Charisma modifier for the at-\r
               tack and damage rolls instead of using Strength or\r
               Dexterity; and you can cause the weapon to deal\r
               Necrotic, Psychic, or Radiant damage or its normal\r
               damage type.\r
               Your bond with the weapon ends if you use this\r
               feature's Bonus Action again, if the weapon is more\r
               than S feet away from you for 1 minute or more, or\r
               if you die. A conjured weapon disappears when the\r
               bond ends.""" //
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
