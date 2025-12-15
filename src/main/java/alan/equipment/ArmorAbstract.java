package alan.equipment;

import alan.Constants.ARMOR_KEY;
import alan.Constants.ARMOR_PROFICIENCY;
import alan.creatures.Creature;

public abstract class ArmorAbstract extends Item{
    private Creature wielder;
    private ARMOR_PROFICIENCY armorProficiency;
    private ARMOR_KEY ArmorKey;
    private int additionalBonus;

    private double  weight;

    public ArmorAbstract() {
        
    }

    public Creature getWielder() {
        return wielder;
    }

    public void setWielder(Creature wielder) {
        this.wielder = wielder;
    }

    public ARMOR_PROFICIENCY getArmorProficiency() {
        return armorProficiency;
    }

    public void setArmorProficiency(ARMOR_PROFICIENCY armorProficiency) {
        this.armorProficiency = armorProficiency;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public ARMOR_KEY getArmorKey() {
        return ArmorKey;
    }

    public void setArmorKey(ARMOR_KEY armorKey) {
        ArmorKey = armorKey;
    }

    public int getAdditionalBonus() {
        return additionalBonus;
    }

    public void setAdditionalBonus(int additionalBonus) {
        this.additionalBonus = additionalBonus;
    }

    
    
}
