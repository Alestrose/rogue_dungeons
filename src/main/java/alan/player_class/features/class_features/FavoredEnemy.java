package alan.player_class.features.class_features;

import alan.Constants;
import alan.Constants.DAMAGE_TYPE;
import alan.creatures.Creature;
import alan.grid_panel.Cell;
import alan.player_class.features.FeatureAbstract;
import alan.spells.level_one.HuntersMark;

public class FavoredEnemy extends FeatureAbstract{
    private HuntersMark huntersMark = new HuntersMark();

    public FavoredEnemy() {
        setClassFeatureKey(Constants.FEATURE.FAVORED_ENEMY);
        setClassFeatureName();
        setFeatureLevel(1);
        setActive(true);
        setBonus(true);
        setFeatType(Constants.FEAT_TYPE.CLASS);
        setResourceQuanity(2);
    }

    @Override
    public void cast(Creature caster, Creature target, Creature[] targetList, Cell cell, DAMAGE_TYPE damage_type,
            int spellLevel) {
        // TODO Auto-generated method stub
        if(getResourceQuanity() > 0){
            huntersMark.cast(caster, target, targetList, cell, damage_type, spellLevel);
        } else System.err.println("No remaining free uses available. Take a long rest to refresh");

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
    }

    @Override
    public String descreiption() {
        // TODO Auto-generated method stub
        return """
               You always have the Hunter's Mark spell prepared.\r
               You can cast it twice without expending a spell\r
               slot, and you regain all expended uses of this ability\r
               when you finish a Long Rest.\r
               The number of times you can cast the spell with-\r
               out a spell slot increases when you reach certain\r
               Ranger levels, as shown in the Favored Enemy col-\r
               umn of the Ranger Features table""" //
        //
        //
        //
        //
        //
        //
        ;
    }

    
}
