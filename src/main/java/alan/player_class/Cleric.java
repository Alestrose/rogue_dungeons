package alan.player_class;

import java.util.HashMap;
import java.util.Map;

import alan.Constants;
import alan.player_class.class_features.FeatureAbstract;
import alan.spells.SpellAbstract;
import alan.spells.cantrips.Guidance;
import alan.spells.cantrips.SacredFlame;
import alan.spells.cantrips.TollTheDead;
import alan.spells.level_one.Bless;
import alan.spells.level_one.GuidingBolt;
import alan.spells.level_one.Sanctuary;
import alan.spells.level_one.ShieldOfFaith;

public class Cleric extends PlayerClass{
    private Map<Constants.FEATURE, FeatureAbstract> clericFeatures = new HashMap<>();
    private Map<Constants.SPELL, SpellAbstract> preparedSpells = new HashMap<>();
    private SpellSlots clericSpellSlots = new SpellSlots();
    private Constants.DIVINE_ORDERS divineOrder;

    public Cleric(Constants.CLASS playerClass, Constants.DIVINE_ORDERS divineOrder){
        super(playerClass);
        this.divineOrder = divineOrder;

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
        
    }

    
    /*
     * Methods
     */

    @Override
    public void onLevelUp() {
        
    }
    
    @Override
    public void onShortRest(){

    }

    @Override
    public void onLongRest(){
        
    }

    @Override
    public void initNewClass(){
        SET_DIVINE_ORDER();
    }

    public final void SET_DIVINE_ORDER(){
        switch (getDivineOrder()) {
            case PROTECTOR: {
                getOwner().addWeaponProficiency(Constants.WEAPON_PROFICIENCY.MARTIAL);
                getOwner().addArmorProficiency(Constants.ARMOR_PROFICIENCY.HEAVY);
            }
            case THAUMATURGE: {
                clericSpellSlots.setNumKnownCantrips(clericSpellSlots.getNumKnownCantrips()+1);
                getOwner().grantSkillBonus(
                    Constants.SKILL_KEY.ARCANA,
                    getOwner().getAbilities().get(Constants.ABILITY.WISDOM).getAbilityMod());
            }
                
                break;
            default:
                throw new AssertionError();
        }
    }
    

    /*
     * Getters and Setters
     */

    public Map<Constants.FEATURE, FeatureAbstract> getClericFeatures() {
        return clericFeatures;
    }

    public void setClericFeatures(Map<Constants.FEATURE, FeatureAbstract> clericFeatures) {
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

    public Constants.DIVINE_ORDERS getDivineOrder() {
        return divineOrder;
    }

    public void setDivineOrder(Constants.DIVINE_ORDERS divineOrder) {
        this.divineOrder = divineOrder;
    }

    
}
