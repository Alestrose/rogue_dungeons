package alan.player_class;

import java.util.HashMap;
import java.util.Map;

import alan.Constants;
import alan.player_class.features.class_features.LayOnHands;
import alan.player_class.features.class_features.WeaponMastery;
import alan.spells.SpellAbstract;
import alan.spells.level_one.CureWounds;
import alan.spells.level_one.DivineSmite;


public class Paladin extends PlayerClass{
    private Map<Constants.SPELL, SpellAbstract> preparedSpells = new HashMap<>();
    private SpellSlots paladinSpellSlots = new SpellSlots();

    public Paladin(Constants.CLASS playerClass){
        super(playerClass);
        grantFeature(Constants.FEATURE.LAY_ON_HANDS, new LayOnHands());
        grantFeature(Constants.FEATURE.WEAPON_MASTERY, new WeaponMastery());
        addWeaponMastery(getFeatures(), Constants.WEAPON_KEY.LONGSWORD);
        addWeaponMastery(getFeatures(), Constants.WEAPON_KEY.LANCE);

        // Setting level one spell slots
        paladinSpellSlots.setNumKnownCantrips(0);
        paladinSpellSlots.setNumPreparedSpells(2);
        paladinSpellSlots.setMaxLevelOneSlots(2);
        paladinSpellSlots.setCurrentLevelOneSlots(paladinSpellSlots.getMaxLevelOneSlots());

        // Setting level one spells (will be done manualy on character building)
        // Spells
        preparedSpells.put(Constants.SPELL.DIVINE_SMITE, new DivineSmite());
        preparedSpells.put(Constants.SPELL.CURE_WOUNDS, new CureWounds());


    }

    /*
     * Methods
     */

    @Override
    public void onLongRest() {
        // TODO Auto-generated method stub
        super.onLongRest();
        paladinSpellSlots.refreshSpellSlots();
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

    public SpellSlots getPaladinSpellSlots() {
        return paladinSpellSlots;
    }

    public void setPaladinSpellSlots(SpellSlots paladinSpellSlots) {
        this.paladinSpellSlots = paladinSpellSlots;
    }

    

    
}
