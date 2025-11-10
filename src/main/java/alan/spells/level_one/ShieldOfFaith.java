package alan.spells.level_one;

import alan.Constants;
import alan.Constants.DAMAGE_TYPE;
import alan.creatures.Creature;
import alan.grid_panel.Cell;
import alan.spells.SpellAbstract;
import alan.spells.SpellInterface;

public class ShieldOfFaith extends SpellAbstract implements SpellInterface{

    public ShieldOfFaith(){
        setSpellName("Shield Of Faith");
        setSpellLevel((byte) 1);
        setSchool(Constants.SCHOOL.ABJURATION);
        setConcentration(true);
        setBonus(true);
        setRange((short) 60);
        setDuration((byte) 100);
    }

    @Override
    public void cast(Creature caster, Creature target, Creature[] targetList, Cell cell, DAMAGE_TYPE damage_type,
            int spellLevel) {
        target.setTempAcBonus(2);
        
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
