package alan.spells;

import java.util.Random;

import alan.Constants;
import alan.creatures.Creature;

public interface DiceRoll {
    static final Random random = new Random();

    // Returns damage roll based on damage die and quanity of damage die
    int rollDamage(int damageDie, int quantityOfDie);
    
    // Returns true if target specified ability modifier plus a random d20 is greater than or equal to casters spell save DC
    boolean rollSpellSaveCheck(Creature target, Creature caster, Constants.ABILITY ability);

    // Returns true if target spell attack bonus plus a random d20 is greater than or equal to casters AC
    boolean rollToHitAC(Creature target, Creature caster);
}
