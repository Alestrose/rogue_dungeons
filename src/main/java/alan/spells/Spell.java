package alan.spells;

import alan.Constants.SCHOOL;
import alan.creatures.Creature;
import alan.creatures.PartyPlayers;
import alan.grid_panel.Grid;

public abstract class Spell {
    Grid grid;
    PartyPlayers partyPlayers;
    private String spellName;
    private byte spellLevel;
    private byte duration;
    private short range;
    private boolean reaction;
    private boolean action;
    private boolean bonus;
    private boolean concentration;
    private boolean ritual;
    private SCHOOL school;

    /*
     * Constructor
     */
    public Spell(){
        grid = Grid.getInstance(0, 0);
        partyPlayers = PartyPlayers.getInstance();
    }

    /*
     * Methods
     */
    public void cast(Creature target){

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

    
}
