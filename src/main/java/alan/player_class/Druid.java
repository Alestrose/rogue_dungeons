package alan.player_class;

import java.util.HashMap;
import java.util.Map;

import alan.Constants;
import alan.spells.SpellAbstract;
import alan.spells.cantrips.PoisonSpray;
import alan.spells.cantrips.Shillelagh;
import alan.spells.cantrips.ThornWhip;
import alan.spells.level_one.CharmPerson;
import alan.spells.level_one.Entangle;
import alan.spells.level_one.FogCloud;
import alan.spells.level_one.IceKnife;
import alan.spells.level_one.SpeakWithAnimals;

public class Druid extends PlayerClass{
    private Map<Constants.SPELL, SpellAbstract> preparedSpells = new HashMap<>();
    private SpellSlots druidSpellSlots = new SpellSlots();
    private Constants.PRIMAL_ORDERS primalOrder;

    public Druid(Constants.CLASS playerClass, Constants.PRIMAL_ORDERS primalOrder){
        super(playerClass);
        this.primalOrder = primalOrder;

        // Setting level one spell slots
        druidSpellSlots.setNumKnownCantrips(2);
        druidSpellSlots.setNumPreparedSpells(4);
        druidSpellSlots.setMaxLevelOneSlots(2);
        druidSpellSlots.setCurrentLevelOneSlots(druidSpellSlots.getMaxLevelOneSlots());

        // Setting level one spells (will be done manualy on character building)
        // Cantrips
        preparedSpells.put(Constants.SPELL.GUIDANCE, new ThornWhip());
        preparedSpells.put(Constants.SPELL.SACRED_FLAME, new Shillelagh());
        preparedSpells.put(Constants.SPELL.SACRED_FLAME, new PoisonSpray());
        // Spells
        preparedSpells.put(Constants.SPELL.SACRED_FLAME, new SpeakWithAnimals()); // Always prepared with Druidic Class Feature
        preparedSpells.put(Constants.SPELL.SACRED_FLAME, new CharmPerson());
        preparedSpells.put(Constants.SPELL.SACRED_FLAME, new Entangle());
        preparedSpells.put(Constants.SPELL.SACRED_FLAME, new FogCloud());
        preparedSpells.put(Constants.SPELL.ICE_KNIFE, new IceKnife());
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
    public void initNewClass() {
        super.initNewClass();
        SET_PRIMAL_ORDER();
    }

    public final void SET_PRIMAL_ORDER(){
        switch (getPrimalOrder()) {
            case WARDEN: {
                getOwner().addWeaponProficiency(Constants.WEAPON_PROFICIENCY.MARTIAL);
                getOwner().addArmorProficiency(Constants.ARMOR_PROFICIENCY.MEDIUM);
            }
            case MAGICIAN: {
                druidSpellSlots.setNumKnownCantrips(druidSpellSlots.getNumKnownCantrips()+1);
                getOwner().grantSkillBonus(
                    Constants.SKILL_KEY.NATURE,
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

    public Constants.PRIMAL_ORDERS getPrimalOrder() {
        return primalOrder;
    }

    public void setPrimalOrder(Constants.PRIMAL_ORDERS primalOrder) {
        this.primalOrder = primalOrder;
    }

    
}
