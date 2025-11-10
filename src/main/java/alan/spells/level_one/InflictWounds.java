package alan.spells.level_one;

import alan.Constants;
import alan.Constants.DAMAGE_TYPE;
import alan.creatures.Creature;
import alan.grid_panel.Cell;
import alan.spells.SpellAbstract;
import alan.spells.SpellInterface;

public class InflictWounds extends SpellAbstract implements SpellInterface{

    public InflictWounds(){
        setSpellName("Inflict Wounds");
        setSpellLevel((byte) 1);
        setSchool(Constants.SCHOOL.NECROMANCY);
        setDamage_type(Constants.DAMAGE_TYPE.NECROTIC);
        setSpellAttack(true);
        setAction(true);
        setRange((short) 5);
        setDamageDie(10);
        setQuantityOfDie(3);
    }

    @Override
    public void cast(Creature caster, Creature target, Creature[] targetList, Cell cell, DAMAGE_TYPE damage_type, int spellLevel) {
        levelSpellPrimaryDie(1, spellLevel);
        
        if(rollToHitAC(target, caster)){
            target.damageHealth(rollDamage(getDamageDie(), getQuantityOfDie()));
        }
    }

    @Override
    public String descreiption() {
        return """
               Make a melee spell attack against a creature you can reach. On a hit, the target takes 3d10 necrotic damage.\r
               At Higher Levels. When you cast this spell using a spell slot of 2nd level or higher, the damage increases by 1d10 for each slot level above 1st.""" //
        ;
    }

    @Override
    public void onLevelUp(int lvl) {
        // TODO Auto-generated method stub
        
    }

    
}
