package alan.equipment.weapons;

import alan.Constants;
import alan.creatures.Creature;
import alan.equipment.WeaponAbstract;

public class Javelin extends WeaponAbstract{

    public Javelin(Creature wielder){
        super(wielder);
        setWeaponKey(Constants.WEAPON_KEY.JAVELIN);
        String s = getWeaponKey().name().toLowerCase().replace('_', ' ');
        setName(s.substring(0, 1).toUpperCase() + s.substring(1));
        setWeaponDamageType(Constants.DAMAGE_TYPE.PIERCING);
        setMasterySkill(Constants.MASTERY_SKILL.SLOW);
        setDamageDie(6);
        setDamageDieQuantity(1);
        setSimple(true);
        setMelee(true);
        setReach(5);
        setRange(120);
        setThrown(true);
        setWeight(2);
        setCost(.5);
    }
}
