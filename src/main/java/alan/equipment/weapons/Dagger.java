package alan.equipment.weapons;

import alan.Constants;
import alan.creatures.Creature;
import alan.equipment.Weapon;

public class Dagger extends Weapon{

    public Dagger(Creature wielder){
        super(wielder);
        setWeaponKey(Constants.WEAPON_KEY.DAGGER);
        String s = getWeaponKey().name().toLowerCase().replace('_', ' ');
        setWeaponName(s.substring(0, 1).toUpperCase() + s.substring(1));
        setWeaponDamageType(Constants.DAMAGE_TYPE.PIERCING);
        setMasterySkill(Constants.MASTERY_SKILL.NICK);
        setDamageDice(4);
        setDamageDiceQuantity(1);
        setSimple(true);
        setMelee(true);
        setReach(5);
        setRange(60);
        setLight(true);
        setFinesse(true);
        setThrown(true);
        setWeight(1);
        setCost(2);
    }
}
