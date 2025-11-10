package alan.spells.level_one;

import alan.Constants;
import alan.Constants.DAMAGE_TYPE;
import alan.creatures.Creature;
import alan.grid_panel.Cell;
import alan.spells.SpellAbstract;
import alan.spells.SpellInterface;

public class MagicMissile extends SpellAbstract implements SpellInterface{

    public MagicMissile(){
        setSpellName("Magic Missile");
        setSpellLevel((byte) 1);
        setSchool(Constants.SCHOOL.EVOCATION);
        setDamage_type(Constants.DAMAGE_TYPE.FORCE);
        setAction(true);
        setRange((short) 120);
        setDamageDie(4);
        setQuantityOfDie(1);
        setMultiCastHits(3);
    }

    @Override
    public void cast(Creature caster, Creature target, Creature[] targetList, Cell cell, DAMAGE_TYPE damage_type, int spellLevel) {
        levelMultiCastHits(1, spellLevel);

        for (Creature creature : targetList) {
            creature.damageHealth(rollDamage(getDamageDie(), getQuantityOfDie()));
        }
    }

    @Override
    public String descreiption() {
        // TODO Auto-generated method stub
        return """
               You create three glowing darts of magical force. Each dart hits a creature of your choice that you can see within range. A dart deals 1d4 + 1 force damage to its target. The darts all strike simultaneously, and you can direct them to hit one creature or several.\r
               At Higher Levels. When you cast this spell using a spell slot of 2nd level or higher, the spell creates one more dart for each slot level above 1st.""" //
        ;
    }

    @Override
    public void onLevelUp(int lvl) {
        // TODO Auto-generated method stub
        
    }

    
}
