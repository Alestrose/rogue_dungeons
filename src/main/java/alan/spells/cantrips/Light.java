package alan.spells.cantrips;

import alan.Constants;
import alan.creatures.Creature;
import alan.grid_panel.Cell;
import alan.spells.SpellAbstract;
import alan.spells.SpellInterface;

public class Light extends SpellAbstract implements SpellInterface{

    public Light(){
        setSpellName("Light");
        setSpellLevel((byte) 0);
        setSchool(Constants.SCHOOL.EVOCATION);
        setAction(true);
        setRange((short) 0);
        setDuration((byte) 600);
    }

    @Override
    public void cast(Creature caster, Creature target, Creature[] targetList, Cell cell) {
        // No combat implementation
        
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
