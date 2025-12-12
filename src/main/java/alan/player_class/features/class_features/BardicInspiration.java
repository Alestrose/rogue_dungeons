package alan.player_class.features.class_features;

import alan.Constants;
import alan.Constants.DAMAGE_TYPE;
import alan.creatures.Creature;
import alan.grid_panel.Cell;
import alan.player_class.features.FeatureAbstract;

public class BardicInspiration extends FeatureAbstract{
    public int bardicDie = 6;
    
    public BardicInspiration(){
        setClassFeatureKey(Constants.FEATURE.BARDIC_INSPIRATION);
        setClassFeatureName();
        setFeatureLevel(1);
        setDuration((byte) 100);
        setBonus(true);
        setActive(true);
        setFeatType(Constants.FEAT_TYPE.CLASS);
    }

    @Override
    public void cast(Creature caster, Creature target, Creature[] targetList, Cell cell, DAMAGE_TYPE damage_type, int spellLevel) {
        target.setHasInspiration(true, getBardicDie());
        setResourceQuanity(getResourceQuanity()-1);
    }

    @Override
    public String descreiption() {
        return """
               You can supernaturally inspire others through\r
               words, music, or dance. This inspiration is repre-\r
               sented by your Bardic Inspiration die, which is a d6.\r
               Using Bardic Inspiration. As a Bonus Action, you\r
               can inspire another creature within 60 feet of your-\r
               self who can see or hear you. That creature gains\r
               one of your Bardic Inspiration dice. A creature can\r
               have only one Bardic Inspiration die at a time.\r
               Once within the next hour when the creature fails\r
               a D20 Test, the creature can roll the Bardic Inspira-\r
               tion die and add the number rolled to the d20, po-\r
               tentially turning the failure into a success. A Bardic\r
               Inspiration die is expended when it's rolled.\r
               Number of Uses. You can confer a Bardic Inspira-\r
               tion die a number of times equal to your Charisma\r
               modifier (minimum of once), and you regain all ex-\r
               pended uses when you finish a Long Rest.\r
               At Higher Levels. Your Bardic Inspiration die\r
               changes when you reach certain Bard levels, as\r
               shown in the Bardic Die column of the Bard Fea-\r
               tures table. The die becomes a d8 at level 5, a dlO at\r
               level 10, and a d12 at level 15""" //
        //
        //
        //
        //
        //
        //
        //
        //
        //
        //
        //
        //
        //
        //
        //
        //
        //
        //
        //
        //
        ;
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
