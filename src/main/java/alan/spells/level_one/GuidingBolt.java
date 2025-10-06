package alan.spells.level_one;

import alan.Constants;
import alan.Constants.DAMAGE_TYPE;
import alan.creatures.Creature;
import alan.grid_panel.Cell;
import alan.spells.SpellAbstract;
import alan.spells.SpellInterface;

public class GuidingBolt extends SpellAbstract implements SpellInterface{
    public GuidingBolt(){
        setSpellName("Guiding Bolt");
        setSpellLevel((byte) 1);
        setSchool(Constants.SCHOOL.EVOCATION);
        setDamage_type(Constants.DAMAGE_TYPE.RADIANT);
        setSpellAttack(true);
        setAction(true);
        setRange((short) 120);
        setDuration((byte) 1);
        setDamageDie(6);
        setQuantityOfDie(4);
    }

    @Override
    public void cast(Creature caster, Creature target, Creature[] targetList, Cell cell, DAMAGE_TYPE damage_type,
        int spellLevel) {
            switch (spellLevel) {
                case 2 -> {setQuantityOfDie(5);}
                case 3 -> {setQuantityOfDie(6);}
                case 4 -> {setQuantityOfDie(7);}
                case 5 -> {setQuantityOfDie(8);}
                case 6 -> {setQuantityOfDie(9);}
                case 7 -> {setQuantityOfDie(10);}
                default -> {}
        }
        target.damageHealth(rollDamage(getDamageDie(), getQuantityOfDie()));

        
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
