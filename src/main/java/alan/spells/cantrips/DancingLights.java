package alan.spells.cantrips;

import alan.Constants;
import alan.creatures.Creature;
import alan.grid_panel.Cell;
import alan.spells.SpellAbstract;
import alan.spells.SpellInterface;

public class DancingLights extends SpellAbstract implements SpellInterface{

    public DancingLights(Creature caster, Creature target, Creature[] targetList, Cell cell){
        super(caster, target, targetList, cell);
        setSpellName("Dancing Lights");
        setSpellLevel((byte) 0);
        setSchool(Constants.SCHOOL.ILLUSION);
        // setDamage_type(Constants.DAMAGE_TYPE.NECROTIC);
        setConcentration(true);
        setAction(true);
        setRange((short) 120);
        setDuration((byte) 10);
        //setDamageDie(10);
        //setQuantityOfDie(1);
    }

    @Override
    public void cast() {
        // No combat implementation
        
    }

    @Override
    public void castOnArea() {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void castOnTarget() {
        // TODO Auto-generated method stub
        
    }
    
    @Override
    public void multiCast() {
        // TODO Auto-generated method stub
        
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
