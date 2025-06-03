package alan.spells.cantrips;

import alan.Constants;
import alan.creatures.Creature;
import alan.grid_panel.Cell;
import alan.spells.SpellAbstract;
import alan.spells.SpellInterface;

public class BladeWard extends SpellAbstract implements SpellInterface{

    public BladeWard(Creature caster, Creature target, Creature[] targetList, Cell cell){
        super(caster, target, targetList, cell);
        setSpellName("Blade Ward");
        setSpellLevel((byte) 0);
        setSchool(Constants.SCHOOL.ABJURATION);
        setConcentration(true);
        setAction(true);
        setRange((short) 0);
        setDuration((byte) 10);
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
        getTarget().setAttackRollReduction(4);
    }
    
    @Override
    public void multiCast() {
        // TODO Auto-generated method stub
        
    }

    @Override
    public String descreiption() {
        return "Whenever a creature makes an attack roll against you before the spell ends, the attacker subtracts 1d4 from the attack roll";
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
            case 5 -> {
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
            case 11 -> {
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
            case 17 -> {
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
