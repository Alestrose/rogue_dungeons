package alan.game_panel;

import java.awt.Color;
import java.awt.Dimension;
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

import alan.Constants;
import alan.creatures.Creature;

public class Card extends JPanel implements KeyListener {
    protected String fileName;
    protected BufferedImage image;

    // Constructor
    public Card(Creature c) {
        this.fileName = c.getFileName();

        // Layout Manager
        this.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(1, 1, 1, 1);
        gbc.fill = GridBagConstraints.BOTH;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;

        // Image
        File pic = new File("images/" + fileName);
        try {
            image = ImageIO.read(pic);
            JLabel label = new JLabel(new ImageIcon(image));
            gbc.gridx = 0;
            gbc.gridy = 0;
            gbc.gridwidth = 1;
            gbc.gridheight = 2;
            this.add(label, gbc);
        } catch (IOException e) {
            System.out.println("file not found");
        }

        // Reset gridheight and gridwidth for text fields
        gbc.gridheight = 1;
        gbc.gridwidth = 1;

        // Info labels/text (row 0 and 1, columns 1–5)
        String[] labels = { 
            "Name: " + c.getName(),
            "Race: " + c.getRaceName(),
            "Class: " + c.getPrimaryClass().getClassName(),
            "Level: " + c.getPrimaryClass().getClassLevel(),
            "AC: " + c.getAc(), 
            "Health: " + c.getMaxHealth(),
            "Speed: " + c.getSpeed(), 
            "DC: " + c.getDc()
        };

        for (int i = 0; i < labels.length; i++) {
            gbc.gridx = (i % 5) + 1; // Columns 1 to 5
            gbc.gridy = i < 5 ? 0 : 1; // First 5 on row 0, last on row 1
            JLabel label = new JLabel(labels[i]);
            label.setForeground(Color.WHITE);
            this.add(label, gbc);
        }

        // Buttons on bottom row (row 2), each spanning 2 columns
        gbc.gridy = 2;
        gbc.gridwidth = 2;
        gbc.weighty = 0;
        gbc.fill = GridBagConstraints.HORIZONTAL;

        JButton action = new JButton("Action");
        gbc.gridx = 0;
        this.add(action, gbc);

        JButton bonus = new JButton("Bonus Action");
        gbc.gridx = 2;
        this.add(bonus, gbc);

        JButton move = new JButton("Move");
        gbc.gridx = 4;
        this.add(move, gbc);

        this.setMaximumSize(new Dimension(Constants.FRAME_WIDTH / 2, Constants.FRAME_HEIGHT / 10));
        this.setBackground(Constants.BLACK);
    }

    @Override
    public void keyPressed(KeyEvent e) {
        // TODO
    }

    @Override
    public void keyReleased(KeyEvent e) {
        // TODO
    }

    @Override
    public void keyTyped(KeyEvent e) {
        // TODO
    }
}
