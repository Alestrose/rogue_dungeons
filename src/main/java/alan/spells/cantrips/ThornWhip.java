package alan.spells.cantrips;

import alan.Constants;
import alan.Constants.DAMAGE_TYPE;
import alan.creatures.Creature;
import alan.grid_panel.Cell;
import alan.spells.SpellAbstract;
import alan.spells.SpellInterface;

public class ThornWhip extends SpellAbstract implements SpellInterface{

    public ThornWhip(){
        setSpellName("Thorn Whip");
        setSpellLevel((byte) 0);
        setSchool(Constants.SCHOOL.TRANSMUTATION);
        setDamage_type(Constants.DAMAGE_TYPE.PIERCING);
        setSpellAttack(true);
        setAction(true);
        setRange((short) 30);
        setDuration((byte) 0);
        setDamageDie(6); 
        setQuantityOfDie(1);
    }

    @Override
    public void cast(Creature caster, Creature target, Creature[] targetList, Cell cell, DAMAGE_TYPE damage_type) {
        target.damageHealth(damageRoll(getDamageDie(), getQuantityOfDie()));
    }

    @Override
    public String descreiption() {
        return """
               You create a vine-like whip covered in thorns that lashes out at your command toward a creature in range. Make a melee spell attack against the target. On a hit, the target takes 1d6 Piercing damage, and if it is Large or smaller, you can pull it up to 10 feet closer to you.\r
               Cantrip Upgrade. The damage increases by 1d6 when you reach levels 5 (2d6), 11 (3d6), and 17 (4d6).""" //
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
