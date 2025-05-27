package alan;
import java.awt.Color;

public class Constants {

    // Display Constants
    public final static int REFRESH_RATE = 100;
    public final static int FRAME_WIDTH = 1200;
    public final static int FRAME_HEIGHT = 800;
    public final static Color SKY_BLUE = new Color(174,227,245);
    public final static Color BLACK = new Color(0,0,0);

    // Grid Constants
    public final static int CELL_WIDTH = 50;
    public final static int CELL_HEIGHT = 50;
    public final static int GRID_PANEL_WIDTH = (int)(FRAME_WIDTH/2);
    public final static int GRID_PANEL_HEIGHT = FRAME_HEIGHT;

    // Bucket Constants
    public final static int BASKET_WIDTH = 100;
    public final static int BASKET_HEIGHT = 100;
    public final static int BASKET_X = (FRAME_WIDTH/2)-(BASKET_WIDTH/2);
    public final static int BASKET_Y = (int)(FRAME_HEIGHT*.75)-BASKET_HEIGHT;
    
}
