package alan.equipment.weapons;

import alan.Constants;
import alan.creatures.Creature;
import alan.equipment.WeaponAbstract;

public class Spear extends WeaponAbstract{

    public Spear(Creature wielder){
        super(wielder);
        setWeaponKey(Constants.WEAPON_KEY.SPEAR);
        String s = getWeaponKey().name().toLowerCase().replace('_', ' ');
        setName(s.substring(0, 1).toUpperCase() + s.substring(1));
        setWeaponDamageType(Constants.DAMAGE_TYPE.PIERCING);
        setMasterySkill(Constants.MASTERY_SKILL.VEX);
        setDamageDie(6);
        setDamageDieTwoHanded(8);
        setDamageDieQuantity(1);
        setSimple(true);
        setMelee(true);
        setReach(5);
        setRange(60);
        setVersitile(true);
        setThrown(true);
        setWeight(3);
        setCost(1);
    }
}
