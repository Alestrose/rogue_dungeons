package alan.player_class;

import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import alan.Constants;
import alan.creatures.Creature;
import alan.player_class.class_features.ClassFeatureAbstract;
import alan.spells.SpellAbstract;
import alan.spells.cantrips.*;
import alan.spells.level_one.*;

public class PlayerClass implements PlayerClassInterface{

    private String className;
    private Creature owner;
    private Constants.CLASS playerClass;
    private int classLevel = 1;
    private ArrayList<Constants.ABILITY> primaryAbilities;
    private int hitPointDie;

    private ArrayList<Constants.WEAPON_TRAINING> weaponProficiencies;
    private ArrayList<Constants.ARMOR_TRAINING> armorTraining;

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
    private Map<Constants.CLASS_FEATURE, ClassFeatureAbstract> classFeaturesMap;

    public PlayerClass(Constants.CLASS playerClass){
        this.playerClass = playerClass;

        // Capitalize first letter of class name
        String s = playerClass.name().toLowerCase().replace('_', ' ');
        className = s.substring(0, 1).toUpperCase() + s.substring(1);
        
        initNewCharacter();
    }

    /*
     * Methods
     */

    public final void initNewCharacter(){
        if(playerClass == null) return; // guard against NPE

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
    
    }

    @Override
    public void onLevelUp(int lvl) {
        
    }

    @Override
    public void onShortRest(){

    }

    @Override
    public void onLongRest(){
        
    }

    /*
     * Set Classes
     */

    public void setBarbarianClass(){
        
    }

    public void setBardClass(){

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
            druidSpells.put(Constants.SPELL.THORN_WHIP, new ThornWhip_());
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

    }

    public void setMonkClass(){

    }

    public void setPaladinClass(){

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

    }

    public void setSorcererClass(){
        
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
            wizardSpells.put(Constants.SPELL.SHILED, new Shield());
            wizardSpells.put(Constants.SPELL.SLEEP, new Sleep());
            wizardSpells.put(Constants.SPELL.TASHAS_HIDEOUS_LAUGHTER, new TashasHideousLaughter());
            wizardSpells.put(Constants.SPELL.THUNDERWAVE, new Thunderwave());
            wizardSpells.put(Constants.SPELL.WITCH_BOLT, new WitchBolt());
        }
    }

    public void updatePassives(Map<Constants.CLASS_FEATURE, ClassFeatureAbstract> featuresMap){
        for(Map.Entry<Constants.CLASS_FEATURE, ClassFeatureAbstract> entry : featuresMap.entrySet()){
            if(entry.getValue().isActive()) {
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


    public ArrayList<Constants.WEAPON_TRAINING> getWeaponProficiencies() {
        return weaponProficiencies;
    }

    public void setWeaponProficiencies(ArrayList<Constants.WEAPON_TRAINING> weaponProficiencies) {
        this.weaponProficiencies = weaponProficiencies;
    }

    public ArrayList<Constants.ARMOR_TRAINING> getArmorTraining() {
        return armorTraining;
    }

    public void setArmorTraining(ArrayList<Constants.ARMOR_TRAINING> armorTraining) {
        this.armorTraining = armorTraining;
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

    public Map<Constants.CLASS_FEATURE, ClassFeatureAbstract> getClassFeaturesMap() {
        return classFeaturesMap;
    }

    public void setClassFeaturesMap(Map<Constants.CLASS_FEATURE, ClassFeatureAbstract> classFeaturesMap) {
        this.classFeaturesMap = classFeaturesMap;
    }

    public Creature getOwner() {
        return owner;
    }

    public void setOwner(Creature owner) {
        this.owner = owner;
    }
    
    
}
