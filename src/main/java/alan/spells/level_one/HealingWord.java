package alan.spells.level_one;

import alan.Constants;
import alan.Constants.DAMAGE_TYPE;
import alan.creatures.Creature;
import alan.grid_panel.Cell;
import alan.spells.SpellAbstract;
import alan.spells.SpellInterface;

public class HealingWord extends SpellAbstract implements SpellInterface{
    public HealingWord(){
        setSpellName("Healing Word");
        setSpellLevel((byte) 1);
        setSchool(Constants.SCHOOL.ABJURATION);
        setBonus(true);
        setRange((short) 0);
        setDuration((byte) 0);
        setDamageDie(4);
        setQuantityOfDie(2);
    }

    @Override
    public void cast(Creature caster, Creature target, Creature[] targetList, Cell cell, DAMAGE_TYPE damage_type,
            int spellLevel) {
        switch (spellLevel) {
            case 2 -> {setQuantityOfDie(4);}
            case 3 -> {setQuantityOfDie(6);}
            case 4 -> {setQuantityOfDie(8);}
            case 5 -> {setQuantityOfDie(10);}
            case 6 -> {setQuantityOfDie(12);}
            case 7 -> {setQuantityOfDie(14);}
            default -> {}
        }
        target.healHealth(rollDamage(getDamageDie(), getQuantityOfDie()) + caster.getSpellCastModifier());
    }

    @Override
    public String descreiption() {
        return """
               A creature of your choice that you can see within range regains Hit Points equal to 2d4 plus your spellcasting ability modifier.\r
               Using a Higher-Level Spell Slot. The healing increases by 2d4 for each spell slot level above 1.""" //
        ;
    }

    @Override
    public void onLevelUp(int lvl) {
        // TODO Auto-generated method stub
        
    }
    

}
