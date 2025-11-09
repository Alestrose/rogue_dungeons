package alan.spells.level_one;

import alan.Constants;
import alan.Constants.DAMAGE_TYPE;
import alan.creatures.Creature;
import alan.grid_panel.Cell;
import alan.spells.SpellAbstract;
import alan.spells.SpellInterface;

public class DissonantWhispers extends SpellAbstract implements SpellInterface{
    public DissonantWhispers(){
        setSpellName("Dissonant Whispers");
        setSpellLevel((byte) 1);
        setSchool(Constants.SCHOOL.ENCHANTMENT);
        setDamage_type(Constants.DAMAGE_TYPE.PSYCHIC);
        setSavingThrow(Constants.ABILITY.WISDOM);
        setAction(true);
        setRange((short) 60);
        setDuration((byte) 0);
        setDamageDie(6);
        setQuantityOfDie(3);
    }

    @Override
    public void cast(Creature caster, Creature target, Creature[] targetList, Cell cell, DAMAGE_TYPE damage_type,
            int spellLevel) {
        switch (spellLevel) {
            case 2 -> {setQuantityOfDie(4);}
            case 3 -> {setQuantityOfDie(5);}
            case 4 -> {setQuantityOfDie(6);}
            case 5 -> {setQuantityOfDie(7);}
            case 6 -> {setQuantityOfDie(8);}
            case 7 -> {setQuantityOfDie(9);}
            default -> {}
        }
        target.damageHealth(rollDamage(getDamageDie(), getQuantityOfDie()));
        target.ApplyConditionEffect(Constants.CONDITION_KEY.FRIGHTENED, caster);
        
    }

    @Override
    public String descreiption() {
        return """
               One creature of your choice that you can see within range hears a discordant melody in its mind. The target makes a Wisdom saving throw. On a failed save, it takes 3d6 Psychic damage and must immediately use its Reaction, if available, to move as far away from you as it can, using the safest route. On a successful save, the target takes half as much damage only.\r
               Using a Higher-Level Spell Slot. The damage increases by 1d6 for each spell slot level above 1.""" //
        ;
    }

    @Override
    public void onLevelUp(int lvl) {
        // TODO Auto-generated method stub
        
    }

    }
