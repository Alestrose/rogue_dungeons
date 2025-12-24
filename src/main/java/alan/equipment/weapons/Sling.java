package alan.equipment.weapons;

import alan.Constants;
import alan.creatures.Creature;
import alan.equipment.WeaponAbstract;

public class Sling extends WeaponAbstract{

    public Sling(Creature wielder){
        super(wielder);
        setWeaponKey(Constants.WEAPON_KEY.SLING);
        String s = getWeaponKey().name().toLowerCase().replace('_', ' ');
        setName(s.substring(0, 1).toUpperCase() + s.substring(1));
        setWeaponDamageType(Constants.DAMAGE_TYPE.BLUDGEONING);
        setMasterySkill(Constants.MASTERY_SKILL.SLOW);
        setDamageDie(4);
        setDamageDieQuantity(1);
        setSimple(true);
        setRanged(true);
        setReach(5);
        setRange(120);
        setWeight(0);
        setCost(.1);
    }

}
