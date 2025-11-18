package alan.player_class;

import java.util.HashMap;
import java.util.Map;

import alan.Constants;
import alan.player_class.class_features.ClassFeatureAbstract;
import alan.spells.SpellAbstract;
import alan.spells.cantrips.Shillelagh;
import alan.spells.cantrips.ThornWhip;
import alan.spells.level_one.CharmPerson;
import alan.spells.level_one.Entangle;
import alan.spells.level_one.FogCloud;
import alan.spells.level_one.SpeakWithAnimals;

public class Druid extends PlayerClass{
    private Map<Constants.CLASS_FEATURE, ClassFeatureAbstract> druidFeatures = new HashMap<>();
    private Map<Constants.SPELL, SpellAbstract> preparedSpells = new HashMap<>();
    private SpellSlots druidSpellSlots = new SpellSlots();

    public Druid(Constants.CLASS playerClass){
        super(playerClass);

        // Setting level one spell slots
        druidSpellSlots.setNumKnownCantrips(2);
        druidSpellSlots.setNumPreparedSpells(4);
        druidSpellSlots.setMaxLevelOneSlots(2);
        druidSpellSlots.setCurrentLevelOneSlots(druidSpellSlots.getMaxLevelOneSlots());

        // Setting level one spells (will be done manualy on character building)
        // Cantrips
        preparedSpells.put(Constants.SPELL.GUIDANCE, new ThornWhip());
        preparedSpells.put(Constants.SPELL.SACRED_FLAME, new Shillelagh());
        // Spells
        preparedSpells.put(Constants.SPELL.SACRED_FLAME, new CharmPerson());
        preparedSpells.put(Constants.SPELL.SACRED_FLAME, new SpeakWithAnimals());
        preparedSpells.put(Constants.SPELL.SACRED_FLAME, new Entangle());
        preparedSpells.put(Constants.SPELL.SACRED_FLAME, new FogCloud());

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

    public Map<Constants.CLASS_FEATURE, ClassFeatureAbstract> getDruidFeatures() {
        return druidFeatures;
    }

    public void setDruidFeatures(Map<Constants.CLASS_FEATURE, ClassFeatureAbstract> druidFeatures) {
        this.druidFeatures = druidFeatures;
    }

    public Map<Constants.SPELL, SpellAbstract> getPreparedSpells() {
        return preparedSpells;
    }

    public void setPreparedSpells(Map<Constants.SPELL, SpellAbstract> preparedSpells) {
        this.preparedSpells = preparedSpells;
    }

    public SpellSlots getDruidSpellSlots() {
        return druidSpellSlots;
    }

    public void setDruidSpellSlots(SpellSlots druidSpellSlots) {
        this.druidSpellSlots = druidSpellSlots;
    }

    
}
