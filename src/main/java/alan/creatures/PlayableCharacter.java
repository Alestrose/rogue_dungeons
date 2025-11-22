package alan.creatures;

import alan.player_class.PlayerClass;
import alan.grid_panel.Cell;

public class PlayableCharacter extends Creature{
    private boolean hasAdvantage = false;
    
    // Without location constructor
    public PlayableCharacter(String name, String fileName, PlayerClass primaryClass) {
        super(name, fileName, primaryClass);
        
        setClassFeatures();
        initPlayable();

    }
    
    // With location constructor
    public PlayableCharacter(String name, String fileName, Cell location, PlayerClass primaryClass) {
        super(name, fileName, location, primaryClass);

        setClassFeatures();
        initPlayable();
        
    }

    /*
     * Methods
     */

    private void initPlayable(){
        
    }

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
