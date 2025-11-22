package alan.player_class.features.fighting_style_features;

import alan.Constants;
import alan.Constants.DAMAGE_TYPE;
import alan.creatures.ArmorClass;
import alan.creatures.Creature;
import alan.creatures.PlayableCharacter;
import alan.grid_panel.Cell;
import alan.player_class.features.FeatureAbstract;

public class Defense extends FeatureAbstract{
    private int bonusToAC = 1;

    public Defense(){
        setClassFeatureKey(Constants.FEATURE.DEFENSE);
        setClassFeatureName();
        setFeatureLevel(1);
        setPassive(true);
        setFeatType(Constants.FEAT_TYPE.FIGHTING_STYLE);
    }

    @Override
    public void update(Creature owner) {
        // TODO Auto-generated method stub
        super.update(owner);
        if (owner instanceof PlayableCharacter pc) {
            ArmorClass ac = pc.getArmorClass();
            ac.setHasDefenseFeat(true);
        } else {
            System.out.println("This creature does not have ArmorClass.");
        }
    }

    @Override
    public void cast(Creature caster, Creature target, Creature[] targetList, Cell cell, DAMAGE_TYPE damage_type,
            int spellLevel) {
        if (caster instanceof PlayableCharacter pc) {
            ArmorClass ac = pc.getArmorClass();
            ac.setHasDefenseFeat(true);
        } else {
            System.out.println("This creature does not have ArmorClass.");
        }
        
    }

    @Override
    public String descreiption() {
        // TODO Auto-generated method stub
        return """
               While you're wearing Light, Medium, or Heavy ar-\r
               mor, you gain a +1 bonus to Armor Class.""" //
        ;
    }

    /*
        Getters and Setters
     */

    public int getBonusToAC() {
        return bonusToAC;
    }

    public void setBonusToAC(int bonusToAC) {
        this.bonusToAC = bonusToAC;
    }

}
