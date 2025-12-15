package alan.equipment.weapons;

import alan.Constants;
import alan.creatures.Creature;
import alan.equipment.WeaponAbstract;

public class Maul extends WeaponAbstract{

    public Maul(Creature wielder){
        super(wielder);
        setWeaponKey(Constants.WEAPON_KEY.MAUL);
        String s = getWeaponKey().name().toLowerCase().replace('_', ' ');
        setName(s.substring(0, 1).toUpperCase() + s.substring(1));
        setWeaponDamageType(Constants.DAMAGE_TYPE.BLUDGEONING);
        setMasterySkill(Constants.MASTERY_SKILL.TOPPLE);
        setDamageDice(6);
        setDamageDiceTwoHanded(6);
        setDamageDiceQuantity(2);
        setMartial(true);
        setRange(0);
        setMelee(true);
        setHeavy(true);
        setTwoHanded(true);
        setWeight(10);
        setCost(10);
    }

}
