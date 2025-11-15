package alan.equipment.weapons;

import alan.Constants;
import alan.creatures.Creature;
import alan.equipment.Weapon;

public class Mace extends Weapon{

    public Mace(Creature wielder){
        super(wielder);
        setWeaponKey(Constants.WEAPON_KEY.MACE);
        String s = getWeaponKey().name().toLowerCase().replace('_', ' ');
        setWeaponName(s.substring(0, 1).toUpperCase() + s.substring(1));
        setWeaponDamageType(Constants.DAMAGE_TYPE.BLUDGEONING);
        setMasterySkill(Constants.MASTERY_SKILL.SAP);
        setDamageDice(6);
        setDamageDiceQuantity(1);
        setSimple(true);
        setMelee(true);
        setReach(5);
        setRange(0);
        setWeight(4);
        setCost(5);
    }
}
