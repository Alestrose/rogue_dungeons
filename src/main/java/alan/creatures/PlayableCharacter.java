package alan.creatures;

import alan.grid_panel.Cell;

public class PlayableCharacter extends Creature{
    private boolean hasAdvantage = false;
    private Race race;

    // Ability scores
    private int strength, dexterity, constitution, intelligence, wisdom, charisma;
    

    // Without location constructor
    public PlayableCharacter(String name, String fileName, Race race) {
        super(name, fileName);
        this.race = race;
        setRacialFeatures();
        setClassFeatures();
    }
    
    // With location constructor
    public PlayableCharacter(String name, String fileName, Cell location, Race race) {
        super(name, fileName, location);
        this.race = race;
        setRacialFeatures();
        setClassFeatures();

    }

    /*
     * Methods
     */

    private  void setClassFeatures(){

    }

    private void setRacialFeatures(){

    }
    
    public void onLongRest(){

    }
    
    public void onShortRest(){
        
    }

    
    
    /*
     * Getters & Setters
     */
    
    public boolean isHasAdvantage() {
        return hasAdvantage;
    }

    public void setHasAdvantage(boolean hasAdvantage) {
        this.hasAdvantage = hasAdvantage;
    }

}
