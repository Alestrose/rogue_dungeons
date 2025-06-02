package alan.spells.cantrips;

import alan.Constants;
import alan.creatures.Creature;
import alan.grid_panel.Cell;
import alan.spells.SpellAbstract;
import alan.spells.SpellInterface;

public class Friends extends SpellAbstract implements SpellInterface{

    public Friends(Creature caster, Creature target, Creature[] targetList, Cell cell) {
        super(caster, target, targetList, cell);
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
    public void cast() {
        // No combat implementation
        
    }

    @Override
    public void castOnArea() {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void castOnTarget() {
        // TODO Auto-generated method stub
        
    }

    @Override
    public String descreiption() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void multiCast() {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void onLevelUp(int lvl) {
        // TODO Auto-generated method stub
        
    }
    
}
