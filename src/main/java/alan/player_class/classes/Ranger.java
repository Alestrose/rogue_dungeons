package alan.player_class.classes;

import java.util.HashMap;
import java.util.Map;

import alan.Constants;
import alan.features.class_features.FavoredEnemy;
import alan.features.class_features.WeaponMastery;
import alan.player_class.PlayerClass;
import alan.player_class.SpellSlots;
import alan.spells.SpellAbstract;
import alan.spells.level_one.FogCloud;
import alan.spells.level_one.HuntersMark;
import alan.spells.level_one.Longstrider;

public class Ranger extends PlayerClass{
    private Map<Constants.SPELL, SpellAbstract> preparedSpells = new HashMap<>();
    private Map<Constants.SPELL, SpellAbstract> alwaysPreparedSpells = new HashMap<>();
    private SpellSlots RangerSpellSlots = new SpellSlots();

    public Ranger(Constants.CLASS playerClass) {
        super(playerClass);
        grantFeature(Constants.FEATURE.FAVORED_ENEMY, new FavoredEnemy());
        grantFeature(Constants.FEATURE.WEAPON_MASTERY, new WeaponMastery());
        addWeaponMastery(getFeatures(), Constants.WEAPON_KEY.SHORTSWORD);
        addWeaponMastery(getFeatures(), Constants.WEAPON_KEY.SCIMITAR);

        // Setting level one spell slots
        RangerSpellSlots.setNumKnownCantrips(0);
        RangerSpellSlots.setNumPreparedSpells(2);
        RangerSpellSlots.setMaxLevelOneSlots(2);
        RangerSpellSlots.setCurrentLevelOneSlots(RangerSpellSlots.getMaxLevelOneSlots());

        // Setting level one spells (will be done manualy on character building)
        // Spells
        alwaysPreparedSpells.put(Constants.SPELL.HUNTERS_MARK, new HuntersMark());
        preparedSpells.put(Constants.SPELL.FOG_CLOUD, new FogCloud());
        preparedSpells.put(Constants.SPELL.LONGSTRIDER, new Longstrider());

    }

    /*
        Methods
     */

    @Override
    public void onLongRest() {
        // TODO Auto-generated method stub
        super.onLongRest();
        RangerSpellSlots.refreshSpellSlots();
    }

    @Override
    public void onLevelUp() {
        // TODO Auto-generated method stub
        super.onLevelUp();
    }

    @Override
    public void onShortRest() {
        // TODO Auto-generated method stub
        super.onShortRest();
    }

    @Override
    public void initNewClass() {
        // TODO Auto-generated method stub
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

    public SpellSlots getRangerSpellSlots() {
        return RangerSpellSlots;
    }

    public void setRangerSpellSlots(SpellSlots rangerSpellSlots) {
        RangerSpellSlots = rangerSpellSlots;
    }

    public Map<Constants.SPELL, SpellAbstract> getAlwaysPreparedSpells() {
        return alwaysPreparedSpells;
    }

    public void setAlwaysPreparedSpells(Map<Constants.SPELL, SpellAbstract> alwaysPreparedSpells) {
        this.alwaysPreparedSpells = alwaysPreparedSpells;
    }

    
    
}
