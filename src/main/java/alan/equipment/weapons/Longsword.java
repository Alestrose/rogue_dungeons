package alan.equipment.weapons;

import alan.Constants;
import alan.creatures.Creature;
import alan.equipment.Weapon;

public class Longsword extends Weapon{

    public Longsword(Creature wielder){
        super(wielder);
        setWeaponKey(Constants.WEAPON_KEY.LONGSWORD);
        String s = getWeaponKey().name().toLowerCase().replace('_', ' ');
        setWeaponName(s.substring(0, 1).toUpperCase() + s.substring(1));
        setWeaponDamageType(Constants.DAMAGE_TYPE.SLASHING);
        setMasterySkill(Constants.MASTERY_SKILL.SAP);
        setDamageDice(8);
        setDamageDiceTwoHanded(10);
        setDamageDiceQuantity(1);
        setMartial(true);
        setRange(0);
        setMelee(true);
        setVersitile(true);
        setWeight(3);
        setCost(15);
    }

}
