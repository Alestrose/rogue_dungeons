package alan.spells.cantrips;

import alan.Constants;
import alan.creatures.Creature;
import alan.grid_panel.Cell;
import alan.spells.SpellAbstract;
import alan.spells.SpellInterface;

public class EldritchBlast extends SpellAbstract implements SpellInterface{

    public EldritchBlast(){
        setSpellName("Eldritch Blast");
        setSpellLevel((byte) 0);
        setSchool(Constants.SCHOOL.EVOCATION);
        setDamage_type(Constants.DAMAGE_TYPE.FORCE);
        setAction(true);
        setRange((short) 120);
        setDuration((byte) 0);
        setDamageDie(10);
        setQuantityOfDie(1);
        setSpellAttack(true);
    }

    // Calls one of below cast types
    @Override
    public void cast(Creature caster, Creature target, Creature[] targetList, Cell cell, Constants.DAMAGE_TYPE damage_type) {
        for (Creature c : targetList) {
            c.damageHealth(damageRoll(getDamageDie(), getQuantityOfDie()));
        }
    }

    @Override
    public String descreiption() {
        // TODO Auto-generated method stub
        return """
               Your hurl a beam of crackling energy. Make a ranged spell attack against one creature or object in range. On a hit, the target takes 1d10 Force damage.\r
               Cantrip Upgrade. The spell creates two beams at level 5, three beams at level 11, and four beams at level 17. You can direct the beams at the same target or at different ones. Make a separate attack roll for each beam.""" //
        ;
    }

    @Override
    public void onLevelUp(int lvl) {
        switch (lvl) {
            case 5 -> {setMultiCastHits(2);}
            case 11 -> {setMultiCastHits(3);}
            case 17 -> {setMultiCastHits(4);}
            default -> {}
        }
    }
}
