package alan.spells.cantrips;

import alan.Constants;
import alan.creatures.Creature;
import alan.grid_panel.Cell;
import alan.spells.SpellAbstract;
import alan.spells.SpellInterface;

public class BladeWard extends SpellAbstract implements SpellInterface{

    public BladeWard(){
        setSpellName("Blade Ward");
        setSpellLevel((byte) 0);
        setSchool(Constants.SCHOOL.ABJURATION);
        setConcentration(true);
        setAction(true);
        setRange((short) 0);
        setDuration((byte) 10);
    }

    @Override
    public void cast(Creature caster, Creature target, Creature[] targetList, Cell cell, Constants.DAMAGE_TYPE damage_type, int spellLevel) {
        target.setAttackRollReduction(4);
    }

    @Override
    public String descreiption() {
        return "Whenever a creature makes an attack roll against you before the spell ends, the attacker subtracts 1d4 from the attack roll";
    }

    @Override
    public void onLevelUp(int lvl) {
   
    }

    
}
