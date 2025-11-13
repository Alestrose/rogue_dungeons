package alan.spells.level_one;

import alan.Constants;
import alan.Constants.DAMAGE_TYPE;
import alan.creatures.Creature;
import alan.grid_panel.Cell;
import alan.spells.SpellAbstract;
import alan.spells.SpellInterface;

public class HuntersMark extends SpellAbstract implements SpellInterface{
    
    public HuntersMark(){
        setSpellName("Hunters Mark");
        setSpellLevel((byte) 1);
        setSchool(Constants.SCHOOL.DIVINATION);
        setDamage_type(Constants.DAMAGE_TYPE.FORCE);
        setConcentration(true);
        setBonus(true);
        setRange((short) 90);
        setDuration((byte) 100);
        setDamageDie(6);
        setQuantityOfDie(1);
    }

    @Override
    public void cast(Creature caster, Creature target, Creature[] targetList, Cell cell, DAMAGE_TYPE damage_type, int spellLevel) {
        target.ApplyConditionEffect(Constants.CONDITION_KEY.HUNTERS_MARKED, caster);
    }

    @Override
    public String descreiption() {
        // TODO Auto-generated method stub
        return """
               You magically mark one creature you can see within range as your quarry. Until the spell ends, you deal an extra 1d6 Force damage to the target whenever you hit it with an attack roll. You also have Advantage on any Wisdom (Perception or Survival) check you make to find it.\r
               If the target drops to 0 Hit Points before this spell ends, you can use a Bonus Action to mark a new creature you can see within range.""" //
        ;
    }

    @Override
    public void onLevelUp(int lvl) {
        // TODO Auto-generated method stub
        
    }

    
}
