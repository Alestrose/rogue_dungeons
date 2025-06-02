package alan.spells.cantrips;

import alan.Constants;
import alan.Constants.CONDITION_KEY;
import alan.creatures.Creature;
import alan.grid_panel.Cell;
import alan.spells.SpellAbstract;
import alan.spells.SpellInterface;

public class ChillTouch extends SpellAbstract implements SpellInterface{

    public ChillTouch(Creature caster, Creature target, Creature[] targetList, Cell cell){
        super(caster, target, targetList, cell);
        setSpellName("Chill Touch");
        setSpellLevel((byte) 0);
        setSchool(Constants.SCHOOL.NECROMANCY);
        setDamage_type(Constants.DAMAGE_TYPE.NECROTIC);
        // setConcentration(true);
        setAction(true);
        setRange((short) 0);
        setDuration((byte) 10);
        setDamageDie(10);
        setQuantityOfDie(1);
    }

    @Override
    public void cast() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void castOnArea() {
    }

    @Override
    public void castOnTarget() {
        getTarget().damageHealth(damageRoll(getDamageDie(), getQuantityOfDie()));
        getTarget().ApplyConditionEffect(CONDITION_KEY.CHILL_TOUCH);
    }

    @Override
    public void multiCast() {
        // TODO Auto-generated method stub
        
    }

    @Override
    public String descreiption() {
        // TODO Auto-generated method stub
        return """
               Channeling the chill of the grave, make a melee spell attack against a target within reach. On a hit, the target takes 1d10 Necrotic damage, and it can't regain Hit Points until the end of your next turn.\r
               Cantrip Upgrade. The damage increases by 1d10 when you reach levels 5 (2d10), 11 (3d10), and 17 (4d10).""" //
        ;
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
