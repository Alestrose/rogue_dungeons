package alan.equipment.weapons;

import alan.Constants;
import alan.creatures.Creature;
import alan.equipment.Weapon;

public class Longbow extends Weapon{

    public Longbow(Creature wielder){
        super(wielder);
        setWeaponKey(Constants.WEAPON_KEY.LONGBOW);
        String s = getWeaponKey().name().toLowerCase().replace('_', ' ');
        setWeaponName(s.substring(0, 1).toUpperCase() + s.substring(1));
        setWeaponDamageType(Constants.DAMAGE_TYPE.PIERCING);
        setMasterySkill(Constants.MASTERY_SKILL.SLOW);
        setDamageDice(8);
        setDamageDiceTwoHanded(8);
        setDamageDiceQuantity(1);
        setRange(600);
        setHeavy(true);
        setTwoHanded(true);
        setMartial(true);
        setRanged(true);
        setWeight(2);
        setCost(50);
    }
}
