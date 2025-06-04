package alan.spells;

import alan.Constants;
import alan.creatures.Creature;
import alan.grid_panel.Cell;

public interface SpellInterface {
    void cast(Creature caster, Creature target, Creature[] targetList, Cell cell, Constants.DAMAGE_TYPE damage_type);    // Calls one of below cast types
    String descreiption();
    void onLevelUp(int lvl);
}
