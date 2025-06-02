package alan.spells.cantrips;

import alan.Constants;
import alan.Constants.CONDITION_KEY;
import alan.creatures.Creature;
import alan.grid_panel.Cell;
import alan.spells.SpellAbstract;
import alan.spells.SpellInterface;

public class ChillTouch extends SpellAbstract implements SpellInterface{

    public ChillTouch(){
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
    public void castOnArea(Creature caster, Cell cell) {
    }

    @Override
    public void castOnTarget(Creature caster, Creature target) {
        target.damageHealth(damageRoll(getDamageDie(), getQuantityOfDie()));
        target.ApplyConditionEffect(CONDITION_KEY.CHILL_TOUCH);
    }

    @Override
    public String descreiption() {
        // TODO Auto-generated method stub
        return null;
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
