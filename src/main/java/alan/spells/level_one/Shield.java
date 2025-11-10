package alan.spells.level_one;

import alan.Constants;
import alan.Constants.DAMAGE_TYPE;
import alan.creatures.Creature;
import alan.grid_panel.Cell;
import alan.spells.SpellAbstract;
import alan.spells.SpellInterface;

public class Shield extends SpellAbstract implements SpellInterface{
    public Shield(){
        setSpellName("Shield");
        setSpellLevel((byte) 1);
        setSchool(Constants.SCHOOL.ABJURATION);
        setReaction(true);
        setRange((short) 0);
        setDuration((byte) 1);
    }

    @Override
    public void cast(Creature caster, Creature target, Creature[] targetList, Cell cell, DAMAGE_TYPE damage_type, int spellLevel) {
        caster.setTempAcBonus(5);
    }

    @Override
    public String descreiption() {
        // TODO Auto-generated method stub
        return "An invisible barrier of magical force appears and protects you. Until the start of your next turn, you have a +5 bonus to AC, including against the triggering attack, and you take no damage from magic missile.";
    }

    @Override
    public void onLevelUp(int lvl) {
        // TODO Auto-generated method stub
        
    }

    
}
