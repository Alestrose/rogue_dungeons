package alan.spells.level_one;

import alan.Constants;
import alan.Constants.DAMAGE_TYPE;
import alan.creatures.Creature;
import alan.grid_panel.Cell;
import alan.spells.SpellAbstract;
import alan.spells.SpellInterface;

public class HellishRebuke extends SpellAbstract implements SpellInterface{
    public HellishRebuke(){
        setSpellName("Hellish Rebuke");
        setSpellLevel((byte) 1);
        setSchool(Constants.SCHOOL.EVOCATION);
        setDamage_type(Constants.DAMAGE_TYPE.FIRE);
        setSavingThrow(Constants.ABILITY.DEXTERITY);
        setSpellAttack(true);
        setConcentration(true);
        setReaction(true);
        setRange((short) 60);
        setDuration((byte) 0);
        setDamageDie(10);
        setQuantityOfDie(2);
    }

    @Override
    public void cast(Creature caster, Creature target, Creature[] targetList, Cell cell, DAMAGE_TYPE damage_type,
            int spellLevel) {
        switch (spellLevel) {
            case 2 -> {setQuantityOfDie(3);}
            case 3 -> {setQuantityOfDie(4);}
            case 4 -> {setQuantityOfDie(5);}
            case 5 -> {setQuantityOfDie(6);}
            case 6 -> {setQuantityOfDie(7);}
            case 7 -> {setQuantityOfDie(8);}
            default -> {}
        }
        target.damageHealth(rollDamage(getDamageDie(), getQuantityOfDie()));
    }

    @Override
    public String descreiption() {
        // TODO Auto-generated method stub
        return """
               The creature that damaged you is momentarily surrounded by green flames. It makes a Dexterity saving throw, taking 2d10 Fire damage on a failed save or half as much damage on a successful one.\r
               Using a Higher-Level Spell Slot. The damage increases by 1d10 for each spell slot level above 1.""" //
        ;
    }

    @Override
    public void onLevelUp(int lvl) {
        // TODO Auto-generated method stub
        
    }
    

}
