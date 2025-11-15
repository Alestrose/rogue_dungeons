package alan.equipment.weapons;

import alan.Constants;
import alan.creatures.Creature;
import alan.equipment.Weapon;

public class Pistol extends Weapon{

    public Pistol(Creature wielder){
        super(wielder);
        setWeaponKey(Constants.WEAPON_KEY.PISTOL);
        String s = getWeaponKey().name().toLowerCase().replace('_', ' ');
        setWeaponName(s.substring(0, 1).toUpperCase() + s.substring(1));
        setWeaponDamageType(Constants.DAMAGE_TYPE.PIERCING);
        setMasterySkill(Constants.MASTERY_SKILL.VEX);
        setDamageDice(10);
        setDamageDiceQuantity(1);
        setRange(90);
        setMartial(true);
        setRanged(true);
        setWeight(3);
        setCost(250);
    }

}
