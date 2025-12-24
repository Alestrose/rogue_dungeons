package alan.spells.cantrips;

import alan.Constants;
import alan.creatures.Creature;
import alan.grid_panel.Cell;
import alan.spells.SpellAbstract;
import alan.spells.SpellInterface;

public class MindSliver extends SpellAbstract implements SpellInterface{

    public MindSliver() {
        setSpellName("Mind Sliver");
        setSpellLevel((byte) 0);
        setSavingThrow(Constants.ABILITY.INTELLIGENCE);
        setSchool(Constants.SCHOOL.ENCHANTMENT);
        setAction(true);
        setBonus(true);
        setReaction(true);
        setRange((short) 60);
        setDuration((byte) 1);
        setDamageDie(6);
        setQuantityOfDie(1);
    }

    @Override
    public void cast(Creature caster, Creature target, Creature[] targetList, Cell cell, Constants.DAMAGE_TYPE damage_type, int spellLevel) {
        target.applyDamage(rollDamage(getDamageDie(), getQuantityOfDie()), damage_type);
        target.setSavingThrowDecrease(4);
    }

    @Override
    public String descreiption() {
        // TODO Auto-generated method stub
        return null;
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
