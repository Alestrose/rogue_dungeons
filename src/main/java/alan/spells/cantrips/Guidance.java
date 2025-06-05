package alan.spells.cantrips;

import alan.Constants;
import alan.creatures.Creature;
import alan.grid_panel.Cell;
import alan.spells.SpellAbstract;
import alan.spells.SpellInterface;

public class Guidance extends SpellAbstract implements SpellInterface{

    public Guidance(){
        setSpellName("Guidance");
        setSpellLevel((byte) 0);
        setSchool(Constants.SCHOOL.DIVINATION);
        setConcentration(true);
        setAction(true);
        setRange((short) 0);
        setDuration((byte) 10);
    }

    @Override
    public void cast(Creature caster, Creature target, Creature[] targetList, Cell cell, Constants.DAMAGE_TYPE damage_type, int spellLevel) {
        target.setAbilityCheckIncrease(4);
        
    }

    @Override
    public String descreiption() {
        return "You touch a willing creature and choose a skill. Until the spell ends, the creature adds 1d4 to any ability check using the chosen skill.";
    }

    @Override
    public void onLevelUp(int lvl) {
        // TODO Auto-generated method stub
    }

    


}
