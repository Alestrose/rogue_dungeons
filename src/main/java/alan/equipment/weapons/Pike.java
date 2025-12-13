package alan.equipment.weapons;

import alan.Constants;
import alan.creatures.Creature;
import alan.equipment.Weapon;

public class Pike extends Weapon{

    public Pike(Creature wielder){
        super(wielder);
        setWeaponKey(Constants.WEAPON_KEY.PIKE);
        String s = getWeaponKey().name().toLowerCase().replace('_', ' ');
        setName(s.substring(0, 1).toUpperCase() + s.substring(1));
        setWeaponDamageType(Constants.DAMAGE_TYPE.PIERCING);
        setMasterySkill(Constants.MASTERY_SKILL.PUSH);
        setDamageDice(10);
        setDamageDiceTwoHanded(10);
        setDamageDiceQuantity(1);
        setRange(0);
        setMartial(true);
        setMelee(true);
        setTwoHanded(true);
        setHeavy(true);
        setIsReach(true);
        setWeight(18);
        setCost(5);
    }

}
