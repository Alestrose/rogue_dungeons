package alan.equipment.weapons;

import alan.Constants;
import alan.creatures.Creature;
import alan.equipment.WeaponAbstract;

public class Warhammer extends WeaponAbstract{

    public Warhammer(Creature wielder){
        super(wielder);
        setWeaponKey(Constants.WEAPON_KEY.WARHAMMER);
        String s = getWeaponKey().name().toLowerCase().replace('_', ' ');
        setName(s.substring(0, 1).toUpperCase() + s.substring(1));
        setWeaponDamageType(Constants.DAMAGE_TYPE.BLUDGEONING);
        setMasterySkill(Constants.MASTERY_SKILL.PUSH);
        setDamageDie(8);
        setDamageDieTwoHanded(10);
        setDamageDieQuantity(1);
        setRange(0);
        setMartial(true);
        setMelee(true);
        setVersitile(true);
        setWeight(4);
        setCost(5);
    }

}
