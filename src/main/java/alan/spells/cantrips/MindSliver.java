package alan.spells.cantrips;

import alan.Constants;
import alan.creatures.Creature;
import alan.grid_panel.Cell;
import alan.spells.SpellAbstract;
import alan.spells.SpellInterface;

public class MindSliver extends SpellAbstract implements SpellInterface{

    public MindSliver(Creature caster, Creature target, Creature[] targetList, Cell cell) {
        super(caster, target, targetList, cell);
        setSpellName("Mind Sliver");
        setSpellLevel((byte) 0);
        setSavingThrow(Constants.ABILITY.INTELLIGENCE);
        setSchool(Constants.SCHOOL.ENCHANTMENT);
        setAction(true);
        setBonus(true);
        setReaction(true);
        setRange((short) 60);
        setDuration((byte) 1);
        setDamageDie(6);
        setQuantityOfDie(1);
    }

    @Override
    public void cast() {
        // TODO Auto-generated method stub

    }

    @Override
    public void castOnArea() {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void castOnTarget() {
        getTarget().damageHealth(damageRoll(getDamageDie(), getQuantityOfDie()));
        getTarget().setSavingThrowDecrease(4);
    }

    @Override
    public String descreiption() {
        // TODO Auto-generated method stub
        return null;
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
