package alan.creatures;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

import alan.Constants;
import alan.player_class.PlayerClass;
import alan.grid_panel.Cell;
import alan.skills_and_feats.Ability;
import alan.skills_and_feats.ConditionEffect;
import alan.skills_and_feats.Skill;

public abstract class Creature {
    private String creatureType, name, raceName;
    private int proficiencyBonus = 2;
    private int baseAC = 10;
    private int ac;
    private int
        level = 1, inspirationDie = 0, TempAcBonus, maxHealth, tempHealth, currentHealth, speed, dc = 10, x,y, width, height, actions = 1, bonusActions = 1, reactions = 1, spellSaveDC, spellAttackBonus, jumpDistance, auraDamage,
        attackRollReduction, damageRollReduction, abilityCheckReduction, savingThrowDecrease, attackRollIncrease, damageRollIncrease, nextHitDamageRollIncrease, abilityCheckIncrease, playerSaveIncrease, savingThrowIncrease, darkVision = 0;
    protected String fileName;
    protected BufferedImage image;
    private Cell location;
    private Constants.CREATURE_SIZE size;
    private Constants.ABILITY spellCastAbility;

    // Booleans
    private boolean canOpportunityAttack = true;
    private boolean attackRollDisadvantage, attackRollAdvantage, isWearingArmor;
    private boolean hasInspiration = false;

    // Classes
    private PlayerClass primaryClass;

    // Ability scores & Modifiers
    protected Map<Constants.ABILITY, Ability> abilities = new HashMap<>();
    protected Map<Constants.SKILL_KEY, Skill> skills = new HashMap<>();
    private ArrayList<Constants.WEAPON_PROFICIENCY> weaponProficiencies = new ArrayList<>();
    private ArrayList<Constants.ARMOR_PROFICIENCY> armorProficiencies = new ArrayList<>();
    
    // Resistances & Vulnerabilities
    protected Map<Constants.DAMAGE_TYPE, Boolean> resistances = new HashMap<>();
    protected Map<Constants.DAMAGE_TYPE, Boolean> vulnerabilities = new HashMap<>();
    protected Map<Constants.DAMAGE_TYPE, Boolean> inVulnerabilities = new HashMap<>();
    protected Map<Constants.CONDITION_KEY, ConditionEffect> conditionEffects = new HashMap<>();

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

        setDefaultResistences();
        setDefaultConditionMap();
        setDefaultAbilities();
        setDefaultSkills();

        // Done last
        initStartingAttributes();
        
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

        setDefaultResistences();
        setDefaultConditionMap();
        setDefaultAbilities();
        setDefaultSkills();

        // Done last
        initClassAttributes();
        initStartingAttributes();
    }

    /*
     * Methods
     */

    public final void initClassAttributes(){
        primaryClass.initNewCharacter();
    }

    public final void initStartingAttributes(){
        setAc(getBaseAC());
    }

    public void move(){

    }

    // Reduces health by int val
    public void damageHealth(int val){
        currentHealth -= val;
        if(currentHealth < 0) currentHealth = 0;
    }

    // Increases health by int val
    public void healHealth(int val){
        currentHealth += val;
        if(currentHealth > maxHealth) currentHealth = maxHealth;
    }

    // For use in "GameManager.drawSprites()"
    public void drawCreature(Graphics2D graphics, JPanel panel){
        graphics.drawImage(getImage(), getX(), getY(), getWidth(), getHeight(), panel);
    }

    /*
     * Setters for granting enum based conditions and effects
     */
    public void grantResistance(Constants.DAMAGE_TYPE resistanceName){
        resistances.put(resistanceName, true);
    }

    public void grantDamageVulnerabilities(Constants.DAMAGE_TYPE vulnerabilityName){
        vulnerabilities.put(vulnerabilityName, true);
    }

    public void grantDamageInVulnerabilities(Constants.DAMAGE_TYPE InVulnerabilityName){
        inVulnerabilities.put(InVulnerabilityName, true);
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

    public void grantSkillBonus(Constants.SKILL_KEY skill_key, int i){
        Skill skill = skills.get(skill_key);
        if (skill != null) {
            skill.setValueBonus(i);
            skill.setValue(skill.getValue() + i);
        }
    }

    /*
     * public void setValueBonus(int valueBonus) {
        this.valueBonus = valueBonus;
        this.value = abilityModifier + valueBonus;
    }
     */

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
     * Each damage type key enum in Constants is added to the resistances, vulnerabilities and inVulnerabilities maps, and sets to false
     * Also used to reset all resistances, vulnerabilities and inVulnerabilities
     */
    private void setDefaultResistences(){  
        for (Constants.DAMAGE_TYPE type : Constants.DAMAGE_TYPE.values()) {
            resistances.put(type, false);
        }
        for (Constants.DAMAGE_TYPE type : Constants.DAMAGE_TYPE.values()) {
            vulnerabilities.put(type, false);
        }
        for (Constants.DAMAGE_TYPE type : Constants.DAMAGE_TYPE.values()) {
            inVulnerabilities.put(type, false);
        }
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

    /*
     * Each skill key enum in Constants is added to the abilitiy map manually here, as new skill object
     */
    private void setDefaultSkills(){
        skills.put(Constants.SKILL_KEY.ATHLETICS, new Skill("athletics", abilities.get(Constants.ABILITY.STRENGTH).getAbilityMod(), getProficiencyBonus()));
        skills.put(Constants.SKILL_KEY.ACROBATICS, new Skill("acrobatics", abilities.get(Constants.ABILITY.DEXTERITY).getAbilityMod(), getProficiencyBonus()));
        skills.put(Constants.SKILL_KEY.SLEIGHT_OF_HAND, new Skill("sleight of Hand", abilities.get(Constants.ABILITY.DEXTERITY).getAbilityMod(), getProficiencyBonus()));
        skills.put(Constants.SKILL_KEY.STEALTH, new Skill("stealth", abilities.get(Constants.ABILITY.DEXTERITY).getAbilityMod(), getProficiencyBonus()));
        skills.put(Constants.SKILL_KEY.ARCANA, new Skill("arcana", abilities.get(Constants.ABILITY.INTELLIGENCE).getAbilityMod(), getProficiencyBonus()));
        skills.put(Constants.SKILL_KEY.HISTORY, new Skill("history", abilities.get(Constants.ABILITY.INTELLIGENCE).getAbilityMod(), getProficiencyBonus()));
        skills.put(Constants.SKILL_KEY.INVESTIGATION, new Skill("investigation", abilities.get(Constants.ABILITY.INTELLIGENCE).getAbilityMod(), getProficiencyBonus()));
        skills.put(Constants.SKILL_KEY.NATURE, new Skill("nature", abilities.get(Constants.ABILITY.INTELLIGENCE).getAbilityMod(), getProficiencyBonus()));
        skills.put(Constants.SKILL_KEY.RELIGION, new Skill("religion", abilities.get(Constants.ABILITY.INTELLIGENCE).getAbilityMod(), getProficiencyBonus()));
        skills.put(Constants.SKILL_KEY.ANIMAL_HANDLING, new Skill("animal handling", abilities.get(Constants.ABILITY.WISDOM).getAbilityMod(), getProficiencyBonus()));
        skills.put(Constants.SKILL_KEY.INSIGHT, new Skill("insight", abilities.get(Constants.ABILITY.WISDOM).getAbilityMod(), getProficiencyBonus()));
        skills.put(Constants.SKILL_KEY.MEDICINE, new Skill("medicine", abilities.get(Constants.ABILITY.WISDOM).getAbilityMod(), getProficiencyBonus()));
        skills.put(Constants.SKILL_KEY.PERCEPTION, new Skill("perception", abilities.get(Constants.ABILITY.WISDOM).getAbilityMod(), getProficiencyBonus()));
        skills.put(Constants.SKILL_KEY.SURVIVAL, new Skill("survival", abilities.get(Constants.ABILITY.WISDOM).getAbilityMod(), getProficiencyBonus()));
        skills.put(Constants.SKILL_KEY.DECEPTION, new Skill("deception", abilities.get(Constants.ABILITY.CHARISMA).getAbilityMod(), getProficiencyBonus()));
        skills.put(Constants.SKILL_KEY.INTIMIDATION, new Skill("intimidation", abilities.get(Constants.ABILITY.CHARISMA).getAbilityMod(), getProficiencyBonus()));
        skills.put(Constants.SKILL_KEY.PERFORMANCE, new Skill("performance", abilities.get(Constants.ABILITY.CHARISMA).getAbilityMod(), getProficiencyBonus()));
        skills.put(Constants.SKILL_KEY.PERSUASION, new Skill("persuasion", abilities.get(Constants.ABILITY.CHARISMA).getAbilityMod(), getProficiencyBonus()));
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

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getAc() {
        int currentAC = ac + getTempAcBonus();
        return currentAC;
    }

    public void setAc(int baseAC) {
        this.ac = baseAC + getAbilities().get(Constants.ABILITY.DEXTERITY).getAbilityMod();
        
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

    public Map<Constants.DAMAGE_TYPE, Boolean> getResistances() {
        return resistances;
    }

    public void setResistances(Map<Constants.DAMAGE_TYPE, Boolean> resistances) {
        this.resistances = resistances;
    }

    public Map<Constants.DAMAGE_TYPE, Boolean> getVulnerabilities() {
        return vulnerabilities;
    }

    public void setVulnerabilities(Map<Constants.DAMAGE_TYPE, Boolean> vulnerabilities) {
        this.vulnerabilities = vulnerabilities;
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

    public Map<Constants.DAMAGE_TYPE, Boolean> getInVulnerabilities() {
        return inVulnerabilities;
    }

    public void setInVulnerabilities(Map<Constants.DAMAGE_TYPE, Boolean> inVulnerabilities) {
        this.inVulnerabilities = inVulnerabilities;
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

    public boolean isAttackRollDisadvantage() {
        return attackRollDisadvantage;
    }

    public void setAttackRollDisadvantage(boolean attackRollDisadvantage) {
        this.attackRollDisadvantage = attackRollDisadvantage;
    }

    public boolean isAttackRollAdvantage() {
        return attackRollAdvantage;
    }

    public void setAttackRollAdvantage(boolean attackRollAdvantage) {
        this.attackRollAdvantage = attackRollAdvantage;
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
        this.TempAcBonus = getTempAcBonus() + TempAcBonus;
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

    public int getBaseAC() {
        return baseAC;
    }

    public void setBaseAC(int baseAC) {
        this.baseAC = baseAC;
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

    
    

}




