package alan.player_class;

import java.util.HashMap;
import java.util.Map;

import alan.Constants;
import alan.player_class.class_features._ClassFeatureAbstract;
import alan.player_class.class_features.WeaponMastery;

public class Fighter extends PlayerClass{
    private Map<Constants.CLASS_FEATURE, _ClassFeatureAbstract> fighterFeatures = new HashMap<>();
    private Constants.FIGHTING_STYLE fightingStyle;

    public Fighter(Constants.CLASS playerClass){
        super(playerClass);
        fighterFeatures.put(Constants.CLASS_FEATURE.WEAPON_MASTERY, new WeaponMastery());
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

    public void setFightingStyle(){

    }

    @Override
    public void initNewClass() {
        // TODO Auto-generated method stub
        super.initNewClass();
        addWeaponMastery(fighterFeatures, Constants.WEAPON_KEY.BATTLEAXE);
        addWeaponMastery(fighterFeatures, Constants.WEAPON_KEY.GREATSWORD);
        addWeaponMastery(fighterFeatures, Constants.WEAPON_KEY.GREATAXE);
    }
    

    /*
     * Getters and Setters
     */

    public void setFighterFeatures(Map<Constants.CLASS_FEATURE, _ClassFeatureAbstract> fighterFeatures) {
        this.fighterFeatures = fighterFeatures;
    }
    
    public Map<Constants.CLASS_FEATURE, _ClassFeatureAbstract> getFighterFeatures() {
        return fighterFeatures;
    }

    public Constants.FIGHTING_STYLE getFightingStyle() {
        return fightingStyle;
    }

    public void setFightingStyle(Constants.FIGHTING_STYLE fightingStyle) {
        this.fightingStyle = fightingStyle;
    }
    

    

}
