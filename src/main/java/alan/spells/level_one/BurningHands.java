package alan.spells.level_one;

import alan.Constants;
import alan.Constants.DAMAGE_TYPE;
import alan.creatures.Creature;
import alan.grid_panel.Cell;
import alan.spells.SpellAbstract;
import alan.spells.SpellInterface;

public class BurningHands extends SpellAbstract implements SpellInterface{

    public BurningHands(){
        setSpellName("Burning Hands");
        setSpellLevel((byte) 1);
        setSchool(Constants.SCHOOL.EVOCATION);
        setDamage_type(Constants.DAMAGE_TYPE.FIRE);
        setSavingThrow(Constants.ABILITY.DEXTERITY);
        setAction(true);
        setRange((short) 120);
        setDuration((byte) 0);
        setDamageDie(6);
        setQuantityOfDie(3);
    }

    @Override
    public void cast(Creature caster, Creature target, Creature[] targetList, Cell cell, DAMAGE_TYPE damage_type,
            int spellLevel) {
        switch (spellLevel) {
            case 2 -> {setQuantityOfDie(4);}
            case 3 -> {setMultiCastHits(5);}
            case 4 -> {setMultiCastHits(6);}
            case 5 -> {setMultiCastHits(7);}
            case 6 -> {setMultiCastHits(8);}
            case 7 -> {setMultiCastHits(9);}
            default -> {}
        }
        for (Creature creature : targetList) {
            creature.damageHealth(rollDamage(getDamageDie(), getQuantityOfDie()));
        }
        
    }

    @Override
    public String descreiption() {
        return """
               A thin sheet of flames shoots forth from you. Each creature in a 15-foot Cone makes a Dexterity saving throw, taking 3d6 Fire damage on a failed save or half as much damage on a successful one.\r
               Flammable objects in the Cone that aren't being worn or carried start burning.\r
               Using a Higher-Level Spell Slot. The damage increases by 1d6 for each spell slot level above 1.""" //
        //
        ;
    }

    @Override
    public void onLevelUp(int lvl) {
        // TODO Auto-generated method stub
        
    }
    

}
