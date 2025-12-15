package alan.equipment.armor;

import alan.Constants.ARMOR_KEY;
import alan.Constants.ARMOR_PROFICIENCY;
import alan.equipment.ArmorAbstract;

public class ShieldArmor extends ArmorAbstract{

    private int acBonus = 2;

    public ShieldArmor() {
        setArmorKey(ARMOR_KEY.SHIELD_ARMOR);
        String s = getArmorKey().name().toLowerCase().replace('_', ' ');
        setName(s.substring(0, 1).toUpperCase() + s.substring(1));
        setArmorProficiency(ARMOR_PROFICIENCY.SHIELDS);
        setWeight(6);
        setCost(10);
    }

    public int getAcBonus() {
        return acBonus;
    }

    public void setAcBonus(int acBonus) {
        this.acBonus = acBonus;
    }

    
}
