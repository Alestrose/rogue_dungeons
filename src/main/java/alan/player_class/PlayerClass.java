package alan.player_class;

import java.awt.image.BufferedImage;
import java.util.ArrayList;

import alan.Constants;

public class PlayerClass {

    private String className;
    private Constants.CLASS playerClass;
    private int classLevel = 1;
    private ArrayList<Constants.ABILITY> primaryAbilities;
    private int hitPointDie;
    private ArrayList<Constants.ABILITY> savingThrowProficiencies;
    private ArrayList<Constants.WEAPON_TRAINING> weaponProficiencies;
    private ArrayList<Constants.ARMOR_TRAINING> armorTraining;

    protected BufferedImage classImage;
    protected String classImageFileName;

    public PlayerClass(Constants.CLASS playerClass){
        this.playerClass = playerClass;

        // Capitalize first letter of class name
        String s = playerClass.name().toLowerCase().replace('_', ' ');
        className = s.substring(0, 1).toUpperCase() + s.substring(1);
        
        initNewCharacter();
    }

    /*
     * Methods
     */

    public final void initNewCharacter(){
        if(playerClass == null) return; // guard against NPE

        switch (playerClass) {
            case BARBARIAN  -> {setBarbarianClass();}
            case BARD       -> {setBardClass();}
            case CLERIC     -> {setClericClass();}
            case DRUID      -> {setDruidClass();}
            case FIGHTER    -> {setFighterClass();}
            case MONK       -> {setMonkClass();}
            case PALADIN    -> {setPaladinClass();}
            case RANGER     -> {setRangerlass();}
            case ROGUE      -> {setRogueClass();}
            case SORCERER   -> {setSorcererClass();}
            case WARLOCK    -> {setWarlockClass();}
            case WIZARD     -> {setWizardClass();}
            default         -> {}
        }
    
    }

    public void setBarbarianClass(){

    }

    public void setBardClass(){

    }

    public void setClericClass(){

    }

    public void setDruidClass(){

    }

    public void setFighterClass(){

    }

    public void setMonkClass(){

    }

    public void setPaladinClass(){

    }

    public void setRangerlass(){

    }

    public void setRogueClass(){

    }

    public void setSorcererClass(){

    }

    public void setWarlockClass(){

    }

    public void setWizardClass(){

    }

    /*
    * Getters and Setters
    */

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public Constants.CLASS getPlayerClass() {
        return playerClass;
    }

    public void setPlayerClass(Constants.CLASS playerClass) {
        this.playerClass = playerClass;
    }

    public int getClassLevel() {
        return classLevel;
    }

    public void setClassLevel(int classLevel) {
        this.classLevel = classLevel;
    }

    public ArrayList<Constants.ABILITY> getPrimaryAbilities() {
        return primaryAbilities;
    }

    public void setPrimaryAbilities(ArrayList<Constants.ABILITY> primaryAbilities) {
        this.primaryAbilities = primaryAbilities;
    }

    public int getHitPointDie() {
        return hitPointDie;
    }

    public void setHitPointDie(int hitPointDie) {
        this.hitPointDie = hitPointDie;
    }

    public ArrayList<Constants.ABILITY> getSavingThrowProficiencies() {
        return savingThrowProficiencies;
    }

    public void setSavingThrowProficiencies(ArrayList<Constants.ABILITY> savingThrowProficiencies) {
        this.savingThrowProficiencies = savingThrowProficiencies;
    }

    public ArrayList<Constants.WEAPON_TRAINING> getWeaponProficiencies() {
        return weaponProficiencies;
    }

    public void setWeaponProficiencies(ArrayList<Constants.WEAPON_TRAINING> weaponProficiencies) {
        this.weaponProficiencies = weaponProficiencies;
    }

    public ArrayList<Constants.ARMOR_TRAINING> getArmorTraining() {
        return armorTraining;
    }

    public void setArmorTraining(ArrayList<Constants.ARMOR_TRAINING> armorTraining) {
        this.armorTraining = armorTraining;
    }

    

    
}
