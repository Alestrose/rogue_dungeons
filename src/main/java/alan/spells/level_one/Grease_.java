package alan.spells.level_one;

import alan.Constants;
import alan.Constants.DAMAGE_TYPE;
import alan.creatures.Creature;
import alan.grid_panel.Cell;
import alan.spells.SpellAbstract;
import alan.spells.SpellInterface;

public class Grease_ extends SpellAbstract implements SpellInterface{
    public Grease_(){
        setSpellName("Grease");
        setSpellLevel((byte) 1);
        setSchool(Constants.SCHOOL.CONJURATION);
        setSavingThrow(Constants.ABILITY.DEXTERITY);
        setAction(true);
        setRange((short) 60);
        setDuration((byte) 10);
    }

    @Override
    public void cast(Creature caster, Creature target, Creature[] targetList, Cell cell, DAMAGE_TYPE damage_type,
            int spellLevel) {
        // Effects Terrain
    }

    @Override
    public String descreiption() {
        return """
               Nonflammable grease covers the ground in a 10-foot square centered on a point within range and turns it into Difficult Terrain for the duration.\r
               When the grease appears, each creature standing in its area must succeed on a Dexterity saving throw or have the Prone condition. A creature that enters the area or ends its turn there must also succeed on that save or fall Prone.""" //
        ;
    }

    @Override
    public void onLevelUp(int lvl) {
        // TODO Auto-generated method stub
        
    }
    
}
