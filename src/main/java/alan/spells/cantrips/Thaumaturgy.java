package alan.spells.cantrips;

import alan.Constants;
import alan.Constants.DAMAGE_TYPE;
import alan.creatures.Creature;
import alan.grid_panel.Cell;
import alan.spells.SpellAbstract;
import alan.spells.SpellInterface;

public class Thaumaturgy extends SpellAbstract implements SpellInterface{

    public Thaumaturgy(){
        setSpellName("Thaumaturgy");
        setSpellLevel((byte) 0);
        setSchool(Constants.SCHOOL.EVOCATION);
        setDamage_type(Constants.DAMAGE_TYPE.FORCE);
        setSavingThrow(Constants.ABILITY.INTELLIGENCE);
        setSpellAttack(true);
        setConcentration(true);
        setAction(true);
        setRange((short) 30);
        setDuration((byte) 10);
    }

    @Override
    public void cast(Creature caster, Creature target, Creature[] targetList, Cell cell, DAMAGE_TYPE damage_type) {
        //Booming Voice
        target.grantSkillAdvantage(Constants.SKILL_KEY.INTIMIDATION);
    }

    @Override
    public String descreiption() {
        return """
               You manifest a minor wonder within range. You create one of the effects below within range. If you cast this spell multiple times, you can have up to three of its 1-minute effects active at a time.\r
               Altered Eyes. You alter the appearance of your eyes for 1 minute.\r
               Booming Voice. Your voice booms up to three times as loud as normal for 1 minute. For the duration, you have Advantage on Charisma (Intimidation) checks.\r
               Fire Play. You cause flames to flicker, brighten, dim, or change color for 1 minute.\r
               Invisible Hand. You instantaneously cause an unlocked door or window to fly open or slam shut.\r
               Phantom Sound. You create an instantaneous sound that originates from a point of your choice within range, such as a rumble of thunder, the cry of a raven, or ominous whispers.\r
               Tremors. You cause harmless tremors in the ground for 1 minute.""" //
        //
        //
        //
        //
        //
        ;
    }

    @Override
    public void onLevelUp(int lvl) {
        // TODO Auto-generated method stub
        
    }
    
}
