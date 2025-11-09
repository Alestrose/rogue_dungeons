package alan.spells.level_one;

import alan.Constants;
import alan.Constants.DAMAGE_TYPE;
import alan.creatures.Creature;
import alan.grid_panel.Cell;
import alan.spells.SpellAbstract;
import alan.spells.SpellInterface;

public class ColorSpray extends SpellAbstract implements SpellInterface{

    public ColorSpray(){
        setSpellName("Color Spray");
        setSpellLevel((byte) 1);
        setSchool(Constants.SCHOOL.ILLUSION);
        setSavingThrow(Constants.ABILITY.CONSTITUTION);
        setAction(true);
        setRange((short) 0);
        setDuration((byte) 0);
    }

    @Override
    public void cast(Creature caster, Creature target, Creature[] targetList, Cell cell, DAMAGE_TYPE damage_type,
            int spellLevel) {
        for (Creature creature : targetList) {
            creature.ApplyConditionEffect(Constants.CONDITION_KEY.BLINDED, caster);
        }
        
    }

    @Override
    public String descreiption() {
        return "You launch a dazzling array of flashing, colorful light. Each creature in a 15-foot Cone originating from you must succeed on a Constitution saving throw or have the Blinded condition until the end of your next turn.";
    }

    @Override
    public void onLevelUp(int lvl) {
        // TODO Auto-generated method stub
        
    }
    

}
