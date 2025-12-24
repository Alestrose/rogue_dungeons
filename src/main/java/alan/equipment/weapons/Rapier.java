package alan.equipment.weapons;

import alan.Constants;
import alan.creatures.Creature;
import alan.equipment.WeaponAbstract;

public class Rapier extends WeaponAbstract{

    public Rapier(Creature wielder){
        super(wielder);
        setWeaponKey(Constants.WEAPON_KEY.RAPIER);
        String s = getWeaponKey().name().toLowerCase().replace('_', ' ');
        setName(s.substring(0, 1).toUpperCase() + s.substring(1));
        setWeaponDamageType(Constants.DAMAGE_TYPE.PIERCING);
        setMasterySkill(Constants.MASTERY_SKILL.VEX);
        setDamageDie(8);
        setDamageDieQuantity(1);
        setRange(0);
        setMartial(true);
        setMelee(true);
        setFinesse(true);
        setWeight(2);
        setCost(25);
    }

}
