package alan.spells;

import alan.Constants.DAMAGE_TYPE;
import alan.Constants.SCHOOL;
import alan.creatures.PartyPlayers;
import alan.grid_panel.Grid;

public abstract class SpellAbstract implements DiceRoll{
    Grid grid;
    PartyPlayers partyPlayers;
    private String spellName;
    private byte spellLevel;
    private byte duration;
    private int damageDie;
    private int quantityOfDie;
    private short range;
    private boolean reaction;
    private boolean action;
    private boolean bonus;
    private boolean concentration;
    private boolean ritual;
    private SCHOOL school;
    private DAMAGE_TYPE damage_type;

    /*
     * Constructor
     */
    public SpellAbstract(){
        grid = Grid.getInstance(0, 0);
        partyPlayers = PartyPlayers.getInstance();
    }
    

    @Override
    public int damageRoll(int damageDie, int quantityOfDie) {
        int total = 0;
        for (int i = 0; i < quantityOfDie; i++) {
            total += random.nextInt(damageDie) + 1;
        }
        return total;
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

    
}
