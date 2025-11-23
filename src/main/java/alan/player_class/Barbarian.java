package alan.player_class;

import alan.Constants;
import alan.player_class.features.class_features.Rage;
import alan.player_class.features.class_features.UnarmoredDefense;
import alan.player_class.features.class_features.WeaponMastery;

public class Barbarian extends PlayerClass{

    // Constructor
    public Barbarian(Constants.CLASS playerClass){
        super(playerClass);
        // Level One Class Feats
        grantFeature(Constants.FEATURE.RAGE, new Rage());
        grantFeature(Constants.FEATURE.UNARMORED_DEFENSE, new UnarmoredDefense(playerClass));
        grantFeature(Constants.FEATURE.WEAPON_MASTERY, new WeaponMastery());
        addWeaponMastery(getFeatures(), Constants.WEAPON_KEY.GREATSWORD);
        addWeaponMastery(getFeatures(), Constants.WEAPON_KEY.GREATAXE);
        
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
    


}
