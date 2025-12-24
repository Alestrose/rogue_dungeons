package alan.interfaces;

import java.util.Random;

import alan.Constants;
import alan.creatures.Creature;

public interface DiceRoll {
    static final Random random = new Random();

    // Returns damage roll based on damage die and quanity of damage die
    int rollDamage(int damageDie, int quantityOfDie);

    int rollWeaponDamage();
    
    // Returns true if target specified ability modifier plus a random d20 is greater than or equal to casters spell save DC
    void rollSpellSaveCheck(Creature target, Creature caster, Constants.ABILITY ability, Runnable onSuccess, Runnable onFail);

    // Returns true if target spell attack bonus plus a random d20 is greater than or equal to casters AC
    void rollToHitAcMeleeSpellAttack(Creature target, Creature caster, Constants.ABILITY ability, Runnable onFail);

    boolean rollToHitACMellee(Creature target, Creature caster);

    boolean rollToHitACRanged(Creature target, Creature caster);
}
