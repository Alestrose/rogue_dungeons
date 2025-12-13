package alan.player_class.classes;

import alan.Constants;
import alan.player_class.PlayerClass;
import alan.player_class.features.class_features.WeaponMastery;
public class Rogue extends PlayerClass{

    public Rogue(Constants.CLASS playerClass) {
        super(playerClass);
        grantFeature(Constants.FEATURE.WEAPON_MASTERY, new WeaponMastery());
        addWeaponMastery(getFeatures(), Constants.WEAPON_KEY.SHORTSWORD);
        addWeaponMastery(getFeatures(), Constants.WEAPON_KEY.SCIMITAR);

    }
}
