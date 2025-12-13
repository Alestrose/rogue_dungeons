package alan.player_class.features.eldritch_invocations;

import java.util.HashMap;
import java.util.Map;

import alan.Constants;
import alan.Constants.DAMAGE_TYPE;
import alan.creatures.Creature;
import alan.grid_panel.Cell;
import alan.player_class.SpellSlots;
import alan.player_class.features.FeatureAbstract;
import alan.spells.SpellAbstract;
import alan.spells.cantrips.BladeWard;
import alan.spells.cantrips.MageHand;
import alan.spells.cantrips.MinorIllusion;
import alan.spells.level_one.ComprehendLanguages;
import alan.spells.level_one.SpeakWithAnimals;

public class PactOfTheTome extends FeatureAbstract{
    private final Map<Constants.SPELL, SpellAbstract> pactTomeSpells = new HashMap<>();
    SpellSlots pactTomeSpellSlots = new SpellSlots();

    public PactOfTheTome() {
        setClassFeatureKey(Constants.FEATURE.PACT_OF_THE_TOME);
        setPassive(true);
        setFeatureLevel(1);
        setFeatType(Constants.FEAT_TYPE.ELDRITCH_INVOCATION);

        pactTomeSpellSlots.setMaxLevelOneSlots(2);
        pactTomeSpellSlots.setNumKnownCantrips(3);
        pactTomeSpells.put(Constants.SPELL.MAGE_HAND, new MageHand());
        pactTomeSpells.put(Constants.SPELL.MINOR_ILLUSION, new MinorIllusion());
        pactTomeSpells.put(Constants.SPELL.BLADE_WARD, new BladeWard());
        pactTomeSpells.put(Constants.SPELL.SPEAK_WITH_ANIMALS, new SpeakWithAnimals());
        pactTomeSpells.put(Constants.SPELL.COMPREHEND_LANGUAGES, new ComprehendLanguages());
    }

    @Override
    public void cast(Creature caster, Creature target, Creature[] targetList, Cell cell, DAMAGE_TYPE damage_type,
            int spellLevel) {
        
        
    }

    @Override
    public String descreiption() {
        return """
               Stitching together strands of shadow, you conjure\r
               forth a book in your hand at the end of a Short or\r
               Long Rest. This Book of Shadows (you determine its\r
               appearance) contains eldritch magic that only you\r
               can access, granting you the benefits below. The\r
               book disappears if you conjure another book with\r
               this feature or if you die.\r
               Cantrips and Rituals. When the book appears,\r
               choose three cantrips, and choose two level 1 spells\r
               that have the Ritual tag. The spells can be from any\r
               class's spell list, and they must be spells you don't\r
               already have prepared. While the book is on your\r
               person, you have the chosen spells prepared, and\r
               they function as Warlock spells for you.\r
               Spellcasting Focus. You can use the book as a\r
               Spellcasting Focus.""" //
        //
        //
        //
        //
        //
        //
        //
        //
        //
        //
        //
        //
        //
        //
        ;
    }

    public Map<Constants.SPELL, SpellAbstract> getSpells(){


        return pactTomeSpells;
    }

    

}
