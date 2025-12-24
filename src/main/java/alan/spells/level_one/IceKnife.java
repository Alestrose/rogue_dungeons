package alan.spells.level_one;

import alan.Constants;
import alan.Constants.DAMAGE_TYPE;
import alan.creatures.Creature;
import alan.grid_panel.Cell;
import alan.spells.SpellAbstract;
import alan.spells.SpellInterface;

public class IceKnife extends SpellAbstract implements SpellInterface{

    public IceKnife(){
        setSpellName("Ice Knife");
        setSpellLevel((byte) 1);
        setSchool(Constants.SCHOOL.CONJURATION);
        setDamage_type(Constants.DAMAGE_TYPE.PIERCING);
        setSecondary_damage_type(Constants.DAMAGE_TYPE.ICE);
        setSavingThrow(Constants.ABILITY.DEXTERITY);
        setSpellAttack(true);
        setAction(true);
        setRange((short) 60);
        setDamageDie(10);
        setQuantityOfDie(1);
        setSecondaryDamageDie(6);
        setQuantityOfSecondaryDie(2);
    }

    @Override
    public void cast(Creature caster, Creature target, Creature[] targetList, Cell cell, DAMAGE_TYPE damage_type, int spellLevel) {
        levelSpellSecondaryDie(1, spellLevel);
        
        target.applyDamage(rollDamage(getDamageDie(), getQuantityOfDie()), damage_type);
        
        for (Creature creature : targetList) {
            rollSpellSaveCheck(creature, caster, getSavingThrow(),
                () -> {},
                () -> creature.applyDamage(rollDamage(getSecondaryDamageDie(), getQuantityOfSecondaryDie()), damage_type));
        }

        
    }

    @Override
    public String descreiption() {
        return """
               You create a shard of ice and fling it at one creature within range. Make a ranged spell attack against the target. On a hit, the target takes 1d10 Piercing damage. Hit or miss, the shard then explodes. The target and each creature within 5 feet of it must succeed on a Dexterity saving throw or take 2d6 Cold damage.\r
               Using a Higher-Level Spell Slot. The Cold damage increases by 1d6 for each spell slot level above 1.""" //
        ;
    }

    @Override
    public void onLevelUp(int lvl) {
        // TODO Auto-generated method stub
        
    }

    
}
