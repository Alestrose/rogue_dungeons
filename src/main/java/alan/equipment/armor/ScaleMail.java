package alan.equipment.armor;

import alan.Constants.ARMOR_KEY;
import alan.Constants.ARMOR_PROFICIENCY;
import alan.equipment.ArmorAbstract;

public class ScaleMail extends ArmorAbstract{

    public ScaleMail() {
        setArmorKey(ARMOR_KEY.SCALE_MAIL);
        String s = getArmorKey().name().toLowerCase().replace('_', ' ');
        setName(s.substring(0, 1).toUpperCase() + s.substring(1));
        setArmorProficiency(ARMOR_PROFICIENCY.MEDIUM);
        setWeight(45);
        setCost(50);
    }
}
