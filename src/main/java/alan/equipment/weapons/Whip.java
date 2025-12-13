package alan.equipment.weapons;

import alan.Constants;
import alan.creatures.Creature;
import alan.equipment.Weapon;

public class Whip extends Weapon{

    public Whip(Creature wielder){
        super(wielder);
        setWeaponKey(Constants.WEAPON_KEY.WHIP);
        String s = getWeaponKey().name().toLowerCase().replace('_', ' ');
        setName(s.substring(0, 1).toUpperCase() + s.substring(1));
        setWeaponDamageType(Constants.DAMAGE_TYPE.SLASHING);
        setMasterySkill(Constants.MASTERY_SKILL.SLOW);
        setDamageDice(4);
        setDamageDiceQuantity(1);
        setRange(0);
        setReach(10);
        setMartial(true);
        setMelee(true);
        setIsReach(true);
        setFinesse(true);
        setWeight(3);
        setCost(2);
    }

}
