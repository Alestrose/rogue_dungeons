package alan.player_class.classes;

import alan.Constants;
import alan.features.class_features.MartialArts;
import alan.features.class_features.UnarmoredDefense;
import alan.player_class.PlayerClass;

public class Monk extends PlayerClass{

    public Monk(Constants.CLASS playerClass){
        super(playerClass);
        // Level One Class Feats
        grantFeature(Constants.FEATURE.UNARMORED_DEFENSE, new UnarmoredDefense(playerClass));
        grantFeature(Constants.FEATURE.MARTIAL_ARTS, new MartialArts());
    }

    /*
     * Methods
     */

    
    
    @Override
    public void initNewClass() {
        // TODO Auto-generated method stub
        super.initNewClass();  
    }

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
}
