package alan.spells.cantrips;

import alan.Constants;
import alan.creatures.Creature;
import alan.grid_panel.Cell;
import alan.spells.SpellAbstract;
import alan.spells.SpellInterface;

public class DancingLights extends SpellAbstract implements SpellInterface{

    public DancingLights(){
        setSpellName("Dancing Lights");
        setSpellLevel((byte) 0);
        setSchool(Constants.SCHOOL.ILLUSION);
        setConcentration(true);
        setAction(true);
        setRange((short) 120);
        setDuration((byte) 10);
    }

    @Override
    public void cast(Creature caster, Creature target, Creature[] targetList, Cell cell, Constants.DAMAGE_TYPE damage_type) {
        // No combat implementation
        
    }

    @Override
    public String descreiption() {
        // TODO Auto-generated method stub
        return """
               You create up to four torch-size lights within range, making them appear as torches, lanterns, or glowing orbs that hover for the duration. Alternatively, you combine the four lights into one glowing Medium form that is vaguely humanlike. Whichever form you choose, each light sheds Dim Light in a 10-foot radius.\r
               As a Bonus Action, you can move the lights up to 60 feet to a space within range. A light must be within 20 feet of another light created by this spell, and a light vanishes if it exceeds the spell's range.""" //
        ;
    }

    @Override
    public void onLevelUp(int lvl) {
        // TODO Auto-generated method stub
        
    }
    
}
