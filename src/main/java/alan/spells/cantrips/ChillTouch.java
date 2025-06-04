package alan.spells.cantrips;

import alan.Constants;
import alan.Constants.CONDITION_KEY;
import alan.creatures.Creature;
import alan.grid_panel.Cell;
import alan.spells.SpellAbstract;
import alan.spells.SpellInterface;

public class ChillTouch extends SpellAbstract implements SpellInterface{

    public ChillTouch(){
        setSpellName("Chill Touch");
        setSpellLevel((byte) 0);
        setSchool(Constants.SCHOOL.NECROMANCY);
        setDamage_type(Constants.DAMAGE_TYPE.NECROTIC);
        setAction(true);
        setRange((short) 0);
        setDuration((byte) 10);
        setDamageDie(10);
        setQuantityOfDie(1);
    }

    @Override
    public void cast(Creature caster, Creature target, Creature[] targetList, Cell cell, Constants.DAMAGE_TYPE damage_type) {
        target.damageHealth(damageRoll(getDamageDie(), getQuantityOfDie()));
        target.ApplyConditionEffect(CONDITION_KEY.CHILL_TOUCH);
    }

    @Override
    public String descreiption() {
        return """
               Channeling the chill of the grave, make a melee spell attack against a target within reach. On a hit, the target takes 1d10 Necrotic damage, and it can't regain Hit Points until the end of your next turn.\r
               Cantrip Upgrade. The damage increases by 1d10 when you reach levels 5 (2d10), 11 (3d10), and 17 (4d10).""" //
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
