package alan.equipment.weapons;

import alan.Constants;
import alan.creatures.Creature;
import alan.equipment.Weapon;

public class Greatsword extends Weapon{

    public Greatsword(Creature wielder){
        super(wielder);
        setWeaponKey(Constants.WEAPON_KEY.GREATSWORD);
        String s = getWeaponKey().name().toLowerCase().replace('_', ' ');
        setWeaponName(s.substring(0, 1).toUpperCase() + s.substring(1));
        setWeaponDamageType(Constants.DAMAGE_TYPE.SLASHING);
        setMasterySkill(Constants.MASTERY_SKILL.GRAZE);
        setDamageDice(6);
        setDamageDiceTwoHanded(6);
        setDamageDiceQuantity(2);
        setRange(0);
        setMartial(true);
        setMelee(true);
        setHeavy(true);
        setTwoHanded(true);
        setWeight(6);
        setCost(50);
    }

}
