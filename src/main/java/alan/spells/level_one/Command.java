package alan.spells.level_one;

import alan.Constants;
import alan.Constants.DAMAGE_TYPE;
import alan.creatures.Creature;
import alan.grid_panel.Cell;
import alan.spells.SpellAbstract;
import alan.spells.SpellInterface;

public class Command extends SpellAbstract implements SpellInterface{

    public Command(){
        setSpellName("Command");
        setSpellLevel((byte) 1);
        setSchool(Constants.SCHOOL.ENCHANTMENT);
        setSavingThrow(Constants.ABILITY.WISDOM);
        setSpellAttack(true);
        setConcentration(true);
        setAction(true);
        setRange((short) 60);
        setDuration((byte) 0);
        setMultiCastHits(1);
    }

    @Override       // Requires further implementation when weapons are added
    public void cast(Creature caster, Creature target, Creature[] targetList, Cell cell, DAMAGE_TYPE damage_type, int spellLevel) {
        levelMultiCastHits(1, spellLevel);
        
        
    }

    @Override
    public String descreiption() {
        // TODO Auto-generated method stub
        return """
               You speak a one-word command to a creature you can see within range. The target must succeed on a Wisdom saving throw or follow the command on its next turn. Choose the command from these options:\r
               Approach. The target moves toward you by the shortest and most direct route, ending its turn if it moves within 5 feet of you.\r
               Drop. The target drops whatever it is holding and then ends its turn.\r
               Flee. The target spends its turn moving away from you by the fastest available means.\r
               Grovel. The target has the Prone condition and then ends its turn.\r
               Halt. On its turn, the target doesn't move and takes no action or Bonus Action.\r
               Using a Higher-Level Spell Slot. You can affect one additional creature for each spell slot level above 1.""" //
        //
        //
        //
        //
        //
        ;
    }

    @Override
    public void onLevelUp(int lvl) {
        // TODO Auto-generated method stub
        
    }
    

}
