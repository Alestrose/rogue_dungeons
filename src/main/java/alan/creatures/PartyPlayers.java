package alan.creatures;

import java.util.ArrayList;

import alan.Constants;
import alan.grid_panel.Grid;
import alan.player_class.Barbarian;
import alan.player_class.Bard;
import alan.player_class.Cleric;
import alan.player_class.Druid;
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
        party.add(new Elf(
            "Phillo",
            "Fighter1.png",
            grid.getCellArray()[4][11],
            new Barbarian(Constants.CLASS.BARBARIAN),
            Constants.SKILL_KEY.PERCEPTION, Elf.ELVEN_LINEAGE.DROW
        ));

        party.add(new Human(
            "Tanith", 
            "Ranger1.png", 
            grid.getCellArray()[2][17], 
            new Bard(Constants.CLASS.BARD), 
            Constants.SKILL_KEY.HISTORY
        ));

        party.add(new Dwarf(
            "Ti Nee",
            "Fighter1.png", 
            grid.getCellArray()[3][6], 
            new Cleric(Constants.CLASS.CLERIC, Constants.DIVINE_ORDERS.PROTECTOR)
        ));

        party.add(new Dragonborn(
            "Drago", 
            "Ranger1.png", 
            grid.getCellArray()[1][11], 
            new Druid(Constants.CLASS.DRUID, Constants.PRIMAL_ORDERS.MAGICIAN), 
            Dragonborn.DRACONIC_ANCESTRY.GREEN
        ));

        party.add(new Aasimar(
            "Alan",
            "Fighter1.png", 
            grid.getCellArray()[2][14], 
            new Cleric(Constants.CLASS.CLERIC, Constants.DIVINE_ORDERS.THAUMATURGE)
        ));

        party.add(new Gnome(
            "Gnomey", 
            "Ranger1.png", 
            grid.getCellArray()[2][4], 
            new Druid(Constants.CLASS.DRUID, Constants.PRIMAL_ORDERS.WARDEN), 
            Constants.ABILITY.WISDOM, 
            Gnome.GNOMISH_LINEAGE.ROCK
        ));
    }

    public ArrayList<Creature> getParty() {
        return party;
    }

}
