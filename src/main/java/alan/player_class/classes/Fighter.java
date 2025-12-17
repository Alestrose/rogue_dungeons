package alan.player_class.classes;

import alan.Constants;
import alan.features.class_features.SecondWind;
import alan.features.class_features.WeaponMastery;
import alan.features.fighting_style_features.Defense;
import alan.player_class.PlayerClass;


public class Fighter extends PlayerClass{

    public Fighter(Constants.CLASS playerClass){
        super(playerClass);
        // Level One Class Feats
        grantFeature(Constants.FEATURE.WEAPON_MASTERY, new WeaponMastery());
        grantFeature(Constants.FEATURE.DEFENSE, new Defense());
        grantFeature(Constants.FEATURE.SECOND_WIND, new SecondWind());
        getFeatures().get(Constants.FEATURE.WEAPON_MASTERY).setResourceQuanity(3);
        addWeaponMastery(getFeatures(), Constants.WEAPON_KEY.LONGBOW);
        addWeaponMastery(getFeatures(), Constants.WEAPON_KEY.GREATSWORD);
        addWeaponMastery(getFeatures(), Constants.WEAPON_KEY.LONGSWORD);
    }
    
    /*
     * Methods
     */

    @Override
    public void onLongRest() {
        // TODO Auto-generated method stub
        super.onLongRest();
    }

    @Override
    public void onLevelUp() {
        // TODO Auto-generated method stub
        super.onLevelUp();
    }

    @Override
    public void onShortRest() {
        // TODO Auto-generated method stub
        super.onShortRest();
    }

    @Override
    public void initNewClass() {
        // TODO Auto-generated method stub
        super.initNewClass();  
    }
    

    /*
     * Getters and Setters
     */


    

}
