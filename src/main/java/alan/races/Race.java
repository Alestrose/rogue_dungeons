package alan.races;

public abstract class Race {
    /*
     * String title;
     * List special traits
     * Int Speed
     */

    protected  enum PlayerRace {HUMAN, ELF, DWARF, ORC, TIEFLING, GNOME, HALFLING, DRAGONBORN, GOLIATH, AASIMAR};
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
            case HUMAN -> {
                title = "Human";
                creatureType = "Humanoid";
                size = "Medium";
                this.speed = 30;
            }
            case ELF -> {
                title = "Elf";
                creatureType = "Humanoid";
                size = "Medium";
                speed = 30;
                elvenLineage = true;
            }
            case DWARF -> {
                title = "Dwarf";
                creatureType = "Humanoid";
                size = "Medium";
                speed = 30;
            }
            case ORC -> {
                title = "Orc";
                creatureType = "Humanoid";
                size = "Medium";
                this.speed = 30;
            }
            case TIEFLING -> {
                title = "Tiefling";
                creatureType = "Humanoid";
                size = "Medium";
                this.speed = 30;
                fiendishLegacy = true;
            }
            case GNOME -> {
                title = "Gnome";
                creatureType = "Humanoid";
                size = "Small";
                speed = 30;
                gnomishLineage = true;
            }
            case HALFLING -> {
                title = "Halfling";
                creatureType = "Humanoid";
                size = "Small";
                speed = 30;
            }
            case DRAGONBORN -> {
                title = "Dragonborn";
                creatureType = "Humanoid";
                size = "Medium";
                speed = 30;
                dragonAncestry = true;
            }
            case GOLIATH -> {
                title = "Goliath";
                creatureType = "Humanoid";
                size = "Medium";
                speed = 35;
                giantAncestry = true;
            }
            case AASIMAR -> {
                title = "Aasimar";
                creatureType = "Humanoid";
                size = "Medium";
                speed = 30;
            }
            default -> {
                title = "Human";
                creatureType = "Humanoid";
                size = "Medium";
                this.speed = 30;
            }
        }
    }

    /*
     * Getters & Setters
     */

    public PlayerRace getRace() {
        return race;
    }

    public void setRace(PlayerRace race) {
        this.race = race;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getCreatureType() {
        return creatureType;
    }

    public void setCreatureType(String creatureType) {
        this.creatureType = creatureType;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public boolean isDragonAncestry() {
        return dragonAncestry;
    }

    public void setDragonAncestry(boolean dragonAncestry) {
        this.dragonAncestry = dragonAncestry;
    }

    public boolean isGiantAncestry() {
        return giantAncestry;
    }

    public void setGiantAncestry(boolean giantAncestry) {
        this.giantAncestry = giantAncestry;
    }

    public boolean isElvenLineage() {
        return elvenLineage;
    }

    public void setElvenLineage(boolean elvenLineage) {
        this.elvenLineage = elvenLineage;
    }

    public boolean isGnomishLineage() {
        return gnomishLineage;
    }

    public void setGnomishLineage(boolean gnomishLineage) {
        this.gnomishLineage = gnomishLineage;
    }

    public boolean isFiendishLegacy() {
        return fiendishLegacy;
    }

    public void setFiendishLegacy(boolean fiendishLegacy) {
        this.fiendishLegacy = fiendishLegacy;
    }

    

     
}
