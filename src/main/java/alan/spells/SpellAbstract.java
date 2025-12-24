package alan.spells;

import java.util.ArrayList;
import java.util.List;

import alan.Constants;
import alan.Constants.DAMAGE_TYPE;
import alan.Constants.SCHOOL;
import alan.creatures.Creature;
import alan.creatures.PartyPlayers;
import alan.grid_panel.Cell;
import alan.grid_panel.Grid;
import alan.interfaces.DiceRoll;


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
    private byte duration;                          // Number of turns the spell is in effect
    private int damageDie;                          // Base die size of primary damage type (4 = 1d4, 6 = 1d6, 8 = 1d8...)
    private int quantityOfDie;                      // Number of dice rolled for primary damage type of spell
    private int quantityOfDieIncrementer;           // Number of additional dice added for each level spell is upcast
    private int secondaryDamageDie;                 // Base die size of secondary damage type (4 = 1d4, 6 = 1d6, 8 = 1d8...)
    private int quantityOfSecondaryDie;             // Number of dice rolled for secondary damage type of spell
    private int quantityOfSecondaryDieIncrementer;  // Number of additional dice for secondary damage type added for each level spell is upcast
    private int multiCastHits;                      // Number of creatures the spell can target
    private int aoeRadius;
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

    /*
     * Methods
     */
    @Override       // Returns damage roll based on damage die and quanity of damage die
    public int rollDamage(int damageDie, int quantityOfDie) {
        int total = 0;
        for (int i = 0; i < quantityOfDie; i++) {
            total += random.nextInt(damageDie) + 1;
        }
        return total;
    }

    @Override
    public int rollWeaponDamage() {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override       // Returns true if target specified ability modifier plus a random d20 is greater than or equal to casters spell save DC
    public void rollSpellSaveCheck(Creature target, Creature caster, Constants.ABILITY savingThrow, Runnable onSuccess, Runnable onFail) {
        boolean success =
            random.nextInt(20) + 1 + target.getAbilities().get(savingThrow).getAbilityMod() // D20 plus relevant saving throw bonus
            >= caster.getSpellSaveDC();                                                     // Against casters spell save DC

        if (success) {
            onSuccess.run();
        }else {
            onFail.run();
        }
    }

    @Override       // run affect if target spell attack bonus plus a random d20 is greater than or equal to targets AC
    public void rollToHitAcMeleeSpellAttack(Creature target, Creature caster, Constants.ABILITY ability, Runnable onFail) {
        boolean success = 
        random.nextInt(20)+1 + caster.getSpellAttackBonus()                     // D20 plus spell attack bonus
        >= target.getArmorClass().getAC();                                      // Against target armor class

        if (!success) onFail.run();
    }

    @Override
    public boolean rollToHitACMellee(Creature target, Creature caster) {
        // TODO Auto-generated method stub
        return random.nextInt(20)+1 + caster.getMelleeAttackRollBonus() >= target.getArmorClass().getAC();
    }

    @Override
    public boolean rollToHitACRanged(Creature target, Creature caster) {
        // TODO Auto-generated method stub
        return random.nextInt(20)+1 + caster.getRangedAttackRollBonus() >= target.getArmorClass().getAC();
    }

    // Returns list of all targets in range of origin cell
    public List<Creature> getAOEList(Cell originCell) {
        int x = originCell.getX();
        int y = originCell.getY();

        int effectDistance = getAoeRadius() / 5;
        List<Creature> targetsInRange = new ArrayList<>();

        for (int dx = -effectDistance; dx <= effectDistance; dx++) {
            for (int dy = -effectDistance; dy <= effectDistance; dy++) {

                int nx = x + dx;
                int ny = y + dy;

                // Bounds check
                if (nx < 0 || ny < 0 ||
                    nx >= grid.getCellArray().length ||
                    ny >= grid.getCellArray()[0].length) {
                    continue;
                }

                Creature occupant = grid.getCellArray()[nx][ny].getOccupant();
                if (occupant != null) {
                    targetsInRange.add(occupant);
                }
            }
        }

        return targetsInRange;
    }

    // Sets quantity of aditional die for primary damage of leveled spell
    public void levelSpellPrimaryDie(int increment, int spellLevel){
        switch (spellLevel) {
            case 2 -> {setQuantityOfDie(getQuantityOfDie() + increment);}
            case 3 -> {setQuantityOfDie(getQuantityOfDie() + (increment * 2));}
            case 4 -> {setQuantityOfDie(getQuantityOfDie() + (increment * 3));}
            case 5 -> {setQuantityOfDie(getQuantityOfDie() + (increment * 4));}
            case 6 -> {setQuantityOfDie(getQuantityOfDie() + (increment * 5));}
            case 7 -> {setQuantityOfDie(getQuantityOfDie() + (increment * 6));}
            case 8 -> {setQuantityOfDie(getQuantityOfDie() + (increment * 7));}
            case 9 -> {setQuantityOfDie(getQuantityOfDie() + (increment * 8));}
            default -> {}
        }
    }
    
    // Sets quantity of aditional die for secondary damage of leveled spell
    public void levelSpellSecondaryDie(int increment, int spellLevel){
        switch (spellLevel) {
            case 2 -> {setQuantityOfSecondaryDie(getQuantityOfSecondaryDie() + increment);}
            case 3 -> {setQuantityOfSecondaryDie(getQuantityOfSecondaryDie() + (increment * 2));}
            case 4 -> {setQuantityOfSecondaryDie(getQuantityOfSecondaryDie() + (increment * 3));}
            case 5 -> {setQuantityOfSecondaryDie(getQuantityOfSecondaryDie() + (increment * 4));}
            case 6 -> {setQuantityOfSecondaryDie(getQuantityOfSecondaryDie() + (increment * 5));}
            case 7 -> {setQuantityOfSecondaryDie(getQuantityOfSecondaryDie() + (increment * 6));}
            case 8 -> {setQuantityOfSecondaryDie(getQuantityOfSecondaryDie() + (increment * 7));}
            case 9 -> {setQuantityOfSecondaryDie(getQuantityOfSecondaryDie() + (increment * 8));}
            default -> {}
        }
    }

    // Sets the quantity of creatures a leveled spell can target
    public void levelMultiCastHits(int increment, int spellLevel){
        switch (spellLevel) {
            case 2 -> {setMultiCastHits(getMultiCastHits() + increment);}
            case 3 -> {setMultiCastHits(getMultiCastHits() + (increment * 2));}
            case 4 -> {setMultiCastHits(getMultiCastHits() + (increment * 3));}
            case 5 -> {setMultiCastHits(getMultiCastHits() + (increment * 4));}
            case 6 -> {setMultiCastHits(getMultiCastHits() + (increment * 5));}
            case 7 -> {setMultiCastHits(getMultiCastHits() + (increment * 6));}
            case 8 -> {setMultiCastHits(getMultiCastHits() + (increment * 7));}
            case 9 -> {setMultiCastHits(getMultiCastHits() + (increment * 8));}
            default -> {}
        }
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

    public int getQuantityOfDieIncrementer() {
        return quantityOfDieIncrementer;
    }

    public void setQuantityOfDieIncrementer(int quantityOfDieIncrementer) {
        this.quantityOfDieIncrementer = quantityOfDieIncrementer;
    }

    public int getQuantityOfSecondaryDie() {
        return quantityOfSecondaryDie;
    }

    public void setQuantityOfSecondaryDie(int quantityOfSecondaryDie) {
        this.quantityOfSecondaryDie = quantityOfSecondaryDie;
    }

    public int getQuantityOfSecondaryDieIncrementer() {
        return quantityOfSecondaryDieIncrementer;
    }

    public void setQuantityOfSecondaryDieIncrementer(int quantityOfSecondaryDieIncrementer) {
        this.quantityOfSecondaryDieIncrementer = quantityOfSecondaryDieIncrementer;
    }

    public int getAoeRadius() {
        return aoeRadius;
    }

    public void setAoeRadius(int aoeRadius) {
        this.aoeRadius = aoeRadius;
    }

    
    
    
    
}
