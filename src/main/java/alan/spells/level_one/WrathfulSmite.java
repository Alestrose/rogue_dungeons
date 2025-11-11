package alan.spells.level_one;

import alan.Constants;
import alan.Constants.DAMAGE_TYPE;
import alan.creatures.Creature;
import alan.grid_panel.Cell;
import alan.spells.SpellAbstract;
import alan.spells.SpellInterface;

public class WrathfulSmite  extends SpellAbstract implements SpellInterface{

    public WrathfulSmite(){
        setSpellName("Wrathful Smite");
        setSpellLevel((byte) 1);
        setSchool(Constants.SCHOOL.EVOCATION);
        setDamage_type(Constants.DAMAGE_TYPE.PSYCHIC);
        setSavingThrow(Constants.ABILITY.WISDOM);
        setConcentration(true);
        setAction(true);
        setBonus(true);
        setRange((short) 0);
        setDuration((byte) 10);
        setDamageDie(6);
        setQuantityOfDie(1);
    }

    @Override       // Requires implementation to hit enemy and check to frighten
    public void cast(Creature caster, Creature target, Creature[] targetList, Cell cell, DAMAGE_TYPE damage_type, int spellLevel) {
        caster.setNextHitDamageRollIncrease(rollDamage(getDamageDie(), getQuantityOfDie()));
        
    }

    @Override
    public String descreiption() {
        // TODO Auto-generated method stub
        return "The next time you hit with a melee weapon attack during this spell's duration, your attack deals an extra 1d6 psychic damage. Additionally, if the target is a creature, it must make a Wisdom saving throw or be frightened of you until the spell ends. As an action, the creature can make a Wisdom check against your spell save DC to steel its resolve and end this spell.";
    }

    @Override
    public void onLevelUp(int lvl) {
        // TODO Auto-generated method stub
        
    }

    
}
