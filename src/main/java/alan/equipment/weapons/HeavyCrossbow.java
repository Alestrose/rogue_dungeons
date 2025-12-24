package alan.equipment.weapons;

import alan.Constants;
import alan.creatures.Creature;
import alan.equipment.WeaponAbstract;

public class HeavyCrossbow extends WeaponAbstract{

    public HeavyCrossbow(Creature wielder){
        super(wielder);
        setWeaponKey(Constants.WEAPON_KEY.HEAVY_CROSSBOW);
        String s = getWeaponKey().name().toLowerCase().replace('_', ' ');
        setName(s.substring(0, 1).toUpperCase() + s.substring(1));
        setWeaponDamageType(Constants.DAMAGE_TYPE.PIERCING);
        setMasterySkill(Constants.MASTERY_SKILL.PUSH);
        setDamageDie(10);
        setDamageDieTwoHanded(10);
        setDamageDieQuantity(1);
        setTwoHanded(true);
        setRange(400);
        setMartial(true);
        setRanged(true);
        setHeavy(true);
        setWeight(18);
        setCost(50);
    }

}
