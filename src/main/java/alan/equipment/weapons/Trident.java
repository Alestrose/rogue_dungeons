package alan.equipment.weapons;

import alan.Constants;
import alan.creatures.Creature;
import alan.equipment.Weapon;

public class Trident extends Weapon{

    public Trident(Creature wielder){
        super(wielder);
        setWeaponKey(Constants.WEAPON_KEY.TRIDENT);
        String s = getWeaponKey().name().toLowerCase().replace('_', ' ');
        setWeaponName(s.substring(0, 1).toUpperCase() + s.substring(1));
        setWeaponDamageType(Constants.DAMAGE_TYPE.PIERCING);
        setMasterySkill(Constants.MASTERY_SKILL.TOPPLE);
        setDamageDice(8);
        setDamageDiceTwoHanded(10);
        setDamageDiceQuantity(1);
        setRange(60);
        setMartial(true);
        setMelee(true);
        setVersitile(true);
        setThrown(true);
        setWeight(4);
        setCost(5);
    }

}
