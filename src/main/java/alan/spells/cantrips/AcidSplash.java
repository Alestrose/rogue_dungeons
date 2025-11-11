package alan.spells.cantrips;

import alan.Constants;
import alan.creatures.Creature;
import alan.grid_panel.Cell;
import alan.spells.SpellAbstract;
import alan.spells.SpellInterface;

public class AcidSplash extends SpellAbstract implements SpellInterface{

    public AcidSplash(){
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
    public void cast(Creature caster, Creature target, Creature[] targetList, Cell cell, Constants.DAMAGE_TYPE damage_type, int spellLevel) {
        int x = cell.getX();
        int y = cell.getY();

        // This section for dealing area damage needs to be improved and implemented in DiceRoll interface
        getGrid().getCellArray()[x][y].getOccupant().damageHealth(rollDamage(getDamageDie(), getQuantityOfDie()));
        getGrid().getCellArray()[x+1][y+1].getOccupant().damageHealth(rollDamage(getDamageDie(), getQuantityOfDie()));
        getGrid().getCellArray()[x-1][y-1].getOccupant().damageHealth(rollDamage(getDamageDie(), getQuantityOfDie()));
        getGrid().getCellArray()[x+1][y-1].getOccupant().damageHealth(rollDamage(getDamageDie(), getQuantityOfDie()));
        getGrid().getCellArray()[x-1][y+1].getOccupant().damageHealth(rollDamage(getDamageDie(), getQuantityOfDie()));
        getGrid().getCellArray()[x][y+1].getOccupant().damageHealth(rollDamage(getDamageDie(), getQuantityOfDie()));
        getGrid().getCellArray()[x][y-1].getOccupant().damageHealth(rollDamage(getDamageDie(), getQuantityOfDie()));
        getGrid().getCellArray()[x+1][y].getOccupant().damageHealth(rollDamage(getDamageDie(), getQuantityOfDie()));
        getGrid().getCellArray()[x-1][y].getOccupant().damageHealth(rollDamage(getDamageDie(), getQuantityOfDie()));
    }

    @Override
    public String descreiption() {
        return "You create an acidic bubble at a point within range, where it explodes in a 5-foot-radius Sphere. Each creature in that Sphere must succeed on a Dexterity saving throw or take 1d6 Acid damage.";
    }

    @Override
    public void onLevelUp(int lvl) {
        
    }
    
    
}
