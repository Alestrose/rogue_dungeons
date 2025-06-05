package alan.spells.cantrips;

import alan.Constants;
import alan.Constants.DAMAGE_TYPE;
import alan.creatures.Creature;
import alan.grid_panel.Cell;
import alan.spells.SpellAbstract;
import alan.spells.SpellInterface;

public class ViciousMockery extends SpellAbstract implements SpellInterface{

    public ViciousMockery(){
        setSpellName("Vicious Mockery");
        setSpellLevel((byte) 0);
        setSchool(Constants.SCHOOL.ENCHANTMENT);
        setDamage_type(Constants.DAMAGE_TYPE.PSYCHIC);
        setSavingThrow(Constants.ABILITY.WISDOM);
        setAction(true);
        setRange((short) 60);
        setDuration((byte) 0);
        setDamageDie(6);
        setQuantityOfDie(1);
    }

    @Override
    public void cast(Creature caster, Creature target, Creature[] targetList, Cell cell, DAMAGE_TYPE damage_type, int spellLevel) {
        target.damageHealth(rollDamage(getDamageDie(), getQuantityOfDie()));
        target.setAttackRollDisadvantage(true);
        
    }

    @Override
    public String descreiption() {
        return """
               You unleash a string of insults laced with subtle enchantments at one creature you can see or hear within range. The target must succeed on a Wisdom saving throw or take 1d6 Psychic damage and have Disadvantage on the next attack roll it makes before the end of its next turn.\r
               Cantrip Upgrade. The damage increases by 1d6 when you reach level 5 (2d6), level 11 (3d6), and level 17 (4d6).""" //
        ;
    }

    @Override
    public void onLevelUp(int lvl) {
        switch (lvl) {
            case 5 -> {setQuantityOfDie(2);}
            case 11 -> {setQuantityOfDie(3);}
            case 17 -> {setQuantityOfDie(4);}
            default -> {}
        }
    }
    

}
