package alan.spells.cantrips;

import alan.Constants;
import alan.creatures.Creature;
import alan.grid_panel.Cell;
import alan.spells.SpellAbstract;
import alan.spells.SpellInterface;

public class Mending extends SpellAbstract implements SpellInterface{

    public Mending() {
        setSpellName("Mending");
        setSpellLevel((byte) 0);
        setSchool(Constants.SCHOOL.TRANSMUTATION);
        setAction(true);
        setRange((short) 0);
    }

    @Override
    public void cast(Creature caster, Creature target, Creature[] targetList, Cell cell, Constants.DAMAGE_TYPE damage_type, int spellLevel) {
        // No combat implementation
        
    }

    @Override
    public String descreiption() {
        // TODO Auto-generated method stub
        return """
               This spell repairs a single break or tear in an object you touch, such as a broken chain link, two halves of a broken key, a torn cloak, or a leaking wineskin. As long as the break or tear is no larger than 1 foot in any dimension, you mend it, leaving no trace of the former damage.\r
               This spell can physically repair a magic item, but it can't restore magic to such an object.""" //
        ;
    }

    @Override
    public void onLevelUp(int lvl) {
        // TODO Auto-generated method stub
        
    }

}
