package alan.equipment;

import alan.Constants;
import alan.Constants.ABILITY;
import alan.creatures.Creature;
import alan.interfaces.DiceRoll;

public abstract class Weapon extends Item implements DiceRoll{

    private Creature wielder;
    private Constants.WEAPON_KEY weaponKey;
    private Constants.DAMAGE_TYPE weaponDamageType;
    private Constants.MASTERY_SKILL masterySkill;
    private String weaponName;
    private int damageDice;
    private int damageDiceTwoHanded = 0;
    private int damageDiceQuantity;
    private int damageBonus = 0;
    private int reach;
    private int range;
    private double  weight;
    private double cost;

    // properties
    private boolean isLight = false;
    private boolean isFinesse = false;
    private boolean isThrown = false;
    private boolean isTwoHanded = false;
    private boolean isVersitile = false;
    private boolean isHeavy = false;
    private boolean isReach = false;
    private boolean isSimple = false;
    private boolean isMartial = false;
    private boolean isMelee = false;
    private boolean isRanged = false;
    private boolean isPactWeapon = false;

    /*
     *  setWeaponKey(Constants.WEAPON_KEY.CLUB);
        String s = getWeaponKey().name().toLowerCase().replace('_', ' ');
        setWeaponName(s.substring(0, 1).toUpperCase() + s.substring(1));
        setWeaponDamageType(Constants.DAMAGE_TYPE.BLUDGEONING);
        setMasterySkill(Constants.MASTERY_SKILL.SLOW);
        setDamageDice(4);
        setDamageDiceQuantity(1);
        setReach(5);
        setRange(60);
        setLight(true);
        setWeight(10);
        setCost(.2);
     */
    
    public Weapon(Creature wielder){
        this.wielder = wielder;
        setItemType(Constants.ITEM_TYPE.WEAPON);
    }

    @Override
    public int rollDamage(int damageDie, int quantityOfDie) {
        int total = 0;
        int modifier = wielder.getAbilities().get(Constants.ABILITY.STRENGTH).getAbilityMod();

        // If finesse weapon and dex > str, set modifier to dex modifier
        if (isPactWeapon) {
            modifier = wielder.getAbilities().get(Constants.ABILITY.CHARISMA).getAbilityMod();
        }
        else if(isFinesse && 
        wielder.getAbilities().get(Constants.ABILITY.DEXTERITY).getAbilityMod() 
        > wielder.getAbilities().get(Constants.ABILITY.STRENGTH).getAbilityMod()){
            modifier = wielder.getAbilities().get(Constants.ABILITY.DEXTERITY).getAbilityMod();
        }

        if(isTwoHanded){
            for (int i = 0; i < quantityOfDie; i++) {
                total += random.nextInt(damageDiceTwoHanded) + 1;
            }
            return total + damageBonus + modifier;
        }else{
            for (int i = 0; i < quantityOfDie; i++) {
                total += random.nextInt(damageDie) + 1;
            }
            return total + damageBonus + modifier;
        }

    }


    @Override
    public boolean rollSpellSaveCheck(Creature target, Creature caster, ABILITY ability) {
        // TODO Auto-generated method stub
        return false;
    }


    @Override
    public boolean rollToHitACRanged(Creature target, Creature caster) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean rollToHitACMellee(Creature target, Creature caster) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean rollToHitACSpellAttack(Creature target, Creature caster) {
        // TODO Auto-generated method stub
        return false;
    }

    /*
     * Getters and Setters
     */

    public Constants.WEAPON_KEY getWeaponKey() {
        return weaponKey;
    }

    public void setWeaponKey(Constants.WEAPON_KEY weaponKey) {
        this.weaponKey = weaponKey;
    }

    public Constants.DAMAGE_TYPE getWeaponDamageType() {
        return weaponDamageType;
    }

    public void setWeaponDamageType(Constants.DAMAGE_TYPE weaponDamageType) {
        this.weaponDamageType = weaponDamageType;
    }

    public Constants.MASTERY_SKILL getMasterySkill() {
        return masterySkill;
    }

    public void setMasterySkill(Constants.MASTERY_SKILL masterySkill) {
        this.masterySkill = masterySkill;
    }

    public String getWeaponName() {
        return weaponName;
    }

    public void setWeaponName(String weaponName) {
        this.weaponName = weaponName;
    }

    public int getDamageDice() {
        return damageDice;
    }

    public void setDamageDice(int damageDice) {
        this.damageDice = damageDice;
    }

    public int getDamageDiceQuantity() {
        return damageDiceQuantity;
    }

    public void setDamageDiceQuantity(int damageDiceQuantity) {
        this.damageDiceQuantity = damageDiceQuantity;
    }

    public int getDamageBonus() {
        return damageBonus;
    }

    public void setDamageBonus(int damageBonus) {
        this.damageBonus = damageBonus;
    }

    public int getReach() {
        return reach;
    }

    public void setReach(int reach) {
        this.reach = reach;
    }

    public int getRange() {
        return range;
    }

    public void setRange(int range) {
        this.range = range;
    }

    public boolean isLight() {
        return isLight;
    }

    public void setLight(boolean isLight) {
        this.isLight = isLight;
    }

    public boolean isFinesse() {
        return isFinesse;
    }

    public void setFinesse(boolean isFinesse) {
        this.isFinesse = isFinesse;
    }

    public boolean isThrown() {
        return isThrown;
    }

    public void setThrown(boolean isThrown) {
        this.isThrown = isThrown;
    }

    public boolean isTwoHanded() {
        return isTwoHanded;
    }

    public void setTwoHanded(boolean isTwoHanded) {
        this.isTwoHanded = isTwoHanded;
    }

    public boolean isVersitile() {
        return isVersitile;
    }

    public void setVersitile(boolean isVersitile) {
        this.isVersitile = isVersitile;
    }

    public boolean isHeavy() {
        return isHeavy;
    }

    public void setHeavy(boolean isHeavy) {
        this.isHeavy = isHeavy;
    }

    public boolean isReach() {
        return isReach;
    }

    public void setIsReach(boolean isReach) {
        this.isReach = isReach;
    }

    public int getDamageDiceTwoHanded() {
        return damageDiceTwoHanded;
    }

    public void setDamageDiceTwoHanded(int damageDiceTwoHanded) {
        this.damageDiceTwoHanded = damageDiceTwoHanded;
    }

    public Creature getWielder() {
        return wielder;
    }

    public void setWielder(Creature wielder) {
        this.wielder = wielder;
    }

    public double  getWeight() {
        return weight;
    }

    public void setWeight(double  weight) {
        this.weight = weight;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public boolean isSimple() {
        return isSimple;
    }

    public void setSimple(boolean isSimple) {
        this.isSimple = isSimple;
    }

    public boolean isMartial() {
        return isMartial;
    }

    public void setMartial(boolean isMartial) {
        this.isMartial = isMartial;
    }

    public boolean isMelee() {
        return isMelee;
    }

    public void setMelee(boolean isMelee) {
        this.isMelee = isMelee;
    }

    public boolean isRanged() {
        return isRanged;
    }

    public void setRanged(boolean isRanged) {
        this.isRanged = isRanged;
    }

    public void setReach(boolean isReach) {
        this.isReach = isReach;
    }

    public boolean isPactWeapon() {
        return isPactWeapon;
    }

    public void setPactWeapon(boolean isPactWeapon) {
        this.isPactWeapon = isPactWeapon;
    }

    

    
}
