package alan.spells.level_one;

import alan.Constants;
import alan.Constants.DAMAGE_TYPE;
import alan.creatures.Creature;
import alan.grid_panel.Cell;
import alan.spells.SpellAbstract;
import alan.spells.SpellInterface;

public class Bless extends SpellAbstract implements SpellInterface{

    public Bless(){
        setSpellName("Bless");
        setSpellLevel((byte) 1);
        setSchool(Constants.SCHOOL.ENCHANTMENT);
        setConcentration(true);
        setAction(true);
        setRange((short) 30);
        setDuration((byte) 10);
        setMultiCastHits(3);
    }

    @Override
    public void cast(Creature caster, Creature target, Creature[] targetList, Cell cell, DAMAGE_TYPE damage_type, int spellLevel) {
        levelMultiCastHits(1, spellLevel);

        for (Creature creature : targetList) {
            creature.setAttackRollIncrease(4);
            creature.setSavingThrowIncrease(4);
        }
        
    }

    @Override
    public String descreiption() {
        return """
               You bless up to three creatures within range. Whenever a target makes an attack roll or a saving throw before the spell ends, the target adds 1d4 to the attack roll or save.\r
               Using a Higher-Level Spell Slot. You can target one additional creature for each spell slot level above 1.""" //
        ;
    }

    @Override
    public void onLevelUp(int lvl) {
        // TODO Auto-generated method stub
        
    }
    

}
