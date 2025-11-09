package alan.spells.level_one;

import alan.Constants;
import alan.Constants.DAMAGE_TYPE;
import alan.creatures.Creature;
import alan.grid_panel.Cell;
import alan.spells.SpellAbstract;
import alan.spells.SpellInterface;

public class EnsnaringStrike extends SpellAbstract implements SpellInterface{
    public EnsnaringStrike(){
        setSpellName("Ensnaring Strike");
        setSpellLevel((byte) 1);
        setSchool(Constants.SCHOOL.CONJURATION);
        setDamage_type(Constants.DAMAGE_TYPE.PIERCING);
        setSavingThrow(Constants.ABILITY.STRENGTH);
        setConcentration(true);
        setBonus(true);
        setRange((short) 0);
        setDuration((byte) 10);
        setDamageDie(6);
        setQuantityOfDie(1);
    }

    @Override
    public void cast(Creature caster, Creature target, Creature[] targetList, Cell cell, DAMAGE_TYPE damage_type,
            int spellLevel) {
        switch (spellLevel) {
            case 2 -> {setQuantityOfDie(2);}
            case 3 -> {setQuantityOfDie(3);}
            case 4 -> {setQuantityOfDie(4);}
            case 5 -> {setQuantityOfDie(5);}
            case 6 -> {setQuantityOfDie(6);}
            case 7 -> {setQuantityOfDie(7);}
            default -> {}
        }
        target.ApplyConditionEffect(Constants.CONDITION_KEY.RESTRAINED, caster);
        
    }

    @Override
    public String descreiption() {
        // TODO Auto-generated method stub
        return """
               As you hit the target, grasping vines appear on it, and it makes a Strength saving throw. A Large or larger creature has Advantage on this save. On a failed save, the target has the Restrained condition until the spell ends. On a successful save, the vines shrivel away, and the spell ends.\r
               While Restrained, the target takes 1d6 Piercing damage at the start of each of its turns. The target or a creature within reach of it can take an action to make a Strength (Athletics) check against your spell save DC. On a success, the spell ends.\r
               Using a Higher-Level Spell Slot. The damage increases by 1d6 for each spell slot level above 1.""" //
        //
        ;
    }

    @Override
    public void onLevelUp(int lvl) {
        // TODO Auto-generated method stub
        
    }
    
}
