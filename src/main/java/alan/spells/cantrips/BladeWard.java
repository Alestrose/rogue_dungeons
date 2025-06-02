package alan.spells.cantrips;

import alan.Constants;
import alan.creatures.Creature;
import alan.grid_panel.Cell;
import alan.spells.SpellAbstract;
import alan.spells.SpellInterface;

public class BladeWard  extends SpellAbstract implements SpellInterface{

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
    public void castOnArea(Creature caster, Cell cell) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void castOnTarget(Creature caster, Creature target) {
        caster.setEnemyAttackRollReduction(4);
    }

    @Override
    public String descreiption() {
        return "Whenever a creature makes an attack roll against you before the spell ends, the attacker subtracts 1d4 from the attack roll";
    }

    
}
