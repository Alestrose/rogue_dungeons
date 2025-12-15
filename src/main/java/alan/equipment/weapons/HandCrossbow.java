package alan.equipment.weapons;

import alan.Constants;
import alan.creatures.Creature;
import alan.equipment.WeaponAbstract;

public class HandCrossbow extends WeaponAbstract{

    public HandCrossbow(Creature wielder){
        super(wielder);
        setWeaponKey(Constants.WEAPON_KEY.HAND_CROSSBOW);
        String s = getWeaponKey().name().toLowerCase().replace('_', ' ');
        setName(s.substring(0, 1).toUpperCase() + s.substring(1));
        setWeaponDamageType(Constants.DAMAGE_TYPE.PIERCING);
        setMasterySkill(Constants.MASTERY_SKILL.VEX);
        setDamageDice(6);
        setDamageDiceQuantity(1);
        setRange(120);
        setMartial(true);
        setRanged(true);
        setLight(true);
        setWeight(1);
        setCost(10);
    }

}
