package alan;

import java.util.ArrayList;

// Singleton Class
public class PartyPlayers {
    Grid grid = Grid.getInstance(0, 0);
    private static PartyPlayers instance = null;
    @SuppressWarnings("FieldMayBeFinal")
    private ArrayList<PlayableCharacter> party = new ArrayList<>();
    private PartyPlayers(){
        
    }

    public static PartyPlayers getInstance(){
        if(instance == null){
            instance = new PartyPlayers();
        }return instance;
    }

    public void addPlayers(){
        party.add(new PlayableCharacter("Fighter", 10, 35, "Fighter1.png", grid.getCellArray()[4][9]));
        party.add(new PlayableCharacter("Ranger", 10, 35, "Ranger1.png", grid.getCellArray()[7][9]));
    }

    public ArrayList<PlayableCharacter> getParty() {
        return party;
    }

}
