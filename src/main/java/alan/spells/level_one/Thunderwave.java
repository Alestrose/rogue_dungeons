package alan.spells.level_one;

import alan.Constants;
import alan.Constants.DAMAGE_TYPE;
import alan.creatures.Creature;
import alan.grid_panel.Cell;
import alan.spells.SpellAbstract;
import alan.spells.SpellInterface;

public class Thunderwave  extends SpellAbstract implements SpellInterface{
    public Thunderwave(){
        setSpellName("Thunderwave");
        setSpellLevel((byte) 1);
        setSchool(Constants.SCHOOL.EVOCATION);
        setDamage_type(Constants.DAMAGE_TYPE.THUNDER);
        setSavingThrow(Constants.ABILITY.CONSTITUTION);
        setAction(true);
        setRange((short) 15);
        setDuration((byte) 0);
        setDamageDie(8);
        setQuantityOfDie(2);
    }

    @Override       // Requires implementation for push back mechanic
    public void cast(Creature caster, Creature target, Creature[] targetList, Cell cell, DAMAGE_TYPE damage_type, int spellLevel) {
        levelSpellPrimaryDie(1, spellLevel);

        for (Creature creature : targetList) {
            if(!rollSpellSaveCheck(target, caster, getSavingThrow())){
                creature.damageHealth(rollDamage(getDamageDie(), getQuantityOfDie()));
            }else{
                creature.damageHealth((int)(rollDamage(getDamageDie(), getQuantityOfDie()))/2);
            }
        }
        
    }

    @Override
    public String descreiption() {
        // TODO Auto-generated method stub
        return """
               A wave of thunderous force sweeps out from you. Each creature in a 15-foot cube originating from you must make a Constitution saving throw. On a failed save, a creature takes 2d8 thunder damage and is pushed 10 feet away from you. On a successful save, the creature takes half as much damage and isn't pushed.\r
               In addition, unsecured objects that are completely within the area of effect are automatically pushed 10 feet away from you by the spell's effect, and the spell emits a thunderous boom audible out to 300 feet.\r
               At Higher Levels. When you cast this spell using a spell slot of 2nd level or higher, the damage increases by 1d8 for each slot level above 1st.""" //
        //
        ;
    }

    @Override
    public void onLevelUp(int lvl) {
        // TODO Auto-generated method stub
        
    }

    
}
