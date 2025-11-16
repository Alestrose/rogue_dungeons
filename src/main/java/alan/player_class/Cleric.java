package alan.player_class;

import java.util.HashMap;
import java.util.Map;

import alan.Constants;
import alan.player_class.class_features.ClassFeatureAbstract;
import alan.spells.SpellAbstract;
import alan.spells.cantrips.Guidance;
import alan.spells.cantrips.SacredFlame;
import alan.spells.cantrips.TollTheDead;
import alan.spells.level_one.Bless;
import alan.spells.level_one.GuidingBolt;
import alan.spells.level_one.Sanctuary;
import alan.spells.level_one.ShieldOfFaith;

public class Cleric extends PlayerClass{
    private Map<Constants.CLASS_FEATURE, ClassFeatureAbstract> clericFeatures = new HashMap<>();
    private Map<Constants.SPELL, SpellAbstract> preparedSpells = new HashMap<>();
    private SpellSlots clericSpellSlots = new SpellSlots();

    public Cleric(Constants.CLASS playerClass){
        super(playerClass);

        // Setting level one spell slots
        clericSpellSlots.setNumKnownCantrips(3);
        clericSpellSlots.setNumPreparedSpells(4);
        clericSpellSlots.setMaxLevelOneSlots(2);
        clericSpellSlots.setCurrentLevelOneSlots(clericSpellSlots.getMaxLevelOneSlots());

        // Setting level one spells (will be done manualy on character building)
        // Cantrips
        preparedSpells.put(Constants.SPELL.GUIDANCE, new Guidance());
        preparedSpells.put(Constants.SPELL.SACRED_FLAME, new SacredFlame());
        preparedSpells.put(Constants.SPELL.TOLL_THE_DEAD, new TollTheDead());
        // Spells
        preparedSpells.put(Constants.SPELL.BLESS, new Bless());
        preparedSpells.put(Constants.SPELL.SANCTUARY, new Sanctuary());
        preparedSpells.put(Constants.SPELL.SHILED_OF_FAITH, new ShieldOfFaith());
        preparedSpells.put(Constants.SPELL.GUIDING_BOLT, new GuidingBolt());

        updatePassives(clericFeatures);
    }

    
    /*
     * Methods
     */

    @Override
    public void onLevelUp(int lvl) {
        
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

    public Map<Constants.CLASS_FEATURE, ClassFeatureAbstract> getClericFeatures() {
        return clericFeatures;
    }

    public void setClericFeatures(Map<Constants.CLASS_FEATURE, ClassFeatureAbstract> clericFeatures) {
        this.clericFeatures = clericFeatures;
    }

    public Map<Constants.SPELL, SpellAbstract> getPreparedSpells() {
        return preparedSpells;
    }

    public void setPreparedSpells(Map<Constants.SPELL, SpellAbstract> preparedSpells) {
        this.preparedSpells = preparedSpells;
    }

    public SpellSlots getClericSpellSlots() {
        return clericSpellSlots;
    }

    public void setClericSpellSlots(SpellSlots clericSpellSlots) {
        this.clericSpellSlots = clericSpellSlots;
    }

}
