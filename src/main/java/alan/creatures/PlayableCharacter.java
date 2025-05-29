package alan.creatures;

import alan.grid_panel.Cell;

public class PlayableCharacter extends Creature{
    private boolean hasAdvantage = false;
    private Race race;

    // Ability scores
    private int strength, dexterity, constitution, intelligence, wisdom, charisma;

    // Resistances
    private boolean 
        resistFire,resistIce,resistLightning,resistPoison,resistAcid,resistSlashing,resistPiercing,resistBludgeoning,resistNecrotic,resistRadient;
    // Vulnerabilities
    private boolean 
        vulnerableFire,vulnerableIce,vulnerableLightning,vulnerablePoison,vulnerableAcid,vulnerableSlashing,vulnerablePiercing,vulnerableBludgeoning,vulnerableNecrotic,vulnerableRadient;

    // Without location constructor
    public PlayableCharacter(String name, String fileName, Race race) {
        super(name, fileName);
        this.race = race;
        setRacialFeatures();
        setClassFeatures();
    }
    
    // With location constructor
    public PlayableCharacter(String name, String fileName, Cell location, Race race) {
        super(name, fileName, location);
        this.race = race;
        setRacialFeatures();
        setClassFeatures();

    }

    /*
     * Methods
     */

    private  void setClassFeatures(){

    }

    private void setRacialFeatures(){

    }
    
    public void onLongRest(){

    }
    
    public void onShortRest(){
        
    }

    public void onLevelUp(){

    }

    
    
    /*
     * Getters & Setters
     */
    
    public boolean isHasAdvantage() {
        return hasAdvantage;
    }

    public void setHasAdvantage(boolean hasAdvantage) {
        this.hasAdvantage = hasAdvantage;
    }

    public Race getRace() {
        return race;
    }

    public void setRace(Race race) {
        this.race = race;
    }

    public int getStrength() {
        return strength;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    public int getDexterity() {
        return dexterity;
    }

    public void setDexterity(int dexterity) {
        this.dexterity = dexterity;
    }

    public int getConstitution() {
        return constitution;
    }

    public void setConstitution(int constitution) {
        this.constitution = constitution;
    }

    public int getIntelligence() {
        return intelligence;
    }

    public void setIntelligence(int intelligence) {
        this.intelligence = intelligence;
    }

    public int getWisdom() {
        return wisdom;
    }

    public void setWisdom(int wisdom) {
        this.wisdom = wisdom;
    }

    public int getCharisma() {
        return charisma;
    }

    public void setCharisma(int charisma) {
        this.charisma = charisma;
    }

    public boolean isResistFire() {
        return resistFire;
    }

    public void setResistFire(boolean resistFire) {
        this.resistFire = resistFire;
    }

    public boolean isResistIce() {
        return resistIce;
    }

    public void setResistIce(boolean resistIce) {
        this.resistIce = resistIce;
    }

    public boolean isResistLightning() {
        return resistLightning;
    }

    public void setResistLightning(boolean resistLightning) {
        this.resistLightning = resistLightning;
    }

    public boolean isResistPoison() {
        return resistPoison;
    }

    public void setResistPoison(boolean resistPoison) {
        this.resistPoison = resistPoison;
    }

    public boolean isResistAcid() {
        return resistAcid;
    }

    public void setResistAcid(boolean resistAcid) {
        this.resistAcid = resistAcid;
    }

    public boolean isResistSlashing() {
        return resistSlashing;
    }

    public void setResistSlashing(boolean resistSlashing) {
        this.resistSlashing = resistSlashing;
    }

    public boolean isResistPiercing() {
        return resistPiercing;
    }

    public void setResistPiercing(boolean resistPiercing) {
        this.resistPiercing = resistPiercing;
    }

    public boolean isResistBludgeoning() {
        return resistBludgeoning;
    }

    public void setResistBludgeoning(boolean resistBludgeoning) {
        this.resistBludgeoning = resistBludgeoning;
    }

    public boolean isResistNecrotic() {
        return resistNecrotic;
    }

    public void setResistNecrotic(boolean resistNecrotic) {
        this.resistNecrotic = resistNecrotic;
    }

    public boolean isResistRadient() {
        return resistRadient;
    }

    public void setResistRadient(boolean resistRadient) {
        this.resistRadient = resistRadient;
    }

    public boolean isVulnerableFire() {
        return vulnerableFire;
    }

    public void setVulnerableFire(boolean vulnerableFire) {
        this.vulnerableFire = vulnerableFire;
    }

    public boolean isVulnerableIce() {
        return vulnerableIce;
    }

    public void setVulnerableIce(boolean vulnerableIce) {
        this.vulnerableIce = vulnerableIce;
    }

    public boolean isVulnerableLightning() {
        return vulnerableLightning;
    }

    public void setVulnerableLightning(boolean vulnerableLightning) {
        this.vulnerableLightning = vulnerableLightning;
    }

    public boolean isVulnerablePoison() {
        return vulnerablePoison;
    }

    public void setVulnerablePoison(boolean vulnerablePoison) {
        this.vulnerablePoison = vulnerablePoison;
    }

    public boolean isVulnerableAcid() {
        return vulnerableAcid;
    }

    public void setVulnerableAcid(boolean vulnerableAcid) {
        this.vulnerableAcid = vulnerableAcid;
    }

    public boolean isVulnerableSlashing() {
        return vulnerableSlashing;
    }

    public void setVulnerableSlashing(boolean vulnerableSlashing) {
        this.vulnerableSlashing = vulnerableSlashing;
    }

    public boolean isVulnerablePiercing() {
        return vulnerablePiercing;
    }

    public void setVulnerablePiercing(boolean vulnerablePiercing) {
        this.vulnerablePiercing = vulnerablePiercing;
    }

    public boolean isVulnerableBludgeoning() {
        return vulnerableBludgeoning;
    }

    public void setVulnerableBludgeoning(boolean vulnerableBludgeoning) {
        this.vulnerableBludgeoning = vulnerableBludgeoning;
    }

    public boolean isVulnerableNecrotic() {
        return vulnerableNecrotic;
    }

    public void setVulnerableNecrotic(boolean vulnerableNecrotic) {
        this.vulnerableNecrotic = vulnerableNecrotic;
    }

    public boolean isVulnerableRadient() {
        return vulnerableRadient;
    }

    public void setVulnerableRadient(boolean vulnerableRadient) {
        this.vulnerableRadient = vulnerableRadient;
    }

    

}
