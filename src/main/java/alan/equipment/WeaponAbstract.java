package alan.equipment;

import alan.Constants;
import alan.Constants.ABILITY;
import alan.creatures.Creature;
import alan.interfaces.DiceRoll;

public abstract class WeaponAbstract extends Item implements DiceRoll{

    private Creature wielder;
    private Constants.WEAPON_KEY weaponKey;
    private Constants.DAMAGE_TYPE weaponDamageType;
    private Constants.MASTERY_SKILL masterySkill;
    private int damageDie;
    private int damageDieTwoHanded = 0;
    private int damageDieQuantity;
    private int damageBonus = 0;
    private int reach;
    private int range;
    private double  weight;
    

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
    
    public WeaponAbstract(Creature wielder){
        this.wielder = wielder;
        setItemType(Constants.ITEM_TYPE.WEAPON);
    }

    @Override
    public int rollWeaponDamage() {
        int die = isTwoHanded ? damageDieTwoHanded : damageDie;

        int total = rollDice(die, damageDieQuantity);

        return total
                + damageBonus
                + getDamageAbilityModifier();
    }


    private int getDamageAbilityModifier() {
        if (isPactWeapon) {
            return wielder.getAbilities()
                    .get(Constants.ABILITY.CHARISMA)
                    .getAbilityMod();
        }

        int str = wielder.getAbilities()
                .get(Constants.ABILITY.STRENGTH)
                .getAbilityMod();

        int dex = wielder.getAbilities()
                .get(Constants.ABILITY.DEXTERITY)
                .getAbilityMod();

        if (isFinesse && dex > str) {
            return dex;
        }

        return str;
    }

    private int rollDice(int die, int count) {
        int total = 0;
        for (int i = 0; i < count; i++) {
            total += random.nextInt(die) + 1;
        }
        return total;
    }


    @Override
    public int rollDamage(int damageDie, int quantityOfDie) {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public void rollSpellSaveCheck(Creature target, Creature caster, ABILITY ability, Runnable onSuccess,
            Runnable onFail) {
        // TODO Auto-generated method stub
        
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

    @Override       // run affect if target spell attack bonus plus a random d20 is greater than or equal to targets AC
    public void rollToHitAcMeleeSpellAttack(Creature target, Creature caster, Constants.ABILITY ability, Runnable onFail) {
        boolean success = 
        random.nextInt(20)+1 + caster.getSpellAttackBonus()                     // D20 plus spell attack bonus
        >= target.getArmorClass().getAC();                                      // Against target armor class

        if (!success) onFail.run();
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

    public int getDamageDie() {
        return damageDie;
    }

    public void setDamageDie(int damageDice) {
        this.damageDie = damageDice;
    }

    public int getDamageDieQuantity() {
        return damageDieQuantity;
    }

    public void setDamageDieQuantity(int damageDiceQuantity) {
        this.damageDieQuantity = damageDiceQuantity;
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

    public int getDamageDieTwoHanded() {
        return damageDieTwoHanded;
    }

    public void setDamageDieTwoHanded(int damageDiceTwoHanded) {
        this.damageDieTwoHanded = damageDiceTwoHanded;
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
