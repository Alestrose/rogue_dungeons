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
        // setDamage_type(Constants.DAMAGE_TYPE.NECROTIC);
        setConcentration(true);
        setAction(true);
        setRange((short) 120);
        setDuration((byte) 10);
        //setDamageDie(10);
        //setQuantityOfDie(1);
    }

    @Override
    public void castOnArea(Creature caster, Cell cell) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void castOnTarget(Creature caster, Creature target) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public String descreiption() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void onLevelUp(int lvl) {
        // TODO Auto-generated method stub
        
    }
    
}
