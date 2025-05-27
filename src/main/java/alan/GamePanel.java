package alan;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.JPanel;
public class GamePanel extends JPanel implements KeyListener{
    private final GameManager gameManager;
    PartyPlayers partyPlayers = PartyPlayers.getInstance();
    @SuppressWarnings("FieldMayBeFinal")
    private ArrayList<Card> playerCards = new ArrayList<>();

    public GamePanel(){
        gameManager = new GameManager();
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setFocusable(true);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g); // <-- CRITICAL: lets Swing paint children (like Card)

        Graphics2D graphics = (Graphics2D) g;
        graphics.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        drawBackground(graphics);
        gameManager.drawSprites(graphics, this);
    }

    // Sets background color, size of screen
    public void drawBackground(Graphics2D graphics){
        graphics.setColor(Constants.SKY_BLUE);
        graphics.fillRect(0, 0, Constants.FRAME_WIDTH, Constants.FRAME_HEIGHT);
    }

    public void update(){
        gameManager.update();
        this.repaint();
    }

    public void setCards(){
        for (Creature i : partyPlayers.getParty()) {
            playerCards.add(new Card(i));
        }
    }

    public void addCards(){
        for (Card c : playerCards) {
            this.add(c);
        }
    }


    @Override
    public void keyTyped(KeyEvent e) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'keyTyped'");
    }

    @Override
    public void keyPressed(KeyEvent e) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'keyPressed'");
    }

    @Override
    public void keyReleased(KeyEvent e) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'keyReleased'");
    }
}
