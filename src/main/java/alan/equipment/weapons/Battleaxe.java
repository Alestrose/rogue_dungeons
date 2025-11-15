package alan.equipment.weapons;

import alan.Constants;
import alan.creatures.Creature;
import alan.equipment.Weapon;

public class Battleaxe extends Weapon{

    public Battleaxe(Creature wielder){
        super(wielder);
        setWeaponKey(Constants.WEAPON_KEY.BATTLEAXE);
        String s = getWeaponKey().name().toLowerCase().replace('_', ' ');
        setWeaponName(s.substring(0, 1).toUpperCase() + s.substring(1));
        setWeaponDamageType(Constants.DAMAGE_TYPE.SLASHING);
        setMasterySkill(Constants.MASTERY_SKILL.TOPPLE);
        setDamageDice(8);
        setDamageDiceTwoHanded(10);
        setDamageDiceQuantity(1);
        setMartial(true);
        setMelee(true);
        setReach(5);
        setRange(0);
        setVersitile(true);
        setWeight(4);
        setCost(10);
    }
}
