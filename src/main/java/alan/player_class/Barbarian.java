package alan.player_class;

import java.util.HashMap;
import java.util.Map;

import alan.Constants;
import alan.player_class.class_features.ClassFeatureAbstract;
import alan.player_class.class_features.Rage;
import alan.player_class.class_features.UnarmoredDefenseBarbarian;
import alan.player_class.class_features.WeaponMastery;

public class Barbarian extends PlayerClass{
    private Map<Constants.CLASS_FEATURE, ClassFeatureAbstract> barbarianFeatures = new HashMap<>();

    // Constructor
    public Barbarian(Constants.CLASS playerClass){
        super(playerClass);
        barbarianFeatures.put(Constants.CLASS_FEATURE.RAGE, new Rage());
        barbarianFeatures.put(Constants.CLASS_FEATURE.UNARMORED_DEFENSE_BARBARIAN, new UnarmoredDefenseBarbarian());
        barbarianFeatures.put(Constants.CLASS_FEATURE.WEAPON_MASTERY, new WeaponMastery());

        // Applies or updates class passive features
        // UPDATE_PASSIVES(barbarianFeatures);
    }
    
    /*
     * Methods
     */

     @Override
    public void onLevelUp() {
        
    }
    
    @Override
    public void onShortRest(){

    }

    @Override
    public void onLongRest(){
        
    }

    /*
     * Getters and Setters
     */

    public Map<Constants.CLASS_FEATURE, ClassFeatureAbstract> getBarbarianFeatures() {
        return barbarianFeatures;
    }


    public void setBarbarianFeatires(Map<Constants.CLASS_FEATURE, ClassFeatureAbstract> barbarianFeatires) {
        this.barbarianFeatures = barbarianFeatires;
    }
    


}
