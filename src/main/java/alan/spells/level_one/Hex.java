package alan.spells.level_one;

import alan.Constants;
import alan.Constants.DAMAGE_TYPE;
import alan.creatures.Creature;
import alan.grid_panel.Cell;
import alan.spells.SpellAbstract;
import alan.spells.SpellInterface;

public class Hex extends SpellAbstract implements SpellInterface{

    public Hex(){
        setSpellName("Hex");
        setSpellLevel((byte) 1);
        setSchool(Constants.SCHOOL.ENCHANTMENT);
        setDamage_type(Constants.DAMAGE_TYPE.NECROTIC);
        setSavingThrow(Constants.ABILITY.INTELLIGENCE);
        setSpellAttack(true);
        setConcentration(true);
        setAction(true);
        setRange((short) 90);
        setDuration((byte) 100);
        setDamageDie(6);
        setQuantityOfDie(1);
    }

    @Override
    public void cast(Creature caster, Creature target, Creature[] targetList, Cell cell, DAMAGE_TYPE damage_type,
            int spellLevel) {
        
        target.ApplyConditionEffect(Constants.CONDITION_KEY.HEXED, caster);
        
    }

    @Override
    public String descreiption() {
        return """
               You place a curse on a creature that you can see within range. Until the spell ends, you deal an extra 1d6 Necrotic damage to the target whenever you hit it with an attack roll. Also, choose one ability when you cast the spell. The target has Disadvantage on ability checks made with the chosen ability.\r
               If the target drops to 0 Hit Points before this spell ends, you can use a Bonus Action on a later turn to curse a new creature.""" //
        ;
    }

    @Override
    public void onLevelUp(int lvl) {
        // TODO Auto-generated method stub
        
    }
    
}
