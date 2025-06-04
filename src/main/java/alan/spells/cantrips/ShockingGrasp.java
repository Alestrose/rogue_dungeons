package alan.spells.cantrips;

import alan.Constants;
import alan.creatures.Creature;
import alan.grid_panel.Cell;
import alan.spells.SpellAbstract;
import alan.spells.SpellInterface;

public class ShockingGrasp extends SpellAbstract implements SpellInterface{

    public ShockingGrasp(){
        setSpellName("Shocking Grasp");
        setSpellLevel((byte) 0);
        setSchool(Constants.SCHOOL.EVOCATION);
        setDamage_type(Constants.DAMAGE_TYPE.LIGHTNING);
        setSpellAttack(true);
        setAction(true);
        setRange((short) 0);
        setDuration((byte) 0);
        setDamageDie(8);
        setQuantityOfDie(1);
    }

    @Override
    public void cast(Creature caster, Creature target, Creature[] targetList, Cell cell, Constants.DAMAGE_TYPE damage_type) {
        target.damageHealth(damageRoll(getDamageDie(), getDamageDie()));
        target.setCanOpportunityAttack(false);
    }

    @Override
    public String descreiption() {
        // TODO Auto-generated method stub
        return """
               Lightning springs from you to a creature that you try to touch. Make a melee spell attack against the target. On a hit, the target takes 1d8 Lightning damage, and it can't make Opportunity Attacks until the start of its next turn.\r
               Cantrip Upgrade. The damage increases by 1d8 when you reach levels 5 (2d8), 11 (3d8), and 17 (4d8).""" //
        ;
    }

    @Override
    public void onLevelUp(int lvl) {
        switch (lvl) {
            case 5 -> {setQuantityOfDie(2);}
            case 11 -> {setQuantityOfDie(3);}
            case 17 -> {setQuantityOfDie(4);}
            default -> {}
        }
    }

}
