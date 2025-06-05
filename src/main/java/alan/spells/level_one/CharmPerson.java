package alan.spells.level_one;

import alan.Constants;
import alan.Constants.CONDITION_KEY;
import alan.Constants.DAMAGE_TYPE;
import alan.creatures.Creature;
import alan.grid_panel.Cell;
import alan.spells.SpellAbstract;
import alan.spells.SpellInterface;

public class CharmPerson extends SpellAbstract implements SpellInterface{

    public CharmPerson(){
        setSpellName("Charm Person");
        setSpellLevel((byte) 1);
        setSchool(Constants.SCHOOL.ENCHANTMENT);
        setSavingThrow(Constants.ABILITY.WISDOM);
        setAction(true);
        setRange((short) 30);
        setDuration((byte) 600);
        setMultiCastHits(1);
    }

    @Override
    public void cast(Creature caster, Creature target, Creature[] targetList, Cell cell, DAMAGE_TYPE damage_type, int spellLevel) {
        switch (spellLevel) {
            case 2 -> {setMultiCastHits(2);}
            case 3 -> {setMultiCastHits(3);}
            case 4 -> {setMultiCastHits(4);}
            case 5 -> {setMultiCastHits(5);}
            case 6 -> {setMultiCastHits(6);}
            case 7 -> {setMultiCastHits(7);}
            default -> {}
        }
        for (Creature creature : targetList) {
            creature.ApplyConditionEffect(CONDITION_KEY.CHARMED);
        }
    }

    @Override
    public String descreiption() {
        return """
               One Humanoid you can see within range makes a Wisdom saving throw. It does so with Advantage if you or your allies are fighting it. On a failed save, the target has the Charmed condition until the spell ends or until you or your allies damage it. The Charmed creature is Friendly to you. When the spell ends, the target knows it was Charmed by you.\r
               Using a Higher-Level Spell Slot. You can target one additional creature for each spell slot level above 1.""" //
        ;
    }

    @Override
    public void onLevelUp(int lvl) {
        // TODO Auto-generated method stub
        
    }
    

}
