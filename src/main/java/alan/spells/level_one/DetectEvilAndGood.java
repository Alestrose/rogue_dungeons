package alan.spells.level_one;

import alan.Constants;
import alan.Constants.DAMAGE_TYPE;
import alan.creatures.Creature;
import alan.grid_panel.Cell;
import alan.spells.SpellAbstract;
import alan.spells.SpellInterface;

public class DetectEvilAndGood extends SpellAbstract implements SpellInterface{

    public DetectEvilAndGood(){
        setSpellName("Detect Evil And Good");
        setSpellLevel((byte) 1);
        setSchool(Constants.SCHOOL.DIVINATION);
        setConcentration(true);
        setAction(true);
        setRange((short) 0);
        setDuration((byte) 0);
    }

    @Override
    public void cast(Creature caster, Creature target, Creature[] targetList, Cell cell, DAMAGE_TYPE damage_type,
            int spellLevel) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public String descreiption() {
        return """
               For the duration, you sense the location of any Aberration, Celestial, Elemental, Fey, Fiend, or Undead within 30 feet of yourself. You also sense whether the Hallow spell is active there and, if so, where.\r
               The spell is blocked by 1 foot of stone, dirt, or wood; 1 inch of metal; or a thin sheet of lead.""" //
        ;
    }

    @Override
    public void onLevelUp(int lvl) {
        // TODO Auto-generated method stub
        
    }
    

}
