package alan;
import java.awt.Color;

public class Constants {

    // Display Constants
    public final static int REFRESH_RATE = 500;
    public final static int FRAME_WIDTH = 1200;
    public final static int FRAME_HEIGHT = 629;
    public final static Color SKY_BLUE = new Color(174,227,245);
    public final static Color BLACK = new Color(0,0,0);

    // Grid Constants
    public final static int CELL_WIDTH = 50;
    public final static int CELL_HEIGHT = 50;
    public final static int GRID_PANEL_WIDTH = (int)(FRAME_WIDTH/2);
    public final static int GRID_PANEL_HEIGHT = FRAME_HEIGHT;

    // Creature
    public static enum CREATURE_SIZE {TINY, SMALL, MEDIUM, LARGE, HUGE, GARGANTUAN, COLOSSAL};
    public static enum DAMAGE_TYPE {FIRE, ICE, LIGHTNING, POISON, ACID, SLASHING, PIERCING, BLUDGEONING, NECROTIC, RADIANT};

    /*
     * resistances.put("fire", false);
    resistances.put("ice", false);
    resistances.put("lightning", false);
    resistances.put("poison", false);
    resistances.put("acid", false);
    resistances.put("slashing", false);
    resistances.put("piercing", false);
    resistances.put("bludgeoning", false);
    resistances.put("necrotic", false);
    resistances.put("radiant", false);
     */
    
}
