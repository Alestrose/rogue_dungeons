package alan.spells.level_one;

import alan.Constants;
import alan.Constants.DAMAGE_TYPE;
import alan.creatures.Creature;
import alan.grid_panel.Cell;
import alan.spells.SpellAbstract;
import alan.spells.SpellInterface;

public class WitchBolt  extends SpellAbstract implements SpellInterface{

    Creature witchBoltLinked;
    
    public WitchBolt(){
        setSpellName("Witch Bolt");
        setSpellLevel((byte) 1);
        setSchool(Constants.SCHOOL.EVOCATION);
        setDamage_type(Constants.DAMAGE_TYPE.LIGHTNING);
        setSpellAttack(true);
        setConcentration(true);
        setAction(true);
        setRange((short) 30);
        setDuration((byte) 10);
        setDamageDie(12);
        setQuantityOfDie(1);
    }

    @Override
    public void cast(Creature caster, Creature target, Creature[] targetList, Cell cell, DAMAGE_TYPE damage_type, int spellLevel) {
        levelSpellPrimaryDie(1, spellLevel);
        
        // If already linked to target, deal damage without to hit AC check
        if(getWitchBoltLinked().equals(target)){
            target.damageHealth(rollDamage(getDamageDie(), getQuantityOfDie()));
        }else if(rollToHitACSpellAttack(target, caster)){
            target.damageHealth(rollDamage(getDamageDie(), getQuantityOfDie()));
            setWitchBoltLinked(target);     // Links to target on hit
        }
    }

    @Override
    public String descreiption() {
        // TODO Auto-generated method stub
        return """
               A beam of crackling, blue energy lances out toward a creature within range, forming a sustained arc of lightning between you and the target. Make a ranged spell attack against that creature. On a hit, the target takes 1d12 lightning damage, and on each of your turns for the duration, you can use your action to deal 1d12 lightning damage to the target automatically. The spell ends if you use your action to do anything else. The spell also ends if the target is ever outside the spell's range or if it has total cover from you.\r
               At Higher Levels. When you cast this spell using a spell slot of 2nd level or higher, the initial damage increases by 1d12 for each slot level above 1st.""" //
        ;
    }

    @Override
    public void onLevelUp(int lvl) {
        // TODO Auto-generated method stub
        
    }

    public Creature getWitchBoltLinked() {
        return witchBoltLinked;
    }

    public void setWitchBoltLinked(Creature witchBoltLinked) {
        this.witchBoltLinked = witchBoltLinked;
    }

    

    
}
