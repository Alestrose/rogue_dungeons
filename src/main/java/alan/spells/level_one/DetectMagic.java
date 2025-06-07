package alan.spells.level_one;

import alan.Constants;
import alan.Constants.DAMAGE_TYPE;
import alan.creatures.Creature;
import alan.grid_panel.Cell;
import alan.spells.SpellAbstract;
import alan.spells.SpellInterface;

public class DetectMagic extends SpellAbstract implements SpellInterface{

    public DetectMagic(){
        setSpellName("Detect Magic");
        setSpellLevel((byte) 1);
        setSchool(Constants.SCHOOL.DIVINATION);
        setDamage_type(Constants.DAMAGE_TYPE.FORCE);
        setSavingThrow(Constants.ABILITY.INTELLIGENCE);
        setConcentration(true);
        setAction(true);
        setRitual(true);
        setRange((short) 0);
        setDuration((byte) 100);
    }

    @Override
    public void cast(Creature caster, Creature target, Creature[] targetList, Cell cell, DAMAGE_TYPE damage_type,
            int spellLevel) {
        // No combat implementation
    }

    @Override
    public String descreiption() {
        // TODO Auto-generated method stub
        return """
               For the duration, you sense the presence of magical effects within 30 feet of yourself. If you sense such effects, you can take the Magic action to see a faint aura around any visible creature or object in the area that bears the magic, and if an effect was created by a spell, you learn the spell's school of magic.\r
               The spell is blocked by 1 foot of stone, dirt, or wood; 1 inch of metal; or a thin sheet of lead.""" //
        ;
    }

    @Override
    public void onLevelUp(int lvl) {
        // TODO Auto-generated method stub
        
    }
    
}
