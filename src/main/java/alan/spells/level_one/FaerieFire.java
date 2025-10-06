package alan.spells.level_one;

import alan.Constants;
import alan.Constants.DAMAGE_TYPE;
import alan.creatures.Creature;
import alan.grid_panel.Cell;
import alan.spells.SpellAbstract;
import alan.spells.SpellInterface;

public class FaerieFire extends SpellAbstract implements SpellInterface{
    public FaerieFire(){
        setSpellName("Faerie Fire");
        setSpellLevel((byte) 1);
        setSchool(Constants.SCHOOL.EVOCATION);
        setSavingThrow(Constants.ABILITY.DEXTERITY);
        setSpellAttack(true);
        setConcentration(true);
        setAction(true);
        setBonus(true);
        setReaction(true);
        setRange((short) 120);
        setDuration((byte) 0);
        setDamageDie(10);
        setQuantityOfDie(1);
    }

    @Override
    public void cast(Creature caster, Creature target, Creature[] targetList, Cell cell, DAMAGE_TYPE damage_type,
            int spellLevel) {
        for (Creature creature : targetList) {
            creature.RemoveConditionEffect(Constants.CONDITION_KEY.INVISIBLE);
            
        }
        
        
    }

    @Override
    public String descreiption() {
        // TODO Auto-generated method stub
        return """
               Objects in a 20-foot Cube within range are outlined in blue, green, or violet light (your choice). Each creature in the Cube is also outlined if it fails a Dexterity saving throw. For the duration, objects and affected creatures shed Dim Light in a 10-foot radius and can't benefit from the Invisible condition.\r
               Attack rolls against an affected creature or object have Advantage if the attacker can see it.""" //
        ;
    }

    @Override
    public void onLevelUp(int lvl) {
        // TODO Auto-generated method stub
        
    }
    

}
