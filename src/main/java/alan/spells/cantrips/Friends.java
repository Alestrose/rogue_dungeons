package alan.spells.cantrips;

import alan.Constants;
import alan.creatures.Creature;
import alan.grid_panel.Cell;
import alan.spells.SpellAbstract;
import alan.spells.SpellInterface;

public class Friends extends SpellAbstract implements SpellInterface{

    public Friends() {
        setSpellName("Friends");
        setSpellLevel((byte) 0);
        setSchool(Constants.SCHOOL.ENCHANTMENT);
        setDamage_type(Constants.DAMAGE_TYPE.FORCE);
        setConcentration(true);
        setAction(true);
        setRange((short) 10);
        setDuration((byte) 0);
    }

    @Override
    public void cast(Creature caster, Creature target, Creature[] targetList, Cell cell, Constants.DAMAGE_TYPE damage_type) {
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
