package alan.spells.level_one;

import alan.Constants;
import alan.Constants.CONDITION_KEY;
import alan.Constants.DAMAGE_TYPE;
import alan.creatures.Creature;
import alan.grid_panel.Cell;
import alan.spells.SpellAbstract;
import alan.spells.SpellInterface;

public class AnimalFriendship extends SpellAbstract implements SpellInterface{

    public AnimalFriendship(){
        setSpellName("Animal Friendship");
        setSpellLevel((byte) 1);
        setSchool(Constants.SCHOOL.ENCHANTMENT);
        setSavingThrow(Constants.ABILITY.WISDOM);
        setAction(true);
        setRange((short) 30);
        setDuration((byte) 0);
        setMultiCastHits(1);
    }

    @Override
    public void cast(Creature caster, Creature target, Creature[] targetList, Cell cell, DAMAGE_TYPE damage_type, int spellLevel) {
        for (Creature creature : targetList) {
            creature.ApplyConditionEffect(CONDITION_KEY.CHARMED, caster);
        }
    }

    @Override
    public String descreiption() {
        // TODO Auto-generated method stub
        return """
               Target a Beast that you can see within range. The target must succeed on a Wisdom saving throw or have the Charmed condition for the duration. If you or one of your allies deals damage to the target, the spells ends.\r
               Using a Higher-Level Spell Slot. You can target one additional Beast for each spell slot level above 1.""" //
        ;
    }

    @Override
    public void onLevelUp(int lvl) {
        switch (lvl) {
            case 5 -> {setMultiCastHits(2);}
            case 11 -> {setMultiCastHits(3);}
            case 17 -> {setMultiCastHits(3);}
            default -> {}
        }
    }

    

}
