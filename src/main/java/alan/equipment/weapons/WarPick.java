package alan.equipment.weapons;

import alan.Constants;
import alan.creatures.Creature;
import alan.equipment.Weapon;

public class WarPick extends Weapon{

    public WarPick(Creature wielder){
        super(wielder);
        setWeaponKey(Constants.WEAPON_KEY.WARP_PICK);
        String s = getWeaponKey().name().toLowerCase().replace('_', ' ');
        setName(s.substring(0, 1).toUpperCase() + s.substring(1));
        setWeaponDamageType(Constants.DAMAGE_TYPE.PIERCING);
        setMasterySkill(Constants.MASTERY_SKILL.SAP);
        setDamageDice(8);
        setDamageDiceTwoHanded(10);
        setDamageDiceQuantity(1);
        setRange(0);
        setMartial(true);
        setMelee(true);
        setVersitile(true);
        setWeight(2);
        setCost(5);
    }

}
