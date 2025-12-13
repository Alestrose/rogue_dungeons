package alan.equipment.weapons;

import alan.Constants;
import alan.creatures.Creature;
import alan.equipment.Weapon;

public class Blowgun extends Weapon{

    public Blowgun(Creature wielder){
        super(wielder);
        setWeaponKey(Constants.WEAPON_KEY.BLOWGUN);
        String s = getWeaponKey().name().toLowerCase().replace('_', ' ');
        setName(s.substring(0, 1).toUpperCase() + s.substring(1));
        setWeaponDamageType(Constants.DAMAGE_TYPE.PIERCING);
        setMasterySkill(Constants.MASTERY_SKILL.VEX);
        setDamageDice(1);
        setDamageDiceQuantity(1);
        setRange(100);
        setMartial(true);
        setRanged(true);
        setWeight(1);
        setCost(10);
    }

}
