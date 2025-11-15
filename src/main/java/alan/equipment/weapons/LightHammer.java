package alan.equipment.weapons;

import alan.Constants;
import alan.creatures.Creature;
import alan.equipment.Weapon;

public class LightHammer extends Weapon{

    public LightHammer(Creature wielder){
        super(wielder);
        setWeaponKey(Constants.WEAPON_KEY.LIGHT_HAMMER);
        String s = getWeaponKey().name().toLowerCase().replace('_', ' ');
        setWeaponName(s.substring(0, 1).toUpperCase() + s.substring(1));
        setWeaponDamageType(Constants.DAMAGE_TYPE.BLUDGEONING);
        setMasterySkill(Constants.MASTERY_SKILL.NICK);
        setDamageDice(4);
        setDamageDiceQuantity(1);
        setReach(5);
        setRange(60);
        setLight(true);
        setThrown(true);
        setWeight(2);
        setCost(2);
    }
}
