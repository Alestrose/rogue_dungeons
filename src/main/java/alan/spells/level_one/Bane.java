package alan.spells.level_one;

import alan.Constants;
import alan.Constants.DAMAGE_TYPE;
import alan.creatures.Creature;
import alan.grid_panel.Cell;
import alan.spells.SpellAbstract;
import alan.spells.SpellInterface;

public class Bane extends SpellAbstract implements SpellInterface{

    public Bane(){
        setSpellName("Bane");
        setSpellLevel((byte) 1);
        setSchool(Constants.SCHOOL.ENCHANTMENT);
        setSavingThrow(Constants.ABILITY.CHARISMA);
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
            creature.setAttackRollReduction(4);
            creature.setSavingThrowDecrease(4);
        }
        
    }

    @Override
    public String descreiption() {
        return """
               Up to three creatures of your choice that you can see within range must each make a Charisma saving throw. Whenever a target that fails this save makes an attack roll or a saving throw before the spell ends, the target must subtract 1d4 from the attack roll or save.\r
               Using a Higher-Level Spell Slot. You can target one additional creature for each spell slot level above 1.""" //
        ;
    }

    @Override
    public void onLevelUp(int lvl) {
        // TODO Auto-generated method stub
        
    }

    
}
