package alan.spells.cantrips;

import alan.Constants;
import alan.creatures.Creature;
import alan.grid_panel.Cell;
import alan.spells.SpellAbstract;
import alan.spells.SpellInterface;

public class SorcerousBurst extends SpellAbstract implements SpellInterface{

    public SorcerousBurst(){
        setSpellName("Sorcerous Burst");
        setSpellLevel((byte) 0);
        setSchool(Constants.SCHOOL.EVOCATION);
        setSpellAttack(true);
        setAction(true);
        setRange((short) 120);
        setDuration((byte) 0);
        setDamageDie(10);
        setQuantityOfDie(1);
    }

    @Override
    public void cast(Creature caster, Creature target, Creature[] targetList, Cell cell, Constants.DAMAGE_TYPE damage_type) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public String descreiption() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void onLevelUp(int lvl) {
        // TODO Auto-generated method stub
        
    }

}
