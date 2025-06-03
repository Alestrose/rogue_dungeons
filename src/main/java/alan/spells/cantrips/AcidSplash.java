package alan.spells.cantrips;

import alan.Constants;
import alan.creatures.Creature;
import alan.grid_panel.Cell;
import alan.spells.SpellAbstract;
import alan.spells.SpellInterface;

public class AcidSplash extends SpellAbstract implements SpellInterface{

    public AcidSplash(Creature caster, Creature target, Creature[] targetList, Cell cell){
        super(caster, target, targetList, cell);
        setSpellName("Acid Splash");
        setSpellLevel((byte) 0);
        setSchool(Constants.SCHOOL.EVOCATION);
        setDamage_type(Constants.DAMAGE_TYPE.ACID);
        setSavingThrow(Constants.ABILITY.DEXTERITY);
        setAction(true);
        setRange((short) 60);
        setDuration((byte) 0);
        setDamageDie(6);
        setQuantityOfDie(1);
        setSpellSave(true);
    }

    @Override
    public void cast() {
        castOnArea();
    }
    @Override
    public void castOnArea() {
        int x = getCell().getX();
        int y = getCell().getY();
        getGrid().getCellArray()[x][y].getOccupant().damageHealth(damageRoll(getDamageDie(), getQuantityOfDie()));
        getGrid().getCellArray()[x+1][y+1].getOccupant().damageHealth(damageRoll(getDamageDie(), getQuantityOfDie()));
        getGrid().getCellArray()[x-1][y-1].getOccupant().damageHealth(damageRoll(getDamageDie(), getQuantityOfDie()));
        getGrid().getCellArray()[x+1][y-1].getOccupant().damageHealth(damageRoll(getDamageDie(), getQuantityOfDie()));
        getGrid().getCellArray()[x-1][y+1].getOccupant().damageHealth(damageRoll(getDamageDie(), getQuantityOfDie()));
        getGrid().getCellArray()[x][y+1].getOccupant().damageHealth(damageRoll(getDamageDie(), getQuantityOfDie()));
        getGrid().getCellArray()[x][y-1].getOccupant().damageHealth(damageRoll(getDamageDie(), getQuantityOfDie()));
        getGrid().getCellArray()[x+1][y].getOccupant().damageHealth(damageRoll(getDamageDie(), getQuantityOfDie()));
        getGrid().getCellArray()[x-1][y].getOccupant().damageHealth(damageRoll(getDamageDie(), getQuantityOfDie()));
    }

    @Override
    public void castOnTarget() {
        
    }
    
    @Override
    public void multiCast() {
        // TODO Auto-generated method stub
        
    }

    @Override
    public String descreiption() {
        // TODO Auto-generated method stub
        return "You create an acidic bubble at a point within range, where it explodes in a 5-foot-radius Sphere. Each creature in that Sphere must succeed on a Dexterity saving throw or take 1d6 Acid damage.";
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
