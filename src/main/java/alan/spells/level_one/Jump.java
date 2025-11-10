package alan.spells.level_one;

import alan.Constants;
import alan.Constants.DAMAGE_TYPE;
import alan.creatures.Creature;
import alan.grid_panel.Cell;
import alan.spells.SpellAbstract;
import alan.spells.SpellInterface;

public class Jump extends SpellAbstract implements SpellInterface{

    public Jump(){
        setSpellName("Jump");
        setSpellLevel((byte) 1);
        setSchool(Constants.SCHOOL.TRANSMUTATION);
        setAction(true);
        setRange((short) 5);
        setDuration((byte) 10);
    }

    @Override
    public void cast(Creature caster, Creature target, Creature[] targetList, Cell cell, DAMAGE_TYPE damage_type, int spellLevel) {
        target.setJumpDistance(target.getJumpDistance() * 3);
    }

    @Override
    public String descreiption() {
        // TODO Auto-generated method stub
        return "You touch a creature. The creature's jump distance is tripled until the spell ends.";
    }

    @Override
    public void onLevelUp(int lvl) {
        // TODO Auto-generated method stub
        
    }

    
}
