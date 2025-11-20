package alan.player_class;

import java.util.HashMap;
import java.util.Map;

import alan.Constants;
import alan.player_class.class_features.FeatureAbstract;
import alan.player_class.class_features.Rage;
import alan.player_class.class_features.UnarmoredDefense;
import alan.player_class.class_features.WeaponMastery;

public class Barbarian extends PlayerClass{
    private Map<Constants.FEATURE, FeatureAbstract> barbarianFeatures = new HashMap<>();

    // Constructor
    public Barbarian(Constants.CLASS playerClass){
        super(playerClass);
        barbarianFeatures.put(Constants.FEATURE.RAGE, new Rage());
        barbarianFeatures.put(Constants.FEATURE.UNARMORED_DEFENSE, new UnarmoredDefense());
        barbarianFeatures.put(Constants.FEATURE.WEAPON_MASTERY, new WeaponMastery());

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

    public Map<Constants.FEATURE, FeatureAbstract> getBarbarianFeatures() {
        return barbarianFeatures;
    }


    public void setBarbarianFeatires(Map<Constants.FEATURE, FeatureAbstract> barbarianFeatires) {
        this.barbarianFeatures = barbarianFeatires;
    }
    


}
