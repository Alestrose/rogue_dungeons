package alan.equipment.weapons;

import alan.Constants;
import alan.creatures.Creature;
import alan.equipment.Weapon;

public class Javelin extends Weapon{

    public Javelin(Creature wielder){
        super(wielder);
        setWeaponKey(Constants.WEAPON_KEY.JAVELIN);
        String s = getWeaponKey().name().toLowerCase().replace('_', ' ');
        setName(s.substring(0, 1).toUpperCase() + s.substring(1));
        setWeaponDamageType(Constants.DAMAGE_TYPE.PIERCING);
        setMasterySkill(Constants.MASTERY_SKILL.SLOW);
        setDamageDice(6);
        setDamageDiceQuantity(1);
        setSimple(true);
        setMelee(true);
        setReach(5);
        setRange(120);
        setThrown(true);
        setWeight(2);
        setCost(.5);
    }
}
