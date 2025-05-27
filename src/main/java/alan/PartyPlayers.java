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
        party.add(new PlayableCharacter("Phillo", 10, 35, "Fighter1.png", grid.getCellArray()[4][9], "Human", "Figther"));
        party.add(new PlayableCharacter("Tanith", 10, 35, "Ranger1.png", grid.getCellArray()[7][9],"Hal-Elf","Ranger"));
    }

    public ArrayList<Creature> getParty() {
        return party;
    }

}
