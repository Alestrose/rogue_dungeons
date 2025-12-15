package alan.equipment.weapons;

import alan.Constants;
import alan.creatures.Creature;
import alan.equipment.WeaponAbstract;

public class Flail extends WeaponAbstract{

    public Flail(Creature wielder){
        super(wielder);
        setWeaponKey(Constants.WEAPON_KEY.FLAIL);
        String s = getWeaponKey().name().toLowerCase().replace('_', ' ');
        setName(s.substring(0, 1).toUpperCase() + s.substring(1));
        setWeaponDamageType(Constants.DAMAGE_TYPE.BLUDGEONING);
        setMasterySkill(Constants.MASTERY_SKILL.SAP);
        setDamageDice(8);
        setDamageDiceQuantity(1);
        setMartial(true);
        setMelee(true);
        setReach(5);
        setRange(0);
        setWeight(2);
        setCost(10);
    }
}
