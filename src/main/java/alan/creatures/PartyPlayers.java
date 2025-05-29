package alan;

import java.util.ArrayList;

// Singleton Class
public class PartyPlayers {
    Grid grid = Grid.getInstance(0, 0);
    private static PartyPlayers instance = null;
    @SuppressWarnings("FieldMayBeFinal")
    private ArrayList<Creature> party = new ArrayList<>();
    private PartyPlayers(){
        
    }

    public static PartyPlayers getInstance(){
        if(instance == null){
            instance = new PartyPlayers();
        }return instance;
    }

    public void addPlayers(){
        party.add(new PlayableCharacter("Phillo", "Fighter1.png", grid.getCellArray()[4][9]));
        party.add(new PlayableCharacter("Tanith", "Ranger1.png", grid.getCellArray()[7][9]));
    }

    public ArrayList<Creature> getParty() {
        return party;
    }

}
