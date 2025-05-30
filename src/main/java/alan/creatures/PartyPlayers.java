package alan.creatures;

import java.util.ArrayList;

import alan.Constants;
import alan.grid_panel.Grid;
import alan.races.Aasimar;
import alan.races.Dragonborn;
import alan.races.Dwarf;
import alan.races.Elf;
import alan.races.Gnome;
import alan.races.Human;

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
        party.add(new Elf("Phillo","Fighter1.png" , grid.getCellArray()[4][6], Constants.SKILL_KEY.PERCEPTION, Elf.ELVEN_LINEAGE.DROW));
        party.add(new Human("Tanith", "Ranger1.png", grid.getCellArray()[7][9], Constants.SKILL_KEY.HISTORY));
        party.add(new Dwarf("Ti Nee","Fighter1.png" , grid.getCellArray()[1][8]));
        party.add(new Dragonborn("Drago", "Ranger1.png", grid.getCellArray()[9][6], Dragonborn.DRACONIC_ANCESTRY.GREEN));
        party.add(new Aasimar("Asswipe", "Fighter1.png", grid.getCellArray()[0][6]));
        party.add(new Gnome("Gnomey", "Ranger1.png", grid.getCellArray()[4][8], Constants.ABILITY.WISDOM, Gnome.GNOMISH_LINEAGE.ROCK));
    }

    public ArrayList<Creature> getParty() {
        return party;
    }

}
