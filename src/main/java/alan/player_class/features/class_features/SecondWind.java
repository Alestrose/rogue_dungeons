package alan.player_class.features.class_features;

import alan.Constants;
import alan.Constants.DAMAGE_TYPE;
import alan.creatures.Creature;
import alan.grid_panel.Cell;
import alan.player_class.features.FeatureAbstract;

public class SecondWind extends FeatureAbstract{

    public SecondWind(){
        setClassFeatureKey(Constants.FEATURE.SECOND_WIND);
        setClassFeatureName();
        setFeatureLevel(1);
        setActive(true);
        setBonus(true);
        setFeatType(Constants.FEAT_TYPE.CLASS);
        setResourceQuanity(2);
        setDamageDie(10);
        setQuantityOfDie(1);
    }

    @Override
    public void cast(Creature caster, Creature target, Creature[] targetList, Cell cell, DAMAGE_TYPE damage_type,
            int spellLevel) {
        if(getResourceQuanity() > 0) caster.healHealth(rollDamage(getDamageDie(), getQuantityOfDie()) + caster.getPrimaryClass().getClassLevel());
        else System.err.println(caster.getPrimaryClass() + ": " + caster.getName() + " has no available uses left. Short or long rest to regain this resource");
        
    }

    @Override
    public void onLongRest() {
        // TODO Auto-generated method stub
        super.onLongRest();
        setResourceQuanity(2);
    }

    @Override
    public void onShortRest() {
        // TODO Auto-generated method stub
        super.onShortRest();
        if(getResourceQuanity() < 2) setResourceQuanity(getResourceQuanity()+1);
        
    }

    


}
