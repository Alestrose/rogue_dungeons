package alan.equipment.armor;

import alan.Constants.ARMOR_KEY;
import alan.Constants.ARMOR_PROFICIENCY;
import alan.equipment.ArmorAbstract;

public class HalfPlateArmor extends ArmorAbstract{

    public HalfPlateArmor() {
        setArmorKey(ARMOR_KEY.HALF_PLATE);
        String s = getArmorKey().name().toLowerCase().replace('_', ' ');
        setName(s.substring(0, 1).toUpperCase() + s.substring(1));
        setArmorProficiency(ARMOR_PROFICIENCY.MEDIUM);
        setWeight(40);
        setCost(750);
    }
}
