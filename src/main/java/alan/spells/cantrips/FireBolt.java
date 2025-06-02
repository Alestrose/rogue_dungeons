package alan.spells.cantrips;

import alan.Constants;
import alan.creatures.Creature;
import alan.grid_panel.Cell;
import alan.spells.SpellAbstract;
import alan.spells.SpellInterface;

public class FireBolt extends SpellAbstract implements SpellInterface{

    public FireBolt(Creature caster, Creature target, Creature[] targetList, Cell cell) {
        super(caster, target, targetList, cell);
        setSpellName("Fire Bolt");
        setSpellLevel((byte) 0);
        setSchool(Constants.SCHOOL.EVOCATION);
        setDamage_type(Constants.DAMAGE_TYPE.FIRE);
        setAction(true);
        setRange((short) 120);
        setDuration((byte) 0);
        setDamageDie(10);
        setQuantityOfDie(1);
    }

    @Override
    public void cast() {
        castOnTarget();
    }

    @Override
    public void castOnArea() {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void castOnTarget() {
        getTarget().damageHealth(damageRoll(getDamageDie(), getQuantityOfDie()));
        
    }

    @Override
    public String descreiption() {
        // TODO Auto-generated method stub
        return """
               You hurl a mote of fire at a creature or an object within range. Make a ranged spell attack against the target. On a hit, the target takes 1d10 Fire damage. A flammable object hit by this spell starts burning if it isn't being worn or carried.\r
               Cantrip Upgrade. The damage increases by 1d10 when you reach levels 5 (2d10), 11 (3d10), and 17 (4d10).""" //
        ;
    }

    @Override
    public void multiCast() {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void onLevelUp(int lvl) {
        switch (lvl) {
            case 1 -> {
            }
            case 2 -> {
            }
            case 3 -> {
            }
            case 4 -> {
            }
            case 5 -> {setQuantityOfDie(2);
            }
            case 6 -> {
            }
            case 7 -> {
            }
            case 8 -> {
            }
            case 9 -> {
            }
            case 10 -> {
            }
            case 11 -> {setQuantityOfDie(3);
            }
            case 12 -> {
            }
            case 13 -> {
            }
            case 14 -> {
            }
            case 15 -> {
            }
            case 16 -> {
            }
            case 17 -> {setQuantityOfDie(4);
            }
            case 18 -> {
            }
            case 19 -> {
            }
            case 20 -> {
            }
            default -> {
            }
        }
        
    }

    

}
