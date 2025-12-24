package alan.spells.level_one;

import alan.Constants;
import alan.Constants.DAMAGE_TYPE;
import alan.creatures.Creature;
import alan.grid_panel.Cell;
import alan.spells.SpellAbstract;
import alan.spells.SpellInterface;

public class RayOfSickness extends SpellAbstract implements SpellInterface{

    public RayOfSickness(){
        setSpellName("Ray Of Sickness");
        setSpellLevel((byte) 1);
        setSchool(Constants.SCHOOL.NECROMANCY);
        setDamage_type(Constants.DAMAGE_TYPE.POISON);
        setSavingThrow(Constants.ABILITY.CONSTITUTION);
        setSpellAttack(true);
        setAction(true);
        setRange((short) 60);
        setDamageDie(8);
        setQuantityOfDie(2);
    }

    @Override
    public void cast(Creature caster, Creature target, Creature[] targetList, Cell cell, DAMAGE_TYPE damage_type, int spellLevel) {
        levelSpellPrimaryDie(1, spellLevel);
        
        // If hit Ac deal damage
        rollToHitAcMeleeSpellAttack(target, caster, getSavingThrow(), () -> target.applyDamage(rollDamage(getDamageDie(), getQuantityOfDie()), damage_type));
        // If target fails constitution save, apply poisoned condition
        rollSpellSaveCheck(target, caster, getSavingThrow(),
            () -> {},
            () -> target.ApplyConditionEffect(Constants.CONDITION_KEY.POISONED, caster));
    }

    @Override
    public String descreiption() {
        // TODO Auto-generated method stub
        return """
               A ray of sickening greenish energy lashes out toward a creature within range. Make a ranged spell attack against the target. On a hit, the target takes 2d8 poison damage and must make a Constitution saving throw. On a failed save, it is also poisoned until the end of your next turn.\r
               At Higher Levels. When you cast this spell using a spell slot of 2nd level or higher, the damage increases by 1d8 for each slot level above 1st.""" //
        ;
    }

    @Override
    public void onLevelUp(int lvl) {
        // TODO Auto-generated method stub
        
    }

    
}
