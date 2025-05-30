package alan.races;

import alan.Constants;
import alan.creatures.PlayableCharacter;
import alan.grid_panel.Cell;

public class Orc extends PlayableCharacter implements RaceInterface{
    final String RACE_NAME = "Orc";
    private Boolean hasRelentlessEndurance = true;

    public Orc(String name, String fileName) {
        super(name, fileName);
        setCreatureType("Humanoid");
        setSpeed(30);
        setSize(Constants.CREATURE_SIZE.MEDIUM);
        setRaceName(RACE_NAME);
        setSpecialFeatures();
    }

    public Orc(String name, String fileName, Cell location) {
        super(name, fileName, location);
        setCreatureType("Humanoid");
        setSpeed(30);
        setSize(Constants.CREATURE_SIZE.MEDIUM);
        setRaceName(RACE_NAME);
        setSpecialFeatures();
    }

    /*
     * Methods
     */
    @Override
    public final void setSpecialFeatures() {
        // Darkvision
        setDarkVision(120);
    }

    @Override
    public void onLevelUpRace(){

    }

    @Override
    public void onShortRestRace() {
        
    }

    @Override
    public void onLongRestRace() {
        setHasRelentlessEndurance(true);

    }

    /*
     * Getters & Setters
     */
    public String getRACE_NAME() {
        return RACE_NAME;
    }

    public Boolean getHasRelentlessEndurance() {
        return hasRelentlessEndurance;
    }

    public void setHasRelentlessEndurance(Boolean hasRelentlessEndurance) {
        this.hasRelentlessEndurance = hasRelentlessEndurance;
    }
}
