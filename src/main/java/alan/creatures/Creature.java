package alan.creatures;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

import alan.Constants;
import alan.Constants.DAMAGE_TYPE;
import alan.player_class.PlayerClass;
import alan.skills.Ability;
import alan.skills.ConditionEffect;
import alan.skills.Skill;
import alan.grid_panel.Cell;

public abstract class Creature {
    private String creatureType, name, raceName;
    private int proficiencyBonus = 2;
    private int
        inspirationDie = 0, TempAcBonus, maxHealth, tempHealth, currentHealth, speed, dc = 10, 
        x,y, width, height, actions = 1, bonusActions = 1, reactions = 1, spellSaveDC, spellSaveDCBonus , spellAttackBonus, 
        jumpDistance, auraDamage, melleeAttackRollBonus = 0, rangedAttackRollBonus = 0,
        attackRollReduction, damageRollReduction, abilityCheckReduction, savingThrowDecrease, 
        attackRollIncrease, damageRollIncrease, nextHitDamageRollIncrease, abilityCheckIncrease, 
        playerSaveIncrease, savingThrowIncrease, darkVision = 0, thrownAttackDamageBonus = 0;

    protected String fileName;
    protected BufferedImage image;
    private Cell location;
    private Constants.CREATURE_SIZE size;
    private Constants.ABILITY spellCastAbility;
    private Map<Constants.LANGUAGE, Boolean> languages = new HashMap<>();

    // Booleans
    private boolean canOpportunityAttack = true;
    private boolean melleeAttackRollDisadvantage, melleeAttackRollAdvantage,
                    rangedAttackRollDisadvantage, rangedAttackRollAdvantage,
                    spellAttackRollAdvantage, spellAttackRollDisadvantage,
                    isWearingArmor = false, hasShieldEquiped = false;
    private boolean hasInspiration = false;

    // Classes
    private PlayerClass primaryClass;
    private ArmorClass armorClass;

    // Ability scores & Modifiers
    protected Map<Constants.ABILITY, Ability> abilities = new HashMap<>();
    protected Map<Constants.SKILL_KEY, Skill> skills = new HashMap<>();
    private ArrayList<Constants.WEAPON_PROFICIENCY> weaponProficiencies = new ArrayList<>();
    private ArrayList<Constants.ARMOR_PROFICIENCY> armorProficiencies = new ArrayList<>();
    
    // Resistances & Vulnerabilities
    protected EnumSet<DAMAGE_TYPE> resistances = EnumSet.noneOf(DAMAGE_TYPE.class);
    protected EnumSet<DAMAGE_TYPE> vulnerabilities = EnumSet.noneOf(DAMAGE_TYPE.class);
    protected EnumSet<DAMAGE_TYPE> immunities = EnumSet.noneOf(DAMAGE_TYPE.class);
    protected Map<Constants.CONDITION_KEY, ConditionEffect> conditionEffects = new HashMap<>();

    // Inventory and Equipments
    private Equipment equipment = new Equipment(this);

    // No Cell location Constructor
    public Creature(String name, String fileName, PlayerClass primaryClass){
        this.name = name;
        this.fileName = fileName;
        setPrimaryClass(primaryClass);

        // Initializes image from images folder. Image selected via fileName
        File pic = new File("images/" + fileName);
        try {
            image = ImageIO.read(pic);
        } catch (IOException e) {
            System.out.println("file not found");
        }

        setDefaultConditionMap();
        setDefaultAbilities();
        setDefaultSkills();
        setDefaultLanguages();
        
        // Done last
        this.armorClass = new ArmorClass(abilities);
        initClass();
        
        
    }

    // Specified Cell location constructor
    public Creature(String name, String fileName, Cell location, PlayerClass primaryClass){
        this.name = name;
        this.fileName = fileName;
        setPrimaryClass(primaryClass);

        // Cell
        this.location = location;
        this.x = location.getX();
        this.y = location.getY();
        this.width = location.getWidth();
        this.height = location.getHeight();
        
        // Initializes image from images folder. Image selected via fileName
        File pic = new File("images/" + fileName);
        try {
            image = ImageIO.read(pic);
        } catch (IOException e) {
            System.out.println("file not found");
        }

        setDefaultConditionMap();
        setDefaultAbilities();
        setDefaultSkills();
        setDefaultLanguages();

        // Done last
        this.armorClass = new ArmorClass(abilities);
        initClass();
    }

    /*
     * Methods
     */

    public final void initClass(){
        primaryClass.initNewCharacter();
        armorClass.setAC();
    }

    public final void initStartingAttributes(){
        
    }

    public void move(){

    }

    public int applyDamage(int baseDamage, Constants.DAMAGE_TYPE type) {

        if (baseDamage <= 0) return 0;

        // 1. Immunity
        if (immunities.contains(type)) return 0;

        int finalDamage = baseDamage;

        // 2. Resistance / Vulnerability
        if (resistances.contains(type)) finalDamage /= 2;
        else if (vulnerabilities.contains(type)) finalDamage *= 2;

        // 3. Temporary HP absorbs damage first
        if (tempHealth > 0) {
            int absorbed = Math.min(tempHealth, finalDamage);
            tempHealth -= absorbed;
            finalDamage -= absorbed;
        }

        // 4. Apply remaining damage to HP
        if (finalDamage > 0) damageHealth(finalDamage);
        
        // 5. Optional: trigger hooks
        onDamageTaken(finalDamage, type);

        return finalDamage;
    }

    private void onDamageTaken(@SuppressWarnings("unused") int finalDamage, @SuppressWarnings("unused") DAMAGE_TYPE type) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    // Reduces health by int val
    public void damageHealth(int val){
        currentHealth -= val;
        if(currentHealth < 0) currentHealth = 0;
    }

    // Increases health by int val
    public void healHealth(int val){
        if (!conditionEffects.containsKey(Constants.CONDITION_KEY.CHILL_TOUCH)) {
            currentHealth += val;
            if(currentHealth > maxHealth) currentHealth = maxHealth;
        }
        
    }

    // For use in "GameManager.drawSprites()"
    public void drawCreature(Graphics2D graphics, JPanel panel){
        graphics.drawImage(getImage(), getX(), getY(), getWidth(), getHeight(), panel);
    }

    /*
     * Setters for granting enum based conditions and effects
     */

    public void grantLanguage(Constants.LANGUAGE language){
        languages.put(language, true);
    }
    
    public void addResistance(DAMAGE_TYPE type) {
        immunities.remove(type);
        vulnerabilities.remove(type);
        resistances.add(type);
    }

    public void addVulnerability(DAMAGE_TYPE type) {
        immunities.remove(type);
        resistances.remove(type);
        vulnerabilities.add(type);
    }

    public void addImmunity(DAMAGE_TYPE type) {
        resistances.remove(type);
        vulnerabilities.remove(type);
        immunities.add(type);
    }

    // sets specified condition isActive bool to true AND sets sorceCaster to the creature that applied this effect
    public void ApplyConditionEffect(Constants.CONDITION_KEY condition_key, Creature sourceCaster){
        ConditionEffect effect = conditionEffects.get(condition_key);
        if (effect != null) {
            effect.setActive(true);
            effect.setSourceCaster(sourceCaster);
        }
    }

    public void RemoveConditionEffect(Constants.CONDITION_KEY condition_key){
        ConditionEffect effect = conditionEffects.get(condition_key);
        if (effect != null) {
            effect.setActive(false);
        }
    }

    public void grantConditionAdvantage(Constants.CONDITION_KEY condition_key){
        ConditionEffect effect = conditionEffects.get(condition_key);
        if (effect != null) {
            effect.setHasAdvantage(true);
        }
    }

    public void grantConditionInvulnerability(Constants.CONDITION_KEY condition_key){
        ConditionEffect effect = conditionEffects.get(condition_key);
        if (effect != null) {
            effect.setInvulnerable(true);
        }
    }

    public void grantSavingThrowBonus(Constants.ABILITY a, Integer val){
        abilities.get(a).setSaveBonus(val);
    }

    public void grantSavingThrowPenalty(Constants.ABILITY a, Integer val){
        abilities.get(a).setSavePenalty(val);
    }

    public void grantAbilitySaveAdvantage(Constants.ABILITY a){
        abilities.get(a).setSaveAdvantage(true);
    }

    public void grantAbilitySaveDisadvantage(Constants.ABILITY a){
        abilities.get(a).setSaveDisadvantage(true);
    }

    public void grantAbilityProficiency(Constants.ABILITY ability_key) {
        Ability ability = abilities.get(ability_key);
        if (ability != null) {
            ability.setHasProficiency(true);
        }
    }

    public void grantSkillProficiency(Constants.SKILL_KEY skill_key) {
        Skill skill = skills.get(skill_key);
        if (skill != null) {
            skill.setHasProficiency(true);
        }
    }

    public void grantSkillExpertise(Constants.SKILL_KEY skill_key) {
        Skill skill = skills.get(skill_key);
        if (skill != null) {
            skill.setHasExpertise(true);
        }
    }

    public void grantSkillBonus(Constants.SKILL_KEY skill_key, int i){
        Skill skill = skills.get(skill_key);
        if (skill != null) {
            if(i>0){
                skill.setValueBonus(i);
                skill.setValue(skill.getValue() + i);
            }else{
                skill.setValueBonus(1);
                skill.setValue(skill.getValue() + 1);
            }
            
        }
    }

    public void grantSkillAdvantage(Constants.SKILL_KEY skill_key) {
        Skill skill = skills.get(skill_key);
        if (skill != null) {
            skill.setHasAdvantage(true);
        }
    }

    public void addWeaponProficiency(Constants.WEAPON_PROFICIENCY e){
        if (!weaponProficiencies.contains(e)) weaponProficiencies.add(e);
        else System.err.println("Creature is already proficient in " + e.name());  
    }

    public void addArmorProficiency(Constants.ARMOR_PROFICIENCY e){
        if (!armorProficiencies.contains(e)) armorProficiencies.add(e);
        else System.err.println("Creature is already proficient in " + e.name());  
    }

    /*
     * Each condtion key enum in Constants is added to the condition map, as new condition effect object
     */
    private void setDefaultConditionMap(){
        for (Constants.CONDITION_KEY key : Constants.CONDITION_KEY.values()) {
            String label = key.toString().toLowerCase().replace("_", " ");
            conditionEffects.put(key, new ConditionEffect(label));
        }
    }

    /*
     * Each abilitie key enum in Constants is added to the abilitiy map, as new ability object
     */
    private void setDefaultAbilities(){
        for (Constants.ABILITY key : Constants.ABILITY.values()) {
            abilities.put(key, new Ability(key.toString().toLowerCase()));
        }
    }

    private void setDefaultLanguages(){
        for (Constants.LANGUAGE key : Constants.LANGUAGE.values()) {
            languages.put(key, false);
        }
    }
    

    /*
     * Each skill key enum in Constants is added to the abilitiy map automatically here, as new skill object
     */
    private void setDefaultSkills() {
    for (Constants.SKILL_KEY key : Constants.SKILL_KEY.values()) {

        Constants.ABILITY ability = key.getGoverningAbility();
        int abilityMod = abilities.get(ability).getAbilityMod();

        skills.put(
            key,
            new Skill(
                key.name().toLowerCase().replace("_", " "),
                abilityMod,
                getProficiencyBonus()
            )
        );
    }
}

    /*
     * Getters & Setters
     */

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMaxHealth() {
        return maxHealth;
    }

    public void setMaxHealth(int health) {
        this.maxHealth = health;
    }

    public int getCurrentHealth() {
        return currentHealth;
    }

    public void setCurrentHealth(int currentHealth) {
        this.currentHealth = currentHealth;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public BufferedImage getImage() {
        return image;
    }

    public void setImage(BufferedImage image) {
        this.image = image;
    }

    public Cell getLocation() {
        return location;
    }

    public void setLocation(Cell location) {
        this.location = location;
        this.x = location.getX();
        this.y = location.getY();
        this.width = location.getWidth();
        this.height = location.getHeight();
    }

    public int getDc() {
        return dc;
    }

    public void setDc(int dc) {
        this.dc = dc;
    }
    
    public String getCreatureType() {
        return creatureType;
    }

    public void setCreatureType(String creatureType) {
        this.creatureType = creatureType;
    }

   public int getDarkVision() {
        return darkVision;
    }

    public void setDarkVision(int darkVision) {
        this.darkVision = darkVision;
    }

    public String getRaceName() {
        return raceName;
    }

    public void setRaceName(String raceName) {
        this.raceName = raceName;
    }

    public EnumSet<Constants.DAMAGE_TYPE> getResistances() {
        return resistances;
    }

    public  EnumSet<Constants.DAMAGE_TYPE> getVulnerabilities() {
        return vulnerabilities;
    }

    public  EnumSet<Constants.DAMAGE_TYPE> getImunities() {
        return immunities;
    }

    public Constants.CREATURE_SIZE getSize() {
        return size;
    }

    public void setSize(Constants.CREATURE_SIZE size) {
        this.size = size;
    }
    
    public Constants.ABILITY getSpellCastAbility() {
        return spellCastAbility;
    }

    public void setSpellCastAbility(Constants.ABILITY spellCastAbility) {
        this.spellCastAbility = spellCastAbility;
        setSpellSaveDC();
    }

    public int getSpellCastModifier(){
         return abilities.get(getSpellCastAbility()).getAbilityMod();
    }

    public Map<Constants.CONDITION_KEY, ConditionEffect> getConditionEffects() {
        return conditionEffects;
    }

    public void setConditionEffects(Map<Constants.CONDITION_KEY, ConditionEffect> conditionEffects) {
        this.conditionEffects = conditionEffects;
    }

    public int getAttackRollReduction() {
        return attackRollReduction;
    }

    public void setAttackRollReduction(int attackRollReduction) {
        this.attackRollReduction = attackRollReduction;
    }

    public int getDamageRollReduction() {
        return damageRollReduction;
    }

    public void setDamageRollReduction(int damageRollReduction) {
        this.damageRollReduction = damageRollReduction;
    }

    public int getAbilityCheckReduction() {
        return abilityCheckReduction;
    }

    public void setAbilityCheckReduction(int abilityCheckReduction) {
        this.abilityCheckReduction = abilityCheckReduction;
    }

    public int getSavingThrowDecrease() {
        return savingThrowDecrease;
    }

    public void setSavingThrowDecrease(int savingThrowDecrease) {
        this.savingThrowDecrease = savingThrowDecrease;
    }

    public int getAttackRollIncrease() {
        return attackRollIncrease;
    }

    public void setAttackRollIncrease(int attackRollIncrease) {
        this.attackRollIncrease = attackRollIncrease;
    }

    public int getDamageRollIncrease() {
        return damageRollIncrease;
    }

    public void setDamageRollIncrease(int damageRollIncrease) {
        this.damageRollIncrease = damageRollIncrease;
    }

    public int getAbilityCheckIncrease() {
        return abilityCheckIncrease;
    }

    public void setAbilityCheckIncrease(int abilityCheckIncrease) {
        this.abilityCheckIncrease = abilityCheckIncrease;
    }

    public int getPlayerSaveIncrease() {
        return playerSaveIncrease;
    }

    public void setPlayerSaveIncrease(int playerSaveIncrease) {
        this.playerSaveIncrease = playerSaveIncrease;
    }

    public int getSavingThrowIncrease() {
        return savingThrowIncrease;
    }

    public void setSavingThrowIncrease(int savingThrowIncrease) {
        this.savingThrowIncrease = savingThrowIncrease;
    }

    public Map<Constants.ABILITY, Ability> getAbilities() {
        return abilities;
    }

    public void setAbilities(Map<Constants.ABILITY, Ability> abilities) {
        this.abilities = abilities;
    }

    public boolean isCanOpportunityAttack() {
        return canOpportunityAttack;
    }

    public void setCanOpportunityAttack(boolean canOpportunityAttack) {
        this.canOpportunityAttack = canOpportunityAttack;
    }

    public int getProficiencyBonus() {
        return proficiencyBonus;
    }

    public void setProficiencyBonus(int proficiencyBonus) {
        this.proficiencyBonus = proficiencyBonus;
    }

    public boolean isMelleeAttackRollDisadvantage() {
        return melleeAttackRollDisadvantage;
    }

    public void setMelleeAttackRollDisadvantage(boolean melleeAttackRollDisadvantage) {
        this.melleeAttackRollDisadvantage = melleeAttackRollDisadvantage;
    }

    public boolean isMelleeAttackRollAdvantage() {
        return melleeAttackRollAdvantage;
    }

    public void setMelleeAttackRollAdvantage(boolean melleeAttackRollAdvantage) {
        this.melleeAttackRollAdvantage = melleeAttackRollAdvantage;
    }

    public int getTempHealth() {
        return tempHealth;
    }

    public void setTempHealth(int tempHealth) {
        this.tempHealth = tempHealth;
    }

    public int getActions() {
        return actions;
    }

    public void setActions(int actions) {
        this.actions = actions;
    }

    public int getBonusActions() {
        return bonusActions;
    }

    public void setBonusActions(int bonusActions) {
        this.bonusActions = bonusActions;
    }

    public int getReactions() {
        return reactions;
    }

    public void setReactions(int reactions) {
        this.reactions = reactions;
    }

    public int getSpellSaveDC() {
        return spellSaveDC;
    }

    public void setSpellSaveDC() {
        // 8 + proficiency bonus + spellcasting ability modifier
        if(getSpellCastAbility() != null) this.spellSaveDC = 8 + getProficiencyBonus() + getSpellCastModifier();
        else System.err.println("Spell casting ability is not set");
    }

    public int getSpellAttackBonus() {
        return spellAttackBonus;
    }

    public void setSpellAttackBonus(int spellAttackBonus) {
        this.spellAttackBonus = spellAttackBonus;
    }

    public int getJumpDistance() {
        return jumpDistance;
    }

    public void setJumpDistance(int jumpDistance) {
        this.jumpDistance = jumpDistance;
    }

    public boolean isWearingArmor() {
        return isWearingArmor;
    }

    public void setWearingArmor(boolean isWearingArmor) {
        this.isWearingArmor = isWearingArmor;
    }

    public int getNextHitDamageRollIncrease() {
        return nextHitDamageRollIncrease;
    }

    public void setNextHitDamageRollIncrease(int nextHitDamageRollIncrease) {
        this.nextHitDamageRollIncrease = nextHitDamageRollIncrease;
    }

    public int getTempAcBonus() {
        return TempAcBonus;
    }

    public void setTempAcBonus(int TempAcBonus) {
        this.TempAcBonus = TempAcBonus;
    }

    public int getAuraDamage() {
        return auraDamage;
    }

    public void setAuraDamage(int auraDamage) {
        this.auraDamage = auraDamage;
    }

    public PlayerClass getPrimaryClass() {
        return primaryClass;
    }

    public final void setPrimaryClass(PlayerClass primaryClass) {
        this.primaryClass = primaryClass;
        primaryClass.setOwner(this);
    }

    public Map<Constants.SKILL_KEY, Skill> getSkills() {
        return skills;
    }

    public void setSkills(Map<Constants.SKILL_KEY, Skill> skills) {
        this.skills = skills;
    }

    public int getInspirationDie() {
        return inspirationDie;
    }

    public void setInspirationDie(int inspirationDie) {
        this.inspirationDie = inspirationDie;
    }

    public boolean isHasInspiration() {
        return hasInspiration;
    }

    public void setHasInspiration(boolean hasInspiration, int die) {
        setInspirationDie(die);
        this.hasInspiration = hasInspiration;
    }

    public void setHasInspiration(boolean hasInspiration) {
        this.hasInspiration = hasInspiration;
    }

    public ArrayList<Constants.WEAPON_PROFICIENCY> getWeaponProficiencies() {
        return weaponProficiencies;
    }

    public void setWeaponProficiencies(ArrayList<Constants.WEAPON_PROFICIENCY> weaponProficiencies) {
        this.weaponProficiencies = weaponProficiencies;
    }

    public ArrayList<Constants.ARMOR_PROFICIENCY> getArmorProficiencies() {
        return armorProficiencies;
    }

    public void setArmorTraining(ArrayList<Constants.ARMOR_PROFICIENCY> armorProficiencies) {
        this.armorProficiencies = armorProficiencies;
    }

    public void setSpellSaveDC(int spellSaveDC) {
        this.spellSaveDC = spellSaveDC;
    }

    public Map<Constants.LANGUAGE, Boolean> getLanguages() {
        return languages;
    }

    public void setLanguages(Map<Constants.LANGUAGE, Boolean> languages) {
        this.languages = languages;
    }

    public void setArmorProficiencies(ArrayList<Constants.ARMOR_PROFICIENCY> armorProficiencies) {
        this.armorProficiencies = armorProficiencies;
    }

    public int getMelleeAttackRollBonus() {
        return melleeAttackRollBonus;
    }

    public void setMelleeAttackRollBonus(int melleeAttackRollBonus) {
        this.melleeAttackRollBonus = melleeAttackRollBonus;
    }

    public int getRangedAttackRollBonus() {
        return rangedAttackRollBonus;
    }

    public void setRangedAttackRollBonus(int rangedAttackRollBonus) {
        this.rangedAttackRollBonus = rangedAttackRollBonus;
    }

    public int getThrownAttackDamageBonus() {
        return thrownAttackDamageBonus;
    }

    public void setThrownAttackDamageBonus(int thrownAttackDamageBonus) {
        this.thrownAttackDamageBonus = thrownAttackDamageBonus;
    }

    public ArmorClass getArmorClass() {
        return armorClass;
    }

    public void setArmorClass(ArmorClass armorClass) {
        this.armorClass = armorClass;
    }

    public boolean isHasShieldEquiped() {
        return hasShieldEquiped;
    }

    public void setHasShieldEquiped(boolean hasShieldEquiped) {
        this.hasShieldEquiped = hasShieldEquiped;
    }

    public boolean isSpellAttackRollAdvantage() {
        return spellAttackRollAdvantage;
    }

    public void setSpellAttackRollAdvantage(boolean spellAttackRollAdvantage) {
        this.spellAttackRollAdvantage = spellAttackRollAdvantage;
    }

    public boolean isSpellAttackRollDisadvantage() {
        return spellAttackRollDisadvantage;
    }

    public void setSpellAttackRollDisadvantage(boolean spellAttackRollDisadvantage) {
        this.spellAttackRollDisadvantage = spellAttackRollDisadvantage;
    }

    public boolean isRangedAttackRollDisadvantage() {
        return rangedAttackRollDisadvantage;
    }

    public void setRangedAttackRollDisadvantage(boolean rangedAttackRollDisadvantage) {
        this.rangedAttackRollDisadvantage = rangedAttackRollDisadvantage;
    }

    public boolean isRangedAttackRollAdvantage() {
        return rangedAttackRollAdvantage;
    }

    public void setRangedAttackRollAdvantage(boolean rangedAttackRollAdvantage) {
        this.rangedAttackRollAdvantage = rangedAttackRollAdvantage;
    }

    public int getSpellSaveDCBonus() {
        return spellSaveDCBonus;
    }

    public void setSpellSaveDCBonus(int spellSaveDCBonus) {
        this.spellSaveDCBonus = spellSaveDCBonus;
    }

    public Equipment getEquipment() {
        return equipment;
    }

    public void setEquipment(Equipment equipment) {
        this.equipment = equipment;
    }

    

    
}




