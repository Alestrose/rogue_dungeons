package alan.spells.cantrips;

import alan.Constants;
import alan.creatures.Creature;
import alan.grid_panel.Cell;
import alan.spells.SpellAbstract;
import alan.spells.SpellInterface;

public class RayOfFrost extends SpellAbstract implements SpellInterface{

    public RayOfFrost() {
        setSpellName("Ray Of Frost");
        setSpellLevel((byte) 0);
        setSchool(Constants.SCHOOL.EVOCATION);
        setDamage_type(Constants.DAMAGE_TYPE.ICE);
        setSpellAttack(true);
        setAction(true);
        setRange((short) 60);
        setDuration((byte) 0);
        setDamageDie(8);
        setQuantityOfDie(1);
    }

    @Override
    public void cast(Creature caster, Creature target, Creature[] targetList, Cell cell, Constants.DAMAGE_TYPE damage_type, int spellLevel) {
        target.damageHealth(rollDamage(getDamageDie(), getQuantityOfDie()));
        target.setSpeed(getTarget().getSpeed() - 10);
    }
    @Override
    public String descreiption() {
        return """
               A frigid beam of blue-white light streaks toward a creature within range. Make a ranged spell attack against the target. On a hit, it takes 1d8 Cold damage, and its Speed is reduced by 10 feet until the start of your next turn.\r
               Cantrip Upgrade. The damage increases by 1d8 when you reach levels 5 (2d8), 11 (3d8), and 17 (4d8).""" //
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
