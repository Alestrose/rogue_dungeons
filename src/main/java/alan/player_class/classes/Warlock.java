package alan.player_class.classes;

import java.util.HashMap;
import java.util.Map;

import alan.Constants;
import alan.player_class.PlayerClass;
import alan.player_class.SpellSlots;
import alan.spells.SpellAbstract;
import alan.spells.cantrips.EldritchBlast;
import alan.spells.cantrips.PoisonSpray;
import alan.spells.level_one.CharmPerson;
import alan.spells.level_one.Hex;

public class Warlock extends PlayerClass{
    private Map<Constants.SPELL, SpellAbstract> preparedSpells = new HashMap<>();
    private SpellSlots warlockSpellSlots = new SpellSlots();

    public Warlock(Constants.CLASS playerClass) {
        super(playerClass);

        // Level One Class Feats

        // Setting level one spell slots
        warlockSpellSlots.setNumKnownCantrips(2);
        warlockSpellSlots.setNumPreparedSpells(2);
        warlockSpellSlots.setMaxLevelWarlockSlots(1);
        warlockSpellSlots.setCurrentLevelOneSlots(warlockSpellSlots.getMaxLevelOneSlots());
        warlockSpellSlots.setWarlockSpellLevel(1);

        // Setting level one spells (will be done manualy on character building)
        preparedSpells.put(Constants.SPELL.ELDRITCH_BLAST, new EldritchBlast());
        preparedSpells.put(Constants.SPELL.POISON_SPRAY, new PoisonSpray());
        preparedSpells.put(Constants.SPELL.HEX, new Hex());
        preparedSpells.put(Constants.SPELL.CHARM_PERSON, new CharmPerson());
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
        warlockSpellSlots.refreshSpellSlots();
    }

    @Override
    public void onLongRest(){
        super.onLongRest();
        warlockSpellSlots.refreshSpellSlots();
    }

    @Override
    public void initNewClass(){
        super.initNewClass();
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



    public SpellSlots getWarlockSpellSlots() {
        return warlockSpellSlots;
    }



    public void setWarlockSpellSlots(SpellSlots warlockSpellSlots) {
        this.warlockSpellSlots = warlockSpellSlots;
    }

    

    

}
