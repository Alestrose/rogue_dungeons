package alan.spells.level_one;

import alan.Constants;
import alan.Constants.DAMAGE_TYPE;
import alan.creatures.Creature;
import alan.grid_panel.Cell;
import alan.spells.SpellAbstract;
import alan.spells.SpellInterface;

public class FalseLife extends SpellAbstract implements SpellInterface{
    int levelModifier = 0;

    public FalseLife(){
        setSpellName("False Life");
        setSpellLevel((byte) 1);
        setSchool(Constants.SCHOOL.NECROMANCY);
        setAction(true);
        setRange((short) 0);
        setDamageDie(4);
        setQuantityOfDie(2);

    }

    @Override
    public void cast(Creature caster, Creature target, Creature[] targetList, Cell cell, DAMAGE_TYPE damage_type,
            int spellLevel) {
        switch (spellLevel) {
            case 2 -> {setLevelModifier(5);}
            case 3 -> {setLevelModifier(10);}
            case 4 -> {setLevelModifier(15);}
            case 5 -> {setLevelModifier(20);}
            case 6 -> {setLevelModifier(25);}
            case 7 -> {setLevelModifier(30);}
            default -> {}
        }
        caster.setTempHealth(rollDamage(getDamageDie(), getQuantityOfDie()) + 4 + getLevelModifier());
    }

    @Override
    public String descreiption() {
        return """
               You gain 2d4 + 4 Temporary Hit Points.\r
               Using a Higher-Level Spell Slot. You gain 5 additional Temporary Hit Points for each spell slot level above 1.""" //
        ;
    }

    @Override
    public void onLevelUp(int lvl) {
        // TODO Auto-generated method stub
        
    }

     public int getLevelModifier() {
        return levelModifier;
    }

    public void setLevelModifier(int levelModifier) {
        this.levelModifier = levelModifier;
    }
    
}
