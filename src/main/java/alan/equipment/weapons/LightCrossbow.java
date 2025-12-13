package alan.equipment.weapons;

import alan.Constants;
import alan.creatures.Creature;
import alan.equipment.Weapon;

public class LightCrossbow extends Weapon{

    public LightCrossbow(Creature wielder){
        super(wielder);
        setWeaponKey(Constants.WEAPON_KEY.LIGHT_CROSSBOW);
        String s = getWeaponKey().name().toLowerCase().replace('_', ' ');
        setName(s.substring(0, 1).toUpperCase() + s.substring(1));
        setWeaponDamageType(Constants.DAMAGE_TYPE.PIERCING);
        setMasterySkill(Constants.MASTERY_SKILL.SLOW);
        setDamageDice(8);
        setDamageDiceTwoHanded(8);
        setDamageDiceQuantity(1);
        setSimple(true);
        setRanged(true);
        setReach(5);
        setRange(320);
        setTwoHanded(true);
        setWeight(5);
        setCost(25);
    }
}
