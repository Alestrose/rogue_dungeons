package alan.creatures;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

import alan.Constants;
import alan.grid_panel.Cell;
import alan.skills_and_feats.Ability;
import alan.skills_and_feats.ConditionEffect;

public abstract class Creature {
    private String
        creatureType, name, raceName;
    private int
        level = 1, ac = 10, maxHealth, currentHealth, tmepHhealth, speed, dc = 10, x,y, width, height,
        enemyAttackRollReduction, enemyDamageRollReduction, playerAttackRollIncrease,
        playerDamageRollIncrease, playerAbilityCheckIncrease, darkVision = 0;
    protected String fileName;
    protected BufferedImage image;
    private Cell location;
    private Constants.CREATURE_SIZE size;
    private Constants.ABILITY spellCastAbility;

    // Ability scores & Modifiers
    protected Map<Constants.ABILITY, Ability> abilities = new HashMap<>();
    // Resistances & Vulnerabilities
    protected Map<Constants.DAMAGE_TYPE, Boolean> resistances = new HashMap<>();
    protected Map<Constants.DAMAGE_TYPE, Boolean> vulnerabilities = new HashMap<>();
    protected Map<Constants.DAMAGE_TYPE, Boolean> inVulnerabilities = new HashMap<>();
    protected Map<Constants.CONDITION_KEY, ConditionEffect> conditionEffects = new HashMap<>();

    // No Cell location Constructor
    public Creature(
        String name,
        String fileName){
        this.name = name;
        this.fileName = fileName;
        // Initializes image from images folder. Image selected via fileName
        File pic = new File("images/" + fileName);
        try {
            image = ImageIO.read(pic);
        } catch (IOException e) {
            System.out.println("file not found");
        }

        setDefaultResistences();
        setDefaultVulnerabilities();
        setDefaultConditionMap();
        setDefaultAbilities();
    }

    // Specified Cell location constructor
    public Creature(
        String name,
        String fileName,
        Cell location){
        this.name = name;
        this.fileName = fileName;
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
        setDefaultVulnerabilities();
        setDefaultConditionMap();
        setDefaultAbilities();
    }

    /*
     * Methods
     */

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

    public void grantResistance(Constants.DAMAGE_TYPE resistanceName){
        resistances.put(resistanceName, true);
    }

    public void grantDamageVulnerabilities(Constants.DAMAGE_TYPE vulnerabilityName){
        vulnerabilities.put(vulnerabilityName, true);
    }

    public void grantDamageInVulnerabilities(Constants.DAMAGE_TYPE InVulnerabilityName){
        inVulnerabilities.put(InVulnerabilityName, true);
    }

    public void ApplyConditionEffect(Constants.CONDITION_KEY condition_key){
        ConditionEffect effect = conditionEffects.get(condition_key);
        if (effect != null) {
            effect.setActive(true);
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

    public void grantAbilityAdvantage(Constants.ABILITY a, Integer val){
        abilities.get(a).setSaveAdvantage(true);
    }

    public void grantAbilityDisadvantage(Constants.ABILITY a, Integer val){
        abilities.get(a).setSaveDisadvantage(true);
    }

    private void setDefaultResistences(){
        for (Constants.DAMAGE_TYPE type : Constants.DAMAGE_TYPE.values()) {
        resistances.put(type, false);
        }
    }
    
    private void setDefaultVulnerabilities(){
        for (Constants.DAMAGE_TYPE type : Constants.DAMAGE_TYPE.values()) {
            vulnerabilities.put(type, false);
        }
    }

    private void setDefaultConditionMap(){
        conditionEffects.put(Constants.CONDITION_KEY.BLINDED, new ConditionEffect("blinded"));
        conditionEffects.put(Constants.CONDITION_KEY.CHARMED, new ConditionEffect("charmed"));
        conditionEffects.put(Constants.CONDITION_KEY.DEAFENED, new ConditionEffect("deafened"));
        conditionEffects.put(Constants.CONDITION_KEY.EXHAUSTION, new ConditionEffect("exhaustion"));
        conditionEffects.put(Constants.CONDITION_KEY.FRIGHTENED, new ConditionEffect("frightened"));
        conditionEffects.put(Constants.CONDITION_KEY.GRAPPLED, new ConditionEffect("grappled"));
        conditionEffects.put(Constants.CONDITION_KEY.INCAPACITATED, new ConditionEffect("incapacitated"));
        conditionEffects.put(Constants.CONDITION_KEY.INVISIBLE, new ConditionEffect("invisible"));
        conditionEffects.put(Constants.CONDITION_KEY.PARALYZED, new ConditionEffect("paralyzed"));
        conditionEffects.put(Constants.CONDITION_KEY.PETRIFIED, new ConditionEffect("petrified"));
        conditionEffects.put(Constants.CONDITION_KEY.POISONED, new ConditionEffect("poisoned"));
        conditionEffects.put(Constants.CONDITION_KEY.PRONE, new ConditionEffect("prone"));
        conditionEffects.put(Constants.CONDITION_KEY.RESTRAINED, new ConditionEffect("restrained"));
        conditionEffects.put(Constants.CONDITION_KEY.STUNNED, new ConditionEffect("stunned"));
        conditionEffects.put(Constants.CONDITION_KEY.UNCONSCIOUS, new ConditionEffect("unconscious"));
        conditionEffects.put(Constants.CONDITION_KEY.CHILL_TOUCH, new ConditionEffect("chill touch"));
    }

    private void setDefaultAbilities(){
        abilities.put(Constants.ABILITY.STRENGTH, new Ability("Strength"));
        abilities.put(Constants.ABILITY.CONSTITUTION, new Ability("Constitution"));
        abilities.put(Constants.ABILITY.DEXTERITY, new Ability("Dexterity"));
        abilities.put(Constants.ABILITY.INTELLIGENCE, new Ability("Intelligence"));
        abilities.put(Constants.ABILITY.WISDOM, new Ability("Wisdom"));
        abilities.put(Constants.ABILITY.CHARISMA, new Ability("Charisma"));
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
        return ac;
    }

    public void setAc(int ac) {
        this.ac = ac;
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
    }

    public int getTmepHhealth() {
        return tmepHhealth;
    }

    public void setTmepHhealth(int tmepHhealth) {
        this.tmepHhealth = tmepHhealth;
    }

    public int getEnemyAttackRollReduction() {
        return enemyAttackRollReduction;
    }

    public void setEnemyAttackRollReduction(int enemyAttackRollReduction) {
        this.enemyAttackRollReduction = enemyAttackRollReduction;
    }

    public int getEnemyDamageRollReduction() {
        return enemyDamageRollReduction;
    }

    public void setEnemyDamageRollReduction(int enemyDamageRollReduction) {
        this.enemyDamageRollReduction = enemyDamageRollReduction;
    }

    public int getPlayerAttackRollIncrease() {
        return playerAttackRollIncrease;
    }

    public void setPlayerAttackRollIncrease(int playerAttackRollIncrease) {
        this.playerAttackRollIncrease = playerAttackRollIncrease;
    }

    public int getPlayerDamageRollIncrease() {
        return playerDamageRollIncrease;
    }

    public void setPlayerDamageRollIncrease(int playerDamageRollIncrease) {
        this.playerDamageRollIncrease = playerDamageRollIncrease;
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

    public int getPlayerAbilityCheckIncrease() {
        return playerAbilityCheckIncrease;
    }

    public void setPlayerAbilityCheckIncrease(int playerAbilityCheckIncrease) {
        this.playerAbilityCheckIncrease = playerAbilityCheckIncrease;
    }
    
    
}




