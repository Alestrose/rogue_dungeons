package alan.equipment.weapons;

import alan.Constants;
import alan.creatures.Creature;
import alan.equipment.WeaponAbstract;

public class Greatclub extends WeaponAbstract{

    public Greatclub(Creature wielder){
        super(wielder);
        setWeaponKey(Constants.WEAPON_KEY.GREATAXE);
        String s = getWeaponKey().name().toLowerCase().replace('_', ' ');
        setName(s.substring(0, 1).toUpperCase() + s.substring(1));
        setWeaponDamageType(Constants.DAMAGE_TYPE.BLUDGEONING);
        setMasterySkill(Constants.MASTERY_SKILL.PUSH);
        setDamageDie(8);
        setDamageDieTwoHanded(8);
        setDamageDieQuantity(1);
        setSimple(true);
        setMelee(true);
        setReach(5);
        setRange(0);
        setTwoHanded(true);
        setWeight(10);
        setCost(.2);

    }
}
