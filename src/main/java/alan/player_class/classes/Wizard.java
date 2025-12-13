package alan.player_class.classes;

import java.util.HashMap;
import java.util.Map;

import alan.Constants;
import alan.player_class.PlayerClass;
import alan.player_class.SpellSlots;
import alan.spells.SpellAbstract;
import alan.spells.cantrips.FireBolt;
import alan.spells.cantrips.Light;
import alan.spells.cantrips.RayOfFrost;
import alan.spells.level_one.IceKnife;
import alan.spells.level_one.Identify;
import alan.spells.level_one.MageArmor;
import alan.spells.level_one.MagicMissile;
import alan.spells.level_one.Shield;
import alan.spells.level_one.TashasHideousLaughter;

public class Wizard extends PlayerClass{
    private Map<Constants.SPELL, SpellAbstract> preparedSpells = new HashMap<>();
    private Map<Constants.SPELL, SpellAbstract> spellBook = new HashMap<>();
    private SpellSlots wizardSpellSlots = new SpellSlots();

    public Wizard(Constants.CLASS playerClass) {
        super(playerClass);

        // Level One Class Feats

        // Setting level one spell slots
        wizardSpellSlots.setNumKnownCantrips(3);
        wizardSpellSlots.setNumPreparedSpells(4);
        wizardSpellSlots.setMaxLevelOneSlots(2);
        wizardSpellSlots.setCurrentLevelOneSlots(wizardSpellSlots.getMaxLevelOneSlots());

        // Setting level one spells (will be done manualy on character building)
        // Spell Book
        spellBook.put(Constants.SPELL.SHILED, new Shield());
        spellBook.put(Constants.SPELL.MAGIC_MISSILE, new MagicMissile());
        spellBook.put(Constants.SPELL.MAGE_ARMOR, new MageArmor());
        spellBook.put(Constants.SPELL.IDENTIFY, new Identify());
        spellBook.put(Constants.SPELL.TASHAS_HIDEOUS_LAUGHTER, new TashasHideousLaughter());
        spellBook.put(Constants.SPELL.ICE_KNIFE, new IceKnife());

        // Prepared spells
        preparedSpells.put(Constants.SPELL.LIGHT, new Light());
        preparedSpells.put(Constants.SPELL.FIRE_BOLT, new FireBolt());
        preparedSpells.put(Constants.SPELL.RAY_OF_FROST, new RayOfFrost());
        preparedSpells.put(Constants.SPELL.SHILED, new Shield());
        preparedSpells.put(Constants.SPELL.MAGE_ARMOR, new MageArmor());
        preparedSpells.put(Constants.SPELL.MAGIC_MISSILE, new MagicMissile());
        preparedSpells.put(Constants.SPELL.TASHAS_HIDEOUS_LAUGHTER, new TashasHideousLaughter());
    }

    /*
     * Methods
     */

    @Override
    public void onLevelUp() {
        // TODO Auto-generated method stub
        super.onLevelUp();
    }

    @Override
    public void onLongRest() {
        super.onLongRest();
        wizardSpellSlots.refreshSpellSlots();
    }

    @Override
    public void onShortRest() {
        // Arcane Recovery
        /*  You can regain some of your magical energy by
            studying your spellbook. When you finish a Short
            Rest, you can choose expended spell slots to recover.
            The spell slots can have a combined level equal to no
            more than half your Wizard level {round up), and
            none of the slots can be level 6 or higher. For exam-
            ple, if you're a level 4 Wizard, you can recover up to
            two levels' worth of spell slots, regaining either one
            level 2 spell slot or two level 1 spell slots.
            Once you use this feature, you can't do so again
            until you finish a Long Rest.
         */
        int spellReovery = (int)Math.ceil(this.getClassLevel()/2.0);
        // Will require complete refactoring for levels over one to choose which spell slot level to recover
        if (wizardSpellSlots.getCurrentLevelOneSlots() < wizardSpellSlots.getMaxLevelOneSlots()) {
            wizardSpellSlots.setCurrentLevelOneSlots(wizardSpellSlots.getCurrentLevelOneSlots() + spellReovery);
        }
        super.onShortRest();
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

    public Map<Constants.SPELL, SpellAbstract> getSpellBook() {
        return spellBook;
    }

    public void setSpellBook(Map<Constants.SPELL, SpellAbstract> spellBook) {
        this.spellBook = spellBook;
    }

    public SpellSlots getWizardSpellSlots() {
        return wizardSpellSlots;
    }

    public void setWizardSpellSlots(SpellSlots wizardSpellSlots) {
        this.wizardSpellSlots = wizardSpellSlots;
    }


}
