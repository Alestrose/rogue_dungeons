package alan.spells.cantrips;

import alan.Constants;
import alan.creatures.Creature;
import alan.grid_panel.Cell;
import alan.spells.SpellAbstract;
import alan.spells.SpellInterface;

public class MageHand extends SpellAbstract implements SpellInterface{

    public MageHand(Creature caster, Creature target, Creature[] targetList, Cell cell) {
        super(caster, target, targetList, cell);
        setSpellName("Mage Hand");
        setSpellLevel((byte) 0);
        setSchool(Constants.SCHOOL.CONJURATION);
        setAction(true);
        setBonus(true);
        setReaction(true);
        setRange((short) 30);
        setDuration((byte) 10);
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
