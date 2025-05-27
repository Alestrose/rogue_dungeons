package alan;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Card  extends JPanel implements KeyListener{
    protected  String fileName;
    protected  BufferedImage image;
    


    // Constructor
    public Card(Creature c){
        this.fileName = c.getFileName();

        // Layout Manager
        this.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
            gbc.insets = new Insets(1,1 , 1, 1);
            gbc.fill = GridBagConstraints.BOTH; // Make the components expand
            gbc.weightx = 1.0;
            gbc.weighty = 1.0;


        // Initializes image from images folder. Image selected via fileName
        File pic = new File("images/" + fileName);
        try {
            image = ImageIO.read(pic);
            JLabel label = new JLabel(new ImageIcon(image));
                gbc.gridx = 0;
                gbc.gridy = 0;
                gbc.gridwidth = 2;
                gbc.gridheight = 2;
                gbc.weightx = 1;
                gbc.weighty = 1;
                gbc.fill = GridBagConstraints.BOTH;
            this.add(label);
        } catch (IOException e) {
            System.out.println("file not found");
        }

        // Reset for buttons
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        gbc.weighty = 0; // Don't stretch buttons vertically
        gbc.fill = GridBagConstraints.HORIZONTAL;

        JButton action = new JButton("Action");
            gbc.gridx = 0;
            gbc.gridy = 2;
            this.add(action,gbc);
        JButton bonus = new JButton("Bonus Action");
            gbc.gridx = 1;
            gbc.gridy = 2;
            this.add(bonus,gbc);
        JButton move = new JButton("Move");
            gbc.gridx = 2;
            gbc.gridy = 2;

            this.add(move,gbc);
    }




    @Override
    public void keyPressed(KeyEvent e) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void keyReleased(KeyEvent e) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void keyTyped(KeyEvent e) {
        // TODO Auto-generated method stub
        
    }
    
}
