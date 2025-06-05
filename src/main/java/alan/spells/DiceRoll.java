package alan.spells;

import java.util.Random;

public interface DiceRoll {
    static final Random random = new Random();

    // Returns damage roll based on damage die and quanity of damage die
    int rollDamage(int damageDie, int quantityOfDie);
    
    
}
