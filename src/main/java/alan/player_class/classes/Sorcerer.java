package alan.player_class.classes;

import java.util.HashMap;
import java.util.Map;

import alan.Constants;
import alan.player_class.PlayerClass;
import alan.player_class.SpellSlots;
import alan.player_class.features.class_features.InnateSorcery;
import alan.spells.SpellAbstract;
import alan.spells.cantrips.FireBolt;
import alan.spells.cantrips.RayOfFrost;
import alan.spells.cantrips.ShockingGrasp;
import alan.spells.cantrips.TrueStrike;
import alan.spells.level_one.IceKnife;
import alan.spells.level_one.MageArmor;

public class Sorcerer extends PlayerClass{
    private Map<Constants.SPELL, SpellAbstract> preparedSpells = new HashMap<>();
    private SpellSlots sorcererSpellSlots = new SpellSlots();

    public Sorcerer(Constants.CLASS playerClass) {
        super(playerClass);

        // Level One Class Feats
        grantFeature(Constants.FEATURE.INNATE_SORCERY, new InnateSorcery());

        // Setting level one spell slots
        sorcererSpellSlots.setNumKnownCantrips(4);
        sorcererSpellSlots.setNumPreparedSpells(4);
        sorcererSpellSlots.setMaxLevelOneSlots(2);
        sorcererSpellSlots.setCurrentLevelOneSlots(sorcererSpellSlots.getMaxLevelOneSlots());

        // Setting level one spells (will be done manualy on character building)
        preparedSpells.put(Constants.SPELL.FIRE_BOLT, new FireBolt());
        preparedSpells.put(Constants.SPELL.SHOCKING_GRASP, new ShockingGrasp());
        preparedSpells.put(Constants.SPELL.RAY_OF_FROST, new RayOfFrost());
        preparedSpells.put(Constants.SPELL.TRUE_STRIKE, new TrueStrike());
        preparedSpells.put(Constants.SPELL.MAGE_ARMOR, new MageArmor());
        preparedSpells.put(Constants.SPELL.ICE_KNIFE, new IceKnife());

    }
    /*
     * Methods
     */

    @Override
    public void onLevelUp() {
        super.onLevelUp();
    }
    
    @Override
    public void onShortRest(){
        super.onShortRest();
    }

    @Override
    public void onLongRest(){
        super.onLongRest();
        sorcererSpellSlots.refreshSpellSlots();
    }

    @Override
    public void initNewClass(){
        super.initNewClass();
    }

    /*
        Getters and Setters
     */

    public Map<Constants.SPELL, SpellAbstract> getPreparedSpells() {
        return preparedSpells;
    }

    public void setPreparedSpells(Map<Constants.SPELL, SpellAbstract> preparedSpells) {
        this.preparedSpells = preparedSpells;
    }

    public SpellSlots getSorcererSpellSlots() {
        return sorcererSpellSlots;
    }

    public void setSorcererSpellSlots(SpellSlots sorcererSpellSlots) {
        this.sorcererSpellSlots = sorcererSpellSlots;
    }

    
}
