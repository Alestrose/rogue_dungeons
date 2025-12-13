package alan.creatures;

import java.util.HashMap;
import java.util.Map;

import alan.Constants;
import alan.skills.Ability;

public class ArmorClass {
    private int ac;
    private int baseAC = 10;
    private int armourAC = 0;
    private int shieldBonus = 0;
    private int defenseFeatBonus = 0;
    private int bonusToAc = 0;
    private int tempBonusToAc = 0;

    private Constants.ARMOR_KEY armorType;

    private int constitutionModifier;
    private int dexterityModifier;
    private int wisdomModifier;

    private boolean isWearingArmor = false;
    private boolean shieldEquiped = false;
    private boolean hasDefenseFeat = false;
    private boolean hasUnarmoredDefenseBarbarianFeat = false;
    private boolean hasUnarmoredDefenseMonkFeat = false;
    private boolean stealthDisadvantage = false;

    protected Map<Constants.ABILITY, Ability> abilities = new HashMap<>();

    // Ac is set in PlayableCharacter constructor and should be set again when equiping/unequiping armor and shields

    public ArmorClass(Map<Constants.ABILITY, Ability> abilities){
        this.abilities = abilities;
        this.constitutionModifier = this.abilities.get(Constants.ABILITY.CONSTITUTION).getAbilityMod();
        this.dexterityModifier = this.abilities.get(Constants.ABILITY.DEXTERITY).getAbilityMod();
        this.wisdomModifier = this.abilities.get(Constants.ABILITY.WISDOM).getAbilityMod();
    }

    public int getAC() {
        return ac;
    }

    public void setAC() {

        // Update ability modifiers
        this.constitutionModifier = abilities.get(Constants.ABILITY.CONSTITUTION).getAbilityMod();
        this.dexterityModifier    = abilities.get(Constants.ABILITY.DEXTERITY).getAbilityMod();
        this.wisdomModifier       = abilities.get(Constants.ABILITY.WISDOM).getAbilityMod();

        // 1. Wearing Armor
        if (isWearingArmor) {
            switch (armorType) {
                case PADDED -> {
                    ac = 11 + dexterityModifier; stealthDisadvantage = true;
                }
                case LEATHER -> ac = 11 + dexterityModifier;
                case STUDDED -> ac = 12 + dexterityModifier;

                case HIDE -> ac = 12 + returnRestrictedDexterity();
                case CHAIN_SHIRT -> ac = 13 + returnRestrictedDexterity();
                case SCALE_MAIL -> {
                    ac = 14 + returnRestrictedDexterity(); stealthDisadvantage = true;
                }
                case BREASTPLATE -> ac = 14 + returnRestrictedDexterity();
                case HALF_PLATE -> {
                    ac = 15 + returnRestrictedDexterity(); stealthDisadvantage = true;
                }

                case RING_MAIL -> {
                    ac = 14; stealthDisadvantage = true;
                }
                case CHAIN_MAIL -> {
                    ac = 16; stealthDisadvantage = true;
                }
                case SPLINT -> {
                    ac = 17; stealthDisadvantage = true;
                }
                case PLATE -> {
                    ac = 18; stealthDisadvantage = true;
                }
            }

            ac += bonusToAc + tempBonusToAc + shieldBonus;
            if (hasDefenseFeat) ac += defenseFeatBonus;

            return;  // STOP — armor AC overrides everything else
        }

        // 2. Barbarian Unarmored Defense (no armor)
        if (hasUnarmoredDefenseBarbarianFeat) {
            ac = baseAC + dexterityModifier + constitutionModifier + shieldBonus + bonusToAc + tempBonusToAc;
            if (hasDefenseFeat) ac += defenseFeatBonus;
            return;
        }

        // 3. Monk Unarmored Defense (no armor, no shield)
        if (hasUnarmoredDefenseMonkFeat && !shieldEquiped) {
            ac = baseAC + dexterityModifier + wisdomModifier + bonusToAc + tempBonusToAc;
            return;
        }

        // 4. Default Unarmored AC
        ac = baseAC + dexterityModifier + shieldBonus + bonusToAc + tempBonusToAc;

    }


    public int returnRestrictedDexterity(){
        if(dexterityModifier >= 2) return 2;
        else return dexterityModifier;
    }

    /*
        Getters and Settters
     */

    public int getBaseAC() {
        return baseAC;
    }

    public void setBaseAC(int baseAC) {
        this.baseAC = baseAC;
    }

    public int getArmourAC() {
        return armourAC;
    }

    public void setArmourAC(int armourAC) {
        this.armourAC = armourAC;
    }

    public int getShieldBonus() {
        return shieldBonus;
    }

    public void setShieldBonus(int shieldBonus) {
        this.shieldBonus = shieldBonus;
    }

    public int getDefenseFeatBonus() {
        return defenseFeatBonus;
    }

    public void setDefenseFeatBonus(int defenseFeatBonus) {
        this.defenseFeatBonus = defenseFeatBonus;
    }

    public boolean isWearingArmor() {
        return isWearingArmor;
    }

    public void setWearingArmor(boolean isWearingArmor) {
        this.isWearingArmor = isWearingArmor;
        if(hasDefenseFeat && isWearingArmor) this.defenseFeatBonus = 1;
        else this.defenseFeatBonus = 0;
    }

    public boolean isShieldEquiped() {
        return shieldEquiped;
    }

    public void setShieldEquiped(boolean shieldEquiped) {
        this.shieldEquiped = shieldEquiped;
    }

    public boolean isHasDefenseFeat() {
        return hasDefenseFeat;
    }

    public void setHasDefenseFeat(boolean hasDefenseFeat) {
        this.hasDefenseFeat = hasDefenseFeat;
        if(hasDefenseFeat && isWearingArmor) this.defenseFeatBonus = 1;
        else this.defenseFeatBonus = 0;
    }

    public boolean isHasUnarmoredDefenseBarbarianFeat() {
        return hasUnarmoredDefenseBarbarianFeat;
    }

    public void setHasUnarmoredDefenseBarbarianFeat(boolean hasUnarmoredDefenseBarbarianFeat) {
        this.hasUnarmoredDefenseBarbarianFeat = hasUnarmoredDefenseBarbarianFeat;
        setAC();
    }

    public Map<Constants.ABILITY, Ability> getAbilities() {
        return abilities;
    }

    public void setAbilities(Map<Constants.ABILITY, Ability> abilities) {
        this.abilities = abilities;
    }

    public int getConstitutionModifier() {
        return constitutionModifier;
    }

    public void setConstitutionModifier(int constitutionModifier) {
        this.constitutionModifier = constitutionModifier;
    }

    public int getDexterityModifier() {
        return dexterityModifier;
    }

    public void setDexterityModifier(int dexterityModifier) {
        this.dexterityModifier = dexterityModifier;
    }

    public int getWisdomModifier() {
        return wisdomModifier;
    }

    public void setWisdomModifier(int wisdomModifier) {
        this.wisdomModifier = wisdomModifier;
    }

    public int getBonusToAc() {
        return bonusToAc;
    }

    public void setBonusToAc(int bonusToAc) {
        this.bonusToAc = bonusToAc;
    }

    public int getTempBonusToAc() {
        return tempBonusToAc;
    }

    public void setTempBonusToAc(int tempBonusToAc) {
        this.tempBonusToAc = tempBonusToAc;
    }
    
    public boolean isHasUnarmoredDefenseMonkFeat() {
        return hasUnarmoredDefenseMonkFeat;
    }

    public void setHasUnarmoredDefenseMonkFeat(boolean hasUnarmoredDefenseMonkFeat) {
        this.hasUnarmoredDefenseMonkFeat = hasUnarmoredDefenseMonkFeat;
        setAC();
    }

    public Constants.ARMOR_KEY getArmorType() {
        return armorType;
    }

    public void setArmorType(Constants.ARMOR_KEY armorType) {
        this.armorType = armorType;
    }

    public boolean isStealthDisadvantage() {
        return stealthDisadvantage;
    }

    public void setStealthDisadvantage(boolean stealthDisadvantage) {
        this.stealthDisadvantage = stealthDisadvantage;
    }

    
    

    
    
}
