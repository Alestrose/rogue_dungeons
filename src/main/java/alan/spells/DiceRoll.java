package alan.spells;

import java.util.Random;

import alan.Constants;
import alan.creatures.Creature;

public interface DiceRoll {
    static final Random random = new Random();

    // Returns damage roll based on damage die and quanity of damage die
    int rollDamage(int damageDie, int quantityOfDie);
    
    // Returns true if creatures (target) specified ability modifier plus a random d20 is greater than or equal to casters spell save DC
    boolean rollSpellSaveCheck(Creature creature, Creature caster, Constants.ABILITY ability);
}
