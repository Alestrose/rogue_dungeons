package alan.equipment.weapons;

import alan.Constants;
import alan.creatures.Creature;
import alan.equipment.Weapon;

public class Shortsword extends Weapon{

    public Shortsword(Creature wielder){
        super(wielder);
        setWeaponKey(Constants.WEAPON_KEY.SHORTSWORD);
        String s = getWeaponKey().name().toLowerCase().replace('_', ' ');
        setWeaponName(s.substring(0, 1).toUpperCase() + s.substring(1));
        setWeaponDamageType(Constants.DAMAGE_TYPE.PIERCING);
        setMasterySkill(Constants.MASTERY_SKILL.CLEAVE);
        setDamageDice(6);
        setDamageDiceQuantity(1);
        setRange(0);
        setMartial(true);
        setMelee(true);
        setFinesse(true);
        setLight(true);
        setWeight(7);
        setCost(30);
    }

}
