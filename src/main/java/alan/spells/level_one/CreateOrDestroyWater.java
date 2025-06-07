package alan.spells.level_one;

import alan.Constants;
import alan.Constants.DAMAGE_TYPE;
import alan.creatures.Creature;
import alan.grid_panel.Cell;
import alan.spells.SpellAbstract;
import alan.spells.SpellInterface;

public class CreateOrDestroyWater extends SpellAbstract implements SpellInterface{

    public CreateOrDestroyWater(){
        setSpellName("Create Or Destroy Water");
        setSpellLevel((byte) 1);
        setSchool(Constants.SCHOOL.TRANSMUTATION);
        setAction(true);
        setRange((short) 30);
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
               You do one of the following:\r
               Create Water. You create up to 10 gallons of clean water within range in an open container. Alternatively, the water falls as rain in a 30-foot Cube within range, extinguishing exposed flames there.\r
               Destroy Water. You destroy up to 10 gallons of water in an open container within range. Alternatively, you destroy fog in a 30-foot Cube within range.\r
               Using a Higher-Level Spell Slot. You create or destroy 10 additional gallons of water, or the size of the Cube increases by 5 feet, for each spell slot level above 1.""" //
        //
        //
        ;
    }

    @Override
    public void onLevelUp(int lvl) {
        // TODO Auto-generated method stub
        
    }
    
}
