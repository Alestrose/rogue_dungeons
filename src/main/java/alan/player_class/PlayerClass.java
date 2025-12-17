package alan.player_class;

import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import alan.Constants;
import alan.creatures.Creature;
import alan.equipment.armor.ChainMail;
import alan.equipment.armor.ChainShirt;
import alan.equipment.armor.LeatherArmor;
import alan.equipment.armor.ShieldArmor;
import alan.equipment.armor.StuddedLeatherArmor;
import alan.equipment.weapons.Dagger;
import alan.equipment.weapons.Flail;
import alan.equipment.weapons.Greataxe;
import alan.equipment.weapons.Greatsword;
import alan.equipment.weapons.Handaxe;
import alan.equipment.weapons.Javelin;
import alan.equipment.weapons.Longbow;
import alan.equipment.weapons.Longsword;
import alan.equipment.weapons.Mace;
import alan.equipment.weapons.Quarterstaff;
import alan.equipment.weapons.Scimitar;
import alan.equipment.weapons.Shortbow;
import alan.equipment.weapons.Shortsword;
import alan.equipment.weapons.Sickle;
import alan.equipment.weapons.Spear;
import alan.features.FeatureAbstract;
import alan.features.class_features.WeaponMastery;
import alan.spells.SpellAbstract;
import alan.spells.cantrips.*;
import alan.spells.level_one.*;

public class PlayerClass implements PlayerClassInterface{

    private int proficiencyBonus;
    private String className;
    private Creature owner;
    private Constants.CLASS playerClass;
    private int classLevel = 1;
    private ArrayList<Constants.ABILITY> primaryAbilities = new ArrayList<>();
    private int hitPointDie;
    private WeaponMastery wm = new WeaponMastery();

    protected BufferedImage classImage;
    protected String classImageFileName;

    // Class spell lists
    private Map<Constants.SPELL, SpellAbstract> bardSpells = new HashMap<>();
    private Map<Constants.SPELL, SpellAbstract> clericSpells = new HashMap<>();
    private Map<Constants.SPELL, SpellAbstract> druidSpells = new HashMap<>();
    private Map<Constants.SPELL, SpellAbstract> paladinSpells = new HashMap<>();
    private Map<Constants.SPELL, SpellAbstract> rangerSpells = new HashMap<>();
    private Map<Constants.SPELL, SpellAbstract> sorcererSpells = new HashMap<>();
    private Map<Constants.SPELL, SpellAbstract> warlockSpells = new HashMap<>();
    private Map<Constants.SPELL, SpellAbstract> wizardSpells = new HashMap<>();

    // Class Feature Lists
    private Map<Constants.FEATURE, FeatureAbstract> Features = new HashMap<>();

    public PlayerClass(Constants.CLASS playerClass){
        this.playerClass = playerClass;

        // Capitalize first letter of class name
        String s = playerClass.name().toLowerCase().replace('_', ' ');
        className = s.substring(0, 1).toUpperCase() + s.substring(1);

    }

    /*
     * Methods
     */

    public final void initNewCharacter(){
        if(playerClass == null) return; // guard against NPE
        proficiencyBonus = owner.getProficiencyBonus();
        owner.grantLanguage(Constants.LANGUAGE.COMMON);
        switch (playerClass) {
            case BARBARIAN  -> {setBarbarianClass();}
            case BARD       -> {setBardClass();}
            case CLERIC     -> {setClericClass();}
            case DRUID      -> {setDruidClass();}
            case FIGHTER    -> {setFighterClass();}
            case MONK       -> {setMonkClass();}
            case PALADIN    -> {setPaladinClass();}
            case RANGER     -> {setRangerlass();}
            case ROGUE      -> {setRogueClass();}
            case SORCERER   -> {setSorcererClass();}
            case WARLOCK    -> {setWarlockClass();}
            case WIZARD     -> {setWizardClass();}
            default         -> {}
        }
        initNewClass();
    }

    @Override
    public void onLevelUp() {
        setClassLevel(getClassLevel() + 1);
    }

    @Override
    public void onShortRest(){

    }

    @Override
    public void onLongRest(){
        
    }

    @Override
    public void initNewClass(){
        UPDATE_PASSIVES(Features);
    }

    public void addWeaponMastery(Map<Constants.FEATURE, FeatureAbstract> Features, Constants.WEAPON_KEY wk){
        if(Features.containsKey(Constants.FEATURE.WEAPON_MASTERY)){
            wm = (WeaponMastery) Features.get(Constants.FEATURE.WEAPON_MASTERY);
            wm.addMastery(wk);
        } else {
            if(Features.containsKey(Constants.FEATURE.WEAPON_MASTERY)) System.err.println("Max number of masteries known");
            else System.err.println("Character does not have the weapon mastery feat");
        }
    }

    public void grantFeature(Constants.FEATURE key, FeatureAbstract feat){
        Features.put(key, feat);
    }

    /*
     * Set Classes
     */

    public void setBarbarianClass(){
        // Core traits
        primaryAbilities.add(Constants.ABILITY.STRENGTH);
        setHitPointDie(12);
        owner.grantAbilityProficiency(Constants.ABILITY.STRENGTH);
        owner.grantAbilityProficiency(Constants.ABILITY.CONSTITUTION);
        owner.addWeaponProficiency(Constants.WEAPON_PROFICIENCY.MARTIAL);
        owner.addWeaponProficiency(Constants.WEAPON_PROFICIENCY.SIMPLE);
        owner.addArmorProficiency(Constants.ARMOR_PROFICIENCY.LIGHT);
        owner.addArmorProficiency(Constants.ARMOR_PROFICIENCY.MEDIUM);
        owner.addArmorProficiency(Constants.ARMOR_PROFICIENCY.SHIELDS);

        // Ability scores (standard array)
        owner.getAbilities().get(Constants.ABILITY.STRENGTH).setAbilityScore(15);
        owner.getAbilities().get(Constants.ABILITY.DEXTERITY).setAbilityScore(13);
        owner.getAbilities().get(Constants.ABILITY.CONSTITUTION).setAbilityScore(14);
        owner.getAbilities().get(Constants.ABILITY.INTELLIGENCE).setAbilityScore(8);
        owner.getAbilities().get(Constants.ABILITY.WISDOM).setAbilityScore(10);
        owner.getAbilities().get(Constants.ABILITY.CHARISMA).setAbilityScore(12);
        
        // Future choice
        owner.grantSkillProficiency(Constants.SKILL_KEY.ATHLETICS);
        owner.grantSkillProficiency(Constants.SKILL_KEY.SURVIVAL);

        // Starting Equipment
        owner.getEquipment().setMainHand(new Greataxe(owner));
        owner.getEquipment().addToInventory(new Handaxe(owner), 4);
    }

    public void setBardClass(){
        //Core traits
        owner.setSpellCastAbility(Constants.ABILITY.CHARISMA);
        primaryAbilities.add(Constants.ABILITY.CHARISMA);
        setHitPointDie(8);
        owner.grantAbilityProficiency(Constants.ABILITY.DEXTERITY);
        owner.grantAbilityProficiency(Constants.ABILITY.CHARISMA);
        owner.addWeaponProficiency(Constants.WEAPON_PROFICIENCY.SIMPLE);
        owner.addArmorProficiency(Constants.ARMOR_PROFICIENCY.LIGHT);

        // Ability scores (standard array)
        owner.getAbilities().get(Constants.ABILITY.STRENGTH).setAbilityScore(8);
        owner.getAbilities().get(Constants.ABILITY.DEXTERITY).setAbilityScore(14);
        owner.getAbilities().get(Constants.ABILITY.CONSTITUTION).setAbilityScore(10);
        owner.getAbilities().get(Constants.ABILITY.INTELLIGENCE).setAbilityScore(12);
        owner.getAbilities().get(Constants.ABILITY.WISDOM).setAbilityScore(13);
        owner.getAbilities().get(Constants.ABILITY.CHARISMA).setAbilityScore(15);
        
        // Future choice
        owner.grantSkillProficiency(Constants.SKILL_KEY.PERFORMANCE);
        owner.grantSkillProficiency(Constants.SKILL_KEY.DECEPTION);
        owner.grantSkillProficiency(Constants.SKILL_KEY.PERSUASION);

        // Starting Equipment
        owner.getEquipment().setMainHand(new Dagger(owner));
        owner.getEquipment().addToInventory(new Dagger(owner), 1);
        owner.getEquipment().setBody(new LeatherArmor());

        // Adding spells to classes spell map
        {
            bardSpells.put(Constants.SPELL.BLADE_WARD, new BladeWard());
            bardSpells.put(Constants.SPELL.DANCING_LIGHTS, new DancingLights());
            bardSpells.put(Constants.SPELL.FRIENDS, new Friends());
            bardSpells.put(Constants.SPELL.LIGHT, new Light());
            bardSpells.put(Constants.SPELL.MAGE_HAND, new Mending());
            bardSpells.put(Constants.SPELL.MESSAGE, new Message());
            bardSpells.put(Constants.SPELL.MINOR_ILLUSION, new MinorIllusion());
            bardSpells.put(Constants.SPELL.PRESTIDIGITATION, new Prestidigitation());
            bardSpells.put(Constants.SPELL.STARRY_WISP, new StarryWisp());
            bardSpells.put(Constants.SPELL.THUNDERCLAP, new Thunderclap());
            bardSpells.put(Constants.SPELL.TRUE_STRIKE, new TrueStrike());
            bardSpells.put(Constants.SPELL.VICIOUS_MOCKERY, new ViciousMockery());
            bardSpells.put(Constants.SPELL.ANIMAL_FRIENDSHIP, new AnimalFriendship());
            bardSpells.put(Constants.SPELL.BANE, new Bane());
            bardSpells.put(Constants.SPELL.CHARM_PERSON, new CharmPerson());
            bardSpells.put(Constants.SPELL.COLOR_SPRAY, new ColorSpray());
            bardSpells.put(Constants.SPELL.COMMAND, new Command());
            bardSpells.put(Constants.SPELL.COMPREHEND_LANGUAGES, new ComprehendLanguages());
            bardSpells.put(Constants.SPELL.CURE_WOUNDS, new CureWounds());
            bardSpells.put(Constants.SPELL.DETECT_MAGIC, new DetectMagic());
            bardSpells.put(Constants.SPELL.DISGUISE_SELF, new DisguiseSelf());
            bardSpells.put(Constants.SPELL.DISSONANT_WHISPERS, new DissonantWhispers());
            bardSpells.put(Constants.SPELL.FAERIE_FIRE, new FaerieFire());
            bardSpells.put(Constants.SPELL.FEATHER_FALL, new FeatherFall());
            bardSpells.put(Constants.SPELL.HEALING_WORD, new HealingWord());
            bardSpells.put(Constants.SPELL.HEROISM, new Heroism());
            bardSpells.put(Constants.SPELL.IDENTIFY, new Identify());
            bardSpells.put(Constants.SPELL.LONGSTRIDER, new Longstrider());
            bardSpells.put(Constants.SPELL.SLEEP, new Sleep());
            bardSpells.put(Constants.SPELL.SPEAK_WITH_ANIMALS, new SpeakWithAnimals());
            bardSpells.put(Constants.SPELL.TASHAS_HIDEOUS_LAUGHTER, new TashasHideousLaughter());
            bardSpells.put(Constants.SPELL.THUNDERWAVE, new Thunderwave());
        }
    }

    public void setClericClass(){
        //Core traits
        owner.setSpellCastAbility(Constants.ABILITY.WISDOM);
        primaryAbilities.add(Constants.ABILITY.WISDOM);
        setHitPointDie(8);
        owner.grantAbilityProficiency(Constants.ABILITY.WISDOM);
        owner.grantAbilityProficiency(Constants.ABILITY.CHARISMA);
        owner.addWeaponProficiency(Constants.WEAPON_PROFICIENCY.SIMPLE);
        owner.addArmorProficiency(Constants.ARMOR_PROFICIENCY.LIGHT);
        owner.addArmorProficiency(Constants.ARMOR_PROFICIENCY.MEDIUM);
        owner.addArmorProficiency(Constants.ARMOR_PROFICIENCY.SHIELDS);

        // Ability scores (standard array)
        owner.getAbilities().get(Constants.ABILITY.STRENGTH).setAbilityScore(13);
        owner.getAbilities().get(Constants.ABILITY.DEXTERITY).setAbilityScore(12);
        owner.getAbilities().get(Constants.ABILITY.CONSTITUTION).setAbilityScore(14);
        owner.getAbilities().get(Constants.ABILITY.INTELLIGENCE).setAbilityScore(10);
        owner.getAbilities().get(Constants.ABILITY.WISDOM).setAbilityScore(15);
        owner.getAbilities().get(Constants.ABILITY.CHARISMA).setAbilityScore(8);
        
        // Future choice
        owner.grantSkillProficiency(Constants.SKILL_KEY.ATHLETICS);
        owner.grantSkillProficiency(Constants.SKILL_KEY.SURVIVAL);

        // Starting Equipment
        owner.getEquipment().setMainHand(new Mace(owner));
        owner.getEquipment().setOffHand(new ShieldArmor());
        owner.getEquipment().setBody(new ChainShirt());
        
        // Adding spells to classes spell map
        {
            clericSpells.put(Constants.SPELL.GUIDANCE, new Guidance());
            clericSpells.put(Constants.SPELL.LIGHT, new Light());
            clericSpells.put(Constants.SPELL.MENDING, new Mending());
            clericSpells.put(Constants.SPELL.RESISTANCE, new Resistance());
            clericSpells.put(Constants.SPELL.SACRED_FLAME, new SacredFlame());
            clericSpells.put(Constants.SPELL.SPARE_THE_DYING, new SpareTheDying());
            clericSpells.put(Constants.SPELL.THAUMATURGY, new Thaumaturgy());
            clericSpells.put(Constants.SPELL.TOLL_THE_DEAD, new TollTheDead());
            clericSpells.put(Constants.SPELL.WORD_OF_RADIANCE, new WordOfRadiance());
            clericSpells.put(Constants.SPELL.BANE, new Bane());
            clericSpells.put(Constants.SPELL.BLESS, new Bless());
            clericSpells.put(Constants.SPELL.COMMAND, new Command());
            clericSpells.put(Constants.SPELL.CREATE_OR_DESTROY_WATER, new CreateOrDestroyWater());
            clericSpells.put(Constants.SPELL.CURE_WOUNDS, new CureWounds());
            clericSpells.put(Constants.SPELL.DETECT_EVIL_AND_GOOD, new DetectEvilAndGood());
            clericSpells.put(Constants.SPELL.DETECT_MAGIC, new DetectMagic());
            clericSpells.put(Constants.SPELL.DETECT_POISON_AND_DISEASE, new DetectPoisonAndDisease());
            clericSpells.put(Constants.SPELL.GUIDING_BOLT, new GuidingBolt());
            clericSpells.put(Constants.SPELL.HEALING_WORD, new HealingWord());
            clericSpells.put(Constants.SPELL.INFLICT_WOUNDS, new InflictWounds());
            clericSpells.put(Constants.SPELL.PROTECTION_FROM_EVIL_AND_GOOD, new ProtectionFromEvilAndGood());
            clericSpells.put(Constants.SPELL.SANCTUARY, new Sanctuary());
            clericSpells.put(Constants.SPELL.SHILED_OF_FAITH, new ShieldOfFaith());
        }
    }

    public void setDruidClass(){
        //Core traits
        owner.setSpellCastAbility(Constants.ABILITY.WISDOM);
        primaryAbilities.add(Constants.ABILITY.WISDOM);
        setHitPointDie(8);
        owner.grantAbilityProficiency(Constants.ABILITY.WISDOM);
        owner.grantAbilityProficiency(Constants.ABILITY.INTELLIGENCE);
        owner.addWeaponProficiency(Constants.WEAPON_PROFICIENCY.SIMPLE);
        owner.addArmorProficiency(Constants.ARMOR_PROFICIENCY.LIGHT);
        owner.addArmorProficiency(Constants.ARMOR_PROFICIENCY.SHIELDS);
        owner.grantLanguage(Constants.LANGUAGE.COMMON);
        owner.grantLanguage(Constants.LANGUAGE.DRUIDIC);

        // Ability scores (standard array)
        owner.getAbilities().get(Constants.ABILITY.STRENGTH).setAbilityScore(12);
        owner.getAbilities().get(Constants.ABILITY.DEXTERITY).setAbilityScore(8);
        owner.getAbilities().get(Constants.ABILITY.CONSTITUTION).setAbilityScore(14);
        owner.getAbilities().get(Constants.ABILITY.INTELLIGENCE).setAbilityScore(13);
        owner.getAbilities().get(Constants.ABILITY.WISDOM).setAbilityScore(15);
        owner.getAbilities().get(Constants.ABILITY.CHARISMA).setAbilityScore(10);

        // Future choice
        owner.grantSkillProficiency(Constants.SKILL_KEY.ANIMAL_HANDLING);
        owner.grantSkillProficiency(Constants.SKILL_KEY.NATURE);

        // Starting Equipment
        owner.getEquipment().setMainHand(new Sickle(owner));
        owner.getEquipment().setOffHand(new ShieldArmor());
        owner.getEquipment().setBody(new LeatherArmor());

        // Adding spells to classes spell map
        {
            druidSpells.put(Constants.SPELL.DRUID_CRAFT, new DruidCraft());
            druidSpells.put(Constants.SPELL.ELEMENTALISM, new Elementalism());
            druidSpells.put(Constants.SPELL.GUIDANCE, new Guidance());
            druidSpells.put(Constants.SPELL.MENDING, new Mending());
            druidSpells.put(Constants.SPELL.MESSAGE, new Message());
            druidSpells.put(Constants.SPELL.POISON_SPRAY, new PoisonSpray());
            druidSpells.put(Constants.SPELL.PRODUCE_FLAME, new ProduceFlame());
            druidSpells.put(Constants.SPELL.RESISTANCE, new Resistance());
            druidSpells.put(Constants.SPELL.SHILLELAGH, new Shillelagh());
            druidSpells.put(Constants.SPELL.SPARE_THE_DYING, new SpareTheDying());
            druidSpells.put(Constants.SPELL.STARRY_WISP, new StarryWisp());
            druidSpells.put(Constants.SPELL.THORN_WHIP, new ThornWhip());
            druidSpells.put(Constants.SPELL.THUNDERCLAP, new Thunderclap());
            druidSpells.put(Constants.SPELL.ANIMAL_FRIENDSHIP, new AnimalFriendship());
            druidSpells.put(Constants.SPELL.CHARM_PERSON, new CharmPerson());
            druidSpells.put(Constants.SPELL.CREATE_OR_DESTROY_WATER, new CreateOrDestroyWater());
            druidSpells.put(Constants.SPELL.CURE_WOUNDS, new CureWounds());
            druidSpells.put(Constants.SPELL.DETECT_MAGIC, new DetectMagic());
            druidSpells.put(Constants.SPELL.DETECT_POISON_AND_DISEASE, new DetectPoisonAndDisease());
            druidSpells.put(Constants.SPELL.ENTANGLE, new Entangle());
            druidSpells.put(Constants.SPELL.FAERIE_FIRE, new FaerieFire());
            druidSpells.put(Constants.SPELL.FOG_CLOUD, new FogCloud());
            druidSpells.put(Constants.SPELL.GOODBERRY, new Goodberry());
            druidSpells.put(Constants.SPELL.HEALING_WORD, new HealingWord());
            druidSpells.put(Constants.SPELL.ICE_KNIFE, new IceKnife());
            druidSpells.put(Constants.SPELL.JUMP, new Jump());
            druidSpells.put(Constants.SPELL.LONGSTRIDER, new Longstrider());
            druidSpells.put(Constants.SPELL.PROTECTION_FROM_EVIL_AND_GOOD, new ProtectionFromEvilAndGood());
            druidSpells.put(Constants.SPELL.SPEAK_WITH_ANIMALS, new SpeakWithAnimals());
            druidSpells.put(Constants.SPELL.THUNDERWAVE, new Thunderwave());
        }
    }

    public void setFighterClass(){
        //Core traits
        primaryAbilities.add(Constants.ABILITY.STRENGTH);
        setHitPointDie(10);
        owner.grantAbilityProficiency(Constants.ABILITY.STRENGTH);
        owner.grantAbilityProficiency(Constants.ABILITY.CONSTITUTION);
        owner.addWeaponProficiency(Constants.WEAPON_PROFICIENCY.SIMPLE);
        owner.addWeaponProficiency(Constants.WEAPON_PROFICIENCY.MARTIAL);
        owner.addArmorProficiency(Constants.ARMOR_PROFICIENCY.LIGHT);
        owner.addArmorProficiency(Constants.ARMOR_PROFICIENCY.MEDIUM);
        owner.addArmorProficiency(Constants.ARMOR_PROFICIENCY.HEAVY);
        owner.addArmorProficiency(Constants.ARMOR_PROFICIENCY.SHIELDS);
        owner.grantLanguage(Constants.LANGUAGE.COMMON);


        // Ability scores (standard array)
        owner.getAbilities().get(Constants.ABILITY.STRENGTH).setAbilityScore(15);
        owner.getAbilities().get(Constants.ABILITY.DEXTERITY).setAbilityScore(13);
        owner.getAbilities().get(Constants.ABILITY.CONSTITUTION).setAbilityScore(14);
        owner.getAbilities().get(Constants.ABILITY.INTELLIGENCE).setAbilityScore(10);
        owner.getAbilities().get(Constants.ABILITY.WISDOM).setAbilityScore(8);
        owner.getAbilities().get(Constants.ABILITY.CHARISMA).setAbilityScore(12);

        // Future choice
        owner.grantSkillProficiency(Constants.SKILL_KEY.ACROBATICS);
        owner.grantSkillProficiency(Constants.SKILL_KEY.ATHLETICS);

        // Starting Equipment
        owner.getEquipment().setMainHand(new Greatsword(owner));
        owner.getEquipment().addToInventory(new Flail(owner), 1);
        owner.getEquipment().addToInventory(new Javelin(owner), 8);
        owner.getEquipment().setBody(new ChainMail());
    }

    public void setMonkClass(){
        //Core traits
        primaryAbilities.add(Constants.ABILITY.DEXTERITY);
        primaryAbilities.add(Constants.ABILITY.WISDOM);
        setHitPointDie(8);
        owner.grantAbilityProficiency(Constants.ABILITY.STRENGTH);
        owner.grantAbilityProficiency(Constants.ABILITY.DEXTERITY);
        owner.addWeaponProficiency(Constants.WEAPON_PROFICIENCY.SIMPLE);
        owner.addWeaponProficiency(Constants.WEAPON_PROFICIENCY.MARTIAL);

        // Ability scores (standard array)
        owner.getAbilities().get(Constants.ABILITY.STRENGTH).setAbilityScore(10);
        owner.getAbilities().get(Constants.ABILITY.DEXTERITY).setAbilityScore(15);
        owner.getAbilities().get(Constants.ABILITY.CONSTITUTION).setAbilityScore(13);
        owner.getAbilities().get(Constants.ABILITY.INTELLIGENCE).setAbilityScore(8);
        owner.getAbilities().get(Constants.ABILITY.WISDOM).setAbilityScore(14);
        owner.getAbilities().get(Constants.ABILITY.CHARISMA).setAbilityScore(12);

        // Future choice
        owner.grantSkillProficiency(Constants.SKILL_KEY.ACROBATICS);
        owner.grantSkillProficiency(Constants.SKILL_KEY.INSIGHT);

        // Starting Equipment
        owner.getEquipment().setMainHand(new Spear(owner));
        owner.getEquipment().addToInventory(new Dagger(owner), 5);
    }

    public void setPaladinClass(){
        //Core traits
        owner.setSpellCastAbility(Constants.ABILITY.CHARISMA);
        primaryAbilities.add(Constants.ABILITY.STRENGTH);
        primaryAbilities.add(Constants.ABILITY.CHARISMA);
        setHitPointDie(10);
        owner.grantAbilityProficiency(Constants.ABILITY.WISDOM);
        owner.grantAbilityProficiency(Constants.ABILITY.CHARISMA);
        owner.addWeaponProficiency(Constants.WEAPON_PROFICIENCY.SIMPLE);
        owner.addWeaponProficiency(Constants.WEAPON_PROFICIENCY.MARTIAL);
        owner.addArmorProficiency(Constants.ARMOR_PROFICIENCY.LIGHT);
        owner.addArmorProficiency(Constants.ARMOR_PROFICIENCY.MEDIUM);
        owner.addArmorProficiency(Constants.ARMOR_PROFICIENCY.HEAVY);
        owner.addArmorProficiency(Constants.ARMOR_PROFICIENCY.SHIELDS);

        // Ability scores (standard array)
        owner.getAbilities().get(Constants.ABILITY.STRENGTH).setAbilityScore(15);
        owner.getAbilities().get(Constants.ABILITY.DEXTERITY).setAbilityScore(13);
        owner.getAbilities().get(Constants.ABILITY.CONSTITUTION).setAbilityScore(10);
        owner.getAbilities().get(Constants.ABILITY.INTELLIGENCE).setAbilityScore(8);
        owner.getAbilities().get(Constants.ABILITY.WISDOM).setAbilityScore(12);
        owner.getAbilities().get(Constants.ABILITY.CHARISMA).setAbilityScore(14);

        // Future choice
        owner.grantSkillProficiency(Constants.SKILL_KEY.INSIGHT);
        owner.grantSkillProficiency(Constants.SKILL_KEY.MEDICINE);

        // Starting Equipment
        owner.getEquipment().setMainHand(new Longsword(owner));
        owner.getEquipment().setOffHand(new ShieldArmor());
        owner.getEquipment().addToInventory(new Javelin(owner), 6);
        owner.getEquipment().setBody(new ChainMail());

        // Adding spells to classes spell map
        {
            paladinSpells.put(Constants.SPELL.BLESS, new Bless());
            paladinSpells.put(Constants.SPELL.COMMAND, new Command());
            paladinSpells.put(Constants.SPELL.COMPELLED_DUEL, new CompelledDuel());
            paladinSpells.put(Constants.SPELL.CURE_WOUNDS, new CureWounds());
            paladinSpells.put(Constants.SPELL.DETECT_EVIL_AND_GOOD, new DetectEvilAndGood());
            paladinSpells.put(Constants.SPELL.DETECT_MAGIC, new DetectMagic());
            paladinSpells.put(Constants.SPELL.DETECT_POISON_AND_DISEASE, new DetectPoisonAndDisease());
            paladinSpells.put(Constants.SPELL.DIVINE_FAVOR, new DivineFavor());
            paladinSpells.put(Constants.SPELL.DIVINE_SMITE, new DivineSmite());
            paladinSpells.put(Constants.SPELL.HEROISM, new Heroism());
            paladinSpells.put(Constants.SPELL.PROTECTION_FROM_EVIL_AND_GOOD, new ProtectionFromEvilAndGood());
            paladinSpells.put(Constants.SPELL.SEARING_SMITE, new SearingSmite());
            paladinSpells.put(Constants.SPELL.SHILED_OF_FAITH, new ShieldOfFaith());
            paladinSpells.put(Constants.SPELL.THUNDEROUS_SMITE, new ThunderousSmite());
            paladinSpells.put(Constants.SPELL.WRATHFUL_SMITE, new WrathfulSmite());
        }
    }

    public void setRangerlass(){
        //Core traits
        owner.setSpellCastAbility(Constants.ABILITY.WISDOM);
        primaryAbilities.add(Constants.ABILITY.DEXTERITY);
        primaryAbilities.add(Constants.ABILITY.WISDOM);
        setHitPointDie(10);
        owner.grantAbilityProficiency(Constants.ABILITY.STRENGTH);
        owner.grantAbilityProficiency(Constants.ABILITY.DEXTERITY);
        owner.addWeaponProficiency(Constants.WEAPON_PROFICIENCY.SIMPLE);
        owner.addWeaponProficiency(Constants.WEAPON_PROFICIENCY.MARTIAL);
        owner.addArmorProficiency(Constants.ARMOR_PROFICIENCY.LIGHT);
        owner.addArmorProficiency(Constants.ARMOR_PROFICIENCY.MEDIUM);
        owner.addArmorProficiency(Constants.ARMOR_PROFICIENCY.SHIELDS);

        // Ability scores (standard array)
        owner.getAbilities().get(Constants.ABILITY.STRENGTH).setAbilityScore(8);
        owner.getAbilities().get(Constants.ABILITY.DEXTERITY).setAbilityScore(15);
        owner.getAbilities().get(Constants.ABILITY.CONSTITUTION).setAbilityScore(13);
        owner.getAbilities().get(Constants.ABILITY.INTELLIGENCE).setAbilityScore(10);
        owner.getAbilities().get(Constants.ABILITY.WISDOM).setAbilityScore(14);
        owner.getAbilities().get(Constants.ABILITY.CHARISMA).setAbilityScore(12);

        // Future choice
        owner.grantSkillProficiency(Constants.SKILL_KEY.ANIMAL_HANDLING);
        owner.grantSkillProficiency(Constants.SKILL_KEY.NATURE);
        owner.grantSkillProficiency(Constants.SKILL_KEY.SURVIVAL);

        // Starting Equipment
        owner.getEquipment().setMainHand(new Longbow(owner));
        owner.getEquipment().addToInventory(new Shortbow(owner), 1);
        owner.getEquipment().addToInventory(new Scimitar(owner), 1);
        owner.getEquipment().setBody(new StuddedLeatherArmor());

        // Adding spells to classes spell map
        {
            rangerSpells.put(Constants.SPELL.ALARM, new Alarm());
            rangerSpells.put(Constants.SPELL.ANIMAL_FRIENDSHIP, new AnimalFriendship());
            rangerSpells.put(Constants.SPELL.CURE_WOUNDS, new CureWounds());
            rangerSpells.put(Constants.SPELL.DETECT_MAGIC, new DetectMagic());
            rangerSpells.put(Constants.SPELL.DETECT_POISON_AND_DISEASE, new DetectPoisonAndDisease());
            rangerSpells.put(Constants.SPELL.ENSNARING_STRIKE, new EnsnaringStrike());
            rangerSpells.put(Constants.SPELL.ENTANGLE, new Entangle());
            rangerSpells.put(Constants.SPELL.FOG_CLOUD, new FogCloud());
            rangerSpells.put(Constants.SPELL.GOODBERRY, new Goodberry());
            rangerSpells.put(Constants.SPELL.HAIL_OF_THORNS, new HailOfThorns());
            rangerSpells.put(Constants.SPELL.HUNTERS_MARK, new HuntersMark());
            rangerSpells.put(Constants.SPELL.JUMP, new Jump());
            rangerSpells.put(Constants.SPELL.LONGSTRIDER, new Longstrider());
            rangerSpells.put(Constants.SPELL.DIVINE_SMITE, new DivineSmite());
            rangerSpells.put(Constants.SPELL.SPEAK_WITH_ANIMALS, new SpeakWithAnimals());
        }
    }

    public void setRogueClass(){

        //Core traits
        owner.grantLanguage(Constants.LANGUAGE.THIEVES_CANT);
        primaryAbilities.add(Constants.ABILITY.DEXTERITY);
        setHitPointDie(8);
        owner.grantAbilityProficiency(Constants.ABILITY.DEXTERITY);
        owner.grantAbilityProficiency(Constants.ABILITY.INTELLIGENCE);
        owner.addWeaponProficiency(Constants.WEAPON_PROFICIENCY.SIMPLE);
        owner.addWeaponProficiency(Constants.WEAPON_PROFICIENCY.MARTIAL);
        owner.addArmorProficiency(Constants.ARMOR_PROFICIENCY.LIGHT);

        // Ability scores (standard array)
        owner.getAbilities().get(Constants.ABILITY.STRENGTH).setAbilityScore(8);
        owner.getAbilities().get(Constants.ABILITY.DEXTERITY).setAbilityScore(15);
        owner.getAbilities().get(Constants.ABILITY.CONSTITUTION).setAbilityScore(14);
        owner.getAbilities().get(Constants.ABILITY.INTELLIGENCE).setAbilityScore(12);
        owner.getAbilities().get(Constants.ABILITY.WISDOM).setAbilityScore(10);
        owner.getAbilities().get(Constants.ABILITY.CHARISMA).setAbilityScore(13);

        // Future choice
        owner.grantSkillProficiency(Constants.SKILL_KEY.STEALTH);
        owner.grantSkillProficiency(Constants.SKILL_KEY.SLEIGHT_OF_HAND);
        owner.grantSkillProficiency(Constants.SKILL_KEY.ACROBATICS);
        owner.grantSkillProficiency(Constants.SKILL_KEY.DECEPTION);
        owner.grantSkillExpertise(Constants.SKILL_KEY.STEALTH);
        owner.grantSkillExpertise(Constants.SKILL_KEY.SLEIGHT_OF_HAND);

        // Starting Equipment
        owner.getEquipment().setMainHand(new Shortbow(owner));
        owner.getEquipment().addToInventory(new Dagger(owner), 2);
        owner.getEquipment().addToInventory(new Shortsword(owner), 1);
        owner.getEquipment().setBody(new LeatherArmor());

    }

    public void setSorcererClass(){
        //Core traits
        primaryAbilities.add(Constants.ABILITY.CHARISMA);
        setHitPointDie(6);
        owner.grantAbilityProficiency(Constants.ABILITY.CONSTITUTION);
        owner.grantAbilityProficiency(Constants.ABILITY.CHARISMA);
        owner.addWeaponProficiency(Constants.WEAPON_PROFICIENCY.SIMPLE);

        // Ability scores (standard array)
        owner.getAbilities().get(Constants.ABILITY.STRENGTH).setAbilityScore(8);
        owner.getAbilities().get(Constants.ABILITY.DEXTERITY).setAbilityScore(12);
        owner.getAbilities().get(Constants.ABILITY.CONSTITUTION).setAbilityScore(13);
        owner.getAbilities().get(Constants.ABILITY.INTELLIGENCE).setAbilityScore(10);
        owner.getAbilities().get(Constants.ABILITY.WISDOM).setAbilityScore(14);
        owner.getAbilities().get(Constants.ABILITY.CHARISMA).setAbilityScore(15);

        // Future choice
        owner.grantSkillProficiency(Constants.SKILL_KEY.ARCANA);
        owner.grantSkillProficiency(Constants.SKILL_KEY.DECEPTION);

        // Starting Equipment
        owner.getEquipment().setMainHand(new Spear(owner));
        owner.getEquipment().addToInventory(new Dagger(owner), 2);
        
        // Adding spells to classes spell map
        {
            sorcererSpells.put(Constants.SPELL.ACID_SPLASH, new AcidSplash());
            sorcererSpells.put(Constants.SPELL.BLADE_WARD, new BladeWard());
            sorcererSpells.put(Constants.SPELL.CHILL_TOUCH, new ChillTouch());
            sorcererSpells.put(Constants.SPELL.DANCING_LIGHTS, new DancingLights());
            sorcererSpells.put(Constants.SPELL.ELEMENTALISM, new Elementalism());
            sorcererSpells.put(Constants.SPELL.FIRE_BOLT, new FireBolt());
            sorcererSpells.put(Constants.SPELL.FRIENDS, new Friends());
            sorcererSpells.put(Constants.SPELL.LIGHT, new Light());
            sorcererSpells.put(Constants.SPELL.MAGE_HAND, new MageHand());
            sorcererSpells.put(Constants.SPELL.MENDING, new Mending());
            sorcererSpells.put(Constants.SPELL.MESSAGE, new Message());
            sorcererSpells.put(Constants.SPELL.MIND_SLIVER, new MindSliver());
            sorcererSpells.put(Constants.SPELL.MINOR_ILLUSION, new MinorIllusion());
            sorcererSpells.put(Constants.SPELL.POISON_SPRAY, new PoisonSpray());
            sorcererSpells.put(Constants.SPELL.PRESTIDIGITATION, new Prestidigitation());
            sorcererSpells.put(Constants.SPELL.RAY_OF_FROST, new RayOfFrost());
            sorcererSpells.put(Constants.SPELL.SHOCKING_GRASP, new ShockingGrasp());
            sorcererSpells.put(Constants.SPELL.SORCEROUS_BLAST, new SorcerousBurst());
            sorcererSpells.put(Constants.SPELL.THUNDERCLAP, new Thunderclap());
            sorcererSpells.put(Constants.SPELL.TRUE_STRIKE, new TrueStrike());
        }
    }

    public void setWarlockClass(){
        //Core traits
        primaryAbilities.add(Constants.ABILITY.CHARISMA);
        setHitPointDie(8);
        owner.grantAbilityProficiency(Constants.ABILITY.WISDOM);
        owner.grantAbilityProficiency(Constants.ABILITY.CHARISMA);
        owner.addWeaponProficiency(Constants.WEAPON_PROFICIENCY.SIMPLE);
        owner.addArmorProficiency(Constants.ARMOR_PROFICIENCY.LIGHT);

        // Ability scores (standard array)
        owner.getAbilities().get(Constants.ABILITY.STRENGTH).setAbilityScore(8);
        owner.getAbilities().get(Constants.ABILITY.DEXTERITY).setAbilityScore(14);
        owner.getAbilities().get(Constants.ABILITY.CONSTITUTION).setAbilityScore(12);
        owner.getAbilities().get(Constants.ABILITY.INTELLIGENCE).setAbilityScore(10);
        owner.getAbilities().get(Constants.ABILITY.WISDOM).setAbilityScore(13);
        owner.getAbilities().get(Constants.ABILITY.CHARISMA).setAbilityScore(15);

        // Future choice
        owner.grantSkillProficiency(Constants.SKILL_KEY.INVESTIGATION);
        owner.grantSkillProficiency(Constants.SKILL_KEY.INTIMIDATION);

        // Starting Equipment
        owner.getEquipment().setMainHand(new Sickle(owner));
        owner.getEquipment().addToInventory(new Dagger(owner), 2);
        owner.getEquipment().setBody(new LeatherArmor());

        // Adding spells to classes spell map
        {
            warlockSpells.put(Constants.SPELL.BLADE_WARD, new BladeWard());
            warlockSpells.put(Constants.SPELL.CHILL_TOUCH, new ChillTouch());
            warlockSpells.put(Constants.SPELL.ELDRITCH_BLAST, new EldritchBlast());
            warlockSpells.put(Constants.SPELL.FRIENDS, new Friends());
            warlockSpells.put(Constants.SPELL.MAGE_HAND, new MageHand());
            warlockSpells.put(Constants.SPELL.MIND_SLIVER, new MindSliver());
            warlockSpells.put(Constants.SPELL.MINOR_ILLUSION, new MinorIllusion());
            warlockSpells.put(Constants.SPELL.POISON_SPRAY, new PoisonSpray());
            warlockSpells.put(Constants.SPELL.PRESTIDIGITATION, new Prestidigitation());
            warlockSpells.put(Constants.SPELL.THUNDERCLAP, new Thunderclap());
            warlockSpells.put(Constants.SPELL.TOLL_THE_DEAD, new TollTheDead());
            warlockSpells.put(Constants.SPELL.TRUE_STRIKE, new TrueStrike());
            warlockSpells.put(Constants.SPELL.ARMOR_OF_AGATHYS, new ArmorOfAgathys());
            warlockSpells.put(Constants.SPELL.ARMS_OF_HADAR, new ArmsOfHadar());
            warlockSpells.put(Constants.SPELL.BANE, new Bane());
            warlockSpells.put(Constants.SPELL.CHARM_PERSON, new CharmPerson());
            warlockSpells.put(Constants.SPELL.COMPREHEND_LANGUAGES, new ComprehendLanguages());
            warlockSpells.put(Constants.SPELL.DETECT_MAGIC, new DetectMagic());
            warlockSpells.put(Constants.SPELL.EXPEDITIOUS_RETREAT, new ExpeditiousRetreat_());
            warlockSpells.put(Constants.SPELL.HELLISH_REBUKE, new HellishRebuke());
            warlockSpells.put(Constants.SPELL.HEX, new Hex());
            warlockSpells.put(Constants.SPELL.PROTECTION_FROM_EVIL_AND_GOOD, new ProtectionFromEvilAndGood());
            warlockSpells.put(Constants.SPELL.SPEAK_WITH_ANIMALS, new SpeakWithAnimals());
            warlockSpells.put(Constants.SPELL.TASHAS_HIDEOUS_LAUGHTER, new TashasHideousLaughter());
            warlockSpells.put(Constants.SPELL.WITCH_BOLT, new WitchBolt());
        }
    }

    public void setWizardClass(){
        //Core traits
        primaryAbilities.add(Constants.ABILITY.INTELLIGENCE);
        setHitPointDie(6);
        owner.grantAbilityProficiency(Constants.ABILITY.INTELLIGENCE);
        owner.grantAbilityProficiency(Constants.ABILITY.WISDOM);
        owner.addWeaponProficiency(Constants.WEAPON_PROFICIENCY.SIMPLE);

        // Ability scores (standard array)
        owner.getAbilities().get(Constants.ABILITY.STRENGTH).setAbilityScore(8);
        owner.getAbilities().get(Constants.ABILITY.DEXTERITY).setAbilityScore(12);
        owner.getAbilities().get(Constants.ABILITY.CONSTITUTION).setAbilityScore(14);
        owner.getAbilities().get(Constants.ABILITY.INTELLIGENCE).setAbilityScore(15);
        owner.getAbilities().get(Constants.ABILITY.WISDOM).setAbilityScore(13);
        owner.getAbilities().get(Constants.ABILITY.CHARISMA).setAbilityScore(10);

        // Future choice
        owner.grantSkillProficiency(Constants.SKILL_KEY.ARCANA);
        owner.grantSkillProficiency(Constants.SKILL_KEY.INSIGHT);

        // Starting Equipment
        owner.getEquipment().setMainHand(new Quarterstaff(owner));
        owner.getEquipment().addToInventory(new Dagger(owner), 2);

        // Adding spells to classes spell map
        {
            wizardSpells.put(Constants.SPELL.ACID_SPLASH, new AcidSplash());
            wizardSpells.put(Constants.SPELL.BLADE_WARD, new BladeWard());
            wizardSpells.put(Constants.SPELL.CHILL_TOUCH, new ChillTouch());
            wizardSpells.put(Constants.SPELL.DANCING_LIGHTS, new DancingLights());
            wizardSpells.put(Constants.SPELL.ELEMENTALISM, new Elementalism());
            wizardSpells.put(Constants.SPELL.FIRE_BOLT, new FireBolt());
            wizardSpells.put(Constants.SPELL.FRIENDS, new Friends());
            wizardSpells.put(Constants.SPELL.LIGHT, new Light());
            wizardSpells.put(Constants.SPELL.MAGE_HAND, new MageHand());
            wizardSpells.put(Constants.SPELL.MENDING, new Mending());
            wizardSpells.put(Constants.SPELL.MESSAGE, new Message());
            wizardSpells.put(Constants.SPELL.MIND_SLIVER, new MindSliver());
            wizardSpells.put(Constants.SPELL.MINOR_ILLUSION, new MinorIllusion());
            wizardSpells.put(Constants.SPELL.POISON_SPRAY, new PoisonSpray());
            wizardSpells.put(Constants.SPELL.PRESTIDIGITATION, new Prestidigitation());
            wizardSpells.put(Constants.SPELL.RAY_OF_FROST, new RayOfFrost());
            wizardSpells.put(Constants.SPELL.SHOCKING_GRASP, new ShockingGrasp());
            wizardSpells.put(Constants.SPELL.THUNDERCLAP, new Thunderclap());
            wizardSpells.put(Constants.SPELL.TOLL_THE_DEAD, new TollTheDead());
            wizardSpells.put(Constants.SPELL.TRUE_STRIKE, new TrueStrike());
            wizardSpells.put(Constants.SPELL.ALARM, new Alarm());
            wizardSpells.put(Constants.SPELL.BURNING_HANDS, new BurningHands());
            wizardSpells.put(Constants.SPELL.CHARM_PERSON, new CharmPerson());
            wizardSpells.put(Constants.SPELL.CHROMATIC_ORB, new ChromaticOrb());
            wizardSpells.put(Constants.SPELL.COLOR_SPRAY, new ColorSpray());
            wizardSpells.put(Constants.SPELL.COMPREHEND_LANGUAGES, new ComprehendLanguages());
            wizardSpells.put(Constants.SPELL.DETECT_MAGIC, new DetectMagic());
            wizardSpells.put(Constants.SPELL.DISGUISE_SELF, new DisguiseSelf());
            wizardSpells.put(Constants.SPELL.EXPEDITIOUS_RETREAT, new ExpeditiousRetreat_());
            wizardSpells.put(Constants.SPELL.FALSE_LIFE, new FalseLife());
            wizardSpells.put(Constants.SPELL.FEATHER_FALL, new FeatherFall());
            wizardSpells.put(Constants.SPELL.FIND_FAMILIAR, new FindFamiliar());
            wizardSpells.put(Constants.SPELL.FOG_CLOUD, new FogCloud());
            wizardSpells.put(Constants.SPELL.GREASE, new Grease());
            wizardSpells.put(Constants.SPELL.ICE_KNIFE, new IceKnife());
            wizardSpells.put(Constants.SPELL.IDENTIFY, new Identify());
            wizardSpells.put(Constants.SPELL.JUMP, new Jump());
            wizardSpells.put(Constants.SPELL.LONGSTRIDER, new Longstrider());
            wizardSpells.put(Constants.SPELL.MAGE_ARMOR, new MageArmor());
            wizardSpells.put(Constants.SPELL.MAGIC_MISSILE, new MagicMissile());
            wizardSpells.put(Constants.SPELL.PROTECTION_FROM_EVIL_AND_GOOD, new ProtectionFromEvilAndGood());
            wizardSpells.put(Constants.SPELL.RAY_OF_FROST, new RayOfFrost());
            wizardSpells.put(Constants.SPELL.SHIELD, new Shield());
            wizardSpells.put(Constants.SPELL.SLEEP, new Sleep());
            wizardSpells.put(Constants.SPELL.TASHAS_HIDEOUS_LAUGHTER, new TashasHideousLaughter());
            wizardSpells.put(Constants.SPELL.THUNDERWAVE, new Thunderwave());
            wizardSpells.put(Constants.SPELL.WITCH_BOLT, new WitchBolt());
        }
    }

    public final void UPDATE_PASSIVES(Map<Constants.FEATURE, FeatureAbstract> Features){
        for(Map.Entry<Constants.FEATURE, FeatureAbstract> entry : Features.entrySet()){
            if(entry.getValue().isPassive()) {
                entry.getValue().cast(getOwner(), null, null, null, null, 1);
            }
        }
    }

    /*
    * Getters and Setters
    */

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public Constants.CLASS getPlayerClass() {
        return playerClass;
    }

    public void setPlayerClass(Constants.CLASS playerClass) {
        this.playerClass = playerClass;
    }

    public int getClassLevel() {
        return classLevel;
    }

    public void setClassLevel(int classLevel) {
        this.classLevel = classLevel;
    }

    public ArrayList<Constants.ABILITY> getPrimaryAbilities() {
        return primaryAbilities;
    }

    public void setPrimaryAbilities(ArrayList<Constants.ABILITY> primaryAbilities) {
        this.primaryAbilities = primaryAbilities;
    }

    public int getHitPointDie() {
        return hitPointDie;
    }

    public void setHitPointDie(int hitPointDie) {
        this.hitPointDie = hitPointDie;
    }

    public BufferedImage getClassImage() {
        return classImage;
    }

    public void setClassImage(BufferedImage classImage) {
        this.classImage = classImage;
    }

    public String getClassImageFileName() {
        return classImageFileName;
    }

    public void setClassImageFileName(String classImageFileName) {
        this.classImageFileName = classImageFileName;
    }

    public Map<Constants.SPELL, SpellAbstract> getBardSpells() {
        return bardSpells;
    }

    public void setBardSpells(Map<Constants.SPELL, SpellAbstract> bardSpells) {
        this.bardSpells = bardSpells;
    }

    public Map<Constants.SPELL, SpellAbstract> getClericSpells() {
        return clericSpells;
    }

    public void setClericSpells(Map<Constants.SPELL, SpellAbstract> clericSpells) {
        this.clericSpells = clericSpells;
    }

    public Map<Constants.SPELL, SpellAbstract> getDruidSpells() {
        return druidSpells;
    }

    public void setDruidSpells(Map<Constants.SPELL, SpellAbstract> druidSpells) {
        this.druidSpells = druidSpells;
    }

    public Map<Constants.SPELL, SpellAbstract> getPaladinSpells() {
        return paladinSpells;
    }

    public void setPaladinSpells(Map<Constants.SPELL, SpellAbstract> paladinSpells) {
        this.paladinSpells = paladinSpells;
    }

    public Map<Constants.SPELL, SpellAbstract> getRangerSpells() {
        return rangerSpells;
    }

    public void setRangerSpells(Map<Constants.SPELL, SpellAbstract> rangerSpells) {
        this.rangerSpells = rangerSpells;
    }

    public Map<Constants.SPELL, SpellAbstract> getSorcererSpells() {
        return sorcererSpells;
    }

    public void setSorcererSpells(Map<Constants.SPELL, SpellAbstract> sorcererSpells) {
        this.sorcererSpells = sorcererSpells;
    }

    public Map<Constants.SPELL, SpellAbstract> getWarlockSpells() {
        return warlockSpells;
    }

    public void setWarlockSpells(Map<Constants.SPELL, SpellAbstract> warlockSpells) {
        this.warlockSpells = warlockSpells;
    }

    public Map<Constants.SPELL, SpellAbstract> getWizardSpells() {
        return wizardSpells;
    }

    public void setWizardSpells(Map<Constants.SPELL, SpellAbstract> wizardSpells) {
        this.wizardSpells = wizardSpells;
    }

    public Creature getOwner() {
        return owner;
    }

    public void setOwner(Creature owner) {
        this.owner = owner;
    }

    public WeaponMastery getWm() {
        return wm;
    }

    public void setWm(WeaponMastery wm) {
        this.wm = wm;
    }

    public Map<Constants.FEATURE, FeatureAbstract> getFeatures() {
        return Features;
    }

    public void setFeatures(Map<Constants.FEATURE, FeatureAbstract> features) {
        Features = features;
    }

    public int getProficiencyBonus() {
        return proficiencyBonus;
    }

    public void setProficiencyBonus(int proficiencyBonus) {
        this.proficiencyBonus = proficiencyBonus;
    }
    
    
    
}
