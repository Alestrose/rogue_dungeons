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
import alan.skills_and_feats.ConditionEffect;

public abstract class Creature {
    private String
        creatureType,
        name,
        raceName;

    private int
        level = 1,
        ac = 10,
        maxHealth,
        currentHealth,
        speed,
        dc = 10,
        x,y,
        width,
        height,
        darkVision = 0;
    protected String fileName;
    protected BufferedImage image;
    private Cell location;
    private Constants.CREATURE_SIZE size;

    // Ability scores & Modifiers
    protected Map<Constants.ABILITY, Integer> abilities = new HashMap<>();
    //private int strength, dexterity, constitution, intelligence, wisdom, charisma;
    private int
        strengthMod = setModifier(abilities.getOrDefault(Constants.ABILITY.STRENGTH, 10)),
        dexterityMod = setModifier(abilities.getOrDefault(Constants.ABILITY.DEXTERITY, 10)),
        constitutionMod = setModifier(abilities.getOrDefault(Constants.ABILITY.CONSTITUTION, 10)),
        intelligenceMod = setModifier(abilities.getOrDefault(Constants.ABILITY.INTELLIGENCE, 10)),
        wisdomMod = setModifier(abilities.getOrDefault(Constants.ABILITY.WISDOM, 10)),
        charismaMod = setModifier(abilities.getOrDefault(Constants.ABILITY.CHARISMA, 10));
    
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

    // Initialize named booleans
    private void setDefaultResistences(){
    resistances.put(Constants.DAMAGE_TYPE.FIRE, false);
    resistances.put(Constants.DAMAGE_TYPE.ICE, false);
    resistances.put(Constants.DAMAGE_TYPE.LIGHTNING, false);
    resistances.put(Constants.DAMAGE_TYPE.POISON, false);
    resistances.put(Constants.DAMAGE_TYPE.ACID, false);
    resistances.put(Constants.DAMAGE_TYPE.SLASHING, false);
    resistances.put(Constants.DAMAGE_TYPE.PIERCING, false);
    resistances.put(Constants.DAMAGE_TYPE.BLUDGEONING, false);
    resistances.put(Constants.DAMAGE_TYPE.NECROTIC, false);
    resistances.put(Constants.DAMAGE_TYPE.RADIANT, false);
    }
    
    // Initialize named booleans
    private void setDefaultVulnerabilities(){
    vulnerabilities.put(Constants.DAMAGE_TYPE.FIRE, false);
    vulnerabilities.put(Constants.DAMAGE_TYPE.ICE, false);
    vulnerabilities.put(Constants.DAMAGE_TYPE.LIGHTNING, false);
    vulnerabilities.put(Constants.DAMAGE_TYPE.POISON, false);
    vulnerabilities.put(Constants.DAMAGE_TYPE.ACID, false);
    vulnerabilities.put(Constants.DAMAGE_TYPE.SLASHING, false);
    vulnerabilities.put(Constants.DAMAGE_TYPE.PIERCING, false);
    vulnerabilities.put(Constants.DAMAGE_TYPE.BLUDGEONING, false);
    vulnerabilities.put(Constants.DAMAGE_TYPE.NECROTIC, false);
    vulnerabilities.put(Constants.DAMAGE_TYPE.RADIANT, false);
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
    }

    private void setDefaultAbilities(){
    abilities.put(Constants.ABILITY.STRENGTH, 10);
    abilities.put(Constants.ABILITY.CONSTITUTION, 10);
    abilities.put(Constants.ABILITY.DEXTERITY, 10);
    abilities.put(Constants.ABILITY.INTELLIGENCE, 10);
    abilities.put(Constants.ABILITY.WISDOM, 10);
    abilities.put(Constants.ABILITY.CHARISMA, 10);

    }

    public int setModifier(int abilityScore){
        if(abilityScore >= 10) return strengthMod = (abilityScore - 10) /2;
        else return strengthMod = (abilityScore - 11) /2;
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

    public int getStrengthMod() {
        return strengthMod;
    }

    public int getDexterityMod() {
        return dexterityMod;
    }

    public int getConstitutionMod() {
        return constitutionMod;
    }

    public int getIntelligenceMod() {
        return intelligenceMod;
    }

    public int getWisdomMod() {
        return wisdomMod;
    }

    public int getCharismaMod() {
        return charismaMod;
    }

    public String getRaceName() {
        return raceName;
    }

    public void setRaceName(String raceName) {
        this.raceName = raceName;
    }

    public void setStrengthMod(int strengthMod) {
        this.strengthMod = strengthMod;
    }

    public void setDexterityMod(int dexterityMod) {
        this.dexterityMod = dexterityMod;
    }

    public void setConstitutionMod(int constitutionMod) {
        this.constitutionMod = constitutionMod;
    }

    public void setIntelligenceMod(int intelligenceMod) {
        this.intelligenceMod = intelligenceMod;
    }

    public void setWisdomMod(int wisdomMod) {
        this.wisdomMod = wisdomMod;
    }

    public void setCharismaMod(int charismaMod) {
        this.charismaMod = charismaMod;
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
    

}




