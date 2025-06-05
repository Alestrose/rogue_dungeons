package alan.spells.level_one;

import alan.Constants;
import alan.Constants.DAMAGE_TYPE;
import alan.creatures.Creature;
import alan.grid_panel.Cell;
import alan.spells.SpellAbstract;
import alan.spells.SpellInterface;

public class Alarm extends SpellAbstract implements SpellInterface{

    public Alarm(){
        setSpellName("Alarm");
        setSpellLevel((byte) 1);
        setSchool(Constants.SCHOOL.ABJURATION);
        setRitual(true);
        setRange((short) 30);
        setDuration((byte) 0);
    }

    @Override
    public void cast(Creature caster, Creature target, Creature[] targetList, Cell cell, DAMAGE_TYPE damage_type, int spellLevel) {
        // No Combat Implementation
    }

    @Override
    public String descreiption() {
        return """
               You set an alarm against intrusion. Choose a door, a window, or an area within range that is no larger than a 20-foot Cube. Until the spell ends, an alarm alerts you whenever a creature touches or enters the warded area. When you cast the spell, you can designate creatures that won't set off the alarm. You also choose whether the alarm is audible or mental:\r
               Audible Alarm. The alarm produces the sound of a handbell for 10 seconds within 60 feet of the warded area.\r
               Mental Alarm. You are alerted by a mental ping if you are within 1 mile of the warded area. This ping awakens you if you're asleep.""" //
        //
        ;
    }

    @Override
    public void onLevelUp(int lvl) {
        // TODO Auto-generated method stub
        
    }
    

}
