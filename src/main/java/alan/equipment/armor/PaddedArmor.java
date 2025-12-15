package alan.equipment.armor;

import alan.Constants.ARMOR_KEY;
import alan.Constants.ARMOR_PROFICIENCY;
import alan.equipment.ArmorAbstract;

public class PaddedArmor extends ArmorAbstract{

    public PaddedArmor() {
        setArmorKey(ARMOR_KEY.PADDED);
        String s = getArmorKey().name().toLowerCase().replace('_', ' ');
        setName(s.substring(0, 1).toUpperCase() + s.substring(1));
        setArmorProficiency(ARMOR_PROFICIENCY.LIGHT);
        setWeight(8);
        setCost(5);
    }
}
