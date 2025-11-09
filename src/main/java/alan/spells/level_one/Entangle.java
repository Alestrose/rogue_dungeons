package alan.spells.level_one;

import alan.Constants;
import alan.Constants.DAMAGE_TYPE;
import alan.creatures.Creature;
import alan.grid_panel.Cell;
import alan.spells.SpellAbstract;
import alan.spells.SpellInterface;

public class Entangle extends SpellAbstract implements SpellInterface{
    public Entangle(){
        setSpellName("Entangle");
        setSpellLevel((byte) 1);
        setSchool(Constants.SCHOOL.CONJURATION);
        setSavingThrow(Constants.ABILITY.STRENGTH);
        setConcentration(true);
        setAction(true);
        setRange((short) 90);
        setDuration((byte) 10);
    }

    @Override
    public void cast(Creature caster, Creature target, Creature[] targetList, Cell cell, DAMAGE_TYPE damage_type,
            int spellLevel) {
        target.ApplyConditionEffect(Constants.CONDITION_KEY.RESTRAINED, caster);
        
    }

    @Override
    public String descreiption() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void onLevelUp(int lvl) {
        // TODO Auto-generated method stub
        
    }
    
}
