package alan.spells.level_one;

import alan.Constants;
import alan.Constants.DAMAGE_TYPE;
import alan.creatures.Creature;
import alan.grid_panel.Cell;
import alan.spells.SpellAbstract;
import alan.spells.SpellInterface;

public class ExpeditiousRetreat_ extends SpellAbstract implements SpellInterface{
    public ExpeditiousRetreat_(){
        setSpellName("Expeditious Retreat");
        setSpellLevel((byte) 1);
        setSchool(Constants.SCHOOL.TRANSMUTATION);
        setConcentration(true);
        setBonus(true);
        setRange((short) 0);
        setDuration((byte) 100);
    }

    @Override
    public void cast(Creature caster, Creature target, Creature[] targetList, Cell cell, DAMAGE_TYPE damage_type,
            int spellLevel) {
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
