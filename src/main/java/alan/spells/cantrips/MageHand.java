package alan.spells.cantrips;

import alan.Constants;
import alan.creatures.Creature;
import alan.grid_panel.Cell;
import alan.spells.SpellAbstract;
import alan.spells.SpellInterface;

public class MageHand extends SpellAbstract implements SpellInterface{

    public MageHand() {
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
    public void cast(Creature caster, Creature target, Creature[] targetList, Cell cell, Constants.DAMAGE_TYPE damage_type, int spellLevel) {
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
