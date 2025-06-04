package alan.spells.cantrips;

import alan.Constants;
import alan.creatures.Creature;
import alan.grid_panel.Cell;
import alan.spells.SpellAbstract;
import alan.spells.SpellInterface;

public class Resistance extends SpellAbstract implements SpellInterface{

    public Resistance() {
        setSpellName("Resistance");
        setSpellLevel((byte) 0);
        setSchool(Constants.SCHOOL.ABJURATION);
        setConcentration(true);
        setAction(true);
        setRange((short) 0);
        setDuration((byte) 10);

    }

    @Override
    public void cast(Creature caster, Creature target, Creature[] targetList, Cell cell, Constants.DAMAGE_TYPE damage_type) {
        target.grantResistance(damage_type);
        
    }

    @Override
    public String descreiption() {
        return "You touch a willing creature and choose a damage type: Acid, Bludgeoning, Cold, Fire, Lightning, Necrotic, Piercing, Poison, Radiant, Slashing, or Thunder. When the creature takes damage of the chosen type before the spell ends, the creature reduces the total damage taken by 1d4. A creature can benefit from this spell only once per turn.";
    }

    @Override
    public void onLevelUp(int lvl) {
        // TODO Auto-generated method stub
        
    }
    

}
