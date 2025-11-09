package alan.spells.level_one;

import alan.Constants;
import alan.Constants.DAMAGE_TYPE;
import alan.creatures.Creature;
import alan.grid_panel.Cell;
import alan.spells.SpellAbstract;
import alan.spells.SpellInterface;

public class Heroism extends SpellAbstract implements SpellInterface{
    public Heroism(){
        setSpellName("Heroism");
        setSpellLevel((byte) 1);
        setSchool(Constants.SCHOOL.ENCHANTMENT);
        setAction(true);
        setConcentration(true);
        setRange((short) 5);
        setDuration((byte) 10);
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
            creature.grantConditionInvulnerability(Constants.CONDITION_KEY.FRIGHTENED);
            creature.setTempHealth(caster.getSpellCastModifier());
        }
        
        // implement timer for these effects...
        
    }

    @Override
    public String descreiption() {
        return """
               A willing creature you touch is imbued with bravery. Until the spell ends, the creature is immune to the Frightened condition and gains Temporary Hit Points equal to your spellcasting ability modifier at the start of each of its turns.\r
               Using a Higher-Level Spell Slot. You can target one additional creature for each spell slot level above 1.""" //
        ;
    }

    @Override
    public void onLevelUp(int lvl) {
        // TODO Auto-generated method stub
        
    }

    
}
