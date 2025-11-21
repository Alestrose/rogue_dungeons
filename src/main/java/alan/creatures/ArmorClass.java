package alan.creatures;

import java.util.HashMap;
import java.util.Map;

import alan.Constants;
import alan.skills.Ability;

public class ArmorClass {
    private int armorClass;
    private int baseAC = 10;
    private int armourAC = 0;
    private int shiledBonus = 0;
    private int defenseFeatBonus = 1;
    private int bonusToAc = 0;
    private int tempBonusToAc = 0;

    private Constants.ARMOR_KEY armorType;;

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

    public ArmorClass(Map<Constants.ABILITY, Ability> abilities){
        this.abilities = abilities;
        this.constitutionModifier = this.abilities.get(Constants.ABILITY.CONSTITUTION).getAbilityMod();
        this.dexterityModifier = this.abilities.get(Constants.ABILITY.DEXTERITY).getAbilityMod();
        this.wisdomModifier = this.abilities.get(Constants.ABILITY.WISDOM).getAbilityMod();
    }

    public int getArmorClass() {
        return armorClass;
    }

    public void setArmorClass() {
        if(hasUnarmoredDefenseBarbarianFeat){
            if(!isWearingArmor) {
                this.armorClass =  baseAC + dexterityModifier + constitutionModifier + bonusToAc + tempBonusToAc + shiledBonus;
            }else this.armorClass =  baseAC + dexterityModifier + bonusToAc + tempBonusToAc + shiledBonus;
        }

        if(hasUnarmoredDefenseMonkFeat){
            if(!isWearingArmor && ! shieldEquiped) {
                this.armorClass =  baseAC + dexterityModifier + wisdomModifier + bonusToAc + tempBonusToAc;
            }else this.armorClass =  baseAC + dexterityModifier + bonusToAc + tempBonusToAc;
        }
        
        if(isWearingArmor) {
            switch (armorType) {
                case PADDED: {this.armorClass =  11 + dexterityModifier + bonusToAc + tempBonusToAc + shiledBonus; setStealthDisadvantage(true);}
                case LEATHER: {this.armorClass =  11 + dexterityModifier + bonusToAc + tempBonusToAc + shiledBonus; setStealthDisadvantage(false);}
                case STUDDED: {this.armorClass =  12 + dexterityModifier + bonusToAc + tempBonusToAc + shiledBonus; setStealthDisadvantage(false);}
                case HIDE: {this.armorClass =  12 + returnRestrictedDexterity() + bonusToAc + tempBonusToAc; setStealthDisadvantage(false);}    
                case CHAIN_SHIRT: {this.armorClass =  13 + returnRestrictedDexterity() + bonusToAc + tempBonusToAc + shiledBonus; setStealthDisadvantage(false);}
                case SCALE_MAIL: {this.armorClass =  14 + returnRestrictedDexterity() + bonusToAc + tempBonusToAc + shiledBonus; setStealthDisadvantage(true);}
                case BREASTPLATE: {this.armorClass =  14 + returnRestrictedDexterity() + bonusToAc + tempBonusToAc + shiledBonus; setStealthDisadvantage(false);}
                case HALF_PLATE: {this.armorClass =  15 + returnRestrictedDexterity() + bonusToAc + tempBonusToAc + shiledBonus; setStealthDisadvantage(true);}
                case RING_MAIL: {this.armorClass =  14 + bonusToAc + tempBonusToAc + shiledBonus; setStealthDisadvantage(true);}
                case CHAIN_MAIL: {this.armorClass =  16 + bonusToAc + tempBonusToAc + shiledBonus; setStealthDisadvantage(true);}
                case SPLINT: {this.armorClass =  17 + bonusToAc + tempBonusToAc + shiledBonus; setStealthDisadvantage(true);}
                case PLATE: {this.armorClass =  18 + bonusToAc + tempBonusToAc + shiledBonus; setStealthDisadvantage(true);}
            }
        } else this.armorClass =  baseAC + dexterityModifier + bonusToAc + tempBonusToAc + shiledBonus;

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

    public int getShiledBonus() {
        return shiledBonus;
    }

    public void setShiledBonus(int shiledBonus) {
        this.shiledBonus = shiledBonus;
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
    }

    public boolean isHasUnarmoredDefenseBarbarianFeat() {
        return hasUnarmoredDefenseBarbarianFeat;
    }

    public void setHasUnarmoredDefenseBarbarianFeat(boolean hasUnarmoredDefenseBarbarianFeat) {
        this.hasUnarmoredDefenseBarbarianFeat = hasUnarmoredDefenseBarbarianFeat;
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

    public void setArmorClass(int armorClass) {
        this.armorClass = armorClass;
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
