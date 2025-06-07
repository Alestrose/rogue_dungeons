package alan.spells.level_one;

import alan.Constants;
import alan.Constants.DAMAGE_TYPE;
import alan.creatures.Creature;
import alan.grid_panel.Cell;
import alan.spells.SpellAbstract;
import alan.spells.SpellInterface;

public class CompelledDuel extends SpellAbstract implements SpellInterface{

    public CompelledDuel(){
        setSpellName("Compelled Duel");
        setSpellLevel((byte) 1);
        setSchool(Constants.SCHOOL.ENCHANTMENT);
        setSavingThrow(Constants.ABILITY.WISDOM);
        setConcentration(true);
        setBonus(true);
        setRange((short) 30);
        setDuration((byte) 10);
    }

    @Override
    public void cast(Creature caster, Creature target, Creature[] targetList, Cell cell, DAMAGE_TYPE damage_type,
            int spellLevel) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public String descreiption() {
        // TODO Auto-generated method stub
        return """
               You try to compel a creature into a duel. One creature that you can see within range makes a Wisdom saving throw. On a failed save, the target has Disadvantage on attack rolls against creatures other than you, and it can't willingly move to a space that is more than 30 feet away from you.\r
               The spell ends if you make an attack roll against a creature other than the target, if you cast a spell on an enemy other than the target, if an ally of yours damages the target, or if you end your turn more than 30 feet away from the target.""" //
        ;
    }

    @Override
    public void onLevelUp(int lvl) {
        // TODO Auto-generated method stub
        
    }
    

}
