package alan.spells.cantrips;

import alan.Constants;
import alan.creatures.Creature;
import alan.grid_panel.Cell;
import alan.spells.SpellAbstract;
import alan.spells.SpellInterface;

public class Guidance extends SpellAbstract implements SpellInterface{

    public Guidance(Creature caster, Creature target, Creature[] targetList, Cell cell){
        super(caster, target, targetList, cell);
        setSpellName("Guidance");
        setSpellLevel((byte) 0);
        setSchool(Constants.SCHOOL.DIVINATION);
        setConcentration(true);
        setAction(true);
        setRange((short) 0);
        setDuration((byte) 10);
    }

    @Override
    public void cast() {
        castOnTarget();
        
    }

    @Override
    public void castOnArea() {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void castOnTarget() {
        getTarget().setPlayerAbilityCheckIncrease(4);
        
    }

    @Override
    public String descreiption() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void multiCast() {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void onLevelUp(int lvl) {
        // TODO Auto-generated method stub
        
    }

    


}
