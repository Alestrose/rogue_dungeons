package alan.player_class;

import java.util.HashMap;
import java.util.Map;

import alan.Constants;
import alan.player_class.features.FeatureAbstract;
import alan.player_class.features.class_features.WeaponMastery;
import alan.player_class.features.fighting_style_features.Defense;

public class Fighter extends PlayerClass{
    private Map<Constants.FEATURE, FeatureAbstract> fighterFeatures = new HashMap<>();

    public Fighter(Constants.CLASS playerClass){
        super(playerClass);
        
    }
    
    /*
     * Methods
     */

    @Override
    public void onLevelUp() {
        // TODO Auto-generated method stub
        
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

    public void setFightingStyle(){

    }

    @Override
    public void initNewClass() {
        // TODO Auto-generated method stub
        super.initNewClass();
        grantFeature(Constants.FEATURE.WEAPON_MASTERY, new WeaponMastery());
        grantFeature(Constants.FEATURE.DEFENSE, new Defense());
        addWeaponMastery(getFeatures(), Constants.WEAPON_KEY.BATTLEAXE);
        addWeaponMastery(getFeatures(), Constants.WEAPON_KEY.GREATSWORD);
        addWeaponMastery(getFeatures(), Constants.WEAPON_KEY.GREATAXE);
        
    }
    

    /*
     * Getters and Setters
     */

    public void setFighterFeatures(Map<Constants.FEATURE, FeatureAbstract> fighterFeatures) {
        this.fighterFeatures = fighterFeatures;
    }
    
    public Map<Constants.FEATURE, FeatureAbstract> getFighterFeatures() {
        return fighterFeatures;
    }


    

}
