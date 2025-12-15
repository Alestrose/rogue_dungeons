package alan.equipment.weapons;

import alan.Constants;
import alan.creatures.Creature;
import alan.equipment.WeaponAbstract;

public class Glaive extends WeaponAbstract{

    public Glaive(Creature wielder){
        super(wielder);
        setWeaponKey(Constants.WEAPON_KEY.GLAIVE);
        String s = getWeaponKey().name().toLowerCase().replace('_', ' ');
        setName(s.substring(0, 1).toUpperCase() + s.substring(1));
        setWeaponDamageType(Constants.DAMAGE_TYPE.SLASHING);
        setMasterySkill(Constants.MASTERY_SKILL.GRAZE);
        setDamageDice(10);
        setDamageDiceTwoHanded(10);
        setDamageDiceQuantity(1);
        setMartial(true);
        setMelee(true);
        setReach(10);
        setRange(0);
        setIsReach(true);
        setHeavy(true);
        setTwoHanded(true);
        setWeight(6);
        setCost(20);
    }

}
