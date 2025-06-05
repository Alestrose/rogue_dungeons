package alan.spells.level_one;

import alan.Constants;
import alan.Constants.DAMAGE_TYPE;
import alan.creatures.Creature;
import alan.grid_panel.Cell;
import alan.spells.SpellAbstract;
import alan.spells.SpellInterface;

public class ArmsOfHadar extends SpellAbstract implements SpellInterface{

    public ArmsOfHadar(){
        setSpellName("Arms Of Hadar");
        setSpellLevel((byte) 1);
        setSchool(Constants.SCHOOL.CONJURATION);
        setDamage_type(Constants.DAMAGE_TYPE.NECROTIC);
        setSavingThrow(Constants.ABILITY.STRENGTH);
        setAction(true);
        setRange((short) 0);
        setDuration((byte) 0);
        setDamageDie(6);
        setQuantityOfDie(2);
    }

    @Override
    public void cast(Creature caster, Creature target, Creature[] targetList, Cell cell, DAMAGE_TYPE damage_type,int spellLevel) {
        switch (spellLevel) {
            case 2 -> {setQuantityOfDie(3);}
            case 3 -> {setQuantityOfDie(4);}
            case 4 -> {setQuantityOfDie(5);}
            case 5 -> {setQuantityOfDie(6);}
            case 6-> {setQuantityOfDie(7);}
            case 7 -> {setQuantityOfDie(8);}
            default -> {}
        }
        for (Creature creature : targetList) {
            creature.damageHealth(rollDamage(getDamageDie(), getQuantityOfDie()));
        }
    }

    @Override
    public String descreiption() {
        return """
               Invoking Hadar, you cause tendrils to erupt from yourself. Each creature in a 10-foot Emanation originating from you makes a Strength saving throw. On a failed save, a target takes 2d6 Necrotic damage and can't take Reactions until the start of its next turn. On a successful save, a target takes half as much damage only.\r
               Using a Higher-Level Spell Slot. The damage increases by 1d6 for each spell slot level above 1.""" //
        ;
    }

    @Override
    public void onLevelUp(int lvl) {
        // TODO Auto-generated method stub
        
    }
    

}
