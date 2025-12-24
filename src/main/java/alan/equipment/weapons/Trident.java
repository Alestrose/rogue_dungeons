package alan.equipment.weapons;

import alan.Constants;
import alan.creatures.Creature;
import alan.equipment.WeaponAbstract;

public class Trident extends WeaponAbstract{

    public Trident(Creature wielder){
        super(wielder);
        setWeaponKey(Constants.WEAPON_KEY.TRIDENT);
        String s = getWeaponKey().name().toLowerCase().replace('_', ' ');
        setName(s.substring(0, 1).toUpperCase() + s.substring(1));
        setWeaponDamageType(Constants.DAMAGE_TYPE.PIERCING);
        setMasterySkill(Constants.MASTERY_SKILL.TOPPLE);
        setDamageDie(8);
        setDamageDieTwoHanded(10);
        setDamageDieQuantity(1);
        setRange(60);
        setMartial(true);
        setMelee(true);
        setVersitile(true);
        setThrown(true);
        setWeight(4);
        setCost(5);
    }

}
