package alan.equipment.weapons;

import alan.Constants;
import alan.creatures.Creature;
import alan.equipment.WeaponAbstract;

public class Sickle extends WeaponAbstract{

    public Sickle(Creature wielder){
        super(wielder);
        setWeaponKey(Constants.WEAPON_KEY.SICKLE);
        String s = getWeaponKey().name().toLowerCase().replace('_', ' ');
        setName(s.substring(0, 1).toUpperCase() + s.substring(1));
        setWeaponDamageType(Constants.DAMAGE_TYPE.SLASHING);
        setMasterySkill(Constants.MASTERY_SKILL.NICK);
        setDamageDie(4);
        setDamageDieQuantity(1);
        setSimple(true);
        setMelee(true);
        setReach(5);
        setRange(0);
        setLight(true);
        setWeight(2);
        setCost(1);
    }
}
