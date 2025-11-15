package alan.equipment.weapons;

import alan.Constants;
import alan.creatures.Creature;
import alan.equipment.Weapon;

public class Musket extends Weapon{

    public Musket(Creature wielder){
        super(wielder);
        setWeaponKey(Constants.WEAPON_KEY.MUSKET);
        String s = getWeaponKey().name().toLowerCase().replace('_', ' ');
        setWeaponName(s.substring(0, 1).toUpperCase() + s.substring(1));
        setWeaponDamageType(Constants.DAMAGE_TYPE.PIERCING);
        setMasterySkill(Constants.MASTERY_SKILL.SLOW);
        setDamageDiceTwoHanded(12);
        setDamageDiceQuantity(1);
        setRange(120);
        setTwoHanded(true);
        setMartial(true);
        setRanged(true);
        setWeight(10);
        setCost(500);
    }

}
