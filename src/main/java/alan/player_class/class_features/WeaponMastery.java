package alan.player_class.class_features;

import java.util.ArrayList;

import alan.Constants;
import alan.Constants.DAMAGE_TYPE;
import alan.creatures.Creature;
import alan.grid_panel.Cell;

public class WeaponMastery extends ClassFeatureAbstract{
    private int maxNumberOfMasteries = 2;
    private ArrayList<Constants.WEAPON_KEY> currentMasteries = new ArrayList<>();

    public WeaponMastery(){
        setClassFeatureKey(Constants.CLASS_FEATURE.WEAPON_MASTERY);
        setPassive(true);
        setFeatureLevel(1);
    }

    @Override
    public void cast(Creature caster, Creature target, Creature[] targetList, Cell cell, DAMAGE_TYPE damage_type, int spellLevel) {
    }

    @Override
    public String descreiption() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void onLevelUp(int lvl) {
        switch (lvl) {
            case 4 -> {setMaxNumberOfMasteries(3);}
            case 10 -> {setMaxNumberOfMasteries(4);}
            default -> {}
        }
    }

    public void addMastery(Constants.WEAPON_KEY key){
        if(currentMasteries.size() < maxNumberOfMasteries){
            currentMasteries.add(key);
        }else System.err.println("Cant train any more masteries.");
    }    

    /*
     * Getters and Setters
     */
    
     public int getMaxNumberOfMasteries() {
        return maxNumberOfMasteries;
    }

    public void setMaxNumberOfMasteries(int maxNumberOfMasteries) {
        this.maxNumberOfMasteries = maxNumberOfMasteries;
    }

    public ArrayList<Constants.WEAPON_KEY> getCurrentMasteries() {
        return currentMasteries;
    }

    public void setCurrentMasteries(ArrayList<Constants.WEAPON_KEY> currentMasteries) {
        this.currentMasteries = currentMasteries;
    }
    
    

}
