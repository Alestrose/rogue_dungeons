package alan.spells.cantrips;

import alan.Constants;
import alan.Constants.DAMAGE_TYPE;
import alan.creatures.Creature;
import alan.grid_panel.Cell;
import alan.spells.SpellAbstract;
import alan.spells.SpellInterface;

public class SpareTheDying extends SpellAbstract implements SpellInterface{

    public SpareTheDying(){
        setSpellName("Spare The Dying");
        setSpellLevel((byte) 0);
        setSchool(Constants.SCHOOL.NECROMANCY);
        setAction(true);
        setRange((short) 15);
        setDuration((byte) 0);
    }

    @Override
    public void cast(Creature caster, Creature target, Creature[] targetList, Cell cell, DAMAGE_TYPE damage_type) {
        if(target.getCurrentHealth() <= 0) target.setCurrentHealth(1);
    }

    @Override
    public String descreiption() {
        return """
               Choose a creature within range that has 0 Hit Points and isn't dead. The creature becomes Stable.\r
               Cantrip Upgrade. The range doubles when you reach levels 5 (30 feet), 11 (60 feet), and 17 (120 feet).""" //
        ;
    }

    @Override
    public void onLevelUp(int lvl) {
        switch (lvl) {
            case 5 -> {setRange((short)30);}
            case 11 -> {setRange((short)60);}
            case 17 -> {setRange((short)120);}
            default -> {}
        }
        
    }
    
}
