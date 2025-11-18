package alan.player_class;

import java.util.HashMap;
import java.util.Map;

import alan.Constants;
import alan.player_class.class_features.ClassFeatureAbstract;

public class Fighter extends PlayerClass{
    private Map<Constants.CLASS_FEATURE, ClassFeatureAbstract> fighterFeatures = new HashMap<>();

    public Fighter(Constants.CLASS playerClass){
        super(playerClass);
    }

    /*
     * Methods
     */

    @Override
    public void onLevelUp() {
        // TODO Auto-generated method stub
        super.onLevelUp();
    }

    @Override
    public void onLongRest() {
        // TODO Auto-generated method stub
        super.onLongRest();
    }

    @Override
    public void onShortRest() {
        // TODO Auto-generated method stub
        super.onShortRest();
    }

    
    

    /*
     * Getters and Setters
     */

    @Override
    public void initNewClass() {
        // TODO Auto-generated method stub
        super.initNewClass();
    }

    public void setFighterFeatures(Map<Constants.CLASS_FEATURE, ClassFeatureAbstract> fighterFeatures) {
        this.fighterFeatures = fighterFeatures;
    }
    
    public Map<Constants.CLASS_FEATURE, ClassFeatureAbstract> getFighterFeatures() {
        return fighterFeatures;
    }

    

    

}
