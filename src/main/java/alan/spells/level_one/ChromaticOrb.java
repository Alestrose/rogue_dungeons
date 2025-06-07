package alan.spells.level_one;

import alan.Constants;
import alan.Constants.DAMAGE_TYPE;
import alan.creatures.Creature;
import alan.grid_panel.Cell;
import alan.spells.SpellAbstract;
import alan.spells.SpellInterface;

public class ChromaticOrb extends SpellAbstract implements SpellInterface{

    public ChromaticOrb(){
        setSpellName("Chromatic Orb");
        setSpellLevel((byte) 1);
        setSchool(Constants.SCHOOL.EVOCATION);
        setSpellAttack(true);
        setAction(true);
        setRange((short) 90);
        setDuration((byte) 0);
        setDamageDie(8);
        setQuantityOfDie(3);
    }

    @Override
    public void cast(Creature caster, Creature target, Creature[] targetList, Cell cell, DAMAGE_TYPE damage_type,
            int spellLevel) {
        switch (spellLevel) {
            case 2 -> {setQuantityOfDie(4);}
            case 3 -> {setQuantityOfDie(5);}
            case 4 -> {setQuantityOfDie(6);}
            case 5 -> {setQuantityOfDie(7);}
            case 6 -> {setQuantityOfDie(8);}
            case 7 -> {setQuantityOfDie(9);}
            default -> {}
        }
        target.damageHealth(rollDamage(getDamageDie(), getQuantityOfDie()));
        
    }

    @Override
    public String descreiption() {
        return """
               You hurl a 4-inch-diameter sphere of energy at a creature that you can see within range. You choose acid, cold, fire, lightning, poison, or thunder for the type of orb you create, and then make a ranged spell attack against the target. If the attack hits, the creature takes 3d8 damage of the type you chose.\r
               At Higher Levels. When you cast this spell using a spell slot of 2nd level or higher, the damage increases by 1d8 for each slot level above 1st.""" //
        ;
    }

    @Override
    public void onLevelUp(int lvl) {
        // TODO Auto-generated method stub
        
    }
    
}
