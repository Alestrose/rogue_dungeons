package alan.spells.cantrips;

import alan.Constants;
import alan.creatures.Creature;
import alan.grid_panel.Cell;
import alan.spells.SpellAbstract;
import alan.spells.SpellInterface;

public class PoisonSpray extends SpellAbstract implements SpellInterface{

    public PoisonSpray() {
        setSpellName("Poison Spray");
        setSpellLevel((byte) 0);
        setSchool(Constants.SCHOOL.NECROMANCY);
        setDamage_type(Constants.DAMAGE_TYPE.POISON);
        setAction(true);
        setRange((short) 30);
        setDuration((byte) 0);
        setSpellAttack(true);
        setDamageDie(12);
        setQuantityOfDie(1);
    }

    @Override
    public void cast(Creature caster, Creature target, Creature[] targetList, Cell cell, Constants.DAMAGE_TYPE damage_type, int spellLevel) {
        target.damageHealth(rollDamage(getDamageDie(), getQuantityOfDie()));
    }

    @Override
    public String descreiption() {
        return """
               You spray toxic mist at a creature within range. Make a ranged spell attack against the target. On a hit, the target takes 1d12 Poison damage.\r
               Cantrip Upgrade. The damage increases by 1d12 when you reach levels 5 (2d12), 11 (3d12), and 17 (4d12).""" //
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
