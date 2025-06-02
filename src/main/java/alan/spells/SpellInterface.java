package alan.spells;

public interface SpellInterface {
    void cast();    // Calls one of below cast types
    void castOnTarget();
    void multiCast();
    void castOnArea();
    String descreiption();
    void onLevelUp(int lvl);
}
