package alan.creatures;

import alan.grid_panel.Cell;

public class PlayableCharacter extends Creature{
    private boolean hasAdvantage = false;
    

    


    // Without location constructor
    public PlayableCharacter(String name, String fileName) {
        super(name, fileName);
        setClassFeatures();
    }
    
    // With location constructor
    public PlayableCharacter(String name, String fileName, Cell location) {
        super(name, fileName, location);
        setClassFeatures();
    }

    /*
     * Methods
     */

    private  void setClassFeatures(){
        
    }
    
    public void onLongRest(){

    }
    
    public void onShortRest(){
        
    }

    public void onLevelUp(){

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
