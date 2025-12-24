package alan.equipment.weapons;

import alan.Constants;
import alan.creatures.Creature;
import alan.equipment.WeaponAbstract;

public class Quarterstaff extends WeaponAbstract{

    public Quarterstaff(Creature wielder){
        super(wielder);
        setWeaponKey(Constants.WEAPON_KEY.QUARTERSTAFF);
        String s = getWeaponKey().name().toLowerCase().replace('_', ' ');
        setName(s.substring(0, 1).toUpperCase() + s.substring(1));
        setWeaponDamageType(Constants.DAMAGE_TYPE.BLUDGEONING);
        setMasterySkill(Constants.MASTERY_SKILL.TOPPLE);
        setDamageDie(6);
        setDamageDieTwoHanded(8);
        setDamageDieQuantity(1);
        setReach(5);
        setRange(0);
        setVersitile(true);
        setWeight(4);
        setCost(.2);
    }
}
