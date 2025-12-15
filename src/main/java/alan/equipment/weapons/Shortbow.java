package alan.equipment.weapons;

import alan.Constants;
import alan.creatures.Creature;
import alan.equipment.WeaponAbstract;

public class Shortbow extends WeaponAbstract{

    public Shortbow(Creature wielder){
        super(wielder);
        setWeaponKey(Constants.WEAPON_KEY.SHORTBOW);
        String s = getWeaponKey().name().toLowerCase().replace('_', ' ');
        setName(s.substring(0, 1).toUpperCase() + s.substring(1));
        setWeaponDamageType(Constants.DAMAGE_TYPE.PIERCING);
        setMasterySkill(Constants.MASTERY_SKILL.VEX);
        setDamageDice(6);
        setDamageDiceTwoHanded(6);
        setDamageDiceQuantity(1);
        setSimple(true);
        setRanged(true);
        setReach(5);
        setRange(320);
        setTwoHanded(true);
        setWeight(2);
        setCost(25);
    }
}
