package alan.spells.cantrips;

import alan.Constants;
import alan.Constants.DAMAGE_TYPE;
import alan.creatures.Creature;
import alan.grid_panel.Cell;
import alan.spells.SpellAbstract;
import alan.spells.SpellInterface;

public class TrueStrike extends SpellAbstract implements SpellInterface{

    public TrueStrike(){
        setSpellName("True Strike");
        setSpellLevel((byte) 0);
        setSchool(Constants.SCHOOL.DIVINATION);
        setDamage_type(Constants.DAMAGE_TYPE.RADIANT);
        setAction(true);
        setRange((short) 0);
        setDuration((byte) 0);
        setDamageDie(6);
        setQuantityOfDie(1);
    }

    @Override
    public void cast(Creature caster, Creature target, Creature[] targetList, Cell cell, DAMAGE_TYPE damage_type, int spellLevel) {
        // Default mellee attack
        switch (caster.getLevel()) {
            case 5 -> {target.damageHealth(rollDamage(getDamageDie(), 1));}
            case 11 -> {target.damageHealth(rollDamage(getDamageDie(), 2));}
            case 17 -> {target.damageHealth(rollDamage(getDamageDie(), 3));}
            default -> {}// Default mellee attack
        }
        
    }

    @Override
    public String descreiption() {
        return """
               Guided by a flash of magical insight, you make one attack with the weapon used in the spell's casting. The attack uses your spellcasting ability for the attack and damage rolls instead of using Strength or Dexterity. If the attack deals damage, it can be Radiant damage or the weapon's normal damage type (your choice).\r
               Cantrip Upgrade. Whether you deal Radiant damage or the weapon's normal damage type, the attack deals extra Radiant damage when you reach levels 5 (1d6), 11 (2d6), and 17 (3d6).""" //
        ;
    }

    @Override
    public void onLevelUp(int lvl) {
        // TODO Auto-generated method stub
        
    }

    
}
