package alan.spells.cantrips;

import alan.Constants;
import alan.Constants.DAMAGE_TYPE;
import alan.creatures.Creature;
import alan.grid_panel.Cell;
import alan.spells.SpellAbstract;
import alan.spells.SpellInterface;

public class TollTheDead extends SpellAbstract implements SpellInterface{
    
    public TollTheDead(){
        setSpellName("Toll The Dead");
        setSpellLevel((byte) 0);
        setSchool(Constants.SCHOOL.NECROMANCY);
        setDamage_type(Constants.DAMAGE_TYPE.NECROTIC);
        setSavingThrow(Constants.ABILITY.WISDOM);
        setAction(true);
        setRange((short) 60);
        setDuration((byte) 0);
        setDamageDie(8);
        setQuantityOfDie(1);
    }

    @Override
    public void cast(Creature caster, Creature target, Creature[] targetList, Cell cell, DAMAGE_TYPE damage_type, int spellLevel) {
        if(target.getCurrentHealth() < target.getMaxHealth()){
            target.applyDamage(rollDamage(getDamageDie()+4, getQuantityOfDie()), damage_type);
        }else target.applyDamage(rollDamage(getDamageDie(), getQuantityOfDie()), damage_type);
    }

    @Override
    public String descreiption() {
        // TODO Auto-generated method stub
        return """
               You point at one creature you can see within range, and the single chime of a dolorous bell is audible within 10 feet of the target. The target must succeed on a Wisdom saving throw or take 1d8 Necrotic damage. If the target is missing any of its Hit Points it instead takes 1d12 Necrotic damage.\r
               Cantrip Upgrade. The damage increases by one die when you reach levels 5 (2d8 or 2d12), 11 (3d8 or 3d12), and 17 (4d8 or 4d12).""" //
        ;
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
