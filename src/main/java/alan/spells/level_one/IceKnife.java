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
        setQuantitySecondaryOfDie(2);
    }

    @Override
    public void cast(Creature caster, Creature target, Creature[] targetList, Cell cell, DAMAGE_TYPE damage_type, int spellLevel) {
        switch (spellLevel) {
            case 2 -> {setQuantitySecondaryOfDie(3);}
            case 3 -> {setQuantitySecondaryOfDie(4);}
            case 4 -> {setQuantitySecondaryOfDie(5);}
            case 5 -> {setQuantitySecondaryOfDie(6);}
            case 6 -> {setQuantitySecondaryOfDie(7);}
            case 7 -> {setQuantitySecondaryOfDie(8);}
            default -> {}
        }
        
        target.damageHealth(rollDamage(getDamageDie(), getQuantityOfDie()));
        for (Creature creature : targetList) {
            if(!spellSaveCheck(creature, caster, getSavingThrow())){
                creature.damageHealth(rollDamage(getSecondaryDamageDie(), getQuantitySecondaryOfDie()));
            }
        }

        
    }

    @Override
    public String descreiption() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void onLevelUp(int lvl) {
        // TODO Auto-generated method stub
        
    }

    
}
