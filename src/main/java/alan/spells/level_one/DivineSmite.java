package alan.spells.level_one;

import alan.Constants;
import alan.Constants.DAMAGE_TYPE;
import alan.creatures.Creature;
import alan.grid_panel.Cell;
import alan.spells.SpellAbstract;
import alan.spells.SpellInterface;

public class DivineSmite extends SpellAbstract implements SpellInterface{

    public DivineSmite(){
        setSpellName("Divine Smite");
        setSpellLevel((byte) 1);
        setSchool(Constants.SCHOOL.EVOCATION);
        setDamage_type(Constants.DAMAGE_TYPE.RADIANT);
        setSavingThrow(Constants.ABILITY.WISDOM);
        setConcentration(true);
        setAction(true);
        setBonus(true);
        setRange((short) 0);
        setDuration((byte) 10);
        setDamageDie(8);
        setQuantityOfDie(2);
    }

    @Override
    public void cast(Creature caster, Creature target, Creature[] targetList, Cell cell, DAMAGE_TYPE damage_type, int spellLevel) {
        levelSpellPrimaryDie(1, spellLevel);
        caster.setNextHitDamageRollIncrease(rollDamage(getDamageDie(), getQuantityOfDie()));
        
    }

    @Override
    public String descreiption() {
        // TODO Auto-generated method stub
        return """
               The target takes an extra 2d8 Radiant damage from the attack. The damage increases by 1d8 if the target is a Fiend or an Undead.\r
               \r
               Using a Higher-Level Spell Slot. The damage increases by 1d8 for each spell slot level above 1""" //
        //
        ;
    }

    @Override
    public void onLevelUp(int lvl) {
        // TODO Auto-generated method stub
        
    }

    
}
