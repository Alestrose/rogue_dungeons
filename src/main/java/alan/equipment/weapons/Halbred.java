package alan.equipment.weapons;

import alan.Constants;
import alan.creatures.Creature;
import alan.equipment.WeaponAbstract;

public class Halbred extends WeaponAbstract{

    public Halbred(Creature wielder){
        super(wielder);
        setWeaponKey(Constants.WEAPON_KEY.HALBRED);
        String s = getWeaponKey().name().toLowerCase().replace('_', ' ');
        setName(s.substring(0, 1).toUpperCase() + s.substring(1));
        setWeaponDamageType(Constants.DAMAGE_TYPE.SLASHING);
        setMasterySkill(Constants.MASTERY_SKILL.CLEAVE);
        setDamageDie(10);
        setDamageDieTwoHanded(10);
        setDamageDieQuantity(1);
        setMartial(true);
        setMelee(true);
        setReach(5);
        setIsReach(true);
        setRange(0);
        setTwoHanded(true);
        setHeavy(true);
        setWeight(6);
        setCost(20);
    }

}
