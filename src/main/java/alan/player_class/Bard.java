package alan.player_class;

import java.util.HashMap;
import java.util.Map;

import alan.Constants;
import alan.player_class.class_features.BardicInspiration;
import alan.player_class.class_features.ClassFeatureAbstract;
import alan.spells.SpellAbstract;
import alan.spells.cantrips.MageHand;
import alan.spells.cantrips.ViciousMockery;
import alan.spells.level_one.Bane;
import alan.spells.level_one.Command;
import alan.spells.level_one.HealingWord;
import alan.spells.level_one.Thunderwave;

public class Bard extends PlayerClass{
    private Map<Constants.CLASS_FEATURE, ClassFeatureAbstract> bardFeatures = new HashMap<>();
    private Map<Constants.SPELL, SpellAbstract> preparedSpells = new HashMap<>();
    private SpellSlots bardSpellSlots = new SpellSlots();
    

    // Spell Slots

    public Bard(Constants.CLASS playerClass){
        super(playerClass);

        // Setting level one spell slots
        bardSpellSlots.setNumKnownCantrips(2);
        bardSpellSlots.setNumPreparedSpells(4);
        bardSpellSlots.setMaxLevelOneSlots(2);
        bardSpellSlots.setCurrentLevelOneSlots(bardSpellSlots.getMaxLevelOneSlots());

        // Setting level one spells (will be done manualy on character building)
        preparedSpells.put(Constants.SPELL.VICIOUS_MOCKERY, new ViciousMockery());
        preparedSpells.put(Constants.SPELL.MAGE_HAND, new MageHand());
        preparedSpells.put(Constants.SPELL.COMMAND, new Command());
        preparedSpells.put(Constants.SPELL.BANE, new Bane());
        preparedSpells.put(Constants.SPELL.HEALING_WORD, new HealingWord());
        preparedSpells.put(Constants.SPELL.THUNDERWAVE, new Thunderwave());

        // Setting level one class features
        bardFeatures.put(Constants.CLASS_FEATURE.BARDIC_INSPIRATION, new BardicInspiration());

        // Setting starting uses of inspiration
        setInspirationQuantity();

        // Applies or updates class passive features
        updatePassives(bardFeatures);
    }

    /*
     * Methods
     */

    @Override
    public void onLevelUp(int lvl) {
        
    }
    
    @Override
    public void onShortRest(){
        setInspirationQuantity();
    }

    @Override
    public void onLongRest(){
        setInspirationQuantity();
    }

    public final void setInspirationQuantity(){
        bardFeatures.get(Constants.CLASS_FEATURE.BARDIC_INSPIRATION).setResourceQuanity(getOwner().getAbilities().get(Constants.ABILITY.DEXTERITY).getAbilityMod());
    }

    /*
     * Getters and Setters
     * 
     */

    public Map<Constants.CLASS_FEATURE, ClassFeatureAbstract> getBardFeatures() {
        return bardFeatures;
    }

    public void setBardFeatures(Map<Constants.CLASS_FEATURE, ClassFeatureAbstract> bardFeatures) {
        this.bardFeatures = bardFeatures;
    }

    public SpellSlots getBardSpellSlots() {
        return bardSpellSlots;
    }

    public void setBardSpellSlots(SpellSlots bardSpellSlots) {
        this.bardSpellSlots = bardSpellSlots;
    }

    public Map<Constants.SPELL, SpellAbstract> getPreparedSpells() {
        return preparedSpells;
    }

    public void setKnownSpells(Map<Constants.SPELL, SpellAbstract> preparedSpells) {
        this.preparedSpells = preparedSpells;
    }

    
}
