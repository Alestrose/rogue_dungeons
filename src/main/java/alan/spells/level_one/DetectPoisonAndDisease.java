package alan.spells.level_one;

import alan.Constants;
import alan.Constants.DAMAGE_TYPE;
import alan.creatures.Creature;
import alan.grid_panel.Cell;
import alan.spells.SpellAbstract;
import alan.spells.SpellInterface;

public class DetectPoisonAndDisease extends SpellAbstract implements SpellInterface{

    public DetectPoisonAndDisease(){
        setSpellName("Detect Poison and Disease");
        setSpellLevel((byte) 1);
        setSchool(Constants.SCHOOL.DIVINATION);
        setSavingThrow(Constants.ABILITY.INTELLIGENCE);
        setConcentration(true);
        setAction(true);
        setRitual(true);
        setRange((short) 0);
        setDuration((byte) 100);
    }

    @Override
    public void cast(Creature caster, Creature target, Creature[] targetList, Cell cell, DAMAGE_TYPE damage_type,
            int spellLevel) {
        // No combat Implementation
        
    }

    @Override
    public String descreiption() {
        return """
               For the duration, you sense the location of poisons, poisonous or venomous creatures, and magical contagions within 30 feet of yourself. You sense the kind of poison, creature, or contagion in each case.\r
               The spell is blocked by 1 foot of stone, dirt, or wood; 1 inch of metal; or a thin sheet of lead.""" //
        ;
    }

    @Override
    public void onLevelUp(int lvl) {
        // TODO Auto-generated method stub
        
    }

    

}
