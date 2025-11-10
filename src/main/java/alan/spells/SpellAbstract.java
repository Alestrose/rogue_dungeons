package alan.spells;

import alan.Constants;
import alan.Constants.DAMAGE_TYPE;
import alan.Constants.SCHOOL;
import alan.creatures.Creature;
import alan.creatures.PartyPlayers;
import alan.grid_panel.Cell;
import alan.grid_panel.Grid;


    // Standard object constructor layout
    /*
     *  setSpellName("Spell Name");
        setSpellLevel((byte) 1);
        setSchool(Constants.SCHOOL.EVOCATION);
        setDamage_type(Constants.DAMAGE_TYPE.FORCE);
        setSavingThrow(Constants.ABILITY.INTELLIGENCE);
        setSpellAttack(true);
        setConcentration(true);
        setAction(true);
        setBonus(true);
        setReaction(true);
        setRange((short) 120);
        setDuration((byte) 0);
        setDamageDie(10);
        setQuantityOfDie(1);
     */
    

public abstract class SpellAbstract implements DiceRoll{
    Grid grid;
    PartyPlayers partyPlayers;
    private String spellName;
    private byte spellLevel;
    private byte duration;
    private int damageDie;
    private int quantityOfDie;
    private int secondaryDamageDie;
    private int quantitySecondaryOfDie;
    private int multiCastHits;
    private short range;
    private boolean reaction = false;
    private boolean action = false;
    private boolean bonus = false;
    private boolean concentration = false;
    private boolean ritual = false;
    private boolean spellAttack = false;
    private boolean spellSave = false;
    private boolean freeCast = false;
    private SCHOOL school;
    private DAMAGE_TYPE damage_type;
    private DAMAGE_TYPE secondary_damage_type;
    private Constants.ABILITY savingThrow;
    private Creature caster;
    private Creature target;
    private Creature[] targetList;
    private Cell cell;

    /*
     * Constructor
     */
    public SpellAbstract(){
        grid = Grid.getInstance(0, 0);
        partyPlayers = PartyPlayers.getInstance();
    }

    @Override
    public int rollDamage(int damageDie, int quantityOfDie) {
        int total = 0;
        for (int i = 0; i < quantityOfDie; i++) {
            total += random.nextInt(damageDie) + 1;
        }
        return total;
    }

    @Override
    public boolean  spellSaveCheck(Creature creature, Creature caster, Constants.ABILITY ability) {
        return random.nextInt(20)+1 + creature.getAbilities().get(ability).getAbilityMod() >= caster.getSpellSaveDC();
    }

    /*
     * Getters & Setters
     */
    public Grid getGrid() {
        return grid;
    }

    public void setGrid(Grid grid) {
        this.grid = grid;
    }

    public PartyPlayers getPartyPlayers() {
        return partyPlayers;
    }

    public void setPartyPlayers(PartyPlayers partyPlayers) {
        this.partyPlayers = partyPlayers;
    }

    public String getSpellName() {
        return spellName;
    }

    public void setSpellName(String spellName) {
        this.spellName = spellName;
    }

    public byte getSpellLevel() {
        return spellLevel;
    }

    public void setSpellLevel(byte spellLevel) {
        this.spellLevel = spellLevel;
    }

    public boolean isReaction() {
        return reaction;
    }

    public void setReaction(boolean reaction) {
        this.reaction = reaction;
    }

    public boolean isAction() {
        return action;
    }

    public void setAction(boolean action) {
        this.action = action;
    }

    public boolean isBonus() {
        return bonus;
    }

    public void setBonus(boolean bonus) {
        this.bonus = bonus;
    }

    public boolean isConcentration() {
        return concentration;
    }

    public void setConcentration(boolean concentration) {
        this.concentration = concentration;
    }

    public boolean isRitual() {
        return ritual;
    }

    public void setRitual(boolean ritual) {
        this.ritual = ritual;
    }

    public byte getDuration() {
        return duration;
    }

    public void setDuration(byte duration) {
        this.duration = duration;
    }

    public short getRange() {
        return range;
    }

    public void setRange(short range) {
        this.range = range;
    }

    public SCHOOL getSchool() {
        return school;
    }

    public void setSchool(SCHOOL school) {
        this.school = school;
    }

    public DAMAGE_TYPE getDamage_type() {
        return damage_type;
    }

    public void setDamage_type(DAMAGE_TYPE damage_type) {
        this.damage_type = damage_type;
    }

    public int getDamageDie() {
        return damageDie;
    }

    public void setDamageDie(int damageDie) {
        this.damageDie = damageDie;
    }

    public int getQuantityOfDie() {
        return quantityOfDie;
    }

    public void setQuantityOfDie(int quantityOfDie) {
        this.quantityOfDie = quantityOfDie;
    }


    public int getMultiCastHits() {
        return multiCastHits;
    }


    public void setMultiCastHits(int multiCastHits) {
        this.multiCastHits = multiCastHits;
    }


    public Creature getCaster() {
        return caster;
    }


    public void setCaster(Creature caster) {
        this.caster = caster;
    }


    public Creature getTarget() {
        return target;
    }


    public void setTarget(Creature target) {
        this.target = target;
    }


    public Creature[] getTargetList() {
        return targetList;
    }


    public void setTargetList(Creature[] targetList) {
        this.targetList = targetList;
    }


    public Cell getCell() {
        return cell;
    }


    public void setCell(Cell cell) {
        this.cell = cell;
    }


    public Constants.ABILITY getSavingThrow() {
        return savingThrow;
    }


    public void setSavingThrow(Constants.ABILITY savingThrow) {
        this.savingThrow = savingThrow;
    }

    public boolean isSpellAttack() {
        return spellAttack;
    }


    public void setSpellAttack(boolean spellAttack) {
        this.spellAttack = spellAttack;
    }


    public boolean isSpellSave() {
        return spellSave;
    }


    public void setSpellSave(boolean spellSave) {
        this.spellSave = spellSave;
    }

    public boolean isFreeCast() {
        return freeCast;
    }

    public void setFreeCast(boolean freeCast) {
        this.freeCast = freeCast;
    }

    public DAMAGE_TYPE getSecondary_damage_type() {
        return secondary_damage_type;
    }

    public void setSecondary_damage_type(DAMAGE_TYPE secondary_damage_type) {
        this.secondary_damage_type = secondary_damage_type;
    }

    public int getSecondaryDamageDie() {
        return secondaryDamageDie;
    }

    public void setSecondaryDamageDie(int secondaryDamageDie) {
        this.secondaryDamageDie = secondaryDamageDie;
    }

    public int getQuantitySecondaryOfDie() {
        return quantitySecondaryOfDie;
    }

    public void setQuantitySecondaryOfDie(int quantitySecondaryOfDie) {
        this.quantitySecondaryOfDie = quantitySecondaryOfDie;
    }
    
    
    
    
}
