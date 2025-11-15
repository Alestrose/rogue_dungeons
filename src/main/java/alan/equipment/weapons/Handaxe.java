package alan.equipment.weapons;

import alan.Constants;
import alan.creatures.Creature;
import alan.equipment.Weapon;

public class Handaxe extends Weapon{

    public Handaxe(Creature wielder){
        super(wielder);
        setWeaponKey(Constants.WEAPON_KEY.HANDAXE);
        String s = getWeaponKey().name().toLowerCase().replace('_', ' ');
        setWeaponName(s.substring(0, 1).toUpperCase() + s.substring(1));
        setWeaponDamageType(Constants.DAMAGE_TYPE.SLASHING);
        setMasterySkill(Constants.MASTERY_SKILL.VEX);
        setDamageDice(6);
        setDamageDiceQuantity(1);
        setSimple(true);
        setMelee(true);
        setReach(5);
        setRange(60);
        setLight(true);
        setThrown(true);
        setWeight(2);
        setCost(5);
    }

}
