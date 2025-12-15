package alan.equipment.armor;

import alan.Constants.ARMOR_KEY;
import alan.Constants.ARMOR_PROFICIENCY;
import alan.equipment.ArmorAbstract;

public class ChainMail extends ArmorAbstract{

    public ChainMail() {
        setArmorKey(ARMOR_KEY.CHAIN_MAIL);
        String s = getArmorKey().name().toLowerCase().replace('_', ' ');
        setName(s.substring(0, 1).toUpperCase() + s.substring(1));
        setArmorProficiency(ARMOR_PROFICIENCY.HEAVY);
        setWeight(55);
        setCost(75);
    }
}
