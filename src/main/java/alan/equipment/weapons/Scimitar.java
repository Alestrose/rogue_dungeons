package alan.equipment.weapons;

import alan.Constants;
import alan.creatures.Creature;
import alan.equipment.WeaponAbstract;

public class Scimitar extends WeaponAbstract{

    public Scimitar(Creature wielder){
        super(wielder);
        setWeaponKey(Constants.WEAPON_KEY.SCIMITAR);
        String s = getWeaponKey().name().toLowerCase().replace('_', ' ');
        setName(s.substring(0, 1).toUpperCase() + s.substring(1));
        setWeaponDamageType(Constants.DAMAGE_TYPE.SLASHING);
        setMasterySkill(Constants.MASTERY_SKILL.NICK);
        setDamageDice(6);
        setDamageDiceQuantity(1);
        setRange(0);
        setMartial(true);
        setMelee(true);
        setFinesse(true);
        setLight(true);
        setWeight(3);
        setCost(25);
    }

}
