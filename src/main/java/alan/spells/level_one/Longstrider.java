package alan.spells.level_one;

import alan.Constants;
import alan.Constants.DAMAGE_TYPE;
import alan.creatures.Creature;
import alan.grid_panel.Cell;
import alan.spells.SpellAbstract;
import alan.spells.SpellInterface;

public class Longstrider extends SpellAbstract implements SpellInterface{

    public Longstrider(){
        setSpellName("Longstrider");
        setSpellLevel((byte) 1);
        setSchool(Constants.SCHOOL.TRANSMUTATION);
        setAction(true);
        setRange((short) 5);
        setDuration((byte) 100);
    }

    @Override
    public void cast(Creature caster, Creature target, Creature[] targetList, Cell cell, DAMAGE_TYPE damage_type, int spellLevel) {
        levelMultiCastHits(1, spellLevel);
        
        for (Creature creature : targetList) {
            creature.setSpeed(target.getSpeed() + 10);
        }
    }

    @Override
    public String descreiption() {
        // TODO Auto-generated method stub
        return """
               You touch a creature. The target's speed increases by 10 feet until the spell ends.\r
               At Higher Levels. When you cast this spell using a spell slot of 2nd level or higher, you can target one additional creature for each slot level above 1st.""" //
        ;
    }

    @Override
    public void onLevelUp(int lvl) {
        // TODO Auto-generated method stub
        
    }

    
}
