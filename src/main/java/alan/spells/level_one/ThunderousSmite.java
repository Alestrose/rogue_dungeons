package alan.spells.level_one;

import alan.Constants;
import alan.Constants.DAMAGE_TYPE;
import alan.creatures.Creature;
import alan.grid_panel.Cell;
import alan.spells.SpellAbstract;
import alan.spells.SpellInterface;

public class ThunderousSmite  extends SpellAbstract implements SpellInterface{

    public ThunderousSmite(){
        setSpellName("ThunderousSmite");
        setSpellLevel((byte) 1);
        setSchool(Constants.SCHOOL.EVOCATION);
        setDamage_type(Constants.DAMAGE_TYPE.THUNDER);
        setSavingThrow(Constants.ABILITY.STRENGTH);
        setConcentration(true);
        setBonus(true);
        setRange((short) 0);
        setDuration((byte) 10);
        setDamageDie(6);
        setQuantityOfDie(2);
    }

    @Override       // Requires implementation for push back mechanic
    public void cast(Creature caster, Creature target, Creature[] targetList, Cell cell, DAMAGE_TYPE damage_type, int spellLevel) {
        caster.setNextHitDamageRollIncrease(rollDamage(getDamageDie(), getQuantityOfDie()));
        
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
