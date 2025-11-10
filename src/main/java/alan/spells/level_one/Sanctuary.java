package alan.spells.level_one;

import alan.Constants;
import alan.Constants.DAMAGE_TYPE;
import alan.creatures.Creature;
import alan.grid_panel.Cell;
import alan.spells.SpellAbstract;
import alan.spells.SpellInterface;

public class Sanctuary extends SpellAbstract implements SpellInterface{
    public Sanctuary(){
        setSpellName("Sanctuary");
        setSpellLevel((byte) 1);
        setSchool(Constants.SCHOOL.ABJURATION);
        setSavingThrow(Constants.ABILITY.WISDOM);
        setBonus(true);
        setRange((short) 30);
        setDuration((byte) 10);
    }

    @Override
    public void cast(Creature caster, Creature target, Creature[] targetList, Cell cell, DAMAGE_TYPE damage_type, int spellLevel) {
        target.ApplyConditionEffect(Constants.CONDITION_KEY.SANCTUARY, caster);
        
    }

    @Override
    public String descreiption() {
        // TODO Auto-generated method stub
        return """
               You ward a creature within range against attack. Until the spell ends, any creature who targets the warded creature with an attack or a harmful spell must first make a Wisdom saving throw. On a failed save, the creature must choose a new target or lose the attack or spell. This spell doesn't protect the warded creature from area effects, such as the explosion of a fireball.\r
               If the warded creature makes an attack, casts a spell that affects an enemy creature, or deal dommage to another creature, this spell ends.""" //
        ;
    }

    @Override
    public void onLevelUp(int lvl) {
        // TODO Auto-generated method stub
        
    }

    
}
