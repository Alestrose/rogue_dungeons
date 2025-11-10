package alan.spells.level_one;

import alan.Constants;
import alan.Constants.DAMAGE_TYPE;
import alan.creatures.Creature;
import alan.grid_panel.Cell;
import alan.spells.SpellAbstract;
import alan.spells.SpellInterface;

public class Identify extends SpellAbstract implements SpellInterface{

    public Identify(){
        setSpellName("Identify");
        setSpellLevel((byte) 1);
        setSchool(Constants.SCHOOL.DIVINATION);
        setSpellAttack(true);
        setRitual(true);
        setRange((short) 5);
    }

    @Override
    public void cast(Creature caster, Creature target, Creature[] targetList, Cell cell, DAMAGE_TYPE damage_type,
            int spellLevel) {
        // Identifies magic item
        
    }

    @Override
    public String descreiption() {
        return """
               You choose one object that you must touch throughout the casting of the spell. If it is a magic item or some other magic-imbued object, you learn its properties and how to use them, whether it requires attunement to use, and how many charges it has, if any. You learn whether any spells are affecting the item and what they are. If the item was created by a spell, you learn which spell created it.\r
               If you instead touch a creature throughout the casting, you learn what spells, if any, are currently affecting it.""" //
        ;
    }

    @Override
    public void onLevelUp(int lvl) {
        // TODO Auto-generated method stub
        
    }

}
