package alan.equipment.weapons;

import alan.Constants;
import alan.creatures.Creature;
import alan.equipment.WeaponAbstract;

public class Morningstar extends WeaponAbstract{

    public Morningstar(Creature wielder){
        super(wielder);
        setWeaponKey(Constants.WEAPON_KEY.MORNINGSTAR);
        String s = getWeaponKey().name().toLowerCase().replace('_', ' ');
        setName(s.substring(0, 1).toUpperCase() + s.substring(1));
        setWeaponDamageType(Constants.DAMAGE_TYPE.PIERCING);
        setMasterySkill(Constants.MASTERY_SKILL.SAP);
        setDamageDie(8);
        setDamageDieQuantity(1);
        setMartial(true);
        setMelee(true);
        setReach(5);
        setRange(0);
        setVersitile(true);
        setWeight(4);
        setCost(10);
    }

}
