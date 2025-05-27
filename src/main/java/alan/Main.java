package alan;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridLayout;
import java.awt.Insets;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Main {
    public static void main(String[] args) {
        /*
        * Initializes frame and adds panel
        * Implements additional settings for the frame
        */
        

        JFrame frame = new JFrame();
        JPanel mainPanel = new JPanel(new GridLayout(1, 2)); // 1 row, 2 columns
        mainPanel.setBackground(Constants.BLACK);

        // === GridPanel ===
        GridBagConstraints gbcGrid = new GridBagConstraints();
        gbcGrid.insets = new Insets(1, 1, 1, 1);
        gbcGrid.fill = GridBagConstraints.BOTH;
        gbcGrid.weightx = 0.5;
        gbcGrid.weighty = 1.0;
        gbcGrid.gridx = 0;
        gbcGrid.gridy = 0;

        GridPanel gridPanel = new GridPanel();
        gridPanel.setPreferredSize(new Dimension(Constants.FRAME_WIDTH / 2, Constants.FRAME_HEIGHT));
        gridPanel.addKeyListener(gridPanel);
        mainPanel.add(gridPanel, gbcGrid);

        // === GamePanel ===
        GridBagConstraints gbcGame = new GridBagConstraints();
        gbcGame.insets = new Insets(1, 1, 1, 1);
        gbcGame.fill = GridBagConstraints.BOTH;
        gbcGame.weightx = 0.5;
        gbcGame.weighty = 1.0;
        gbcGame.gridx = 1;
        gbcGame.gridy = 0;

        GamePanel gamePanel = new GamePanel();
        gamePanel.setPreferredSize(new Dimension(Constants.FRAME_WIDTH / 2, Constants.FRAME_HEIGHT));
        gamePanel.addKeyListener(gamePanel);
        gamePanel.setCards();
        gamePanel.addCards();
        mainPanel.add(gamePanel, gbcGame);

        // === Final frame setup ===
        frame.add(mainPanel);
        frame.setTitle("Rogue Dungeons");
        frame.setSize(Constants.FRAME_WIDTH, Constants.FRAME_HEIGHT);
        frame.setVisible(true);
        frame.requestFocus();
        gridPanel.requestFocus();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);

        /*
        * Game Loop
        * Updates the frame evey 100 milliseconds
        */
        long startTime = System.currentTimeMillis();
        while(true){
            long elapsedTime = System.currentTimeMillis() - startTime;
            if(elapsedTime > Constants.REFRESH_RATE){
                gridPanel.update();
                gamePanel.update();
                startTime = System.currentTimeMillis();                         // This function must remain at the end of this statement
            }
        }
    }

}