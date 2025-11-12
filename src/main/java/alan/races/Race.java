package alan.races;

import alan.Constants;
import alan.grid_panel.Cell;

public abstract class Race  implements RaceInterface{
    final String RACE_NAME;


    // Constructor without cell location
    public Race(String name, String fileName, Constants.CLASS playerClass) {
        RACE_NAME = playerClass.toString().toLowerCase();

    }

    // Constructor with cell location
    public Race(String name, String fileName, Cell location, Constants.CLASS playerClass) {
        RACE_NAME = playerClass.toString().toLowerCase();

    }

    /*
     * Methods
     */

    public void init(){
        setSpecialFeatures();
    }

    @Override
    public void onLevelUpRace() {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void onLongRestRace() {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void onShortRestRace() {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void setSpecialFeatures() {
        // TODO Auto-generated method stub
        
    }
    
    /*
    * Getters and Setters
    */

    public String getRACE_NAME() {
         return RACE_NAME;
    }

}
