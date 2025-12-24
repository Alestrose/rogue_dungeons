package alan.spells.level_one;

import alan.Constants;
import alan.Constants.DAMAGE_TYPE;
import alan.creatures.Creature;
import alan.grid_panel.Cell;
import alan.spells.SpellAbstract;
import alan.spells.SpellInterface;

public class GuidingBolt extends SpellAbstract implements SpellInterface{
    public GuidingBolt(){
        setSpellName("Guiding Bolt");
        setSpellLevel((byte) 1);
        setSchool(Constants.SCHOOL.EVOCATION);
        setDamage_type(Constants.DAMAGE_TYPE.RADIANT);
        setSpellAttack(true);
        setAction(true);
        setRange((short) 120);
        setDuration((byte) 1);
        setDamageDie(6);
        setQuantityOfDie(4);
    }

    @Override
    public void cast(Creature caster, Creature target, Creature[] targetList, Cell cell, DAMAGE_TYPE damage_type, int spellLevel) {
        levelSpellPrimaryDie(1, spellLevel);
        
        target.applyDamage(rollDamage(getDamageDie(), getQuantityOfDie()), damage_type);
        target.isMelleeAttackRollAdvantage();     // Until end of targets next turn
    }

    @Override
    public String descreiption() {
        // TODO Auto-generated method stub
        return """
               A flash of light streaks toward a creature of your choice within range. Make a ranged spell attack against the target. On a hit, the target takes 4d6 radiant damage, and the next attack roll made against this target before the end of your next turn has advantage, thanks to the mystical dim light glittering on the target until then.\r
               At Higher Levels. When you cast this spell using a spell slot of 2nd level or higher, the damage increases by 1d6 for each slot level above 1st.""" //
        ;
    }

    @Override
    public void onLevelUp(int lvl) {
        // TODO Auto-generated method stub
        
    }
    
}
