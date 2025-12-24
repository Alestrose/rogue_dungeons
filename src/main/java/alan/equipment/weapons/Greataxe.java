package alan.equipment.weapons;

import alan.Constants;
import alan.creatures.Creature;
import alan.equipment.WeaponAbstract;

public class Greataxe extends WeaponAbstract{

    public Greataxe(Creature wielder){
        super(wielder);
        setWeaponKey(Constants.WEAPON_KEY.GREATAXE);
        String s = getWeaponKey().name().toLowerCase().replace('_', ' ');
        setName(s.substring(0, 1).toUpperCase() + s.substring(1));
        setWeaponDamageType(Constants.DAMAGE_TYPE.SLASHING);
        setMasterySkill(Constants.MASTERY_SKILL.CLEAVE);
        setDamageDie(12);
        setDamageDieTwoHanded(12);
        setDamageDieQuantity(1);
        setRange(0);
        setMartial(true);
        setMelee(true);
        setTwoHanded(true);
        setHeavy(true);
        setWeight(7);
        setCost(30);
    }

}
