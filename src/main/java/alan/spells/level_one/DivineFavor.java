package alan.spells.level_one;

import alan.Constants;
import alan.Constants.DAMAGE_TYPE;
import alan.creatures.Creature;
import alan.grid_panel.Cell;
import alan.spells.SpellAbstract;
import alan.spells.SpellInterface;

public class DivineFavor extends SpellAbstract implements SpellInterface{

    public DivineFavor(){
        setSpellName("Divine Favor");
        setSpellLevel((byte) 1);
        setSchool(Constants.SCHOOL.TRANSMUTATION);
        setDamage_type(Constants.DAMAGE_TYPE.RADIANT);
        setAction(true);
        setRange((short) 0);
        setDuration((byte) 10);
        setDamageDie(4);
        setQuantityOfDie(1);
    }

    @Override
    public void cast(Creature caster, Creature target, Creature[] targetList, Cell cell, DAMAGE_TYPE damage_type,
            int spellLevel) {
        caster.setDamageRollIncrease(rollDamage(getDamageDie(), getQuantityOfDie()));
        
    }

    @Override
    public String descreiption() {
        // TODO Auto-generated method stub
        return "Until the spell ends, your attacks with weapons deal an extra 1d4 Radiant damage on a hit.";
    }

    @Override
    public void onLevelUp(int lvl) {
        // TODO Auto-generated method stub
        
    }

    
}
