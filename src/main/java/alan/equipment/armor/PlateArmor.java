package alan.equipment.armor;

import alan.Constants.ARMOR_KEY;
import alan.Constants.ARMOR_PROFICIENCY;
import alan.equipment.ArmorAbstract;

public class PlateArmor extends ArmorAbstract{

    public PlateArmor() {
        setArmorKey(ARMOR_KEY.PLATE);
        String s = getArmorKey().name().toLowerCase().replace('_', ' ');
        setName(s.substring(0, 1).toUpperCase() + s.substring(1));
        setArmorProficiency(ARMOR_PROFICIENCY.HEAVY);
        setWeight(65);
        setCost(1500);
    }
}
