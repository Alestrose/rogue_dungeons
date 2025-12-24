package alan.equipment.weapons;

import alan.Constants;
import alan.creatures.Creature;
import alan.equipment.WeaponAbstract;

public class Handaxe extends WeaponAbstract{

    public Handaxe(Creature wielder){
        super(wielder);
        setWeaponKey(Constants.WEAPON_KEY.HANDAXE);
        String s = getWeaponKey().name().toLowerCase().replace('_', ' ');
        setName(s.substring(0, 1).toUpperCase() + s.substring(1));
        setWeaponDamageType(Constants.DAMAGE_TYPE.SLASHING);
        setMasterySkill(Constants.MASTERY_SKILL.VEX);
        setDamageDie(6);
        setDamageDieQuantity(1);
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
