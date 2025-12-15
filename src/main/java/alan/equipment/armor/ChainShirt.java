package alan.equipment.armor;

import alan.Constants.ARMOR_KEY;
import alan.Constants.ARMOR_PROFICIENCY;
import alan.equipment.ArmorAbstract;

public class ChainShirt extends ArmorAbstract{

    public ChainShirt() {
        setArmorKey(ARMOR_KEY.CHAIN_SHIRT);
        String s = getArmorKey().name().toLowerCase().replace('_', ' ');
        setName(s.substring(0, 1).toUpperCase() + s.substring(1));
        setArmorProficiency(ARMOR_PROFICIENCY.MEDIUM);
        setWeight(20);
        setCost(50);
    }
}
