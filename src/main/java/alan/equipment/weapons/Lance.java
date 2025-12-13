package alan.equipment.weapons;

import alan.Constants;
import alan.creatures.Creature;
import alan.equipment.Weapon;

public class Lance extends Weapon{

    public Lance(Creature wielder){
        super(wielder);
        setWeaponKey(Constants.WEAPON_KEY.LANCE);
        String s = getWeaponKey().name().toLowerCase().replace('_', ' ');
        setName(s.substring(0, 1).toUpperCase() + s.substring(1));
        setWeaponDamageType(Constants.DAMAGE_TYPE.PIERCING);
        setMasterySkill(Constants.MASTERY_SKILL.TOPPLE);
        setDamageDice(10);
        setDamageDiceTwoHanded(10);
        setDamageDiceQuantity(1);
        setMartial(true);
        setMelee(true);
        setIsReach(true);
        setRange(0);
        setReach(5);
        setHeavy(true);
        setTwoHanded(true);
        setWeight(6);
        setCost(10);
    }

}
