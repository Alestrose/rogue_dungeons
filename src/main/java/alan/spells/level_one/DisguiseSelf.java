package alan.spells.level_one;

import alan.Constants;
import alan.Constants.DAMAGE_TYPE;
import alan.creatures.Creature;
import alan.grid_panel.Cell;
import alan.spells.SpellAbstract;
import alan.spells.SpellInterface;

public class DisguiseSelf extends SpellAbstract implements SpellInterface{

    public DisguiseSelf(){
        setSpellName("Disguise Self");
        setSpellLevel((byte) 1);
        setSchool(Constants.SCHOOL.ILLUSION);
        setSavingThrow(Constants.ABILITY.INTELLIGENCE);
        setConcentration(true);
        setAction(true);
        setRange((short) 0);
        setDuration((byte) 600);
    }

    @Override
    public void cast(Creature caster, Creature target, Creature[] targetList, Cell cell, DAMAGE_TYPE damage_type,
            int spellLevel) {
        // No Combat Implementation
        
    }

    @Override
    public String descreiption() {
        return """
               You make yourself\u2014including your clothing, armor, weapons, and other belongings on your person\u2014look different until the spell ends. You can seem 1 foot shorter or taller and can appear heavier or lighter. You must adopt a form that has the same basic arrangement of limbs as you have. Otherwise, the extent of the illusion is up to you.\r
               The changes wrought by this spell fail to hold up to physical inspection. For example, if you use this spell to add a hat to your outfit, objects pass through the hat, and anyone who touches it would feel nothing.\r
               To discern that you are disguised, a creature must take the Study action to inspect your appearance and succeed on an Intelligence (Investigation) check against your spell save DC.""" //
        //
        ;
    }

    @Override
    public void onLevelUp(int lvl) {
        // TODO Auto-generated method stub
        
    }
    

}
