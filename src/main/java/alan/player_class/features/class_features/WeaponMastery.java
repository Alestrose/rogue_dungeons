package alan.player_class.features.class_features;

import java.util.ArrayList;

import alan.Constants;
import alan.Constants.DAMAGE_TYPE;
import alan.creatures.Creature;
import alan.grid_panel.Cell;
import alan.player_class.features.FeatureAbstract;

public class WeaponMastery extends FeatureAbstract{
    
    private ArrayList<Constants.WEAPON_KEY> currentMasteries = new ArrayList<>();

    public WeaponMastery(){
        setClassFeatureKey(Constants.FEATURE.WEAPON_MASTERY);
        setPassive(true);
        setFeatureLevel(1);
        setFeatType(Constants.FEAT_TYPE.CLASS);
        setResourceQuanity(2);
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
            case 4 -> {setResourceQuanity(3);}
            case 10 -> {setResourceQuanity(4);}
            default -> {}
        }
    }

    public void addMastery(Constants.WEAPON_KEY key){
        if(currentMasteries.size() < getResourceQuanity()){
            currentMasteries.add(key);
        }else System.err.println("Cant train any more masteries.");
    }    

    /*
     * Getters and Setters
     */
    

    public ArrayList<Constants.WEAPON_KEY> getCurrentMasteries() {
        return currentMasteries;
    }

    public void setCurrentMasteries(ArrayList<Constants.WEAPON_KEY> currentMasteries) {
        this.currentMasteries = currentMasteries;
    }
    
    

}
