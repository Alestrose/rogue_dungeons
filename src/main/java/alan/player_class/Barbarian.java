package alan.player_class;

import java.util.Map;

import alan.Constants;
import alan.player_class.class_features.ClassFeatureAbstract;
import alan.player_class.class_features.Rage;

public class Barbarian extends PlayerClass{
    private Map<Constants.CLASS_FEATURE, ClassFeatureAbstract> barbarianFeatures;

    private int resourceRage = 0;

    // Constructor
    public Barbarian(Constants.CLASS playerClass){
        super(playerClass);
        barbarianFeatures.put(Constants.CLASS_FEATURE.RAGE, new Rage());
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


    public int getResourceRage() {
        return resourceRage;
    }


    public void setResourceRage(int resourceRage) {
        this.resourceRage = resourceRage;
    }

    


}
