package alan.spells.level_one;

import alan.Constants;
import alan.Constants.DAMAGE_TYPE;
import alan.creatures.Creature;
import alan.grid_panel.Cell;
import alan.spells.SpellAbstract;
import alan.spells.SpellInterface;

public class CureWounds extends SpellAbstract implements SpellInterface{

    public CureWounds(){
        setSpellName("Cure Wounds");
        setSpellLevel((byte) 1);
        setSchool(Constants.SCHOOL.ABJURATION);
        setAction(true);
        setRange((short) 5);
        setDuration((byte) 0);
        setDamageDie(8);
        setQuantityOfDie(2);
    }

    @Override
    public void cast(Creature caster, Creature target, Creature[] targetList, Cell cell, DAMAGE_TYPE damage_type, int spellLevel) {
        levelSpellPrimaryDie(2, spellLevel);
        
        target.healHealth(rollDamage(getDamageDie(), getQuantityOfDie()));
        
    }

    @Override
    public String descreiption() {
        return """
               A creature you touch regains a number of Hit Points equal to 2d8 plus your spellcasting ability modifier.\r
               Using a Higher-Level Spell Slot. The healing increases by 2d8 for each spell slot level above 1.""" //
        ;
    }

    @Override
    public void onLevelUp(int lvl) {
        // TODO Auto-generated method stub
        
    }

    

}
