package alan.creatures;

public abstract class Race {
    /*
     * String title;
     * List special traits
     * Int Speed
     */

    private enum PlayerRace {HUMAN, ELF, DWARF, ORC, TIEFLING, GNOME, HALFLING, DRAGONBORN, GOLIATH, AASIMAR};
    PlayerRace race;
    private String title, size, creatureType;
    private int speed;

    private boolean dragonAncestry = false;
    private boolean giantAncestry = false;
    private boolean elvenLineage = false;
    private boolean gnomishLineage = false;
    private boolean fiendishLegacy = false;

    public Race(PlayerRace race){
        this.race = race;
        switch (race) {
            case HUMAN:
                title = "Human";
                creatureType = "Humanoid";
                size = "Medium";
                this.speed = 30;
                break;
            case ELF:
                title = "Elf";
                creatureType = "Humanoid";
                size = "Medium";
                speed = 30;
                elvenLineage = true;
                break;
            case DWARF:
                title = "Dwarf";
                creatureType = "Humanoid";
                size = "Medium";
                speed = 30;
                break;
            case ORC:
                title = "Orc";
                creatureType = "Humanoid";
                size = "Medium";
                this.speed = 30;
                break;
            case TIEFLING:
                title = "Tiefling";
                creatureType = "Humanoid";
                size = "Medium";
                this.speed = 30;
                fiendishLegacy = true;
                break;
            case GNOME:
                title = "Gnome";
                creatureType = "Humanoid";
                size = "Small";
                speed = 30;
                gnomishLineage = true;
                break;
            case HALFLING:
                title = "Halfling";
                creatureType = "Humanoid";
                size = "Small";
                speed = 30;
                break;
            case DRAGONBORN:
                title = "Dragonborn";
                creatureType = "Humanoid";
                size = "Medium";
                speed = 30;
                dragonAncestry = true;
                break;
            case GOLIATH:
                title = "Goliath";
                creatureType = "Humanoid";
                size = "Medium";
                speed = 35;
                giantAncestry = true;
                break;
            case AASIMAR:
                title = "Aasimar";
                creatureType = "Humanoid";
                size = "Medium";
                speed = 30;
                break;
            default:
                title = "Human";
                creatureType = "Humanoid";
                size = "Medium";
                this.speed = 30;
                break;
        }
    }
}
