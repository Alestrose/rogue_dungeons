package alan.spells.level_one;

import java.util.ArrayList;
import java.util.Arrays;

import alan.Constants;
import alan.Constants.DAMAGE_TYPE;
import alan.creatures.Creature;
import alan.grid_panel.Cell;
import alan.spells.SpellAbstract;
import alan.spells.SpellInterface;

public class Sleep extends SpellAbstract implements SpellInterface{

    public Sleep(){
        setSpellName("Sleep");
        setSpellLevel((byte) 1);
        setSchool(Constants.SCHOOL.ENCHANTMENT);
        setAction(true);
        setRange((short) 90);
        setDuration((byte) 10);
        setDamageDie(8);
        setQuantityOfDie(5);
    }

    @Override
    public void cast(Creature caster, Creature target, Creature[] targetList, Cell cell, DAMAGE_TYPE damage_type, int spellLevel) {
        levelSpellPrimaryDie(2, spellLevel);
        int healthPool = rollDamage(getDamageDie(), getQuantityOfDie());
        ArrayList<Creature> tempList = new ArrayList<>();
        tempList.addAll(Arrays.asList(targetList));

        // sort lowest currentHealth to highest
        tempList.sort((a, b) -> Integer.compare(a.getCurrentHealth(), b.getCurrentHealth()));

        for (Creature creature : tempList) {
            if(creature.getCurrentHealth() < healthPool) {
                creature.ApplyConditionEffect(Constants.CONDITION_KEY.UNCONSCIOUS, caster);
                healthPool -= creature.getCurrentHealth();
            }
        }
    }

    @Override
    public String descreiption() {
        // TODO Auto-generated method stub
        return """
               This spell sends creatures into a magical slumber. Roll 5d8; the total is how many hit points of creatures this spell can affect. Creatures within 20 feet of a point you choose within range are affected in ascending order of their current hit points (ignoring unconscious creatures).\r
               Starting with the creature that has the lowest current hit points, each creature affected by this spell falls unconscious until the spell ends, the sleeper takes damage, or someone uses an action to shake or slap the sleeper awake. Subtract each creature's hit points from the total before moving on to the creature with the next lowest hit points. A creature's hit points must be equal to or less than the remaining total for that creature to be affected.\r
               Undead and creatures immune to being charmed aren't affected by this spell.\r
               At Higher Levels. When you cast this spell using a spell slot of 2nd level or higher, roll an additional 2d8 for each slot level above 1st.""" //
        //
        //
        ;
    }

    @Override
    public void onLevelUp(int lvl) {
        // TODO Auto-generated method stub
        
    }

    
}
