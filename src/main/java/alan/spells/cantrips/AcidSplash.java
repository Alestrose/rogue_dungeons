package alan.spells.cantrips;

import alan.Constants;
import alan.creatures.Creature;
import alan.grid_panel.Cell;
import alan.spells.SpellAbstract;
import alan.spells.SpellInterface;

public class AcidSplash extends SpellAbstract implements SpellInterface{

    public AcidSplash() {
        setSpellName("Acid Splash");
        setSpellLevel((byte) 0);
        setSchool(Constants.SCHOOL.EVOCATION);
        setDamage_type(Constants.DAMAGE_TYPE.ACID);
        setAction(true);
        setRange((short) 60);
        setDuration((byte) 0);
        setDamageDie(6);
        setQuantityOfDie(1);
    }
    

    @Override
    public void castOnArea(Creature caster, Cell cell) {
        int x = cell.getX();
        int y = cell.getY();
        castOnTarget(caster, getGrid().getCellArray()[x][y].getOccupant());
        castOnTarget(caster, getGrid().getCellArray()[x+1][y+1].getOccupant());
        castOnTarget(caster, getGrid().getCellArray()[x-1][y-1].getOccupant());
        castOnTarget(caster, getGrid().getCellArray()[x+1][y-1].getOccupant());
        castOnTarget(caster, getGrid().getCellArray()[x-1][y+1].getOccupant());
        castOnTarget(caster, getGrid().getCellArray()[x][y+1].getOccupant());
        castOnTarget(caster, getGrid().getCellArray()[x][y-1].getOccupant());
        castOnTarget(caster, getGrid().getCellArray()[x+1][y].getOccupant());
        castOnTarget(caster, getGrid().getCellArray()[x-1][y].getOccupant());
    }

    @Override
    public void castOnTarget(Creature caster, Creature target) {
        target.damageHealth(damageRoll(getDamageDie(), getQuantityOfDie()));
        
    }

    @Override
    public String descreiption() {
        // TODO Auto-generated method stub
        return "You create an acidic bubble at a point within range, where it explodes in a 5-foot-radius Sphere. Each creature in that Sphere must succeed on a Dexterity saving throw or take 1d6 Acid damage.";
    }
    
    
}
