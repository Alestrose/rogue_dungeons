package alan.spells.level_one;

import alan.Constants;
import alan.Constants.DAMAGE_TYPE;
import alan.creatures.Creature;
import alan.grid_panel.Cell;
import alan.spells.SpellAbstract;
import alan.spells.SpellInterface;

public class HailOfThorns extends SpellAbstract implements SpellInterface{
    public HailOfThorns(){
        setSpellName("Hail Of Thorns");
        setSpellLevel((byte) 1);
        setSchool(Constants.SCHOOL.CONJURATION);
        setDamage_type(Constants.DAMAGE_TYPE.PIERCING);
        setSavingThrow(Constants.ABILITY.DEXTERITY);
        setBonus(true);
        setRange((short) 0);
        setDuration((byte) 0);
        setDamageDie(10);
        setQuantityOfDie(1);
    }

    @Override
    public void cast(Creature caster, Creature target, Creature[] targetList, Cell cell, DAMAGE_TYPE damage_type, int spellLevel) {
        levelSpellPrimaryDie(1, spellLevel);
        
        for (Creature creature : targetList) {
            creature.damageHealth(rollDamage(getDamageDie(), getQuantityOfDie()));            
        }
    }

    @Override
    public String descreiption() {
        return """
               As you hit the creature, this spell creates a rain of thorns that sprouts from your Ranged weapon or ammunition. The target of the attack and each creature within 5 feet of it make a Dexterity saving throw, taking 1d10 Piercing damage on a failed save or half as much damage on a successful one.\r
               Using a Higher-Level Spell Slot. The damage increases by 1d10 for each spell slot level above 1.""" //
        ;
    }

    @Override
    public void onLevelUp(int lvl) {
        // TODO Auto-generated method stub
        
    }
    
}
