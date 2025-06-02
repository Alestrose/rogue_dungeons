package alan.spells;

import java.util.Random;

public interface DiceRoll {
    static final Random random = new Random();

    // Returns damage roll based on damage die and quanity of damage die
    int damageRoll(int damageDie, int quantityOfDie);
    /*
     * @Override
        public int damageRoll(int damageDie, int quantityOfDie) {
        int total = 0;
        for (int i = 0; i < quantityOfDie; i++) {
            total += random.nextInt(damageDie) + 1;
        }
        return total;
    }
     */
}
