package alan.spells;

import alan.creatures.Creature;
import alan.grid_panel.Cell;

public interface SpellInterface {
    void castOnTarget(Creature caster, Creature target);
    void castOnArea(Creature caster, Cell cell);
    String descreiption();
}
