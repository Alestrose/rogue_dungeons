package alan.spells.level_one;

import alan.Constants;
import alan.Constants.DAMAGE_TYPE;
import alan.creatures.Creature;
import alan.grid_panel.Cell;
import alan.spells.SpellAbstract;
import alan.spells.SpellInterface;

public class ArmorOfAgathys extends SpellAbstract implements SpellInterface{
    private int tempHealthMod = 5;
    private int auraDamage = 5;
    public ArmorOfAgathys(){
        setSpellName("Armor of Agathys");
        setSpellLevel((byte) 1);
        setSchool(Constants.SCHOOL.ABJURATION);
        setDamage_type(Constants.DAMAGE_TYPE.FORCE);
        setSavingThrow(Constants.ABILITY.INTELLIGENCE);
        setBonus(true);
        setRange((short) 0);
        setDuration((byte) 600);

    }

    @Override
    public void cast(Creature caster, Creature target, Creature[] targetList, Cell cell, DAMAGE_TYPE damage_type, int spellLevel) {
        switch (spellLevel) {
            case 2 -> {setTempHealthMod(10);setAuraDamage(10);}
            case 3 -> {setTempHealthMod(15);setAuraDamage(15);}
            case 4 -> {setTempHealthMod(20);setAuraDamage(20);}
            case 5 -> {setTempHealthMod(25);setAuraDamage(25);}
            case 6-> {setTempHealthMod(30);setAuraDamage(30);}
            case 7 -> {setTempHealthMod(35);setAuraDamage(35);}
            default -> {}
        }
        target.setTempHealth(target.getTempHealth() + tempHealthMod);
    }

    @Override
    public String descreiption() {
        return """
               Protective magical frost surrounds you. You gain 5 Temporary Hit Points. If a creature hits you with a melee attack roll before the spell ends, the creature takes 5 Cold damage. The spell ends early if you have no Temporary Hit Points.\r
               Using a Higher-Level Spell Slot. The Temporary Hit Points and the Cold damage both increase by 5 for cach spell slot level above 1.""" //
        ;
    }

    @Override
    public void onLevelUp(int lvl) {
        // TODO Auto-generated method stub
        
    }

    public int getTempHealthMod() {
        return tempHealthMod;
    }

    public void setTempHealthMod(int tempHealthMod) {
        this.tempHealthMod = tempHealthMod;
    }

    public int getAuraDamage() {
        return auraDamage;
    }

    public void setAuraDamage(int auraDamage) {
        this.auraDamage = auraDamage;
    }

    

    
}
