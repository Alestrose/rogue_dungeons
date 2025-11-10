package alan.spells.level_one;

import alan.Constants;
import alan.Constants.DAMAGE_TYPE;
import alan.creatures.Creature;
import alan.grid_panel.Cell;
import alan.spells.SpellAbstract;
import alan.spells.SpellInterface;

public class SearingSmite extends SpellAbstract implements SpellInterface{
    public SearingSmite(){
        setSpellName("Searing Smite");
        setSpellLevel((byte) 1);
        setSchool(Constants.SCHOOL.EVOCATION);
        setDamage_type(Constants.DAMAGE_TYPE.FIRE);
        setSavingThrow(Constants.ABILITY.CONSTITUTION);
        setConcentration(true);
        setBonus(true);
        setRange((short) 0);
        setDuration((byte) 10);
        setDamageDie(6);
        setQuantityOfDie(1);
    }

    // Requires more implementation when weapons and attacks are added
    @Override
    public void cast(Creature caster, Creature target, Creature[] targetList, Cell cell, DAMAGE_TYPE damage_type, int spellLevel) {
        levelSpellPrimaryDie(1, spellLevel);
        
        caster.setNextHitDamageRollIncrease(rollDamage(getDamageDie(), getQuantityOfDie()));
    }

    @Override
    public String descreiption() {
        // TODO Auto-generated method stub
        return """
               The next time you hit a creature with a melee weapon attack during the spell's duration, your weapon flares with white-hot intensity, and the attack deals an extra 1d6 fire damage to the target and causes the target to ignite in flames. At the start of each of its turns until the spell ends, the target must make a Constitution saving throw. On a failed save, it takes 1d6 fire damage. On a successful save, the spell ends. If the target or a creature within 5 feet of it uses an action to put out the flames, or if some other effect douses the flames (such as the target being submerged in water), the spell ends.\r
               At Higher Levels. When you cast this spell using a spell slot of 2nd level or higher, the initial extra damage dealt by the attack increases by 1d6 for each slot level above 1st.""" //
        ;
    }

    @Override
    public void onLevelUp(int lvl) {
        // TODO Auto-generated method stub
        
    }

    
}
