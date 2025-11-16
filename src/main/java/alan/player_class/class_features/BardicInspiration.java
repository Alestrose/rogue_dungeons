package alan.player_class.class_features;

import alan.Constants;
import alan.Constants.DAMAGE_TYPE;
import alan.creatures.Creature;
import alan.grid_panel.Cell;

public class BardicInspiration extends ClassFeatureAbstract{
    public int bardicDie = 6;
    
    public BardicInspiration(){
        setClassFeatureKey(Constants.CLASS_FEATURE.BARDIC_INSPIRATION);
        setClassFeatureName();
        setFeatureLevel(1);
        setDuration((byte) 100);
        setBonus(true);
        setActive(true);
    }

    @Override
    public void cast(Creature caster, Creature target, Creature[] targetList, Cell cell, DAMAGE_TYPE damage_type, int spellLevel) {
        target.setHasInspiration(true, getBardicDie());
        setResourceQuanity(getResourceQuanity()-1);
    }

    @Override
    public String descreiption() {
        // TODO Auto-generated method stub
        return "";
    }

    @Override
    public void onLevelUp(int lvl) {
        switch (lvl) {
            case 5 -> {setBardicDie(8); }
            case 10 -> {setBardicDie(10);}
            case 12 -> {setBardicDie(12);}
            default -> {}
        }
        
    }

    public int getBardicDie() {
        return bardicDie;
    }

    public void setBardicDie(int bardicDie) {
        this.bardicDie = bardicDie;
    }

    
}
