package alan.equipment.weapons;

import alan.Constants;
import alan.creatures.Creature;
import alan.equipment.Weapon;

public class Dart extends Weapon{

    public Dart(Creature wielder){
        super(wielder);
        setWeaponKey(Constants.WEAPON_KEY.DART);
        String s = getWeaponKey().name().toLowerCase().replace('_', ' ');
        setName(s.substring(0, 1).toUpperCase() + s.substring(1));
        setWeaponDamageType(Constants.DAMAGE_TYPE.PIERCING);
        setMasterySkill(Constants.MASTERY_SKILL.VEX);
        setDamageDice(4);
        setDamageDiceQuantity(1);
        setSimple(true);
        setRanged(true);
        setReach(5);
        setRange(60);
        setFinesse(true);
        setThrown(true);
        setWeight(.25);
        setCost(.05);
    }

}
